# -*- coding: utf-8 -*-
"""
Created on Thu Oct 14 22:27:05 2021

@author: phtan1
"""
import numpy as np
import json
from vlcc_gen import Generate_plan 
from vlcc_check import Check_plans
from copy import deepcopy
import pandas as pd
from scipy.interpolate import interp1d
# from discharge_init import Process_input1

INITIAL_RATE = 1000
REDUCED_RATE = 1500

# MAX_RATE = {1: 12000, 2:11129, 3:11553, 4:5829}

INDEX = ['Time', '1C', '2C', '3C', '4C', '5C', '1P', '1S', '2P', '2S', '3P', '3S', '4P', '4S', '5P', '5S', 'SLP', 'SLS']
        

class DischargingOperations(object):
    # 
    def __init__(self, data):
        
        self.error = {}
        self.ballast_color, self.rob_color = {}, {}
        self.vessel = data.vessel
        self.module = data.module
        self.mode = ""
        
        self.time_interval1 = data.discharging_info_json['dischargingStages']['stageDuration']*60 # in 60*4 min
        self.num_stage_interval =  data.discharging_info_json['dischargingStages']['stageOffset']
        
        self.config = data.config
        print('time interval:', self.time_interval1)
        
        # discharging_rate_ = min(data.loading_info_json['loadingRates']['maxLoadingRate'], shoreLoadingRate_)
        # self.max_loading_rate = loading_rate_
        # # loading_rate_ = 7000
        # print('loading rate (max):', loading_rate_)
        # min_loading_rate_ = data.loading_info_json['loadingRates']['minLoadingRate']
        # min_loading_rate_ = min_loading_rate_ if min_loading_rate_ not in [None, ""] else 1000.
        # print('loading rate (min):', min_loading_rate_)
        
        # self.max_ballast_rate = data.loading_info_json['loadingRates'].get('maxDeBallastingRate',7000.)*1.025
        # # self.max_ballast_rate = 7000.
        # print('max ballast:', self.max_ballast_rate)
        
        
        self.seawater_density = float(data.port_json['portDetails'].get('seawaterDensity', 1.025))
        
        
        self.preloaded_cargos = []
        self.commingle_loading, self.commingle_preloaded = False, False
        
        self.time_interval = {}
        
        cargo_info_ = {}
        
        # initial and final ROB
        self._get_rob(data.vessel_json['onHand'], cargo_info_)
        
        cargo_info_['cargoTanksUsed'], cargo_info_['ballastTanksUsed'] = [], []
        # initial Ballast, final Ballast
        cargo_info_['ballast'] = []
        
        
        # initial Ballast, final Ballast
        cargo_info_['ballast'] = []
        self._get_ballast(data.discharge_json['planDetails']['arrivalCondition']['dischargePlanBallastDetails'], cargo_info_)
        self._get_ballast(data.discharge_json['planDetails']['departureCondition']['dischargePlanBallastDetails'], cargo_info_)
        self._get_eduction(cargo_info_)
        
        tank_ = [t_ for t_ in cargo_info_['tankToBallast'] if t_[0] == 'W' ]
        # self.num_pump = 1 if (len(cargo_info_['tankToBallast']) + len(cargo_info_['tankToDeballast']) <= 4) else 2
        self.num_pump = 1 if (len(tank_) <= 4) else 2
        print('num ballast pump:', self.num_pump)
        
        self.discharging_rate = {}
        
        cargo_info_['discharging_order1'], order_ = {}, 1
        cargo_info_['discharging_qty1'], order_ = {}, 1
        
        for d_ in data.discharging_info_json['dischargingSequences']['dischargeDelays']:
            if d_['dsCargoNominationId'] in [0]:
                pass
            else:
                ## at cargo level                
                # self.discharging_rate[order_] = d_.get('maxDischargingRate', 7000)
                self.discharging_rate[order_] = data.discharging_info_json['dischargingRates'].get('maxDischargingRate', 7000)
                
                # self.discharging_rate[order_] = MAX_RATE[order_]
                
                cargo_ = 'P'+str(d_['dsCargoNominationId'])
                
                if cargo_ not in cargo_info_['discharging_order1']:
                    cargo_info_['discharging_order1'][cargo_] = [order_]
                    cargo_info_['discharging_qty1'][cargo_] = [d_['quantity']]
                    
                else:
                    cargo_info_['discharging_order1'][cargo_].append(order_)
                    cargo_info_['discharging_qty1'][cargo_].append(d_['quantity'])
                    
                order_ += 1
                
                
        # multiple discharge of single cargo        
        cargo_info_['multiDischarge'] = [k_ for k_, v_ in cargo_info_['discharging_order1'].items() if len(v_) > 1]
        cargo_info_['numStages'] = sum([len(v_) for k_, v_ in cargo_info_['discharging_order1'].items()])
         
        
        # if True in partial_discharge_:
        #     self.error['Partial Discharge'] = 'Partial Discharge not supported!!'
                
        cargo_info_['timing_delay1'] = [0 for d_ in range(cargo_info_['numStages'])]
        # cumsum ## 
        # for d_ in data.discharging_info_json['dischargingSequences']['dischargeDelays']:
        #     if d_['dsCargoNominationId'] in [0]:
        #         cargo_info_['timing_delay1'][0] +=  d_['duration']
        #     else:
        #         o_ = cargo_info_['loading_order1']['P'+str(d_['cargoNominationId'])]-1
        #         cargo_info_['timing_delay1'][o_] += d_['duration']
                
        # add plans -------------------------------------------------------------------------
        cargo_info_['cargo_plans'] = []
        cargo_info_['cargo_tank'] = {}
        cargo_info_['density'], cargo_info_['api'], cargo_info_['temperature'] = {}, {}, {}
        cargo_info_['cargoId'], cargo_info_['colorCode'], cargo_info_['abbreviation'] = {}, {}, {}
        cargo_info_['commingle'] = {}
        cargo_info_['cargo_pump'] = {}
        
        cargoDetails_ = data.discharging_info_json['dischargeQuantityCargoDetails']
        
        cargo_info_['cargoNominationId'] = {'P'+ str(l_['cargoNominationId']) : 'P'+ str(l_['dsCargoNominationId']) for l_ in cargoDetails_}
        cargo_info_['dsCargoNominationId'] = {'P'+str(l_['dsCargoNominationId']) : 'P'+ str(l_['cargoNominationId']) for l_ in cargoDetails_}
        
        # initial plan
        self._get_plan(data.discharge_json['planDetails']['arrivalCondition']['dischargePlanStowageDetails'],
                       cargo_info_, cargoDetails_, 
                       commingleDetails = data.discharge_json['planDetails']['arrivalCondition']['dischargePlanCommingleDetails'],
                       initial = True)
        
        cargo_info_['pre_cargo'] = [k_ for k_,v_ in cargo_info_['cargo_tank'].items()]
        cargo_info_['discharging_order'] = [-1 for d_ in range(cargo_info_['numStages'])]
        cargo_info_['discharging_qty'] = [-1 for d_ in range(cargo_info_['numStages'])]
        for (k_, v_), (k1_, v1_) in zip(cargo_info_['discharging_order1'].items(), cargo_info_['discharging_qty1'].items()):
            assert k_ == k1_
            for a_, b_ in zip(v_, v1_):
                cargo_info_['discharging_order'][a_-1] = k_
                cargo_info_['discharging_qty'][a_-1] = -b_
                
                
        cargo_info_['tank_cargo'] = {k1_:k_  for k_, v_ in cargo_info_['cargo_tank'].items() for k1_ in v_}
                
        ##        
        # cargo_info_['discharging_order'] = ['P200000178', 'P200000176', 'P200000177']
        # cargo_info_['discharging_order1'] = {'P200000178': [1], 'P200000176': [2], 'P200000177': [3]}
        # cargo_info_['multiDischarge'] = False
        
        cargo_info_['stripping_tanks'] = {d__+1:[]  for d__,d_ in enumerate(cargo_info_['discharging_order'])}
        dep_plan_ = []
        dep_tanks_, arr_tanks_ = [], []
        for l_ in data.discharge_json['planDetails']['departureCondition']['dischargePlanStowageDetails']:
            dep_plan_.append(l_)
            dep_tanks_.append(self.vessel.info['tankId'][l_['tankId']])
            
        all_tanks_ = []
        for k_, v_ in cargo_info_['cargo_tank'].items():
            all_tanks_ += v_
            
        empty_tanks_ = set(all_tanks_) - set(dep_tanks_)
        for i_ in data.discharge_json['planDetails']['arrivalCondition']['dischargePlanStowageDetails']:
            tank_ = self.vessel.info['tankId'][i_['tankId']]
            if tank_ in empty_tanks_:
                info_ = dict(i_)
                info_['quantityMT'] = '0.0'
                dep_plan_.append(info_)
                
        if not cargo_info_['multiDischarge']:
            print('No multiple discharge for each cargo')
            # cargo_info_['loading_order'] = ['A','B','C','D']
            for o__,o_ in enumerate(cargo_info_['discharging_order'][:-1]):
                
                not_cargo_ = cargo_info_['discharging_order'][o__+1:]
                # print(not_cargo_)
                self._get_plan(dep_plan_,
                            cargo_info_, cargoDetails_, 
                            commingleDetails = data.discharge_json['planDetails']['departureCondition']['dischargePlanCommingleDetails'],
                            initial = False, not_cargo = not_cargo_, strip_info=True)
            
            # final plan     
            self._get_plan(data.discharge_json['planDetails']['departureCondition']['dischargePlanStowageDetails'],
                       cargo_info_, cargoDetails_, 
                       commingleDetails = data.discharge_json['planDetails']['departureCondition']['dischargePlanCommingleDetails'],
                       initial = False, strip_info=True)
            
        else:
            print('multiple_discharge:', cargo_info_['multiDischarge'])
            
            # final plan 
            self._get_plan(data.discharge_json['planDetails']['departureCondition']['dischargePlanStowageDetails'],
                           cargo_info_, cargoDetails_, 
                           commingleDetails = data.discharge_json['planDetails']['departureCondition']['dischargePlanCommingleDetails'],
                           initial = False)
            
            final_plan_ = cargo_info_['cargo_plans'].pop()
            
            
            cargo_info_['portOpt'] = sum([v_[:-1] for k_, v_ in cargo_info_['discharging_order1'].items() if len(v_) > 1], [])
            self.info = cargo_info_
            self.solver = 'AMPL'
            self._get_plan_ampl(cargo_info_, final_plan_)
            self._write_ampl()
            
            self.module = 'DISCHARGING'
            self.vessel_id  = '1'
            
            gen_output = Generate_plan(self)
            gen_output.run(num_plans=1)
            
            plan_check = Check_plans(self, reballast = False)
            plan_check._check_plans(gen_output)
            
            # # # input("Press Enter to continue...")
    
            
            plan_ = gen_output.plans.get('ship_status',[])
            # plan_ = []
            if len(plan_) == 0:
                self.error['Optimization Error'] = ['No discharge plan generated!!']
                return
            else:
                plan__ = []
                
                for k_, v_ in plan_[0].items():
                    if k_ not in ['0']:
                        info_ = {}
                      
                        cargo_to_discharge1_ = cargo_info_['discharging_order'][int(k_)-1]
                        cargo_to_discharge_ = cargo_info_['dsCargoNominationId'][cargo_to_discharge1_] 
                        
                        
                        fill_tank_ = []
                        for k1_, v1_ in  v_['cargo'].items():
                            
                            info_[k1_] = [{'abbreviation': cargo_info_['abbreviation'][v1_[0]['parcel']],
                                          'api': v1_[0]['api'],
                                          'cargo': v1_[0]['parcel'],
                                          'cargoId': cargo_info_['cargoId'][v1_[0]['parcel']],
                                          'colorCode': cargo_info_['colorCode'][v1_[0]['parcel']],
                                          'corrUllage': v1_[0]['corrUllage'],
                                          'lcg': v1_[0]['lcg'],
                                          'quantityMT': v1_[0]['wt'],
                                          'quantityM3': v1_[0]['vol'],
                                          'SG': v1_[0]['SG'],
                                          'tankId': self.vessel.info['tankName'][k1_],
                                          'tcg': v1_[0]['tcg'],
                                          'temperature': v1_[0]['temperature']
                                          }]
                            
                            fill_tank_.append(k1_)
                           
                        empty_ = set(self.vessel.info['cargoTankNames']) - set(fill_tank_)
                        for t__, t_ in enumerate(empty_):
                            # print(t__, t_)
                            info_[t_] =  deepcopy(cargo_info_['cargo_plans'][0][t_])
                            info_[t_][0]['quantityMT'] = 0.
                            info_[t_][0]['quantityM3'] = 0.
                           
                            if cargo_to_discharge_ == info_[t_][0]['cargo']:
                                if cargo_to_discharge1_ in cargo_info_['multiDischarge']:
                                    ports_ = cargo_info_['discharging_order1'][cargo_to_discharge1_]
                                    appended_ = [True for a_, b_ in cargo_info_['stripping_tanks'].items() if t_ in b_ and a_ in ports_]
                                    if True in appended_:
                                        pass
                                    else:
                                        cargo_info_['stripping_tanks'][int(k_)].append(t_)
                                      
                                else:
                                    cargo_info_['stripping_tanks'][int(k_)].append(t_)
                            
                        plan__.append(info_)
                    
            
            ## 
            # with open("plan1.json", "w") as outfile:
            #     json.dump(plan__, outfile)
            
            # with open("plan2.json", "r") as outfile:
            #    plan__ = json.load(outfile)
            # cargo_info_['stripping_tanks'] = {1: [], 2: ['1P', '3P', '3S', '1S'], 3: [], 4: ['2C', '4C']}
            
            # plan_check = Check_plans(self)
            # plan_check._check_plans(gen_output.plans.get('ship_status',[]), gen_output.plans.get('cargo_tank',[]))
            
            cargo_info_['cargo_plans'] += plan__
            
        # cargo_info_['cargo_plans'].append(final_plan_)
        
        
        print('strip_tanks:', cargo_info_['stripping_tanks'])
        self._get_COW_tanks(cargo_info_)
        print('collect cow_tanks:', cargo_info_['cow_tanks'])
        self.info = cargo_info_
        ## discharging_order1 and discharging_order dsCargoNomination 
        
        
    def _get_COW_tanks(self, cargo_info):
        TANKS_TO_COW = ['3C','1C','2C','4C','5C']
        cargo_info['cow_tanks'] = {1: [], 2: [], 3: [], 4: [], 5:[], 6:[], 7:[], 8:[], 9:[]}
        
        for t_ in TANKS_TO_COW:
            for k_, v_ in cargo_info['stripping_tanks'].items():
                if t_ in v_:
                    cargo_info['cow_tanks'][k_].append(t_)
                    
                    
            
            
            
        
    def _get_eduction(self, cargo_info_):

        cargo_info_['tankToBallast'] = []
        cargo_info_['tankToDeballast'] = []
        cargo_info_['eduction'] = []
        
        for k_, v_ in cargo_info_['ballast'][0].items():
            initial_ = v_[0]['quantityMT']
            final_ = cargo_info_['ballast'][1].get(k_, [{'quantityMT':0.}])[0]['quantityMT']
            # print(initial_,  final_, k_)
            if initial_ - final_ > 0. and k_ not in cargo_info_['tankToDeballast']:
                # print('tankToDeballast', initial_,  final_, k_)
                cargo_info_['tankToDeballast'].append(k_)
                if final_ == 0.:
                    cargo_info_['eduction'].append(k_)
                    
            elif initial_ - final_ < 0. and k_ not in cargo_info_['tankToBallast']:
                # print('tankToBallast', initial_,  final_, k_)
                cargo_info_['tankToBallast'].append(k_)
                
        for k_, v_ in cargo_info_['ballast'][1].items():
            final_ = v_[0]['quantityMT']
            initial_ = cargo_info_['ballast'][0].get(k_, [{'quantityMT':0.}])[0]['quantityMT']
            # print(initial_,  final_, k_)
            if initial_ - final_ > 0. and k_ not in cargo_info_['tankToDeballast']:
                # print('tankToDeballast', initial_,  final_, k_)
                cargo_info_['tankToDeballast'].append(k_)
            elif initial_ - final_ < 0. and k_ not in cargo_info_['tankToBallast']:
                # print('tankToBallast', initial_,  final_, k_)
                cargo_info_['tankToBallast'].append(k_)
                
                
    # def _get_cow(self, cargo_info):
        
    #     NUM_COW = 5
    #     cargo_info['cow_tanks'] = {}
    #     cargo_info['drive_tanks'] = {}
    #     n_cows_ = 0
            
    #     for k_, v_ in cargo_info['stripping_tanks'].items():
    #         cargo_info['cow_tanks'][k_] = []
            
    #         if 'SLS' in v_ and 'SLP' in v_:
    #             cargo_info['drive_tanks'][k_] = 'SLP'
    #         elif 'SLS' in v_:
    #             cargo_info['drive_tanks'][k_] = 'SLS'
    #         elif 'SLP' in v_:
    #             cargo_info['drive_tanks'][k_] = 'SLP'
    #         else:
    #             cargo_info['drive_tanks'][k_] = None
                
                
                
    #         # print(k_, v_)
    #         for t_ in v_:
    #             if t_[-1] not in ['C'] and t_ not in ['SLS', 'SLP']:
    #                 if n_cows_ <= NUM_COW:
    #                     cargo_info['cow_tanks'][k_] += [t_[0]+'P', t_[0]+'S']
    #             else:
    #                 if n_cows_ <= NUM_COW and t_ not in cargo_info['cow_tanks'][k_]:
    #                     cargo_info['cow_tanks'][k_] += [t_]
  
    def _gen_stripping(self):
        # INDEX = self.config["gantt_chart_index"]
        
        # MAX_RATE = {1: 12000, 2:11129, 3:11553, 4:5829}
        
        TIME_SEP = 2
        TIME_PUMP_WARM = 30
        TIME_AIR_PURGE = 2 ## if required
        TIME_INITIAL = TIME_SEP + TIME_PUMP_WARM 
        TIME_INIT_RATE = 20
        TIME_INC_RATE = 15# 15000m3/hr: 45mins 10000-15000m3/hr: 30mins 5000-10000m3/hr: 15mins

        
        ## manually set which tanks to COW at each stage
