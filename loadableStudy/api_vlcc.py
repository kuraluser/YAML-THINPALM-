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



from discharge_init import Process_input1

# import pickle

def gen_allocation(data):
    out = []
            
    if not data['vessel']:
        return {'message': 'Vessel details not available!!'}
    
    if data.get('loadablePlanPortWiseDetails', []):
        out = manual_mode(data)        
    elif data['module'] in ['LOADABLE']:
        print ('Auto Mode LOADABLE --------------------------------------------')
        out = auto_mode(data)
    else:
        print ('DISCHARGE Mode --------------------------------------------')
        out = discharge_mode(data)
    
    return out

def discharge_mode(data):
    out = []
    
    input_param = Process_input1(data)
    input_param.prepare_dat_file()
    input_param.write_dat_file()
    
    # collect plan from AMPL
    gen_output = Generate_plan(input_param)
    gen_output.run(num_plans=1)
    
    # with open('result.pickle', 'wb') as fp_:
    #     pickle.dump(gen_output, fp_)  
    
    # with open('result.pickle', 'rb') as fp_:
    #     gen_output = pickle.load(fp_)
    
    ## check and modify plans    
    plan_check = Check_plans(input_param)
    plan_check._check_plans(gen_output.plans.get('ship_status',[]), gen_output.plans.get('cargo_tank',[]))
    
      
    ## gen json  
    out = gen_output.gen_json2({}, plan_check.stability_values)
    
    return out

def manual_mode(data):
    if not data.get('ballastEdited', False):
        print('Manual Mode LOADABLE -------------------------------------------')
    else:
        print('Full Manual Mode LOADABLE -------------------------------------------')
    
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
    plan_check._check_plans(gen_output.plans.get('ship_status',[]), gen_output.plans.get('cargo_tank',[]))
    
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
    
    # print(outputs.plans.get('cargo_tank',[]))
    # with open('outputs.json', 'w') as f_:  
    #    json.dump(outputs.plans, f_)
    
    ## check and modify plans    
    plan_check = Check_plans(input_param)
    plan_check._check_plans(outputs.plans.get('ship_status',[]), outputs.plans.get('cargo_tank',[]))
    
    # with open('result.pickle', 'wb') as handle:
    #     pickle.dump((data, input_param, outputs.plans), handle, protocol=pickle.HIGHEST_PROTOCOL)
    
    
    

    
    # ## check cargo rotation
    cargo_rotate = Check_rotations(data, input_param)
    cargo_rotate._check_plans(outputs.plans, outputs.permute_list, outputs.permute_list1)
    
    # # # ## gen json  
    out = outputs.gen_json(cargo_rotate.constraints, plan_check.stability_values)
    ## out = outputs.gen_json({str(k_):[] for k_ in range(0,len(outputs.plans.get('ship_status',[])))}, plan_check.stability_values)
    
        
    
    return out
    
