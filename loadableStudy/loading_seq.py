# -*- coding: utf-8 -*-
"""
Created on Wed Jul 28 12:31:41 2021

@author: I2R
"""

"""
data.ship_status_dep, data.ballast_weight

data.input.loadable['stages']
{1: 'MaxLoading1', 2: 'MaxLoading2', 3: 'MaxLoading3', 4: 'MaxLoading4', 5: 'MaxLoading5', 6: 'Topping5', 7: 'Topping12'}
 
"""

import numpy as np
from copy import deepcopy

STAGE_INFO = ['time', 'foreDraft', 'meanDraft', 'afterDraft', 'trim', 'heel', 'airDraft', 'bendinMoment', 'shearForce' ]

class Loading_seq:
    def __init__(self, data, stability):
        
        self.plans = data   # .ship_status_dep, .ballast_weight 
        self.stability = stability[0]  # single plan only
        
        self.stages = []
        self.pre_port = 0 # for collecting ballast weight
        self.delay = 0
        self.last_plan = None
        
    def _get_ballast_rate(self, plan, port, prev_port, time):
        # stage_ = self.plans.input.loadable['stages'][port]
        # print(port, prev_port, time)
        pre_ballast_ = self.plans.input.loading.info['ballast'][0] if prev_port == 0 else self.plans.ballast_weight[0][str(prev_port)]
        cur_ballast_ = self.plans.ballast_weight[0][str(port)]
        
        deballast_amt_ = 0.
        ballast_amt_ = 0.
        
        for k_, v_ in cur_ballast_.items():
            cur_vol_ = v_[0]['vol']
            pre_vol_ = pre_ballast_.get(k_, [{}])[0].get('quantityM3',0.) if prev_port == 0 else  pre_ballast_.get(k_, [{}])[0].get('vol',0.)
            
            k1_ = self.plans.input.vessel.info['tankName'][k_]
            # print(k_, cur_vol_, pre_vol_)
            if round(cur_vol_,3) < round(pre_vol_,3):
                plan['deballastingRateM3_Hr'][k1_] = str(round((-cur_vol_ + pre_vol_)/time*60,2))
                deballast_amt_ += (-cur_vol_ + pre_vol_)
                
            elif round(cur_vol_,3) > round(pre_vol_,3):
                plan['ballastingRateM3_Hr'][k1_] = str(round((cur_vol_ - pre_vol_)/time*60,2))
                ballast_amt_ += (cur_vol_ - pre_vol_)
        
        for k_, v_ in pre_ballast_.items():         
           k1_ = self.plans.input.vessel.info['tankName'][k_]
           
           if k1_ not in plan['deballastingRateM3_Hr']  and k1_ not in plan['ballastingRateM3_Hr']:
               cur_vol_ = cur_ballast_.get(k_, [{}])[0].get('vol',0.)
               pre_vol_ = v_[0]['quantityM3'] if prev_port == 0 else  v_[0]['vol']
               
               # print(k_, cur_vol_, pre_vol_)
               if round(cur_vol_,3) < round(pre_vol_,3):
                    plan['deballastingRateM3_Hr'][k1_] = str(round((-cur_vol_ + pre_vol_)/time*60,2))
                    deballast_amt_ += (-cur_vol_ + pre_vol_)
               elif round(cur_vol_,3) > round(pre_vol_,3):
                    plan['ballastingRateM3_Hr'][k1_] = str(round((cur_vol_ - pre_vol_)/time*60,2))
                    ballast_amt_ += (cur_vol_ - pre_vol_)
               
        # print(deballast_amt_, ballast_amt_)
        plan['totBallastingRateM3_Hr'] = str(round(ballast_amt_/time*60,2))
        plan['totDeballastingRateM3_Hr'] = str(round(deballast_amt_/time*60,2))
        # print(deballast_amt_, time)
        
        
        
               
            
               
        
    def _stage(self, info, cargo, cargo_order):
        
        ##print(info['stage'])
        
        # stages_
        # {'initialCondition': (0, 0), 'openSingleTank': (0, 5), 'initialRate': (5, 15), 'openAllTanks': (15, 20), 'increaseToMaxRate': (20, 30), 'loadingAtMaxRate': (30, 312), 'topping': (312, 342)}
        # start_time_
        # 342
        
        start_time_ = self.plans.input.loading.seq[cargo]['startTime']
        if info['stage'] == 'initialCondition':
            self.delay += self.plans.input.loading.info['timing_delay1'][self.plans.input.loading.info['loading_order1'][cargo]-1]
        
        start_ = int(self.plans.input.loading.seq[cargo]['stageInterval'][info['stage']][0] + start_time_ + self.delay)
        end_   = int(self.plans.input.loading.seq[cargo]['stageInterval'][info['stage']][1] + start_time_ + self.delay)
        info["timeStart"] = str(start_)
        info["timeEnd"] = str(end_)
        
        # info["timeStart"] = ''
        # info["timeEnd"] = ''
        info["toLoadicator"] = False
        info["jumpStep"] = False
        info['loadablePlanPortWiseDetails'] = []
        info["cargoValves"] = []
        info["ballastValves"] = []
        
        info["ballastRateM3_Hr"] = {}
        info["deballastingRateM3_Hr"] = {}
        info["cargoLoadingRatePerTankM3_Hr"] = []
        info["cargoLoadingRateM3_Hr"] = {}
        info["ballast"] = {}
        info["eduction"] = {}
            
        if info['stage'] == 'initialCondition':
            # print('----', info['stage'])
            info["toLoadicator"] = True
            info["jumpStep"] = True
            plan_ = {'time': str(int(info["timeStart"])), 
                     "loadableQuantityCommingleCargoDetails":[],
                     "loadablePlanStowageDetails":[],
                     "loadablePlanBallastDetails":[],
                     "loadablePlanRoBDetails":[]}
            
            if cargo_order == 1:
                self._get_plan(plan_)
            else:
                plan_ = {k_: v_ for k_, v_ in self.last_plan.items() if k_ in ['time', 'loadableQuantityCommingleCargoDetails', 'loadablePlanStowageDetails', 'loadablePlanBallastDetails', 'loadablePlanRoBDetails', 'ballastVol', 'cargoVol', 'foreDraft', 'meanDraft', 'afterDraft', 'trim', 'heel', 'airDraft', 'bendinMoment', 'shearForce']}
            
            
            plan_['time'] = info["timeEnd"]
            info['loadablePlanPortWiseDetails'].append(plan_)
            
            if cargo_order == 1:
                self.initial_plan = plan_
            
            if len(self.stages) > 0 and (self.stages[-1]['time'] == plan_['time']):
                pass
            else:
                
                info_ = {'time': plan_['time'], 
                         'foreDraft': plan_['foreDraft'], 
                         'meanDraft': plan_['meanDraft'], 
                         'afterDraft': plan_['afterDraft'], 
                         'trim': plan_['trim'], 
                         'heel': None, 
                         'gom': None,
                         'airDraft': plan_['airDraft'],
                         'bendinMoment': plan_['bendinMoment'], 
                         'shearForce': plan_['shearForce']
                         }
                self.stages.append(info_)
            
            info['simDeballastingRateM3_Hr'] = [{}]
            info['simBallastingRateM3_Hr'] = [{}]
            
        elif info['stage'] == 'openSingleTank':
            
            info['simCargoLoadingRatePerTankM3_Hr'] = [{}]
            info['simDeballastingRateM3_Hr'] = [{}]
            info['simBallastingRateM3_Hr'] = [{}]
            
                
            # c"deballastingRateM3_Hr"] = {}
            # info["ballast"] = {}
            
            # info["cargoValves"] = []
            # info["ballastValves"] = []
            
        elif info['stage'] == "initialRate":
            
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['initialRate'])}
            info['simDeballastingRateM3_Hr'] = [{}]
            info['simBallastingRateM3_Hr'] = [{}]
            
            
            if self.plans.input.loading.seq[cargo]['firstTank'] in self.plans.input.vessel.info['tankName']:
                tankId_ = self.plans.input.vessel.info['tankName'][self.plans.input.loading.seq[cargo]['firstTank']]
                info["cargoLoadingRatePerTankM3_Hr"] = [{tankId_: str(self.plans.input.loading.seq[cargo]['initialRate'])}]
                
                info["simCargoLoadingRatePerTankM3_Hr"] = [{tankId_: {"tankShortName":self.plans.input.vessel.info['tankId'][tankId_],
                                                                      "rate":str(self.plans.input.loading.seq[cargo]['initialRate']),
                                                                      "timeStart": info["timeStart"],
                                                                      "timeEnd": info["timeEnd"]}}]
                
            else:
                tank1_, tank2_ = self.plans.input.loading.seq[cargo]['firstTank'][:-1]+'P', self.plans.input.loading.seq[cargo]['firstTank'][:-1]+'S'
                tank1Id_ = self.plans.input.vessel.info['tankName'][tank1_]
                tank2Id_ = self.plans.input.vessel.info['tankName'][tank2_]
                
                info["cargoLoadingRatePerTankM3_Hr"] = [{tank1Id_: str(self.plans.input.loading.seq[cargo]['initialRate']/2),
                                                        tank2Id_: str(self.plans.input.loading.seq[cargo]['initialRate']/2)}]
            
                info["simCargoLoadingRatePerTankM3_Hr"] = [{tank1Id_: {"tankShortName":self.plans.input.vessel.info['tankId'][tank1Id_],
                                                                      "rate":str(self.plans.input.loading.seq[cargo]['initialRate']/2),
                                                                      "timeStart": info["timeStart"],
                                                                       "timeEnd": info["timeEnd"]},
                                                           tank2Id_: {"tankShortName":self.plans.input.vessel.info['tankId'][tank2Id_],
                                                                      "rate":str(self.plans.input.loading.seq[cargo]['initialRate']/2),
                                                                      "timeStart": info["timeStart"],
                                                                      "timeEnd": info["timeEnd"]}}]
                                                           
                                                                      
            # info["ballast"] = {}
            # info["deballastingRateM3_Hr"] = {}
            
        elif info['stage'] == "openAllTanks":
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['initialRate'])}
            info['simDeballastingRateM3_Hr'] = [{}]
            info['simBallastingRateM3_Hr'] = [{}]
           
            tot_num_ = len(self.plans.input.loadable['toLoadCargoTank'][cargo])
            rate_ = round(self.plans.input.loading.seq[cargo]['initialRate']/tot_num_,2)
            info["cargoLoadingRatePerTankM3_Hr"] = [{self.plans.input.vessel.info['tankName'][k_]:str(rate_) for k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items()}]
            
            info["simCargoLoadingRatePerTankM3_Hr"] = []
            info1_ = {}
            for k_, v_ in info["cargoLoadingRatePerTankM3_Hr"][0].items():
                info1_[k_] = {'tankShortName': self.plans.input.vessel.info['tankId'][k_],
                                                               "rate": v_, 
                                                               "timeStart": info["timeStart"],
                                                               "timeEnd": info["timeEnd"]}
            
            info["simCargoLoadingRatePerTankM3_Hr"].append(info1_)
            
        elif info['stage'] == "increaseToMaxRate":
           
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['initialRate'])}
            info['simDeballastingRateM3_Hr'] = [{}]
            info['simBallastingRateM3_Hr'] = [{}]
           
            tot_num_ = len(self.plans.input.loadable['toLoadCargoTank'][cargo])
            rate_ = round(self.plans.input.loading.seq[cargo]['initialRate']/tot_num_,2)
            info["cargoLoadingRatePerTankM3_Hr"] = [{self.plans.input.vessel.info['tankName'][k_]:str(rate_) for k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items()}]
            
            info["simCargoLoadingRatePerTankM3_Hr"] = []
            info1_ = {}
            for k_, v_ in info["cargoLoadingRatePerTankM3_Hr"][0].items():
                
                info1_[k_] = {'tankShortName': self.plans.input.vessel.info['tankId'][k_],
                                                               "rate": v_, 
                                                               "timeStart": info["timeStart"],
                                                               "timeEnd": info["timeEnd"]}
                
            info["simCargoLoadingRatePerTankM3_Hr"].append(info1_)
            
        elif info['stage'] == "loadingAtMaxRate":
                        
            info['simDeballastingRateM3_Hr'] = []
            info['simBallastingRateM3_Hr'] = []
            
            info['totDeballastingRateM3_Hr'] = []
            info['totBallastingRateM3_Hr'] = []
            
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['maxShoreRate'])}
            
            tot_num_ = len(self.plans.input.loadable['toLoadCargoTank'][cargo])
            # rate_ = round(self.plans.input.loading.seq[cargo]['initialRate']/tot_num_,2)
            info["cargoLoadingRatePerTankM3_Hr"] = []
            info["simCargoLoadingRatePerTankM3_Hr"] = []
            
            
            if self.plans.input.loading.seq[cargo]['commingleStart'] in [None]:
                info1_, info2_ = {}, {}
                for  k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items():
                    if v_ > 0:
                        if k_[-1] in ['C'] or k_ in self.plans.input.vessel.info['slopTank']:
                            rate_ = self.plans.input.loading.seq[cargo]['loadingRateM3Min'][k_]*60
                        else:
                            k1_ = k_[:-1]+'W'
                            rate_ = self.plans.input.loading.seq[cargo]['loadingRateM3Min'][k1_]*60/2
                            
                        info1_[self.plans.input.vessel.info['tankName'][k_]] = str(round(rate_,2))
                        info2_[self.plans.input.vessel.info['tankName'][k_]] = {'tankShortName': k_,
                                                                                 "rate": str(round(rate_,2)), 
                                                                                 "timeStart": info["timeStart"],
                                                                                 "timeEnd": info["timeEnd"]}
                            
                info["cargoLoadingRatePerTankM3_Hr"].append(info1_)
                info["simCargoLoadingRatePerTankM3_Hr"].append(info2_)
                                                                                                                  
            else:
                info1_, info2_ = {}, {}
                loadingRateM3Min = self.plans.input.loading.seq[cargo]['loadingRateM3Min'][0]
                commingleStart_ = str(int(info["timeStart"]) + self.plans.input.loading.seq[cargo]['commingleStart'] - 30)
                
                for  k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items():
                    
                    t_ = k_ if k_[-1] in ['C'] or k_ in self.plans.input.vessel.info['slopTank'] else k_[:-1]+'W'
                    if v_ > 0 and loadingRateM3Min[t_] > 0:
                        if k_[-1] in ['C'] or k_ in self.plans.input.vessel.info['slopTank']:
                            rate_ = loadingRateM3Min[k_]*60
                        else:
                            k1_ = k_[:-1]+'W'
                            rate_ = loadingRateM3Min[k1_]*60/2
                            
                        info1_[self.plans.input.vessel.info['tankName'][k_]] = str(round(rate_,2))
                        info2_[self.plans.input.vessel.info['tankName'][k_]] = {'tankShortName': k_,
                                                                                 "rate": str(round(rate_,2)), 
                                                                                 "timeStart": info["timeStart"],
                                                                                 "timeEnd": commingleStart_}
                            
                info["cargoLoadingRatePerTankM3_Hr"].append(info1_)
                info["simCargoLoadingRatePerTankM3_Hr"].append(info2_)
                
                info1_, info2_ = {}, {}
                loadingRateM3Min = self.plans.input.loading.seq[cargo]['loadingRateM3Min'][1]
                for  k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items():
                    if v_ > 0:
                        if k_[-1] in ['C'] or k_ in self.plans.input.vessel.info['slopTank']:
                            rate_ = loadingRateM3Min[k_]*60
                        else:
                            k1_ = k_[:-1]+'W'
                            rate_ = loadingRateM3Min[k1_]*60/2
                            
                        info1_[self.plans.input.vessel.info['tankName'][k_]] = str(round(rate_,2))
                        info2_[self.plans.input.vessel.info['tankName'][k_]] = {'tankShortName': k_,
                                                                                 "rate": str(round(rate_,2)), 
                                                                                 "timeStart": str(max(int(commingleStart_),int(info["timeStart"]))),
                                                                                 "timeEnd": info["timeEnd"]}
                            
                info["cargoLoadingRatePerTankM3_Hr"].append(info1_)
                info["simCargoLoadingRatePerTankM3_Hr"].append(info2_)
            
            info["toLoadicator"] = True            
            info["jumpStep"] = True
            info['simIniDeballastingRateM3_Hr'] = {}
            info['simIniBallastingRateM3_Hr'] = {}
            info['iniDeballastingRateM3_Hr'] = {}
            info['iniBallastingRateM3_Hr'] = {}
            info['iniTotDeballastingRateM3_Hr'] = 0.
            info['iniTotBallastingRateM3_Hr'] = 0.
            info['stageEndTime'] = {}
            
            pre_port_ = self.pre_port
            # print('self.pre_port', self.pre_port)
            # {1: 'MaxLoading11', 2: 'MaxLoading21', 3: 'MaxLoading31', 4: 'MaxLoading41', 5: 'MaxLoading51', 6: 'MaxLoading61', 7: 'Topping61', 8: 'MaxLoading12', 9: 'MaxLoading22', 10: 'MaxLoading32', 11: 'Topping42'}
            for k_, v_ in self.plans.input.loadable['stages'].items():
                
                justBeforeTopping = v_[:-1] == self.plans.input.loading.seq[cargo]['justBeforeTopping'] 
                
                # print(v_, justBeforeTopping)
                
                if v_[:3] in ['Max'] and v_[-1] == str(cargo_order) and (not justBeforeTopping):
                    time_ = int(self.plans.input.loading.seq[cargo]['gantt'][v_[:-1]]['Time'] + self.plans.input.loading.seq[cargo]['startTime'] + self.delay)
                    plan_ = {'time': str(time_), 
                             "loadableQuantityCommingleCargoDetails":[],
                             "loadablePlanStowageDetails":[],
                             "loadablePlanBallastDetails":[],
                             "loadablePlanRoBDetails":[]}
                    
                    port_ = [a_ for a_, b_ in self.plans.input.loadable['stages'].items() if b_ == v_][0]
                    self._get_plan(plan_, port_)
            
                    info['loadablePlanPortWiseDetails'].append(plan_)
                    
                    info['stageEndTime'][v_[:-1]] = time_
                    
                    info_ = {} # get stability info
                    for a_, b_ in plan_.items():
                        if a_ in STAGE_INFO:
                            info_[a_] = b_
                            # if a_ in ['time']:
                            #     info_[a_] = str(int(info_[a_]) + self.delay)
                            
                    self.stages.append(info_)
                    
                    ballast_plan_ = {'deballastingRateM3_Hr':{}, 'ballastingRateM3_Hr':{}}
                    cur_time_ = self.plans.input.loadable['stageTimes'][port_]
                    pre_time_ = self.plans.input.loadable['stageTimes'].get(pre_port_, 0.)
                    
                    # print(cur_time_, pre_time_)
                    educt_ = self.plans.input.loading.seq[cargo].get('eduction', (None,None))
                    if  educt_[1] == v_[:-1]:
                        print('eduction', educt_, v_)
                        time_ = educt_[0]
                        
                    elif info['gravityNeeded'] and cargo_order == 1:
                        time1_ = self.plans.input.loading.seq[cargo]['ballastLimit'][v_[:-1]]
                        time_ = cur_time_-pre_time_
                        # print('gravity:', v_[:-1], time_, time1_)
                        time_ = min(time_, time1_)
                        
                    else:
                        time_ = cur_time_-pre_time_
                        
                    if time_ > 0:
                        self._get_ballast_rate(ballast_plan_, port_, pre_port_, time_)
                    
                    plan_['deballastingRateM3_Hr'] = ballast_plan_['deballastingRateM3_Hr']
                    plan_['ballastingRateM3_Hr'] = ballast_plan_['ballastingRateM3_Hr']
                    # plan_['totDeballastingRateM3_Hr'] = ballast_plan_['totDeballastingRateM3_Hr']
                    # plan_['totBallastingRateM3_Hr'] = ballast_plan_['totBallastingRateM3_Hr']
                     
                    if pre_port_ == self.pre_port:
                        pre_time_ += 30  # start of maxloading1
                        
                    # print(port_,pre_port_,cur_time_,pre_time_)
                    # print()
                    if  educt_[1] == v_[:-1]:
                        start_ = int(pre_time_+self.delay)
                        end_ = int(pre_time_+ educt_[0] +self.delay)
                    elif info['gravityNeeded'] and cargo_order == 1:
                        start1_ = int(pre_time_+self.delay)
                        start2_ = self.delay + 120
                        start_ = max(start1_, start2_)
                        end_ = int(cur_time_+self.delay)
                    
                    else:
                        start_ = int(pre_time_+self.delay)
                        end_ = int(cur_time_+self.delay)
                    
                    
                    info_ = {}
                    for k1_, v1_ in  ballast_plan_['deballastingRateM3_Hr'].items():
                        info_[k1_] = {'tankShortName': self.plans.input.vessel.info['tankId'][k1_],
                                     'rate': v1_,
                                     "timeStart": str(start_), "timeEnd": str(end_)}
                    
                    info['simDeballastingRateM3_Hr'].append(info_)
                    
                    info_ = {}
                    for k1_, v1_ in  ballast_plan_['ballastingRateM3_Hr'].items():
                        info_[k1_] = {'tankShortName': self.plans.input.vessel.info['tankId'][k1_],
                                     'rate': v1_,
                                     "timeStart": str(start_), 
                                     "timeEnd": str(end_)}
                    
                    info['simBallastingRateM3_Hr'].append(info_)
                    
                    
                    info['totDeballastingRateM3_Hr'].append(ballast_plan_.get('totDeballastingRateM3_Hr', '0.00'))
                    info['totBallastingRateM3_Hr'].append(ballast_plan_.get('totBallastingRateM3_Hr', '0.00'))
                    
                    pre_port_ = port_
                    
                    if v_[:-1] == 'MaxLoading1':
                        
                        # pass to other stage prior to MaxLoading1
                        info['iniDeballastingRateM3_Hr'] = deepcopy(ballast_plan_['deballastingRateM3_Hr'])
                        info['iniBallastingRateM3_Hr'] = deepcopy(ballast_plan_['ballastingRateM3_Hr'])
                        
                        info['iniTotDeballastingRateM3_Hr'] = deepcopy(ballast_plan_.get('totDeballastingRateM3_Hr', '0.00'))
                        info['iniTotBallastingRateM3_Hr'] = deepcopy(ballast_plan_.get('totBallastingRateM3_Hr', '0.00'))
                        
                        
                        info['simIniDeballastingRateM3_Hr'] = deepcopy(info['simDeballastingRateM3_Hr'][0])
                        info['simIniBallastingRateM3_Hr'] = deepcopy(info['simBallastingRateM3_Hr'][0])
                        
                elif v_[:3] in ['Max'] and v_[-1] == str(cargo_order) and (justBeforeTopping):      
                    
                    # time_ = self.plans.input.loading.seq[cargo]['gantt'][v_[:-1]]['Time'] + self.plans.input.loading.seq[cargo]['startTime'] + self.delay
                    # plan_ = {'time': str(time_), 
                    #          "loadableQuantityCommingleCargoDetails":[],
                    #          "loadablePlanStowageDetails":[],
                    #          "loadablePlanBallastDetails":[],
                    #          "loadablePlanRoBDetails":[]}
                    
                    port_ = [a_ for a_, b_ in self.plans.input.loadable['stages'].items() if b_ == v_][0]
                    # self._get_plan(plan_, port_)
            
                    # info['loadablePlanPortWiseDetails'].append(plan_)
                    
                    # info_ = {}
                    # for a_, b_ in plan_.items():
                    #     if a_ in STAGE_INFO:
                    #         info_[a_] = b_
                    #         # if a_ in ['time']:
                    #         #     info_[a_] = str(int(info_[a_]) + self.delay)
                            
                    # self.stages.append(info_)
                    
                    ballast_plan_ = {'deballastingRateM3_Hr':{}, 'ballastingRateM3_Hr':{}}
                    cur_time_ = self.plans.input.loadable['stageTimes'][port_]
                    pre_time_ = self.plans.input.loadable['stageTimes'].get(pre_port_, 0.)
                    
                    info['stageEndTime'][v_[:-1]] = int(cur_time_ + self.delay)
                          
                   
                    educt_ = self.plans.input.loading.seq[cargo].get('eduction', (None,None))
                    if  educt_[1] == v_[:-1]:
                        print('eduction', educt_, v_)
                        time_ = educt_[0]
                        
                    elif info['gravityNeeded'] and cargo_order == 1:
                        time1_ = self.plans.input.loading.seq[cargo]['ballastLimit'][v_[:-1]]
                        time_ = cur_time_-pre_time_
                        # print('gravity:', v_[:-1], time_, time1_)
                        time_ = min(time_, time1_)
                        
                    else:
                        time_ = cur_time_-pre_time_
                        
                    if time_ > 0:
                        self._get_ballast_rate(ballast_plan_, port_, pre_port_, time_)
                    
                    plan_['deballastingRateM3_Hr'] = ballast_plan_['deballastingRateM3_Hr']
                    plan_['ballastingRateM3_Hr'] = ballast_plan_['ballastingRateM3_Hr']
                    
                    if pre_port_ == self.pre_port:
                        pre_time_ += 30  # start of maxloading1
                        
                    # print(port_,pre_port_,cur_time_,pre_time_)
                    # print()
                    
                    if  educt_[1] == v_[:-1]:
                        start_ = int(pre_time_+self.delay)
                        end_ = int(pre_time_+ educt_[0] +self.delay)
                    else:
                        start_ = int(pre_time_+self.delay)
                        end_ = int(cur_time_+self.delay)
                    
                    
                    info_ = {}
                    for k1_, v1_ in  ballast_plan_['deballastingRateM3_Hr'].items():
                        info_[k1_] = {'tankShortName': self.plans.input.vessel.info['tankId'][k1_],
                                     'rate': v1_,
                                     "timeStart": str(start_), "timeEnd": str(end_)}
                    
                    info['simDeballastingRateM3_Hr'].append(info_)
                    
                    info_ = {}
                    for k1_, v1_ in  ballast_plan_['ballastingRateM3_Hr'].items():
                        info_[k1_] = {'tankShortName': self.plans.input.vessel.info['tankId'][k1_],
                                     'rate': v1_,
                                     "timeStart": str(start_), 
                                     "timeEnd": str(end_)}
                    
                    info['simBallastingRateM3_Hr'].append(info_)
                    
                   
                    info['totDeballastingRateM3_Hr'].append(ballast_plan_.get('totDeballastingRateM3_Hr', '0.00'))
                    info['totBallastingRateM3_Hr'].append(ballast_plan_.get('totBallastingRateM3_Hr', '0.00'))
                  
                    
                    
                    pre_port_ = port_
                    
                    if v_[:-1] == 'MaxLoading1':
                        
                        # pass to other stage prior to MaxLoading1
                        info['iniDeballastingRateM3_Hr'] = deepcopy(ballast_plan_['deballastingRateM3_Hr'])
                        info['iniBallastingRateM3_Hr'] = deepcopy(ballast_plan_['ballastingRateM3_Hr'])
                        
                        info['simIniDeballastingRateM3_Hr'] = deepcopy(info['simDeballastingRateM3_Hr'][0])
                        info['simIniBallastingRateM3_Hr'] = deepcopy(info['simBallastingRateM3_Hr'][0])
                    
                    
                    
            self.pre_port = pre_port_
                    
        
        elif info['stage'] == "topping":
            
            
            info['simDeballastingRateM3_Hr'] = [{}]
            info['simBallastingRateM3_Hr'] = [{}]
            info["cargoLoadingRatePerTankM3_Hr"] = []
            info["simCargoLoadingRatePerTankM3_Hr"] = []
            
            info1_, info2_ = {}, {}
            for  k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items():
                if v_ > 0:
                    if k_[-1] in ['C'] or k_ in self.plans.input.vessel.info['slopTank']:
                        rate_ = self.plans.input.loading.seq[cargo]['staggerRate'].loc[k_,:].to_list()
                        r1_ = [r_  for r_ in rate_ if r_ not in [None]] # every 15min
                        rate_ = np.mean(r1_) 
                        
                    else:
                        k1_ = k_[:-1]+'W'
                        rate_ = self.plans.input.loading.seq[cargo]['staggerRate'].loc[k1_,:].to_list()
                        r1_ = [r_  for r_ in rate_ if r_ not in [None]] # every 15min
                        rate_ = np.mean(r1_)/2
                    
                    end_time_ = int(float(info['timeStart'])) + len(r1_)*15    
                    info1_[self.plans.input.vessel.info['tankName'][k_]] = str(round(rate_,2))
                    info2_[self.plans.input.vessel.info['tankName'][k_]] = {'tankShortName': k_,
                                                                             'rate':str(round(rate_,2)),
                                                                            "timeStart":info['timeStart'],
                                                                            'timeEnd':str(end_time_)}
            
            info["cargoLoadingRatePerTankM3_Hr"].append(info1_)
            info["simCargoLoadingRatePerTankM3_Hr"].append(info2_)
            
            # last item of last row
            for i_ in range(1,13):
                rate_ = self.plans.input.loading.seq[cargo]['staggerRate'].iloc[-i_,:].to_list()
                if len([j_ for j_ in rate_ if j_ not in [None]]) > 0:
                    reduce_rate_ = rate_[-1]
                    break
                    
            # reduce_rate_ = self.plans.input.loading.seq[cargo]['staggerRate'].iloc[-1,:].to_list()[-1]
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['maxShoreRate']),
                                             1:str(reduce_rate_) }
            
            
            info["toLoadicator"] = True
            info["jumpStep"] = True
            pre_port_ = self.pre_port
            
            for k_, v_ in self.plans.input.loadable['stages'].items():
                
                if v_[:3] in ['Top'] and v_[-1] == str(cargo_order):
                    
                    port_ = [a_ for a_, b_ in self.plans.input.loadable['stages'].items() if b_ == v_][0]
                    time_ = self.plans.input.loading.seq[cargo]['gantt'][v_[:-1]]['Time'] + self.plans.input.loading.seq[cargo]['startTime']
                    time1_ = self.plans.input.loading.seq[cargo]['gantt'][v_[:-1]]['Time'] 
                    if v_[:-1] !=  self.plans.input.loading.seq[cargo]['lastStage']:
                        # print(time_)
                        time0_ = time_
                        c_ = self.plans.input.loading.info['loading_order'][int(v_[-1])-1]
                        time_interval_ = self.plans.input.loading.time_interval[c_]
                        time_ = time_interval_ * round(time1_/time_interval_) + self.plans.input.loading.seq[cargo]['startTime']
                        print(v_, time0_, '->', time_)

                    plan_ = {'time': str(int(time_+self.delay)), 
                     "loadableQuantityCommingleCargoDetails":[],
                     "loadablePlanStowageDetails":[],
                     "loadablePlanBallastDetails":[],
                     "loadablePlanRoBDetails":[]}
                    
                    
                    self._get_plan(plan_, port_)
            
                    info['loadablePlanPortWiseDetails'].append(plan_)
                    
                    info_ = {}
                    for a_, b_ in plan_.items():
                        if a_ in STAGE_INFO:
                            info_[a_] = b_
                            # if a_ in ['time']:
                            #     info_[a_] = str(int(info_[a_]) + self.delay)
                            
                    self.stages.append(info_)
                    
                    if self.plans.input.loading.seq['stages'][-1] == v_:
                        self.final_plan = plan_
                        
                    ballast_plan_ = {'deballastingRateM3_Hr':{}, 'ballastingRateM3_Hr':{}}
                    
                    cur_time_ = self.plans.input.loadable['stageTimes'][port_]
                    pre_time_ = self.plans.input.loadable['stageTimes'].get(pre_port_, 0.)
                    
                    self._get_ballast_rate(ballast_plan_, port_, pre_port_, cur_time_-pre_time_)
                    pre_port_ = port_
                    plan_['deballastingRateM3_Hr'] = ballast_plan_['deballastingRateM3_Hr']
                    plan_['ballastingRateM3_Hr'] = ballast_plan_['ballastingRateM3_Hr']
                    
            self.pre_port = pre_port_
            self.last_plan = plan_
            
        
        else:
            print(info['stage'])
            exit(1)
    
    
    def _get_plan(self, plan, port=0):
        
        cargo_ = self.plans.plans['ship_status'][0][str(port)]['cargo'] # single plan
        if port not in [0]:
            ballast_ = self.plans.ballast_weight[0][str(port)] # single plan
        else:
            ballast_ = self.plans.initial_ballast_weight
        
        other_weight_ = self.plans.other_weight[str(port)]
        
        plan["ballastVol"] = 0.
        plan["cargoVol"] = {}
        
        cargo_tanks_added_, ballast_tanks_added_, other_tanks_added_ = [], [], []
        
        for k_, v_ in cargo_.items():
            #print(k_, v_)
            info_ = {}
            
            if  type(v_[0]['parcel']) == str: # single cargo
                info_['tankShortName'] = k_
                info_['tankName'] =  self.plans.input.vessel.info['cargoTanks'][k_]['name']
                info_['tankId'] = int(self.plans.input.vessel.info['tankName'][k_])
                info_['quantityMT'] = str(round(abs(v_[0]['wt']),2))
                info_['quantityM3'] = str(round(abs(v_[0]['wt']/v_[0]['SG']),2))
                info_['api'] = str(round(abs(v_[0]['api']),2))
                info_['temperature'] = str(round(abs(v_[0]['temperature']),2))
                info_['ullage'] = str(round(abs(v_[0]['corrUllage']),3))
                info_['cargoNominationId'] = int(v_[0]['parcel'][1:])
                
                info_['cargoId'] = self.plans.input.loading.info['cargoId'][v_[0]['parcel']]
                info_['colorCode'] = self.plans.input.loading.info['colorCode'][v_[0]['parcel']]
                info_['cargoAbbreviation'] = self.plans.input.loading.info['abbreviation'][v_[0]['parcel']]
                info_['abbreviation'] = self.plans.input.loading.info['abbreviation'][v_[0]['parcel']]
                
                
                    
                if v_[0]['parcel'] not in plan["cargoVol"]:
                    plan["cargoVol"][v_[0]['parcel']] = v_[0]['wt']/v_[0]['SG']
                else:
                    plan["cargoVol"][v_[0]['parcel']] += v_[0]['wt']/v_[0]['SG']
                
                plan["loadablePlanStowageDetails"].append(info_)
            
            else: # commingle
                
                info_['tankShortName'] = k_
                info_['tankName'] =  self.plans.input.vessel.info['cargoTanks'][k_]['name']
                info_['tankId'] = int(self.plans.input.vessel.info['tankName'][k_])
                info_['quantityMT'] = str(round(abs(v_[0]['wt']),1))
                info_['quantityM3'] = str(round(abs(v_[0]['vol']),2))
                info_['api'] = str(round(abs(v_[0]['api']),2))
                info_['temperature'] = str(round(abs(v_[0]['temperature']),2))
                info_['ullage'] = str(round(abs(v_[0]['corrUllage']),3))
                info_['cargoNomination1Id'] = int(v_[0]['parcel'][0][1:])
                info_['cargoNomination2Id'] = int(v_[0]['parcel'][1][1:])
                
                info_['cargo1Id'] = self.plans.input.loading.info['cargoId']['P'+str(info_['cargoNomination1Id'])]
                info_['cargo2Id'] = self.plans.input.loading.info['cargoId']['P'+str(info_['cargoNomination2Id'])]
                
                info_['colorCode'] = self.plans.input.loading.info['commingle'].get('colorCode', None)
                info_['cargoAbbreviation'] = self.plans.input.loading.info['commingle'].get('abbreviation', None)
                info_['abbreviation'] = self.plans.input.loading.info['commingle'].get('abbreviation', None)
                
                info_['abbreviation1'] = self.plans.input.loading.info['abbreviation'][v_[0]['parcel'][0]]
                info_['abbreviation2'] = self.plans.input.loading.info['abbreviation'][v_[0]['parcel'][1]]
                
                info_['quantity1MT'] = str(round(abs(v_[0]['wt1']),1))
                info_['quantity2MT'] = str(round(abs(v_[0]['wt2']),1))
                info_['ullage1'] = str(round(abs(v_[0]['corrUllage1']),3))
                info_['ullage2'] = str(round(abs(v_[0]['corrUllage2']),3))
                info_['quantity1M3'] = str(round(abs(v_[0]['vol1']),2))
                info_['quantity2M3'] = str(round(abs(v_[0]['vol2']),2))
                
                plan["loadableQuantityCommingleCargoDetails"].append(info_)
                
            if k_ not in cargo_tanks_added_:
                cargo_tanks_added_.append(k_)
                
                
                
            
        ##
        empty_ = set(self.plans.input.vessel.info['cargoTankNames']) - set(cargo_tanks_added_)
        # print('empty_',empty_)
        for k_ in empty_:
            info_ = {}
            info_['tankShortName'] = k_
            info_['tankName'] =  self.plans.input.vessel.info['cargoTanks'][k_]['name']
            info_['tankId'] = int(self.plans.input.vessel.info['tankName'][k_])
            info_['quantityMT'] = "0.0"
            info_['quantityM3'] = "0.0"
            info_['api'] = None 
            info_['temperature'] = None
            info_['ullage'] = str(round(self.plans.input.vessel.info['ullageEmpty'][str(info_['tankId'])],3))
            info_['cargoNominationId'] = None
            
            info_['cargoId'] = None
            info_['colorCode'] = None
            info_['cargoAbbreviation'] = None
            info_['abbreviation'] = None
            
            plan["loadablePlanStowageDetails"].append(info_)
            
        commingle_tank_ = self.plans.input.loading.info['commingle'].get('tankName', None)
        tanks_ = [p_['tankShortName'] for p_ in plan["loadablePlanStowageDetails"]]
        
        if commingle_tank_ and commingle_tank_ not in tanks_:
            k_ = commingle_tank_
            info_ = {}
            info_['tankShortName'] = k_
            info_['tankName'] =  self.plans.input.vessel.info['cargoTanks'][k_]['name']
            info_['tankId'] = int(self.plans.input.vessel.info['tankName'][k_])
            info_['quantityMT'] = "0.0"
            info_['quantityM3'] = "0.0"
            info_['api'] = None 
            info_['temperature'] = None
            info_['ullage'] = str(round(self.plans.input.vessel.info['ullageEmpty'][str(info_['tankId'])],3))
            info_['cargoNominationId'] = None
            
            info_['cargoId'] = None
            info_['colorCode'] = None
            info_['cargoAbbreviation'] = None
            info_['abbreviation'] = None
            
            
            plan["loadablePlanStowageDetails"].append(info_)
            
                
            
                
        for k_, v_ in plan["cargoVol"].items():
            plan["cargoVol"][k_] = str(round(v_,2))
            
        for k_, v_ in ballast_.items():
            # print(k_, v_)
            info_ = {}
            info_['tankShortName'] = k_
            info_['tankName'] =  self.plans.input.vessel.info['ballastTanks'][k_]['name']
            info_['tankId'] = int(self.plans.input.vessel.info['tankName'][k_])
            info_['quantityMT'] = str(round(abs(v_[0]['wt']),2))
            info_['quantityM3'] = str(round(abs(v_[0]['vol']),2))
            info_['sounding'] = str(round(v_[0]['corrLevel'],3))
            
            info_['sg'] = str(v_[0]['SG'])
            info_['colorCode'] = self.plans.input.loading.ballast_color[k_]
            
            if k_ not in ballast_tanks_added_:
                ballast_tanks_added_.append(k_)
                
            plan["ballastVol"] += v_[0]['vol']
            
            plan["loadablePlanBallastDetails"].append(info_)
            
            
        ##
        empty_ = set(self.plans.input.vessel.info['ballastTankNames']) - set(ballast_tanks_added_) - set(self.plans.input.vessel.info['banBallast'])
