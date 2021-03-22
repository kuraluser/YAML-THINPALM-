# -*- coding: utf-8 -*-
"""
Created on Tue Feb 16 14:39:08 2021

@author: I2R
"""

from itertools import permutations
from copy import deepcopy
# import time

# from vlcc_init_rotate import Process_input_rotate
from vlcc_gen import Generate_plan
from vlcc_check import Check_plans

class Check_rotations:
    def __init__(self, data, inputs):
#        self.outfile   = 'resmsg.json'
        self.input = inputs # original input
        self.json = data # original loadable
        self.rotation_input = deepcopy(inputs)
        
        
    def _check_plans(self, plans):
        
        self.constraints = {str(p__):[] for p__,p_ in enumerate(plans['ship_status'])}
        # time.sleep(10) 
        # input("Press Enter to continue...")
        for s__, s_ in enumerate(plans.get('operation',[])):
            print('main plan:', s__, plans['rotation'][s__])
            ballast_plan_ = {k1_:v1_['ballast']  for k1_,v1_ in plans['ship_status'][s__].items()}
            if self.input.loadable.info['rotationCheck']:
                
                for r__, r_ in enumerate(permutations(plans['rotation'][s__])):
                    if plans['rotation'][s__] != list(r_):
                        print('check rotation ...',list(r_)) 
                        self._check_rotations(list(r_), s_, ballast_plan_, s__, r__, plans['rotation'][s__])
                    else:
                        for l__,l_ in enumerate(plans['rotation'][s__]):
                            str1 += self.input.loadable.info['parcel'][l_]['abbreviation'] + ' -> '
                        
                        self.constraints[str(s__)].append(str1[:-3] + 'is fine!!')
                        
            else:
                print('no rotation needed ...')
            
                        
                    
            
        
    def _check_rotations(self, new_rotation, loading_plan, ballast_plan, plan_id, rotation_id, cur_rotation):
        
        dat_file = 'input_rotate'+str(plan_id+rotation_id)+'.dat'
        loading_plan_ = dict(loading_plan)
        start_ = self.input.loadable.info['rotationVirtual'][0]
        for a_, (b_,c_) in enumerate(zip(self.input.loadable.info['rotationVirtual'], new_rotation)):
            print(a_,b_,c_)
            virtual_ = cur_rotation.index(c_) + start_
            # loading_plan_[str(new_virtual_)] = loading_plan[str(b_)]
            loading_plan_[str(b_)] = loading_plan[str(virtual_)]
            
            
        empty_ballast_port_ = self.input.loadable.info['rotationVirtual'][:-1]
        ballast_plan_ = {k_:v_ for k_, v_ in ballast_plan.items() if int(k_) not in  empty_ballast_port_}
        
        # loadable_json = deepcopy(self.json['loadable'])
        # loadable_json['loadingPlan'] = loading_plan_
        # loadable_json['ballastPlan'] = ballast_plan_
        
            
                # plan = {k_:v_ for k_,v_ in s_.items() if k_[:-1] == port}
        # loadable_json = self._recreate_loadable(loading_plan, ballast_plan)
        
        # data = {}
        # data['vessel'] = self.json['vessel']
        # data['loadable'] = loadable_json
        
        new_input = self.rotation_input
        # new_input.port = Port(new_input)
        # new_input.loadable = Loadable(self) # basic info
        new_input.cargo_rotation = new_rotation
        
        new_input.loadable_json['loadingPlan'] = loading_plan_
        new_input.loadable_json['ballastPlan'] = ballast_plan_
        new_input.loadable._create_operations(new_input) # operation and commingle
        # new_input.vessel = Vessel(self)
        # new_input.vessel._get_onhand(self) # ROB
        # new_input.vessel._get_onboard(self) # Arrival condition
        new_input.get_stability_param()
        new_input.write_dat_file(file = dat_file)
        
        new_output = Generate_plan(new_input)
        new_output.run(dat_file=dat_file,num_plans=1)
        
        str1 = ''
        for l__,l_ in enumerate(new_input.loadable.info['rotationCargo']):
            str1 += self.input.loadable.info['parcel'][l_]['abbreviation'] + ' -> '
        
        # new_output.plan['ship_status'] = []
        if new_output.plan['ship_status']:
            self.constraints[str(plan_id)].append(str1[:-3] + 'is fine!!')
        else:
            ## set positive trim < 2
            print('set 0 < trim <= 2')
            # new_input.trim_upper = {str(p_):str(2) for p_ in range(1,new_input.loadable.info['lastVirtualPort']) if str(p_) not in new_input.loadable.info['fixedBallastPort']}
            new_input._set_trim(2, 0)
            new_input.write_dat_file(file = dat_file)
        
            new_output = Generate_plan(new_input)
            new_output.run(dat_file=dat_file,num_plans=1)
            
            
                        
            if new_output.plan['ship_status']:
                self.constraints[str(plan_id)].append(str1[:-3] + 'is fine with 0 < trim <= 2!!')
            else:
                self.constraints[str(plan_id)].append(str1[:-3] + 'is not possible!!')
            
          
            
        
        ## check and modify plans    
        print('main plan:', plan_id, new_rotation)
        plan_check = Check_plans(new_input)
        plan_check._check_plans(new_output.plan.get('ship_status',[]), new_output.plan.get('cargo_tank',[]))
       
        
        # time.sleep(10) 
        # input("Press Enter to continue...")
                
   
   