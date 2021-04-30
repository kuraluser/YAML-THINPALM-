# -*- coding: utf-8 -*-
"""
Created on Fri Nov 27 16:33:14 2020

@author: I2R
"""

# import uvicorn
#from typing import Dict, List
import asyncio
from concurrent.futures.process import ProcessPoolExecutor
from http import HTTPStatus
import databases, sqlalchemy, datetime
from fastapi import BackgroundTasks
from uuid import uuid4
from fastapi import FastAPI
from pydantic import BaseModel, Field
from typing import List
import json
from api_vlcc import gen_allocation, loadicator
from vlcc_ullage import get_correction, cal_density
import pickle
import numpy as np
import httpx
from loguru import logger

## load configuration --------------------------------------------------------
with open('config.json', "r") as f_:
   config = json.load(f_)
   
with open('KAZUSA_ullage.pickle', 'rb') as fp_:
    # vessel_info['ullage_func'] = pickle.load(fp_)
    _, ullageCorr, ullageInv, _ = pickle.load(fp_)
   

## Postgres Database --------------------------------------------------------
#DATABASE_URL = "postgresql://postgres:postgres@127.0.0.1:5432/postgres"
DATABASE_URL = config['url']['database']
database = databases.Database(DATABASE_URL)
metadata = sqlalchemy.MetaData()

users = sqlalchemy.Table(
    "pyuser",
    metadata,
    sqlalchemy.Column("id"          ,sqlalchemy.String,primary_key=True),
    sqlalchemy.Column("log_file"    ,sqlalchemy.String),
    sqlalchemy.Column("message"     ,sqlalchemy.JSON),
    sqlalchemy.Column("status"      ,sqlalchemy.String),
    sqlalchemy.Column("timestamp"   ,sqlalchemy.String),
    )

engine = sqlalchemy.create_engine(DATABASE_URL)
metadata.create_all(engine)

app = FastAPI()
logger.add(config['log']['fileName'], rotation=config['log']['rotation'], backtrace=True, diagnose=True)

class DbList(BaseModel):
    id: str
    log_file: str
    message: dict
    status: str
    timestamp: str

class DbDelete(BaseModel):
    id: str = Field(..., example="Enter the id")

async def get_vessel_details(url, gID):
    try:
        async with httpx.AsyncClient() as client:
            resp_ = await client.get(url)
#            resp_.raise_for_status()
            if resp_.status_code == httpx.codes.OK:
                response_json = resp_.json()
                
    except httpx.HTTPError as err:
        # print(f"HTTP Exception: {err}")
        # print('>>>> get vessel FILE')
        logger.info(gID + ": " + f"HTTP Exception - {err}")
        logger.info(gID + ": Get vessel FILE")
        with open('vessel_info.json') as json_file: 
            response_json = json.load(json_file) 
            
    return response_json


async def post_response(url, payload, gID):
    try:
        async with httpx.AsyncClient() as client:
            resp_ = await client.post(url, json=payload)
            resp_.raise_for_status()
            # print(url,resp_)
            # logger.info(gID + ": "+ resp_)
    except httpx.HTTPError  as err:
        # print(f"HTTP Exception: {err}")
        logger.info(gID + ": "+ f"HTTP Exception - {err}")
        pass

async def run_in_process(fn, *args):
    loop = asyncio.get_event_loop()
    return await loop.run_in_executor(app.state.executor, fn, *args)  # wait and return result


async def start_cpu_bound_task(uid: str, data: dict) -> None:
#    print(uid,type(uid))    
    result = await run_in_process(gen_allocation, data)
    gDate = str(datetime.datetime.now())
    query = users.update().\
        where(users.c.id == uid).\
        values(
            message = result,
            status = '5',
            timestamp = gDate
            )
    await database.execute(query)
    
    logger.info(uid + ": Allocation completed")
    ## send feedback
    # print('>>>> Update feedback to Thinkpalm')
    
    
    if result.get('validated', None) in [None]:
        logger.info(uid + ": Update status")
        status_url_ = config['url']['loadable-study-status'].format(vesselId=data['loadable']['vesselId'],
                                                                voyageId=data['loadable']['voyageId'],
                                                                loadableStudyId=data['loadable']['id'])
        # print(status_url_)
        await post_response(status_url_, {"processId" : uid, "loadableStudyStatusId" : 5}, uid)
    
        result_url_ = config['url']['loadable-patterns'].format(vesselId=data['loadable']['vesselId'],
                                                                voyageId=data['loadable']['voyageId'],
                                                                loadableStudyId=data['loadable']['id'])
    else:
        result_url_ = config['url']['validate-patterns'].format(vesselId=data['loadable']['vesselId'],
                                                                voyageId=data['loadable']['voyageId'],
                                                                loadableStudyId=data['loadable']['id'],
                                                                loadablePatternId=data['loadable']['loadablePatternId'])
    print(result_url_)
    logger.info(uid + ": Upload result")
    # print(result)
    await post_response(result_url_, result, uid)
    

