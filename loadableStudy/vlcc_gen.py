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

DEC_PLACE = 3


class Generate_plan:
    def __init__(self, data):

        self.input = data
        self.commingled = False
        
    def _run_ampl(self,dat_file='input.dat'):
                
        is_succeed, num_solutions = False, 0
        solve_result, obj, plan, ship_status, ballast_weight, cargo_loaded, xx, cargo_loaded_port = [], [], [], [], [], [], [], []
        message = []
    
        try:
            model_ = 'model_1i.mod'
            print(model_)
            ampl = AMPL()
            ampl.option['show_presolve_messages'] = True
            ampl.read(model_)
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
                
                print("{:.3f}".format(self.input.loadable.info['toLoadPort'].max()), "{:.3f}".format(tot_load[0][1]))
                
            else:
                message = 'Solve result: ' + solve_result +'. No solution is available!!'
                print(message)
#                upsertToDB(stat_file, 'Optimization terminated with error.\n' + str(e))
            
            
        except Exception as err:
            print('AMPL Error:',err)
            message = err
#            upsertToDB(stat_file, 'Optimization terminated with error.\n' + str(e))
        
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
                
                print("{:.3f}".format(self.input.loadable.info['toLoadPort'].max()), "{:.3f}".format(tot_load[0][1]))
            
            else:
                message = 'Solve result: No solution is available!!'
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
        
        # self.plan = {}
        self.plan['obj'] = []
        self.plan['operation'] = []
        self.plan['ship_status'] = []
        self.plan['cargo_status'] = []
        self.plan['constraint'] = []
        self.plan['slop_qty'] = []
        self.plan['cargo_order'] = []
        
        
        self.num_plans = min(num_plans,result['num_plans'])
        
        self.ship_status_dep, self.ballast_weight = [], []
        
        self.other_weight, self.initial_ballast_weight = [], []
        self.cargo_in_tank = []
        
        for p_ in range(self.num_plans):
            
            commingled_ = False
            tank_cargo_ = {t_:[]  for t_ in self.input.vessel.info['cargoTanks']}
            for q_ in result['xx']:
                if (p_+1) == int(q_[0]) and q_[3] > .0:
                    tank_cargo_[q_[2]].append(q_[1])
                    if len(tank_cargo_[q_[2]]) > 1:
                        commingled_ = True
                        
                    
                                    
            operation_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
            for i_ in result['plan']: # (1.0, 'P101', '1S', 3.0, -10000.0)
                if int(i_[0]) == (p_+1) and round(abs(i_[4]),DEC_PLACE) >= 0.01 and i_[1] in tank_cargo_[i_[2]]:
                    density_ = self.input.loadable.info['parcel'][i_[1]]['maxtempSG']
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
                        
            self.plan['operation'].append(operation_)
            
            # status at departure: cargo tank only 
            ship_status_dep_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
            for i_ in result['ship_status']: # (1.0, 'P101', '3P', 1.0, 10000.0)
                if int(i_[0]) == (p_+1) and round(i_[4],DEC_PLACE) >= 0.01 and i_[1] in tank_cargo_[i_[2]]:
                    onboard_ = self.input.vessel.info['onboard'].get(i_[2],{}).get('wt',0.)
                    # if onboard_ > 0:
                    #     print(i_[2],i_[1],i_[4],onboard_)
                    wt_ = round(i_[4] + onboard_ ,DEC_PLACE) 
                    density_ = self.input.loadable.info['parcel'][i_[1]]['maxtempSG']
                    capacity_ = self.input.vessel.info['cargoTanks'][i_[2]]['capacityCubm']
                    tcg_ = 0.
                    if i_[2] in self.input.vessel.info['tankTCG']['tcg']:
                        tcg_ = np.interp(wt_/density_, self.input.vessel.info['tankTCG']['tcg'][i_[2]]['vol'],
                                         self.input.vessel.info['tankTCG']['tcg'][i_[2]]['tcg'])
                    vol_ = wt_/density_ 
                    fillingRatio_ =  round(vol_/capacity_,DEC_PLACE)
                    
                    info_ = {'parcel':i_[1], 'wt': wt_, 'SG': density_,
                             'fillRatio': fillingRatio_, 'tcg':tcg_, 
                             'temperature':self.input.loadable.info['parcel'][i_[1]]['temperature'],
                             'api':self.input.loadable.info['parcel'][i_[1]]['api']}
                    
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
                            parcel1_ = self.input.loadable.info['commingleCargo']['parcel1']
                            parcel2_ = self.input.loadable.info['commingleCargo']['parcel2']
                            
                            parcel_ = [v1_[0]['parcel'], v1_[1]['parcel']]
                            
                            onboard_ = self.input.vessel.info['onboard'].get(k1_,{}).get('wt',0.)
                            # temperature_ = self.input.loadable.info['commingleCargo']['temperature']
                            
                            wt1_ = sum([vv_['wt'] for vv_ in v1_ if vv_['parcel'] == parcel1_]) - onboard_
                            wt2_ = sum([vv_['wt'] for vv_ in v1_ if vv_['parcel'] == parcel2_]) - onboard_
                            
                            weight_ = wt1_ + wt2_ + onboard_
                            
                            capacity_ = self.input.vessel.info['cargoTanks'][k1_]['capacityCubm']
                            
                           
                            api__ = [self.input.loadable.info['commingleCargo']['api1'], self.input.loadable.info['commingleCargo']['api2']]
                            wt__ = [wt1_,wt2_]
                            temp__ = [self.input.loadable.info['commingleCargo']['t1'], self.input.loadable.info['commingleCargo']['t2']]
                            api_, temp_ = self._get_commingleAPI(api__, wt__, temp__)
                            
                            density_ = self._cal_density(round(api_,2), round(temp_,1))
                            vol_ = weight_/density_ 
                            
                            fillingRatio_ = round(vol_/capacity_,DEC_PLACE)
                            print(parcel1_,parcel2_, k1_, fillingRatio_, round(api_,2), round(temp_,1), density_, round(weight_,3))
                            
                            tcg_ = 0.
                            if k1_ in self.input.vessel.info['tankTCG']['tcg']:
                                tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][k1_]['vol'],
                                                 self.input.vessel.info['tankTCG']['tcg'][k1_]['tcg'])
                            
                                                              
                            info_ = {'parcel':parcel_, 'wt': round(weight_,3), 'SG': round(density_,4),
                                     'fillRatio': fillingRatio_, 'tcg':tcg_, 
                                     'temperature':round(temp_,2),
                                     'api':api_,
                                     'wt1':wt1_, 'wt2':wt2_,
                                     'wt1percent':wt1_/(wt1_+wt2_), 'wt2percent':wt2_/(wt1_+wt2_)}
                            
                            # print(info_)
                            
                            ship_status_dep_[k_][k1_] = [info_]
                            
                            # print(density_,api_)
                    
                            # print(v1_[0]['wt']/v1_[0]['SG'], v1_[1]['wt']/v1_[1]['SG'], weight_/density_)
                            
            for k_, v_ in self.input.vessel.info['onboard'].items():
                if k_ not in ['totalWeight']:
                    print(k_, 'empty with onboard', v_)
                    wt_ = round(v_['wt'] ,DEC_PLACE) 
                    density_ = round(v_['wt']/v_['vol1'], 4)
                    capacity_ = self.input.vessel.info['cargoTanks'][k_]['capacityCubm']
                    tcg_ = 0.
                    if k_ in self.input.vessel.info['tankTCG']['tcg']:
                        tcg_ = np.interp(wt_/density_, self.input.vessel.info['tankTCG']['tcg'][k_]['vol'],
                                         self.input.vessel.info['tankTCG']['tcg'][k_]['tcg'])
                        
                    info_ = {'parcel':'onboard', 'wt': wt_, 'SG': density_,
                             'fillRatio': round(v_['vol']/capacity_,DEC_PLACE), 'tcg':tcg_, 
                             'temperature':None}
                    
                    for k1_, v1_ in ship_status_dep_.items():
                        if not v1_.get(k_, []):
                            ship_status_dep_[k1_][k_] = [info_]
                    
                        
                        
                       
            # ballast status: departure/arrive for loading/discharging port         
            ballast_weight_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
            for i_ in result['ballast_weight']: # (1.0, 'FPTL', 1.0, 5580.1)
                if int(i_[0]) == (p_+1) and round(i_[3],DEC_PLACE) >= 1:
                    port_ = self.input.loadable.info['virtualArrDepPort'][str(int(i_[2]))][:-1]
                    portName_ = self.input.port.info['portOrder'][str(port_)]
                    density_ = 1.025
                    #density_ = self.input.port.info['portRotation'][portName_]['seawaterDensity']
                    capacity_ =  self.input.vessel.info['ballastTanks'][i_[1]]['capacityCubm']
                    wt_ = round(i_[3],DEC_PLACE)
                    tcg_ = 0.
                    if i_[1] in self.input.vessel.info['tankTCG']['tcg']:
                        tcg_ = np.interp(wt_/density_, self.input.vessel.info['tankTCG']['tcg'][i_[1]]['vol'],
                                         self.input.vessel.info['tankTCG']['tcg'][i_[1]]['tcg'])
                    ballast_weight_[str(int(i_[2]))][i_[1]] = [{'wt': wt_, 
                                                      'SG':density_,
                                                      'fillRatio': round(i_[3]/density_/capacity_,DEC_PLACE),
                                                      'tcg':tcg_}]
            
            
                           
                            
                    # if k_ not in [str(self.input.port.info['numPort'])+'D']:
                    #     ship_status_[k_]['other'][i_]  = [{'wt': round(v_['wt'],DEC_PLACE), 
                    #                                   'SG':round(v_['wt']/max(1.0,v_['vol']),DEC_PLACE),
                    #                                   'tcg':v_['tcg']}]
            
            
            
            self.ship_status_dep.append(ship_status_dep_)       
            self.ballast_weight.append(ballast_weight_)       
            self.commingled = commingled_
            
            cargo_in_tank_, max_tank_used_ = {}, 0
            # print(p_,'--------------------------------------------------------')
            for k_, v_ in self.input.loadable.info['parcel'].items():
                tanks_ = [i_  for i_,j_ in tank_cargo_.items() if k_ in j_]
                # print(k_,tanks_)
                cargo_in_tank_[k_] = tanks_
                if len(tanks_) > max_tank_used_:
                    max_tank_used_ = len(tanks_)
                    self.max_tank_parcel = k_
                    
            self.cargo_in_tank.append(cargo_in_tank_)
                
            
            
        # add ROB    
        other_weight_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
        for i_, j_ in self.input.vessel.info['onhand'].items():
            for k_, v_ in j_.items():
                info_ =  [{'wt': round(v_['wt'],DEC_PLACE), 
                                                  'SG':round(v_['wt']/max(1.0,v_['vol']),DEC_PLACE),
                                                  'tcg':v_['tcg']}]
        
                for k1_, v1_ in self.input.loadable.info['virtualArrDepPort'].items():
                    if v1_ == k_:
                        other_weight_[k1_][i_] =  info_
                        
        self.other_weight = other_weight_
                            
        initial_ballast_weight_ = {} 
        # add ballast for first arrival port
        for i_, j_ in self.input.vessel.info['initBallast']['wt'].items():
            density_ = 1.025
            capacity_ =  self.input.vessel.info['ballastTanks'][i_]['capacityCubm']
            wt_ = round(j_,DEC_PLACE)
            tcg_ = 0.
            if i_ in self.input.vessel.info['tankTCG']['tcg']:
                tcg_ = np.interp(wt_/density_, self.input.vessel.info['tankTCG']['tcg'][i_]['vol'],
                                      self.input.vessel.info['tankTCG']['tcg'][i_]['tcg'])
            initial_ballast_weight_[i_] = [{'wt': wt_, 
                                                  'SG':density_,
                                                  'fillRatio': round(j_/density_/capacity_,DEC_PLACE),
                                                  'tcg':tcg_}]
        self.initial_ballast_weight = initial_ballast_weight_
            
    def _process_checking_plans(self, result):
        
        ## still in virtual port 
        for p_ in range(self.num_plans):
            ship_status_dep_ = self.ship_status_dep[p_]
            ballast_weight_ = self.ballast_weight[p_]
            
            # switch from departure only to departure/arrive for loading/discharging port
            ship_status_, cargo_status_ = {}, {}
            for i_ in range(0,self.input.loadable.info['lastVirtualPort']):
                ship_status_[str(i_)] = {'cargo':{},'ballast':{},'other':{}}
                if i_ == 0:
                    ship_status_[str(i_)]['ballast'] = self.initial_ballast_weight
                else:
                    ship_status_[str(i_)]['ballast'] = ballast_weight_[str(i_)]
                
                ship_status_[str(i_)]['cargo'] = ship_status_dep_[str(i_)]
                ship_status_[str(i_)]['other'] = self.other_weight[str(i_)]
                
                cargo_status_[str(i_)] = {k_[1]:round(k_[3],3) for k_  in result['cargo_loaded_port'] if k_[0] == p_+1 and k_[2] == i_}
                
                
            self.plan['ship_status'].append(ship_status_)
            self.plan['cargo_status'].append(cargo_status_)
            self.plan['obj'].append(round(result['obj'][p_][1],3))
            
            ##--------------------------------------------------------------
            slop_qty_ = 0
            for k_, v_ in ship_status_[str(self.input.loadable.info['lastVirtualPort']-1)]['cargo'].items():
                if k_ in ['SLS', 'SLP']:
                    slop_qty_ += v_[0]['wt']
            self.plan['slop_qty'].append(slop_qty_)
            ##--------------------------------------------------------------
            self.plan['cargo_order'].append(self.input.loadable.info['cargoOrder'])
            
        
        self.plan['cargo_tank'] = self.cargo_in_tank
            
            
            # if self.input.loadable.info['rotationCargo']:
            #     self.plan['constraint'].append({str(self.input.loadable.info['rotationCargo']):'ok'})
            
        
        with open('ship_status.json', 'w') as fp:
            json.dump(self.plan['ship_status'], fp)            
                    
                
    
