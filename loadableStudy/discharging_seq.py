# -*- coding: utf-8 -*-
"""
Created on Sat Oct 23 23:59:50 2021

@author: phtan1
"""

from copy import deepcopy
import numpy as np

STAGE_INFO = ['time', 'foreDraft', 'meanDraft', 'afterDraft', 'trim', 'heel', 'airDraft', 'bendinMoment', 'shearForce', 'gom' ]


class Discharging_seq:
    def __init__(self, data, stability):
        
        self.plans = data   # .ship_status_dep, .ballast_weight 
        self.stability = stability[0]  # single plan only
        
        self.stages = []
        self.pre_port = 0 # for collecting ballast weight
        self.delay = 0
        self.last_plan = None
   
    
    def _stage(self, info, cargo, cargo_order, final_event = 0):
        ##print(info['stage'])
        
        # EVENTS = ["initialCondition", "floodSeparator", "warmPumps",
        #           "initialRate", "increaseToMaxRate", "dischargingAtMaxRate", 
        #           "reducedRate"]
        
        # 'initialCondition' -> "initialCondition", "floodSeparator", "warmPumps"
        # 'initialRate' -> "initialRate"
        # 'increaseToMaxRate' -> "increaseToMaxRate"
        # 'dischargingAtMaxRate' -> "dischargingAtMaxRate"
        # 'stripping' -> "reducedRate"
        
        start_time_ = self.plans.input.discharging.seq[cargo]['startTime']
        if info['stage'] == 'initialCondition':
            self.delay += self.plans.input.discharging.info['timing_delay1'][cargo_order-1]
        
        
        
        # info["timeStart"] = ''
        # info["timeEnd"] = ''
        info["toLoadicator"] = False
        info["jumpStep"] = False
        info['dischargePlanPortWiseDetails'] = []
        info["cargoValves"] = []
        info["ballastValves"] = []
        
        info["ballastRateM3_Hr"] = {}
        info["deballastingRateM3_Hr"] = {}
        info["cargoDischargingRatePerTankM3_Hr"] = []
        info["cargoDischargingRateM3_Hr"] = {}
        info["ballast"] = {}
        info["TCP"] = {}
        info["STPED"] = {}
        info["STP"] = {}
        info["cargo"] = {}
        info["simCargoDischargingRatePerTankM3_Hr"] = [{}]
        info["simBallastingRatePerTankM3_Hr"] = [{}]
        info["simDeballatingRatePerTankM3_Hr"] = [{}]
        
        info["Cleaning"] = {"TopClean":[], "BtmClean":[], "FullClean":[]}
        info["stripping"] = []
        
        if info['stage'] == 'initialCondition':
            # print('----', info['stage'])
            info["toLoadicator"] = True
            info["jumpStep"] = True
            start_ = int(0 + start_time_ + self.delay)
            end_   = int(0 + start_time_ + self.delay)
            info["timeStart"] = str(start_)
            info["timeEnd"] = str(end_)
            
            plan_ = {'time': str(int(info["timeStart"])), 
                     "dischargeQuantityCommingleCargoDetails":[],
                     "dischargePlanStowageDetails":[],
                     "dischargePlanBallastDetails":[],
                     "dischargePlanRoBDetails":[]}
            
            if cargo_order == 1:
                self._get_plan(plan_)
            else:
                plan_ = {k_: v_ for k_, v_ in self.last_plan.items() if k_ in ['time', 'dischargeQuantityCommingleCargoDetails', 'dischargePlanStowageDetails', 'dischargePlanBallastDetails', 'dischargePlanRoBDetails', 'ballastVol', 'cargoVol', 'foreDraft', 'meanDraft', 'afterDraft', 'trim', 'heel', 'airDraft', 'bendinMoment', 'shearForce']}
            
            plan_['time'] = info["timeEnd"]
            info['dischargePlanPortWiseDetails'].append(plan_)
            
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
            
            
            
        elif info['stage'] == 'floodSeparator':
            start_ = int(0 + start_time_ + self.delay)
            end_   = int(2 + start_time_ + self.delay)
            info["timeStart"] = str(start_)
            info["timeEnd"] = str(end_)
            
            info["dischargePlanPortWiseDetails"] = [{"time": str(end_),
                                                     "dischargeQuantityCommingleCargoDetails": [],
                                                     "dischargePlanStowageDetails": [],
                                                     "dischargePlanBallastDetails": [],
                                                     "dischargePlanRoBDetails": []
                                                     }]
            
            
        
        elif info['stage'] == 'warmPumps':
            start_ = int(2 + start_time_ + self.delay)
            end_   = int(32 + start_time_ + self.delay)
            info["timeStart"] = str(start_)
            info["timeEnd"] = str(end_)
            
            info["dischargePlanPortWiseDetails"] = [{"time": str(end_),
                                                     "dischargeQuantityCommingleCargoDetails": [],
                                                     "dischargePlanStowageDetails": [],
                                                     "dischargePlanBallastDetails": [],
                                                     "dischargePlanRoBDetails": []
                                                     }]
            
        elif info['stage'] == 'initialRate':
            start_ = int(self.plans.input.discharging.seq[cargo]['stageInterval'][info['stage']][0] + start_time_ + self.delay)
            end_   = int(self.plans.input.discharging.seq[cargo]['stageInterval'][info['stage']][1] + start_time_ + self.delay)
            info["timeStart"] = str(start_)
            info["timeEnd"] = str(end_)
            
            info["dischargePlanPortWiseDetails"] = [{"time": str(end_),
                                                     "dischargeQuantityCommingleCargoDetails": [],
                                                     "dischargePlanStowageDetails": [],
                                                     "dischargePlanBallastDetails": [],
                                                     "dischargePlanRoBDetails": []
                                                     }]
            
            info["cargoDischargingRateM3_Hr"] = {0:str(self.plans.input.discharging.seq[cargo]['initialRate'])}
            
            rate_ = self.plans.input.discharging.seq[cargo]['initialRate']/len(self.plans.input.discharging.seq[cargo]['tanks'])
            
            info["cargoDischargingRatePerTankM3_Hr"] = [{self.plans.input.vessel.info['tankName'][k_]:str(round(rate_,2)) 
                                                         for k_, v_ in self.plans.input.loadable.info['preloadOperation'][cargo[:-1]].items()
                                                         if k_ in self.plans.input.discharging.seq[cargo]['tanks']}]
            
            info["simCargoDischargingRatePerTankM3_Hr"] = []
            info1_ = {}
            for k_, v_ in info["cargoDischargingRatePerTankM3_Hr"][0].items():
                info1_[k_] = {'tankShortName': self.plans.input.vessel.info['tankId'][k_],
                                                               "rate": v_, 
                                                               "timeStart": info["timeStart"],
                                                               "timeEnd": info["timeEnd"]}
            
            info["simCargoDischargingRatePerTankM3_Hr"].append(info1_)
            
            ## 
            num_pump_ = len(self.plans.input.discharging.seq[cargo]['cargoPump'])
            rate_ = self.plans.input.discharging.seq[cargo]['initialRate']/num_pump_
            vol_ = rate_*(int(info["timeEnd"]) - int(info["timeStart"]))/60
            for p_ in self.plans.input.discharging.seq[cargo]['cargoPump']:
                id_ = self.plans.input.vessel.info['cargoPumpId'][p_]['id']
                info["cargo"][id_] = [{"rateM3_Hr": str(round(rate_,2)),
                                         "quantityM3": str(round(vol_,2)),
                                         "timeStart": info["timeStart"],
                                         "timeEnd": info["timeEnd"]}]
            
            
        elif info['stage'] == 'increaseToMaxRate':
            start_ = int(self.plans.input.discharging.seq[cargo]['stageInterval'][info['stage']][0] + start_time_ + self.delay)
            end_   = int(self.plans.input.discharging.seq[cargo]['stageInterval'][info['stage']][1] + start_time_ + self.delay)
            info["timeStart"] = str(start_)
            info["timeEnd"] = str(end_)
            
            info["dischargePlanPortWiseDetails"] = [{"time": str(end_),
                                                     "dischargeQuantityCommingleCargoDetails": [],
                                                     "dischargePlanStowageDetails": [],
                                                     "dischargePlanBallastDetails": [],
                                                     "dischargePlanRoBDetails": []
                                                     }]
            
            info["cargoDischargingRateM3_Hr"] = {0:str(self.plans.input.discharging.seq[cargo]['incMaxRate'])}
            
            rate_ = self.plans.input.discharging.seq[cargo]['incMaxRate']/len(self.plans.input.discharging.seq[cargo]['tanks'])
            
            info["cargoDischargingRatePerTankM3_Hr"] = [{self.plans.input.vessel.info['tankName'][k_]:str(round(rate_,2)) 
                                                         for k_, v_ in self.plans.input.loadable.info['preloadOperation'][cargo[:-1]].items()
                                                         if k_ in self.plans.input.discharging.seq[cargo]['tanks']}]
            
            info["simCargoDischargingRatePerTankM3_Hr"] = []
            info1_ = {}
            for k_, v_ in info["cargoDischargingRatePerTankM3_Hr"][0].items():
                info1_[k_] = {'tankShortName': self.plans.input.vessel.info['tankId'][k_],
                                                               "rate": v_, 
                                                               "timeStart": info["timeStart"],
                                                               "timeEnd": info["timeEnd"]}
            
            info["simCargoDischargingRatePerTankM3_Hr"].append(info1_)
            
            ## 
            num_pump_ = len(self.plans.input.discharging.seq[cargo]['cargoPump'])
            rate_ = self.plans.input.discharging.seq[cargo]['incMaxRate']/num_pump_
            vol_ = rate_*(int(info["timeEnd"]) - int(info["timeStart"]))/60
            for p_ in self.plans.input.discharging.seq[cargo]['cargoPump']:
                id_ = self.plans.input.vessel.info['cargoPumpId'][p_]['id']
                info["cargo"][id_] = [{"rateM3_Hr": str(round(rate_,2)),
                                         "quantityM3": str(round(vol_,2)),
                                         "timeStart": info["timeStart"],
                                         "timeEnd": info["timeEnd"]}]
            
            
           
            
        elif info['stage'] == 'dischargingAtMaxRate':
            
            start_ = int(self.plans.input.discharging.seq[cargo]['stageInterval'][info['stage']][0] + start_time_ + self.delay)
            end_   = int(self.plans.input.discharging.seq[cargo]['stageInterval'][info['stage']][1] + start_time_ + self.delay)
            info["timeStart"] = str(start_)
            info["timeEnd"] = str(end_)
            
            
            info['simDeballastingRateM3_Hr'] = []
            info['simBallastingRateM3_Hr'] = []
            
            info['totDeballastingRateM3_Hr'] = []
            info['totBallastingRateM3_Hr'] = []
            
            info["cargoDischargingRateM3_Hr"] = {0:str(self.plans.input.discharging.seq[cargo]['maxRate'])}
            
            tot_num_ = len(self.plans.input.discharging.seq[cargo]['tanks'])
            info["cargoDischargingRatePerTankM3_Hr"] = []
            info["simCargoDischargingRatePerTankM3_Hr"] = []
            
            info1_, info2_ = {}, {}
            for  k_ in self.plans.input.discharging.seq[cargo]['tanks']:
                    
                rate_ = self.plans.input.discharging.seq[cargo]['dischargingRateM3Min'][k_]*60
                    
                info1_[self.plans.input.vessel.info['tankName'][k_]] = str(round(rate_,2))
                info2_[self.plans.input.vessel.info['tankName'][k_]] = {'tankShortName': k_,
                                                                         "rate": str(round(rate_,2)), 
                                                                             "timeStart": info["timeStart"],
                                                                             "timeEnd": info["timeEnd"]}
                        
            info["cargoDischargingRatePerTankM3_Hr"].append(info1_)
            info["simCargoDischargingRatePerTankM3_Hr"].append(info2_)
            
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
            for k_, v_ in self.plans.input.loadable.info['stages'].items():
                
                justBeforeStripping = v_[:-1] == self.plans.input.discharging.seq[cargo]['justBeforeStripping']
                
                if v_[:3] in ['Max'] and v_[-1] == str(cargo_order) and (not justBeforeStripping):
                    # all stages before last max stages
                    
                    time_ = int(self.plans.input.discharging.seq[cargo]['gantt'][v_[:-1]]['Time'] +
                                self.plans.input.discharging.seq[cargo]['startTime'] + self.delay)
                    
                    plan_ = {'time': str(time_), 
                             "dischargeQuantityCommingleCargoDetails":[],
                             "dischargePlanStowageDetails":[],
                             "dischargePlanBallastDetails":[],
                             "dischargePlanRoBDetails":[]}
                    
                    port_ = [a_ for a_, b_ in self.plans.input.loadable.info['stages'].items() if b_ == v_][0]
                    self._get_plan(plan_, port_)
            
                    info['dischargePlanPortWiseDetails'].append(plan_)
                    
                    info['stageEndTime'][v_[:-1]] = time_
                    
                    info_ = {} # get stability info
                    for a_, b_ in plan_.items():
                        if a_ in STAGE_INFO:
                            info_[a_] = b_
                            # if a_ in ['time']:
                            #     info_[a_] = str(int(info_[a_]) + self.delay)
                            
                    self.stages.append(info_)
                    
                    ballast_plan_ = {'deballastingRateM3_Hr':{}, 'ballastingRateM3_Hr':{}}
                    cur_time_ = self.plans.input.loadable.info['stageTimes'][port_]
                    pre_time_ = self.plans.input.loadable.info['stageTimes'].get(pre_port_, 0.)
                    
                    time_ = cur_time_-pre_time_
                    self._get_ballast_rate(ballast_plan_, port_, pre_port_, time_)
                    
                    plan_['deballastingRateM3_Hr'] = ballast_plan_['deballastingRateM3_Hr']
                    plan_['ballastingRateM3_Hr'] = ballast_plan_['ballastingRateM3_Hr']
                    
                    if pre_port_ == self.pre_port:
                        pre_time_ += 67  # start of maxloading1
                        
                    # print(port_,pre_port_,cur_time_,pre_time_)
                    # print()
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
                    
                    
                    info['totDeballastingRateM3_Hr'].append(ballast_plan_['totDeballastingRateM3_Hr'])
                    info['totBallastingRateM3_Hr'].append(ballast_plan_['totBallastingRateM3_Hr'])
                    
                    pre_port_ = port_
                    
                    if v_[:-1] == 'MaxDischarging1':
                        
                        # pass to other stage prior to MaxLoading1
                        info['iniDeballastingRateM3_Hr'] = deepcopy(ballast_plan_['deballastingRateM3_Hr'])
                        info['iniBallastingRateM3_Hr'] = deepcopy(ballast_plan_['ballastingRateM3_Hr'])
                        
                        info['iniTotDeballastingRateM3_Hr'] = deepcopy(ballast_plan_['totDeballastingRateM3_Hr'])
                        info['iniTotBallastingRateM3_Hr'] = deepcopy(ballast_plan_['totBallastingRateM3_Hr'])
                        
                        
                        info['simIniDeballastingRateM3_Hr'] = deepcopy(info['simDeballastingRateM3_Hr'][0])
                        info['simIniBallastingRateM3_Hr'] = deepcopy(info['simBallastingRateM3_Hr'][0])
                        
               
                elif v_[:3] in ['Max'] and v_[-1] == str(cargo_order) and (justBeforeStripping):      
                    
                    port_ = [a_ for a_, b_ in self.plans.input.loadable.info['stages'].items() if b_ == v_][0]
                    
                    ballast_plan_ = {'deballastingRateM3_Hr':{}, 'ballastingRateM3_Hr':{}}
                    cur_time_ = self.plans.input.loadable.info['stageTimes'][port_]
                    pre_time_ = self.plans.input.loadable.info['stageTimes'].get(pre_port_, 0.)
                    
                    info['stageEndTime'][v_[:-1]] = cur_time_ + self.delay
                    time_ = cur_time_-pre_time_
                    
                    # print(cur_time_, pre_time_)
                    self._get_ballast_rate(ballast_plan_, port_, pre_port_, time_)
                    
                    plan_['deballastingRateM3_Hr'] = ballast_plan_['deballastingRateM3_Hr']
                    plan_['ballastingRateM3_Hr'] = ballast_plan_['ballastingRateM3_Hr']
                    
                    if pre_port_ == self.pre_port:
                        pre_time_ += 67  # start of maxloading1
                        
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
                    
                    info['totDeballastingRateM3_Hr'].append(ballast_plan_['totDeballastingRateM3_Hr'])
                    info['totBallastingRateM3_Hr'].append(ballast_plan_['totBallastingRateM3_Hr'])
                    
                    
                    pre_port_ = port_
                    
                    if v_[:-1] == 'MaxDischarging1':
                        
                        # pass to other stage prior to MaxLoading1
                        info['iniDeballastingRateM3_Hr'] = deepcopy(ballast_plan_['deballastingRateM3_Hr'])
                        info['iniBallastingRateM3_Hr'] = deepcopy(ballast_plan_['ballastingRateM3_Hr'])
                        
                        info['simIniDeballastingRateM3_Hr'] = deepcopy(info['simDeballastingRateM3_Hr'][0])
                        info['simIniBallastingRateM3_Hr'] = deepcopy(info['simBallastingRateM3_Hr'][0])
                    
                ## to do 3 COP for now
                
                num_pump_ = len(self.plans.input.discharging.seq[cargo]['cargoPump'])
                # for p_ in self.plans.input.discharging.seq[cargo]['cargoPump']:
                #     if self.plans.input.discharging.seq[cargo]['COPendTime1'][p_] > self.plans.input.discharging.seq[cargo]['stageInterval']['stripping'][0]:
                #         num_pump_ += 1
                #     else:
                #         print(self.plans.input.discharging.seq[cargo]['COPendTime1'][p_])
                
                rate_ = self.plans.input.discharging.seq[cargo]['maxRate']/num_pump_
                vol_ = rate_*(int(info["timeEnd"]) - int(info["timeStart"]))/60
                for p_ in self.plans.input.discharging.seq[cargo]['cargoPump']:
                    id_ = self.plans.input.vessel.info['cargoPumpId'][p_]['id']
                    info["cargo"][id_] = [{"rateM3_Hr": str(round(rate_,2)),
                                             "quantityM3": str(round(vol_,2)),
                                             "timeStart": info["timeStart"],
                                             "timeEnd": info["timeEnd"]}]
                    
                    
            self.pre_port = pre_port_
                    
                    
            
            
        elif info['stage'] == 'reducedRate':
            
            if len(self.plans.input.discharging.info['cow_tanks'][cargo_order]) > 0:
                info['stage'] = 'COWStripping'
            
            if len(self.plans.input.discharging.seq[cargo]['stripTanks']) > 0:
                info['stage'] = 'COWStripping'
            
            start_ = int(self.plans.input.discharging.seq[cargo]['stageInterval']['stripping'][0] + start_time_ + self.delay)
            end_   = int(self.plans.input.discharging.seq[cargo]['stageInterval']['stripping'][1] + start_time_ + self.delay)
            info["timeStart"] = str(start_)
            info["timeEnd"] = str(end_)
            
            info['simDeballastingRateM3_Hr'] = [{}]
            info["cargoDischargingRatePerTankM3_Hr"] = []
            info["simCargoDischargingRatePerTankM3_Hr"] = []
            
            
            info['simBallastingRateM3_Hr'] = []
            
            info['totDeballastingRateM3_Hr'] = []
            info['totBallastingRateM3_Hr'] = []
            
            info1_, info2_ = {}, {}
            info3_ = {"COP1":0., "COP2":0., "COP3":0.}
            for  k_ in self.plans.input.discharging.seq[cargo]['tanks']:
                
                vol_ = [b_ for (a_,b_) in self.plans.input.discharging.seq[cargo]['reduceRate'].loc[k_,:].to_list()]
                a_ = np.where(np.diff(vol_) == 0)[0]
                if len(a_) == 0:
                    l_ = len(vol_)
                else:
                    l_ = np.where(np.diff(vol_) == 0)[0][0] + 1
                    
                # print(k_, l_)
                if l_ == 1:
                    time_ = 0
                else:
                    if vol_[-1] == 0:
                        time_ = self.plans.input.discharging.seq[cargo]['reduceRate']['C'+str(l_-1)]['Time']
                    else:
                        time_ = self.plans.input.discharging.seq[cargo]['reduceRate']['C'+str(l_)]['Time']
                # print(k_, time_, np.diff(vol_))
                
                if time_ > 0:
                    rate_ = (vol_[0]-vol_[-1])/time_*60
                else:
                    rate_ = 0.
                
                end_time_ = int(float(info['timeStart'])) + time_
                    
                info1_[self.plans.input.vessel.info['tankName'][k_]] = str(round(rate_,2))
                info2_[self.plans.input.vessel.info['tankName'][k_]] = {'tankShortName': k_,
                                                                         "rate": str(round(rate_,2)), 
                                                                             "timeStart": info["timeStart"],
                                                                             "timeEnd": str(end_time_)}
                
                # vol acc
                info3_[self.plans.input.vessel.info['tankCargoPump'][k_]] += (vol_[0]-vol_[-1])
                
                        
            info["cargoDischargingRatePerTankM3_Hr"].append(info1_)
            info["simCargoDischargingRatePerTankM3_Hr"].append(info2_)
            
            
            ## to do -------------------------------------------------------------------------------
            tot_vol_ = sum([v_ for k_,v_ in info3_.items()])
            
            num_pump_ = 0
            for p_ in self.plans.input.discharging.seq[cargo]['cargoPump']:
                if self.plans.input.discharging.seq[cargo]['COPendTime1'][p_] > self.plans.input.discharging.seq[cargo]['stageInterval']['stripping'][0]:
                    num_pump_ += 1
                else:
                    print(self.plans.input.discharging.seq[cargo]['COPendTime1'][p_])
                    
            
            for p_ in self.plans.input.discharging.seq[cargo]['cargoPump']:
                if self.plans.input.discharging.seq[cargo]['COPendTime1'][p_] > self.plans.input.discharging.seq[cargo]['stageInterval']['stripping'][0]:
                
                    end1_   = int(self.plans.input.discharging.seq[cargo]['COPendTime1'][p_] + start_time_ + self.delay)
                    time_ = end1_ - start_
                    vol_ = tot_vol_/num_pump_ #info3_[p_]
                    rate_ = vol_/time_*60
               
                    id_ = self.plans.input.vessel.info['cargoPumpId'][p_]['id']
                    info["cargo"][id_] = [{"rateM3_Hr": str(round(rate_,2)),
                                             "quantityM3": str(round(vol_,2)),
                                             "timeStart": info["timeStart"],
                                             "timeEnd": str(end1_)}]
                    
                    # print(start_, end1_, info["cargo"][id_])
            
            
            info["cargoDischargingRateM3_Hr"] = {0:str(self.plans.input.discharging.seq[cargo]['maxRate']),
                                              1:str(self.plans.input.discharging.seq[cargo]['reduceRate1'])}
            
            info["cargoDischargingRateM3_Hr"] = {}
            
            info["toLoadicator"] = True
            info["jumpStep"] = True
            pre_port_ = self.pre_port
            
            for k_, v_ in self.plans.input.loadable.info['stages'].items():
                
                if v_[:3] in ['Dep']: 
                    port_ = [a_ for a_, b_ in self.plans.input.loadable.info['stages'].items() if b_ == v_][0]
                    time_ = self.plans.input.discharging.seq[cargo]['gantt'][v_[:-1]]['Time'] + self.plans.input.discharging.seq[cargo]['startTime']
                    
                    plan_ = {'time': str(int(time_+self.delay)), 
                     "dischargeQuantityCommingleCargoDetails":[],
                     "dischargePlanStowageDetails":[],
                     "dischargePlanBallastDetails":[],
                     "dischargePlanRoBDetails":[]}
                    
                    
                    self._get_plan(plan_, port_)
                    self.final_plan = deepcopy(plan_)
                    
                    
                    ballast_plan_ = {'deballastingRateM3_Hr':{}, 'ballastingRateM3_Hr':{}}
                    
                    cur_time_ = self.plans.input.loadable.info['stageTimes'][port_]
                    pre_time_ = self.plans.input.loadable.info['stageTimes'].get(pre_port_, 0.)
                    
                    self._get_ballast_rate(ballast_plan_, port_, pre_port_, cur_time_-pre_time_)
                    
                    plan_['deballastingRateM3_Hr'] = ballast_plan_['deballastingRateM3_Hr']
                    plan_['ballastingRateM3_Hr'] = ballast_plan_['ballastingRateM3_Hr']
                    
                    info_ = {}
                    for k1_, v1_ in  ballast_plan_['deballastingRateM3_Hr'].items():
                        info_[k1_] = {'tankShortName': self.plans.input.vessel.info['tankId'][k1_],
                                     'rate': v1_,
                                     "timeStart": str(start_), "timeEnd": str(end_)}
                    
                    plan_['simDeballastingRateM3_Hr'] = deepcopy(info_)
                    
                    info_ = {}
                    for k1_, v1_ in  ballast_plan_['ballastingRateM3_Hr'].items():
                        info_[k1_] = {'tankShortName': self.plans.input.vessel.info['tankId'][k1_],
                                     'rate': v1_,
                                     "timeStart": str(start_), 
                                     "timeEnd": str(end_)}
                    
                    plan_['simBallastingRateM3_Hr'] = deepcopy(info_)
                    
                    self.final_ballast = plan_
                
                elif v_[:3] in ['Str'] and v_[-1] == str(cargo_order):
                    
                    port_ = [a_ for a_, b_ in self.plans.input.loadable.info['stages'].items() if b_ == v_][0]
                    time_ = self.plans.input.discharging.seq[cargo]['gantt'][v_[:-1]]['Time'] + self.plans.input.discharging.seq[cargo]['startTime']
                    time1_ = self.plans.input.discharging.seq[cargo]['gantt'][v_[:-1]]['Time'] 
                    if v_[:-1] !=  self.plans.input.discharging.seq[cargo]['lastStage']:
                        # print(time_)
                        time0_ = time_
                        # c_ = self.plans.input.discharging.info['discharging_order'][int(v_[-1])-1]
                        # c1_ = self.plans.input.discharging.info['dsCargoNominationId'][c_]
                        time_interval_ = self.plans.input.discharging.time_interval[cargo_order]
                        time_ = time_interval_ * round(time1_/time_interval_) + self.plans.input.discharging.seq[cargo]['startTime']
                        print(v_, time0_, '->', time_)

                    plan_ = {'time': str(int(time_+self.delay)), 
                     "dischargeQuantityCommingleCargoDetails":[],
                     "dischargePlanStowageDetails":[],
                     "dischargePlanBallastDetails":[],
                     "dischargePlanRoBDetails":[]}
                    
                    
                    self._get_plan(plan_, port_)
            
                    info['dischargePlanPortWiseDetails'].append(plan_)
                    
                    info_ = {}
                    for a_, b_ in plan_.items():
                        if a_ in STAGE_INFO:
                            info_[a_] = b_
                            # if a_ in ['time']:
                            #     info_[a_] = str(int(info_[a_]) + self.delay)
                            
                    self.stages.append(info_)
                    
                    # if self.plans.input.discharging.seq['stages'][-1] == v_:
                    #     self.final_plan = plan_
                        
                    ballast_plan_ = {'deballastingRateM3_Hr':{}, 'ballastingRateM3_Hr':{}}
                    
                    cur_time_ = self.plans.input.loadable.info['stageTimes'][port_]
                    pre_time_ = self.plans.input.loadable.info['stageTimes'].get(pre_port_, 0.)
                    
                    self._get_ballast_rate(ballast_plan_, port_, pre_port_, cur_time_-pre_time_)
                    
                    plan_['deballastingRateM3_Hr'] = ballast_plan_['deballastingRateM3_Hr']
                    plan_['ballastingRateM3_Hr'] = ballast_plan_['ballastingRateM3_Hr']
                    
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
                    
                    info['totDeballastingRateM3_Hr'].append(ballast_plan_['totDeballastingRateM3_Hr'])
                    info['totBallastingRateM3_Hr'].append(ballast_plan_['totBallastingRateM3_Hr'])
                    
                    pre_port_ = port_
                    
            self.pre_port = pre_port_
            self.last_plan = plan_
            
        
        elif info['stage'] == 'dryCheck':
            
            start_ = int(self.plans.input.discharging.seq[cargo]['stageInterval']['stripping'][1] + start_time_ + self.delay)
            end_   = int(60 + self.plans.input.discharging.seq[cargo]['stageInterval']['stripping'][1] + start_time_ + self.delay)
            info["timeStart"] = str(start_)
            info["timeEnd"] = str(end_)
        
        elif info['stage'] == 'slopDischarge':
            
            start_ = int(60 + self.plans.input.discharging.seq[cargo]['stageInterval']['stripping'][1] + start_time_ + self.delay)
            end_   = int(60*2 + self.plans.input.discharging.seq[cargo]['stageInterval']['stripping'][1] + start_time_ + self.delay)
            info["timeStart"] = str(start_)
            info["timeEnd"] = str(end_)
            
            if self.plans.input.discharging.seq[cargo]['driveTank']:
                print('slopDischarge')
                tank_ = self.plans.input.discharging.seq[cargo]['driveTank']['tank']
                info['stripping'].append({'tankShortName':tank_, 
                                          'tankId':self.plans.input.vessel.info['tankName'][tank_],
                                          "timeStart":str(start_),
                                          "timeEnd":str(end_)})
                
                cargo_pump_ = self.plans.input.vessel.info['tankCargoPump'][tank_]
                id_ = self.plans.input.vessel.info['cargoPumpId'][cargo_pump_]['id']
                vol_ = self.plans.input.discharging.seq[cargo]['driveTank']['driveVol']
                rate_ = vol_ ## m3/hr
                info["cargo"][id_] = [{"rateM3_Hr": str(round(rate_,2)),
                                     "quantityM3": str(round(vol_,2)),
                                     "timeStart": info["timeStart"],
                                     "timeEnd": info["timeEnd"]}]
                
        
        elif info['stage'] == 'finalStripping':
            start_ = int(60*(final_event-1) + self.plans.input.discharging.seq[cargo]['stageInterval']['stripping'][1] + start_time_ + self.delay)
            end_   = int(60*final_event + self.plans.input.discharging.seq[cargo]['stageInterval']['stripping'][1] + start_time_ + self.delay)
            info["timeStart"] = str(start_)
            info["timeEnd"] = str(end_)
            
           
            id_ = self.plans.input.vessel.info['cargoPumpId']['STP']['id']
            info["STP"][id_] = [{"rateM3_Hr": "",
                                     "quantityM3": "",
                                     "timeStart": info["timeStart"],
                                     "timeEnd": info["timeEnd"]}]
        
        else:
            print(info['stage'])
            exit(1)
    
                
            
        
            
    def _get_ballast_rate(self, plan, port, prev_port, time):
        # stage_ = self.plans.input.loadable['stages'][port]
        # print(port, prev_port, time)
        pre_ballast_ = self.plans.input.discharging.info['ballast'][0] if prev_port == 0 else self.plans.ballast_weight[0][str(prev_port)]
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
        plan['totBallastingRateM3_Hr'] = str(round(ballast_amt_/time*60,12))
        plan['totDeballastingRateM3_Hr'] = str(round(deballast_amt_/time*60,12))
        
        
        
               
            
          
        
    
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
                
                
                info_['dsCargoNominationId'] = int(self.plans.input.discharging.info['cargoNominationId'][v_[0]['parcel']][1:])
                info_['cargoId'] = self.plans.input.discharging.info['cargoId'][v_[0]['parcel']]
                info_['colorCode'] = self.plans.input.discharging.info['colorCode'][v_[0]['parcel']]
                info_['cargoAbbreviation'] = self.plans.input.discharging.info['abbreviation'][v_[0]['parcel']]
                info_['abbreviation'] = self.plans.input.discharging.info['abbreviation'][v_[0]['parcel']]
                
                    
                if v_[0]['parcel'] not in plan["cargoVol"]:
                    plan["cargoVol"][v_[0]['parcel']] = v_[0]['wt']/v_[0]['SG']
                else:
                    plan["cargoVol"][v_[0]['parcel']] += v_[0]['wt']/v_[0]['SG']
                
                plan["dischargePlanStowageDetails"].append(info_)
            
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
#        print(empty_)
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
            
            parcel_ = self.plans.input.discharging.info['tank_cargo'].get(k_, None)
            
            if parcel_:
                info_['cargoNominationId'] = int(parcel_[1:])
                info_['dsCargoNominationId'] = int(self.plans.input.discharging.info['cargoNominationId'][parcel_][1:])
                    
                
                info_['cargoId'] = self.plans.input.discharging.info['cargoId'][parcel_]
                info_['colorCode'] = self.plans.input.discharging.info['colorCode'][parcel_]
                info_['cargoAbbreviation'] = self.plans.input.discharging.info['abbreviation'][parcel_]
                info_['abbreviation'] = self.plans.input.discharging.info['abbreviation'][parcel_]
            else:
                info_['cargoNominationId'] = None
                info_['dsCargoNominationId'] = None
                
                info_['cargoId'] = None
                info_['colorCode'] = None
                info_['cargoAbbreviation'] = None
                info_['abbreviation'] = None
                
                
            
            plan["dischargePlanStowageDetails"].append(info_)
            
                
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
            info_['colorCode'] = self.plans.input.discharging.ballast_color.get(k_,None)
            
            if k_ not in ballast_tanks_added_:
                ballast_tanks_added_.append(k_)
                
            plan["ballastVol"] += v_[0]['vol']
            
            plan["dischargePlanBallastDetails"].append(info_)
            
            
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
            plan["dischargePlanBallastDetails"].append(info_)
            
            
        plan["ballastVol"] = str(round(plan["ballastVol"],2))    
        
        
        for k_, v_ in other_weight_.items():
            info_ = {}
            info_['tankShortName'] = k_
            info_['tankName'] =  self.plans.input.vessel.info['tankFullName'][k_]
            info_['tankId'] = int(self.plans.input.vessel.info['tankName'][k_])
            info_['quantityMT'] = str(round(abs(v_[0]['wt']),2))
            info_['quantityM3'] = str(round(abs(v_[0]['vol']),2))
            
            info_['density'] = str(self.plans.input.config['rob_density'][k_])
            info_['colorCode'] = self.plans.input.discharging.rob_color[k_]
            
            if k_ not in other_tanks_added_:
                other_tanks_added_.append(k_)
            
            plan["dischargePlanRoBDetails"].append(info_)
            
            
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
            info_['colorCode'] = self.plans.input.discharging.rob_color[k_]
            plan["dischargePlanRoBDetails"].append(info_)
            
            
        
        
        ##
        plan["foreDraft"] = self.stability[str(port)]['forwardDraft']
        plan["meanDraft"] = self.stability[str(port)]['meanDraft']
        plan["afterDraft"] = self.stability[str(port)]['afterDraft']
        plan["trim"] = self.stability[str(port)]['trim']
        plan["heel"] = self.stability[str(port)]['heel']
        plan["airDraft"] = self.stability[str(port)]['airDraft']
        plan["bendinMoment"] = self.stability[str(port)]['bendinMoment']
        plan["shearForce"] = self.stability[str(port)]['shearForce']
        plan["gom"] = self.stability[str(port)].get('gom', None)
        plan["manifoldHeight"] = self.stability[str(port)]['manifoldHeight']
        plan["freeboard"] = self.stability[str(port)]['freeboard']
        
        
        