@app.post("/new_loadable", status_code=HTTPStatus.ACCEPTED)
async def task_handler(data: dict, background_tasks: BackgroundTasks):
    gID = str(uuid4())
#    data_saved = create_data(user_in)
    gDate = str(datetime.datetime.now())
    query = users.insert().values(
        id = gID,
        log_file = "stowage",
        message = None,
        status = "4",
        timestamp = gDate
        )
    await database.execute(query)
    
    data_ = {}
    
    if data.get('loadableStudy', []):
        # manual/fullManual mode
        # manual mode
        data_['loadable'] = data['loadableStudy']
        data_['loadablePlanPortWiseDetails'] = data['loadablePlanPortWiseDetails']
        data_['caseNumber'] = data.get('caseNumber', None)
        data_['loadable']['loadablePatternId'] = data.get('loadablePatternId',111111)
        
    else:
        data_['loadable'] = data
    
    data_['vessel'] = None
    data_['processId'] = gID
    # data_['ballastEdited'] = True
    
    # print('>>>> get vessel API')
    logger.info(gID + ": Get vessel API")
    vessel_url_ = config['url']['vessel-details'].format(vesselId=data_['loadable']['vesselId'])
    # print(vessel_url_)
    data_['vessel'] = await get_vessel_details(vessel_url_, gID)
        
    # print('>>>> add new loadable')
    logger.info(gID + ": Add new loadable")
    background_tasks.add_task(start_cpu_bound_task, gID, data_)

    ## send feedback
    # print('>>>> send feedback to Thinkpalm')
    # status_url_ = config['url']['loadable-study-status'].format(vesselId=data['vesselId'],voyageId=data['voyageId'],loadableStudyId=data['id'])
    # # print(status_url_)
    # await post_response(status_url_, {"processId" : gID, "loadableStudyStatusId" : 4})
    
    return {'processId': gID,  'status': '4', 'result': None}


@app.get("/status/")
async def status_handler(userId: dict):
    query = users.select().where(users.c.id == userId['processId'])
    # out = {'processId': userId['processId'], 'status':None, 'result': None}
    # out['status'] = await database.fetch_val(query,column=3)
    out = await database.fetch_val(query,column=2)
    
    return out

@app.post("/loadicator_results/")
async def loadicator_handler(data: dict):
    
    query = users.select().where(users.c.id == data['processId'])
    # out = {'processId': data['processId'], 'status':None, 'result': None}
    #out['status'] = await database.fetch_val(query,column=3)
    result = await database.fetch_val(query,column=2)
    
    #print(result['message'])
    limits = result['message']
    out = loadicator(data, limits)
    # # print('>>>Send loadicator results')
    logger.info(data["processId"] + ": Upload loadicator result")
    loadicator_url_ = config['url']['loadicator-result'].format(vesselId=limits['limits']['vesselId'],
                                                                voyageId=limits['limits']['voyageId'],
                                                                loadableStudyId=limits['limits']['id'])
    print(loadicator_url_)
    await post_response(loadicator_url_, out, data["processId"])
    return out

@app.post("/ullage_results/")
async def ullage_handler(data: dict):
           
    tankId = data['tankId']
    cf = get_correction(str(tankId), float(data["rdgUllage"]), float(data["trim"]), ullageCorr)
    if cf not in [None]:
        corr_ullage =  float(data["rdgUllage"]) + cf/100 
        vol = ullageInv[str(tankId)](corr_ullage) 
        density = data.get('sg', None)
        if density in [None,""]:
            density = cal_density(float(data["api"]), float(data["temp"]))
        else:
            density = float(density)
        wt = density*vol 
        
        return {"id":data["id"], "correctionFactor": str(round(cf/100,3)), "correctedUllage": str(round(corr_ullage,3)),
                "obsM3": str(np.round(vol,2)), "quantityMt": str(round(wt,1))}
        
    else:
        return {"id":data["id"], "correctionFactor": None, "correctedUllage": None, "obsM3": None, "quantityMt": None}
    
    

@app.get("/users/{userId}", response_model=DbList)
async def find_user_by_id(userId: str):
    query = users.select().where(users.c.id == userId)
    return await database.fetch_one(query)

@app.delete("/users/{userId}")
async def delete_user(userId: str):
    query = users.delete().where(users.c.id == userId)
    await database.execute(query)
    
    return{
        "status": True,
        "message": "This user has been deleted successfully."
        }



@app.on_event("startup")
async def startup_event():
    app.state.executor = ProcessPoolExecutor()

@app.on_event("shutdown")
async def on_shutdown():
    app.state.executor.shutdown()

@app.on_event("startup")
async def startup():
    await database.connect()
    
@app.on_event("shutdown")
async def shutdown():
    await database.disconnect()
    
@app.get("/db/", response_model=List[DbList])
async def find_all_db_list():
    query = users.select()
    return await database.fetch_all(query)



# if __name__ == '__main__':
#     uvicorn.run(app, host='127.0.0.1', port=8000)
    
# uvicorn main:app --reload --host 0.0.0.0 --port:8000