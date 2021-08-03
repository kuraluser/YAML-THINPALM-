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
            # info["deballastingRateM3_Hr"] = {}
            # info["ballast"] = {}
            
            # info["cargoValves"] = []
            # info["ballastValves"] = []
            
        elif info['stage'] == "initialRate":
            pass
            # info["deballastingRateM3_Hr"] = {}
            # info["cargoLoadingRatePerTankM3_Hr"] = {}
            # info["cargoLoadingRateM3_Hr"] = {}
            # info["ballast"] = {}
            
        elif info['stage'] == "openAllTanks":
           pass
       
        elif info['stage'] == "increaseToMaxRate":
           pass
        
        elif info['stage'] == "loadingAtMaxRate":
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
        
            
        
        
