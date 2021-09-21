# -*- coding: utf-8 -*-
"""
Created on Wed Jul 14 16:50:44 2021

@author: I2R
"""

from loading_init import Process_input
from vlcc_gen import Generate_plan 
from vlcc_check import Check_plans
# import json

import pickle

def gen_sequence(data: dict) -> dict:
    
    if not data['vessel']:
        return {'message': 'Vessel details not available!!'}
    
    out = loading(data)
    
    return out


def loading(data: dict) -> dict:
    out = {}
    
    params = Process_input(data)
    params.prepare_data()
    params.write_ampl()
    
    #input("Press Enter to continue...")
    # collect plan from AMPL
    gen_output = Generate_plan(params)
    gen_output.run(num_plans=1)
    
    # with open('result.pickle', 'wb') as fp_:
    #     pickle.dump(gen_output, fp_)  
    
    # with open('result.pickle', 'rb') as fp_:
    #     gen_output = pickle.load(fp_)
    
    ## check and modify plans    
    plan_check = Check_plans(params)
    plan_check._check_plans(gen_output.plans.get('ship_status',[]), gen_output.plans.get('cargo_tank',[]))
    
      
    # gen json  
    out = gen_output.gen_json1({}, plan_check.stability_values)
    
    return out

def loadicator1(data, limits):
    
    out = {"processId": data["processId"], 
           "loadingInformationId": data["loadingInformationId"],  
            'vesselId': data["vesselId"],
            'portId': data["portId"],
           "loadicatorResults":[]}
    # print(limits)
    
    
    for s__, s_ in enumerate(data['stages']):
        u_, v_ = s_['ldTrim'], s_['ldStrength']
        info_ = {}
        info_['time'] = int(float(s_['time']))
        
        info_["calculatedDraftFwdPlanned"] = u_["foreDraftValue"]
        info_["calculatedDraftMidPlanned"] = u_["meanDraftValue"]
        info_["calculatedDraftAftPlanned"] = u_["aftDraftValue"]
        info_["calculatedTrimPlanned"] = u_["trimValue"]
        info_["blindSector"] = None
        info_["list"] = str(u_["heelValue"])
        info_['airDraft'] = u_['airDraftValue']
        info_['deflection'] = u_.get("deflection", None) 
        
        info_["SF"] = v_["shearingForcePersentValue"]
        info_['BM'] = v_["bendingMomentPersentValue"]
        info_['errorDetails'] = [u_["errorDetails"], v_["errorDetails"]]
        
        if info_['deflection'] in [None, ""]:
            sag_ = 0.
        else:
            sag_ = float(u_.get('deflection', 0.))/400
            
        mid_ship_draft_ = float(u_["meanDraftValue"]) + sag_
        info_['judgement'] = []
        # max permissible draft
        max_draft_ = max([float(u_["foreDraftValue"]), float(u_["aftDraftValue"]), mid_ship_draft_]) 
        if limits['limits']['draft']['maxDraft'] < max_draft_:
            info_['judgement'].append('Failed max permissible draft check!')
        # loadline 
        if limits['limits']['draft']['loadline'] < max_draft_:
            info_['judgement'].append('Failed loadline check!')
        # airDraft
        if limits['limits']['airDraft'] < float(info_['airDraft']):
            info_['judgement'].append('Failed airdraft check!')
        
        # SF
        if abs(float(v_["shearingForcePersentValue"])) > 100:
            info_['judgement'].append('Failed SF check!')
            # fail_SF_  = True
        # BM
        if abs(float(v_["bendingMomentPersentValue"])) > 100:
            info_['judgement'].append('Failed BM check!')
            # fail_BM_ = True
        
        out["loadicatorResults"].append(info_)
    
    
    return out
