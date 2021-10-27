# -*- coding: utf-8 -*-
"""
Created on Fri Nov 27 15:55:30 2020

@author: I2R
"""
#import amplpy
from amplpy import AMPL
import numpy as np
import json

from vlcc_ortools import vlcc_ortools
from loading_seq import Loading_seq
from discharging_seq import Discharging_seq

from copy import deepcopy

DEC_PLACE = 3

CONS = {'Condition01z': 'Min tolerance constraints violated!!',
        'Constr122': 'Priority constraints violated!!',
        'Condition112d1': '1P and 1S cannot have same weight!!',
        'Condition112d2': '2P and 2S cannot have same weight!!',
        'Condition112d3': '4P and 4S cannot have same weight!!',
        'Condition112d4': '5P and 5S cannot have same weight!!',
        'Condition114g1': 'Deballast amt during loading cargo issue!!',
        'Constr13': 'Displacement bound issue!!',
        'Constr13b': 'Deadweight bound issue!!',
        'Constr16a': 'Trim lower bound issue!!',
        'Constr16b': 'Trim upper bound issue!!',
        'Condition20b': 'SF lower bound issue!!',
        'Condition20c': 'SF upper bound issue!!',
        'Condition21b': 'BM lower bound issue!!',
        'Condition21c': 'BM upper bound issue!!',
        'Condition111': "Load all cargo issue!!",
        'Condition115': "Deballast limitation issue!!",
        'Condition112g1': "SLP has to be used issue!!",
        'Condition112g2': "SLS has to be used issue!!"
        
        }

# FIXCONS =  []
FIXCONS = ['Condition0', 'Condition01', 'Condition03', 
            'Condition04', 'Condition05',
            'Condition041', 'Condition050', 'Condition050a', 
            'Condition050b', 'Condition050b1',
            'Condition050c', 'Condition050c1',
            'Condition052', 'Condition06', 'condition22',
            'condition23', 'condition23a', 'condition23b',
            'condition24', 'condition24a', 'condition25', 'condition27',
            'Constr5a',
            'Constr8', 'Constr11', 'Constr12a1',
            'Condition112a', 'Condition112b', 'Condition112c1', 'Condition112c2', 'Condition112c3',
            'Condition112a1', 'Condition112a2',
            'Condition112b1', 'Condition112b2',
            'Condition112f', 
            'Condition112g1', 'Condition112g2', 
            'Condition113d1', 'Condition113d2', 'Condition113d3',
            'Condition114a1', 'Condition114a2', 'Condition114a3',
            "Condition114b", "Condition114c", "Condition114d2",
            'Condition114e1', 'Condition114e2', 'Condition114e3', 'Condition114e4', 'Condition114e5', 'Condition114e6',
            'Condition114f1',
            'Constr17a', 'Constr13c1', 'Constr13c2',
            'Constr13a',
            'Constr15b1', 'Constr15b2', 'Constr15c1', 'Constr15c2', 'Constr153', 'Constr154',
            'Constr16b1', 'Constr16b2', 'Constr161', 'Constr163', 'Constr164',
            'Constr18a', 'Constr18b', 'Constr19a', 'Constr19b', 'Constr18d', 'Condition200a',
            'Condition20a1', 'Condition21a1', 'Condition20a2', 'Condition21a2']

DENSITY = {'DSWP':1.0, 'DWP':1.0, 'FWS':1.0, 'DSWS':1.0,
                   'FO2P':0.98, 'FO2S':0.98, 'FO1P':0.98, 'FO1S':0.98, 'BFOSV':0.98, 'FOST':0.98, 'FOSV':0.98,
                   'DO1S':0.88,  'DO2S':0.88, 'DOSV1':0.88, 'DOSV2':0.88}
        
class Generate_plan:
    def __init__(self, data):

        self.input = data
        self.commingled = False
        self.rerun = False
        self.full_load = False
        self.IIS = True
        self.commingled_ratio = {}
        
        
        
    def run(self, dat_file='input.dat', num_plans=100):
        
        self.plans = {}
        self.plans['ship_status'] = []
        self.plans['message'] = {}
        self.plans['constraint'] = []
        
        if not self.input.error:
            
            # if self.input.mode in ['FullManual']:
            #     print('run Assemble ....')
            #     self._assemble()
                
            # else:
            if self.input.solver in ['AMPL']:
                print('run AMPL ....')
                result = self._run_ampl(dat_file=dat_file) 
            else:
                print('run ORTOOLS ....')
                result = self._run_ortools()
            
            if result['succeed']:
                self._process_ampl(result, num_plans=num_plans)
                if self.commingled_ratio:
                    print('Rerun due to miss temperature in commingle cargo!!')
                    temp_ = 0.
                    for k_, v_ in self.commingled_temp.items():
                        if v_ > temp_:
                            temp_ = v_
                            self.input.loadable.commingled_ratio = self.commingled_ratio[k_]
                    
                    self.input.loadable._create_operations(self.input) # operation and commingle
                    self.input.write_dat_file()
                    
                    if self.input.solver in ['AMPL']:
                        print('run AMPL ....')
                        result = self._run_ampl(dat_file=dat_file) 
                    else:
                        print('run ORTOOLS ....')
                        result = self._run_ortools()
                    self._process_ampl(result, num_plans=num_plans)
                    
                self._process_checking_plans(result)
            else:
                self.plans['message']['Optimization Error'] = result['message']
        else:
            self.plans['message'] = self.input.error
            
        
    def _run_ampl(self,dat_file='input.dat'):
                
        is_succeed, num_solutions = False, 0
        solve_result, obj, plan, ship_status, ballast_weight, cargo_loaded, xx, cargo_loaded_port = [], [], [], [], [], [], [], []
        message = []
    
        try:
            # model_1i.mod : max loaded
            # model_3i.mod : min tank 
            
            if self.input.module in ['LOADING']:
                model_ = 'model_1i.mod'
                dat_file = 'input_load.dat'
            elif self.input.module in ['LOADABLE']:
                if self.input.mode in ['FullManual']:
                    model_ = 'model_2i.mod'
                else:
                    if self.input.config.get('objective', "1") == '1':
                        model_ = 'model_1i.mod'
                    else:
                        model_ = 'model_3i.mod'
                        
            elif self.input.module in ['DISCHARGE']:
                model_ = 'model_1i.mod'
                dat_file = 'input_discharge.dat'
                
            elif self.input.module in ['DISCHARGING']:
                model_ = 'model_4i.mod'
                dat_file = 'input_discharging.dat'
                
            print(model_)
            ampl = AMPL()
            # ampl.option['show_presolve_messages'] = True
            
            if self.input.module in ['LOADING']:
                # ampl.option['presolve'] = False
                pass
            elif self.input.module in ['LOADABLE']:
                if self.input.mode in ['Manual'] or not self.IIS:
                    ampl.option['presolve'] = False
                
            ampl.read(model_)
            
            ## module dependent constraints    
            if self.input.module in ['LOADABLE']:
                
                if self.input.mode not in ['FullManual']:
                    # auto and manual modes
                    c1_ = ampl.getConstraint('Condition112d5') # only for discharging
                    c2_ = ampl.getConstraint('Condition114g2') # only for discharging
                    c1_.drop()
                    c2_.drop()
                    
                if self.input.mode in ['Manual']:
                    c3_ = ampl.getConstraint('Constr5b') # commingle 98%
                    c3_.drop()
                    
                if self.input.vessel.info['onboard']:
                    if 'SLP' in self.input.vessel.info.get('notOnTop', []):
                        slp_ = ampl.getConstraint('Condition112g1') # SLP must be used
                        slp_.drop()
                        
                    if 'SLS' in self.input.vessel.info.get('notOnTop', []): # SLS must be used
                        sls_ = ampl.getConstraint('Condition112g2')
                        sls_.drop()
                    
            elif self.input.module in ['LOADING']:
                c1_ = ampl.getConstraint('Condition112d5') # only for discharging
                c2_ = ampl.getConstraint('Condition114g2') # only for discharging
                c3_ = ampl.getConstraint('Condition01') # one tank can only take in one cargo
                c1_.drop()
                c2_.drop()
                c3_.drop()
                
                # drop slop tanks must be used constraints
                slp_ = ampl.getConstraint('Condition112g1') # SLP must be used
                sls_ = ampl.getConstraint('Condition112g2') # SLS must be used
                slp_.drop()
                sls_.drop()
                
            elif self.input.module in ['DISCHARGE']:
                cw_ = ampl.getConstraint('Constr13b')
                cw_.drop()
                # drop slop tanks must be used constraints
                slp_ = ampl.getConstraint('Condition112g1') # SLP must be used
                sls_ = ampl.getConstraint('Condition112g2')  # SLS must be used
                slp_.drop()
                sls_.drop()
                #
                wwt_ = ampl.getConstraint('condition24a')
                wwt_.drop()
                
            elif self.input.module in ['DISCHARGING']:
                 # drop slop tanks must be used constraints
                c1_ = ampl.getConstraint('Condition112g1') # SLP must be used
                c2_ = ampl.getConstraint('Condition112g2') # SLS must be used
                c1_.drop()
                c2_.drop()
                
                # 5% different in vol
                c3_ = ampl.getConstraint('Condition112a1')
                c4_ = ampl.getConstraint('Condition112a2')
                c3_.drop()
                c4_.drop()
                
                cw_ = ampl.getConstraint('Constr13b') 
                cw_.drop()
                
            ## vessel dependent constraints    
            if int(self.input.vessel_id) in [1] and self.input.mode not in ['FullManual']:
                
                # drop mean draft in BF and SF
                c4_ = ampl.getConstraint('Condition20a2')
                c5_ = ampl.getConstraint('Condition21a2')
                c4_.drop()
                c5_.drop()
                
            elif int(self.input.vessel_id) in [2]:
                # drop aft draft in BF and SF
                c4_ = ampl.getConstraint('Condition20a1')
                c5_ = ampl.getConstraint('Condition21a1')
                c4_.drop()
                c5_.drop()
                    
                    
            ampl.readData(dat_file)
            ampl.read('run_ampl.run')
            
            solve_result = ampl.getValue('solve_result')
            solve_result_num = int(ampl.getValue('solve_result_num'))
            num_solutions = int(ampl.getValue('Action_Amount.npool')) 
            print(solve_result,solve_result_num, num_solutions)
            