#     def _process_ampl_plans(self, result):
        
#         for p_ in range(self.num_plans):
#             ship_status_dep_ = self.ship_status_dep[p_]
#             ballast_weight_ = self.ballast_weight[p_]
            
#             # switch from departure only to departure/arrive for loading/discharging port
#             ship_status_ = {}
#             ship_status_['1A'] =  {'cargo':{},'ballast':{},'other':{}}
            
#             cargo_status_ = {}
#             cargo_status_ ['1A'] = {}
            
#             for i_ in range(1,self.input.port.info['numPort']+1):
                
#                 if i_ == 1:
#                     ship_status_['1D'] = {'cargo':{},'ballast':{},'other':{}}
#                     ship_status_['1D']['cargo'] = ship_status_dep_['1']
#                     ship_status_['1D']['ballast'] = ballast_weight_['1']
                    
#                     cargo_status_['1D'] = {k_[1]:round(k_[3],3) for k_  in result['cargo_loaded_port'] if k_[0] == p_+1 and k_[2] == 1 }
                    
#                 elif i_ == self.input.port.info['numPort']:
#                     ship_status_[str(i_)+'A'] = {'cargo':{},'ballast':{},'other':{}}
#                     ship_status_[str(i_)+'A']['cargo']  = ship_status_dep_[str(2*(i_-1))]
#                     ship_status_[str(i_)+'A']['ballast']  = ballast_weight_[str(2*(i_-1))]
                    
