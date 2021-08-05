# -*- coding: utf-8 -*-
"""
Created on Thu Jul 15 10:48:53 2021

@author: I2R
"""
import pandas as pd
import numpy as np
from copy import deepcopy


## virtual ports
DENSITY = {'DSWP':1.0, 'DWP':1.0, 'FWS':1.0, 'DSWS':1.0,
           'FO2P':0.98, 'FO2S':0.98, 'FO1P':0.98, 'FO1S':0.98, 'BFOSV':0.98, 'FOST':0.98, 'FOSV':0.98,
           'DO1S':0.88,  'DO2S':0.88, 'DOSV1':0.88, 'DOSV2':0.88}

INDEX = ['Time','SLS', 'SLP', '5W', '5C', '4W', '4C', '2W', '2C','1W','1C','3W','3C']
INDEX1 = ['LFPT', 'WB1P', 'WB1S', 'WB2P', 'WB2S', 'WB3P', 'WB3S', 'WB4P', 'WB4S', 'WB5P', 'WB5S', 'AWBP', 'AWBS', 'APT']
OPEN_TANKS = ['3C', '2C', '4C', '5C', '1C', '3W', '4W', '2W', '5W', '1W' ]
DEC_PLACE = 10

TIME_EDUCTING = 60*3
        
class LoadingOperations(object):
    
    def __init__(self, data):
        
        
        self.vessel = data.vessel
        
        self.time_interval = 60*4
        self.load_param = {'Manifolds':[2,3],
                     'centreTank':[],
                     'wingTank': [],
                     'slopTank': [],
                     'BottomLines': [2,3]
                    }
        
        self.staggering_param = {'maxShoreRate': 11129, #### 
                                 'wingTank': 2*self.vessel.info['loadingRate6']['WingTankBranchLine'], # 7900
                                 'centerTank': self.vessel.info['loadingRate6']['CentreTankBranchLine'], #5790,
                                 'slopTank': self.vessel.info['loadingRate6']['SlopTankBranchLine'], #3435,
                                 'toppingSeq':[]}
        
        
        self.preloaded_cargos, self.to_load_cargos = [], []
        
        
        cargo_info_ = {}
        
        # initial and final ROB
        self._get_rob(data.vessel_json['onHand'], cargo_info_)
                
                
        # initial Ballast, final Ballast
        cargo_info_['ballast'] = []
        self._get_ballast(data.loadable_json['planDetails']['arrivalCondition']['loadablePlanBallastDetails'], cargo_info_)
        self._get_ballast(data.loadable_json['planDetails']['departureCondition']['loadablePlanBallastDetails'], cargo_info_)
        
        
        
        
        # for d_ in data.loadable_json['planDetails']['departureCondition']['loadablePlanBallastDetails']:
        #     type_, tank_, wt_ = 'Ballast', d_['tankId'], d_['quantityMT']
        #     tankName_ = data.vessel.info['tankId'][tank_]
        #     if wt_ not in [None, 0., 'null']:
        #         cargo_info_['finalBallast'][(type_,tankName_)] = wt_
            
        cargo_info_['loading_order'] = ['P'+str(d_['cargoNominationId']) for d_ in data.loading_info_json['loadingSequences']['loadingDelays'] if d_['cargoNominationId'] not in [0]]
        
        # add plans -------------------------------------------------------------------------
        cargo_info_['cargo_plans'] = []
        cargo_info_['cargo_tank'] = {}
        cargo_info_['density'] = {}
        cargo_info_['density'], cargo_info_['api'], cargo_info_['temperature'] = {}, {}, {}
        
        # initial plan
        self._get_plan(data.loadable_json['planDetails']['arrivalCondition']['loadablePlanStowageDetails'],
                       cargo_info_, data.loading_info_json['loadableQuantityCargoDetails'], initial = True)
        
       
        # cargo_info_['loading_order'] = ['A','B','C','D']
        for o__,o_ in enumerate(cargo_info_['loading_order'][:-1]):
            
            not_cargo_ = cargo_info_['loading_order'][o__+1:]
            # print(not_cargo_)
            self._get_plan(data.loadable_json['planDetails']['departureCondition']['loadablePlanStowageDetails'],
                       cargo_info_, data.loading_info_json['loadableQuantityCargoDetails'], initial = False, not_cargo = not_cargo_)
                    
            
        # final plan 
        self._get_plan(data.loadable_json['planDetails']['departureCondition']['loadablePlanStowageDetails'],
                       cargo_info_, data.loading_info_json['loadableQuantityCargoDetails'], initial = False)
        
                
        self.info = cargo_info_
        
        # print('total wt_', total_wt_)
        # data.error['Input Error'] = ['Error']
    
    def _get_rob(self, onhand, cargo_info_):
        
        plan_i_, plan_f_ = {}, {}
        for o__,o_ in enumerate(onhand):
            # print(o_['tankName'])
            tankName_ = o_['tankName']
            
            
            
            tcg_data_ = self.vessel.info['tankTCG']['tcg'][tankName_] # tcg_data
            lcg_data_ = self.vessel.info['tankLCG']['lcg'][tankName_] # lcg_data
                
            if o_['arrivalQuantity'] > 0:
                
                wt_ =  o_['arrivalQuantity']
                vol_ = float(wt_)/DENSITY[tankName_]
                
                tcg_ = np.interp(vol_, tcg_data_['vol'], tcg_data_['tcg'])
                lcg_ = np.interp(vol_, lcg_data_['vol'], lcg_data_['lcg'])
                
                tank_ = self.vessel.info['tankName'][tankName_]
                
                plan_i_[tankName_] =  [{'quantityMT': float(wt_), 
                                'quantityM3': vol_,
                                'tankId':tank_,
                                'tcg':tcg_, 'lcg':lcg_}]
                
                
            if o_['departureQuantity'] > 0:
                wt_ =  o_['departureQuantity']
                vol_ = float(o_['departureQuantity'])/DENSITY[tankName_]
                
                tcg_ = np.interp(vol_, tcg_data_['vol'], tcg_data_['tcg'])
                lcg_ = np.interp(vol_, lcg_data_['vol'], lcg_data_['lcg'])
                
                tank_ = self.vessel.info['tankName'][tankName_]
                
                plan_f_[tankName_] =  [{'quantityMT': float(wt_), 
                                'quantityM3': vol_,
                                'tankId':tank_,
                                'tcg':tcg_, 'lcg':lcg_}]
                
        cargo_info_['ROB'] = [plan_i_, plan_f_]
    
    
    def _get_ballast(self, ballast, cargo_info_):
        
        density_ = 1.025
        plan_ = {}
        for d_ in ballast:
            tank_, wt_ = d_['tankId'], d_['quantityMT']
            tankName_ = self.vessel.info['tankId'][tank_]
            if wt_ not in [None, '0', 'null']:
               vol_ = float(wt_)/density_
               
               tcg_data_ = self.vessel.info['tankTCG']['tcg'][tankName_] # tcg_data
               lcg_data_ = self.vessel.info['tankLCG']['lcg'][tankName_] # lcg_data
                
               tcg_ = np.interp(vol_, tcg_data_['vol'], tcg_data_['tcg'])
               lcg_ = np.interp(vol_, lcg_data_['vol'], lcg_data_['lcg'])
                
               tank_ = self.vessel.info['tankName'][tankName_]
                
               plan_[tankName_] =  [{'quantityMT': float(wt_), 
                                     'quantityM3': vol_,
                                'tankId':tank_,
                                'tcg':tcg_, 'lcg':lcg_,'density':density_}]
        
        cargo_info_['ballast'].append(plan_)
                
                
                
        
    def _get_plan(self, loadablePlanStowageDetails, cargo_info_, loadableQuantityCargoDetails, initial = True, not_cargo = []):
        
        plan_ = {}
        for d_ in loadablePlanStowageDetails:
            
            
            if not d_.get('cargoNominationId', None):
                continue
            elif 'P'+str(d_['cargoNominationId']) in not_cargo:
                continue
            
            cargo_, tank_, wt_ = 'P'+str(d_['cargoNominationId']), d_['tankId'], d_['quantityMT']
            
            if cargo_ not in cargo_info_['density']:
                i_ = [j_ for j_ in loadableQuantityCargoDetails if j_["cargoNominationId"] == d_["cargoNominationId"]][0]
                cargo_info_['density'][cargo_] = self._cal_density(float(i_['estimatedAPI']),float(i_['estimatedTemp']))
                cargo_info_['api'][cargo_] = float(i_['estimatedAPI'])
                cargo_info_['temperature'][cargo_] = float(i_['estimatedTemp'])
            
            tankName_ = self.vessel.info['tankId'][tank_]
            
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
                        
            plan_[tankName_] = [{'quantityMT': float(wt_), 'cargo':cargo_, 
                                'quantityM3': vol_,
                                'tankId':tank_,
                                'api':cargo_info_['api'][cargo_],
                                'temperature':cargo_info_['temperature'][cargo_],
                                'tcg':tcg_, 'lcg':lcg_, 'corrUallage':corrLevel_}]
            
            if tankName_[-1] == 'C' or tankName_ in ['SLS', 'SLP']:
                tank1_ = tankName_ 
            else:
                tank1_ = tankName_[:-1] + 'W'
                
            
            if cargo_ not in cargo_info_['cargo_tank']:
                cargo_info_['cargo_tank'][cargo_] = [tank1_]
            elif tank1_ not in cargo_info_['cargo_tank'][cargo_]:
                cargo_info_['cargo_tank'][cargo_].append(tank1_)
                
            if initial and cargo_ not in self.preloaded_cargos :
                self.preloaded_cargos.append(cargo_)
            elif cargo_ not in self.to_load_cargos:
                self.to_load_cargos.append(cargo_)
                
        cargo_info_['cargo_plans'].append(plan_)
                
        
    def _gen_topping(self):
        
        
        
        self.seq = {}
        # self.seq['cargo'] =[]
        
        start_time_ = 0 # 
        
        for p__, p_ in enumerate(self.info['cargo_plans'][:-1]):
            
            df_ = pd.DataFrame(index=INDEX)
            
            # print(p__, p_)
            df_['Initial'] = None
            df_['Initial']['Time'] = 0
            
            stages_ = {"initialCondition":(df_['Initial']['Time'], df_['Initial']['Time'])}
            
            cargo_to_load_ = self.info['loading_order'][p__]
            
            self.seq[cargo_to_load_] = {}
            
            # for each cargo volume
            for k_, v_ in p_.items(): #self.info['plans'][p__+1].items():
                # set time 0
                tank_ = k_
                if tank_[-1] == 'C' or tank_ in ['SLS', 'SLP']:
                    df_['Initial'][tank_] = (v_[0]['cargo'], v_[0]['quantityM3'])
                else:
                    tank_ = tank_[:-1] +'W'
                    if df_['Initial'][tank_] == None:
                        df_['Initial'][tank_] = (v_[0]['cargo'], v_[0]['quantityM3'])
                    else:
                        df_['Initial'][tank_] = (v_[0]['cargo'], v_[0]['quantityM3'] + df_['Initial'][tank_][-1])
                        
            # open first tank
            first_tank_ = [t_ for t_ in OPEN_TANKS if t_ in self.info['cargo_tank'][cargo_to_load_]][0] ### fixed
            
            self.seq[cargo_to_load_]['firstTank'] = first_tank_     
            # copy self.load_param
            load_param = deepcopy(self.load_param)
                
            if first_tank_[-1] in ['C']:
                load_param['centreTank'].append(first_tank_)
            elif first_tank_ in ['SLS','SLP']:
                load_param['slopTank'].append(first_tank_)
            else:
                load_param['wingTank'].append(first_tank_)
                    
            loading_rate_ = self._cal_max_rate(load_param)
            
            print('initial rate: ', loading_rate_) # m3/hr
            self.seq[cargo_to_load_]['initialRate'] = loading_rate_     
            
            # Open one tank
            df_['Open'] =  df_['Initial']  
            df_['Open']['Time'] = 5
            
            stages_['openSingleTank'] = (df_['Initial']['Time'], df_['Open']['Time'])
            # Initial rate - fill first tank
            df_['InitialRate'] =  df_['Initial']
            df_['InitialRate']['Time'] = 15
            df_['InitialRate'][first_tank_] = (cargo_to_load_, loading_rate_/6) # P111, vol
            
            stages_['initialRate'] = (df_['Open']['Time'], df_['InitialRate']['Time'])
            
            
            # open all empty tanks 
            df_['OpenAll'] =  df_['Initial']
            df_['OpenAll']['Time'] = 20 # end time
            
            stages_['openAllTanks'] = (df_['InitialRate']['Time'], df_['OpenAll']['Time'])
            
            
            
            total_tank_ = 0
            for t_ in self.info['cargo_tank'][cargo_to_load_]:
                if 'W' not in t_:
                    total_tank_ += 1
                else:
                    total_tank_ += 2
            
            cargo_loaded_ = loading_rate_/4
            cargo_loaded_per_tank_ = cargo_loaded_/total_tank_
            # should have used same ullage but used uniform volume instead
            for t_ in self.info['cargo_tank'][cargo_to_load_]:
                if t_[-1] == 'C' or t_ in ['SLS','SLP']:
                    df_['OpenAll'][t_] = (cargo_to_load_, cargo_loaded_per_tank_)
                else:
                    df_['OpenAll'][t_] = (cargo_to_load_, 2*cargo_loaded_per_tank_)
                    
            # increase to max rate
            df_['IncMax'] =  df_['Initial']
            df_['IncMax']['Time'] = 30 # end time
            
            cargo_loaded_ = loading_rate_*25/60
            cargo_loaded_per_tank_ = cargo_loaded_/total_tank_
            
            stages_['increaseToMaxRate'] = (df_['OpenAll']['Time'], df_['IncMax']['Time'])
            
            df_inc_max_ = pd.DataFrame(index=INDEX[1:])
            df_inc_max_['IncMax'] = None
            
            for t_ in self.info['cargo_tank'][cargo_to_load_]:
                if t_[-1] == 'C' or t_ in ['SLS','SLP']:
                    df_['IncMax'][t_] = (cargo_to_load_, cargo_loaded_per_tank_)
                    df_inc_max_['IncMax'][t_] = cargo_loaded_per_tank_
                else:
                    df_['IncMax'][t_] = (cargo_to_load_, 2*cargo_loaded_per_tank_)
                    df_inc_max_['IncMax'][t_] = 2*cargo_loaded_per_tank_
                    
            
            # staggering rate  ## fixed
            # param_ = {'maxShoreRate': 11129, 
            #          'wingTank': 7900,
            #          'centerTank': 5790,
            #          'slopTank': 3435,
            #          'toppingSeq':[]}
            
            param_ = deepcopy(self.staggering_param)
            
            self.seq[cargo_to_load_]['maxShoreRate'] = param_['maxShoreRate']
            
            for t_ in INDEX:
                if t_ in self.info['cargo_tank'][cargo_to_load_]:
                    param_['toppingSeq'].append([t_])
                        
            staggering_rate_ = self._cal_staggering_rate(param_)
            
            
            self.seq[cargo_to_load_]['staggerRate'] = deepcopy(staggering_rate_) 
            
            num_staggering_ = len(staggering_rate_.columns)
            
            staggering_rate_['TotalVol'] = None
            # staggering_rate_['TotalWeight'] = None
            
            for k_, v_ in self.info['cargo_plans'][p__+1].items():
                # print(k_, v_)
                if v_[0]['cargo'] == cargo_to_load_:
                    if k_[-1] == 'C' or k_ in ['SLS', 'SLP']:
                        staggering_rate_['TotalVol'][k_] = v_[0]['quantityM3']
                        # staggering_rate_['TotalWeight'][k_[1]] = staggering_rate_['TotalVol'][k_[1]]*self.info['density'][cargo_to_load_]
                        
                    else:
                        tank1_ = k_[:-1] + 'P'
                        tank2_ = k_[:-1] + 'S'
                        tank_ = k_[:-1] + 'W'
                        staggering_rate_['TotalVol'][tank_]  = self.info['cargo_plans'][p__+1][tank1_][0]['quantityM3'] + self.info['cargo_plans'][p__+1][tank2_][0]['quantityM3'] 
                        
                        
                    
            staggering_rate_['AmtFilled'] = None
            for t_ in self.info['cargo_tank'][cargo_to_load_]:
                t__ = t_
                
                rate_ = staggering_rate_.loc[t__].to_list()[:-2]
                len_rate_ = len(rate_) - rate_.count(None)
                vol_ = np.array(rate_[:len_rate_]).sum()/4 # fixed 15 min per stage
                staggering_rate_['AmtFilled'][t__] = vol_ #round(vol_,10)
                    
            staggering_rate_['AmtBefTop'] =     staggering_rate_['TotalVol'] -  staggering_rate_['AmtFilled']
            time_taken_ =  (staggering_rate_['AmtBefTop'].sum() - df_inc_max_['IncMax'].sum())/param_['maxShoreRate']*60 # min
            
            staggering_rate_['LoadingRateM3Min'] = (staggering_rate_['AmtBefTop'] - df_inc_max_['IncMax'])/time_taken_
            
            topping_start_ = time_taken_ + 30
            
            time_interval_ = self.time_interval ## fixed
            # self.time_interval = time_interval_
            time_, stage_ = time_interval_, 1
            time_incmax_ = df_['IncMax']['Time']
            
            ballast_ = [(0, 'Initial')]
            ballast_stop_ = []
            while time_ < topping_start_:
                # print(time_)
                ss_ = 'MaxLoading' + str(stage_)
                df_[ss_] = df_['IncMax']
                df_[ss_]['Time'] = int(time_)
                before_topping_ = ss_
                ballast_.append((int(time_),ss_))
                for t_ in self.info['cargo_tank'][cargo_to_load_]:
                    t__ = t_
                        
                    df_[ss_][t__] = (cargo_to_load_, df_['IncMax'][t__][1] + (time_-time_incmax_)*staggering_rate_['LoadingRateM3Min'][t__])
                
                time_ += time_interval_
                stage_ += 1
            
            next_time_ = time_
            time_ = topping_start_
            ss_ = 'MaxLoading' + str(stage_)
            just_before_topping_ = ss_
            df_[ss_] = df_['IncMax']
            df_[ss_]['Time'] = int(time_)
            for t_ in self.info['cargo_tank'][cargo_to_load_]:
                t__ = t_
                    
                df_[ss_][t__] = (cargo_to_load_, df_['IncMax'][t__][1] + (time_-time_incmax_)*staggering_rate_['LoadingRateM3Min'][t__])
           
            
            last_loading_max_rate_stage_ = ss_
            stages_['loadingAtMaxRate'] = (df_['IncMax']['Time'], df_[ss_]['Time'])
            
            # last max stage before topping
            if p__+1 < len(self.info['loading_order']):
                ballast_.append((int(df_[ss_]['Time']),ss_))
                ballast_stop_.append((int(df_[ss_]['Time']),ss_))
                
            
            next_ballast_ = (None,None,10000)  # time; stage; relative to interval
            final_ballast_ = (None, None)
            for c_ in range(1,num_staggering_+1):
                # print(c_)
                ss_ = 'Topping' + str(c_)
                df_[ss_] = df_[df_.columns[-1]]
                df_[ss_]['Time'] += 15
                
                final_ballast_ = (int(df_[ss_]['Time']),ss_)
                
                if abs(df_[ss_]['Time']-next_time_) < next_ballast_[-1]:
                    next_ballast_ = (int(df_[ss_]['Time']),ss_,int(abs(df_[ss_]['Time']-next_time_)))
                    
                
                for t_ in self.info['cargo_tank'][cargo_to_load_]:
                    t__ = t_
                    rate_ = 0 if staggering_rate_[c_][t__] == None else staggering_rate_[c_][t__]
                    vol_ = rate_/4
                   
                    df_[ss_][t__] = (cargo_to_load_, df_[ss_][t__][1] + vol_)  
                    
            stages_['topping'] = (df_[last_loading_max_rate_stage_]['Time'], df_[ss_]['Time'])
                    
            if next_ballast_ not in [(None,None,10000)]:
                ballast_.append((next_ballast_[0],next_ballast_[1]))    
                
            if (final_ballast_[0],final_ballast_[1]) not in ballast_:
                ballast_.append((final_ballast_[0],final_ballast_[1]))    
                
                    
            self.seq[cargo_to_load_]['gantt'] = df_        
            self.seq[cargo_to_load_]['ballast'] = list(ballast_) # need to get ballast for these stages
            self.seq[cargo_to_load_]['toppingStart'] = int(topping_start_) # time when topping starts
            self.seq[cargo_to_load_]['beforeTopping'] = before_topping_ # 2nd last stage before topping
            self.seq[cargo_to_load_]['justBeforeTopping'] = just_before_topping_ # last stage before topping
            self.seq[cargo_to_load_]['stageInterval'] = stages_ # time duration for each stage
            self.seq[cargo_to_load_]['startTime'] = start_time_ # time duration for each stage
            self.seq[cargo_to_load_]['ballastStop'] = list(ballast_stop_) # need to get ballast for these stages
            self.seq[cargo_to_load_]['lastStage'] = ss_
            self.seq[cargo_to_load_]['loadingRateM3Min'] = staggering_rate_['LoadingRateM3Min'] 
            
            
            start_time_ = df_[ss_]['Time']
            
            

            
            # print(df_)
                
            
    def _get_ballast_requirements(self):
        # main deballast/ballast , eduction finished 1 hrs before topping 
        # eduction take 2 hr
        
        density_ = self.info['density']
        num_port_ = 0
        fixed_ballast_ = []
        same_ballast_ = []
        stages_ = []
        ## for single cargo ... 
        for c__,c_ in enumerate(self.info['loading_order']):
            df_ = self.seq[c_]['gantt']
            df_ = df_.append(pd.DataFrame(index=INDEX1))

            # initial
            if c__ == 0: # first cargo to load
                fixed_ballast_ = ['Initial1']
                for k_, v_ in self.info['ballast'][0].items():
                    df_['Initial'][k_] = v_[0]['quantityMT']
                
            # topping last cargo topping
            if c__ ==  len(self.info['loading_order']) - 1:
                
                # time for educting for last cargo
                # if interval < 2hrs more time might be needed
                time_ = df_[self.seq[c_]['justBeforeTopping']]['Time'] - df_[self.seq[c_]['beforeTopping']]['Time']
                if time_ < TIME_EDUCTING:
                    fixed_ballast_.append(self.seq[c_]['beforeTopping']+str(c__+1))
                    for k_, v_ in self.info['ballast'][-1].items():
                        df_[self.seq[c_]['beforeTopping']][k_] = v_[0]['quantityMT']
                        
                fixed_ballast_.append(self.seq[c_]['justBeforeTopping']+str(c__+1))
                for k_, v_ in self.info['ballast'][-1].items():
                    df_[self.seq[c_]['justBeforeTopping']][k_] = v_[0]['quantityMT']
                
                
            # get loading info        
            ddf_ = pd.DataFrame(index=INDEX)
            
            if c__ == 0:
                col_ = 'Initial' + str(c__+1)
                ddf_[col_] = df_['Initial']
            
            ddf_ = ddf_.append(pd.DataFrame(index=['Weight']))
            
            for b__,b_ in enumerate(self.seq[c_]['ballast']):
                if b__ > 0:
                    num_port_ += 1
                    stages_.append(b_[1]+str(c__+1))
                    wt_ = 0
                    col_ = b_[1] + str(c__+1)
                    ddf_[col_] = None
                    ddf_[col_]['Time'] = b_[0] + self.seq[c_]['startTime']
                    pre_col_ = self.seq[c_]['ballast'][b__-1][1]
                    
                    if b_  in self.seq[c_]['ballastStop']:
                        same_ballast_.append(num_port_)
                      
                    for h_, (i_,j_) in enumerate(self.seq[c_]['gantt'][b_[1]].iteritems()): 
                        # print(i_, j_)
                        if i_ not in ['Time'] and j_ not in [None]:
                            # print(i_,j_) # j_ = curr (cargo, vol)
                            pre_ = self.seq[c_]['gantt'][pre_col_][i_]
                            #print(pre_, j_)
                            if  pre_ not in [None] and pre_[0] == c_:
                                ddf_[col_][i_] = (c_, j_[1] - pre_[1])
                                wt_ += round((j_[1] - pre_[1])*density_[c_],10)
                            elif j_[0] == c_:
                                ddf_[col_][i_] = (c_, j_[1])
                                wt_ += round(j_[1]*density_[c_],10)
                                
                    ddf_[col_]['Weight'] = wt_            
                    
                    
                          
            self.seq[c_]['loadingInfo'] = ddf_  # cargo in m3
            self.seq[c_]['fixBallast'] = fixed_ballast_
            
            # print(df_.columns)
            
            
            # self.seq[c_]['gantt'] = df_
        
        self.seq['numPort'] = num_port_
        self.seq['stages'] = stages_
        self.seq['sameBallast'] = same_ballast_
        
            
            
                
        
                    
    def _cal_staggering_rate(self, param, reduce = 1000):
    
        stages_ = {}
        for t__, t_ in enumerate(param['toppingSeq']):
            stages_[t__+1] = {}
            for s__, s_ in enumerate(range(t__,t__+20)):
                if s_+1 <= len(param['toppingSeq']):
                    for r_ in param['toppingSeq'][s_]:
                        if r_ in ['SLS', 'SLP']:
                            rate_ = param['slopTank']
                        elif r_[-1] == 'C':
                            rate_ = param['centerTank']
                        else:
                            rate_ = param['wingTank']
                        
                        stages_[t__+1][r_] = rate_
        
        df_ = pd.DataFrame(index=INDEX[1:])
        for k_, v_ in stages_.items():
            total_ = sum([v__ for k__,v__ in v_.items()])
            # print(k_, total_)
            maxRate_ = min(total_, param['maxShoreRate'])
            
            df_[k_] = None
            for k__,v__ in v_.items():
                stages_[k_][k__] = v__/total_*maxRate_
                
                df_[k_][k__] = stages_[k_][k__] 
            
            
        return df_        
               
                
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
        
        if required_rate == 1:
            flow_rate = self.vessel.info['loadingRate1']
        elif required_rate == 6:
            flow_rate = self.vessel.info['loadingRate6']
        
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

        for k_, v_ in components.items():
            rate_ = 0
            for i_, j_ in zip(v_[0], v_[1]):
                # print(i_,j_, param.get(i_,1), flow_rate[j_])
                if j_ in ['maxLoadingRate', 'maxRiser']:
                    # print(i_, j_, flow_rate[j_])
                    rate_ += flow_rate.get(j_, 20500)
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

                
    def _cal_density(self, api, temperature_F):
        
        ## https://www.myseatime.com/blog/detail/cargo-calculations-on-tankers-astm-tables
    
        a60 = 341.0957/(141360.198/(api+131.5))**2
        dt = temperature_F-60
        vcf_ = np.exp(-a60*dt*(1+0.8*a60*dt))
        t13_ = (535.1911/(api+131.5)-0.0046189)*0.42/10
        density = t13_*vcf_*6.2898
        
    
        return round(density,6)
    
                
                
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        