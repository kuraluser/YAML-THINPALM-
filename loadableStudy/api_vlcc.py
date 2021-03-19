# -*- coding: utf-8 -*-
"""
Created on Sun Dec  6 12:24:27 2020

@author: I2R
"""
import json
#import requests
#from requests.exceptions import HTTPError

from vlcc_init import Process_input
from vlcc_check import Check_plans
from vlcc_rotation import Check_rotations
from vlcc_gen import Generate_plan 
from vlcc_multi_gen import Multiple_plans 

import pickle

def gen_allocation(data):
    out = []
            
    if not data['vessel']:
        return {'message': 'Vessel details not available!!'}
    
    if data.get('loadablePlanPortWiseDetails', []):
        print('Manual Mode -------------------------------------------')
        out = manual_mode(data)
    else:
        print ('Auto Mode --------------------------------------------')
        out = auto_mode(data)
    
    
    return out

def manual_mode(data):
    out = []
    
    # data = get_plan(data)
    
    input_param = Process_input(data)
    input_param.prepare_dat_file()
    input_param.write_dat_file()
    
    # collect plan from AMPL
    gen_output = Generate_plan(input_param)
    gen_output.run(num_plans=1)
    
    ## check and modify plans    
    plan_check = Check_plans(input_param)
    plan_check._check_plans(gen_output.plan.get('ship_status',[]), gen_output.plan.get('cargo_tank',[]))
    
    # gen json  
    out = gen_output.gen_json({}, plan_check.stability_values)
    
    
    return out

# get the loading and ballast operations


def auto_mode(data):
    out = []
    ## process input and gen dat for AMPL
    input_param = Process_input(data)
    input_param.prepare_dat_file()
    input_param.write_dat_file()
    
    input_param.gen_distinct_plan = True
    
    # collect plan from AMPL or ORTOOLS
    outputs = Multiple_plans(data, input_param)
    outputs.run()
    
    ## check and modify plans    
    plan_check = Check_plans(input_param)
    plan_check._check_plans(outputs.plans.get('ship_status',[]), outputs.plans.get('cargo_tank',[]))
    
    with open('result.pickle', 'wb') as handle:
        pickle.dump((data, input_param, outputs.plans), handle, protocol=pickle.HIGHEST_PROTOCOL)
    
    
    # ## check cargo rotation
    cargo_rotate = Check_rotations(data, input_param)
    cargo_rotate._check_plans(outputs.plans)
    
    # # # ## gen json  
    out = outputs.gen_json(cargo_rotate.constraints, plan_check.stability_values)
    # out = outputs.gen_json({str(k_):[] for k_ in range(0,len(outputs.plans.get('ship_status',[])))}, plan_check.stability_values)
    
        
    
    return out
    
