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

CONS = {'Condition01z': 'Min tolerance constraints violated!!',
            'Constr122': 'Priority constraints violated!!'}

class Generate_plan:
    def __init__(self, data):

        self.input = data
        self.commingled = False
        self.rerun = False
        self.full_load = False
        self.IIS = True
        
        
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
                # self.rerun = False
                # if self.rerun:
                #     print('Rerun due to miss temperature in commingle cargo!!')
                #     self.input.loadable._create_operations(self.input) # operation and commingle
                #     self.input.write_dat_file()
                    
                #     if self.input.solver in ['AMPL']:
                #         print('run AMPL ....')
                #         result = self._run_ampl(dat_file=dat_file) 
                #     else:
                #         print('run ORTOOLS ....')
                #         result = self._run_ortools()
                #     self._process_ampl(result, num_plans=num_plans)
                    
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
            model_ = 'model_2i.mod' if self.input.mode in ['FullManual'] else 'model_1i.mod'
            print(model_)
            ampl = AMPL()
            # ampl.option['show_presolve_messages'] = True
            if self.input.mode in ['Manual'] or not self.IIS:
                ampl.option['presolve'] = False
                
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
                
                if round(self.input.loadable.info['toLoadPort'].max(),3) == round(tot_load[0][1],3):
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
                            print(cons[int(v_[0])-1][1])
                            
                            if cons[int(v_[0])-1][1].split('[')[0] not in violated_cons_:
                                violated_cons_.append(cons[int(v_[0])-1][1].split('[')[0])
                                
                                
                    if len(violated_cons_) == 0 :
                        ampl = AMPL()
                        ampl.option['presolve'] = False
                        ampl.read(model_)
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
                    
                    for l_ in violated_cons_:
                        
                         con_ = CONS.get(l_,None)
                         if con_ not in [None]:
                             message.append(con_)
                         else:
                             message.append(l_ + ' violated!!')
                         
                         
                    
           
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
                
                print("{:.3f}".format(self.input.loadable.info['toLoadPort'].max()), "{:.3f}".format(tot_load[0][1]))
                
                
            
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
        
        self.other_weight, self.initial_ballast_weight = [], []
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
                        
            self.plans['operation'].append(operation_)
            
            # status at departure: cargo tank only 
            ship_status_dep_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
            for i_ in result['ship_status']: # (1.0, 'P101', '3P', 1.0, 10000.0)
                if int(i_[0]) == (p_+1) and round(i_[4],DEC_PLACE) >= 0.01 and i_[1] in tank_cargo_[i_[2]]:
                    onboard_ = self.input.vessel.info['onboard'].get(i_[2],{}).get('wt',0.)
                    # if onboard_ > 0:
                    #     print(i_[2],i_[1],i_[4],onboard_)
                    #wt_ = round(i_[4] + onboard_ ,DEC_PLACE) 
                    wt_ = i_[4] + onboard_
                    density_ = self.input.loadable.info['parcel'][i_[1]]['maxtempSG']
                    capacity_ = self.input.vessel.info['cargoTanks'][i_[2]]['capacityCubm']
                    vol_ = wt_/density_ 
                    
                    tcg_ = 0.
                    if i_[2] in self.input.vessel.info['tankTCG']['tcg']:
                        tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][i_[2]]['vol'],
                                         self.input.vessel.info['tankTCG']['tcg'][i_[2]]['tcg'])
                    
                    fillingRatio_ =  round(vol_/capacity_,DEC_PLACE)
                    
                    if fillingRatio_ > .98:
                        print('**',i_[2], fillingRatio_)
                    
                    tankId_ = self.input.vessel.info['tankName'][i_[2]]
                    corrUllage_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist(), 6)

                    info_ = {'parcel':i_[1], 'wt': round(wt_,DEC_PLACE), 'SG': density_,
                             'fillRatio': fillingRatio_, 'tcg':tcg_, 
                             'temperature':self.input.loadable.info['parcel'][i_[1]]['temperature'],
                             'api':self.input.loadable.info['parcel'][i_[1]]['api'],
                             'corrUllage': corrUllage_,
                             'maxTankVolume':capacity_}
                    
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
                            
                            density_ = self.input.loadable._cal_density(round(api_,2), round(temp_,1))
                            vol_ = weight_/density_ 
                            
                            fillingRatio_ = round(vol_/capacity_,DEC_PLACE)
                            print(parcel1_,parcel2_, k1_, fillingRatio_, round(api_,2), round(temp_,1), density_, round(weight_,3))
                            
                            
                            tcg_ = 0.
                            if k1_ in self.input.vessel.info['tankTCG']['tcg']:
                                tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][k1_]['vol'],
                                                 self.input.vessel.info['tankTCG']['tcg'][k1_]['tcg'])
                            
                            tankId_ = self.input.vessel.info['tankName'][k1_]
                            corrUllage_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist(), 6)

                                  
                            info_ = {'parcel':parcel_, 'wt': round(weight_,3), 'SG': round(density_,4),
                                     'fillRatio': fillingRatio_, 'tcg':tcg_, 
                                     'temperature':round(temp_,2),
                                     'api':api_,
                                     'wt1':wt1_, 'wt2':wt2_,
                                     'wt1percent':wt1_/(wt1_+wt2_), 'wt2percent':wt2_/(wt1_+wt2_),
                                     'corrUllage':corrUllage_,
                                     'maxTankVolume':capacity_}
                            
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
                    
                    tankId_ = self.input.vessel.info['tankName'][k_]
                    corrUllage_ = round(self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist(), 6)

                        
                    info_ = {'parcel':'onboard', 'wt': wt_, 'SG': density_,
                             'fillRatio': round(v_['vol']/capacity_,DEC_PLACE), 'tcg':tcg_, 
                             'temperature':None,
                             'corrUllage': corrUllage_,
                             'maxTankVolume': capacity_}
                    
                    for k1_, v1_ in ship_status_dep_.items():
                        if not v1_.get(k_, []):
                            ship_status_dep_[k1_][k_] = [info_]
                    
                        
                        
                       
            # ballast status: departure/arrive for loading/discharging port         
            ballast_weight_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
            
            
            if self.input.mode in ['FullManual']:
                
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
                        
                        tankId_ = v__['tankId']    
                        try:
                            corrLevel_ = self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist()
                        except:
                            print('correct level not available:',i_[1], vol_)
                            corrLevel_ = 0.
                        
                        ballast_weight_[k_][tank_] = [{'wt': round(wt_,DEC_PLACE), 'SG':density_,
                                                          'fillRatio': round(v__['wt']/density_/capacity_,DEC_PLACE),
                                                          'tcg':tcg_, 
                                                          'corrLevel':round(corrLevel_,3),
                                                          'maxTankVolume':capacity_,
                                                          'volume':vol_}]
                
                
            
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
                            
                        tankId_ = self.input.vessel.info['tankName'][i_[1]]     
                        try:
                            corrLevel_ = self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist()
                        except:
                            print('correct level not available:',i_[1], vol_)
                            corrLevel_ = 0.
                        
                    
                        ballast_weight_[str(int(i_[2]))][i_[1]] = [{'wt': round(wt_,DEC_PLACE), 
                                                          'SG':density_,
                                                          'fillRatio': round(i_[3]/density_/capacity_,DEC_PLACE),
                                                          'tcg':tcg_,
                                                          'corrLevel':round(corrLevel_,3),
                                                          'maxTankVolume':capacity_,
                                                          'volume':vol_}]
                
                
                               
                                
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
            
            flow_rate = {'PVvalveWingTank': 3950,
                         'PVvalveCentreTank': 5790,
                         'maxLoadingRate': 20500,
                         'maxRiser': 20500,
                         'manifolds': 8056,
                         'dropLines': 8056,
                         'bottomLines': 10780,
                         'wingTankBranch': 4713,
                         'centreTankBranch': 6843}
            load_param = {'manifolds':[1,2,3],
                     'centreTank':[],
                     'wingTank': [],
                     'bottomLines': [1,2,3]
                    }
            
            loading_rate_, topping_ = {}, {}
            for k_, v_ in cargo_in_tank_.items():
                load_param['centreTank'], load_param['wingTank'] = [], []
                tank_num_ = 0
                for t_ in v_:
                    if t_[-1] in ['C']:
                        load_param['centreTank'].append(t_)
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
                loading_rate_[k_] = (self._cal_max_rate(load_param, flow_rate),add_)
                topping_[k_] = self._topping_seq(v_)
                
            self.loading_rate.append(loading_rate_)
            self.topping_seq.append(topping_)
                
                
            
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
            wt_ = j_
            vol_ = wt_/density_
            
            tcg_ = 0.
            if i_ in self.input.vessel.info['tankTCG']['tcg']:
                tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][i_]['vol'],
                                      self.input.vessel.info['tankTCG']['tcg'][i_]['tcg'])
                
            tankId_ = self.input.vessel.info['tankName'][i_]     
            try:
                corrLevel_ = self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist()
            except:
                print(i_, vol_, ': correctLevel not available!!')
                corrLevel_ = 0.
            
            initial_ballast_weight_[i_] = [{'wt': round(wt_,DEC_PLACE),
                                                  'SG':density_,
                                                  'fillRatio': round(j_/density_/capacity_,DEC_PLACE),
                                                  'tcg':tcg_, 'corrLevel':round(corrLevel_,3),
                                                  'maxTankVolume':capacity_,
                                                  'volume':vol_}]
        self.initial_ballast_weight = initial_ballast_weight_
            
 
        
        
    # def _assemble(self):
    #     ## still in virtual port 
    #     self.plans['obj'] = []
    #     self.plans['operation'] = []
    #     self.plans['ship_status'] = []
    #     self.plans['cargo_status'] = []
    #     self.plans['constraint'] = []
    #     self.plans['slop_qty'] = []
    #     self.plans['cargo_order'] = []
        
        
    #     self.num_plans = 1
        
    #     self.ship_status_dep, self.ballast_weight = [], []
        
    #     self.other_weight, self.initial_ballast_weight = [], []
    #     self.cargo_in_tank = []
        
    #     commingled_ = False
        
    #     ship_status_dep_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
    #     ballast_weight_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
        
    #     for k_, v_ in self.input.loadable.info['manualOperation'].items():
    #         for k__, v__ in v_.items():
    #             virtualport_ = int(k__)
    #             for i_ in v__:
    #                 tank_ = self.input.vessel.info['tankId'][int(i_['tankId'])]
    #                 cargo_ = k_
    #                 onboard_ = self.input.vessel.info['onboard'].get(tank_,{}).get('wt',0.)
    #                 wt_ = float(i_['qty']) + onboard_
    #                 density_ = self.input.loadable.info['parcel'][cargo_]['maxtempSG']
    #                 capacity_ = self.input.vessel.info['cargoTanks'][tank_]['capacityCubm']
    #                 vol_ = wt_/density_ 
    #                 tcg_ = 0.
    #                 if tank_ in self.input.vessel.info['tankTCG']['tcg']:
    #                     tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][tank_]['vol'],
    #                                      self.input.vessel.info['tankTCG']['tcg'][tank_]['tcg'])
                    
    #                 fillingRatio_ =  round(vol_/capacity_,DEC_PLACE)
                    
    #                 tankId_ = i_['tankId']
    #                 corrUllage_ = self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist()

                    
    #                 info_ = {'parcel':cargo_, 'wt': round(wt_,DEC_PLACE), 'SG': density_,
    #                          'fillRatio': fillingRatio_, 'tcg':tcg_, 
    #                          'temperature':self.input.loadable.info['parcel'][cargo_]['temperature'],
    #                          'api':self.input.loadable.info['parcel'][cargo_]['api'],
    #                          'corrUllage':corrUllage_}
                    
                    
    #                 for p_ in range(virtualport_, self.input.loadable.info['lastVirtualPort']+1):
    #                     if tank_ in ship_status_dep_[str(p_)].keys():
                            
    #                         if 
    #                         ship_status_dep_[str(p_)][tank_].append(info_)
    #                         commingled_ = True
    #                     else:
    #                         ship_status_dep_[str(p_)][tank_] = [info_]
                            
        
    #     if commingled_:
    #         print('Commingled ship_status') 
    #         for k_, v_ in ship_status_dep_.items():
    #             for k1_, v1_ in v_.items():
    #                 if len(v1_) > 1:
    #                     parcel1_ = self.input.loadable.info['commingleCargo']['parcel1']
    #                     parcel2_ = self.input.loadable.info['commingleCargo']['parcel2']
                        
    #                     parcel_ = [v1_[0]['parcel'], v1_[1]['parcel']]
                        
    #                     onboard_ = self.input.vessel.info['onboard'].get(k1_,{}).get('wt',0.)
    #                     # temperature_ = self.input.loadable.info['commingleCargo']['temperature']
                        
    #                     wt1_ = sum([vv_['wt'] for vv_ in v1_ if vv_['parcel'] == parcel1_]) - onboard_
    #                     wt2_ = sum([vv_['wt'] for vv_ in v1_ if vv_['parcel'] == parcel2_]) - onboard_
                        
    #                     weight_ = wt1_ + wt2_ + onboard_
                        
    #                     capacity_ = self.input.vessel.info['cargoTanks'][k1_]['capacityCubm']
                        
                       
    #                     api__ = [self.input.loadable.info['commingleCargo']['api1'], self.input.loadable.info['commingleCargo']['api2']]
    #                     wt__ = [wt1_,wt2_]
    #                     temp__ = [self.input.loadable.info['commingleCargo']['t1'], self.input.loadable.info['commingleCargo']['t2']]
    #                     api_, temp_ = self._get_commingleAPI(api__, wt__, temp__)
                        
    #                     density_ = self.input.loadable._cal_density(round(api_,2), round(temp_,1))
    #                     vol_ = weight_/density_ 
                        
    #                     fillingRatio_ = round(vol_/capacity_,DEC_PLACE)
    #                     print(parcel1_,parcel2_, k1_, fillingRatio_, round(api_,2), round(temp_,1), density_, round(weight_,3))
                        
                        
    #                     tcg_ = 0.
    #                     if k1_ in self.input.vessel.info['tankTCG']['tcg']:
    #                         tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][k1_]['vol'],
    #                                          self.input.vessel.info['tankTCG']['tcg'][k1_]['tcg'])
                        
    #                     tankId_ = self.input.vessel.info['tankName'][k1_]
    #                     corrUllage_ = self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist()

                           
    #                     info_ = {'parcel':parcel_, 'wt': round(weight_,3), 'SG': round(density_,4),
    #                              'fillRatio': fillingRatio_, 'tcg':tcg_, 
    #                              'temperature':round(temp_,2),
    #                              'api':api_,
    #                              'wt1':round(wt1_,DEC_PLACE), 'wt2':round(wt2_,DEC_PLACE),
    #                              'wt1percent':wt1_/(wt1_+wt2_), 'wt2percent':wt2_/(wt1_+wt2_),
    #                              'corrUllage':corrUllage_}
                        
    #                     # print(info_)
                        
    #                     ship_status_dep_[k_][k1_] = [info_]
                            
        
        
    #      # ballast status: departure/arrive for loading/discharging port         
            
    #     for k_, v_ in self.input.loadable.info['ballastOperation'].items():
    #         for v__ in v_:
    #             tank_ = self.input.vessel.info['tankId'][int(v__['tankId'])]
    #             density_ = 1.025
    #             capacity_ =  self.input.vessel.info['ballastTanks'][tank_]['capacityCubm']
    #             wt_ = v__['wt']
    #             vol_ = wt_/density_
                
    #             tcg_ = 0.
    #             if tank_ in self.input.vessel.info['tankTCG']['tcg']:
    #                 tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][tank_]['vol'],
    #                                   self.input.vessel.info['tankTCG']['tcg'][tank_]['tcg'])
                
    #             tankId_ = v__['tankId']    
    #             try:
    #                 corrLevel_ = self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist()
    #             except:
    #                 print(k_, vol_)
    #                 corrLevel_ = 0.
                
    #             ballast_weight_[k_][tank_] = [{'wt': round(wt_,DEC_PLACE), 'SG':density_,
    #                                               'fillRatio': round(v__['wt']/density_/capacity_,DEC_PLACE),
    #                                               'tcg':tcg_, 'corrLevel':corrLevel_}]
                
            
        
        
        
    #     for k_, v_ in self.input.vessel.info['onboard'].items():
    #         if k_ not in ['totalWeight']:
    #             print(k_, 'empty with onboard', v_)
    #             wt_ = v_['wt']  
    #             density_ = v_['wt']/v_['vol1']
    #             capacity_ = self.input.vessel.info['cargoTanks'][k_]['capacityCubm']
    #             vol_ = wt_/density_
                
    #             tcg_ = 0.
    #             if k_ in self.input.vessel.info['tankTCG']['tcg']:
    #                 tcg_ = np.interp(vol_, self.input.vessel.info['tankTCG']['tcg'][k_]['vol'],
    #                                  self.input.vessel.info['tankTCG']['tcg'][k_]['tcg'])
                    
                    
    #             tankId_ = self.input.vessel.info['tankName'][k_]
    #             corrUllage_ = self.input.vessel.info['ullage'][str(tankId_)](vol_).tolist()

                    
    #             info_ = {'parcel':'onboard', 'wt': round(wt_,DEC_PLACE), 'SG': round(density_,4),
    #                      'fillRatio': round(v_['vol']/capacity_,DEC_PLACE), 'tcg':tcg_, 
    #                      'temperature':None, 'corrUllage':corrUllage_}
                
    #             for k1_, v1_ in ship_status_dep_.items():
    #                 if not v1_.get(k_, []):
    #                     ship_status_dep_[k1_][k_] = [info_]        
                        
        
    #     # add ROB    
    #     other_weight_ = {str(pp_):{} for pp_ in range(0,self.input.loadable.info['lastVirtualPort']+1)} 
    #     for i_, j_ in self.input.vessel.info['onhand'].items():
    #         for k_, v_ in j_.items():
    #             info_ =  [{'wt': round(v_['wt'],DEC_PLACE), 
    #                                               'SG':round(v_['wt']/max(1.0,v_['vol']),DEC_PLACE),
    #                                               'tcg':v_['tcg']}]
        
    #             for k1_, v1_ in self.input.loadable.info['virtualArrDepPort'].items():
    #                 if v1_ == k_:
    #                     other_weight_[k1_][i_] =  info_
                        
    #     self.other_weight = other_weight_    
        
    #     cargo_in_tank_, max_tank_used_ = {}, 0
    #     # print(p_,'--------------------------------------------------------')
    #     # for k_, v_ in self.input.loadable.info['parcel'].items():
    #     #     tanks_ = [i_  for i_,j_ in tank_cargo_.items() if k_ in j_]
    #     #     # print(k_,tanks_)
    #     #     cargo_in_tank_[k_] = tanks_
    #     #     if len(tanks_) > max_tank_used_:
    #     #         max_tank_used_ = len(tanks_)
    #     #         self.max_tank_parcel = k_
                
    #     self.cargo_in_tank.append(cargo_in_tank_)
        
    #     # switch from departure only to departure/arrive for loading/discharging port
    #     ship_status_, cargo_status_ = {}, {}
    #     for i_ in range(0,self.input.loadable.info['lastVirtualPort']):
    #         ship_status_[str(i_)] = {'cargo':{},'ballast':{},'other':{}}
    #         ship_status_[str(i_)]['ballast'] = ballast_weight_[str(i_)]
            
    #         ship_status_[str(i_)]['cargo'] = ship_status_dep_[str(i_)]
    #         ship_status_[str(i_)]['other'] = self.other_weight[str(i_)]
            
    #         #cargo_status_[str(i_)] = {k_[1]:round(k_[3],3) for k_  in result['cargo_loaded_port'] if k_[0] == p_+1 and k_[2] == i_}
            
            
    #     self.plans['ship_status'].append(ship_status_)
    #     self.plans['cargo_status'].append(cargo_status_)
    #     self.plans['obj'].append(0)
            
            
        
            
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
                
                
            self.plans['ship_status'].append(ship_status_)
            self.plans['cargo_status'].append(cargo_status_)
            self.plans['obj'].append(round(result['obj'][p_][1],3))
            
            ##--------------------------------------------------------------
            slop_qty_ = {}
            for k_, v_ in ship_status_[str(self.input.loadable.info['lastVirtualPort']-1)]['cargo'].items():
                if k_ in ['SLS', 'SLP']:
                    if v_[0]['parcel'] not in slop_qty_.keys():
                        slop_qty_[v_[0]['parcel']]  = 0.
                        
                    slop_qty_[v_[0]['parcel']] += v_[0]['wt']
            self.plans['slop_qty'].append(slop_qty_)
            ##--------------------------------------------------------------
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
        
    

    
    
    def gen_json(self, constraints, stability_values):
        data = {}
        data['message'] = None
        data['processId'] = self.input.process_id
        data['user'] = self.input.user
        data['role'] = self.input.role
        data['hasLoadicator'] = self.input.has_loadicator
        
        data['errors'] = []
        
        data['validated'] = True if self.input.mode in ['Manual', 'FullManual'] else None
        
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
                
            data['loadablePlanDetails'].append(plan)
        data['message'] = {'limits':self.input.limits}
        
        if self.input.mode in ['Manual', 'FullManual']:
            data['loadablePlanDetails'] = data['loadablePlanDetails'][0]
                
      
        return data

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
                        info_['loadingHrs'] = str(round(self.plans['loading_hrs'][sol][k_][0]+self.plans['loading_hrs'][sol][k_][1], 2))
                        info_['cargoNominationTemperature'] = str(self.input.loadable.info['parcel'][k_]['loadingTemperature'])
                        
                        plan_.append(info_)
            
        elif category == 'cargoStatus':
                        
            for k_,v_ in self.plans['ship_status'][sol][virtual_]['cargo'].items():
                # print(k_,v_)
                if type(v_[0]['parcel']) == str and v_[0]['parcel'] in self.input.loadable.info['parcel'].keys():
                    info_ = {}
                    info_['tankShortName'] = k_
                    info_['quantityMT'] = str(abs(v_[0]['wt']))
                    
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
                    
                    info_['loadingHrs'] = str(round(l1_+l2_, 2))
                    
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
                
                info_['volume'] = str(round(v_[0]['volume'],2))
                info_['maxTankVolume'] = str(round(v_[0]['maxTankVolume'],3))
                
                
                plan_.append(info_)
                
                
        elif category == 'robStatus':
            
            for k_,v_ in self.plans['ship_status'][sol][virtual_]['other'].items():
                info_ = {}
                info_['tankShortName'] = k_
                info_['quantity'] = str(abs(v_[0]['wt']))
                info_['sg'] = str(v_[0]['SG'])
                info_['tankId'] = int(self.input.vessel.info['tankName'][k_])
             
                plan_.append(info_)
        
        return plan_
        

    def _format_errors(self, message):
        errors = []
        for k_, v_ in message.items():
            errors.append({"errorHeading":k_, "errorDetails":v_})
    
        return errors
    
    def _cal_max_rate(self, param, flow_rate):
        max_rate = 1000000
        
        components = {'manifolds':[['manifolds'], ['manifolds']],   # param, flow_rate
                      'drop':[['manifolds'], ['dropLines']], 
                      'bottom':[['bottomLines'],['bottomLines']],
                      'tanks':[['centreTank', 'wingTank'], ['centreTankBranch','wingTankBranch']], 
                      'PVvalves':[['centreTank', 'wingTank'], ['PVvalveCentreTank','PVvalveWingTank']], 
                      'maxVessel':[[''],['maxLoadingRate']],
                      'maxRiser':[[''],['maxRiser']]}
        rate = {}
        for k_, v_ in components.items():
            rate_ = 0
            for i_, j_ in zip(v_[0], v_[1]):
                # print(i_,j_, param.get(i_,1), flow_rate[j_])
                rate_ += len(param.get(i_,[1])) * flow_rate[j_]
            
            rate[k_] = rate_
            if max_rate > rate_:
                max_rate = rate_
            
        # print(rate)
        
        
        return max_rate
            

    def _topping_seq(self, tanks):
        fixed_order = ['SLP','5P','5C', '4P', '4C', '2P','2C', '1P','1C','3P', '3C']
        order_ = ['' for o_ in fixed_order]
        
        for t_ in tanks:
            t__ = t_ if t_ not in ['SLS'] else 'SLP'
            if t__ in fixed_order:
                i_ = fixed_order.index(t__)
                order_[i_] = t__
                
        order__ = [o_ for o_ in order_ if o_ not in ['']]
    
        # print(order__)
        
        seq = []
        for t_ in tanks:
            t__ = t_ if t_[-1] not in ['S'] else t_[:-1]+'P'
            # print(t_,t__)
            seq_ = {}
            seq_['shortName'] = t_
            seq_['tankId'] = self.input.vessel.info['tankName'][t_]
            seq_['sequenceOrder'] = order__.index(t__) + 1
            
            seq.append(seq_)
            
            
        # print(seq)
        
        return seq
                    
        