#        print(empty_)
        for k_ in empty_:
            info_ = {}
            info_['tankShortName'] = k_
            info_['tankName'] =  self.plans.input.vessel.info['ballastTanks'][k_]['name']
            info_['tankId'] = int(self.plans.input.vessel.info['tankName'][k_])
            info_['quantityMT'] = "0.00"
            info_['quantityM3'] = "0.00"
            info_['sounding'] = str(round(self.plans.input.vessel.info['ullageEmpty'][str(info_['tankId'])],3))
            
            info_['sg'] = None
            info_['colorCode'] = None
            plan["loadablePlanBallastDetails"].append(info_)
            
            
        plan["ballastVol"] = str(round(plan["ballastVol"],2))    
        
        
        for k_, v_ in other_weight_.items():
            info_ = {}
            info_['tankShortName'] = k_
            info_['tankName'] =  self.plans.input.vessel.info['tankFullName'][k_]
            info_['tankId'] = int(self.plans.input.vessel.info['tankName'][k_])
            info_['quantityMT'] = str(round(abs(v_[0]['wt']),2))
            info_['quantityM3'] = str(round(abs(v_[0]['vol']),2))
            
            info_['density'] = str(self.plans.input.config['rob_density'][k_])
            info_['colorCode'] = self.plans.input.loading.rob_color[k_]
            
            if k_ not in other_tanks_added_:
                other_tanks_added_.append(k_)
            
            plan["loadablePlanRoBDetails"].append(info_)
            
            
        empty_ = set(self.plans.input.vessel.info['otherTankNames']) - set(other_tanks_added_)