#                     cargo_status_[str(i_)+'A'] = {k_[1]:round(k_[3],3) for k_  in result['cargo_loaded_port'] if k_[0] == p_+1 and k_[2] == 2*(i_-1) }
 
                    
#                 else:
#                     ship_status_[str(i_)+'A'] = {'cargo':{},'ballast':{},'other':{}}
#                     ship_status_[str(i_)+'A']['cargo']  = ship_status_dep_[str(2*(i_-1))]
#                     ship_status_[str(i_)+'A']['ballast']  = ballast_weight_[str(2*(i_-1))]
                    
#                     cargo_status_[str(i_)+'A'] = {k_[1]:round(k_[3],3) for k_  in result['cargo_loaded_port'] if k_[0] == p_+1 and k_[2] == 2*(i_-1) }
 
#                     ship_status_[str(i_)+'D'] = {'cargo':{},'ballast':{},'other':{}}
#                     ship_status_[str(i_)+'D']['cargo']  = ship_status_dep_[str(2*(i_-1)+1)]
#                     ship_status_[str(i_)+'D']['ballast']  = ballast_weight_[str(2*(i_-1)+1)]
                    
#                     cargo_status_[str(i_)+'D'] = {k_[1]:round(k_[3],3) for k_  in result['cargo_loaded_port'] if k_[0] == p_+1 and k_[2] == 2*(i_-1)+1 }
 
                    
#             # add ROB
#             for i_, j_ in self.input.vessel.info['onhand'].items():
#                 for k_, v_ in j_.items():
#                     if k_ not in [str(self.input.port.info['numPort'])+'D']:
#                         ship_status_[k_]['other'][i_]  = [{'wt': round(v_['wt'],DEC_PLACE), 
#                                                       'SG':round(v_['wt']/max(1.0,v_['vol']),DEC_PLACE),
#                                                       'tcg':v_['tcg']}]
            
