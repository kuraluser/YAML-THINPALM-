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

import httpx


## load configuration --------------------------------------------------------
with open('config.json', "r") as f_:
   config = json.load(f_)
   

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

class DbList(BaseModel):
    id: str
    log_file: str
    message: dict
    status: str
    timestamp: str

class DbDelete(BaseModel):
    id: str = Field(..., example="Enter the id")

async def get_vessel_details(url):
    try:
        async with httpx.AsyncClient() as client:
            resp_ = await client.get(url)
#            resp_.raise_for_status()
            if resp_.status_code == httpx.codes.OK:
                response_json = resp_.json()
                
    except Exception as err:
        print(f"HTTP Exception: {err}")
        print('>>>> get vessel FILE')
        with open('vessel_info.json') as json_file: 
            response_json = json.load(json_file) 
            
    return response_json


async def post_response(url, payload):
    try:
        async with httpx.AsyncClient() as client:
            resp_ = await client.post(url, json=payload)
            resp_.raise_for_status()
            print(url,resp_)
    except Exception  as err:
        print(f"HTTP Exception: {err}")
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
    
    ## send feedback
    print('>>>> Update feedback to Thinkpalm')
    status_url_ = config['url']['loadable-study-status'].format(vesselId=data['loadable']['vesselId'],
                                                                voyageId=data['loadable']['voyageId'],
                                                                loadableStudyId=data['loadable']['id'])
    # print(status_url_)
    await post_response(status_url_, {"processId" : uid, "loadableStudyStatusId" : 5})
    
    
    if result.get('validated', None) in [None]:
        result_url_ = config['url']['loadable-patterns'].format(vesselId=data['loadable']['vesselId'],
                                                                voyageId=data['loadable']['voyageId'],
                                                                loadableStudyId=data['loadable']['id'])
    else:
        result_url_ = config['url']['validate-patterns'].format(vesselId=data['loadable']['vesselId'],
                                                                voyageId=data['loadable']['voyageId'],
                                                                loadableStudyId=data['loadable']['id'],
                                                                loadablePatternId=data['loadable']['loadablePatternId'])
    print(result_url_)
    await post_response(result_url_, result)
    

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
        # manual mode
        data_['loadable'] = data['loadableStudy']
        data_['loadablePlanPortWiseDetails'] = data['loadablePlanPortWiseDetails']
        
    else:
        data_['loadable'] = data
    
    data_['vessel'] = None
    data_['processId'] = gID
    data_['loadable']['loadablePatternId'] = data.get('loadablePatternId',101)
    # data_['ballastEdited'] = True
    
    print('>>>> get vessel API')
    vessel_url_ = config['url']['vessel-details'].format(vesselId=data_['loadable']['vesselId'])
    # print(vessel_url_)
    data_['vessel'] = await get_vessel_details(vessel_url_)
        
    print('>>>> add new loadable')
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
    out = {'processId': userId['processId'], 'status':None, 'result': None}
    out['status'] = await database.fetch_val(query,column=3)
    out['result'] = await database.fetch_val(query,column=2)
    
    return out

@app.post("/loadicator_results/")
async def loadicator_handler(data: dict):
    
    query = users.select().where(users.c.id == data['processId'])
    # out = {'processId': data['processId'], 'status':None, 'result': None}
    #out['status'] = await database.fetch_val(query,column=3)
    result = await database.fetch_val(query,column=2)
    limits = result['message']['limits']
    out = loadicator(data, limits)
    print('>>>Send loadicator results')
    loadicator_url_ = config['url']['loadable-patterns'].format(vesselId=limits['vesselId'],voyageId=limits['voyageId'],loadableStudyId=limits['id'])
    # print(status_url_)
    await post_response(loadicator_url_, out)
    return out


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