#        print(empty_)
        for k_ in empty_:
            info_ = {}
            info_['tankShortName'] = k_
            info_['tankName'] =  self.plans.input.vessel.info['tankFullName'][k_]
            info_['tankId'] = int(self.plans.input.vessel.info['tankName'][k_])
            info_['quantityMT'] = str("0.00")
            info_['quantityM3'] = str("0.00")
            
            info_['density'] = None
            info_['colorCode'] = self.plans.input.loading.rob_color[k_]
            plan["loadablePlanRoBDetails"].append(info_)
            
            
        
        
        ##
        plan["foreDraft"] = self.stability[str(port)]['forwardDraft']
        plan["meanDraft"] = self.stability[str(port)]['meanDraft']
        plan["afterDraft"] = self.stability[str(port)]['afterDraft']
        plan["trim"] = self.stability[str(port)]['trim']
        plan["heel"] = self.stability[str(port)]['heel']
        plan["airDraft"] = self.stability[str(port)]['airDraft']
        plan["bendinMoment"] = self.stability[str(port)]['bendinMoment']
        plan["shearForce"] = self.stability[str(port)]['shearForce']
        plan["gom"] = self.stability[str(port)]['gom']
        plan["manifoldHeight"] = self.stability[str(port)]['manifoldHeight']
        plan["freeboard"] = self.stability[str(port)]['freeboard']
        
        
        
        
        
    
    
    # def _get_time_interval(self, cargo, stage):
        
    #     return str(self.plans.input.loading.seq[cargo]['stageInterval'][0]), str(self.plans.input.loading.seq[cargo]['stageInterval'][stage][1])
        
            
        
        