#             # add ballast for first arrival port
#             for i_, j_ in self.input.vessel.info['initBallast'].items():
#                 density_ = 1.025
#                 capacity_ =  self.input.vessel.info['ballastTanks'][i_]['capacityCubm']
#                 wt_ = round(j_,DEC_PLACE)
#                 tcg_ = 0.
#                 if i_ in self.input.vessel.info['tankTCG']['tcg']:
#                     tcg_ = np.interp(wt_/density_, self.input.vessel.info['tankTCG']['tcg'][i_]['vol'],
#                                          self.input.vessel.info['tankTCG']['tcg'][i_]['tcg'])
#                 ship_status_['1A']['ballast'][i_] = [{'wt': wt_, 
#                                                       'SG':density_,
#                                                       'fillRatio': round(j_/density_/capacity_,DEC_PLACE),
#                                                       'tcg':tcg_}]
                
                
         
#             self.plan['ship_status'].append(ship_status_)
#             self.plan['cargo_status'].append(cargo_status_)
            
#             self.plan['obj'].append(result['obj'][p_][1])
#             self.plan['slop_qty'].append(0)
            
# #            print(d0_)
    
            
    def _get_commingleAPI(self, api, weight, temp):
        weight_api_ , weight_temp_ = 0., 0.
        
        sg60_ = [141.5/(a_+131.5) for a_ in api]
        t13_ = [(535.1911/(a_+131.5)-0.0046189)*0.042 for a_ in api]
        vol_bbls_60_ = [w_/t_ for (w_,t_) in zip(weight,t13_)]
        
        weight_sg60_ = sum([v_*s_ for (v_,s_) in zip(vol_bbls_60_,sg60_)])/sum(vol_bbls_60_)
        weight_api_ = 141.5/weight_sg60_ - 131.5
        
        weight_temp_ = sum([v_*s_ for (v_,s_) in zip(vol_bbls_60_,temp)])/sum(vol_bbls_60_)
        
        return weight_api_, weight_temp_
        
    
    def run(self, dat_file='input.dat', num_plans=100):
        
        self.plan = {}
        self.plan['ship_status'] = []
        self.plan['message'] = {}
        self.plan['constraint'] = []
        
        if not self.input.error:
            
            if self.input.solver in ['AMPL']:
                print('run AMPL ....')
                result = self._run_ampl(dat_file=dat_file) 
            else:
                print('run ORTOOLS ....')
                result = self._run_ortools()
            
            if result['succeed']:
                self._process_ampl(result, num_plans=num_plans)
                self._process_checking_plans(result)
                
            else:
                self.plan['message']['Optimization Error'] = result['message']
        else:
            self.plan['message'] = self.input.error
            
            
    def gen_json(self, constraints, stability_values):
        data = {}
        data['message'] = None
        data['processId'] = self.input.process_id
        
        if len(self.plan['ship_status']) == 0:
            data['loadablePlanDetails'] = [] #self.plan['message']
            #data['message'] = self.input.error + self.plan['message']
            
            data['message'] = {**self.input.error, **self.plan['message']}
            
            data['errors'] = self._format_errors(data['message'])
            
            return data
        
        
        
        # data['loadableStudyId'] = str(self.input.loadable_id)
        # data['vesselId'] = str(self.input.vessel_id)
        # data['voyageId'] = str(self.input.voyage_id)
        
        # all loading port
        path_ = [self.input.port.info['portOrder'][str(i_+1)]  for i_ in range(self.input.port.info['numPort'])]
        
        data['loadablePlanDetails'] = []
        for s_ in range(len(self.plan['ship_status'])):
            plan = {}
            plan['caseNumber'] = str(s_+1)
            plan['loadablePlanPortWiseDetails'] = []
            plan['constraints'] = constraints.get(str(s_),{})
            plan['stabilityParameters'] = stability_values[s_][self.input.loadable.info['arrDepVirtualPort'][str(self.input.port.info['lastLoadingPort'])+'D']]
            plan['slopQuantity'] = str(self.plan['slop_qty'][s_])
            
            for p__,p_ in enumerate(path_):
                plan_ = {}
                plan_['portId'] = str(self.input.port.info['portRotation'][p_]['portId'])
                plan_['portCode'] = p_
                plan_['portRotationId'] = self.input.port.info['portRotation'][p_]['portRotationId']
                # arrival
                plan_['arrivalCondition'] = {"loadableQuantityCargoDetails":[],
                                              "loadableQuantityCommingleCargoDetails":[],
                                              "loadablePlanStowageDetails":[],
                                              "loadablePlanBallastDetails":[],
                                              "loadablePlanRoBDetails":[]}
                
                if p_ not in [path_[0]]:
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
                    
                
                plan['loadablePlanPortWiseDetails'].append(plan_)
                
            data['loadablePlanDetails'].append(plan)
        data['message'] = {'limits':self.input.limits}
                
      
        return data

    def _get_status(self,sol,port,category):
        plan_ = []
        virtual_ = self.input.loadable.info['arrDepVirtualPort'][port]
        
        if category == 'total':
            
            for k_, v_ in self.plan['cargo_status'][sol][virtual_].items():
                if v_ > 0.:
                    info_ = {}
                    info_["cargoId"] = str(self.input.loadable.info['parcel'][k_]['cargoId'])
                    info_['cargoAbbreviation'] = self.input.loadable.info['parcel'][k_]['abbreviation']
                    info_['estimatedAPI'] = str(self.input.loadable.info['parcel'][k_]['api'])
                    info_['estimatedTemp'] = str(self.input.loadable.info['parcel'][k_]['temperature'])
                    info_['loadableMT'] = str(v_)
                    info_['priority'] = str(self.input.loadable.info['parcel'][k_]['priority'])
                    info_['colorCode'] = self.input.loadable.info['parcel'][k_]['color']
                    intend_ = self.input.loadable.info['toLoadIntend'][k_]
                    info_['orderedQuantity'] = str(round(intend_,DEC_PLACE))
                    info_['differencePercentage'] = str(round((v_-intend_)/intend_*100,2))
                    info_['loadingOrder'] = str(self.plan['cargo_order'][sol][k_])
                    info_["maxTolerance"] = str(self.input.loadable.info['parcel'][k_]['minMaxTol'][1])
                    info_["minTolerance"] = str(self.input.loadable.info['parcel'][k_]['minMaxTol'][0])
          
          
                    plan_.append(info_)
            
        elif category == 'cargoStatus':
                        
            for k_,v_ in self.plan['ship_status'][sol][virtual_]['cargo'].items():
                # print(k_,v_)
                if type(v_[0]['parcel']) == str and v_[0]['parcel'] in self.input.loadable.info['parcel'].keys():
                    info_ = {}
                    info_['tank'] = k_
                    info_['quantityMT'] = str(abs(v_[0]['wt']))
                    
                    info_['cargoAbbreviation'] = self.input.loadable.info['parcel'][v_[0]['parcel']]['abbreviation']
                    info_['tankId'] = str(self.input.vessel.info['tankName'][k_])
                    info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                    info_['tankName'] = self.input.vessel.info['cargoTanks'][k_]['name']
                    
                    
                    info_['temperature'] = str(self.input.loadable.info['parcel'][v_[0]['parcel']]['temperature'])
                    info_['colorCode'] = self.input.loadable.info['parcel'][v_[0]['parcel']]['color']
                    info_['api'] = str(self.input.loadable.info['parcel'][v_[0]['parcel']]['api'])
                    
                    info_['cargoNominationId'] = v_[0]['parcel'][1:]
                    info_['onboard'] = self.input.vessel.info['onboard'].get(k_,{}).get('wt',0.)
                    
                    vol_ = abs(v_[0]['wt'])/v_[0]['SG']
                    info_['rdgUllage'] = str(round(self.input.vessel.info['ullage_func'][str(info_['tankId'])](vol_).tolist(), 2))
                   
                    plan_.append(info_)
                    
                elif type(v_[0]['parcel']) == str:
                	# only onboard 
                    info_ = {}
                    info_['tank'] = k_
                    info_['quantityMT'] = str(abs(v_[0]['wt']))
                    info_['cargoAbbreviation'] = None
                    info_['tankId'] = str(self.input.vessel.info['tankName'][k_])
                    
                    
                    info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                    info_['tankName'] = self.input.vessel.info['cargoTanks'][k_]['name']
                    info_['temperature'] = None
                    info_['colorCode'] = self.input.vessel.info['cargoTanks'][k_]['colorCode']
                    info_['api'] = self.input.vessel.info['cargoTanks'][k_]['api']
                    
                    vol_ = abs(v_[0]['wt'])/v_[0]['SG']
                    info_['rdgUllage'] = str(round(self.input.vessel.info['ullage_func'][str(info_['tankId'])](vol_).tolist(), 2))
                    info_['cargoNominationId'] = ''
                    info_['onboard'] = self.input.vessel.info['onboard'].get(k_,{}).get('wt',0.)
                    
                    plan_.append(info_)
                    
                    
                    
        elif category == 'commingleStatus':
            
            for k_,v_ in self.plan['ship_status'][sol][virtual_]['cargo'].items():
                if type(v_[0]['parcel']) == list:
                    info_ = {}
                    
                    info_['tank'] = k_
                    info_['quantity'] = str(abs(v_[0]['wt']))
                    info_['cargo1Abbreviation'] = self.input.loadable.info['parcel'][v_[0]['parcel'][0]]['abbreviation']
                    info_['cargo2Abbreviation'] = self.input.loadable.info['parcel'][v_[0]['parcel'][1]]['abbreviation']
                    info_['priority'] = str(self.input.loadable.info['commingleCargo']['priority'])
                    
                    info_['parcel1Id'] = v_[0]['parcel'][0][1:]
                    info_['parcel2Id'] = v_[0]['parcel'][1][1:]
                     
                    
                    
                    info_['priority'] = str(self.input.loadable.info['commingleCargo']['priority'])
                    info_['cargo1Percentage'] = str(round(v_[0]['wt1percent']*100,2))
                    info_['cargo2Percentage'] = str(round(v_[0]['wt2percent']*100,2))
                    info_['cargo1MT'] = str(v_[0]['wt1'])
                    info_['cargo2MT'] = str(v_[0]['wt2'])
                    
                    info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                    info_['temp'] = str(v_[0]['temperature'])
                    
                    info_['api'] =  str(round(v_[0]['api'],2))
                    info_['tankId'] = self.input.vessel.info['tankName'][k_]
                    info_['tankName'] = self.input.vessel.info['cargoTanks'][k_]['name']
                    vol_ = abs(v_[0]['wt'])/v_[0]['SG']
                    info_['rdgUllage'] = round(self.input.vessel.info['ullage_func'][str(info_['tankId'])](vol_).tolist(), 2)
                   
                    info_['onboard'] = self.input.vessel.info['onboard'].get(k_,{}).get('wt',0.)
                    plan_.append(info_)
                
        elif category == 'ballastStatus':
            
            for k_,v_ in self.plan['ship_status'][sol][virtual_]['ballast'].items():
                info_ = {}
                info_['tank'] = k_
                info_['quantityMT'] = str(round(abs(v_[0]['wt']),2))
                info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                info_['sg'] = str(v_[0]['SG'])
                
                info_['tankId'] = str(self.input.vessel.info['tankName'][k_])
                info_['tankName'] = self.input.vessel.info['ballastTanks'][k_]['name']
                vol_ = np.floor(abs(v_[0]['wt'])/v_[0]['SG']) # + self.input.vessel.info['onboard'].get(k_,{}).get('vol',0.)
                
                try:
                    ul_= self.input.vessel.info['ullage_func'][str(info_['tankId'])](vol_).tolist()
                except:
                    print(k_, vol_)
                    ul_ = 0.
                info_['rdgLevel'] = str(round(ul_, 2))
                
                plan_.append(info_)
                
                
        elif category == 'robStatus':
            
            for k_,v_ in self.plan['ship_status'][sol][virtual_]['other'].items():
                info_ = {}
                info_['tank'] = k_
                info_['quantity'] = str(abs(v_[0]['wt']))
                info_['sg'] = str(v_[0]['SG'])
                info_['tankId'] = str(self.input.vessel.info['tankName'][k_])
             
                plan_.append(info_)
        
        return plan_
        

    def _format_errors(self, message):
        errors = []
        for k_, v_ in message.items():
            errors.append({"errorHeading":k_, "errorDetails":v_})
    
        return errors
  
            
    def _cal_density(self, api, temperature_F):
        
        temperature = ((temperature_F - 32)*5/9*100+0.5)/100
        # temp_F_ = round(temperature*1.8+32,1)
        
        sg_60_ = round(141.5/(api+131.5),4) # SG@60F
        
        # density@15C in vacuum
        if sg_60_ < 0.68:
            density_15C_ = sg_60_ - 0.0001
        elif sg_60_ < 0.7389:
            density_15C_ = sg_60_ - 0.0002
        elif sg_60_ < 0.7929:
            density_15C_ = sg_60_ - 0.0003
        elif sg_60_ < 0.8609:
            density_15C_ = sg_60_ - 0.0004
        elif sg_60_ < 0.9549:
            density_15C_ = sg_60_ - 0.0005
        else:
            density_15C_ = sg_60_ - 0.0006
            
        vcf_ = np.exp(-(613.97231/(density_15C_*1000)**2)*(temperature-15.0)*(1.0+(0.8*(613.97231/(density_15C_*1000)**2)*(temperature-15.0))))
        
        # density@15C in air == density_15C_-0.0011
        density = (density_15C_-0.0011)*vcf_  # 
        
        # temp_diff_ = temperature - 15
        # density_ = density_15C_ - 0.0006*temp_diff_
        
#        print(temp_F_,sg_60_,round(density_15C_,4),round(vcf_,5),round(density_,4))
    
        return round(density,4)
                
        
        