# -*- coding: utf-8 -*-
"""
Created on Wed Jul 14 16:50:44 2021

@author: I2R
"""

from discharging_init import Process_input
from vlcc_gen import Generate_plan 
from vlcc_check import Check_plans
import numpy as np
# import json

# import pickle
#import dill as pickle

def gen_sequence1(data: dict) -> dict:
    
    if not data['vessel']:
        return {'message': 'Vessel details not available!!'}
    
    out = discharging(data)
    
    return out


def discharging(data: dict) -> dict:
    out = {}
    
    params = Process_input(data)
    params.prepare_data()
    params.write_ampl(IIS = False)
    
    # input("Press Enter to continue...")
    
    
    gen_output = Generate_plan(params)
    gen_output.run(num_plans=1)
    
    # with open('result.pickle', 'wb') as fp_:
    #     pickle.dump(gen_output, fp_)  
    
    # with open('result.pickle', 'rb') as fp_:
    #     gen_output = pickle.load(fp_)
    
    
    # ## check and modify plans    
    plan_check = Check_plans(params)
    plan_check._check_plans(gen_output.plans.get('ship_status',[]), gen_output.plans.get('cargo_tank',[]))
    
      
    ## gen json  
    out = gen_output.gen_json3({}, plan_check.stability_values)
    
    
    return out