#            solve_result_num, solve_result = 99, 'timelimit'
            if (num_solutions > 0) and (solve_result_num in [0, 2, 403] or solve_result == 'solved'):
                # Solve
                # Get the solution
                
                tot_load = ampl.getData('totloaded').toList()
                plan = ampl.getData('res').toList()
                obj = ampl.getData('totloaded').toList()
                ship_status = ampl.getData('shipStatus').toList()
                ballast_weight = ampl.getData('wtB').toList()
                cargo_loaded = ampl.getData('cargoloaded').toList()
                cargo_loaded_port = ampl.getData('cargoloadedport').toList()
                xx = ampl.getData('xx').toList()
                
                # self._other_AMPL_data(ampl)
                
                is_succeed = True
                
                toLoadPortMax_ = -1
                if self.input.module in ['LOADABLE']:
                    toLoadPortMax_ = round(self.input.loadable.info['toLoadPort'].max(),3)
                elif self.input.module in ['LOADING']:
                    toLoadPortMax_ = round(max([j_ for i_, j_ in  self.input.loadable['toLoadPort'].items()]),3)
                
                print("{:.3f}".format(toLoadPortMax_), "{:.3f}".format(tot_load[0][1]))
                
                if round(toLoadPortMax_,3) == round(tot_load[0][1],3):
                    self.full_load = True
                
            else:
                message = ['Solve result: ' + solve_result +'. No solution is available!!']
                print(message)
                
                if solve_result in ['infeasible'] and self.IIS:
                    cons = ampl.getData('_conname').toList() # constraint list
                    violated_cons = ampl.getData('_con.iis').toList() # violated constraint list
                    
                    violated_cons_ = []
                    print('The following constraints are violated:')
                    for v_ in violated_cons:
                        if v_[1] not in ['non', '0']:
                            # print(cons[int(v_[0])-1][1])
                            
                            if cons[int(v_[0])-1][1].split('[')[0] not in violated_cons_:
                                violated_cons_.append(cons[int(v_[0])-1][1].split('[')[0])
                                
                                
                    if len(violated_cons_) == 0 :
                        ampl = AMPL()
                        ampl.option['presolve'] = False
                        ampl.read(model_)
                        
                        ## module dependent constraints    
                        if self.input.module in ['LOADABLE']:
                            if self.input.mode not in ['FullManual']:
                                # auto and manual modes
                                c1_ = ampl.getConstraint('Condition112d5') # only for discharging
                                c2_ = ampl.getConstraint('Condition114g2') # only for discharging
                                c1_.drop()
                                c2_.drop()
                                
                            if self.input.mode in ['Manual']:
                                c3_ = ampl.getConstraint('Constr5b') # commingle 98%
                                c3_.drop()
                                
                            if self.input.vessel.info['onboard']:
                                if 'SLP' in self.input.vessel.info.get('notOnTop', []):
                                    slp_ = ampl.getConstraint('Condition112g1') # SLP must be used
                                    slp_.drop()
                                    
                                if 'SLS' in self.input.vessel.info.get('notOnTop', []): # SLS must be used
                                    sls_ = ampl.getConstraint('Condition112g2')
                                    sls_.drop()
                            
                        elif self.input.module in ['LOADING']:
                            c1_ = ampl.getConstraint('Condition112d5')
                            c2_ = ampl.getConstraint('Condition114g2')
                            c3_ = ampl.getConstraint('Condition01')
                            c1_.drop()
                            c2_.drop()
                            c3_.drop()
                            
                            # drop slop tanks must be used constraints
                            slp_ = ampl.getConstraint('Condition112g1')
                            sls_ = ampl.getConstraint('Condition112g2')
                            slp_.drop()
                            sls_.drop()
                            
                        elif self.input.module in ['DISCHARGE']:
                            cw_ = ampl.getConstraint('Constr13b')
                            cw_.drop()
                            # drop slop tanks must be used constraints
                            slp_ = ampl.getConstraint('Condition112g1')
                            sls_ = ampl.getConstraint('Condition112g2')
                            slp_.drop()
                            sls_.drop()
                            #
                            wwt_ = ampl.getConstraint('condition24a')
                            wwt_.drop()
                            
                        elif self.input.module in ['DISCHARGING']:
                            
                            # drop slop tanks must be used constraints
                            c1_ = ampl.getConstraint('Condition112g1')
                            c2_ = ampl.getConstraint('Condition112g2')
                            c1_.drop()
                            c2_.drop()
                            
                            # 5% different in vol
                            c3_ = ampl.getConstraint('Condition112a1')
                            c4_ = ampl.getConstraint('Condition112a2')
                            c3_.drop()
                            c4_.drop()
                            
                            cw_ = ampl.getConstraint('Constr13b')
                            cw_.drop()
                            
                        ## vessel dependent constraints    
                        if int(self.input.vessel_id) in [1]:
                            
                            # drop mean draft in BF and SF
                            c4_ = ampl.getConstraint('Condition20a2')
                            c5_ = ampl.getConstraint('Condition21a2')
                            c4_.drop()
                            c5_.drop()
                            
                        elif int(self.input.vessel_id) in [2]:
                            # drop aft draft in BF and SF
                            c4_ = ampl.getConstraint('Condition20a1')
                            c5_ = ampl.getConstraint('Condition21a1')
                            c4_.drop()
                            c5_.drop()
                            
                            
                        ampl.readData(dat_file)
                        ampl.read('run_ampl.run')
                        
                        print('Run AMPL with no presolve')
                        cons = ampl.getData('_conname').toList() # constraint list
                        violated_cons = ampl.getData('_con.iis').toList() # violated constraint list
                        
                        violated_cons_ = []
                        print('The following constraints are violated:')
                        for v_ in violated_cons:
                            if v_[1] not in ['non', '0']:
                                print(cons[int(v_[0])-1][1])
                                
                                if cons[int(v_[0])-1][1].split('[')[0] not in violated_cons_:
                                    violated_cons_.append(cons[int(v_[0])-1][1].split('[')[0])
                        
                        
                        
                    # print({'volatedConstraints':violated_cons_})
                    
                    remove_ = True
                    
                    for l_ in violated_cons_:
                        
                         con_ = CONS.get(l_,None)
                         if con_ not in [None]:
                             message.append(con_)
                         elif remove_ and l_ not in FIXCONS:
                             message.append(l_ + ' violated!!')
                         elif not remove_:
                             message.append(l_ + ' violated!!')

                             
                    print(message)
                         
                    
           
        except Exception as err:
            print('AMPL Error:',err)
            message = err
        
        return {'solve_result':solve_result, 
            'succeed':is_succeed,
            'obj':obj, 
            'plan':plan, 
            'ship_status':ship_status, 
            'ballast_weight':ballast_weight, 
            'cargo_loaded':cargo_loaded, 
            'xx':xx, 
            'cargo_loaded_port':cargo_loaded_port,
            'num_plans':num_solutions,
            'message':message}
    
    def _run_ortools(self):
        
        is_succeed = False
        solve_result, obj, plan, ship_status, ballast_weight, cargo_loaded, xx, cargo_loaded_port = [], [], [], [], [], [], [], []
        num_solutions = 0
        message = []
        
        try:
            result = vlcc_ortools(self.input)
            status = result['status']
            
            if status in [0,1]:
                solve_result = 'solved' # objective
                tot_load = result['totloaded'] # totloaded
                plan = result['res']
                obj = result['obj']  
                ship_status = result['shipStatus']
                ballast_weight = result['wtB']
                cargo_loaded = result['cargoloaded']
                cargo_loaded_port = result['cargoloadedport']
                xx = result['xx']
                num_solutions = 1

                is_succeed = True
                
                # print("{:.3f}".format(self.input.loadable.info['toLoadPort'].max()), "{:.3f}".format(tot_load[0][1]))
                toLoadPortMax_ = -1
                if self.input.module in ['LOADABLE']:
                    toLoadPortMax_ = round(self.input.loadable.info['toLoadPort'].max(),3)
                elif self.input.module in ['LOADING']:
                    toLoadPortMax_ = round(max([j_ for i_, j_ in  self.input.loadable['toLoadPort'].items()]),3)
                
                print("{:.3f}".format(toLoadPortMax_), "{:.3f}".format(tot_load[0][1]))
                
                
            
            else:
                message = ['Solve result: No solution is available!!']
                print(message)
                
        except Exception as err:
            print('ORTOOLS Error:',err)
            message = err
            
        return {'solve_result':solve_result, 
                'succeed':is_succeed,
                'obj':obj,
                'plan':plan, 
                'ship_status':ship_status, 
                'ballast_weight':ballast_weight, 
                'cargo_loaded':cargo_loaded, 
                'xx':xx, 
                'cargo_loaded_port':cargo_loaded_port,
                'message':message,
                'num_plans':num_solutions
                }
        
        
            
    def _other_AMPL_data(self, ampl):
        
        sf = ampl.getData('sf').toList()
        bm = ampl.getData('bm').toList()
        
        SF, BM = [], []
        for p__, p_ in enumerate(self.input.base_draft):
            SF.append([round(d_[3],3) for d_ in sf if d_[0] == 1 and d_[2] == p__+1 ]) # sol, frame, port, sf
            BM.append([round(d_[3],3) for d_ in bm if d_[0] == 1 and d_[2] == p__+1 ]) # sol, frame, port, bm
                        
        
        with open('ampl_data.json', 'w') as f_:  
            json.dump({'SF':SF, 'BM':BM}, f_)

        
        
    def _process_ampl(self, result, num_plans=100):
        
        
        self.plans['obj'] = []
        self.plans['operation'] = []
        self.plans['ship_status'] = []
        self.plans['cargo_status'] = []
        self.plans['constraint'] = []
        self.plans['slop_qty'] = []
        self.plans['cargo_order'] = []
        self.plans['loading_hrs'] = []
        self.plans['topping'] = []
        self.plans['loading_rate'] = []
        
        self.num_plans = min(num_plans,result['num_plans'])
        
        self.ship_status_dep, self.ballast_weight = [], []
        
        self.other_weight, self.initial_ballast_weight = {}, {}
        self.cargo_in_tank = []
        self.loading_rate = []
        self.topping_seq = [] 
        
        for p_ in range(self.num_plans):
            
            commingled_ = False
            tank_cargo_ = {t_:[]  for t_ in self.input.vessel.info['cargoTanks']}
            for q_ in result['xx']:
                if (p_+1) == int(q_[0]) and q_[3] > .0:
                    tank_cargo_[q_[2]].append(q_[1])
                    if len(tank_cargo_[q_[2]]) > 1:
                        commingled_ = True
                        
            
            if hasattr(self.input.loadable, "info"):
                operation_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
            else:
                operation_ = {str(pp_):{} for pp_ in range(0,self.input.loadable['lastVirtualPort']+1)}
            
            for i_ in result['plan']: # (1.0, 'P101', '1S', 3.0, -10000.0)
                if int(i_[0]) == (p_+1) and round(abs(i_[4]),DEC_PLACE) >= 0.01 and i_[1] in tank_cargo_[i_[2]]:
                    
                    
                    if hasattr(self.input.loadable, "info"):
                        density_ = self.input.loadable.info['parcel'][i_[1]]['maxtempSG']
                    else:
                        density_ = self.input.loadable['parcel'][i_[1]]['maxtempSG']
                        
                    wt_ = round(i_[4],DEC_PLACE)
                    capacity_ = self.input.vessel.info['cargoTanks'][i_[2]]['capacityCubm']
                    info_ = {'parcel':i_[1], 'wt': wt_, 'SG':density_, 
                             'fillRatio': round(i_[4]/density_/capacity_,DEC_PLACE)}
                    # print(i_[2],info_)
                    if i_[2] in operation_[str(int(i_[3]))].keys():
                        operation_[str(int(i_[3]))][i_[2]].append(info_)
                        commingled_ = True
                    else:
                        operation_[str(int(i_[3]))][i_[2]] = [info_]
                        
            self.plans['operation'].append(operation_)
            
            # status at departure: cargo tank only 
            if hasattr(self.input.loadable, "info"):
                ship_status_dep_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
            else:
                ship_status_dep_ = {str(pp_):{} for pp_ in range(0,self.input.loadable['lastVirtualPort']+1)} 
            
            for i_ in result['ship_status']: # (1.0, 'P101', '3P', 1.0, 10000.0)
                if int(i_[0]) == (p_+1) and round(i_[4],DEC_PLACE) >= 0.01 and i_[1] in tank_cargo_[i_[2]]:
                    onboard_ = self.input.vessel.info['onboard'].get(i_[2],{}).get('wt',0.)
                    # if onboard_ > 0:
                    #     print(i_[2],i_[1],i_[4],onboard_)
                    #wt_ = round(i_[4] + onboard_ ,DEC_PLACE) 
                    wt_ = i_[4] + onboard_
                    
                    if hasattr(self.input.loadable, "info"):
                        density_ = self.input.loadable.info['parcel'][i_[1]]['maxtempSG']
                    else:
                        density_ = self.input.loadable['parcel'][i_[1]]['maxtempSG']
                    
                    
                    capacity_ = self.input.vessel.info['cargoTanks'][i_[2]]['capacityCubm']
                    vol_ = wt_/density_ 
                    
                    tcg_ = 0.
                    if i_[2] in self.input.vessel.info['tankTCG']['tcg']:
                        tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][i_[2]]['vol'],
                                         self.input.vessel.info['tankTCG']['tcg'][i_[2]]['tcg'])
                        
                    lcg_ = 0.
                    if i_[2] in self.input.vessel.info['tankLCG']['lcg']:
                        lcg_ = np.interp(vol_, self.input.vessel.info['tankLCG']['lcg'][i_[2]]['vol'],
                                         self.input.vessel.info['tankLCG']['lcg'][i_[2]]['lcg'])
                    
                    
                    fillingRatio_ =  round(vol_/capacity_,DEC_PLACE)
                    
                    if fillingRatio_ > .98:
                        print('**',i_[2], fillingRatio_)
                    
                    tankId_ = self.input.vessel.info['tankName'][i_[2]]
                    corrUllage_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist(), 6)
                    
                    if hasattr(self.input.loadable, "info"):
                        temp_ = self.input.loadable.info['parcel'][i_[1]]['temperature']
                        api_  = self.input.loadable.info['parcel'][i_[1]]['api']
                    else:
                        temp_ = self.input.loadable['parcel'][i_[1]]['temperature']
                        api_  = self.input.loadable['parcel'][i_[1]]['api']
                    

                    
                    info_ = {'parcel':i_[1], 'wt': round(wt_,DEC_PLACE), 'SG': density_,
                             'fillRatio': fillingRatio_, 'tcg':tcg_, 'lcg':lcg_, 
                             'temperature':temp_,
                             'api':api_,
                             'corrUllage': corrUllage_,
                             'maxTankVolume':capacity_,
                             'vol': vol_}
                    
                    # print(i_[3],i_[2],info_)
                    
                    if i_[2] in ship_status_dep_[str(int(i_[3]))].keys():
                        ship_status_dep_[str(int(i_[3]))][i_[2]].append(info_)
                    else:
                        ship_status_dep_[str(int(i_[3]))][i_[2]] = [info_]
                        
            if commingled_:
                print('Commingled ship_status') 
                for k_, v_ in ship_status_dep_.items():
                    for k1_, v1_ in v_.items():
                        if len(v1_) > 1:
                            
                            if self.input.module in ['LOADABLE']:
                                parcel1_ = self.input.loadable.info['commingleCargo']['parcel1']
                                parcel2_ = self.input.loadable.info['commingleCargo']['parcel2']
                            elif self.input.module in ['LOADING']:
                                parcel1_ = self.input.loading.info['commingle']['parcel1']
                                parcel2_ = self.input.loading.info['commingle']['parcel2']
                                
                                
                            
                            parcel_ = [v1_[0]['parcel'], v1_[1]['parcel']]
                            
                            onboard_ = self.input.vessel.info['onboard'].get(k1_,{}).get('wt',0.)
                            # temperature_ = self.input.loadable.info['commingleCargo']['temperature']
                            
                            wt1_ = sum([vv_['wt'] for vv_ in v1_ if vv_['parcel'] == parcel1_]) - onboard_
                            wt2_ = sum([vv_['wt'] for vv_ in v1_ if vv_['parcel'] == parcel2_]) - onboard_
                            
                            weight_ = wt1_ + wt2_ + onboard_
                            
                            capacity_ = self.input.vessel.info['cargoTanks'][k1_]['capacityCubm']
                            
                            wt__ = [wt1_,wt2_]
                            
                            if self.input.module in ['LOADABLE']:
                                api__ = [self.input.loadable.info['commingleCargo']['api1'], self.input.loadable.info['commingleCargo']['api2']]
                                temp__ = [self.input.loadable.info['commingleCargo']['t1'], self.input.loadable.info['commingleCargo']['t2']]
                            elif self.input.module in ['LOADING']:
                                api__ = [self.input.loading.info['commingle']['api1'], self.input.loading.info['commingle']['api2']]
                                temp__ = [self.input.loading.info['commingle']['t1'], self.input.loading.info['commingle']['t2']]
                       
                                
                            api_, temp_ = self._get_commingleAPI(api__, wt__, temp__)
                            
                            if self.input.module in ['LOADABLE']:
                                density_ = self.input.loadable._cal_density(round(api_,2), round(temp_,1))
                            elif self.input.module in ['LOADING']:
                                density_ = self.input.loading._cal_density(round(api_,2), round(temp_,1))
                                
                            vol_ = weight_/density_ 
                            vol1_ = wt1_/density_ 
                            vol2_ = wt2_/density_ 
                            
                            fillingRatio_ = round(vol_/capacity_,DEC_PLACE)
                            print(parcel1_,parcel2_, k1_, fillingRatio_, round(wt1_/(wt1_+wt2_),2), round(wt2_/(wt1_+wt2_),2), round(api_,2), round(temp_,1), density_, round(weight_,3))
                            
                            # re-run once only
                            # print(self.commingled_ratio)
                            if (fillingRatio_ > 0.98 or fillingRatio_ < 0.98) and self.input.module in ['LOADABLE'] and self.input.mode in ['Auto'] and len(self.commingled_ratio) == 0:
                                print('Need to regenerate commingle plans!!')
                                self.commingled_ratio = {parcel1_:round(wt1_/(wt1_+wt2_),2), 
                                                         parcel2_:round(wt2_/(wt1_+wt2_),2)}
                                self.commingled_temp = {parcel1_:self.input.loadable.info['commingleCargo']['t1'], 
                                                         parcel2_:self.input.loadable.info['commingleCargo']['t2']}
                                
                                return
                                
                                
                                
                                
                            tcg_ = 0.
                            if k1_ in self.input.vessel.info['tankTCG']['tcg']:
                                tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][k1_]['vol'],
                                                 self.input.vessel.info['tankTCG']['tcg'][k1_]['tcg'])
                                
                            lcg_ = 0.
                            if k1_ in self.input.vessel.info['tankLCG']['lcg']:
                                lcg_ = np.interp(vol_, self.input.vessel.info['tankLCG']['lcg'][k1_]['vol'],
                                                 self.input.vessel.info['tankLCG']['lcg'][k1_]['lcg'])
                                
                            
                            tankId_ = self.input.vessel.info['tankName'][k1_]
                            corrUllage_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist(), 6)
                            corrUllage1_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol1_).tolist(), 6)
                            corrUllage2_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol2_).tolist(), 6)

                                  
                            info_ = {'parcel':parcel_, 'wt': round(weight_,3), 'SG': round(density_,4),
                                     'fillRatio': fillingRatio_, 'tcg':tcg_,  'lcg':lcg_,
                                     'temperature':round(temp_,2),
                                     'api':api_,
                                     'wt1':wt1_, 'wt2':wt2_,
                                     'wt1percent':wt1_/(wt1_+wt2_), 'wt2percent':wt2_/(wt1_+wt2_),
                                     'corrUllage':corrUllage_,
                                     'maxTankVolume':capacity_,
                                     'vol':vol_, 'vol1':vol1_, 'vol2':vol2_,
                                     'corrUllage1':corrUllage1_,'corrUllage2':corrUllage2_}
                            
                            # print(info_)
                            
                            ship_status_dep_[k_][k1_] = [info_]
                            
                            # if self.input.mode in ['Auto'] and p_ == 0 and not self.full_load and (fillingRatio_ < 0.98) and abs(self.input.loadable.info['commingleCargo']['temperature'] - temp_) > 0.5:
                            #     self.rerun = True
                            #     self.input.commingle_temperature = temp_
                                # return
                            
                            # print(density_,api_)
                    
                            # print(v1_[0]['wt']/v1_[0]['SG'], v1_[1]['wt']/v1_[1]['SG'], weight_/density_)
                            
            for k_, v_ in self.input.vessel.info['onboard'].items():
                if k_ not in ['totalWeight']:
                    print(k_, 'empty with onboard', v_)
                    wt_ = round(v_['wt'] ,DEC_PLACE) 
                    density_ = round(v_['wt']/v_['vol1'], 4)
                    capacity_ = self.input.vessel.info['cargoTanks'][k_]['capacityCubm']
                    vol_ = v_['vol1']
                    
                    tcg_ = 0.
                    if k_ in self.input.vessel.info['tankTCG']['tcg']:
                        tcg_ = np.interp(wt_/density_, self.input.vessel.info['tankTCG']['tcg'][k_]['vol'],
                                         self.input.vessel.info['tankTCG']['tcg'][k_]['tcg'])
                    
                    lcg_ = 0.
                    if k_ in self.input.vessel.info['tankLCG']['lcg']:
                        lcg_ = np.interp(wt_/density_, self.input.vessel.info['tankLCG']['lcg'][k_]['vol'],
                                         self.input.vessel.info['tankLCG']['lcg'][k_]['lcg'])
                    
                    
                    
                    tankId_ = self.input.vessel.info['tankName'][k_]
                    corrUllage_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist(), 6)

                        
                    info_ = {'parcel':'onboard', 'wt': wt_, 'SG': density_,
                             'fillRatio': round(v_['vol']/capacity_,DEC_PLACE), 'tcg':tcg_, 'lcg':lcg_, 
                             'temperature':None,
                             'corrUllage': corrUllage_,
                             'maxTankVolume': capacity_,
                             'vol':vol_}
                    
                    for k1_, v1_ in ship_status_dep_.items():
                        if not v1_.get(k_, []):
                            ship_status_dep_[k1_][k_] = [info_]
                    
                        
                        
                       
            # ballast status: departure/arrive for loading/discharging port       
            if hasattr(self.input.loadable, "info"):
                ballast_weight_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
                # tot_ballast_vol_ = {str(pp_):0. for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
                
            else:
                ballast_weight_ = {str(pp_):{} for pp_ in range(0,self.input.loadable['lastVirtualPort']+1)}
