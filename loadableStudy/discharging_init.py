# -*- coding: utf-8 -*-
"""
Created on Thu Oct 14 21:48:53 2021

@author: phtan1
"""

from vlcc_vessel import Vessel
from discharging_operations import DischargingOperations
import numpy as np

class Process_input(object):
    def __init__(self, data):
        #
        self.vessel_json = {'vessel': data['vessel'],
                            'onBoard': {}, #data['loading']['onBoardQuantity'],
                            'onHand': data['discharging']['onHandQuantity'],
                            }
        
        #
        self.port_id   = data['discharging']['portId']
        self.port_json = {'portDetails': data['discharging']['dischargeInformation']['berthDetails']['selectedBerths'][0]}
        
        self.discharge1_json = {'planDetails': [p_ for p_ in data['discharging']['planPortWiseDetails'] if p_['portId'] == self.port_id][0]
                              }
        
        self.discharge_json = {'planDetails': []}
        for p__, p_ in enumerate(data['discharging']['planPortWiseDetails']):
            if p_['portId'] == self.port_id:
                self.discharge_json['planDetails'] = p_
                # self.first_discharge_port = True if p__ == 0 else False
                
                
        #
        self.discharging_info_json = {'trimAllowed':data['discharging']['dischargeInformation']["dischargeDetails"]["trimAllowed"],
                                  "dischargingRates":data['discharging']['dischargeInformation']["dischargeRates"],
                                  "dischargingStages":data['discharging']['dischargeInformation']["dischargeStages"],
                                  "dischargingSequences":data['discharging']['dischargeInformation']["dischargeSequences"],
                                  "dischargeQuantityCargoDetails":data['discharging']['dischargeInformation']["dischargeQuantityCargoDetails"],
                                  "dischargeMachinesInUses":data['discharging']['dischargeInformation']["machineryInUses"]["machinesInUses"]
                                  }
        
        # self.discharging_information = {"loadingRates":data['discharging']['loadingInformation']["loadingRates"],
        #                             "berthDetails":data['discharging']['loadingInformation']['berthDetails'],
        #                             "loadingSequences":data['discharging']['loadingInformation']["loadingSequences"],
        #                             "machineryInUses":data['discharging']['loadingInformation']["machineryInUses"]
        #                             }
        
        self.config = data['config']
        self.error = {}
        self.solver = self.config['solver'] #_SOLVER_ ## config
        
        self.vessel_id   = int(data['discharging']['vesselId'])
        self.process_id = data['processId']
        self.information_id = data['discharging']['infoId']
        
        self.module = 'DISCHARGING'
        self.has_loadicator = self.vessel_json['vessel']['vessel'].get('hasLoadicator',False)
        
        self.max_draft = self.port_json['portDetails']['seaDraftLimitation'] ## or 'maxShipDepth'
        self.max_draft = 30.0 if self.max_draft in [None] else self.max_draft
        self.max_airdraft = self.port_json['portDetails'].get('airDraftLimitation', None)
        self.max_airdraft = 100.0 if self.max_airdraft in [None] else self.max_airdraft
        self.mode = ""
        
        
    def prepare_data(self):
        
        self.error = {}
        
        self.vessel = Vessel(self, loading=True)
        self.vessel.info['onboard'] = {}
        # self.vessel._get_onhand(self) # ROB
        # self.vessel._get_onboard(self, loading = True) # Arrival condition
        
        self.discharging = DischargingOperations(self)
        
        if not self.discharging.error:
            self.discharging._gen_stripping()
            self.discharging._get_ballast_requirements()
            self.get_param()
        else:
            self.error = {**self.error, **self.discharging.error}
        
    def get_param(self):
        
        self.limits = {}
        self.limits['draft'] = {}
        self.limits['draft']['loadline'] = 100
        self.limits['draft']['maxDraft'] =  100
        self.limits['maxAirDraft'] = 100
        
        self.seawater_density = 1.025 ## self.loading.seawater_density  ##           
        # self.ballast_percent = 0.4 # round(7000/self.loading.staggering_param['maxShoreRate'],3)-0.001  #0.4
        
        self.info = self.discharging.info
        
        cargo_info = self.discharging.info
        self.loadable = lambda: None
        setattr(self.loadable, 'info', {})
        self.loadable.info['parcel'] = {c_:{}  for c_ in cargo_info['pre_cargo']}
        # self.loadable.info['lastVirtualPort'] = len(cargo_info['discharging_order'])
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
        self.loadable.info['cargoOrderTank'] = {}
        
        
        self.trim_upper, self.trim_lower  = {}, {}
        
        # port_ = 0
        density_ = cargo_info['density']
        
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
                
        self.loadable.info['stages'], self.loadable.info['stageTimes'] = {}, {}
        self.loadable.info['toLoadPort'] = {0:round(wt_,1)} ###
        
        port_ = 0
        for c__, c_ in enumerate(cargo_info['discharging_order']):
            
            # last_cargo_ = True if c__+1 == len(self.loading.info['loading_order']) else False
            cargo_ = cargo_info['dsCargoNominationId'][c_]
            c1_ = cargo_+str(c__)
            
            self.loadable.info['toLoadCargoTank'][c__+1] = {}
            self.loadable.info['toLoadCargoTank'][c__+1][cargo_] = {}
            
            self.loadable.info['cargoOrderTank'][c1_] = []
            
            if cargo_ not in  self.loadable.info['operation'].keys():
                self.loadable.info['operation'][cargo_] = {}
                self.loadable.info['toLoad'][cargo_] = 0.0
                self.loadable.info['preloadOperation'][cargo_] = {t_:{}  for t_ in self.vessel.info['cargoTanks']}
                # self.loadable.info['toLoadCargoTank'][cargo_] = {} #{t_:0.  for t_ in self.vessel.info['cargoTanks']}
            
            # wt_ = 0.
            # strip_ = False
            # if c_ not in cargo_info['multiDischarge']:
                # single discharge stage for this cargo
                
            last_ = self.discharging.seq[c1_]['lastStage']    
            for e_ in  self.discharging.seq[c1_]['gantt'][last_].iteritems():
                if e_[0] not in ['Time', 'Weight'] and e_[1][0] == cargo_:
                    self.loadable.info['toLoadCargoTank'][c__+1][cargo_][e_[0]] = round(e_[1][1]*density_[cargo_],1)
                    
                
            toLoadTank_ = {t_:0.  for t_ in self.vessel.info['cargoTanks']}
            for e_ in  self.discharging.seq[c1_]['gantt']['Initial'].iteritems():
                if e_[0] not in ['Time', 'Weight'] and e_[1][0] == cargo_:
                    toLoadTank_[e_[0]] = round(e_[1][1]*density_[cargo_],1) 
            
            
            for d_ in  self.discharging.seq[c1_]['loadingInfo']: # for each column
            
                if self.discharging.seq[c1_]['loadingInfo'][d_]['Weight'] not in [None, np.nan]:
                    port_ += 1
                    wt_ = round(self.discharging.seq[c1_]['loadingInfo'][d_]['Weight'],1) 
                    self.loadable.info['operation'][cargo_][port_] = 0        
                    # print(port_,self.plans.seq[c_]['loadingInfo'][d_]['Weight'])
                    self.loadable.info['toLoadPort'][port_] = round(wt_ + self.loadable.info['toLoadPort'][port_-1],1)  ## accumulated at each port
                    
                    self.loadable.info['toLoadPort1'][port_] = wt_       ## at each port
                    self.loadable.info['stages'][port_] = d_
                    self.loadable.info['stageTimes'][port_] = self.discharging.seq[c1_]['loadingInfo'][d_]['Time']
                    
                    for e_ in self.discharging.seq[c1_]['loadingInfo'][d_].iteritems():
                        # print(e_)
                        if e_[1] not in [None] and e_[0] not in ['Time', 'Weight']:
                            # print(e_)
                            
                            # amt move
                            wt_ = round(e_[1][1]*density_[cargo_],1)
                            # tank
                            t1_ = e_[0]
                            # new amt left
                            final_wt_t1_ = round(wt_ + toLoadTank_[t1_],1)
                            # diff
                            diff1_ = (final_wt_t1_-self.loadable.info['toLoadCargoTank'][c__+1][cargo_][t1_])
                            
                            if t1_ not in self.loadable.info['cargoOrderTank'][c1_] and wt_ != 0:
                                self.loadable.info['cargoOrderTank'][c1_].append(t1_)
                            
                            # print(t1_, final_wt_t1_, final_wt_t1_/density_[cargo_])
                            # print(diff1_)
                            if (diff1_ >= 1):
                                # normal 
                                self.loadable.info['preloadOperation'][cargo_][t1_][port_] = wt_
                            
                                self.loadable.info['toLoad'][cargo_] += wt_
                                
                                self.loadable.info['operation'][cargo_][port_] += wt_
                                toLoadTank_[e_[0]] += wt_
                            else:
                                # print(t1_, final_wt_t1_, final_wt_t1_/density_[cargo_], diff1_)
                                # print('round')
                                wt1_ = self.loadable.info['toLoadCargoTank'][c__+1][cargo_][t1_] - toLoadTank_[t1_]
                                
                                self.loadable.info['preloadOperation'][cargo_][t1_][port_] = wt1_
                                self.loadable.info['toLoad'][cargo_] += wt1_
                                toLoadTank_[t1_] += wt1_ # amt left
                                self.loadable.info['operation'][cargo_][port_] += wt1_
                                    # print('--', t1_, toLoadTank_[t1_])
                    
                    strip_ = len(cargo_info['stripping_tanks'][c__+1]) > 1  
                    self.loadable.info['operation'][cargo_][port_] = round(self.loadable.info['operation'][cargo_][port_],1)
                    # print('DOne')            
                    if not strip_:
                        self.trim_lower[str(port_)] = 3.0
                        self.trim_upper[str(port_)] = 4.0
                    else:
                        self.trim_lower[str(port_)] = 4.0
                        self.trim_upper[str(port_)] = 5.0
                
            
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
                    self.loadable.info['ballastOperation'][k_] = {str(port_):v_[0]['quantityMT']}
                else:
                    self.loadable.info['ballastOperation'][k_][str(port_)] = v_[0]['quantityMT']
            
        self.loadable.info['fixedBallastPort'] = ['0', str(port_)]            
        self.loadable.info['lastVirtualPort']  = port_            
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
   
        # self.loadable.info['fixCargoPort'] = [str(port_-1)]
        # self.loadable.info['fixCargoPortAmt'] = {}
        # for k_, v_ in final_plan.items():
        #     if v_[0]['cargo'] not in self.loadable.info['fixCargoPortAmt']:
        #         self.loadable.info['fixCargoPortAmt'][v_[0]['cargo']] = {}
        #         self.loadable.info['fixCargoPortAmt'][v_[0]['cargo']][k_] = {str(port_-1): v_[0]['quantityMT']}
                
        #     else:
        #         self.loadable.info['fixCargoPortAmt'][v_[0]['cargo']][k_] = {str(port_-1): v_[0]['quantityMT']}
                
        
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
       
        
        
    def write_ampl(self, file = 'input_discharging.dat', IIS = True):
        
        if not self.error and self.solver in ['AMPL']:
            
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
                # for k_ in self.info['multiDischarge']:
                #     str1 += self.info['dsCargoNominationId'][k_] + ' '
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
                            if v2_ not in [{}, 0]:
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
                # print(str1, file=text_file) 
                # for k_, v_ in self.loadable.info['fixCargoPortAmt'].items():
                #     for k1_, v1_ in v_.items():
                #         for k2_, v2_ in v1_.items():
                #             if v2_ not in [{}, 0]:
                #                 str1 = k_ + ' ' +  ' ' + str(k1_) + ' ' + str(k2_) + ' ' + "{:.1f}".format(v2_) 
                #                 print(str1, file=text_file)
                print(';', file=text_file)
    
                print('# fixCargoPort',file=text_file)#  ##
                # str1 = 'set fixCargoPort := '  # to virtual ports
                # for k_ in self.loadable.info['fixCargoPort']:
                #     str1 += ' ' + str(k_)
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
                # for k_ in self.info['portOpt']:
                #     str1 += str(k_) + ' '
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
                for i_, j_ in self.discharging.info['ROB'][1].items(): ##
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
                for k_, v_ in self.discharging.info['ballast'][0].items():
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
                    
                
                str1 = 'set C_equal := '  
                # if len(self.loadable.info['parcel']) == 1:
                #     str1 += list(self.loadable.info['parcel'].keys())[0]
                print(str1+';', file=text_file) 
                
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
                for i_, j_ in self.discharging.info['ROB'][1].items():
                    str1 = '['+ i_ + ',*] = '
                    for p_ in range(1,self.loadable.info['lastVirtualPort']+1):
                        str1 += str(p_) + ' ' + "{:.4f}".format(j_[0]['tcg']) + ' '
                            
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                print('# LCGs for others tanks', file=text_file) ##
                str1 = 'param LCGtp := '
                print(str1, file=text_file)
                for i_, j_ in self.discharging.info['ROB'][1].items():
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        