#        self.info['cow_tanks'] = {1: [], 2: ['1P','3P','1S','3S'], 3: [], 4: [], 5:[], 6:[], 7:[], 8:[]}
        print('cow tanks', self.info['cow_tanks'])
        self.seq = {}
        
        start_time_ = 0 # 
        
        for p__, p_ in enumerate(self.info['cargo_plans'][:-1]):
            
            df_ = pd.DataFrame(index=INDEX)
            
            df_['Initial'] = None
            df_['Initial']['Time'] = TIME_INITIAL
            df_init_ = df_['Initial'].copy()
            
            stages_ = {"initialCondition":(df_['Initial']['Time'], df_['Initial']['Time'])}
            
            cargo_to_discharge1_ = self.info['discharging_order'][p__]
            cargo_to_discharge_ = self.info['dsCargoNominationId'][cargo_to_discharge1_]
            
            self.seq[cargo_to_discharge_+str(p__)] = {}
            print(p__, cargo_to_discharge_,'cargo stripping')
            
            
            # for each cargo volume
            for k_, v_ in p_.items(): #self.info['plans'][p__+1].items():
                # set time 0
                tank_ = k_
                df_['Initial'][tank_] = (v_[0]['cargo'], v_[0]['quantityM3'])
                df_init_[tank_] = v_[0]['quantityM3']
                ##
                ## need to consider commingle later ???
                        
            # empty_ = []
            # for t_ in self.info['cargo_tank'][cargo_to_discharge_]:
            #     if df_['Initial'][t_] in [None]:
            #         empty_.append(True)
            #     else:
            #         empty_.append(False)
                    
            # self.commingle_loading1 = True if False in empty_ else False # at cargo level
            
            tanks_ = []
            for k_, v_ in self.info['cargo_plans'][p__+1].items():
                # print(v_[0]['cargo'], cargo_to_discharge_)
                if v_[0]['cargo'] == cargo_to_discharge_:
                    next_ = v_[0]['quantityMT']
                    cur_ = p_[k_][0]['quantityMT']
                    
                    if cur_ > next_ +1:
                        tanks_.append(k_)
                        
            total_tank_ = len(tanks_)
            print(tanks_)
            
            # ----------------------------------------------------
            direct_cargo_pump_ = []
            direct_cargo_tank_pump_ = {}
            
            for t_ in tanks_:
                cp_ = self.vessel.info['tankCargoPump'][t_]
                if cp_ not in direct_cargo_pump_:
                    direct_cargo_pump_.append(cp_)
                    direct_cargo_tank_pump_[cp_] = 1
                else:
                    direct_cargo_tank_pump_[cp_] += 1
            
            # initial rate ---------------------------------
            # 20 min
            df_['InitialRate'] =  df_['Initial']
            df_['InitialRate']['Time'] = TIME_INITIAL+TIME_INIT_RATE
            
            discharging_rate_ = INITIAL_RATE
            discharging_rate_per_tank_ = discharging_rate_/total_tank_
            # cargo_loaded_per_tank_ = cargo_loaded_/total_tank_
            stages_['initialRate'] = (df_['Initial']['Time'], df_['InitialRate']['Time'])
            
            self.seq[cargo_to_discharge_+str(p__)]['initialRate'] = discharging_rate_     
            
            for t_ in tanks_:
                    
                # if t_ == self.info['commingle'].get('tankName', None) and self.commingle_loading1:
                #     continue # not counting commingle tank
                
                cargo_loaded_per_tank_ = df_['InitialRate'][t_][1] - discharging_rate_per_tank_*20/60
                
                df_['InitialRate'][t_] = (cargo_to_discharge_, cargo_loaded_per_tank_)
                
            # increase to max rate ----------------------------------------------------------------
            df_['IncMax'] =  df_['InitialRate']
            df_['IncMax']['Time'] = TIME_INITIAL+TIME_INIT_RATE+TIME_INC_RATE # end time
            df_inc_max_ = pd.DataFrame(index=INDEX)
            df_inc_max_['VolRemoved'] = None
            
            max_rate_ = self.discharging_rate[p__+1]
            # max_rate_ = MAX_RATE[p__+1]
            # max_rate_ = 10000
            print('max rate:', max_rate_ )
            
            # direct_rate_ = 5500*len(direct_cargo_pump_)
            # if direct_rate_
            num_pump_ = np.ceil(max_rate_/5500)
            add_pump_ = []
            if len(direct_cargo_pump_) > num_pump_:
                # need to remove pump
                while True:
                    mincp_, min_ = 0, 1000
                    for k_, v_  in direct_cargo_tank_pump_.items():
                        if v_ < min_:
                            mincp_ = k_
                            min_ = v_
                            
                    del direct_cargo_tank_pump_[mincp_]                    
                    if num_pump_ == len(direct_cargo_tank_pump_):
                        cargo_pump_ = list(direct_cargo_tank_pump_.keys())
                        break
  
            elif len(direct_cargo_pump_) < num_pump_:
                # need to add
                add_pump_ = set(['COP1', 'COP2', 'COP3']) - set(direct_cargo_pump_)
                cargo_pump_ = list(direct_cargo_pump_)
                for pp_ in ['COP1', 'COP2', 'COP3']:
                    if pp_ in add_pump_ and len(cargo_pump_) < num_pump_:
                        cargo_pump_.append(pp_)
                        
            else:
                cargo_pump_ = direct_cargo_pump_
                
            print('direct cargo pump:', direct_cargo_pump_)    
            print('cargo pump:', cargo_pump_)    
   
            discharging_rate_ = (INITIAL_RATE + max_rate_)/2
            
            discharging_rate_per_tank_ = discharging_rate_/total_tank_
            # cargo_loaded_per_tank_ = cargo_loaded_/total_tank_
            
            self.seq[cargo_to_discharge_+str(p__)]['incMaxRate'] = discharging_rate_     
           
            
            stages_['increaseToMaxRate'] = (df_['InitialRate']['Time'], df_['IncMax']['Time'])
            
            for t_ in tanks_:
                    
                # if t_ == self.info['commingle'].get('tankName', None) and self.commingle_loading1:
                #     continue # not counting commingle tank
                
                cargo_loaded_per_tank_ = df_['IncMax'][t_][1] - discharging_rate_per_tank_*15/60
                
                df_['IncMax'][t_] = (cargo_to_discharge_, cargo_loaded_per_tank_)
                df_inc_max_['VolRemoved'][t_] = df_init_[t_] - cargo_loaded_per_tank_
                
                
            ## backward calculation ------------------------------------------------------------------------
            cow_strip_, drive_tank_, strip_, partial_ = self._cal_cow_strip(p__, cargo_to_discharge_, df_['Initial'], tanks_, max_rate_)
            
            #self.seq[cargo_to_load_]['staggerRate'] = deepcopy(staggering_rate_) 
            
            self.seq[cargo_to_discharge_+str(p__)]['reduceRate'] = deepcopy(cow_strip_.iloc[:,:-1]) 
            
            num_stripping_ = len(cow_strip_.columns)-1
            cow_strip_['AmtRemoved'] = None
            
            for t_ in tanks_:
                cow_strip_['AmtRemoved'][t_] = cow_strip_['C1'][t_][1] - cow_strip_['C'+str(num_stripping_)][t_][1] #round(vol_,10)
                    
            cow_strip_['AmtBefStrip'] =  df_init_ -  cow_strip_['AmtRemoved'] - cow_strip_['TotalVol']
            
            time_taken_ =  float(cow_strip_['AmtBefStrip'].sum() - df_inc_max_.sum())/ max_rate_*60 # min
            
            if drive_tank_:
                # print(self.drive_tank)
                tank_ = drive_tank_['tank']
                vol_ = cow_strip_['C1'][tank_][1]
                cow_strip_['AmtBefStrip'][tank_] = df_init_[tank_]  - vol_
                drive_tank_['driveVol'] = vol_
                
                
            cow_strip_['LoadingRateM3Min'] = (cow_strip_['AmtBefStrip']- df_inc_max_['VolRemoved'])/time_taken_
            
            # max discharging
            discharging_rate_ = max_rate_
            
            
            self.seq[cargo_to_discharge_+str(p__)]['maxRate'] = discharging_rate_     
           
            
            stripping_start_ = time_taken_ + TIME_INITIAL + TIME_INIT_RATE + TIME_INC_RATE
            
            time_interval_ = self.time_interval1 ## fixed
            num_stages_ = 0
            self.time_interval[p__+1] = time_interval_
            
            df1_ = df_.copy()
            
            while num_stages_ < self.num_stage_interval and time_interval_ >= 60 :
            
                # self.time_interval = time_interval_
                time_, stage_ = time_interval_, 1
                time_incmax_ = df_['IncMax']['Time']
                
                ballast_ = [(0, 'Initial')]
                if time_incmax_ > time_:
                    ballast_.append([time_incmax_, 'IncMax'])
                    time_ += time_interval_
                    stage_ += 1
                
                ballast_stop_, before_stripping_ = [], 'MaxDischarging' + str(stage_)
                single_max_stage_ = True
                while (time_ < stripping_start_):
                    single_max_stage_ = False
                    # print(time_)
                    ss_ = 'MaxDischarging' + str(stage_)
                    df_[ss_] = df_['IncMax']
                    df_[ss_]['Time'] = int(time_)
                    before_stripping_ = ss_
                    ballast_.append((int(time_),ss_))
                    
                    for t_ in tanks_:
                        # if self.commingle_loading1:
                        #     pass
                        # else:
                        df_[ss_][t_] = (cargo_to_discharge_, df_['IncMax'][t_][1] - (time_-time_incmax_)*cow_strip_['LoadingRateM3Min'][t_])
                    
                    time_ += time_interval_
                    stage_ += 1
                
                num_stages_ = stage_-1
                
                next_time_ = time_ # next interval
                time_ = stripping_start_
                ss_ = 'MaxDischarging' + str(stage_)
                just_before_stripping_ = ss_
                df_[ss_] = df_['IncMax']
                df_[ss_]['Time'] = int(time_)
                for t_ in tanks_:
                    df_[ss_][t_] = (cargo_to_discharge_, df_['IncMax'][t_][1] - (time_-time_incmax_)*cow_strip_['LoadingRateM3Min'][t_])
                
                if num_stages_ < self.num_stage_interval:
                        time_interval_ -= 60
                        self.time_interval[p__+1] = time_interval_
                        print('Reduce stage interval', cargo_to_discharge_, time_interval_)
                        df_ = df1_.copy()
                        
                        if time_interval_ == 0:
                            self.error['Interval Error'] = ["No. of stages requirement cannot be met!!"]
                            return
                
            if  df_[ss_]['Time'] == df_['MaxDischarging'+str(stage_-1)]['Time']:
                df_[ss_]['Time'] = int(df_[ss_]['Time'] +1)    
            
            
            last_discharging_max_rate_stage_ = ss_
            stages_['dischargingAtMaxRate'] = (df_['IncMax']['Time'], df_[ss_]['Time'])
            
            # last max stage before stripping
            # if p__+1 < len(self.info['loading_order'])+1:
            # ballast_.append((int(df_[ss_]['Time']),ss_)) # need to monitor ballast
            # ballast_stop_.append((int(df_[ss_]['Time']),ss_))
            
            ballast1_, time1_ = [ss_], [int(df_[ss_]['Time'])]
            
            for c_ in range(2,num_stripping_+1):
                # print(c_)
                ss_ = 'Stripping' + str(c_-1)
                df_[ss_] = cow_strip_['C'+str(c_)]
                df_[ss_]['Time'] = df_[last_discharging_max_rate_stage_]['Time'] + cow_strip_['C'+str(c_)]['Time']
                ballast1_.append(ss_)
                time1_.append(df_[ss_]['Time'])
                   
            stages_['stripping'] = (df_[last_discharging_max_rate_stage_]['Time'], df_[ss_]['Time'])
            
            next_time_ = ballast_[-1][0] + time_interval_
            while True:
                nearest_time_ = min(time1_, key=lambda x_:abs(x_-next_time_))
                a_ = time1_.index(nearest_time_)
                b_ = ballast1_[a_]
                ballast_.append((nearest_time_,b_))
                
                next_time_ += time_interval_
                if next_time_ > time1_[-1]:
                    break
  
                
            ## add MaxLoading1 if necessary 
            if single_max_stage_ and  (df_['MaxDischarging1']['Time'],'MaxDischarging1') not in ballast_:
                ballast_.insert(1, (df_['MaxDischarging1']['Time'],'MaxDischarging1'))
                
            ballast_limit_ = {}
            for aa_, (bb_,cc_) in enumerate(ballast_):
                if cc_[:3] in ['Max', 'Str']:
                    
                    add_time_ = 0 if cc_ not in ['MaxDischarging1'] else 32
                    time_ = bb_ - ballast_[aa_-1][0] - add_time_
                    ballast_limit_[cc_] = time_
                    
            if p__+2 == len(self.info['cargo_plans']):
                print('last cargo')
                last_time_ = df_[df_.columns[-1]]['Time']
                df_['Depart'] = None
                df_['Depart']['Time'] = last_time_ + 180
                
                for k_, v_ in self.info['cargo_plans'][-1].items():
                    df_['Depart'][k_] = (v_[0]['cargo'], v_[0]['quantityM3'])
                    
                ballast_.append((df_['Depart']['Time'], 'Depart'))
                ss_ = 'Depart'
                ballast_limit_['Depart'] = 180
            
            self.seq[cargo_to_discharge_+str(p__)]['gantt'] = df_        
            self.seq[cargo_to_discharge_+str(p__)]['ballast'] = list(ballast_) # need to get ballast for these stages
            self.seq[cargo_to_discharge_+str(p__)]['stripingStart'] = int(stripping_start_) # time when topping starts
            self.seq[cargo_to_discharge_+str(p__)]['beforeStripping'] = before_stripping_ # 2nd last stage before topping
            self.seq[cargo_to_discharge_+str(p__)]['justBeforeStripping'] = just_before_stripping_ # last stage before topping
            self.seq[cargo_to_discharge_+str(p__)]['stageInterval'] = stages_ # time duration for each stage
            self.seq[cargo_to_discharge_+str(p__)]['startTime'] = start_time_ # start time without delay
            # self.seq[cargo_to_discharge_+str(p__)]['ballastStop'] = list(ballast_stop_) # need to get ballast for these stages
            self.seq[cargo_to_discharge_+str(p__)]['lastStage'] = ss_
            # if self.commingle_loading1:
            #     self.seq[cargo_to_load_]['loadingRateM3Min'] = (staggering_rate_['LoadingRateM3Min1'],staggering_rate_['LoadingRateM3Min2'])
            # else:
            self.seq[cargo_to_discharge_+str(p__)]['dischargingRateM3Min'] = cow_strip_['LoadingRateM3Min'] 
            self.seq[cargo_to_discharge_+str(p__)]['tanks'] = tanks_
            
            self.seq[cargo_to_discharge_+str(p__)]['timeNeeded'] = df_[ss_]['Time']
            self.seq[cargo_to_discharge_+str(p__)]['singleMaxStage'] = single_max_stage_
            # self.seq[cargo_to_discharge_]['commingleStart'] = commingle_start_
            self.seq[cargo_to_discharge_+str(p__)]['ballastLimit'] = ballast_limit_
            self.seq[cargo_to_discharge_+str(p__)]['driveTank'] = drive_tank_
            self.seq[cargo_to_discharge_+str(p__)]['stripTanks'] = strip_
            self.seq[cargo_to_discharge_+str(p__)]['partialTanks'] = partial_
            self.seq[cargo_to_discharge_+str(p__)]['reduceRate1'] = REDUCED_RATE
            
            self.seq[cargo_to_discharge_+str(p__)]['directCargoPump'] = direct_cargo_pump_
            self.seq[cargo_to_discharge_+str(p__)]['cargoPump'] = cargo_pump_
            self.seq[cargo_to_discharge_+str(p__)]['indirectPump'] = list(add_pump_)
            
            
            # get end of COP
            self._end_COP(cargo_to_discharge_+str(p__))
            print(self.seq[cargo_to_discharge_+str(p__)]['COPendTime1'])
          
            start_time_ += df_[ss_]['Time']
            
            print(df_.columns.to_list()[3:]) # 'MaxLoading1', 'MaxLoading2', ...
            print(start_time_-df_[ss_]['Time'], start_time_)
            
            
    
            
    
    
    def _end_COP(self, cargo):
        
        self.seq[cargo]['COPendTime'] = {}
        self.seq[cargo]['COPendTime1'] = {'COP1':0, 'COP2':0, 'COP3':0}
        type_ = []
        
        time_ = self.seq[cargo]['gantt'].loc['Time'].to_list()
        end_time_   = {cp_: [] for cp_ in self.seq[cargo]['cargoPump']}
        # indir_time_ = {cp_: self.seq[cargo]['timeNeeded'] for cp_ in self.seq[cargo]['indirectPump']}
        
        for t_ in self.seq[cargo]['tanks']:
            
            vol_ = [l_[1] for l_ in self.seq[cargo]['gantt'].loc[t_].to_list()]
            min_vol_ = self.vessel.info['ullage2mVol'][t_]  # to shut indirect pump
            pump_ = self.vessel.info['tankCargoPump'][t_]
            
            i1_ = np.where(np.diff(vol_) == 0)[0]
            if len(i1_) == 0:
                i1_ = len(vol_)-1
            else:
                i1_ = i1_[0]
            end_time__ = time_[i1_]
            
            if min_vol_ < vol_[i1_]:
                ## partial with above 2m
                # print('partial with above 2m')
                if pump_ in end_time_:
                    end_time_[pump_].append(end_time__)