def loadicator(data, limits):
    
    out = {"processId": data["processId"], "loadicatorResults":{}}
    # print(limits)
    
    # print(limits['limits']['feedback'], limits['limits']['sfbm'])
    
    if type(data.get("loadicatorPatternDetail",None)) is dict:
        
        # Manual or fully Manual
        
        out["loadicatorResults"]["loadablePatternId"] = data['loadicatorPatternDetail']['loadablePatternId']
        out["loadicatorResults"]['loadicatorResultDetails'] = []
        
        results_ =  data['loadicatorPatternDetail']
        fail_SF_, fail_BM_ = False, False
        
        for u_, v_ in zip(results_['ldTrim'],results_['ldStrength']):
            assert u_['portId'] == v_['portId']
            info_ = {}
            info_['portId'] = int(u_['portId'])
            info_['synopticalId'] = int(u_['synopticalId'])
            info_['operationId'] = int(limits['limits']['operationId'][str(info_['portId'])])
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
            info_['errorDetails'] = [l_ for l_ in u_["errorDetails"]+v_["errorDetails"] if l_ not in [""]]
            
            if info_['deflection'] in [None, ""]:
                sag_ = 0.
            else:
                sag_ = float(u_.get('deflection', 0.))/400
            
            mid_ship_draft_ = float(u_["meanDraftValue"]) + sag_
            info_['judgement'] = []
            
            
            # trim
            if abs(float(u_["trimValue"])) > 0.1:
                info_['judgement'].append('Failed trim check ('+ "{:.2f}".format(float(u_["trimValue"])) +'m)!')
                # fail_SF_  = True
            # list
            if u_["heelValue"] not in [None and ""] and abs(float(u_["heelValue"])) > 0.1:
                info_['judgement'].append('Failed list check ('+ "{:.1f}".format(float(u_["heelValue"])) +')!')
                # fail_BM_ = True
            
            # max permissible draft
            # max_draft_ = max([float(u_["forwardDraft"]), float(u_["afterDraft"]), mid_ship_draft_]) 
            max_draft_ = max([float(u_["foreDraftValue"]), float(u_["aftDraftValue"]), mid_ship_draft_]) 
            if limits['limits']['draft'][str(info_['portId'])] < max_draft_:
                info_['judgement'].append('Failed max permissible draft check ('+ "{:.2f}".format(max_draft_) +'m)!')
            # loadline 
            if limits['limits']['draft']['loadline'] < max_draft_:
                info_['judgement'].append('Failed loadline check ('+ "{:.2f}".format(max_draft_) +'m)!')
            # airDraft
            if limits['limits']['airDraft'][str(info_['portId'])] < float(info_['airDraft']):
                info_['judgement'].append('Failed airdraft check ('+ "{:.2f}".format(float(info_['airDraft'])) +'m)!')
            
            # SF
            if abs(float(v_["shearingForcePersentValue"])) > 100:
                info_['judgement'].append('Failed SF check ('+ "{:.0f}".format(float(v_["shearingForcePersentValue"])) +')!')
                # fail_SF_  = True
            # BM
            if abs(float(v_["bendingMomentPersentValue"])) > 100:
                info_['judgement'].append('Failed BM check ('+ "{:.0f}".format(float(v_["bendingMomentPersentValue"])) +')!')
                # fail_BM_ = True
            
            
            out["loadicatorResults"]['loadicatorResultDetails'].append(info_)
            
        rerun_ = True if fail_BM_ or fail_SF_ else False
            
    elif type(data["loadicatorPatternDetails"]) is list:
        # auto mode
        out = {"processId": data["processId"], "loadicatorResultsPatternWise":[]}
        
        # print(len(data['loadicatorPatternDetails']))
        
        fail_BMSF_ = 0
        
        for p_ in data['loadicatorPatternDetails']:
            out_ = {"loadablePatternId":p_["loadablePatternId"], 'loadicatorResultDetails':[]}
            
            fail_SF_, fail_BM_ = False, False
            for u_, v_ in zip(p_['ldTrim'],p_['ldStrength']):
                assert u_['portId'] == v_['portId']
                info_ = {}
                info_['portId'] = int(u_['portId'])
                info_['synopticalId'] = int(u_.get('synopticalId',""))
                info_['operationId'] = int(limits['limits']['operationId'][str(info_['portId'])])
                
                info_["calculatedDraftFwdPlanned"] = u_["foreDraftValue"]
                info_["calculatedDraftMidPlanned"] = u_["meanDraftValue"]
                info_["calculatedDraftAftPlanned"] = u_["aftDraftValue"]
                info_["calculatedTrimPlanned"] = u_["trimValue"]
                info_["blindSector"] = None
                info_["list"] = str(u_["heelValue"])
                info_['airDraft'] = u_['airDraftValue']
                info_['deflection'] = u_.get('deflection', None)
                
                info_["SF"] = v_["shearingForcePersentValue"]
                info_['BM'] = v_["bendingMomentPersentValue"]
                info_['errorDetails'] = [u_["errorDetails"], v_["errorDetails"]]
                
                if info_['deflection'] in [None, ""]:
                    sag_ = 0.
                else:
                    sag_ = float(u_.get('deflection', 0.))/400
                
                
                mid_ship_draft_ = float(u_["meanDraftValue"]) + sag_
                info_['judgement'] = []
                
                # trim
                if abs(float(u_["trimValue"])) > 0.1:
                    info_['judgement'].append('Failed trim check ('+ "{:.2f}".format(float(u_["trimValue"])) +'m)!')
                    
                # list
                if u_["heelValue"] not in [None and ""] and abs(float(u_["heelValue"])) > 0.1:
                    info_['judgement'].append('Failed list check ('+ "{:.1f}".format(float(u_["heelValue"])) +')!')
                
                # max permissible draft
                # max_draft_ = max([float(u_["forwardDraft"]), float(u_["afterDraft"]), mid_ship_draft_]) 
                max_draft_ = max([float(u_["foreDraftValue"]), float(u_["aftDraftValue"]), mid_ship_draft_]) 
                if limits['limits']['draft'][str(info_['portId'])] < max_draft_:
                    info_['judgement'].append('Failed max permissible draft check ('+ "{:.2f}".format(max_draft_) +'m)!')
                # loadline 
                if limits['limits']['draft']['loadline'] < max_draft_:
                    info_['judgement'].append('Failed loadline check ('+ "{:.2f}".format(max_draft_) +'m)!')
                # airDraft
                if limits['limits']['airDraft'][str(info_['portId'])] < float(info_['airDraft']):
                    info_['judgement'].append('Failed airdraft check ('+ "{:.2f}".format(float(info_['airDraft'])) +'m)!')
                
                # SF
                if abs(float(v_["shearingForcePersentValue"])) > 100:
                    info_['judgement'].append('Failed SF check ('+ "{:.0f}".format(float(v_["shearingForcePersentValue"])) +')!')
                    fail_SF_ = True
                # BM
                if abs(float(v_["bendingMomentPersentValue"])) > 100:
                    info_['judgement'].append('Failed BM check ('+ "{:.0f}".format(float(v_["bendingMomentPersentValue"])) +')!')
                    fail_BM_ = True
                
                out_["loadicatorResultDetails"].append(info_)
            
            out['loadicatorResultsPatternWise'].append(out_)
            if fail_SF_ and fail_BM_:
                fail_BMSF_ += 1
                
            
        rerun_ = True if fail_BMSF_ == len(data['loadicatorPatternDetails']) else False
            
    else:
        print('Unknown type!!')
            
        
    # print(fail_BMSF_)
    # rerun_ = True
    if not rerun_:    
        ## feedback loop
        out['feedbackLoop'] = False
        out['feedbackLoopCount'] = limits['limits']['feedback']['feedbackLoopCount']
        out['sfbmFac'] = limits['limits']['sfbm']
        
        # print('do')
    elif data.get('module', None) in ['LOADABLE']:
        print('Rerun!!')
        out['feedbackLoop'] = True
        out['feedbackLoopCount'] = limits['limits']['feedback']['feedbackLoopCount'] + 1
        out['sfbmFac'] = limits['limits']['sfbm'] - 0.05
    ## 
    
    
    return out
#    print(out)

if __name__ == "__main__":
    
    data = {}
    with open('loadableStudy1.json') as json_file: 
        data['loadable'] = json.load(json_file) 
    with open('vessel.json') as json_file: 
        data['vessel'] = json.load(json_file) 
        
    message = gen_allocation(data)