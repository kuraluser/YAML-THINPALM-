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

STAGE_INFO = ['time', 'foreDraft', 'meanDraft', 'afterDraft', 'trim', 'heel', 'airDraft', 'bendinMoment', 'shearForce' ]

class Loading_seq:
    def __init__(self, data, stability):
        
        self.plans = data   # .ship_status_dep, .ballast_weight 
        self.stability = stability[0]  # single plan only
        
        self.stages = []
        
        
    def _stage(self, info, cargo, cargo_order):
        
        ##print(info['stage'])
        
        info["timeStart"] = self.plans.input.loading.seq[cargo]['stageInterval'][info['stage']][0] + self.plans.input.loading.seq[cargo]['startTime']
        info["timeEnd"] = self.plans.input.loading.seq[cargo]['stageInterval'][info['stage']][1] + self.plans.input.loading.seq[cargo]['startTime']
        
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
            plan_ = {'time': info["timeStart"], 
                     "loadableQuantityCommingleCargoDetails":[],
                     "loadablePlanStowageDetails":[],
                     "loadablePlanBallastDetails":[],
                     "loadablePlanRoBDetails":[]}
            self._get_plan(plan_)
            
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
            else:
                tank1_, tank2_ = self.plans.input.loading.seq[cargo]['firstTank'][:-1]+'P', self.plans.input.loading.seq[cargo]['firstTank'][:-1]+'S'
                tank1Id_ = self.plans.input.vessel.info['tankName'][tank1_]
                tank2Id_ = self.plans.input.vessel.info['tankName'][tank2_]
                
                info["cargoLoadingRatePerTankM3_Hr"] = {tank1Id_: str(self.plans.input.loading.seq[cargo]['initialRate']/2),
                                                        tank2Id_: str(self.plans.input.loading.seq[cargo]['initialRate']/2)}
            
            
            # info["ballast"] = {}
            # info["deballastingRateM3_Hr"] = {}
            
        elif info['stage'] == "openAllTanks":
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['initialRate'])}
           
            tot_num_ = len(self.plans.input.loadable['toLoadCargoTank'][cargo])
            rate_ = round(self.plans.input.loading.seq[cargo]['initialRate']/tot_num_,2)
            info["cargoLoadingRatePerTankM3_Hr"] = {self.plans.input.vessel.info['tankName'][k_]:str(rate_) for k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items()}
       
        elif info['stage'] == "increaseToMaxRate":
           
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['initialRate'])}
           
            tot_num_ = len(self.plans.input.loadable['toLoadCargoTank'][cargo])
            rate_ = round(self.plans.input.loading.seq[cargo]['initialRate']/tot_num_,2)
            info["cargoLoadingRatePerTankM3_Hr"] = {self.plans.input.vessel.info['tankName'][k_]:str(rate_) for k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items()}
       
        
        elif info['stage'] == "loadingAtMaxRate":
                        
            
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['maxShoreRate'])}
            
            tot_num_ = len(self.plans.input.loadable['toLoadCargoTank'][cargo])
            rate_ = round(self.plans.input.loading.seq[cargo]['initialRate']/tot_num_,2)
            info["cargoLoadingRatePerTankM3_Hr"] = {}
            for  k_, v_ in self.plans.input.loadable['toLoadCargoTank'][cargo].items():
                if v_ > 0:
                    if k_[-1] in ['C'] or k_ in ['SLS', 'SLP']:
                        rate_ = self.plans.input.loading.seq[cargo]['loadingRateM3Min'][k_]*60
                    else:
                        k1_ = k_[:-1]+'W'
                        rate_ = self.plans.input.loading.seq[cargo]['loadingRateM3Min'][k1_]*60/2
                        
                    info["cargoLoadingRatePerTankM3_Hr"][self.plans.input.vessel.info['tankName'][k_]] = str(round(rate_,2))
            
            
        
        
            info["toLoadicator"] = True
            
            for k_, v_ in self.plans.input.loadable['stages'].items():
                
                justBeforeTopping = v_[:-1] == self.plans.input.loading.seq[cargo]['justBeforeTopping'] 
                
                if v_[:3] in ['Max'] and v_[-1] == str(cargo_order) and (not justBeforeTopping):
                    time_ = self.plans.input.loading.seq[cargo]['gantt'][v_[:-1]]['Time'] + self.plans.input.loading.seq[cargo]['startTime']
                    plan_ = {'time': str(time_), 
                     "loadableQuantityCommingleCargoDetails":[],
                     "loadablePlanStowageDetails":[],
                     "loadablePlanBallastDetails":[],
                     "loadablePlanRoBDetails":[]}
                    
                    port_ = [a_ for a_, b_ in self.plans.input.loadable['stages'].items() if b_ == v_][0]
                    self._get_plan(plan_, port_)
            
                    info['loadablePlanPortWiseDetails'].append(plan_)
                    self.stages.append({a_:b_  for a_, b_ in plan_.items() if a_ in STAGE_INFO})
                    
        
        elif info['stage'] == "topping":
            
            
            
            info["cargoLoadingRatePerTankM3_Hr"] = {}
            
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
                        
                    info["cargoLoadingRatePerTankM3_Hr"][self.plans.input.vessel.info['tankName'][k_]] = str(round(rate_,2))
            
            
            # last item of last row
            reduce_rate_ = self.plans.input.loading.seq[cargo]['staggerRate'].iloc[-1,:].to_list()[-1]
            info["cargoLoadingRateM3_Hr"] = {0:str(self.plans.input.loading.seq[cargo]['maxShoreRate']),
                                             1:str(reduce_rate_) }
            
            
            info["toLoadicator"] = True
            
            for k_, v_ in self.plans.input.loadable['stages'].items():
                
                if v_[:3] in ['Top'] and v_[-1] == str(cargo_order):
                    
                    port_ = [a_ for a_, b_ in self.plans.input.loadable['stages'].items() if b_ == v_][0]
                    time_ = self.plans.input.loading.seq[cargo]['gantt'][v_[:-1]]['Time'] + self.plans.input.loading.seq[cargo]['startTime']
                    
                    if v_[:-1] !=  self.plans.input.loading.seq[cargo]['lastStage']:
                        time_ = self.plans.input.plans.time_interval * round(time_/self.plans.input.plans.time_interval) + self.plans.input.loading.seq[cargo]['startTime']

                    plan_ = {'time': str(time_), 
                     "loadableQuantityCommingleCargoDetails":[],
                     "loadablePlanStowageDetails":[],
                     "loadablePlanBallastDetails":[],
                     "loadablePlanRoBDetails":[]}
                    
                    
                    self._get_plan(plan_, port_)
            
                    info['loadablePlanPortWiseDetails'].append(plan_)
                    self.stages.append({a_:b_  for a_, b_ in plan_.items() if a_ in STAGE_INFO})
                    
                    if self.plans.input.loading.seq['stages'][-1] == v_:
                        self.final_plan = plan_
        
        else:
            print(info['stage'])
            exit(1)
    
    
    def _get_plan(self, plan, port=0):
        
        cargo_ = self.plans.ship_status_dep[0][str(port)]  # single plan
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
        
            
        
        
