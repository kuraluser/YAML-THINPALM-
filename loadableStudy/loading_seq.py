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
        
        for k_, v_ in cur_ballast_.items():
            cur_vol_ = v_[0]['vol']
            pre_vol_ = pre_ballast_.get(k_, [{}])[0].get('quantityM3',0.) if prev_port == 0 else  pre_ballast_.get(k_, [{}])[0].get('vol',0.)
            
            k1_ = self.plans.input.vessel.info['tankName'][k_]
            if round(cur_vol_,3) < round(pre_vol_,3):
                plan['deballastingRateM3_Hr'][k1_] = str(round((-cur_vol_ + pre_vol_)/time*60,2))
            elif round(cur_vol_,3) > round(pre_vol_,3):
                plan['ballastingRateM3_Hr'][k1_] = str(round((cur_vol_ - pre_vol_)/time*60,2))
        
        for k_, v_ in pre_ballast_.items():         
           if k_ not in plan['deballastingRateM3_Hr']  and k_ not in plan['ballastingRateM3_Hr']:
               cur_vol_ = cur_ballast_.get(k_, [{}])[0].get('vol',0.)
               pre_vol_ = v_[0]['quantityM3'] if prev_port == 0 else  v_[0]['vol']
               
               k1_ = self.plans.input.vessel.info['tankName'][k_]
               if round(cur_vol_,3) < round(pre_vol_,3):
                    plan['deballastingRateM3_Hr'][k1_] = str(round((-cur_vol_ + pre_vol_)/time*60,2))
               elif round(cur_vol_,3) > round(pre_vol_,3):
                    plan['ballastingRateM3_Hr'][k1_] = str(round((cur_vol_ - pre_vol_)/time*60,2))
               
               
            
               
        
    def _stage(self, info, cargo, cargo_order):
        
        ##print(info['stage'])
        
        # stages_
        # {'initialCondition': (0, 0), 'openSingleTank': (0, 5), 'initialRate': (5, 15), 'openAllTanks': (15, 20), 'increaseToMaxRate': (20, 30), 'loadingAtMaxRate': (30, 312), 'topping': (312, 342)}
        # start_time_
        # 342
        
        start_time_ = self.plans.input.loading.seq[cargo]['startTime']
        if info['stage'] == 'initialCondition':
            self.delay += self.plans.input.loading.info['timing_delay1'][self.plans.input.loading.info['loading_order1'][cargo]-1]
        
        info["timeStart"] = str(self.plans.input.loading.seq[cargo]['stageInterval'][info['stage']][0] + start_time_ + self.delay)
        info["timeEnd"] = str(self.plans.input.loading.seq[cargo]['stageInterval'][info['stage']][1] + start_time_ + self.delay)
        
        # info["timeStart"] = ''
        # info["timeEnd"] = ''
        info["toLoadicator"] = False
        info['loadablePlanPortWiseDetails'] = []
        info["cargoValves"] = []
        info["ballastValves"] = []
        
        info["ballastRateM3_Hr"] = {}
        info["deballastingRateM3_Hr"] = {}
        info["cargoLoadingRatePerTankM3_Hr"] = {}
        info["cargoLoadingRateM3_Hr"] = {}
        info["ballast"] = {}
            
        if info['stage'] == 'initialCondition':
            # print('----', info['stage'])
            info["toLoadicator"] = True
            plan_ = {'time': str(info["timeStart"]), 
                     "loadableQuantityCommingleCargoDetails":[],
                     "loadablePlanStowageDetails":[],
                     "loadablePlanBallastDetails":[],
                     "loadablePlanRoBDetails":[]}
            
            if cargo_order == 1:
                self._get_plan(plan_)
            else:
                plan_ = {k_: v_ for k_, v_ in self.last_plan.items() if k_ in ['time', 'loadableQuantityCommingleCargoDetails', 'loadablePlanStowageDetails', 'loadablePlanBallastDetails', 'loadablePlanRoBDetails', 'ballastVol', 'cargoVol', 'foreDraft', 'meanDraft', 'afterDraft', 'trim', 'heel', 'airDraft', 'bendinMoment', 'shearForce']}
            
            info['loadablePlanPortWiseDetails'].append(plan_)
            
            if cargo_order == 1:
                self.initial_plan = plan_
            
        elif info['stage'] == 'openSingleTank':
            
            pass
            
                
            # c"deballastingRateM3_Hr"] = {}
            # info["ballast"] = {}
            
            # info["cargoValves"] = []
            # info["ballastValves"] = []
            
        elif info['stage'] == "initialRate":
            
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['initialRate'])}
            
            
            if self.plans.input.loading.seq[cargo]['firstTank'] in self.plans.input.vessel.info['tankName']:
                tankId_ = self.plans.input.vessel.info['tankName'][self.plans.input.loading.seq[cargo]['firstTank']]
                info["cargoLoadingRatePerTankM3_Hr"] = {tankId_: str(self.plans.input.loading.seq[cargo]['initialRate'])}
                
                info["simCargoLoadingRatePerTankM3_Hr"] = { tankId_: {"tankName":self.plans.input.vessel.info['tankId'][tankId_],
                                                                      "rate":str(self.plans.input.loading.seq[cargo]['initialRate']),
                                                                      "timeStart": info["timeStart"],
                                                                      "timeEnd": info["timeEnd"]}}
                
            else:
                tank1_, tank2_ = self.plans.input.loading.seq[cargo]['firstTank'][:-1]+'P', self.plans.input.loading.seq[cargo]['firstTank'][:-1]+'S'
                tank1Id_ = self.plans.input.vessel.info['tankName'][tank1_]
                tank2Id_ = self.plans.input.vessel.info['tankName'][tank2_]
                
                info["cargoLoadingRatePerTankM3_Hr"] = {tank1Id_: str(self.plans.input.loading.seq[cargo]['initialRate']/2),
                                                        tank2Id_: str(self.plans.input.loading.seq[cargo]['initialRate']/2)}
            
                info["simCargoLoadingRatePerTankM3_Hr"] = {tank1Id_: {"tankName":self.plans.input.vessel.info['tankId'][tank1Id_],
                                                                      "rate":str(self.plans.input.loading.seq[cargo]['initialRate']/2),
                                                                      "timeStart": info["timeStart"],
                                                                       "timeEnd": info["timeEnd"]},
                                                           tank2Id_: {"tankName":self.plans.input.vessel.info['tankId'][tank2Id_],
                                                                      "rate":str(self.plans.input.loading.seq[cargo]['initialRate']/2),
                                                                      "timeStart": info["timeStart"],
                                                                      "timeEnd": info["timeEnd"]}}
                                                           
                                                                      
            # info["ballast"] = {}
            # info["deballastingRateM3_Hr"] = {}
            
        elif info['stage'] == "openAllTanks":
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['initialRate'])}
           
            tot_num_ = len(self.plans.input.loadable['toLoadCargoTank'][cargo])
            rate_ = round(self.plans.input.loading.seq[cargo]['initialRate']/tot_num_,2)
            info["cargoLoadingRatePerTankM3_Hr"] = {self.plans.input.vessel.info['tankName'][k_]:str(rate_) for k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items()}
            
            info["simCargoLoadingRatePerTankM3_Hr"] = {}
            for k_, v_ in info["cargoLoadingRatePerTankM3_Hr"].items():
                info["simCargoLoadingRatePerTankM3_Hr"][k_] = {'tankName': self.plans.input.vessel.info['tankId'][k_],
                                                               "rate": v_, 
                                                               "timeStart": info["timeStart"],
                                                               "timeEnd": info["timeEnd"]}
            
        elif info['stage'] == "increaseToMaxRate":
           
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['initialRate'])}
           
            tot_num_ = len(self.plans.input.loadable['toLoadCargoTank'][cargo])
            rate_ = round(self.plans.input.loading.seq[cargo]['initialRate']/tot_num_,2)
            info["cargoLoadingRatePerTankM3_Hr"] = {self.plans.input.vessel.info['tankName'][k_]:str(rate_) for k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items()}
            
            info["simCargoLoadingRatePerTankM3_Hr"] = {}
            for k_, v_ in info["cargoLoadingRatePerTankM3_Hr"].items():
                info["simCargoLoadingRatePerTankM3_Hr"][k_] = {'tankName': self.plans.input.vessel.info['tankId'][k_],
                                                               "rate": v_, 
                                                               "timeStart": info["timeStart"],
                                                               "timeEnd": info["timeEnd"]}
        
        elif info['stage'] == "loadingAtMaxRate":
                        
            info['simDeballastingRateM3_Hr'] = []
            info['simBallastingRateM3_Hr'] = []
            
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['maxShoreRate'])}
            
            tot_num_ = len(self.plans.input.loadable['toLoadCargoTank'][cargo])
            rate_ = round(self.plans.input.loading.seq[cargo]['initialRate']/tot_num_,2)
            info["cargoLoadingRatePerTankM3_Hr"] = {}
            info["simCargoLoadingRatePerTankM3_Hr"] = {}
            
            for  k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items():
                if v_ > 0:
                    if k_[-1] in ['C'] or k_ in ['SLS', 'SLP']:
                        rate_ = self.plans.input.loading.seq[cargo]['loadingRateM3Min'][k_]*60
                    else:
                        k1_ = k_[:-1]+'W'
                        rate_ = self.plans.input.loading.seq[cargo]['loadingRateM3Min'][k1_]*60/2
                        
                    info["cargoLoadingRatePerTankM3_Hr"][self.plans.input.vessel.info['tankName'][k_]] = str(round(rate_,2))
                    
                    info["simCargoLoadingRatePerTankM3_Hr"][self.plans.input.vessel.info['tankName'][k_]] = {'tankName': k_,
                                                                                                              "rate": str(round(rate_,2)), 
                                                                                                              "timeStart": info["timeStart"],
                                                                                                              "timeEnd": info["timeEnd"]}
            
            
            info["toLoadicator"] = True
            pre_port_ = self.pre_port
            for k_, v_ in self.plans.input.loadable['stages'].items():
                
                justBeforeTopping = v_[:-1] == self.plans.input.loading.seq[cargo]['justBeforeTopping'] 
                
                if v_[:3] in ['Max'] and v_[-1] == str(cargo_order) and (not justBeforeTopping):
                    time_ = self.plans.input.loading.seq[cargo]['gantt'][v_[:-1]]['Time'] + self.plans.input.loading.seq[cargo]['startTime'] + self.delay
                    plan_ = {'time': str(time_), 
                     "loadableQuantityCommingleCargoDetails":[],
                     "loadablePlanStowageDetails":[],
                     "loadablePlanBallastDetails":[],
                     "loadablePlanRoBDetails":[]}
                    
                    port_ = [a_ for a_, b_ in self.plans.input.loadable['stages'].items() if b_ == v_][0]
                    self._get_plan(plan_, port_)
            
                    info['loadablePlanPortWiseDetails'].append(plan_)
                    
                    info_ = {}
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
                    self._get_ballast_rate(ballast_plan_, port_, pre_port_, cur_time_-pre_time_)
                    pre_port_ = port_
                    plan_['deballastingRateM3_Hr'] = ballast_plan_['deballastingRateM3_Hr']
                    plan_['ballastingRateM3_Hr'] = ballast_plan_['ballastingRateM3_Hr']
                    
                    if self.pre_port == 0:
                        pre_time_ = 30  # start of maxloading1
                        
                    
                    info_ = {}
                    for k1_, v1_ in  ballast_plan_['deballastingRateM3_Hr'].items():
                        info_[k1_] = {'tankName': self.plans.input.vessel.info['tankId'][k1_],
                                     'rate': v1_,
                                     "timeStart": str(int(pre_time_+self.delay)), "timeEnd": str(int(cur_time_+self.delay))}
                    
                    info['simDeballastingRateM3_Hr'].append(info_)
                    
                    info_ = {}
                    for k1_, v1_ in  ballast_plan_['ballastingRateM3_Hr'].items():
                        info_[k1_] = {'tankName': self.plans.input.vessel.info['tankId'][k1_],
                                     'rate': v1_,
                                     "timeStart": str(int(pre_time_+self.delay)), 
                                     "timeEnd": str(int(cur_time_+self.delay))}
                    
                    
                    info['simBallastingRateM3_Hr'].append(info_)
                    
                    # dict(ballast_plan_['deballastingRateM3_Hr'])
                    
                    
                    #  = dict(ballast_plan_['ballastingRateM3_Hr'])
                    
                    
                    
                    if v_[:-1] == 'MaxLoading1':
                        # pass to other stage prior to MaxLoading1
                        info['iniDeballastingRateM3_Hr'] = ballast_plan_['deballastingRateM3_Hr']
                        info['iniBallastingRateM3_Hr'] = ballast_plan_['ballastingRateM3_Hr']
                        
                        info['simIniDeballastingRateM3_Hr'] = info['simDeballastingRateM3_Hr']
                        info['simIniBallastingRateM3_Hr'] = info['simBallastingRateM3_Hr']
                        
                    
            self.pre_port = pre_port_
                    
        
        elif info['stage'] == "topping":
            
            
            
            info["cargoLoadingRatePerTankM3_Hr"] = {}
            info["simCargoLoadingRatePerTankM3_Hr"] = {}
            
            
            for  k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items():
                if v_ > 0:
                    if k_[-1] in ['C'] or k_ in ['SLS', 'SLP']:
                        rate_ = self.plans.input.loading.seq[cargo]['staggerRate'].loc[k_,:].to_list()
                        r1_ = [r_  for r_ in rate_ if r_ not in [None]] # every 15min
                        rate_ = np.mean(r1_) 
                        
                    else:
                        k1_ = k_[:-1]+'W'
                        rate_ = self.plans.input.loading.seq[cargo]['staggerRate'].loc[k1_,:].to_list()
                        r1_ = [r_  for r_ in rate_ if r_ not in [None]] # every 15min
                        rate_ = np.mean(r1_)/2
                    
                    end_time_ = int(float(info['timeStart'])) + len(r1_)*15    
                    info["cargoLoadingRatePerTankM3_Hr"][self.plans.input.vessel.info['tankName'][k_]] = str(round(rate_,2))
                    info["cargoLoadingRatePerTankM3_Hr"][self.plans.input.vessel.info['tankName'][k_]] = {'tankName': k_,
                                                                                                          'rate':str(round(rate_,2)),
                                                                                                          "timeStart":info['timeStart'],
                                                                                                          'timeEnd':str(end_time_)}
            
            
            # last item of last row
            reduce_rate_ = self.plans.input.loading.seq[cargo]['staggerRate'].iloc[-1,:].to_list()[-1]
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['maxShoreRate']),
                                             1:str(reduce_rate_) }
            
            
            info["toLoadicator"] = True
            pre_port_ = self.pre_port
            
            for k_, v_ in self.plans.input.loadable['stages'].items():
                
                if v_[:3] in ['Top'] and v_[-1] == str(cargo_order):
                    
                    port_ = [a_ for a_, b_ in self.plans.input.loadable['stages'].items() if b_ == v_][0]
                    time_ = self.plans.input.loading.seq[cargo]['gantt'][v_[:-1]]['Time'] + self.plans.input.loading.seq[cargo]['startTime']
                    
                    if v_[:-1] !=  self.plans.input.loading.seq[cargo]['lastStage']:
                        print(time_)
                        time_ = self.plans.input.loading.time_interval * round(time_/self.plans.input.loading.time_interval) + self.plans.input.loading.seq[cargo]['startTime']
                        print(time_)

                    plan_ = {'time': str(time_+self.delay), 
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
        
        
        
        for k_, v_ in cargo_.items():
            #print(k_, v_)
            info_ = {}
            info_['tankName'] = k_
            info_['tankId'] = int(self.plans.input.vessel.info['tankName'][k_])
            info_['quantityMT'] = str(round(abs(v_[0]['wt']),2))
            info_['quantityM3'] = str(round(abs(v_[0]['wt']/v_[0]['SG']),2))
            info_['api'] = str(round(abs(v_[0]['api']),2))
            info_['temperature'] = str(round(abs(v_[0]['temperature']),2))
            info_['ullage'] = str(round(abs(v_[0]['corrUllage']),3))
            info_['cargoNominationId'] = int(v_[0]['parcel'][1:])
            
            if v_[0]['parcel'] not in plan["cargoVol"]:
                plan["cargoVol"][v_[0]['parcel']] = v_[0]['wt']/v_[0]['SG']
            else:
                plan["cargoVol"][v_[0]['parcel']] += v_[0]['wt']/v_[0]['SG']
                
            
            plan["loadablePlanStowageDetails"].append(info_)
            
        for k_, v_ in plan["cargoVol"].items():
            plan["cargoVol"][k_] = str(round(v_,2))
            
            
        
            
            
        for k_, v_ in ballast_.items():
            # print(k_, v_)
            info_ = {}
            info_['tankName'] = k_
            info_['tankId'] = int(self.plans.input.vessel.info['tankName'][k_])
            info_['quantityMT'] = str(round(abs(v_[0]['wt']),2))
            info_['quantityM3'] = str(round(abs(v_[0]['vol']),2))
            info_['sounding'] = str(round(v_[0]['corrLevel'],3))
            
            plan["ballastVol"] += v_[0]['vol']
            
            plan["loadablePlanBallastDetails"].append(info_)
            
        plan["ballastVol"] = str(round(plan["ballastVol"],2))    
            
        for k_, v_ in other_weight_.items():
            info_ = {}
            info_['tankName'] = k_
            info_['tankId'] = int(self.plans.input.vessel.info['tankName'][k_])
            info_['quantityMT'] = str(round(abs(v_[0]['wt']),2))
            info_['quantityM3'] = str(round(abs(v_[0]['vol']),2))
            
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
        
        
        
    
    
    # def _get_time_interval(self, cargo, stage):
        
    #     return str(self.plans.input.loading.seq[cargo]['stageInterval'][0]), str(self.plans.input.loading.seq[cargo]['stageInterval'][stage][1])
        
            
        
        