#                    print(t_, pump_, end_time_[pump_][-1])
                    
                indir_pump_ = set(self.seq[cargo]['cargoPump']) - set([pump_])
                for pp_ in indir_pump_:
                    if pp_ in end_time_:
                        end_time_[pp_].append(end_time__)
                        
#                        print(t_, pp_, end_time_[pp_][-1])
                
            else:
                # print('below 2m')
                ifunc_ = interp1d(vol_, time_)
                time1_ = int(ifunc_(self.vessel.info['ullage2mVol'][t_]).round())
                
                if pump_ in end_time_:
                    t1_ = list(np.argwhere(np.array(vol_) ==  0.))
                    if len(t1_) > 0:
                        t2_ = time_[int(t1_[0])-1]
                        end_time_[pump_].append(t2_)
                    else:
                        end_time_[pump_].append(self.seq[cargo]['timeNeeded'])
                        
#                    print(t_, pump_, end_time_[pump_][-1])
                
                indir_pump_ = set(self.seq[cargo]['cargoPump']) - set([pump_])
                for pp_ in indir_pump_:
                    if pp_ in end_time_:
                        end_time_[pp_].append(time1_)
#                        print(t_, pp_, end_time_[pp_][-1])
                    
#            print('---------------------------------------------')
                        
                    
                
               
                
        for k_, v_ in   end_time_.items():
            self.seq[cargo]['COPendTime1'][k_] = int(max(v_))
            
            
   
    def _cal_cow_strip(self, port, cargo_to_discharge, initial, tanks, max_rate):
        
        STRIP_ORDER = ['1', '1C', '2', '2C', '3', '3C', '4', '4C', '5', '5C', 'SLP', 'SLS']
        STRIP_LEVEL = {'1C':334.25, '2C':312.03, '3C':312, '4C':311.98, '5C':343.98,
                       '1P':152.44, '1S':152.44, '2P':161.3, '2S':161.3, '3P':161.34, '3S':161.34,
                       '4P':161.3, '4S':161.3, '5P':110.04, '5S':110.04, 'SLP':3.1, 'SLS':3.1}
        
        ##
        ####self.info['cow_tanks'] = {1: [], 2: ['1P', '3P', '3S', '1S'], 3: [], 4: [], 5:[], 6:[], 7:[], 8:[]}
        ### self.info['cow_tanks'] = {1: [], 2: [], 3: [], 4: [], 5:[], 6:[], 7:[], 8:[]}
        # change on line 403

        self.info['sorted_cow'] = {1: [], 2: [], 3: [], 4: [], 5:[], 6:[], 7:[], 8:[]}
        
        
        df_ = pd.DataFrame(index=INDEX)
        strip_ = self.info['stripping_tanks'][port+1]
        strip_num_ = []
        for t_ in strip_:
            if t_[-1] in ['C'] or t_ in ['SLS', 'SLP']:
                strip_num_.append(t_)
            elif t_[:-1] not in strip_num_:
                strip_num_.append(t_[:-1])
                
        partial_ = set(tanks) - set(strip_)
        
        
        drive_tank_ = {}
        if self.info['cow_tanks'][port+1] or strip_:
            print('Drive tank needed!!')
            tank_in_ = self.info['cargo_tank'][cargo_to_discharge]
            
            
            if 'SLS' in tank_in_:
                drive_tank_['tank'] = 'SLS'
                drive_tank_['ullage16mVol'] = self.vessel.info['ullage16mVol']['SLS']
                
            elif 'SLP' in tank_in_:
                drive_tank_['tank'] = 'SLP'
                drive_tank_['ullage16mVol'] = self.vessel.info['ullage16mVol']['SLP']
                
            else:
                print('Not supported yet!!')
                raise Exception("Not supported cow_tank")
            
            drive_tank_['departVol'] = self.info['cargo_plans'][port+1][drive_tank_['tank']][0]['quantityM3']
            
        ##
                
        
        
        if len(strip_) == 0 and len(partial_) > 0:
            print('partial discharge with no stripping and COW')
            # partial discharge with no stripping and COW
            # reduce 2 stages only
            df_['C1'] = None
            df_['C2'] = None
            df_['C3'] = initial
            df_['C3']['Time'] = 30
            df_['TotalVol'] = None
            
            
            # C3: 
            for k_, v_ in self.info['cargo_plans'][port+1].items(): #self.info['plans'][p__+1].items():
                # set time 0
                tank_ = k_
                df_['C3'][tank_] = (v_[0]['cargo'], v_[0]['quantityM3'])
                df_['TotalVol'][tank_] = v_[0]['quantityM3']
            
            df_['C2'] = df_['C3']
            df_['C2']['Time'] = 15
            
            # C2 : 
            discharging_rate_per_tank_ = REDUCED_RATE/len(tanks)  #(REDUCED_RATE + max_rate)/2/len(tanks)
            for t_ in tanks:
                    
                # if t_ == self.info['commingle'].get('tankName', None) and self.commingle_loading1:
                #     continue # not counting commingle tank
                
                cargo_loaded_per_tank_ = df_['C3'][t_][1] + discharging_rate_per_tank_*15/60
                
                df_['C2'][t_] = (cargo_to_discharge, cargo_loaded_per_tank_)
                
            df_['C1'] = df_['C2']
            df_['C1']['Time'] = 0
            
            # C2 : 
            discharging_rate_per_tank_ = (REDUCED_RATE + max_rate)/2/len(tanks)
            for t_ in tanks:
                    
                # if t_ == self.info['commingle'].get('tankName', None) and self.commingle_loading1:
                #     continue # not counting commingle tank
                
                cargo_loaded_per_tank_ = df_['C2'][t_][1] + discharging_rate_per_tank_*15/60
                
                df_['C1'][t_] = (cargo_to_discharge, cargo_loaded_per_tank_)
                
        elif len(strip_) > 0 and len(partial_) > 0:
            # reduce 2 stages for partial 
            # strip - 1 additional stage
            if 'SLP' in [drive_tank_.get('tank', None)] and 'SLP' in strip_:
                exit()
            
                
                
                
            total_stage_ = 2 + len(strip_num_) + 1
            if 'SLS' in [drive_tank_.get('tank', None)] and 'SLS' in strip_:
                total_stage_ -= 1


            for ss_ in range(1, total_stage_+1):
                df_['C'+str(ss_)] = None
            
            df_['C1']['Time'] = 0
            df_['C2']['Time'] = 15
            df_['C3']['Time'] = 30
            
            # C3: 
            for k_, v_ in self.info['cargo_plans'][port+1].items(): #self.info['plans'][p__+1].items():
                # set time 0
                tank_ = k_
                df_['C3'][tank_] = (v_[0]['cargo'], v_[0]['quantityM3'])
                
            for ss_ in range(1, total_stage_+1):
                if ss_ not in [3]:
                    df_['C'+str(ss_)].iloc[1:] = df_['C3'].iloc[1:] 
                
            reduction_rate_ = (max_rate - REDUCED_RATE)/(total_stage_-2)
            discharging_rate_ = [REDUCED_RATE+(total_stage_-2 - r_ -1)*reduction_rate_  for r_ in range(0, (total_stage_-2))]   
            ss_ = 3  # starting stage
            sort_strip_num_ = [t_ for t_ in STRIP_ORDER if t_ in strip_num_]
            # self.info['sorted_cow'][port] = sort_strip_num_
            
            for t_ in sort_strip_num_:
            
                if t_ in [drive_tank_.get('tank', None)]:
                    print('Drive tank:', t_)
                    vol_ = drive_tank_['ullage16mVol'] if  drive_tank_['departVol'] == 0. else drive_tank_['departVol']
                    df_.loc[t_] = [(cargo_to_discharge, vol_)]*len(df_.loc[t_])
                
                elif len(t_) == 1:
                      # wing tanks
                    t1_, t2_ = t_+'P', t_+'S'
                    
                    df_['C'+str(ss_)][t1_] = (cargo_to_discharge, STRIP_LEVEL[t1_])
                    df_['C'+str(ss_)][t2_] = (cargo_to_discharge, STRIP_LEVEL[t2_])
                    add_time_ = 60 if t1_ in self.info['cow_tanks'][port+1] else 20

                    ss_ += 1
                    df_['C'+str(ss_)]['Time'] = df_['C'+str(ss_-1)]['Time'] + add_time_
                    
                else:
                    df_['C'+str(ss_)][t_] = (cargo_to_discharge, STRIP_LEVEL[t_])
                    add_time_ = 60 if t_ in self.info['cow_tanks'][port+1] else 20
                
                    ss_ += 1
                    df_['C'+str(ss_)]['Time'] = df_['C'+str(ss_-1)]['Time'] + add_time_
                    
                
                
            # go backward 
                    # for s1_ in range(1,ss_):
                    #     # print(ss_-s1_) # 
                    #     s2_ = ss_ - s1_ # need to update C+s2_
                    #     rate_ = discharging_rate_[s2_-1]
                    #     tank__ = [t4_ for t4_ in tanks if df_['C'+str(ss_)][t4_][1] > 0]
                        
                    #     print(s2_, rate_)
                    
            
            # discharging_rate_per_tank_ = {}
            tank_strip_ = 0
            tank__ = []
            s2_ = 3
            s4_ = 0
            for s1_, s2_ in enumerate(range(total_stage_-1, 3, -1)):
                strip_tank_ = sort_strip_num_[len(sort_strip_num_) - s1_ - 1] if len(sort_strip_num_) - s1_ - 1 >= 0 else ""
                # print(s2_, strip_tank_)
                
                if strip_tank_ in [drive_tank_.get('tank', None)]:
                    s4_ = 1
                    continue

                if len(strip_tank_) == 1:
                    tank__ += [strip_tank_+'P', strip_tank_+'S']
                    tank_strip_ += 2
                    
                elif len(strip_tank_) >= 2:
                    tank__ += [strip_tank_]
                    tank_strip_ += 1
                    
                rate_ = discharging_rate_[s2_-2+s4_]
                discharging_rate_per_tank_ = rate_/tank_strip_
                # print(s2_, tank_strip_, rate_, discharging_rate_per_tank_)
                
                add_time_ = df_['C'+str(s2_+s4_)]['Time'] - df_['C'+str(s2_-1+s4_)]['Time']
                for t4_ in tank__:
                    df_['C'+str(s2_-1+s4_)][t4_] = (df_['C'+str(s2_+s4_)][t4_][0], 
                                                df_['C'+str(s2_+s4_)][t4_][1]+discharging_rate_per_tank_*add_time_/60)
                
                    
            ss_ = s2_ - 1 + s4_
            for s1_, s2_ in enumerate(range(ss_, 1, -1)):
                rate_ = discharging_rate_[s2_-2]
                # print(s2_, rate_)
                tanks_ = [t4_ for t4_ in tanks if df_['C'+str(s2_)][t4_][1] > 0. and t4_ not in [drive_tank_.get('tank', None)]] 
                discharging_rate_per_tank_ = rate_/len(tanks_)
                
                add_time_ = df_['C'+str(s2_)]['Time'] - df_['C'+str(s2_-1)]['Time']
                for t4_ in tanks_:
                    df_['C'+str(s2_-1)][t4_] = (df_['C'+str(s2_)][t4_][0], 
                                                df_['C'+str(s2_)][t4_][1]+discharging_rate_per_tank_*add_time_/60)
                 
                
                
            # print(df_)
            
        elif len(strip_) > 0 and len(partial_) == 0:
            
            add_stage_ = False
            total_stage_ = len(strip_num_) + 1
            
            # subtract drive tank
            if drive_tank_.get('tank', None) in strip_num_:
                total_stage_ -= 1
                
            if total_stage_ == 2:
                total_stage_ = 3
                add_stage_ = True
                
            for ss_ in range(1, total_stage_+1):
                df_['C'+str(ss_)] = None
            
            df_['C1']['Time'] = 0
            if add_stage_:
                df_['C2']['Time'] = 15
            # df_['C3']['Time'] = 30
        
            for k_, v_ in self.info['cargo_plans'][port+1].items(): #self.info['plans'][p__+1].items():
                # set time 0
                tank_ = k_
                df_['C1'][tank_] = (v_[0]['cargo'], v_[0]['quantityM3'])
                
            for ss_ in range(1, total_stage_+1): # repeat for other column
                if ss_ not in [1]: 
                    df_['C'+str(ss_)].iloc[1:] = df_['C1'].iloc[1:] 
                    
            
            # get ending stage before COW/STRIPPING
            reduction_rate_ = (max_rate - REDUCED_RATE)/(total_stage_-2)
            discharging_rate_ = [REDUCED_RATE+(total_stage_-2 - r_ -1)*reduction_rate_  for r_ in range(0, (total_stage_-2))]   
            ss_ = 1 if  not add_stage_ else 2 # starting stage
            sort_strip_num_ = [t_ for t_ in STRIP_ORDER if t_ in strip_num_]
            # self.info['sorted_cow'][port] = sort_strip_num_
            for t_ in sort_strip_num_:
                
                if t_ in [drive_tank_.get('tank', None)]:
                    # print('Drive tank:', t_)
                    pass
                elif len(t_) == 1:
                    # wing tanks
                    t1_, t2_ = t_+'P', t_+'S'
                    
                    df_['C'+str(ss_)][t1_] = (cargo_to_discharge, STRIP_LEVEL[t1_])
                    df_['C'+str(ss_)][t2_] = (cargo_to_discharge, STRIP_LEVEL[t2_])
                    
                    add_time_ = 60 if t1_ in self.info['cow_tanks'][port+1] else 20
                else:
                    df_['C'+str(ss_)][t_] = (cargo_to_discharge, STRIP_LEVEL[t_])
                    add_time_ = 60 if t_ in self.info['cow_tanks'][port+1] else 20
                    
                if t_ in [drive_tank_.get('tank', None)]:
                    print('Drive tank:', t_)
                    vol_ = drive_tank_['ullage16mVol'] if  drive_tank_['departVol'] == 0. else drive_tank_['departVol']
                    df_.loc[t_] = [(cargo_to_discharge, vol_)]*len(df_.loc[t_])
                else:
                    ss_ += 1
                    df_['C'+str(ss_)]['Time'] = df_['C'+str(ss_-1)]['Time'] + add_time_
                
            
            # discharging_rate_per_tank_ = {}
            tank_strip_ = 0
            tank__ = []
            s2_ = 3
            s4_ = 0
            for s1_, s2_ in enumerate(range(total_stage_-1, 3, -1)):
                strip_tank_ = sort_strip_num_[len(sort_strip_num_) - s1_ - 1] if len(sort_strip_num_) - s1_ - 1 >= 0 else ""
                # print(s2_, strip_tank_)
                if strip_tank_ in [drive_tank_.get('tank', None)]:
                    # print('Drive tank:', t_)
                    s4_ = 1
                elif strip_tank_ in ['SLS', 'SLP']:
                    # finish discharging before reducing rate
                    pass
                elif len(strip_tank_) == 1:
                    tank__ += [strip_tank_+'P', strip_tank_+'S']
                    tank_strip_ += 2
                    
                elif len(strip_tank_) >= 2:
                    tank__ += [strip_tank_]
                    tank_strip_ += 1
                    
                if strip_tank_ in [drive_tank_.get('tank', None)]:
                    # print('Drive tank:', t_)
                    pass
                
                elif strip_tank_ in ['SLS', 'SLP']:
                    t4_ = strip_tank_
                    # no discharging for strip tank
                    parcel_ = df_['C'+str(s2_+s4_)][t4_][0]
                    vol_ = df_['C'+str(s2_+s4_)][t4_][1]
                    for s_ in range(s2_-1+s4_,0,-1):
                        df_['C'+str(s_)][t4_] = (parcel_,vol_)
                else:
                    
                    rate_ = discharging_rate_[s2_-2+s4_]
                    discharging_rate_per_tank_ = rate_/tank_strip_
                    # print(s2_, tank_strip_, rate_, discharging_rate_per_tank_)
                    
                    add_time_ = df_['C'+str(s2_+s4_)]['Time'] - df_['C'+str(s2_-1+s4_)]['Time']
                    for t4_ in tank__:
                        df_['C'+str(s2_-1+s4_)][t4_] = (df_['C'+str(s2_+s4_)][t4_][0], 
                                                    df_['C'+str(s2_+s4_)][t4_][1]+discharging_rate_per_tank_*add_time_/60)
                    
                    
            ss_ = s2_ - 1 + s4_
            for s1_, s2_ in enumerate(range(ss_, 1, -1)):
                rate_ = discharging_rate_[s2_-2]
                tanks_ = [t4_ for t4_ in tanks if df_['C'+str(s2_)][t4_][1] > 0. and t4_ not in  [drive_tank_.get('tank', None), 'SLS', 'SLP']]
                discharging_rate_per_tank_ = rate_/len(tanks_)
                add_time_ = df_['C'+str(s2_)]['Time'] - df_['C'+str(s2_-1)]['Time']
                
                for t4_ in tanks_:
                    df_['C'+str(s2_-1)][t4_] = (df_['C'+str(s2_)][t4_][0], 
                                                df_['C'+str(s2_)][t4_][1]+discharging_rate_per_tank_*add_time_/60)
                 
                  
        
        df_['TotalVol'] = None
        for k_, v_ in self.info['cargo_plans'][port+1].items(): #self.info['plans'][p__+1].items():
            df_['TotalVol'][k_] = v_[0]['quantityM3']
        
        
       
        return df_, drive_tank_, strip_, partial_
        

             
        
    def _get_ballast_requirements(self):
        
        # INDEX = self.config["gantt_chart_index"]
        INDEX1 = self.config["gantt_chart_ballast_index"]
        
        self.max_ballast_rate = 7000
        
        density_ = self.info['density']
        num_port_ = 0
        fixed_ballast_ = []
        same_ballast_ = []
        stages_ = []
        
        for c__,c_ in enumerate(self.info['discharging_order']):
            
            cargo_to_discharge_ = self.info['dsCargoNominationId'][c_]
            c1_ = cargo_to_discharge_+str(c__)
            
            print(c__, 'collecting ballast requirements ....')
            df_ = self.seq[c1_]['gantt']
            df_ = df_.append(pd.DataFrame(index=INDEX1))
            
             # initial
            if c__ == 0: # first cargo to load
                print('1st stage to be fixed; collecting ballast ...')
                fixed_ballast_ = ['Initial1']
                for k_, v_ in self.info['ballast'][0].items():
                    df_['Initial'][k_] = v_[0]['quantityMT']
                
            # stripping last cargo topping
            if c__ ==  len(self.info['discharging_order']) - 1:
                print('last discharging cargo')
                # # fixed at departure ballast            
                # if self.seq[c1_]['justBeforeTopping']+str(c__+1) not in fixed_ballast_:
                #     fixed_ballast_.append(self.seq[c1_]['justBeforeTopping']+str(c__+1))
                    
                for k_, v_ in self.info['ballast'][-1].items():
                    df_[self.seq[c1_]['lastStage']][k_] = v_[0]['quantityMT']
                
                
            # get loading info        
            ddf_ = pd.DataFrame(index=INDEX)
            
            if c__ == 0:
                col_ = 'Initial' + str(c__+1)
                ddf_[col_] = df_['Initial']
            
            ddf_ = ddf_.append(pd.DataFrame(index=['Weight']))
            
            for b__,b_ in enumerate(self.seq[c1_]['ballast']):
                if b__ > 0:
                    num_port_ += 1
                    stages_.append(b_[1]+str(c__+1))
                    wt_ = 0
                    col_ = b_[1] + str(c__+1)
                    ddf_[col_] = None
                    ddf_[col_]['Time'] = b_[0] + self.seq[c1_]['startTime']
                    pre_col_ = self.seq[c1_]['ballast'][b__-1][1]
                    
                    # if b_  in self.seq[c1_]['ballastStop']:
                    #     same_ballast_.append(num_port_)
                      
                    for h_, (i_,j_) in enumerate(self.seq[c1_]['gantt'][b_[1]].iteritems()): 
                        # print(i_, j_)
                        if i_ not in ['Time'] and j_ not in [None]:
                            # print(i_,j_) # j_ = curr (cargo, vol)
                            
                            pre_ = self.seq[c1_]['gantt'][pre_col_][i_]
                            
                            check_ = False
                            if pre_ not in [None]:
                                if pre_[0] == cargo_to_discharge_:
                                    check_ = True
                                elif len(pre_) == 4 and pre_[2] == cargo_to_discharge_:
                                    check_ = True
                                
                            
                            #print(pre_, j_)
                            if  pre_ not in [None] and check_:
                                
                                if pre_[0] == cargo_to_discharge_:
                                    amt_ = j_[1] - pre_[1]
                                    ddf_[col_][i_] = (cargo_to_discharge_, amt_)
                                    wt_ += round(amt_*density_[cargo_to_discharge_],10)
                                elif len(pre_) == 4 and pre_[2] == cargo_to_discharge_:
                                    amt_ = j_[3] - pre_[3]
                                    ddf_[col_][i_] = (cargo_to_discharge_, amt_)
                                    wt_ += round(amt_*density_[cargo_to_discharge_],10)
                                
                            elif j_[0] == cargo_to_discharge_:
                                ddf_[col_][i_] = (cargo_to_discharge_, j_[1])
                                wt_ += round(j_[1]*density_[cargo_to_discharge_],10)
                                
                            elif len(j_) > 2 and j_[2] == cargo_to_discharge_:
                                ddf_[col_][i_] = (cargo_to_discharge_, j_[3])
                                wt_ += round(j_[3]*density_[cargo_to_discharge_],10)
                                
                    ddf_[col_]['Weight'] = wt_ # cargo added in this stage           
                    
                    
                          
            self.seq[c1_]['loadingInfo'] = ddf_  # cargo in m3
            self.seq[c1_]['fixBallast'] = fixed_ballast_
            
            print('fixed ballast: ', fixed_ballast_)
            
            # print(df_.columns)
            
            
            # self.seq[c_]['gantt'] = df_
        
        print('same ballast: ', same_ballast_)
        print('stage: ', stages_)
        
        ballast_limit_ = {}
        for s__,s_ in enumerate(stages_):
            c_ = int(s_[-1]) - 1 # less than 10 cargos loading at one port
            cargo_ = self.info['discharging_order'][c_] # less than 10 cargos loading at one port
            cargo_to_discharge_ = self.info['dsCargoNominationId'][cargo_]
            c1_ = cargo_to_discharge_+str(c_)
            if s_[:3] in ['Max', 'Str', 'Dep']:
                b_ = round(self.max_ballast_rate * self.seq[c1_]['ballastLimit'][s_[:-1]]/60 *1.025,2) # in MT
                ballast_limit_[s__+1] = b_
            
            
        
        self.seq['numPort'] = num_port_
        self.seq['stages'] = stages_
        self.seq['sameBallast'] = same_ballast_
        self.seq['ballastLimit'] = ballast_limit_
        
            
            
                    
        
        
    def _get_plan_ampl(self, cargo_info, final_plan):
        
        self.limits = {}
        
        self.seawater_density = 1.025 ## self.loading.seawater_density  ##           
        # self.ballast_percent = 0.4 # round(7000/self.loading.staggering_param['maxShoreRate'],3)-0.001  #0.4
        
        
        self.loadable = lambda: None
        setattr(self.loadable, 'info', {})
        self.loadable.info['parcel'] = {c_:{}  for c_ in cargo_info['pre_cargo']}
        self.loadable.info['lastVirtualPort'] = len(cargo_info['discharging_order'])
        for k_, v_ in cargo_info['density'].items():
            self.loadable.info['parcel'][k_]['mintempSG'] = v_
            self.loadable.info['parcel'][k_]['maxtempSG'] = v_
            
        for k_, v_ in cargo_info['api'].items():
            self.loadable.info['parcel'][k_]['api'] = v_
        
        for k_, v_ in cargo_info['temperature'].items():
            self.loadable.info['parcel'][k_]['temperature'] = v_
            
            
        self.loadable.info['operation'], self.loadable.info['toLoadPort1'] = {},{}
        self.loadable.info['toLoad'] = {}
        self.loadable.info['toLoadCargoTank'] = {}
        self.loadable.info['manualOperation'] = {} # cargo tank port amount
        self.loadable.info['preloadOperation0'] = {} # initial cargo tank port amount
        self.loadable.info['preloadOperation'] = {} # port 1 to ... cargo tank port amount
        
        self.loadable.info['ballastOperation'] = {t_:{}  for t_ in self.vessel.info['ballastTanks'] if t_ not in self.vessel.info['banBallast']} # tank port amount
        self.loadable.info['fixedBallastPort'] = []
        self.trim_upper, self.trim_lower  = {}, {}
        
        port_ = 0
        # density_ = cargo_info['density']
        
        # preloaded cargo
        #first_cargo_ = self.loading.info['loading_order'][0]
        wt_ = 0
        initial_plan_ = cargo_info['cargo_plans'][0]
        for k_, v_ in initial_plan_.items():
            # print(k_, v_)
            
            cargo_ = v_[0]['cargo']
            if cargo_ not in self.loadable.info['preloadOperation0']:
                self.loadable.info['preloadOperation0'][cargo_] = {}
            
            self.loadable.info['preloadOperation0'][cargo_][k_] = v_[0]['quantityMT']
            wt_ += v_[0]['quantityMT']
            
            if len(v_) > 1:
                cargo_ = v_[1]['cargo']
                if cargo_ not in self.loadable.info['preloadOperation0']:
                    self.loadable.info['preloadOperation0'][cargo_] = {}
                
                self.loadable.info['preloadOperation0'][cargo_][k_] = v_[1]['quantityMT']
                wt_ += v_[1]['quantityMT']
                
        # self.loadable.info['stages'], self.loadable.info['stageTimes'] = {}, {}
        self.loadable.info['toLoadPort'] = {0:round(wt_,1)} ###
        
        port_ = 1
        for c__, c_ in enumerate(cargo_info['discharging_order']):
            
            # last_cargo_ = True if c__+1 == len(self.loading.info['loading_order']) else False
            cargo_ = cargo_info['dsCargoNominationId'][c_]
            
            if cargo_ not in  self.loadable.info['operation'].keys():
                self.loadable.info['operation'][cargo_] = {}
                self.loadable.info['toLoad'][cargo_] = 0.0
                self.loadable.info['preloadOperation'][cargo_] = {t_:{}  for t_ in self.vessel.info['cargoTanks']}
                self.loadable.info['toLoadCargoTank'][cargo_] = {} #{t_:0.  for t_ in self.vessel.info['cargoTanks']}
            
            wt_ = 0.
            strip_ = False
            if c_ not in cargo_info['multiDischarge']:
                # single discharge stage for this cargo
                for k_, v_ in  final_plan.items():
                    if v_[0]['cargo'] == cargo_:
                        wt__ = round(v_[0]['quantityMT'] - initial_plan_[k_][0]['quantityMT'],1)
                        self.loadable.info['toLoadCargoTank'][cargo_][k_] = wt__
                        wt_ += wt__
                        
                        if v_[0]['quantityMT'] == 0.:
                            strip_ = True
                        
                        self.loadable.info['preloadOperation'][cargo_][k_][port_] = wt__
                        self.loadable.info['toLoad'][cargo_] += wt__
                        
                        
                    elif len(v_) == 2 and v_[1]['cargo'] == cargo_:
                        exit()
                        ##
                        self.loadable.info['toLoadCargoTank'][cargo_][k_] = v_[1]['quantityMT']
            else:
                wt_ = cargo_info['discharging_qty'][c__]
                self.loadable.info['toLoad'][cargo_] += wt_
                strip_ = True
                
                
            if not strip_:
                self.trim_lower[str(port_)] = 3.0
                self.trim_upper[str(port_)] = 4.0
            else:
                self.trim_lower[str(port_)] = 4.0
                self.trim_upper[str(port_)] = 5.0
                
            
                    
            # toLoadTank_ = {t_:0.  for t_ in self.vessel.info['cargoTanks']}
            
            self.loadable.info['operation'][cargo_][port_] = round(wt_,1) 
            
            self.loadable.info['toLoadPort'][port_] = round(wt_ + self.loadable.info['toLoadPort'][port_-1],1)  ## accumulated at each port
            self.loadable.info['toLoadPort1'][port_] = wt_       ## at each port
            
            port_ += 1
            
        # initial ballast
        for k_, v_ in cargo_info['ballast'][0].items():
            if v_[0]['quantityMT'] > 0:
                if k_ not in self.loadable.info['ballastOperation']:
                    self.loadable.info['ballastOperation'][k_] = {'0':v_[0]['quantityMT']}
                else:
                    self.loadable.info['ballastOperation'][k_]['0'] = v_[0]['quantityMT']
            
        self.vessel.info['initBallast'] = {}
        self.vessel.info['initBallast']['wt'] = {k_: v_.get('0', 0.) for k_, v_ in self.loadable.info['ballastOperation'].items()}
        
        # final 
        for k_, v_ in cargo_info['ballast'][1].items():
            if v_[0]['quantityMT'] > 0:
                if k_ not in self.loadable.info['ballastOperation']:
                    self.loadable.info['ballastOperation'][k_] = {str(port_-1):v_[0]['quantityMT']}
                else:
                    self.loadable.info['ballastOperation'][k_][str(port_-1)] = v_[0]['quantityMT']
            
        self.loadable.info['fixedBallastPort'] = ['0', str(port_-1)]
        
        self.loadable.info['incInitBallast'] = []
        self.loadable.info['decInitBallast'] = []
        
        
        for t_ in self.vessel.info['ballastTanks']:
            # print(t_)
            if t_ not in self.vessel.info['banBallast']:
                # print(t_)
                in_ = cargo_info['ballast'][0].get(t_, [{}])[0].get('quantityMT', 0.)
                out_ = cargo_info['ballast'][-1].get(t_, [{}])[0].get('quantityMT', 0.)
                
                if float(out_) >= float(in_):
                    self.loadable.info['incInitBallast'].append(t_)
                else:
                    self.loadable.info['decInitBallast'].append(t_)
       
        self.loadable.info['fixCargoPort'] = [str(port_-1)]
        self.loadable.info['fixCargoPortAmt'] = {}
        for k_, v_ in final_plan.items():
            if v_[0]['cargo'] not in self.loadable.info['fixCargoPortAmt']:
                self.loadable.info['fixCargoPortAmt'][v_[0]['cargo']] = {}
                self.loadable.info['fixCargoPortAmt'][v_[0]['cargo']][k_] = {str(port_-1): v_[0]['quantityMT']}
                
            else:
                self.loadable.info['fixCargoPortAmt'][v_[0]['cargo']][k_] = {str(port_-1): v_[0]['quantityMT']}
                
        
        ## get param discharge_init
            
        self.ballast_percent = self.config['ballast_percent'] #0.4 
        lightweight_ = self.vessel.info['lightweight']['weight']
        max_deadweight_ = 1000*1000
        cont_weight_ = self.vessel.info['deadweightConst']['weight'] #+ self.vessel.info['onboard']['totalWeight']
        
        loadline_ = 100.0
        min_draft_limit_  = 10.425
        
        self.displacement_lower, self.displacement_upper = {}, {}
        self.base_draft = {}
        self.sf_base_value, self.sf_draft_corr, self.sf_trim_corr = {}, {}, {}
        self.bm_base_value, self.bm_draft_corr, self.bm_trim_corr = {}, {}, {}
        self.sf_bm_frac = 0.95 ##  _bm_frac, self.feedback_sf_bm_frac)
        # self.trim_lower, self.trim_upper = {}, {}
        
        # self.trim_lower[str(self.loadable.info['lastVirtualPort'])] = 2.0
        # self.trim_upper[str(self.loadable.info['lastVirtualPort'])] = 3.0
        
        self.full_discharge = True
        
        # self._set_trim(trim_upper, trim_lower)
        ballast_weight_ = 91800
        ballast_ = cargo_info['initBallastWeight']
        # weight_ = cargo_info['initCargoWeight']
        misc_weight_ = cargo_info['depROBweight']
        for p_ in range(1, self.loadable.info['lastVirtualPort']+1):  # exact to virtual
            
            cargo_to_load_ = self.loadable.info['toLoadPort1'][p_]
            ballast_ = min(ballast_weight_, ballast_- self.ballast_percent*cargo_to_load_)
            
            # misc_weight_ = 0.0
            # for k1_, v1_ in self.vessel.info['onhand'].items():
            #     misc_weight_ += v1_.get(str(port_)+arr_dep_,{}).get('wt',0.)