#                tot_ballast_vol_ = {str(pp_):0. for pp_ in range(0,self.input.loadable['lastVirtualPort']+1)} 
                
            
            if hasattr(self.input, "mode") and self.input.mode in ['FullManual']:
                
                for k_, v_ in self.input.loadable.info['ballastOperation'].items():
                    for v__ in v_:
                        tank_ = self.input.vessel.info['tankId'][int(v__['tankId'])]
                        density_ = 1.025
                        capacity_ =  self.input.vessel.info['ballastTanks'][tank_]['capacityCubm']
                        wt_ = v__['wt']
                        vol_ = wt_/density_
                        
                        tcg_ = 0.
                        if tank_ in self.input.vessel.info['tankTCG']['tcg']:
                            tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][tank_]['vol'],
                                              self.input.vessel.info['tankTCG']['tcg'][tank_]['tcg'])
                            
                        lcg_ = 0.
                        if tank_ in self.input.vessel.info['tankLCG']['lcg']:
                            lcg_ = np.interp(vol_, self.input.vessel.info['tankLCG']['lcg'][tank_]['vol'],
                                              self.input.vessel.info['tankLCG']['lcg'][tank_]['lcg'])
                        
                        tankId_ = v__['tankId']    
                        try:
                            corrLevel_ = self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist()
                        except:
                            print('correct level not available:',i_[1], vol_)
                            corrLevel_ = 0.
                        
                        ballast_weight_[k_][tank_] = [{'wt': round(wt_,DEC_PLACE), 'SG':density_,
                                                          'fillRatio': round(v__['wt']/density_/capacity_,DEC_PLACE),
                                                          'tcg':tcg_, 'lcg':lcg_, 
                                                          'corrLevel':round(corrLevel_,3),
                                                          'maxTankVolume':capacity_,
                                                          'vol':vol_}]
                
                
            
            else:
                    
                for i_ in result['ballast_weight']: # (1.0, 'FPTL', 1.0, 5580.1)
                    if int(i_[0]) == (p_+1) and round(i_[3],DEC_PLACE) >= 1:
                        # port_ = self.input.loadable.info['virtualArrDepPort'][str(int(i_[2]))][:-1]
                        # portName_ = self.input.port.info['portOrder'][str(port_)]
                        density_ = 1.025
                        #density_ = self.input.port.info['portRotation'][portName_]['seawaterDensity']
                        capacity_ =  self.input.vessel.info['ballastTanks'][i_[1]]['capacityCubm']
                        wt_ = i_[3]
                        vol_ = wt_/density_
                        
                        
                        tcg_ = 0.
                        if i_[1] in self.input.vessel.info['tankTCG']['tcg']:
                            tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][i_[1]]['vol'],
                                             self.input.vessel.info['tankTCG']['tcg'][i_[1]]['tcg'])
                            
                        lcg_ = 0.
                        if i_[1] in self.input.vessel.info['tankLCG']['lcg']:
                            lcg_ = np.interp(vol_, self.input.vessel.info['tankLCG']['lcg'][i_[1]]['vol'],
                                             self.input.vessel.info['tankLCG']['lcg'][i_[1]]['lcg'])
                            
                            
                        tankId_ = self.input.vessel.info['tankName'][i_[1]]     
                        try:
                            corrLevel_ = self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist()
                        except:
                            print('correct level not available:',i_[1], vol_)
                            corrLevel_ = 0.
                        
                    
                        ballast_weight_[str(int(i_[2]))][i_[1]] = [{'wt': round(wt_,DEC_PLACE), 
                                                          'SG':density_,
                                                          'fillRatio': round(i_[3]/density_/capacity_,DEC_PLACE),
                                                          'tcg':tcg_, 'lcg':lcg_,
                                                          'corrLevel':round(corrLevel_,3),
                                                          'maxTankVolume':capacity_,
                                                          'vol':vol_}]
                                                   
                        # if k_ not in [str(self.input.port.info['numPort'])+'D']:
                        #     ship_status_[k_]['other'][i_]  = [{'wt': round(v_['wt'],DEC_PLACE), 
                        #                                   'SG':round(v_['wt']/max(1.0,v_['vol']),DEC_PLACE),
                        #                                   'tcg':v_['tcg']}]
            
            
            
            
            
            self.ship_status_dep.append(ship_status_dep_)       
            self.ballast_weight.append(ballast_weight_)       
            self.commingled = commingled_
            
            
            cargo_in_tank_, max_tank_used_ = {}, 0
            # print(p_,'--------------------------------------------------------')
            
            if hasattr(self.input.loadable, "info"):
                parcel_ = self.input.loadable.info['parcel']
            else:
                parcel_ = self.input.loadable['parcel']
            
            for k_, v_ in parcel_.items():
                tanks_ = [i_  for i_,j_ in tank_cargo_.items() if k_ in j_]
                # print(k_,tanks_)
                cargo_in_tank_[k_] = tanks_
                if len(tanks_) > max_tank_used_:
                    max_tank_used_ = len(tanks_)
                    self.max_tank_parcel = k_
                    
            self.cargo_in_tank.append(cargo_in_tank_)
            
            if self.input.module in ['LOADABLE']:
            
                load_param = {'Manifolds':[1,2,3],
                         'centreTank':[],
                         'wingTank': [],
                         'slopTank': [],
                         'BottomLines': [1,2,3]
                        }
                
                loading_rate_, topping_ = {}, {}
                for k_, v_ in cargo_in_tank_.items():
                    load_param['centreTank'], load_param['wingTank'], load_param['slopTank'] = [], [], []
                    tank_num_ = 0
                    for t_ in v_:
                        if t_[-1] in ['C']:
                            load_param['centreTank'].append(t_)
                            tank_num_ += 1
                        elif t_ in ['SLS','SLP']:
                            load_param['slopTank'].append(t_)
                            tank_num_ += 1
                        else:
                            load_param['wingTank'].append(t_)
                            tank_num_ += 1
                    
                    if tank_num_ == 1:
                        add_ = 0.5
                    elif tank_num_ == 2:
                        add_ = 1.0
                    else:
                        add_ = 1.5
                    loading_rate_[k_] = (self._cal_max_rate(load_param), add_)
                    topping_[k_] = self._topping_seq(v_)
                    
                self.loading_rate.append(loading_rate_)
                self.topping_seq.append(topping_)
                    
                
        if self.input.module in ['LOADABLE', 'DISCHARGE']:
            # add ROB    
            other_weight_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
            for i_, j_ in self.input.vessel.info['onhand'].items():
                for k_, v_ in j_.items():
                    info_ =  [{'wt': round(v_['wt'],DEC_PLACE), 
                               'SG':round(v_['wt']/max(1.0,v_['vol']),DEC_PLACE),
                               'tcg':v_['tcg'], 'lcg':v_['lcg'], 'vol': v_['vol']}]
            
                    for k1_, v1_ in self.input.loadable.info['virtualArrDepPort'].items():
                        if v1_ == k_:
                            other_weight_[k1_][i_] =  info_
                            
            self.other_weight = other_weight_
            
        elif self.input.module in ['LOADING']:
            # initial ROB
            
            # info_ = [{'wt': wt_, 'SG':density_, "vol":vol_, 'tcg':tcg_, 'lcg':lcg_}]
            initial_ROB_ = {}
            for k_, v_ in self.input.loading.info['ROB'][0].items():
                info_ = {}
                info_['wt'] = v_[0]['quantityMT']
                info_['vol'] = v_[0]['quantityM3']
                info_['SG'] = round(v_[0]['quantityMT']/v_[0]['quantityM3'],2)
                info_['tcg'] = v_[0]['tcg']
                info_['lcg'] = v_[0]['lcg']
                
                initial_ROB_[k_] = [info_]
                
            
            # final ROB
            final_ROB_ = {}
            for k_, v_ in self.input.loading.info['ROB'][1].items():
                info_ = {}
                info_['wt'] = v_[0]['quantityMT']
                info_['vol'] = v_[0]['quantityM3']
                info_['SG'] = round(v_[0]['quantityMT']/v_[0]['quantityM3'],2)
                info_['tcg'] = v_[0]['tcg']
                info_['lcg'] = v_[0]['lcg']
                
                final_ROB_[k_] = [info_]
            
            other_weight_ = {}
            for pp_ in range(0,self.input.loadable['lastVirtualPort']+1):
                other_weight_[str(pp_)] = {}
                
                if pp_ == 0:
                    other_weight_[str(pp_)] = initial_ROB_
                else:
                    other_weight_[str(pp_)] = final_ROB_
            
           
            self.other_weight = other_weight_
            
        elif self.input.module in ['DISCHARGING']:
            # initial ROB
            
            # info_ = [{'wt': wt_, 'SG':density_, "vol":vol_, 'tcg':tcg_, 'lcg':lcg_}]
            initial_ROB_ = {}
            for k_, v_ in self.input.info['ROB'][0].items():
                info_ = {}
                info_['wt'] = v_[0]['quantityMT']
                info_['vol'] = v_[0]['quantityM3']
                info_['SG'] = round(v_[0]['quantityMT']/v_[0]['quantityM3'],2)
                info_['tcg'] = v_[0]['tcg']
                info_['lcg'] = v_[0]['lcg']
                
                initial_ROB_[k_] = [info_]
                
            
            # final ROB
            final_ROB_ = {}
            for k_, v_ in self.input.info['ROB'][1].items():
                info_ = {}
                info_['wt'] = v_[0]['quantityMT']
                info_['vol'] = v_[0]['quantityM3']
                info_['SG'] = round(v_[0]['quantityMT']/v_[0]['quantityM3'],2)
                info_['tcg'] = v_[0]['tcg']
                info_['lcg'] = v_[0]['lcg']
                
                final_ROB_[k_] = [info_]
            
            other_weight_ = {}
            for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1):
                other_weight_[str(pp_)] = {}
                
                if pp_ == 0:
                    other_weight_[str(pp_)] = initial_ROB_
                else:
                    other_weight_[str(pp_)] = final_ROB_
            
           
            self.other_weight = other_weight_
            
            
            
        self.initial_cargo_weight = {}
        if self.input.module in ['LOADABLE', 'DISCHARGE']:
            
            for  k_, v_ in self.input.loadable.info['preloadOperation'].items():
                density_ = self.input.loadable.info['parcel'][k_]['maxtempSG']
                temp_ = self.input.loadable.info['parcel'][k_]['temperature']
                api_ = self.input.loadable.info['parcel'][k_]['api']
                for k1_, v1_ in v_.items():
                    
                    tankId_ = self.input.vessel.info['tankName'][k1_]
                    vol_ = v1_/density_
                    
                    tcg_data_ = self.input.vessel.info['tankTCG']['tcg'][k1_] # tcg_data
                    lcg_data_ = self.input.vessel.info['tankLCG']['lcg'][k1_] # lcg_data
                    
                    tcg_ = np.interp(vol_, tcg_data_['vol'], tcg_data_['tcg'])
                    lcg_ = np.interp(vol_, lcg_data_['vol'], lcg_data_['lcg'])
                    
                    corrUllage_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist(), 6)
                    
                    fr_ = round(vol_/self.input.vessel.info['cargoTanks'][k1_]['capacityCubm'], DEC_PLACE)
                    
                    info_ = {'parcel':k_, 'wt': round(v1_,1), 'SG': density_,
                                     'fillRatio': fr_, 'tcg':tcg_,  'lcg':lcg_,
                                     'temperature':temp_,
                                     'api':api_,
                                     'corrUllage':corrUllage_
                                     }
                    
                    self.initial_cargo_weight[k1_] = [info_]
            
            # add onboard
            for k_, v_ in self.ship_status_dep[0]['0'].items():
                self.initial_cargo_weight[k_] = v_
                
                    
                    
        elif self.input.module in ['DISCHARGING']:
                         
            for k_, v_ in self.input.info['cargo_plans'][0].items():
                
                tankId_ = self.input.vessel.info['tankName'][k_]
                
                if len(v_) == 1:
                    vol_ = v_[0]['quantityM3']
                    corrUllage_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist(), 6)
                    
                    info_ = {'parcel':v_[0]['cargo'], 'wt': round(v_[0]['quantityMT'],1), 'SG': v_[0]['SG'],
                                         'fillRatio': None, 'tcg':v_[0]['tcg'],  'lcg':v_[0]['lcg'],
                                         'temperature':v_[0]['temperature'],
                                         'api':v_[0]['api'],
                                         'corrUllage':corrUllage_
                                         }
                    
                    self.initial_cargo_weight[k_] = [info_]
                
                else:
                    exit()
                    
                
        elif self.input.module in ['LOADING']:
            
            for k_, v_ in self.input.loading.info['cargo_plans'][0].items():
                
                tankId_ = self.input.vessel.info['tankName'][k_]
                
                if len(v_) == 1:
                    vol_ = v_[0]['quantityM3']
                    corrUllage_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist(), 6)
                    
                    info_ = {'parcel':v_[0]['cargo'], 'wt': round(v_[0]['quantityMT'],1), 'SG': v_[0]['SG'],
                                         'fillRatio': None, 'tcg':v_[0]['tcg'],  'lcg':v_[0]['lcg'],
                                         'temperature':v_[0]['temperature'],
                                         'api':v_[0]['api'],
                                         'corrUllage':corrUllage_
                                         }
                    
                    self.initial_cargo_weight[k_] = [info_]
                
                else:
                    
                    parcel1_ = v_[0]['cargo']
                    parcel2_ = v_[1]['cargo']
                    parcel_ = [parcel1_, parcel2_]
                            
                    onboard_ = self.input.vessel.info['onboard'].get(k_,{}).get('wt',0.)
                    # temperature_ = self.input.loadable.info['commingleCargo']['temperature']
                    
                    wt1_ = sum([vv_['quantityMT'] for vv_ in v_ if vv_['cargo'] == parcel1_]) - onboard_
                    wt2_ = sum([vv_['quantityMT'] for vv_ in v_ if vv_['cargo'] == parcel2_]) - onboard_
                    
                    weight_ = wt1_ + wt2_ + onboard_
                    
                    capacity_ = self.input.vessel.info['cargoTanks'][k_]['capacityCubm']
                    
                    wt__ = [wt1_,wt2_]
                    
                    
                    api__ = [self.input.loading.info['commingle']['api1'], self.input.loading.info['commingle']['api2']]
                    temp__ = [self.input.loading.info['commingle']['t1'], self.input.loading.info['commingle']['t2']]
               
                        
                    api_, temp_ = self._get_commingleAPI(api__, wt__, temp__)
                    
                    density_ = self.input.loading._cal_density(round(api_,2), round(temp_,1))
                        
                    vol_ = weight_/density_ 
                    vol1_ = wt1_/density_
                    vol2_ = wt2_/density_
                    
                    fillingRatio_ = round(vol_/capacity_,DEC_PLACE)
                    print(parcel1_,parcel2_, k1_, fillingRatio_, round(wt1_/(wt1_+wt2_),2), round(wt2_/(wt1_+wt2_),2), round(api_,2), round(temp_,1), density_, round(weight_,3))
                    
                        
                        
                    tcg_ = 0.
                    if k_ in self.input.vessel.info['tankTCG']['tcg']:
                        tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][k_]['vol'],
                                         self.input.vessel.info['tankTCG']['tcg'][k_]['tcg'])
                        
                    lcg_ = 0.
                    if k_ in self.input.vessel.info['tankLCG']['lcg']:
                        lcg_ = np.interp(vol_, self.input.vessel.info['tankLCG']['lcg'][k_]['vol'],
                                         self.input.vessel.info['tankLCG']['lcg'][k_]['lcg'])
                        
                    
                    tankId_ = self.input.vessel.info['tankName'][k1_]
                    corrUllage_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist(), 6)
                    
                    corrUllage1_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol1_).tolist(), 6)
                    corrUllage2_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol2_).tolist(), 6)
                    
                          
                    info_ = {'parcel':parcel_, 'wt': round(weight_,3), 'SG': round(density_,4),
                             'fillRatio': fillingRatio_, 'tcg':tcg_,  'lcg':lcg_,
                             'temperature':round(temp_,2),
                             'api':api_,
                             'wt1':wt1_, 'wt2':wt2_,
                             'wt1percent':wt1_/(wt1_+wt2_), 'wt2percent':wt2_/(wt1_+wt2_),
                             'corrUllage':corrUllage_,
                             'maxTankVolume':capacity_,
                             'vol':vol_, 'vol1':vol1_, 'vol2':vol2_, 
                             'corrUllage1':corrUllage1_,'corrUllage2':corrUllage2_}
                    
                    self.initial_cargo_weight[k_] = [info_]
                    
            
            
        if self.input.module not in ['LOADING']:
                                
            initial_ballast_weight_ = {} 
            density_ = 1.025
            # add ballast for first arrival port
            for i_, j_ in self.input.vessel.info['initBallast']['wt'].items():
                
                capacity_ =  self.input.vessel.info['ballastTanks'][i_]['capacityCubm']
                wt_ = j_
                vol_ = wt_/density_
                
                tcg_ = 0.
                if i_ in self.input.vessel.info['tankTCG']['tcg']:
                    tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][i_]['vol'],
                                          self.input.vessel.info['tankTCG']['tcg'][i_]['tcg'])
                
                lcg_ = 0.
                if i_ in self.input.vessel.info['tankLCG']['lcg']:
                    lcg_ = np.interp(vol_, self.input.vessel.info['tankLCG']['lcg'][i_]['vol'],
                                          self.input.vessel.info['tankLCG']['lcg'][i_]['lcg'])
                    
                tankId_ = self.input.vessel.info['tankName'][i_]     
                try:
                    corrLevel_ = self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist()
                except:
                    print(i_, vol_, ': correctLevel not available!!')
                    corrLevel_ = 0.
                
                initial_ballast_weight_[i_] = [{'wt': round(wt_,DEC_PLACE),
                                                'SG':density_,
                                                'fillRatio': round(j_/density_/capacity_,DEC_PLACE),
                                                'tcg':tcg_, 'lcg':lcg_,
                                                'corrLevel':round(corrLevel_,3),
                                                'maxTankVolume':capacity_,
                                                'vol':vol_}]
            self.initial_ballast_weight = initial_ballast_weight_
            
        else:
            
            self.initial_ballast_weight = {}
            for k_, v_ in self.input.loading.info['ballast'][0].items():
                info_ = {}
                info_['wt'] = v_[0]['quantityMT']
                info_['vol'] = v_[0]['quantityM3']
                info_['SG'] = 1.025
                info_['tcg'] = v_[0]['tcg']
                info_['lcg'] = v_[0]['lcg']
                
                tankId_ = self.input.vessel.info['tankName'][k_]     
                try:
                    corrLevel_ = self.input.vessel.info['ullage'][str(tankId_)](float(info_['vol'])).tolist()
                except:
                    print(k_, vol_, ': correctLevel not available!!')
                    corrLevel_ = 0.
                info_['corrLevel'] = round(corrLevel_,3)
                
                self.initial_ballast_weight[k_] = [info_]
                
                
                
            
    def _process_checking_plans(self, result):
        
        ## still in virtual port 
        for p_ in range(self.num_plans):
            ship_status_dep_ = self.ship_status_dep[p_]
            ballast_weight_ = self.ballast_weight[p_]
            
            # switch from departure only to departure/arrive for loading/discharging port
            ship_status_, cargo_status_ = {}, {}
            
            if hasattr(self.input.loadable, "info"):
                port_ = self.input.loadable.info['lastVirtualPort']
            else:
                port_ = self.input.loadable['lastVirtualPort']
                
            
            for i_ in range(0, port_+1):
                
                if i_ == port_ and self.input.module not in ['LOADING', 'DISCHARGE','DISCHARGING']:
                    break
                
                ship_status_[str(i_)] = {'cargo':{},'ballast':{},'other':{}}
                if i_ == 0:
                    ship_status_[str(i_)]['ballast'] = self.initial_ballast_weight
                    ship_status_[str(i_)]['cargo'] = self.initial_cargo_weight
                else:
                    ship_status_[str(i_)]['ballast'] = ballast_weight_[str(i_)]
                    ship_status_[str(i_)]['cargo'] = ship_status_dep_[str(i_)]
                
                ship_status_[str(i_)]['other'] = self.other_weight[str(i_)]
                
                cargo_status_[str(i_)] = {k_[1]:round(k_[3],3) for k_  in result['cargo_loaded_port'] if k_[0] == p_+1 and k_[2] == i_}
                
                
            self.plans['ship_status'].append(ship_status_)
            self.plans['cargo_status'].append(cargo_status_)
            self.plans['obj'].append(round(result['obj'][p_][1],3))
            
            ##--------------------------------------------------------------
            slop_qty_ = {}
            
            for k_, v_ in ship_status_[str(port_-1)]['cargo'].items():
                if k_ in ['SLS', 'SLP']:
                    if v_[0]['parcel'] not in slop_qty_.keys():
                        slop_qty_[v_[0]['parcel']]  = 0.
                        
                    slop_qty_[v_[0]['parcel']] += v_[0]['wt']
            self.plans['slop_qty'].append(slop_qty_)
            ##--------------------------------------------------------------
            
            if hasattr(self.input.loadable, "info") and self.input.module in ['LOADABLE']:
                self.plans['cargo_order'].append(self.input.loadable.info['cargoOrder'])
            
            ##--------------------------------------------------------------- 
                cargo_ = cargo_status_[str(self.input.loadable.info['lastVirtualPort']-1)]
                loading_hrs_ = {}
                for k_, v_ in cargo_.items():
                    loading_hrs_[k_] = (v_/self.input.loadable.info['parcel'][k_]['SG']/self.loading_rate[p_][k_][0],
                                        self.loading_rate[p_][k_][1])
                
                self.plans['loading_hrs'].append(loading_hrs_)
                                    
            
        
        self.plans['cargo_tank'] = self.cargo_in_tank
        self.plans['topping'] = self.topping_seq
        self.plans['loading_rate'] = self.loading_rate
            
            
            # if self.input.loadable.info['rotationCargo']:
            #     self.plan['constraint'].append({str(self.input.loadable.info['rotationCargo']):'ok'})
            
        
        # with open('ship_status.json', 'w') as fp:
        #     json.dump(self.plan['ship_status'], fp)            
                    
    
            
    def _get_commingleAPI(self, api, weight, temp):
        weight_api_ , weight_temp_ = 0., 0.
        
        sg60_ = [141.5/(a_+131.5) for a_ in api]
        t13_ = [(535.1911/(a_+131.5)-0.0046189)*0.042 for a_ in api]
        vol_bbls_60_ = [w_/t_ for (w_,t_) in zip(weight,t13_)]
        
        weight_sg60_ = sum([v_*s_ for (v_,s_) in zip(vol_bbls_60_,sg60_)])/sum(vol_bbls_60_)
        weight_api_ = 141.5/weight_sg60_ - 131.5
        
        weight_temp_ = sum([v_*s_ for (v_,s_) in zip(vol_bbls_60_,temp)])/sum(vol_bbls_60_)
        
        return weight_api_, weight_temp_
    
    ## for DISCHARGING 
    def gen_json3(self, constraints, stability_values):
        
        
        EVENTS = ["initialCondition", "floodSeparator", "warmPumps",
                  "initialRate", "increaseToMaxRate", "dischargingAtMaxRate", 
                  "reducedRate"]
        
        data = {}
        data['message'] = None
        data['processId'] = self.input.process_id
        data['portId'] = self.input.port_id
        data['dischargingInfoId'] = self.input.information_id
        data['hasLoadicator'] = self.input.has_loadicator
        
        # self.plans['ship_status'] = []
        
        if len(self.plans['ship_status']) == 0:
            
            data['message'] = {**self.input.error, **self.plans['message']}
            data['errors'] = self._format_errors(data['message'])
            
            return data
        
        discharging_seq = Discharging_seq(self, stability_values)
        # loading_seq._get_ballast()
        # events
        data["events"] = []
        
        for c__, c_ in enumerate(self.input.discharging.info['discharging_order']):
            print(c_)
            info_ = {}
            info_["dsCargoNominationId"] = int(c_[1:])
            cargo_ = self.input.discharging.info['dsCargoNominationId'][c_]
            info_["cargoNominationId"] = int(cargo_[1:])
            info_["sequence"] = []
            first_cargo_ = c__ == 0
            
            
            
            for e__, e_ in enumerate(EVENTS):
                info1_ = {"stage": e_}
                discharging_seq._stage(info1_, cargo_+str(c__), c__+1)
                
                if e_ == 'initialCondition' and first_cargo_:
                    self.gTimeStart = int(info1_['timeStart'])
                
                
                if e_ in ['dischargingAtMaxRate']:
                    for d__, d_ in enumerate(info_['sequence'][1:]):
                        # print(d_['stage'])
                        info_['sequence'][d__+1]['deballastingRateM3_Hr'] = info1_.get('iniDeballastingRateM3_Hr', {})
                        info_['sequence'][d__+1]['ballastingRateM3_Hr'] = info1_.get('iniBallastingRateM3_Hr', {})
                        
                        info2_ = {'simIniDeballastingRateM3_Hr': deepcopy(info1_.get('simIniDeballastingRateM3_Hr', {})),
                                  'simIniBallastingRateM3_Hr': deepcopy(info1_.get('simIniBallastingRateM3_Hr', {}))}
                        
                        # if len(info2_['simIniDeballastingRateM3_Hr']) > 0:
                        for k_, v_ in info2_['simIniDeballastingRateM3_Hr'].items():
                            info2_['simIniDeballastingRateM3_Hr'][k_]['timeStart'] = info_['sequence'][d__+1]['timeStart']
                            info2_['simIniDeballastingRateM3_Hr'][k_]['timeEnd'] = info_['sequence'][d__+1]['timeEnd']
                            
                        for k_, v_ in info2_['simIniBallastingRateM3_Hr'].items():
                            info2_['simIniBallastingRateM3_Hr'][k_]['timeStart'] = info_['sequence'][d__+1]['timeStart']
                            info2_['simIniBallastingRateM3_Hr'][k_]['timeEnd'] = info_['sequence'][d__+1]['timeEnd']
                             
                        
                        
                        # info2_['simIniDeballastingRateM3_Hr'][0]['timeStart'] = info_['sequence'][d__+1]['timeStart']
                        # info2_['simIniDeballastingRateM3_Hr'][0]['timeEnd'] = info_['sequence'][d__+1]['timeEnd']
                        
                        # info2_['simIniBallastingRateM3_Hr'][0]['timeStart'] = info_['sequence'][d__+1]['timeStart']
                        # info2_['simIniBallastingRateM3_Hr'][0]['timeEnd'] = info_['sequence'][d__+1]['timeEnd']
                            
                        info_['sequence'][d__+1]['simDeballastingRateM3_Hr'] = [info2_['simIniDeballastingRateM3_Hr']]
                        info_['sequence'][d__+1]['simBallastingRateM3_Hr'] = [info2_['simIniBallastingRateM3_Hr']]
                        
                        
                        # self._get_ballast(info_['sequence'][d__+1], info1_, first_cargo_)
                        
                        
                    
                    # self._get_ballast1(info1_, first_cargo_, c_)
                    
                    # print(info1_['stageEndTime'])
                    # self._get_eduction(info1_, c_)
                    
                    # print(info1_.keys())
                    info1_.pop('simIniDeballastingRateM3_Hr')
                    info1_.pop('simIniBallastingRateM3_Hr')
                    info1_.pop('iniDeballastingRateM3_Hr')
                    info1_.pop('iniBallastingRateM3_Hr')
                        
                
                
                info_["sequence"].append(info1_)
                
            data["events"].append(info_)
                
            
        
        data["plans"] = {'arrival':discharging_seq.initial_plan, 'departure':discharging_seq.final_plan}
        data["stages"] = discharging_seq.stages
        data["dischargingInformation"] = None #self.input.loading_information
        
        data['message'] = {'limits':self.input.limits}
        
            
        
        
        return data
    
    
    ## for LOADING
    def gen_json1(self, constraints, stability_values):
        
        
        EVENTS = ["initialCondition", "openSingleTank", "initialRate",
                  "openAllTanks", "increaseToMaxRate", "loadingAtMaxRate", 
                  "topping"]
        
        
        
        
        data = {}
        data['message'] = None
        data['processId'] = self.input.process_id
        data['portId'] = self.input.port_id
        data['loadingInfoId'] = self.input.information_id
        data['hasLoadicator'] = self.input.has_loadicator
        
        # data['user'] = self.input.user
        # data['role'] = self.input.role
        # data['hasLoadicator'] = self.input.has_loadicator
        
        if len(self.plans['ship_status']) == 0:
            
            data['message'] = {**self.input.error, **self.plans['message']}
            data['errors'] = self._format_errors(data['message'])
            
            return data
        
        loading_seq = Loading_seq(self, stability_values)
        # loading_seq._get_ballast()
        # events
        data["events"] = []
        
        for c__, c_ in enumerate(self.input.loading.info['loading_order']):
            print(c_)
            info_ = {}
            info_["cargoNominationId"] = int(c_[1:])
            info_["sequence"] = []
            first_cargo_ = c__ == 0
            
            for e__, e_ in enumerate(EVENTS):
                info1_ = {"stage": e_}
                loading_seq._stage(info1_, c_, c__+1)
                
                if e_ == 'initialCondition' and first_cargo_:
                    self.gTimeStart = int(info1_['timeStart'])
                
                
                if e_ in ['loadingAtMaxRate']:
                    for d__, d_ in enumerate(info_['sequence'][1:]):
                        # print(d_['stage'])
                        info_['sequence'][d__+1]['deballastingRateM3_Hr'] = info1_.get('iniDeballastingRateM3_Hr', {})
                        info_['sequence'][d__+1]['ballastingRateM3_Hr'] = info1_.get('iniBallastingRateM3_Hr', {})
                        
                        info2_ = {'simIniDeballastingRateM3_Hr': deepcopy(info1_.get('simIniDeballastingRateM3_Hr', {})),
                                  'simIniBallastingRateM3_Hr': deepcopy(info1_.get('simIniBallastingRateM3_Hr', {}))}
                        
                        # if len(info2_['simIniDeballastingRateM3_Hr']) > 0:
                        for k_, v_ in info2_['simIniDeballastingRateM3_Hr'].items():
                            info2_['simIniDeballastingRateM3_Hr'][k_]['timeStart'] = info_['sequence'][d__+1]['timeStart']
                            info2_['simIniDeballastingRateM3_Hr'][k_]['timeEnd'] = info_['sequence'][d__+1]['timeEnd']
                            
                        for k_, v_ in info2_['simIniBallastingRateM3_Hr'].items():
                            info2_['simIniBallastingRateM3_Hr'][k_]['timeStart'] = info_['sequence'][d__+1]['timeStart']
                            info2_['simIniBallastingRateM3_Hr'][k_]['timeEnd'] = info_['sequence'][d__+1]['timeEnd']
                             
                        
                        
                        # info2_['simIniDeballastingRateM3_Hr'][0]['timeStart'] = info_['sequence'][d__+1]['timeStart']
                        # info2_['simIniDeballastingRateM3_Hr'][0]['timeEnd'] = info_['sequence'][d__+1]['timeEnd']
                        
                        # info2_['simIniBallastingRateM3_Hr'][0]['timeStart'] = info_['sequence'][d__+1]['timeStart']
                        # info2_['simIniBallastingRateM3_Hr'][0]['timeEnd'] = info_['sequence'][d__+1]['timeEnd']
                            
                        info_['sequence'][d__+1]['simDeballastingRateM3_Hr'] = [info2_['simIniDeballastingRateM3_Hr']]
                        info_['sequence'][d__+1]['simBallastingRateM3_Hr'] = [info2_['simIniBallastingRateM3_Hr']]
                        
                        
                        self._get_ballast(info_['sequence'][d__+1], info1_, first_cargo_)
                        
                        
                    
                    self._get_ballast1(info1_, first_cargo_, c_)
                    
                    # print(info1_['stageEndTime'])
                    self._get_eduction(info1_, c_)
                    
                    # print(info1_.keys())
                    info1_.pop('simIniDeballastingRateM3_Hr')
                    info1_.pop('simIniBallastingRateM3_Hr')
                    info1_.pop('iniDeballastingRateM3_Hr')
                    info1_.pop('iniBallastingRateM3_Hr')
                        
                info_["sequence"].append(info1_)
                        
            
            data["events"].append(info_)
            
        
        data["plans"] = {'arrival':loading_seq.initial_plan, 'departure':loading_seq.final_plan}
        data["stages"] = loading_seq.stages
        data["loadingInformation"] = self.input.loading_information
        
        data['message'] = {'limits':self.input.limits}
        
        
        
        
        return data
    
    
    def _get_eduction(self, out, cargo):
        
        if self.input.loading.seq[cargo].get('eduction',()):
            # print(self.input.loading.seq[cargo]['eduction'])
            print(out['stageEndTime'])
            out['eduction'] = {}
            
            cur_stage_ = self.input.loading.seq[cargo]['eduction'][1]
            pre_stage_ = int(cur_stage_[10:]) - 1
            if pre_stage_ == 0:
                timeStart_ = int(out['timeStart'])
            else:
                pre_stage_ = 'MaxLoading' + str(pre_stage_)
                timeStart_ = out['stageEndTime'][pre_stage_]    
            
            timeStart_ += self.input.loading.seq[cargo]['eduction'][0]
            timeEnd_ = timeStart_ + self.input.loading.time_eduction - 60
            
            out['eduction']['timeStart'] = str(int(timeStart_))
            out['eduction']['timeEnd']   = str(int(timeEnd_))
            out['eduction']['tank'] = {self.input.vessel.info['tankName'][t_]:t_  for t_ in self.input.loading.info['eduction'] if t_ not in ['LFPT', 'FPT']}
            
            eduction_ = {}
            for p_ in self.input.loading.eduction_pump:
                id_ = str(self.input.vessel.info['vesselPumps']['ballastEductor'][p_]['pumpId'])
                eduction_[id_] = {}
                eduction_[id_]['pumpName'] = p_
                
            out['eduction']['pumpSelected'] = eduction_ #self.input.loading.eduction_pump
            
            # print(out['eduction'])
            
        
    
    def _get_ballast1(self, out, first_cargo, cargo):
        # pass
    
        timeStart_ = int(out['timeStart'])
        
        educt_ = self.input.loading.seq[cargo].get('eduction', (None,None))
        
        if educt_ not in [(None, None)]:
            ballast_time_ = educt_[0]
            eduction_stage_ = int(educt_[1][10:])
        else:
            eduction_stage_ = 10000
        
        for d__, d_ in enumerate(out['totDeballastingRateM3_Hr']):
            deballast_ = float(d_)
            
            if d__ < len(out['loadablePlanPortWiseDetails']):
                timeEnd_ = int(out['loadablePlanPortWiseDetails'][d__]['time'])
            else:
                timeEnd_ = int(out['timeEnd'])
                
            pump_ = self._get_pump(timeEnd_,first_cargo)    
            
            # print(d__+1, timeStart_, timeEnd_, pump_)
            
            
            if d__ == 0:
                out['ballast']['Gravity'] = []
                out['ballast']['BP1'] = []
                out['ballast']['BP2'] = []
                
            
            ## gravity
            end_gravity_ = pump_.get('Gravity', 0.)
            time_gr_ = end_gravity_ - timeStart_
            amt_ = deballast_* time_gr_/60.
            if time_gr_ > 0.:
                info_ = {'timeStart': str(timeStart_), 'timeEnd': str(end_gravity_),
                         "rateM3_Hr": str(round(deballast_,2)),
                         "quantityM3": str(round(amt_))}
            else:
                info_ = {'timeStart': str(timeStart_), 'timeEnd': str(timeEnd_),
                         "rateM3_Hr": str("0.00"),
                         "quantityM3": str(0)}
                
            out['ballast']['Gravity'].append(info_)
            
            ## pump 1 ----------------------------------------------------
            timeStart1_ = timeStart_ if time_gr_ < 0 else end_gravity_ 
            end_bp1_ = pump_.get('BP1', 0.)
            
            if eduction_stage_ == d__+1:
                timeEnd1_ = timeStart1_ + ballast_time_
            else:
                timeEnd1_ = timeEnd_
            
            time_ = min(timeEnd1_, end_bp1_) - timeStart1_
            amt_ = deballast_/self.input.loading.num_pump* time_/60.
            
            
            ## patch empty slots
            if len(out['ballast']['BP1']) > 0:
                pre_ = int(out['ballast']['BP1'][-1]['timeEnd'])
                
                if pre_ < timeStart1_:
                    info_ = {'timeStart': str(pre_), 'timeEnd': str(timeStart1_),
                             "rateM3_Hr": str("0.00"),
                             "quantityM3": str(0)}
                    
                    if info_ not in out['ballast']['BP1']:
                        out['ballast']['BP1'].append(info_)
                
            
            
            # print('BP', time_)
            
            if time_ > 0.:
                info_ = {'timeStart': str(timeStart1_), 'timeEnd': str(timeEnd1_),
                         "rateM3_Hr": str(round(deballast_/self.input.loading.num_pump,2)),
                         "quantityM3": str(round(amt_))}
            else:
                info_ = {'timeStart': str(timeStart_), 'timeEnd': str(timeEnd_),
                         "rateM3_Hr": str("0.00"),
                         "quantityM3": str(0)}
                
            if info_ not in out['ballast']['BP1']:
                out['ballast']['BP1'].append(info_)
            
            if timeEnd1_ < timeEnd_:
                
                info_ = {'timeStart': str(timeEnd1_), 'timeEnd': str(timeEnd_),
                         "rateM3_Hr": str("0.00"),
                         "quantityM3": str(0)}
                
                if info_ not in out['ballast']['BP1']:
                    out['ballast']['BP1'].append(info_)
            
            if self.input.loading.num_pump > 1:
            ## pump 2 ----------------------------------------------------
                timeStart2_ = timeStart_ if time_gr_ < 0 else end_gravity_ 
                end_bp2_ = pump_.get('BP2', 0.)
                
                if eduction_stage_ == d__+1:
                    timeEnd2_ = timeStart2_ + ballast_time_
                else:
                    timeEnd2_ = timeEnd_
                
                time_ = min(timeEnd2_, end_bp2_) - timeStart2_
                amt_ = deballast_/self.input.loading.num_pump* time_/60.
                
                
                ## patch empty slots
                if len(out['ballast']['BP2']) > 0:
                    pre_ = int(out['ballast']['BP2'][-1]['timeEnd'])
                    
                    if pre_ < timeStart2_:
                        info_ = {'timeStart': str(pre_), 'timeEnd': str(timeStart2_),
                                 "rateM3_Hr": str("0.00"),
                                 "quantityM3": str(0)}
                        if info_ not in out['ballast']['BP2']:
                            out['ballast']['BP2'].append(info_)
                    
                
                
                if time_ > 0.:
                    info_ = {'timeStart': str(timeStart2_), 'timeEnd': str(timeEnd2_),
                             "rateM3_Hr": str(round(deballast_/self.input.loading.num_pump,2)),
                             "quantityM3": str(round(amt_))}
                else:
                    info_ = {'timeStart': str(timeStart_), 'timeEnd': str(timeEnd_),
                             "rateM3_Hr": str("0.00"),
                             "quantityM3": str(0)}
                
                if info_ not in out['ballast']['BP2']:
                    out['ballast']['BP2'].append(info_)
                
                if timeEnd2_ < timeEnd_:
                    info_ = {'timeStart': str(timeEnd2_), 'timeEnd': str(timeEnd_),
                             "rateM3_Hr": str("0.00"),
                             "quantityM3": str(0)}
                    
                    if info_ not in out['ballast']['BP2']:
                        out['ballast']['BP2'].append(info_)
            
            timeStart_ = timeEnd_
            
        ## change ballast name to ballastId
        if 'ballastPump' in self.input.vessel.info['vesselPumps'].keys():
            bp1_ = self.input.vessel.info['vesselPumps']['ballastPump']['BP1']['pumpId']
            out['ballast'][bp1_] = out['ballast'].pop('BP1')
        
        if 'ballastPump' in self.input.vessel.info['vesselPumps'].keys():
            bp2_ = self.input.vessel.info['vesselPumps']['ballastPump']['BP2']['pumpId']
            out['ballast'][bp2_] = out['ballast'].pop('BP2')
        
        # dictionary[new_key] = dictionary.pop(old_key)
        # print(out['ballast']['Gravity'])
        last_ = -1
        for l__, l_ in enumerate(out['ballast']['Gravity']):
            if float(l_['quantityM3']) > 0:
                last_ = l__
                
        if len(out['ballast']['Gravity']) > 0:
            out['ballast']['Gravity'] = out['ballast']['Gravity'][:(last_+1)]
            
        # print(out['ballast']['Gravity'])        



        
    def _get_pump(self, timeEnd_,first_cargo):
        
        if first_cargo:
            if self.input.loading.max_loading_rate > 15000:
                # pump only
                pump_ = {'Gravity':0}
                if self.input.loading.num_pump == 1:
                    pump_['BP1'] = timeEnd_
                elif self.input.loading.num_pump == 2:
                    pump_['BP1'] = timeEnd_
                    pump_['BP2'] = timeEnd_
                    
            elif self.input.loading.max_loading_rate > 10000:
                # gravity for 2 hr
                if timeEnd_ <= self.gTimeStart + 2*60:
                    pump_ = {'Gravity':timeEnd_}
                else:
                    pump_ = {'Gravity': self.gTimeStart +2*60}
                    if self.input.loading.num_pump == 1:
                        pump_['BP1'] = timeEnd_
                    elif self.input.loading.num_pump == 2:
                        pump_['BP1'] = timeEnd_
                        pump_['BP2'] = timeEnd_
            else:
                # gravity for 4 hr
                if timeEnd_ <= self.gTimeStart + 4*60:
                    pump_ = {'Gravity':timeEnd_}
                else:
                    pump_ = {'Gravity': self.gTimeStart +4*60}
                    if self.input.loading.num_pump == 1:
                        pump_['BP1'] = timeEnd_
                    elif self.input.loading.num_pump == 2:
                        pump_['BP1'] = timeEnd_
                        pump_['BP2'] = timeEnd_
                        
                    
        else:
            # pump only
            pump_ = {'Gravity':0}
            if self.input.loading.num_pump == 1:
                pump_['BP1'] = timeEnd_
            elif self.input.loading.num_pump == 2:
                pump_['BP1'] = timeEnd_
                pump_['BP2'] = timeEnd_
        
        
        return pump_
        
    def _get_ballast(self, out, data, first_cargo):
        
        # for stages before maxloadingrate
        # print(out)
        # timeStart_ = int(out['timeStart'])
        timeEnd_   = int(out['timeEnd'])
        
      
        pump_ = self._get_pump(timeEnd_,first_cargo)    
            
        # print(out['stage'], pump_)
        
        for k_, v_ in pump_.items():
            
            time_ = v_ - int(out['timeStart'])
            rate_ = float(data['iniTotDeballastingRateM3_Hr'])
            amt_ = rate_*time_/60.
            
            if k_ == 'Gravity' and v_ > 0:
                
                out['ballast']['Gravity'] = [{'timeStart': out['timeStart'],
                                              'timeEnd': str(v_),
                                              "rateM3_Hr": str(round(rate_,2)),
                                              "quantityM3": str(round(amt_))}]
                
            elif k_ == 'BP1' and v_ > 0:
                out['ballast']['BP1'] = [{'timeStart': out['timeStart'],
                                              'timeEnd': str(v_),
                                              "rateM3_Hr": str(round(rate_/2,2)),
                                              "quantityM3": str(round(amt_))}]
                
            elif k_ == 'BP2' and v_ > 0:
                out['ballast']['BP2'] = [{'timeStart': out['timeStart'],
                                              'timeEnd': str(v_),
                                              "rateM3_Hr": str(round(rate_/2,2)),
                                              "quantityM3": str(round(amt_))}]
                     
        ## 
        if 'BP1' in out['ballast'].keys():
            if 'ballastPump' in self.input.vessel.info['vesselPumps'].keys():
                bp1_ = self.input.vessel.info['vesselPumps']['ballastPump']['BP1']['pumpId']
                out['ballast'][bp1_] = out['ballast'].pop('BP1')
        
        if 'BP2' in out['ballast'].keys():
            if 'ballastPump' in self.input.vessel.info['vesselPumps'].keys():
                bp2_ = self.input.vessel.info['vesselPumps']['ballastPump']['BP2']['pumpId']
                out['ballast'][bp2_] = out['ballast'].pop('BP2')
        
    
    
    ## for discharging study
    def gen_json2(self, constraints, stability_values):
        data = {}
        data['message'] = None
        data['processId'] = self.input.process_id
        data['hasLoadicator'] = self.input.has_loadicator
        
        if len(self.plans['ship_status']) == 0:
            data['loadablePlanDetails'] = []
            #data['message'] = self.input.error + self.plan['message']
            
            data['message'] = {**self.input.error, **self.plans['message']}
            data['errors'] = self._format_errors(data['message'])
            # data['validated'] = False if self.input.mode in ['Manual', 'FullManual'] else None
            
            return data
        
        # all loading port
        path_ = [self.input.port.info['portOrder'][str(i_+1)]  for i_ in range(self.input.port.info['numPort'])]
        # print(path_)
        data['dischargePlanDetails'] = []
        for s_ in range(len(self.plans['ship_status'])):
            plan = {}
            
            plan['caseNumber'] = int(s_+1)
            
            plan['dischargePlanPortWiseDetails'] = []
            plan['constraints'] = constraints.get(str(s_),[])
            
            for p__,p_ in enumerate(path_):
                plan_ = {}
                plan_['portId'] = int(self.input.port.info['portRotation'][p_]['portId'])
                plan_['portCode'] = p_
                plan_['portRotationId'] = int(self.input.port.info['portRotation'][p_]['portRotationId'])
                
                # arrival
                plan_['arrivalCondition'] = {"dischargeQuantityCargoDetails":[],
                                              "dischargeQuantityCommingleCargoDetails":[],
                                              "dischargePlanStowageDetails":[],
                                              "dischargePlanBallastDetails":[],
                                              "dischargePlanRoBDetails":[]}
                
                plan_['arrivalCondition']["stabilityParameters"] = stability_values[s_][self.input.loadable.info['arrDepVirtualPort'][str(p__+1)+'A']]
                
                plan_['arrivalCondition']["dischargeQuantityCargoDetails"] = self._get_status(s_, str(p__+1)+'A', 'dTotal')
                # get loadablePlanStowageDetails
                plan_['arrivalCondition']["dischargePlanStowageDetails"] = self._get_status(s_, str(p__+1)+'A', 'dCargoStatus')
                # get loadablePlanBallastDetails
                plan_['arrivalCondition']["dischargePlanBallastDetails"] = self._get_status(s_, str(p__+1)+'A', 'ballastStatus')
                # get loadablePlanRoBDetails
                plan_['arrivalCondition']["dischargePlanRoBDetails"] = self._get_status(s_, str(p__+1)+'A', 'robStatus')
                
                # departure
                plan_['departureCondition'] = {"dischargeQuantityCargoDetails":[],
                                              "dischargeQuantityCommingleCargoDetails":[],
                                              "dischargePlanStowageDetails":[],
                                              "dischargePlanBallastDetails":[],
                                              "dischargePlanRoBDetails":[]}
                
                plan_['departureCondition']["stabilityParameters"] = stability_values[s_][self.input.loadable.info['arrDepVirtualPort'][str(p__+1)+'D']]
                
                plan_['departureCondition']["dischargeQuantityCargoDetails"] = self._get_status(s_, str(p__+1)+'D', 'dTotal')
                # get loadablePlanStowageDetails
                plan_['departureCondition']["dischargePlanStowageDetails"] = self._get_status(s_, str(p__+1)+'D', 'dCargoStatus')
                # get loadablePlanBallastDetails
                plan_['departureCondition']["dischargePlanBallastDetails"] = self._get_status(s_, str(p__+1)+'D', 'ballastStatus')
                # get loadablePlanRoBDetails
                plan_['departureCondition']["dischargePlanRoBDetails"] = self._get_status(s_, str(p__+1)+'D', 'robStatus')
                # get loadableQuantityCommingleCargoDetails
                # plan_['departureCondition']["loadableQuantityCommingleCargoDetails"] = self._get_status(s_, str(p__+1)+'D', 'commingleStatus')
                plan['dischargePlanPortWiseDetails'].append(plan_)
                
            data['dischargePlanDetails'].append(plan)
        # data['message'] = {'limits':self.input.limits}
        
        
        return data
    
    def gen_json(self, constraints, stability_values):
        data = {}
        data['message'] = None
        data['processId'] = self.input.process_id
        data['user'] = self.input.user
        data['role'] = self.input.role
        data['hasLoadicator'] = self.input.has_loadicator
        
        data['errors'] = []
        
        data['validated'] = True if self.input.mode in ['Manual', 'FullManual'] else None
        data['feedbackLoop'] = self.input.feedbackLoop
        data['feedbackLoopCount'] = self.input.feedbackLoopCount
        
        
        if len(self.plans['ship_status']) == 0:
            data['loadablePlanDetails'] = None if self.input.mode in  ['Manual', 'FullManual'] else []
            #data['message'] = self.input.error + self.plan['message']
            
            data['message'] = {**self.input.error, **self.plans['message']}
            data['errors'] = self._format_errors(data['message'])
            data['validated'] = False if self.input.mode in ['Manual', 'FullManual'] else None
            
            return data
        
        
        
        # data['loadableStudyId'] = str(self.input.loadable_id)
        # data['vesselId'] = str(self.input.vessel_id)
        # data['voyageId'] = str(self.input.voyage_id)
        
        # all loading port
        path_ = [self.input.port.info['portOrder'][str(i_+1)]  for i_ in range(self.input.port.info['numPort'])]
        
        data['loadablePlanDetails'] = []
        for s_ in range(len(self.plans['ship_status'])):
            plan = {}
            
            if self.input.mode in ['Manual', 'FullManual']:
                plan['caseNumber'] = self.input.case_number
            else:
                plan['caseNumber'] = int(s_+1)
                
            plan['loadablePlanPortWiseDetails'] = []
            plan['constraints'] = constraints.get(str(s_),[])
            # plan['stabilityParameters'] = stability_values[s_][self.input.loadable.info['arrDepVirtualPort'][str(self.input.port.info['lastLoadingPort'])+'D']]
            plan['slopQuantity'] = str(self.plans['slop_qty'][s_]) if len(self.plans['slop_qty']) > 0 else None
            
            for p__,p_ in enumerate(path_):
                plan_ = {}
                plan_['portId'] = int(self.input.port.info['portRotation'][p_]['portId'])
                plan_['portCode'] = p_
                plan_['portRotationId'] = int(self.input.port.info['portRotation'][p_]['portRotationId'])
                plan_['seaWaterTemperature'] = str(self.input.port.info['portRotation'][p_]['seaWaterTemperature'])
                plan_['ambientTemperature'] = str(self.input.port.info['portRotation'][p_]['ambientTemperature'])
                # arrival
                plan_['arrivalCondition'] = {"loadableQuantityCargoDetails":[],
                                              "loadableQuantityCommingleCargoDetails":[],
                                              "loadablePlanStowageDetails":[],
                                              "loadablePlanBallastDetails":[],
                                              "loadablePlanRoBDetails":[]}
                
                # if p_ not in [path_[0]]:
                    # print(s_,p_, 'Get arrival info')
                plan_['arrivalCondition']["loadableQuantityCargoDetails"] = self._get_status(s_, str(p__+1)+'A', 'total')
                # get loadablePlanStowageDetails
                plan_['arrivalCondition']["loadablePlanStowageDetails"] = self._get_status(s_, str(p__+1)+'A', 'cargoStatus')
                # get loadablePlanBallastDetails
                plan_['arrivalCondition']["loadablePlanBallastDetails"] = self._get_status(s_, str(p__+1)+'A', 'ballastStatus')
                # get loadablePlanRoBDetails
                plan_['arrivalCondition']["loadablePlanRoBDetails"] = self._get_status(s_, str(p__+1)+'A', 'robStatus')
                # get loadableQuantityCommingleCargoDetails
                plan_['arrivalCondition']["loadableQuantityCommingleCargoDetails"] = self._get_status(s_, str(p__+1)+'A', 'commingleStatus')
                plan_['arrivalCondition']["stabilityParameters"] = stability_values[s_][self.input.loadable.info['arrDepVirtualPort'][str(p__+1)+'A']]
                
                
                # departure
                plan_['departureCondition'] = {"loadableQuantityCargoDetails":[],
                                              "loadableQuantityCommingleCargoDetails":[],
                                              "loadablePlanStowageDetails":[],
                                              "loadablePlanBallastDetails":[],
                                              "loadablePlanRoBDetails":[]}
                
                if p_ not in [path_[-1]]:
                    # print(s_,p_,'Get departure info')
                    # get loadableQuantityCargoDetails
                    plan_['departureCondition']["loadableQuantityCargoDetails"] = self._get_status(s_, str(p__+1)+'D', 'total')
                    # get loadablePlanStowageDetails
                    plan_['departureCondition']["loadablePlanStowageDetails"] = self._get_status(s_, str(p__+1)+'D', 'cargoStatus')
                    # get loadablePlanBallastDetails
                    plan_['departureCondition']["loadablePlanBallastDetails"] = self._get_status(s_, str(p__+1)+'D', 'ballastStatus')
                    # get loadablePlanRoBDetails
                    plan_['departureCondition']["loadablePlanRoBDetails"] = self._get_status(s_, str(p__+1)+'D', 'robStatus')
                    # get loadableQuantityCommingleCargoDetails
                    plan_['departureCondition']["loadableQuantityCommingleCargoDetails"] = self._get_status(s_, str(p__+1)+'D', 'commingleStatus')
                    plan_['departureCondition']["stabilityParameters"] = stability_values[s_][self.input.loadable.info['arrDepVirtualPort'][str(p__+1)+'D']]
                
                
                plan['loadablePlanPortWiseDetails'].append(plan_)
                
                
            # self._set_bunker(plan)
                
                
            data['loadablePlanDetails'].append(plan)
        data['message'] = {'limits':self.input.limits}
        
        if self.input.mode in ['Manual', 'FullManual']:
            data['loadablePlanDetails'] = data['loadablePlanDetails'][0]
                
      
        return data
    
    def _set_bunker(self, plan):
        
        # ['normalOp'] = {0: 359, 1: 2116, 3: 2065}
        # ['bunkering'] = {2 : {'id': 100003006 ... }}
        for k_, v_ in self.input.port.info['bunkering'].items():
            print('bunkering:', k_, v_)

    def _get_status(self,sol,port,category):
        
        # print('enter vlcc_gen.py')
        
        plan_ = []
        virtual_ = self.input.loadable.info['arrDepVirtualPort'][port]
        
        if category == 'total':
            
            if len(self.plans['cargo_status'][sol]) > 0:
            
                for k_, v_ in self.plans['cargo_status'][sol][virtual_].items():
                    if v_ > 0.:
                        info_ = {}
                        info_["cargoId"] = int(self.input.loadable.info['parcel'][k_]['cargoId'])
                        info_["cargoNominationId"] = int(k_[1:])
                        info_['cargoAbbreviation'] = self.input.loadable.info['parcel'][k_]['abbreviation']
                        info_['estimatedAPI'] = str(self.input.loadable.info['parcel'][k_]['api'])
                        info_['estimatedTemp'] = str(self.input.loadable.info['parcel'][k_]['temperature'])
                        info_['loadableMT'] = str(v_)
                        info_['priority'] = int(self.input.loadable.info['parcel'][k_]['priority'])
                        info_['colorCode'] = self.input.loadable.info['parcel'][k_]['color']
                        intend_ = self.input.loadable.info['toLoadIntend'][k_]
                        info_['orderedQuantity'] = str(round(intend_,DEC_PLACE))
                        info_['differencePercentage'] = str(round((v_-intend_)/intend_*100,2))
                        info_['loadingOrder'] = int(self.plans['cargo_order'][sol][k_])
                        info_["maxTolerence"] = str(self.input.loadable.info['parcel'][k_]['minMaxTol'][1])
                        info_["minTolerence"] = str(self.input.loadable.info['parcel'][k_]['minMaxTol'][0])
                        info_['slopQuantity'] = str(self.plans['slop_qty'][sol].get(k_,0.))
                        info_['toppingSequence'] = self.plans['topping'][sol][k_]
                        info_['timeRequiredForLoading'] = str(round(self.plans['loading_hrs'][sol][k_][0]+self.plans['loading_hrs'][sol][k_][1], 2))
                        info_['cargoNominationTemperature'] = str(self.input.loadable.info['parcel'][k_]['loadingTemperature'])
                        info_['loadingRateM3Hr'] = str(round(self.plans['loading_rate'][sol][k_][0]))
                        
                        plan_.append(info_)
        
        elif category == 'dTotal':
             if len(self.plans['cargo_status'][sol]) > 0:
                 
                slop_qty_ = {} 
                if virtual_ in ['0']:
                    data_ = {}
                    
                    for k_, v_ in self.input.loadable.info['preloadOperation'].items():
                        data_[k_] = 0.
                        for k1_, v1_ in v_.items():
                            data_[k_]  += v1_
                            
                            if k1_ in ['SLS', 'SLP']:
                                if k_ not in slop_qty_.keys():
                                    slop_qty_[k_] = v1_
                                else:
                                    slop_qty_[k_] += v1_
                            
                            
                    self.plans['cargo_status'][sol][virtual_] = data_
                
                else:
                    for k_, v_ in self.plans['ship_status'][sol][virtual_]['cargo'].items(): 
                        if k_ in ['SLS', 'SLP']:
                            if v_[0]['parcel'] not in slop_qty_.keys():
                                slop_qty_[v_[0]['parcel']] = v_[0]['wt']
                            else:
                                slop_qty_[v_[0]['parcel']] += v_[0]['wt']
                        
               
                for k_, v_ in self.plans['cargo_status'][sol][virtual_].items():
                    #print(k_, v_)
                    
                    info_ = {}
                    info_["cargoId"] = int(self.input.loadable.info['parcel'][k_]['cargoId'])
                    info_["dscargoNominationId"] = int(k_[1:])
                    info_['cargoNominationId'] = int(self.input.loadable.info['parcel'][k_]['cargoNominationId'][1:])
                    info_['cargoAbbreviation'] = self.input.loadable.info['parcel'][k_]['abbreviation']
                    info_['estimatedAPI'] = str(self.input.loadable.info['parcel'][k_]['api'])
                    info_['estimatedTemp'] = str(self.input.loadable.info['parcel'][k_]['temperature'])
                    
                    info_['dischargeMT'] = str(0.0)
                    disch_ = 0
                    if virtual_ not in ['0']:
                        pre_ = str(int(virtual_)-1)
                        disch_ = self.plans['cargo_status'][sol][pre_][k_] - v_
                        info_['dischargeMT'] = str(round(disch_,1))
                        
                    info_['priority'] = int(self.input.loadable.info['parcel'][k_]['priority'])
                    info_['colorCode'] = self.input.loadable.info['parcel'][k_]['color']
                    
                    info_['slopQuantity'] = str(round(slop_qty_.get(k_, 0.0),1))
                    
                    info_['dischargingRate'] = str(10000)
                    info_['timeRequiredForDischarging'] = str(round(disch_/10000,1))
                    info_['cowDetails'] = []
                    
                    plan_.append(info_)
                                    
            
        elif category == 'dCargoStatus':
                        
            for k_,v_ in self.plans['ship_status'][sol][virtual_]['cargo'].items():
                # print(k_,v_)
                info_ = {}
                info_['tankShortName'] = k_
                info_['quantityMT'] = str(abs(v_[0]['wt']))
                info_['quantityM3'] = str(round(abs(v_[0]['wt'])/v_[0]['SG'],2))
                
                info_['cargoAbbreviation'] = self.input.loadable.info['parcel'][v_[0]['parcel']]['abbreviation']
                info_['tankId'] = int(self.input.vessel.info['tankName'][k_])
                info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                info_['tankName'] = self.input.vessel.info['cargoTanks'][k_]['name']
                   
                info_['temperature'] = str(v_[0]['temperature'])
                # info_['cargoNominationTemperature'] = str(v_[0]['temperature'])
                
                info_['colorCode'] = self.input.loadable.info['parcel'][v_[0]['parcel']]['color']
                info_['api'] = str(self.input.loadable.info['parcel'][v_[0]['parcel']]['api'])
                
                info_['dscargoNominationId'] = int(v_[0]['parcel'][1:])
                info_['cargoNominationId'] = int(self.input.loadable.info['parcel'][v_[0]['parcel']]['cargoNominationId'][1:])
                # info_['onboard'] = str(self.input.vessel.info['onboard'].get(k_,{}).get('wt',0.))
                
                # vol_ = abs(v_[0]['wt'])/v_[0]['SG']
                # info_['rdgUllage'] = str(round(self.input.vessel.info['ullage_func'][str(info_['tankId'])](vol_).tolist(), 2))
                
                info_['correctedUllage'] = str(round(v_[0]['corrUllage'],6))
                info_['correctionFactor'] = str(0.00 if v_[0]['correctionFactor'] == 0 else v_[0]['correctionFactor'])
                info_['rdgUllage'] = str(v_[0]['rdgUllage'])
                info_['maxTankVolume'] = str(self.input.vessel.info['cargoTanks'][k_]['capacityCubm'])
                
                plan_.append(info_)
                    
                    
        elif category == 'cargoStatus':
                        
            for k_,v_ in self.plans['ship_status'][sol][virtual_]['cargo'].items():
                # print(k_,v_)
                if type(v_[0]['parcel']) == str and v_[0]['parcel'] in self.input.loadable.info['parcel'].keys():
                    info_ = {}
                    info_['tankShortName'] = k_
                    info_['quantityMT'] = str(abs(v_[0]['wt']))
                    info_['quantityM3'] = str(round(abs(v_[0]['vol']),2))
                    
                    
                    info_['cargoAbbreviation'] = self.input.loadable.info['parcel'][v_[0]['parcel']]['abbreviation']
                    info_['tankId'] = int(self.input.vessel.info['tankName'][k_])
                    info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                    info_['tankName'] = self.input.vessel.info['cargoTanks'][k_]['name']
                    
                    
                    info_['temperature'] = str(self.input.loadable.info['parcel'][v_[0]['parcel']]['temperature'])
                    info_['cargoNominationTemperature'] = str(self.input.loadable.info['parcel'][v_[0]['parcel']]['loadingTemperature'])
                    
                    info_['colorCode'] = self.input.loadable.info['parcel'][v_[0]['parcel']]['color']
                    info_['api'] = str(self.input.loadable.info['parcel'][v_[0]['parcel']]['api'])
                    
                    info_['cargoNominationId'] = int(v_[0]['parcel'][1:])
                    info_['onboard'] = str(self.input.vessel.info['onboard'].get(k_,{}).get('wt',0.))
                    
                    # vol_ = abs(v_[0]['wt'])/v_[0]['SG']
                    # info_['rdgUllage'] = str(round(self.input.vessel.info['ullage_func'][str(info_['tankId'])](vol_).tolist(), 2))
                    
                    info_['correctedUllage'] = str(round(v_[0]['corrUllage'],6))
                    info_['correctionFactor'] = str(0.00 if v_[0]['correctionFactor'] == 0 else v_[0]['correctionFactor'])
                    info_['rdgUllage'] = str(v_[0]['rdgUllage'])
                    info_['maxTankVolume'] = str(round(v_[0]['maxTankVolume'],3))
                    
                    plan_.append(info_)
                    
                elif type(v_[0]['parcel']) == str:
                 	# only onboard 
                    info_ = {}
                    info_['tankShortName'] = k_
                    info_['quantityMT'] = str(abs(v_[0]['wt']))
                    info_['quantityM3'] = str(round(abs(v_[0]['vol']),2))
                    
                    info_['cargoAbbreviation'] = None
                    info_['tankId'] = int(self.input.vessel.info['tankName'][k_])
                    
                    
                    info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                    info_['tankName'] = self.input.vessel.info['cargoTanks'][k_]['name']
                    info_['temperature'] = None
                    info_['colorCode'] = self.input.vessel.info['cargoTanks'][k_]['colorCode']
                    info_['api'] = self.input.vessel.info['cargoTanks'][k_]['api']
                    
                    # vol_ = abs(v_[0]['wt'])/v_[0]['SG']
                    # info_['rdgUllage'] = str(round(self.input.vessel.info['ullage_func'][str(info_['tankId'])](vol_).tolist(), 2))
                    info_['correctedUllage'] = str(round(v_[0]['corrUllage'],6))
                    info_['correctionFactor'] = str(0.00 if v_[0]['correctionFactor'] == 0 else v_[0]['correctionFactor'])
                    info_['rdgUllage'] = str(v_[0]['rdgUllage'])
                                        
                    info_['cargoNominationId'] = ''
                    info_['onboard'] = str(self.input.vessel.info['onboard'].get(k_,{}).get('wt',0.))
                    info_['maxTankVolume'] = str(round(v_[0]['maxTankVolume'],3))
                    
                    
                    plan_.append(info_)
                    
                    
                    
        elif category == 'commingleStatus':
            
            for k_,v_ in self.plans['ship_status'][sol][virtual_]['cargo'].items():
                if type(v_[0]['parcel']) == list:
                    info_ = {}
                    
                    info_['tankShortName'] = k_
                    info_['quantity'] = str(abs(v_[0]['wt']))
                    info_['quantityM3'] = str(round(abs(v_[0]['vol']),2))
                    
                    info_['cargo1Abbreviation'] = self.input.loadable.info['parcel'][v_[0]['parcel'][0]]['abbreviation']
                    info_['cargo2Abbreviation'] = self.input.loadable.info['parcel'][v_[0]['parcel'][1]]['abbreviation']
                    info_['priority'] = int(self.input.loadable.info['commingleCargo']['priority'])
                    
                    info_['cargo1NominationId'] = int(v_[0]['parcel'][0][1:])
                    info_['cargo2NominationId'] = int(v_[0]['parcel'][1][1:])
                     
                    
                    
                    # info_['priority'] = str(self.input.loadable.info['commingleCargo']['priority'])
                    info_['cargo1Percentage'] = str(round(v_[0]['wt1percent']*100,2))
                    info_['cargo2Percentage'] = str(round(v_[0]['wt2percent']*100,2))
                    info_['cargo1MT'] = str(v_[0]['wt1'])
                    info_['cargo2MT'] = str(v_[0]['wt2'])
                    
                    info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                    info_['temp'] = str(v_[0]['temperature'])
                    
                    info_['api'] =  str(round(v_[0]['api'],2))
                    info_['tankId'] = int(self.input.vessel.info['tankName'][k_])
                    info_['tankName'] = self.input.vessel.info['cargoTanks'][k_]['name']
                    # vol_ = abs(v_[0]['wt'])/v_[0]['SG']
                    
                    info_['correctedUllage'] = str(round(v_[0]['corrUllage'],6))
                    info_['correctionFactor'] = str(0.00 if v_[0]['correctionFactor'] == 0 else v_[0]['correctionFactor'])
                    info_['rdgUllage'] = str(v_[0]['rdgUllage'])
                   
                    info_['onboard'] = str(self.input.vessel.info['onboard'].get(k_,{}).get('wt',0.))
                    info_['slopQuantity'] = str(abs(v_[0]['wt'])) if k_ in ['SLS','SLP'] else 0.
                    
                    info_['colorCode'] = self.input.loadable.info['commingleCargo']['colorCode']
                    info_['maxTankVolume'] = str(round(v_[0]['maxTankVolume'],3))
                    
                    l1_ = self.plans['loading_hrs'][sol][v_[0]['parcel'][0]][0]+self.plans['loading_hrs'][sol][v_[0]['parcel'][0]][1]
                    l2_ = self.plans['loading_hrs'][sol][v_[0]['parcel'][1]][0]+self.plans['loading_hrs'][sol][v_[0]['parcel'][1]][1]
                    
                    info_['timeRequiredForLoading'] = str(round(l1_+l2_, 2))
                    
                    loading_order1_ = int(self.plans['cargo_order'][sol]['P'+str(info_['cargo1NominationId'])])
                    loading_order2_ = int(self.plans['cargo_order'][sol]['P'+str(info_['cargo2NominationId'])])
                    
                    if loading_order1_ < loading_order2_:
                        info_['toppingOffCargoId'] = info_['cargo2NominationId']
                    else:
                        info_['toppingOffCargoId'] = info_['cargo1NominationId']
                        
                            
                    plan_.append(info_)
                
        elif category == 'ballastStatus':
            
            for k_,v_ in self.plans['ship_status'][sol][virtual_]['ballast'].items():
                info_ = {}
                info_['tankShortName'] = k_
                info_['quantityMT'] = str(round(abs(v_[0]['wt']),2))
                info_['quantityM3'] = str(round(abs(v_[0]['vol']),2))
                
                info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                info_['sg'] = str(v_[0]['SG'])
                
                info_['tankId'] = int(self.input.vessel.info['tankName'][k_])
                info_['tankName'] = self.input.vessel.info['ballastTanks'][k_]['name']
                # vol_ = np.floor(abs(v_[0]['wt'])/v_[0]['SG']) # + self.input.vessel.info['onboard'].get(k_,{}).get('vol',0.)
                
                # try:
                #     ul_= self.input.vessel.info['ullage_func'][str(info_['tankId'])](vol_).tolist()
                # except:
                #     print(k_, vol_)
                #     ul_ = 0.
                info_['correctedUllage'] = str(round(v_[0]['corrLevel'],6))
                info_['correctionFactor'] = str(0.00 if v_[0]['correctionFactor'] == 0 else v_[0]['correctionFactor'])
                info_['rdgLevel'] = str(v_[0]['rdgLevel'])
                
                info_['volume'] = str(round(v_[0]['vol'],2))
                info_['maxTankVolume'] = str(round(v_[0]['maxTankVolume'],3))
                
                
                plan_.append(info_)
                
                
        elif category == 'robStatus':
            
            for k_,v_ in self.plans['ship_status'][sol][virtual_]['other'].items():
                info_ = {}
                info_['tankShortName'] = k_
                info_['quantityMT'] = str(abs(v_[0]['wt']))
                info_['quantityM3'] = str(round(abs(v_[0]['vol']),2))
                
                info_['sg'] = str(v_[0]['SG'])
                info_['tankId'] = int(self.input.vessel.info['tankName'][k_])
                info_['tankName'] =  self.input.vessel.info['tankFullName'][k_]
             
                plan_.append(info_)
        
        return plan_
        

    def _format_errors(self, message):
        errors = []
        for k_, v_ in message.items():
            errors.append({"errorHeading":k_, "errorDetails":v_})
    
        return errors
    
    # def _cal_max_rate(self, param, flow_rate):
    #     max_rate = 1000000
        
    #     components = {'manifolds':[['manifolds'], ['manifolds']],   # param, flow_rate
    #                   'drop':[['manifolds'], ['dropLines']], 
    #                   'bottom':[['bottomLines'],['bottomLines']],
    #                   'tanks':[['centreTank', 'wingTank'], ['centreTankBranch','wingTankBranch']], 
    #                   'PVvalves':[['centreTank', 'wingTank'], ['PVvalveCentreTank','PVvalveWingTank']], 
    #                   'maxVessel':[[''],['maxLoadingRate']],
    #                   'maxRiser':[[''],['maxRiser']]}
    #     rate = {}
    #     for k_, v_ in components.items():
    #         rate_ = 0
    #         for i_, j_ in zip(v_[0], v_[1]):
    #             # print(i_,j_, param.get(i_,1), flow_rate[j_])
    #             rate_ += len(param.get(i_,[1])) * flow_rate[j_]
            
    #         rate[k_] = rate_
    #         if max_rate > rate_:
    #             max_rate = rate_
            
    #     # print(rate)
        
        
    #     return max_rate
    
    
    def _cal_max_rate(self, param, required_rate = 1):
        
        # flow_rate = {'maxLoadingRate': 20500,
        # 'maxRiser': 25625,
        # 'manifolds':         {1: 1140, 6: 6841, 7: 7891, 12:13681},
        # 'dropLines':         {1: 1140, 6: 6841, 7: 7891, 12:13681},
        # 'bottomLines':       {1: 1534, 6: 9205, 7:10739, 12:18409},
        # 'wingTankBranch':    {1:  659, 6: 3950, 7: 3950, 12: 3950},
        # 'centreTankBranch':  {1:  965, 6: 5790, 7: 5790, 12: 5790},
        # 'PVvalveWingTank':   {1: 7050, 6: 7050, 7: 7050, 12: 7050},
        # 'PVvalveCentreTank': {1:12000, 6:12000, 7:12000, 12:12000},
        # 'slopTankBranch':    {1:  573, 6: 3435, 7: 3950, 12: 3950},
        # }
        
        flow_rate = self.input.vessel.info['loadingRate6']
        
        max_rate = 1000000
        
        components = {'manifolds':[['Manifolds'], ['Manifolds']],   # param, flow_rate
                      'drop':[['Manifolds'], ['DropLines']], 
                      'bottom':[['BottomLines'],['BottomLines']],
                      'tanks':[['centreTank', 'wingTank','slopTank'], ['CentreTankBranchLine','WingTankBranchLine','SlopTankBranchLine']], 
                      'PVvalves':[['centreTank', 'wingTank','slopTank'], ['PVValveCentreTank','PVValveWingTank','PVValveWingTank']], 
                      'maxVessel':[[''],['maxLoadingRate']],
                      'maxRiser':[[''],['maxRiser']]}
        rate = {}
        # print(param['centreTank'])
        # print(param['wingTank'])
        # print(param['slopTank'])
        
        # min (vessel, riser)
        loading_rate_ = min(self.input.vessel.info['loadingRateVessel'], self.input.vessel.info['loadingRateRiser'])

        for k_, v_ in components.items():
            rate_ = 0
            for i_, j_ in zip(v_[0], v_[1]):
                # print(i_,j_, param.get(i_,1), flow_rate[j_])
                if j_ in ['maxLoadingRate', 'maxRiser']:
                    # print(i_, j_, flow_rate[j_])
                    rate_ += flow_rate.get(j_, loading_rate_)
                else:
                    # print(i_, j_, param[i_], flow_rate[j_])
                    if i_ == 'wingTank' and j_ == 'PVValveWingTank':
                        rate_ += len(param[i_])/2 * flow_rate[j_]
                    else:
                        rate_ += len(param[i_]) * flow_rate[j_]
    
            
            rate[k_] = rate_
            if max_rate > rate_:
                max_rate = rate_
            
            # print('>>>', k_, rate_)
            
        # print(max_rate)
        
        
        return max_rate


            

    def _topping_seq(self, tanks):
        fixed_order = ['SLS','SLP','5P','5C', '4P', '4C', '2P','2C', '1P','1C','3P', '3C']
        order_ = ['' for o_ in fixed_order]
        
        for t_ in tanks:
            t__ = t_ #if t_ not in ['SLS'] else 'SLP'
            if t__ in fixed_order:
                i_ = fixed_order.index(t__)
                order_[i_] = t__
                
        order__ = [o_ for o_ in order_ if o_ not in ['']]
    
        # print(order__)
        
        seq = []
        for t_ in tanks:
            if t_ not in ['SLS', 'SLP']:
                t__ = t_ if t_[-1] not in ['S'] else t_[:-1]+'P'
            else:
                t__ = t_ 
            # print(t_,t__)
            seq_ = {}
            seq_['shortName'] = t_
            seq_['tankId'] = self.input.vessel.info['tankName'][t_]
            seq_['sequenceOrder'] = order__.index(t__) + 1
            
            seq.append(seq_)
            
            
        # print(seq)
        
        return seq
                    
        