def loadicator(data, limits):
    
    out = {"processId": data["processId"], "loadicatorResults":{}}
    
    if type(data.get("loadicatorPatternDetail",None)) is dict:
        
        out["loadicatorResults"]["loadablePatternId"] = data['loadicatorPatternDetail']['loadablePatternId']
        out["loadicatorResults"]['loadicatorResultDetails'] = []
        
        results_ =  data['loadicatorPatternDetail']
        
        for u_, v_ in zip(results_['ldTrim'],results_['ldStrength']):
            assert u_['portId'] == v_['portId']
            info_ = {}
            info_['portId'] = str(u_['portId'])
            info_['synopticalId'] = str(u_['synopticalId'])
            info_['operationId'] = str(limits['limits']['operationId'][str(info_['portId'])])
            info_["calculatedDraftFwdPlanned"] = u_["foreDraftValue"]
            info_["calculatedDraftMidPlanned"] = u_["meanDraftValue"]
            info_["calculatedDraftAftPlanned"] = u_["aftDraftValue"]
            info_["calculatedTrimPlanned"] = u_["trimValue"]
            info_["blindSector"] = None
            info_["list"] = u_["heelValue"]
            info_["deflection"] = None
            
            info_["SF"] = v_["shearingForcePersentValue"]
            info_['BM'] = v_["bendingMomentPersentValue"]
            info_['errorDetails'] = u_["errorDetails"] + v_["errorDetails"]
            
            sag_ = 0.
            mid_ship_draft_ = float(u_["meanDraftValue"]) + sag_
            info_['judgement'] = []
            # max permissible draft
            max_draft_ = max([float(u_["foreDraftValue"]), float(u_["aftDraftValue"]), mid_ship_draft_]) 
            if limits['limits']['draft'][info_['portId']] < max_draft_:
                info_['judgement'].append('Failed max permissible draft check!')
            # loadline 
            if limits['limits']['draft']['loadline'] < max_draft_:
                info_['judgement'].append('Failed loadline check!')
            # airDraft
            
            # SF
            if float(v_["shearingForcePersentValue"]) > 100:
                info_['judgement'].append('Failed SF check!')
            # BM
            if float(v_["bendingMomentPersentValue"]) > 100:
                info_['judgement'].append('Failed BM check!')
                    
            
            out["loadicatorResults"]['loadicatorResultDetails'].append(info_)
            
    elif type(data["loadicatorPatternDetails"]) is list:
        
        out = {"processId": data["processId"], "loadicatorResultsPatternWise":[]}
    
        for p_ in data['loadicatorPatternDetails']:
            out_ = {"loadablePatternId":p_["loadablePatternId"], 'loadicatorResultDetails':[]}
            
            for u_, v_ in zip(p_['ldTrim'],p_['ldStrength']):
                assert u_['portId'] == v_['portId']
                info_ = {}
                info_['portId'] = str(u_['portId'])
                info_['synopticalId'] = str(u_.get('synopticalId',""))
                info_['operationId'] = str(limits['limits']['operationId'][str(info_['portId'])])
                info_["calculatedDraftFwdPlanned"] = u_["foreDraftValue"]
                info_["calculatedDraftMidPlanned"] = u_["meanDraftValue"]
                info_["calculatedDraftAftPlanned"] = u_["aftDraftValue"]
                info_["calculatedTrimPlanned"] = u_["trimValue"]
                info_["blindSector"] = None
                info_["list"] = u_["heelValue"]
                info_["deflection"] = None
                
                info_["SF"] = v_["shearingForcePersentValue"]
                info_['BM'] = v_["bendingMomentPersentValue"]
                info_['errorDetails'] = u_["errorDetails"] + v_["errorDetails"]
                
                sag_ = 0.
                mid_ship_draft_ = float(u_["meanDraftValue"]) + sag_
                info_['judgement'] = []
                # max permissible draft
                max_draft_ = max([float(u_["foreDraftValue"]), float(u_["aftDraftValue"]), mid_ship_draft_]) 
                if limits['limits']['draft'][info_['portId']] < max_draft_:
                    info_['judgement'].append('Failed max permissible draft check!')
                # loadline 
                if limits['limits']['draft']['loadline'] < max_draft_:
                    info_['judgement'].append('Failed loadline check!')
                # airDraft
                
                # SF
                if float(v_["shearingForcePersentValue"]) > 100:
                    info_['judgement'].append('Failed SF check!')
                # BM
                if float(v_["bendingMomentPersentValue"]) > 100:
                    info_['judgement'].append('Failed BM check!')
            
                out_["loadicatorResultDetails"].append(info_)
            
            out['loadicatorResultsPatternWise'].append(out_)
        
            
    else:
        print('Unknown type!!')
            
    
    return out
#    print(out)

if __name__ == "__main__":
    
    data = {}
    with open('loadableStudy1.json') as json_file: 
        data['loadable'] = json.load(json_file) 
    with open('vessel.json') as json_file: 
        data['vessel'] = json.load(json_file) 
        
    message = gen_allocation(data)