#                
#            # get estimate cargo weight
            cargo_weight_  = self.loadable.info['toLoadPort'][p_]
#            print(str(port_)+arr_dep_, cargo_weight_)

            est_deadweight_ = min(cont_weight_ + misc_weight_ + cargo_weight_ + ballast_, max_deadweight_)
            est_displacement_ = lightweight_ + est_deadweight_
            seawater_density_ = self.seawater_density
            
             ## lower bound displacement
            lower_draft_limit_ = min_draft_limit_ #max(self.ports.draft_airdraft[p_], min_draft_limit_)
            lower_displacement_limit_ = np.interp(lower_draft_limit_, self.vessel.info['hydrostatic']['draft'], self.vessel.info['hydrostatic']['displacement'])
            # correct displacement to port seawater density
            lower_displacement_limit_  = lower_displacement_limit_*seawater_density_/1.025
            
            # disp1_ = lower_displacement_limit_*1.025/seawater_density_
            # d1_ = np.interp(disp1_, self.vessel.info['hydrostatic']['displacement'], self.vessel.info['hydrostatic']['draft'])
            # print(port__,d1_,seawater_density_,disp1_,lower_displacement_limit_)
            
            est_displacement_ = max(lower_displacement_limit_, est_displacement_)   
#            
           
            ## upper bound displacement
            # upper_draft_limit_ = #min(loadline_, float(self.port.info['portRotation'][port_code_]['maxDraft'])) - 0.001
            # check uplimit not exceeed for min load
            # est_displacement_wo_ballast_ =  self.loadable.info['toLoadMinPort'][p_]  + cont_weight_ + misc_weight_ + lightweight_
            # est_draft_wo_ballast_ =  np.interp(est_displacement_wo_ballast_, self.vessel.info['hydrostatic']['displacement'], self.vessel.info['hydrostatic']['draft'])
            
            # if est_draft_wo_ballast_ > upper_draft_limit_:
            #     message_ = 'Draft error at '+ port_code_ + '!!'
            #     #print('Draft error')
            #     if 'Draft Error' not in self.error.keys():
            #         self.error['Draft Error'] = [message_]
            #     elif message_ not in self.error['Draft Error']:
            #         self.error['Draft Error'].append(message_)
                
            # upper_displacement_limit_ = np.interp(upper_draft_limit_, self.vessel.info['hydrostatic']['draft'], self.vessel.info['hydrostatic']['displacement'])
            # # correct displacement to port seawater density
            # upper_displacement_limit_  = upper_displacement_limit_*seawater_density_/1.025
            
            upper_displacement_limit_ = 1e6
            est_displacement_ = min(est_displacement_, upper_displacement_limit_)
            
            self.displacement_lower[str(p_)] = lower_displacement_limit_
            self.displacement_upper[str(p_)] = upper_displacement_limit_
            
            est_draft_ = np.interp(est_displacement_, self.vessel.info['hydrostatic']['displacement'], self.vessel.info['hydrostatic']['draft'])
            
            # base draft for BM and SF
            trim_ = 0.5*(self.trim_lower.get(str(p_), 3.0) + self.trim_upper.get(str(p_), 5.0))
            base_draft__ = int(np.floor(est_draft_+trim_/2))
            base_draft_ = base_draft__ if p_  == 1 else min(base_draft__, self.base_draft[str(p_-1)])
            self.base_draft[str(p_)] = base_draft_
            
            
            frames_ = self.vessel.info['frames']
            
            df_sf_ = self.vessel.info['SSTable']
            df_bm_ = self.vessel.info['SBTable']
            
            base_value_, draft_corr_, trim_corr_ = [],[],[]
            base_value__, draft_corr__, trim_corr__ = [],[],[]
            for f__,f_ in enumerate(frames_):
                # SF
                df_ = df_sf_[df_sf_["frameNumber"].isin([float(f_)])]  
                df_ = df_[df_['baseDraft'].isin([base_draft_])]
                base_value_.append(float(df_['baseValue']))
                draft_corr_.append(float(df_['draftCorrection']))
                trim_corr_.append(float(df_['trimCorrection']))
                
                # BM
                df_ = df_bm_[df_bm_["frameNumber"].isin([float(f_)])]  
                df_ = df_[df_['baseDraft'].isin([base_draft_])]
                base_value__.append(float(df_['baseValue']))
                draft_corr__.append(float(df_['draftCorrection']))
                trim_corr__.append(float(df_['trimCorrection']))
                
            self.sf_base_value[str(p_)] = base_value_
            self.sf_draft_corr[str(p_)] = draft_corr_
            self.sf_trim_corr[str(p_)] = trim_corr_
                        
            self.bm_base_value[str(p_)] = base_value__
            self.bm_draft_corr[str(p_)] = draft_corr__
            self.bm_trim_corr[str(p_)] = trim_corr__
            
        print('base draft:', self.base_draft)
            
            
    def _write_ampl(self, file = 'input_discharging.dat', IIS = True):
        
        if not self.error and self.solver in ['AMPL']: #and self.mode not in ['FullManual']:
            
            
            with open(file, "w") as text_file:
                ##
                print('# set of all cargo tanks',file=text_file)
                cargo_tanks_ = []
                str1 = 'set T:= '
                for i_,j_ in self.vessel.info['cargoTanks'].items():
                    str1 += i_ + ' '
                    cargo_tanks_.append(i_)
                print(str1+';', file=text_file)
                
                ##
                print('# cargo tanks with non-pw tcg details',file=text_file)#  
                str1 = 'set T1 := '
                for i_, j_ in self.vessel.info['cargoTanks'].items():
                    if i_ not in self.vessel.info['tankTCG']['tcg_pw']:
                        str1 += i_ + ' '
                print(str1+';', file=text_file)
                
                ##
                print('# set of tanks compatible with cargo c',file=text_file)
                for i_,j_ in self.loadable.info['parcel'].items():
                    str1 = 'set Tc[' + str(i_) + '] := '
                    for j_ in cargo_tanks_:
                        if j_ not in self.vessel.info['banCargo'].get(i_,[]):
                            str1 += j_ + ' '
                    print(str1+';', file=text_file)
                    
                ## 
                print('# set of loaded tanks (preloaded condition)',file=text_file)
                t_loaded_ = []
                str1 = 'set T_loaded:= '
                for k_, v_ in self.loadable.info['preloadOperation0'].items():
                    for k1_, v1_ in v_.items():
                        if k1_ not in t_loaded_:
                            str1 += k1_ + ' '
                            t_loaded_.append(k1_)
                            
                print(str1+';', file=text_file)
                
                ##
                print('# set of all cargoes',file=text_file)
                str1 = 'set C:= '
                for i_, j_ in self.loadable.info['parcel'].items():
                    str1 += i_ + ' '
                print(str1+';', file=text_file)
                
                
                print('# set of all loaded cargoes (partial loading condition)',file=text_file)
                str1 = 'set C_loaded:= '
                for k_, v_ in self.loadable.info['preloadOperation'].items():
                    str1 += k_ + ' '
                print(str1+';', file=text_file)
                
                
                print('# set of all loaded cargoes (partial loading condition) with auto discharge',file=text_file)
                str1 = 'set C_loaded1:= '
                for k_ in self.info['multiDischarge']:
                    str1 += self.info['dsCargoNominationId'][k_] + ' '
                print(str1+';', file=text_file)
                
                print('# if cargo c has been loaded in tank t (partial loading condition)',file=text_file)
                str1 = 'param I_loaded := '
                print(str1, file=text_file)
                for k_, v_ in self.loadable.info['preloadOperation0'].items():  ###
                    str1 = '[' + k_ + ', *] := '
                    for k1_, v1_ in v_.items():
                        if v1_ not in [{}]:
                            str1 += k1_ + ' ' + '1 '
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                #            
                str1 = 'param W_loaded   := ' 
                print(str1, file=text_file) 
                for k_, v_ in self.loadable.info['preloadOperation'].items():
                    for k1_, v1_ in v_.items():
                        for k2_, v2_ in v1_.items():
                            if v2_ not in [{}]:
                                str1 = k_ + ' ' +  ' ' + str(k1_) + ' ' + str(k2_) + ' ' + "{:.1f}".format(v2_) 
                                print(str1, file=text_file)
                print(';', file=text_file)
    
                #
                print('# weight of cargo c remained in tank t at initial state (before ship entering the first port)',file=text_file)#  
                str1 = 'param W0  := ' 
                print(str1, file=text_file) 
                for k_, v_ in self.loadable.info['preloadOperation0'].items(): ###
                    str1 = '[' + k_ + ', *] := '
                    for k1_, v1_ in v_.items():
                        if v1_ not in [{}]:
                            str1 += k1_ + ' ' +  "{:.1f}".format(v1_) + ' ' 
                    print(str1, file=text_file)
                    
                print(';', file=text_file)
                
                
                ##
                str1 = 'param W1  := ' ##
                print(str1, file=text_file) 
                for k_, v_ in self.loadable.info['fixCargoPortAmt'].items():
                    for k1_, v1_ in v_.items():
                        for k2_, v2_ in v1_.items():
                            if v2_ not in [{}, 0]:
                                str1 = k_ + ' ' +  ' ' + str(k1_) + ' ' + str(k2_) + ' ' + "{:.1f}".format(v2_) 
                                print(str1, file=text_file)
                print(';', file=text_file)
    
                print('# fixCargoPort',file=text_file)#  ##
                str1 = 'set fixCargoPort := '  # to virtual ports
                for k_ in self.loadable.info['fixCargoPort']:
                    str1 += ' ' + str(k_)
                print(str1+';', file=text_file)
                
                
                
                ## 
                print('# total number of ports in the booking list',file=text_file)#   
                str1 = 'param NP := ' + str(self.loadable.info['lastVirtualPort']) # to virtual ports 
                print(str1+';', file=text_file)
                
                print('# the last loading port',file=text_file)#  
                str1 = 'param LP := ' + str(0) # to virtual ports
                print(str1+';', file=text_file)
                
                print('# P_stable0',file=text_file)#  
                str1 = 'set P_stable0 := '  # to virtual ports
                for k_ in range(1, self.loadable.info['lastVirtualPort']+1):
                    str1 += ' ' + str(k_)
                print(str1+';', file=text_file)
                
                
                #  NP1 = {} for cargo left in last discharge port so to avoid min draft
                # print('# NP1',file=text_file) 
                # if not self.full_discharge:
                #     str1 = 'set NP1 := '  # to virtual ports
                #     print(str1+';', file=text_file)
                
                print('# cargo density @ low temperature (in t/m3)',file=text_file)#  
                str1 = 'param densityCargo_High  := ' 
                for i_,j_ in self.loadable.info['parcel'].items():
                    str1 +=  str(i_) + ' ' + "{:.6f}".format(j_['mintempSG'])  + ' '
                print(str1+';', file=text_file)
     
                print('# cargo density @ high temperature (in t/m3)',file=text_file)#  
                str1 = 'param densityCargo_Low  := ' 
                density_ = []
                for i_,j_ in self.loadable.info['parcel'].items():
                    density_.append(j_['maxtempSG'])
                    str1 +=  str(i_) + ' ' + "{:.6f}".format(j_['maxtempSG'])  + ' '
                print(str1+';', file=text_file)
                
                str1 = 'param aveCargoDensity  := ' 
                str1 += "{:.4f}".format(np.mean(density_))  + ' '
                print(str1+';', file=text_file)
                
                print('# weight (in metric tone) of cargo to be moved at port p',file=text_file)#  
                first_ = {}
                str1 = 'param Wcp  := ' 
                print(str1, file=text_file) 
                for i_, j_ in self.loadable.info['operation'].items():
                    p_ = 100
                    str1 = '[' + str(i_) + ', *] := '
                    for k_,v_ in j_.items():
                        if int(k_) > 0:
                            str1 += str(k_) + ' ' + "{:.1f}".format(int(v_*10)/10) + ' '
                            p_ = min(p_, int(k_))
                    print(str1, file=text_file)
                    first_[i_] = p_
                print(';', file=text_file)
                
                
                ##
                print('# first port for discharging cargo c',file=text_file)
                for i_, j_ in first_.items():
                    str1 = 'set P_stable2[' + str(i_) + '] := '
                    for k_ in range(j_, self.loadable.info['lastVirtualPort']+1):
                        str1 += str(k_) + ' '
                    print(str1+';', file=text_file)
                    
                    
                print('# opt port for discharging cargo ',file=text_file)
                str1 = 'set P_opt := '
                for k_ in self.info['portOpt']:
                    str1 += str(k_) + ' '
                print(str1+';', file=text_file)
                
                # for deballasting amt
                print('# loading ports',file=text_file)#  
                str1 = 'set loadPort  := ' 
                # for i_, j_ in self.loadable['toLoadPort1'].items():
                #     str1 += str(i_) + ' '
                print(str1+';', file=text_file)
                # for deballasting amt 
                str1 = 'param loadingPortAmt  := ' 
                # for i_, j_ in self.loadable['toLoadPort1'].items():
                #     str1 += str(i_)  + ' ' +  "{:.1f}".format(int(j_*10)/10)  + ' '
                print(str1+';', file=text_file)
                
                # for ballasing amt
                print('# discharge ports',file=text_file)#  
                str1 = 'set dischargePort  := ' 
                for i_, j_ in self.loadable.info['toLoadPort1'].items():
                    str1 += str(i_) + ' '
                print(str1+';', file=text_file)
                
                # for ballasing amt
                str1 = 'param dischargePortAmt  := ' 
                for i_, j_ in self.loadable.info['toLoadPort1'].items():
                    str1 += str(i_)  + ' ' +  "{:.1f}".format(-j_)  + ' '
                print(str1+';', file=text_file)
                
                print('# intended cargo to load',file=text_file)#  
                str1 = 'param toLoad  := ' 
                # for i_, j_ in self.loadable['toLoad'].items():
                #     str1 += i_ + ' ' +  "{:.1f}".format(j_)  + ' '
                print(str1+';', file=text_file)
                
                print('# intended cargo to load',file=text_file)#  
                str1 = 'set cargoPriority := ' 
                print(str1+';', file=text_file)
                
                print('# min cargo to must be loaded',file=text_file)#  
                str1 = 'param minCargoLoad  := ' 
                # for i_, j_ in self.loadable.info['toLoadMin'].items():
                #     str1 += i_ + ' ' +  "{:.3f}".format(int(j_*10)/10)  + ' '
                print(str1+';', file=text_file)        
                
                                # if self.loadable.info['numParcel'] == 1:
                #     print('# slop tanks diff cargos',file=text_file)#  
                #     str1 = 'param diffSlop := 10' 
                #     print(str1+';', file=text_file)
                #     # default is 1 in AMPL
                
                print('# Commingle cargos',file=text_file)#  
                str1 = 'set Cm_1 := ' 
                # if self.loadable.info['commingleCargo']:
                #     str1 += self.loadable.info['commingleCargo']['parcel1'] + ' '
                print(str1+';', file=text_file)
                
                str1 = 'set Cm_2 := ' 
                # if self.loadable.info['commingleCargo']:
                #     str1 += self.loadable.info['commingleCargo']['parcel2'] + ' '
                print(str1+';', file=text_file)
                            
                print('# Possible commingled tanks',file=text_file)#
                str1 = 'set Tm := '
                # if self.loadable.info['commingleCargo']:
                #     if self.loadable.info['commingleCargo'].get('tank',[]):
                #         for t_ in self.loadable.info['commingleCargo']['tank']:
                #             str1 +=  self.vessel.info['tankId'][int(t_)]  + ' '
                #     elif not self.loadable.info['commingleCargo']['slopOnly']:
                #         str1 += '2C 3C 4C SLS SLP'
                #     else:
                #         str1 += 'SLS SLP'
                print(str1+';', file=text_file)
                
                # print('# Density commingled cargo',file=text_file)#
                # str1 = 'param density_Cm := '
                # if self.loadable.info['commingleCargo']:
                #     str1 += self.loadable.info['commingleCargo']['parcel1'] + ' ' + "{:.4f}".format(self.loadable.info['commingleCargo']['SG1'])+ ' '
                #     str1 += self.loadable.info['commingleCargo']['parcel2'] + ' ' + "{:.4f}".format(self.loadable.info['commingleCargo']['SG2'])+ ' '
                    
                # print(str1+';', file=text_file)
                
                
                # if self.loadable.info['commingleCargo'].get('mode','0') == '2':
                #     print('# Manual commingled cargo',file=text_file)
                #     str1 = 'param Qm_1 := ' + "{:.3f}".format(self.loadable.info['commingleCargo']['wt1'])
                #     print(str1+';', file=text_file)
                #     str1 = 'param Qm_2 := ' + "{:.3f}".format(self.loadable.info['commingleCargo']['wt2'])
                #     print(str1+';', file=text_file)
                #     str1 = 'param Mm := 0'
                #     print(str1+';', file=text_file)
                
                
                print('# cargo tank capacity (in m3)',file=text_file)#  
                str1 = 'param capacityCargoTank := ' 
                for i_, j_ in self.vessel.info['cargoTanks'].items():
                    o_ = self.vessel.info['onboard'].get(i_,{}).get('vol',0.)
                    if o_ > 0:
                        print(i_,j_['capacityCubm'],o_, 'in input.dat')
                    str1 += i_ + ' ' +  "{:.3f}".format(j_['capacityCubm']-o_/0.98)  + ' '
                print(str1+';', file=text_file)
                
                print('# onboard cargo tank (in mt)',file=text_file)#  
                str1 = 'param onboard := ' 
                # for i_, j_ in self.vessel.info['onboard'].items():
                #     if i_ not in ['totalWeight']:
                #         str1 += i_ + ' ' +  "{:.3f}".format(j_['wt'])  + ' '
                print(str1+';', file=text_file)
                
                
                ##
                print('# locked tank',file=text_file)#   
                locked_tank_ = []
                str1 = 'set T_locked := ' 
                for k_, v_ in self.loadable.info['manualOperation'].items():
                    for k1_, v1_ in v_.items():
                        if k1_ not in locked_tank_:
                            str1 += k1_ + ' ' 
                            locked_tank_.append(k1_)
                        
                                
                print(str1+';', file=text_file)
                
                print('# locked cargo',file=text_file)#  
                locked_cargo_= []
                str1 = 'set C_locked := ' 
                for k_, v_ in self.loadable.info['manualOperation'].items():
                    if k_ not in locked_cargo_:
                        str1 += k_ + ' '
                        locked_cargo_.append(k_)
                        
                print(str1+';', file=text_file)
                
                print('# 1 if tank t is locked for cargo c',file=text_file)#  
                str1 = 'param A_locked  := ' 
                print(str1, file=text_file) 
                for k_, v_ in self.loadable.info['manualOperation'].items():
                    str1 = '[' + k_ + ', *] := '
                    tank_ = []
                    for k1_, v1_ in v_.items():
                        tank__ = k1_
                        if v1_ and tank__  not in tank_:
                            str1 += tank__ + ' ' + '1' + ' '
                            tank_.append(tank__)
                    print(str1, file=text_file)
                print(';', file=text_file)  
    #            
                str1 = 'param W_locked   := ' 
                print(str1, file=text_file) 
                for k_, v_ in self.loadable.info['manualOperation'].items():
                    for k1_, v1_ in v_.items():
                        for k2_, v2_ in v1_.items():
                            # tank_ = self.vessel.info['tankId'][int(v2_['tankId'])]
                            
                            str1 = k_ + ' ' + k1_  + ' ' + str(k2_) + ' ' + "{:.1f}".format(v2_)
                            print(str1, file=text_file)
                print(';', file=text_file)
                
                
                str1 = 'param B_locked := '
                print(str1, file=text_file) 
                for k_, v_ in self.loadable.info['ballastOperation'].items():
                    tank_ = k_
                    str1 = '[' + tank_ + ', *] := '
                    for k__, v__ in v_.items():
                        if k__ not in ['0'] and v_ not in [{}]:
                            str1 += k__ + ' ' + "{:.3f}".format(v__) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)  
                        
                
                str1 = 'set fixBallastPort := '
                for k_ in self.loadable.info['fixedBallastPort']:
                    if k_ != '0':
                        str1 += k_ + ' ' 
                print(str1+';', file=text_file)
            
                str1 = 'param trim_upper := '
                for k_, v_ in self.trim_upper.items():
                    str1 += k_ + ' ' + "{:.3f}".format(v_) + ' '
                print(str1+';', file=text_file)
                
                str1 = 'param trim_lower := '
                for k_, v_ in self.trim_lower.items():
                    str1 += k_ + ' ' + "{:.3f}".format(v_) + ' '
                print(str1+';', file=text_file)
                
                # set of other tanks, e.g. fuel tanks, water tanks,
                other_tanks_ = {**self.vessel.info['fuelTanks'], **self.vessel.info['dieselTanks'], **self.vessel.info['freshWaterTanks'] }
                str1 = 'set OtherTanks := '
                for i_, j_ in other_tanks_.items():
                    str1 += i_ + ' '
                print(str1+';', file=text_file)
                
                # weight of each tank
                str1 = 'param weightOtherTank := '
                print(str1, file=text_file)
                for i_, j_ in self.info['ROB'][1].items(): ##
                    str1 = '['+ i_ + ',*] = '
                    for p_ in range(1,self.loadable.info['lastVirtualPort']+1):
                        str1 += str(p_) + ' ' + "{:.3f}".format(j_[0]['quantityMT']) + ' '
                            
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                
                ## ballast tanks    
                # ban_ballast_ = ['FPTU','AWBP','AWBS'] # ['APT','FPTU','AWBP','AWBS']
                print('# ballast tanks ',file=text_file)#  
                str1 = 'set TB := '
                ballast_tanks_ = []
                for i_, j_ in self.vessel.info['ballastTanks'].items():
                    if i_ not in  self.vessel.info['banBallast']:
                        str1 += i_ + ' '
                        ballast_tanks_.append(i_)
                print(str1+';', file=text_file)
                
                str1 = 'param minBallastAmt := '
                for i_, j_ in self.vessel.info['ullage30cm'].items():
                    if i_ not in  self.vessel.info['banBallast']:
                        str1 += i_ + ' ' + "{:.3f}".format(j_) + ' '
                      
                print(str1+';', file=text_file)
                
                # min ballast amt before eduction
                str1 = 'set minTB := '
                # for i_ in self.loading.info['eduction']:
                #     if i_ not in  self.vessel.info['banBallast']:
                #         str1 += i_ + ' '
                print(str1+';', file=text_file)
                
                
                
                print('# ballast tanks with non-pw tcg details',file=text_file)#  
                tb_list_ = list(self.vessel.info['tankTCG']['tcg_pw'].keys()) + self.vessel.info['banBallast']
                str1 = 'set TB1 := '
                for i_, j_ in self.vessel.info['ballastTanks'].items():
                    if i_ not in tb_list_:
                        str1 += i_ + ' '
                print(str1+';', file=text_file)
                
                print('# ballast tanks with non-pw lcg details',file=text_file)#  
                tb_list_ = list(self.vessel.info['tankLCG']['lcg_pw'].keys()) + self.vessel.info['banBallast']
                # tb_list_ = self.vessel.info['banBallast']
                str1 = 'set TB2 := '
                for i_, j_ in self.vessel.info['ballastTanks'].items():
                    if i_ not in tb_list_:
                        str1 += i_ + ' '
                print(str1+';', file=text_file)
    #            
                # density of seawater
                print('# density of seawater ',file=text_file)#
                str1 = 'param densitySeaWater := '
                for p_ in range(1,self.loadable.info['lastVirtualPort']+1): ##
                    str1 += str(p_) + ' ' + "{:.4f}".format(self.seawater_density)  + ' '
                print(str1+';', file=text_file)
                
                print('# cargo tanks restrictions ',file=text_file)#
                str1 = 'set cargoTankNonSym := '
                # for k__, k_  in enumerate(self.vessel.info['notSym']):
                #     str1 += '('+ k_[0]  + ',' + k_[1] + ') '
                print(str1+';', file=text_file)
                
                str1 = 'set C_max := '
                # for k__, k_  in enumerate(self.vessel.info['maxCargo']):
                #     str1 += k_ + ' '
                print(str1+';', file=text_file)
                
                
                # print('# diff vol ',file=text_file)#
                # str1 = 'param diffVol := 1' 
                # print(str1+';', file=text_file)
                
                # print('# deballast percent ',file=text_file)#  ##
                # str1 = 'param deballastPercent := ' + "{:.4f}".format(self.deballast_percent) 
                # print(str1+';', file=text_file)
                
                
                
                print('# initial ballast ',file=text_file)#
                str1 = 'param initBallast := '
                for k_, v_ in self.info['ballast'][0].items():
                    str1 += str(k_) + ' ' + "{:.3f}".format(v_[0]['quantityMT'])  + ' '
                print(str1+';', file=text_file)
                
                print('# inc initial ballast ',file=text_file)##
                str1 = 'set incTB := '
                for k_ in self.loadable.info['incInitBallast']:
                    str1 += str(k_) + ' '
                print(str1+';', file=text_file)
                
                print('# dec initial ballast ',file=text_file)##
                str1 = 'set decTB := '
                for k_ in self.loadable.info['decInitBallast']:
                    str1 += str(k_) + ' '
                print(str1+';', file=text_file)
                
                               
                
                # ##
                print('# loading ports ',file=text_file)#
                str1 = 'set loadingPort := '
                # for k__, k_  in enumerate(self.vessel.info['loading']):
                #     if k__ < len(self.vessel.info['loading'])-1:
                #         str1 += '('+ str(k_)  + ',' + str(self.vessel.info['loading'][k__+1]) + ') '
                print(str1+';', file=text_file)
                
                print('# loading ports not last ',file=text_file)#
                str1 = 'set loadingPortNotLast := '
                # for k__, k_  in enumerate(self.vessel.info['loading']):
                #     if k__ < len(self.vessel.info['loading'])-2:
                #         str1 += '('+ str(k_)  + ',' + str(self.vessel.info['loading'][k__+1]) + ') '
                print(str1+';', file=text_file)
                
                
                print('# departure arrival ports non-empty and empty ROB',file=text_file)#
                str1 = 'set depArrPort1 := '
                # for k__, k_  in enumerate(self.vessel.info['loading']):
                #     if k__ < len(self.vessel.info['loading'])-1:
                #         if (str(k_), str(k_+1)) not in self.vessel.info['sameROBseawater']:
                #             str1 += '('+ str(k_)  + ',' + str(int(k_)+1) + ') '
                print(str1+';', file=text_file)
                
                # same weight
                str1 = 'set depArrPort2 := '  ##
                # for k__, k_  in enumerate(self.loading.seq['sameBallast']):
                #     str1 += '('+ str(k_)  + ',' + str(k_+1) + ') '
                print(str1+';', file=text_file)
                
                # same weight
                str1 = 'set sameBallastPort := '  ##
                # for k__, k_  in enumerate(self.loading.seq['sameBallast']):
                #     str1 += str(k_)  + ' '
                print(str1+';', file=text_file)
                
                
                print('# rotating ports ',file=text_file)#
                str1 = 'set rotatingPort1 := '
                for k_  in range(0, self.loadable.info['lastVirtualPort']):
                        str1 += '('+ str(k_)  + ',' + str(k_+1)+ ') '
                print(str1+';', file=text_file)
                
                
                str1 = 'set rotatingPort2 := '
                # if len(self.vessel.info['rotationVirtual']) >= 2:
                #     for k__, k_  in enumerate(self.vessel.info['rotationVirtual'][1]):
                #         if k__ < len(self.vessel.info['rotationVirtual'][1])-1:
                #             str1 += '('+ str(k_)  + ',' + str(self.vessel.info['rotationVirtual'][1][k__+1])+ ') '
                print(str1+';', file=text_file)
                
                ##
                print('# lastLoadingPortBallastBan ',file=text_file)#
                str1 = 'set lastLoadingPortBallastBan := ' # WB1P WB1S WB2P WB2S WB3P WB3S WB4P WB4S WB5P WB5S'
                print(str1+';', file=text_file)
                
                ## banned ballast in P
                print('# ballastBan ',file=text_file)#
                str1 = 'set ballastBan := ' ##'AWBP AWBS APT'
                print(str1+';', file=text_file)
                
                # print('# first loading Port',file=text_file)#
                # str1 = 'param firstloadingPort := ' #+ self.loadable.info['arrDepVirtualPort']['1D']
                # print(str1+';', file=text_file)
                
                
                print('# capacity of ballast tanks', file=text_file)
                str1 = 'param capacityBallastTank := ' 
                for i_, j_ in self.vessel.info['ballastTanks'].items():
                    if i_ not in self.vessel.info['banBallast']:
                        str1 += i_ + ' ' +  "{:.3f}".format(j_['capacityCubm']) + ' '
                print(str1+';', file=text_file)
    
                print('# light weight of ship', file=text_file)
                str1 = 'param lightWeight := ' + str(self.vessel.info['lightweight']['weight'])
                print(str1+';', file=text_file)            
                
                print('# LCG of ship', file=text_file)
                str1 = 'param LCGship := ' + str(self.vessel.info['lightweight']['lcg'])
                print(str1+';', file=text_file) 
                
                print('# deadweight constant', file=text_file)
                str1 = 'param deadweightConst := ' + str(self.vessel.info['deadweightConst']['weight']) # deadweight constant
                print(str1+';', file=text_file) 
                            
                print('# LCG of deadweight constant', file=text_file)
                str1 = 'param LCGdw := ' + str(self.vessel.info['deadweightConst']['lcg']) 
                print(str1+';', file=text_file) 
                
                print('# TCG of deadweight constant', file=text_file)
                str1 = 'param TCGdw := ' + str(self.vessel.info['deadweightConst']['tcg']) 
                print(str1+';', file=text_file) 
                
                # print('# max num tanks', file=text_file)
                # if self.maxTankUsed:
                #     str1 = 'param maxTankUsed := ' + str(self.maxTankUsed) 
                #     print(str1+';', file=text_file) 
                
                
                print('# first discharge cargo', file=text_file)
                str1 = 'set firstDisCargo := ' 
                # if self.firstDisCargo not in ['None'] and  'P'+self.firstDisCargo not in ['P']:
                #     str1 += 'P'+self.firstDisCargo
                print(str1+';', file=text_file)
                
                
                # print('# cargoweight', file=text_file)
                # str1 = 'param cargoweight := ' + str(self.cargoweight) 
                # print(str1+';', file=text_file) 
                
                # if self.mode in ['Manual', 'FullManual']:
                #     str1 = 'param diffVol := 0.101' 
                #     print(str1+';', file=text_file) 
                    
                
                # str1 = 'set C_equal := '  
                # if len(self.loadable.info['parcel']) == 1:
                #     str1 += list(self.loadable.info['parcel'].keys())[0]
                # print(str1+';', file=text_file) 
                
                str1 = 'set C_slop := '  
                # if len(self.loadable.info['parcel']) == 1:
                #     str1 += list(self.loadable.info['parcel'].keys())[0]
                print(str1+';', file=text_file) 
                    
                
                
                print('# random seed for Gurobi', file=text_file)
                str1 = 'param seed   := ' + str(np.random.randint(0,1000)) 
                # str1 = 'param seed   := 11' 
                print(str1+';', file=text_file)
                
                
                tanks_ = {**self.vessel.info['cargoTanks'], **self.vessel.info['ballastTanks'], 
                          **self.vessel.info['fuelTanks'], **self.vessel.info['dieselTanks'], **self.vessel.info['freshWaterTanks']}
                
                print('# LCGs of tanks', file=text_file)
                str1 = 'param LCGt := '
                for i_, j_ in tanks_.items():
                    if i_ not in  self.vessel.info['banBallast']:
                        str1 += i_ + ' ' +  "{:.4f}".format(j_['lcg']) + ' '
                print(str1+';', file=text_file)   
                
                
                self.vessel.info['TCGt'] = {}
                print('# TCGs of tanks', file=text_file)
                str1 = 'param TCGt := '
                for i_, j_ in tanks_.items():
                    if i_ not in self.vessel.info['banBallast']:
                        tcg_ = self.vessel.info['tankTCG']['tcg'].get(i_,{}).get('tcg',[0.,0.,0.,0.])[-3] # FPTU missing
                        self.vessel.info['TCGt'][i_] = tcg_
                        str1 += i_ + ' ' +  "{:.4f}".format(tcg_)  + ' '
                print(str1+';', file=text_file)   
                
                
                
                print('# num of pw TCG curves for ballast tank', file=text_file)
                str1 = 'param pwTCG := ' +  str(self.vessel.info['tankTCG']['tcg_pw']['npw'])
                print(str1+';', file=text_file)
                
                print('# slopes of TCG curves for tanks', file=text_file)
                print('param mTankTCG := ', file=text_file)
                for m_ in range(1,self.vessel.info['tankTCG']['tcg_pw']['npw']+1):
                    str1 = '[' + str(m_) + ',*] := '
                    for k_, v_ in self.vessel.info['tankTCG']['tcg_pw'].items():
                        if k_ not in (['npw']+self.vessel.info['banBallast']):
                            str1 += k_ + ' ' + str(round(v_['slopes'][m_-1],8)) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)    
                    
                print('# breaks of TCG curves for tanks', file=text_file)
                print('param bTankTCG := ', file=text_file)
                for m_ in range(1,self.vessel.info['tankTCG']['tcg_pw']['npw']):
                    str1 = '[' + str(m_) + ',*] := '
                    for k_, v_ in self.vessel.info['tankTCG']['tcg_pw'].items():
                        if k_ not in (['npw']+self.vessel.info['banBallast']):
                            str1 += k_ + ' ' + str(round(v_['breaks'][m_-1],8)) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)    
                    
                print('# num of pw LCG curves for ballast tank', file=text_file)
                str1 = 'param pwLCG := ' +  str(self.vessel.info['tankLCG']['lcg_pw']['npw'])
                print(str1+';', file=text_file)
                
                print('# slopes of LCG curves for tanks', file=text_file)
                print('param mTankLCG := ', file=text_file)
                for m_ in range(1,self.vessel.info['tankLCG']['lcg_pw']['npw']+1):
                    str1 = '[' + str(m_) + ',*] := '
                    for k_, v_ in self.vessel.info['tankLCG']['lcg_pw'].items():
                        if k_ not in (['npw']+self.vessel.info['banBallast']):
                            str1 += k_ + ' ' + str(round(v_['slopes'][m_-1],8)) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                print('# breaks of LCG curves for tanks', file=text_file)
                print('param bTankLCG := ', file=text_file)
                for m_ in range(1,self.vessel.info['tankLCG']['lcg_pw']['npw']):
                    str1 = '[' + str(m_) + ',*] := '
                    for k_, v_ in self.vessel.info['tankLCG']['lcg_pw'].items():
                        if k_ not in (['npw']+self.vessel.info['banBallast']):
                            str1 += k_ + ' ' + str(round(v_['breaks'][m_-1],8)) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                print('# TCGs for others tanks', file=text_file) ##
                str1 = 'param TCGtp := '
                print(str1, file=text_file)
                for i_, j_ in self.info['ROB'][1].items():
                    str1 = '['+ i_ + ',*] = '
                    for p_ in range(1,self.loadable.info['lastVirtualPort']+1):
                        str1 += str(p_) + ' ' + "{:.4f}".format(j_[0]['tcg']) + ' '
                            
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                print('# LCGs for others tanks', file=text_file) ##
                str1 = 'param LCGtp := '
                print(str1, file=text_file)
                for i_, j_ in self.info['ROB'][1].items():
                    str1 = '['+ i_ + ',*] = '
                    for p_ in range(1,self.loadable.info['lastVirtualPort']+1):
                        str1 += str(p_) + ' ' + "{:.4f}".format(j_[0]['lcg']) + ' '
                            
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                print('# slopes of LCB x Disp curve', file=text_file)
                str1 = 'param pwLCB := ' +  str(len(self.vessel.info['lcb_mtc']['lcb']['slopes']))
                print(str1+';', file=text_file)
                
                # str1 = 'param adjLCB := ' +  "{:.8f}".format(self.vessel.info['lcb_mtc']['lcb']['adj'])
                # print(str1+';', file=text_file)
                
                str1 = 'param mLCB := '
                for m_ in range(1, len(self.vessel.info['lcb_mtc']['lcb']['slopes'])+1):
                    str1 +=  str(m_) + ' ' + str(round(self.vessel.info['lcb_mtc']['lcb']['slopes'][m_-1],8))  + ' '
                print(str1+';', file=text_file)
                    
                print('# breaks of LCB x Disp curve', file=text_file)
                str1 = 'param bLCB := '
                for m_ in range(1,len(self.vessel.info['lcb_mtc']['lcb']['slopes'])):
                    str1 += str(m_) + ' ' + str(round(self.vessel.info['lcb_mtc']['lcb']['breaks'][m_-1],8))  + ' '
                print(str1+';', file=text_file)
                    
                print('# slopes of MTC curve', file=text_file)
                str1 = 'param pwMTC := ' +  str(len(self.vessel.info['lcb_mtc']['mtc']['slopes']))
                print(str1+';', file=text_file)
                str1 = 'param mMTC := '
                for m_ in range(1, len(self.vessel.info['lcb_mtc']['mtc']['slopes'])+1):
                    str1 += str(m_) + ' ' + str(round(self.vessel.info['lcb_mtc']['mtc']['slopes'][m_-1],10))  + ' '
                print(str1+';', file=text_file)
                    
                print('# breaks of MTC curve', file=text_file)
                str1 = 'param bMTC := ' 
                for m_ in range(1,len(self.vessel.info['lcb_mtc']['mtc']['slopes'])):
                    str1 += str(m_) + ' ' + str(round(self.vessel.info['lcb_mtc']['mtc']['breaks'][m_-1],10))  + ' '
                print(str1+';', file=text_file)
                
                print('# upper limit on displacement', file=text_file)
                # stability - draft
                str1 = 'param displacementLimit := '
                for i_, j_ in self.displacement_upper.items():
                    str1 += str(i_) + ' ' +  "{:.5f}".format(j_) + ' '
                print(str1+';', file=text_file)
                
                print('# lower limit on displacement', file=text_file)
                str1 = 'param displacementLowLimit := '
                for i_, j_ in self.displacement_lower.items():
                    str1 += str(i_) + ' ' +  "{:.5f}".format(j_) + ' '
                print(str1+';', file=text_file)
                
                print('# deadweight constraint', file=text_file)
                #str1 = 'param deadweight   := ' + str(self.vessel.info['draftCondition']['deadweight']) 
                str1 = 'param deadweight   := ' + str(1000000) 
                print(str1+';', file=text_file)
                
                
                print('# base draft', file=text_file)
                str1 = 'param base_draft := '
                for i_, j_ in self.base_draft.items():
                    str1 += str(i_) + ' ' +  "{:.2f}".format(j_) + ' '
                print(str1+';', file=text_file)
                
                print('# slopes of draft curve', file=text_file)
                str1 = 'param pwDraft := ' +  str(len(self.vessel.info['lcb_mtc']['draft']['slopes']))
                print(str1+';', file=text_file)
                str1 = 'param mDraft := '
                for m_ in range(1, len(self.vessel.info['lcb_mtc']['draft']['slopes'])+1):
                    str1 += str(m_) + ' ' + str(round(self.vessel.info['lcb_mtc']['draft']['slopes'][m_-1],18))  + ' '
                print(str1+';', file=text_file)
                    
                print('# breaks of draft curve', file=text_file)
                str1 = 'param bDraft :='
                for m_ in range(1,len(self.vessel.info['lcb_mtc']['draft']['slopes'])):
                    str1 += str(m_) + ' ' + str(round(self.vessel.info['lcb_mtc']['draft']['breaks'][m_-1],8))  + ' '
                print(str1+';', file=text_file)
                
                print('# number of frames ',file=text_file)#
                str1 = 'param Fr := ' + str(len(self.vessel.info['frames'])) 
                print(str1+';', file=text_file)
                
                print('# weight ratio for SF and BM',file=text_file)#
                str1 = 'param weightRatio_ct := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['tankGroup'].items():
                    str1 = '['+ str(i_) + ',*] = '
                    for u_, v_ in j_.items():
                        if u_ in cargo_tanks_:
                            str1 += u_ + ' ' + str(round(v_['wr'],4)) + ' '
                    
                    if str1 != '['+ str(i_) + ',*] = ':
                        print(str1, file=text_file)
                print(';', file=text_file)
                
                str1 = 'param weightRatio_bt := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['tankGroup'].items():
                    str1 = '['+ str(i_) + ',*] = '
                    for u_, v_ in j_.items():
                        if u_ in ballast_tanks_:
                            str1 += u_ + ' ' + str(round(v_['wr'],4)) + ' '
                    
                    if str1 != '['+ str(i_) + ',*] = ':
                        print(str1, file=text_file)
                print(';', file=text_file)
                
                str1 = 'param weightRatio_ot := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['tankGroup'].items():
                    str1 = '['+ str(i_) + ',*] = '
                    for u_, v_ in j_.items():
                        if u_ in other_tanks_:
                            str1 += u_ + ' ' + str(round(v_['wr'],4)) + ' '
                    
                    if str1 != '['+ str(i_) + ',*] = ':
                        print(str1, file=text_file)
                print(';', file=text_file)
                
                
                print('# LCG for SF and BM ',file=text_file)#
                str1 = 'param LCG_ct := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['tankGroup'].items():
                    str1 = '['+ str(i_) + ',*] = '
                    for u_, v_ in j_.items():
                        if u_ in cargo_tanks_:
                            str1 += u_ + ' ' + str(round(v_['lcg'],4)) + ' '
                    
                    if str1 != '['+ str(i_) + ',*] = ':
                        print(str1, file=text_file)
                print(';', file=text_file)
                
                str1 = 'param LCG_bt := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['tankGroup'].items():
                    str1 = '['+ str(i_) + ',*] = '
                    for u_, v_ in j_.items():
                        if u_ in ballast_tanks_:
                            str1 += u_ + ' ' + str(round(v_['lcg'],4)) + ' '
                    
                    if str1 != '['+ str(i_) + ',*] = ':
                        print(str1, file=text_file)
                print(';', file=text_file)
               
                str1 = 'param LCG_ot := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['tankGroup'].items():
                    str1 = '['+ str(i_) + ',*] = '
                    for u_, v_ in j_.items():
                        if u_ in other_tanks_:
                            str1 += u_ + ' ' + str(round(v_['lcg'],4)) + ' '
                    
                    if str1 != '['+ str(i_) + ',*] = ':
                        print(str1, file=text_file)
                print(';', file=text_file)
                 
                str1 = 'param LCG_fr := '
                for i_, j_ in self.vessel.info['tankGroupLCG'].items():
                    str1 += str(i_) + ' ' + str(round(j_,3)) + ' '
                print(str1+';', file=text_file)
                
                print('# lower limit SF ',file=text_file)#
                str1 = 'param lowerSFlimit := '
                for i_, j_ in enumerate(self.vessel.info['frames']):
                    str1 += str(i_+1) + ' ' +  str(round(float(self.vessel.info['SFlimits'][j_][0])/1000*self.sf_bm_frac,5)) + ' '      
                print(str1+';', file=text_file)
                
                print('# upper limit SF ',file=text_file)#
                str1 = 'param upperSFlimit := '
                for i_, j_ in enumerate(self.vessel.info['frames']):
                    str1 += str(i_+1) + ' ' +  str(round(float(self.vessel.info['SFlimits'][j_][1])/1000*self.sf_bm_frac,5)) + ' '      
                print(str1+';', file=text_file)
                
                str1 = 'param BV_SF := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['tankGroup'].items():
                    str1 = '['+ str(i_) + ',*] = '
                    for k_, v_ in self.sf_base_value.items():
                        str1 += str(k_) + ' ' + str(round(v_[int(i_)-1],5)) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                str1 = 'param CD_SF := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['tankGroup'].items():
                    str1 = '['+ str(i_) + ',*] = '
                    for k_, v_ in self.sf_draft_corr.items():
                        str1 += str(k_) + ' ' + str(round(v_[int(i_)-1],5)) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                str1 = 'param CT_SF := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['tankGroup'].items():
                    str1 = '['+ str(i_) + ',*] = '
                    for k_, v_ in self.sf_trim_corr.items():
                        str1 += str(k_) + ' ' + str(round(v_[int(i_)-1],5)) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                
                
                print('# lower limit BM ',file=text_file)#
                str1 = 'param lowerBMlimit := '
                for i_, j_ in enumerate(self.vessel.info['frames']):
                    str1 += str(i_+1) + ' ' +  str(round(float(self.vessel.info['BMlimits'][j_][0])/1000*self.sf_bm_frac,5)) + ' '      
                print(str1+';', file=text_file)
                
                print('# upper limit BM ',file=text_file)#
                str1 = 'param upperBMlimit := '
                for i_, j_ in enumerate(self.vessel.info['frames']):
                    str1 += str(i_+1) + ' ' +  str(round(float(self.vessel.info['BMlimits'][j_][1])/1000*self.sf_bm_frac,5)) + ' '      
                print(str1+';', file=text_file)
                
                
                str1 = 'param BV_BM := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['tankGroup'].items():
                    str1 = '['+ str(i_) + ',*] = '
                    for k_, v_ in self.bm_base_value.items():
                        str1 += str(k_) + ' ' + str(round(v_[int(i_)-1],5)) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                str1 = 'param CD_BM := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['tankGroup'].items():
                    str1 = '['+ str(i_) + ',*] = '
                    for k_, v_ in self.bm_draft_corr.items():
                        str1 += str(k_) + ' ' + str(round(v_[int(i_)-1],5)) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                str1 = 'param CT_BM := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['tankGroup'].items():
                    str1 = '['+ str(i_) + ',*] = '
                    for k_, v_ in self.bm_trim_corr.items():
                        str1 += str(k_) + ' ' + str(round(v_[int(i_)-1],5)) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                str1 = 'param IIS := ' 
                str1 += '1' if IIS else '0'
                print(str1, file=text_file)
                
              
        
        
    def _get_plan(self, stowageDetails, cargo_info_, cargoDetails, commingleDetails = [], initial = True, not_cargo = [], strip_info = False):
        
        arr_plan_ =  cargo_info_['cargo_plans'][0] if len(cargo_info_['cargo_plans']) > 0 else []
        if not initial:
            init_tanks_ = [k_ for k_, v_ in arr_plan_.items() if v_[0]['quantityMT'] > 0]
        else:
            init_tanks_ = []
        
        if strip_info:
            cur_cargo_ = cargo_info_['discharging_order'][len(cargo_info_['cargo_plans'])-1]
            cur_cargo_ = cargo_info_['dsCargoNominationId'][cur_cargo_] 
        
        plan_, tanks_ = {}, []
        wt_ = 0.0
        
        
            
        for d_ in stowageDetails:
            tank_ = self.vessel.info['tankId'][d_['tankId']]
            
            cargo_ = d_.get('cargoNominationId', None)
            if cargo_ not in [None]:
                cargo_ = 'P' + str(cargo_)
                tanks_.append(tank_)
            
            if not cargo_:
                continue
            elif cargo_info_['cargoNominationId'][cargo_] not in not_cargo:
                
                self._get_plan1(d_["cargoNominationId"], d_["tankId"], d_["quantityMT"], 
                                d_.get('cargoId',None), d_.get('colorCode',None), d_.get('abbreviation',None),
                                plan_, cargo_info_, cargoDetails, initial)
                
                wt_ += float(d_["quantityMT"])
                
                if strip_info and float(d_["quantityMT"]) == 0 and cargo_ == cur_cargo_:
                    cargo_info_['stripping_tanks'][len(cargo_info_['cargo_plans'])].append(tank_)
                    
            else:
                # print('Get from arr_plan_')
                plan_[tank_] = arr_plan_[tank_]
                
            
        # for d_ in commingleDetails:
        #     ## not supported
        #     if initial:
        #         self.commingle_preloaded = True 
        #     else:
        #         self.commingle_loading = True
            
        #     self._get_plan2(d_, plan_, cargo_info_, cargoDetails, initial, not_cargo)
            
        # print(set(init_tanks_)-set(tanks_))
        
        if not initial:
            for t_ in set(init_tanks_)-set(tanks_):
                
                if strip_info and arr_plan_[t_][0]['cargo'] == cur_cargo_:
                    cargo_info_['stripping_tanks'][len(cargo_info_['cargo_plans'])].append(t_)
                    
                plan_[t_] = deepcopy(arr_plan_[t_])
                plan_[t_][0]['quantityMT'] = 0.
                plan_[t_][0]['quantityM3'] = 0.
                
                
                
        cargo_info_['cargo_plans'].append(plan_)    
        if initial:
            cargo_info_['initCargoWeight'] = wt_


    def _get_plan1(self, cargoNominationId, tankId, quantityMT, cargoId, color, abbrev, plan_, cargo_info_, cargoDetails, initial):
        
        cargo_, tank_, wt_ = 'P'+str(cargoNominationId), tankId, quantityMT
            
        if cargo_ not in cargo_info_['density']:
            i_ = [j_ for j_ in cargoDetails if j_["cargoNominationId"] == cargoNominationId][0]
            cargo_info_['density'][cargo_] = self._cal_density(float(i_['estimatedAPI']),float(i_['estimatedTemp']))
            cargo_info_['api'][cargo_] = float(i_['estimatedAPI'])
            cargo_info_['temperature'][cargo_] = float(i_['estimatedTemp'])
            cargo_info_['cargoId'][cargo_] = cargoId
            cargo_info_['colorCode'][cargo_] = color
            cargo_info_['abbreviation'][cargo_] = abbrev
            
        
        tankName_ = self.vessel.info['tankId'][tank_]
        if tankName_ not in cargo_info_['cargoTanksUsed']:
            cargo_info_['cargoTanksUsed'].append(tankName_)
    
        
        vol_ = float(wt_)/cargo_info_['density'][cargo_]
       
        tcg_ = 0.
        if tankName_ in self.vessel.info['tankTCG']['tcg']:
            tcg_ = np.interp(vol_, self.vessel.info['tankTCG']['tcg'][tankName_]['vol'],
                                   self.vessel.info['tankTCG']['tcg'][tankName_]['tcg'])
        
        lcg_ = 0.
        if tankName_ in self.vessel.info['tankLCG']['lcg']:
            lcg_ = np.interp(vol_, self.vessel.info['tankLCG']['lcg'][tankName_]['vol'],
                                  self.vessel.info['tankLCG']['lcg'][tankName_]['lcg'])
            
        tankId_ = self.vessel.info['tankName'][tankName_]     
        try:
            corrLevel_ = self.vessel.info['ullage'][str(tankId_)](vol_).tolist()
        except:
            print(tankName_, vol_, ': correctLevel not available!!')
            corrLevel_ = 0.
            
        info_ = {'quantityMT': float(wt_), 'cargo':cargo_, 
                            'quantityM3': vol_,
                            'SG':cargo_info_['density'][cargo_],
                            'tankId':tank_,
                            'api':cargo_info_['api'][cargo_],
                            'temperature':cargo_info_['temperature'][cargo_],
                            'tcg':tcg_, 'lcg':lcg_, 'corrUallage':corrLevel_,
                            'cargoId':cargo_info_['cargoId'][cargo_], 
                            'colorCode':cargo_info_['colorCode'][cargo_], 
                            'abbreviation':cargo_info_['abbreviation'][cargo_] 
                            }
        
        if tankName_ not in plan_.keys():
            plan_[tankName_] = [info_]
        else:
            plan_[tankName_].append(info_)
            
        
        # if tankName_[-1] == 'C' or tankName_ in ['SLS', 'SLP']:
        #     tank1_ = tankName_ 
        # else:
        #     tank1_ = tankName_[:-1] + 'W'
            
        tank1_ = tankName_
            
        
        if cargo_ not in cargo_info_['cargo_tank']:
            cargo_info_['cargo_tank'][cargo_] = [tank1_]
            
        elif tank1_ not in cargo_info_['cargo_tank'][cargo_]:
            cargo_info_['cargo_tank'][cargo_].append(tank1_)
            
        if initial and cargo_ not in self.preloaded_cargos :
            self.preloaded_cargos.append(cargo_)
            
        # elif (cargo_ not in self.to_load_cargos) and (cargo_ not in self.preloaded_cargos):
        #     self.to_load_cargos.append(cargo_)
        
    def _get_plan2(self, d_, plan_, cargo_info_, cargoDetails, initial, not_cargo):
        
        cargo1_, cargo2_ = 'P'+str(d_['cargo1NominationId']), 'P'+str(d_['cargo2NominationId'])
        
        if cargo1_ not in not_cargo:
            # load cargo 1
            self._get_plan1(d_["cargo1NominationId"], d_["tankId"], d_["cargo1QuantityMT"],
                            d_.get('cargoId',None), d_.get('colorCode',None), d_.get('abbreviation',None),
                            plan_, cargo_info_, cargoDetails, initial)
        
        if cargo2_ not in not_cargo:
            # load cargo 2
            self._get_plan1(d_["cargo2NominationId"], d_["tankId"], d_["cargo2QuantityMT"],
                            d_.get('cargoId',None), d_.get('colorCode',None), d_.get('abbreviation',None),
                            plan_, cargo_info_, cargoDetails, initial)
            
            
        if cargo1_ not in not_cargo and cargo2_ not in not_cargo:
            # update commingle
            print(cargo1_, cargo2_, 'commingle')
            cargo_info_['commingle'] = {k_:v_  for k_, v_ in d_.items() if k_ in ['tankId', 'cargo1QuantityMT', 'cargo2QuantityMT', 'cargo1NominationId', 'cargo2NominationId']}
            
            api__ = [cargo_info_['api'][cargo1_], cargo_info_['api'][cargo2_]]
            wt__ = [float(cargo_info_['commingle']['cargo1QuantityMT']), float(cargo_info_['commingle']['cargo2QuantityMT'])]
            temp__ = [cargo_info_['temperature'][cargo1_], cargo_info_['temperature'][cargo2_]]
            api_, temp_ = self._get_commingleAPI(api__, wt__, temp__)
            
            density_ = self._cal_density(round(api_,2), round(temp_,1))
            cargo_info_['commingle']['density'] = density_
            cargo_info_['commingle']['tankName'] = self.vessel.info['tankId'][cargo_info_['commingle']['tankId']]
            cargo_info_['commingle']['parcel1'] = 'P'+str(cargo_info_['commingle']['cargo1NominationId'])
            cargo_info_['commingle']['parcel2'] = 'P'+str(cargo_info_['commingle']['cargo2NominationId'])
            cargo_info_['commingle']['t1'] = cargo_info_['temperature'][cargo1_]
            cargo_info_['commingle']['t2'] = cargo_info_['temperature'][cargo2_]
            cargo_info_['commingle']['api1'] = cargo_info_['api'][cargo1_]
            cargo_info_['commingle']['api2'] = cargo_info_['api'][cargo2_]
            cargo_info_['commingle']['colorCode'] = d_.get('colorCode', None)
            cargo_info_['commingle']['abbreviation'] = d_.get('abbreviation', None)
            
            
        
        
    def _get_commingleAPI(self, api, weight, temp):
        weight_api_ , weight_temp_ = 0., 0.
        
        sg60_ = [141.5/(a_+131.5) for a_ in api]
        t13_ = [(535.1911/(a_+131.5)-0.0046189)*0.042 for a_ in api]
        vol_bbls_60_ = [w_/t_ for (w_,t_) in zip(weight,t13_)]
        
        weight_sg60_ = sum([v_*s_ for (v_,s_) in zip(vol_bbls_60_,sg60_)])/sum(vol_bbls_60_)
        weight_api_ = 141.5/weight_sg60_ - 131.5
        
        weight_temp_ = sum([v_*s_ for (v_,s_) in zip(vol_bbls_60_,temp)])/sum(vol_bbls_60_)
        
        return weight_api_, weight_temp_
        
               
        
    def _get_rob(self, onhand, cargo_info_):
        
        DENSITY = self.config['rob_density']
        
        plan_i_, plan_f_ = {}, {}
        wt_i_, wt_f_  = 0., 0.
        for o__,o_ in enumerate(onhand):
            # print(o_['tankName'])
            tankName_ = o_['tankName']
            
            tcg_data_ = self.vessel.info['tankTCG']['tcg'][tankName_] # tcg_data
            lcg_data_ = self.vessel.info['tankLCG']['lcg'][tankName_] # lcg_data
            color_ = o_.get('colorCode', None)
            
            self.rob_color[tankName_] = color_
                
            if o_['arrivalQuantity'] > 0:
                
                wt_ =  o_['arrivalQuantity']
                vol_ = float(wt_)/DENSITY[tankName_]
                
                tcg_ = np.interp(vol_, tcg_data_['vol'], tcg_data_['tcg'])
                lcg_ = np.interp(vol_, lcg_data_['vol'], lcg_data_['lcg'])
                
                tank_ = self.vessel.info['tankName'][tankName_]
                
                plan_i_[tankName_] =  [{'quantityMT': float(wt_), 
                                'quantityM3': vol_,
                                'tankId':tank_,
                                'tcg':tcg_, 'lcg':lcg_, 'colorCode':color_}]
                
                
            if o_['departureQuantity'] > 0:
                wt_ =  o_['departureQuantity']
                vol_ = float(o_['departureQuantity'])/DENSITY[tankName_]
                
                tcg_ = np.interp(vol_, tcg_data_['vol'], tcg_data_['tcg'])
                lcg_ = np.interp(vol_, lcg_data_['vol'], lcg_data_['lcg'])
                
                tank_ = self.vessel.info['tankName'][tankName_]
                
                plan_f_[tankName_] =  [{'quantityMT': float(wt_), 
                                'quantityM3': vol_,
                                'tankId':tank_,
                                'tcg':tcg_, 'lcg':lcg_, 'colorCode':color_}]
                
                wt_f_ += float(wt_)
                
        cargo_info_['ROB'] = [plan_i_, plan_f_]
        cargo_info_['depROBweight'] = wt_f_
        
        
    def _get_ballast(self, ballast, cargo_info_):
        
        density_ = 1.025 #  ballast density
        # density_ = self.seawater_density
        plan_ = {}
        wt1_ = 0
        for d_ in ballast:
            tank_, wt_ = d_['tankId'], d_['quantityMT']
            tankName_ = self.vessel.info['tankId'][tank_]
            color_ = d_.get('colorCode', None)
            
            if tankName_ not in cargo_info_['ballastTanksUsed'] and tankName_ not in self.vessel.info['banBallast']:
                cargo_info_['ballastTanksUsed'].append(tankName_)
                # print(tankName_)
                
            
            self.ballast_color[tankName_] = color_
            
            if wt_ not in [None, '0', 'null']:
               
               wt1_ += float(wt_) 
               
               vol_ = float(wt_)/density_
               
               tcg_data_ = self.vessel.info['tankTCG']['tcg'][tankName_] # tcg_data
               lcg_data_ = self.vessel.info['tankLCG']['lcg'][tankName_] # lcg_data
                
               tcg_ = np.interp(vol_, tcg_data_['vol'], tcg_data_['tcg'])
               lcg_ = np.interp(vol_, lcg_data_['vol'], lcg_data_['lcg'])
                
               tank_ = self.vessel.info['tankName'][tankName_]
               
                
               plan_[tankName_] =  [{'quantityMT': float(wt_), 
                                     'quantityM3': vol_,
                                'tankId':tank_,
                                'tcg':tcg_, 'lcg':lcg_,'density':density_, 'colorCode':color_}]
        
        if len(cargo_info_['ballast']) == 0:
            cargo_info_['initBallastWeight'] = wt1_
            
        cargo_info_['ballast'].append(plan_)
        
    def _cal_density(self, api, temperature_F):
        
        ## https://www.myseatime.com/blog/detail/cargo-calculations-on-tankers-astm-tables
    
        a60 = 341.0957/(141360.198/(api+131.5))**2
        dt = temperature_F-60
        vcf_ = np.exp(-a60*dt*(1+0.8*a60*dt))
        t13_ = (535.1911/(api+131.5)-0.0046189)*0.42/10
        density = t13_*vcf_*6.2898
        
    
        return round(density,6)
                