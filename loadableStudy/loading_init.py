# -*- coding: utf-8 -*-
"""
Created on Wed Jul 14 17:08:08 2021

@author: I2R
"""
from vlcc_vessel import Vessel
from loading_operations import LoadingOperations

import numpy as np

_SOLVER_ = 'AMPL' # AMPL or ORTOOLS



class Process_input(object):
    def __init__(self, data):
        
        #
        self.vessel_json = {'vessel': data['vessel'],
                            'onBoard': {}, #data['loading']['onBoardQuantity'],
                            'onHand': data['loading']['onHandQuantity'],
                            }
        #
        self.port_id   = data['loading']['portId']
        self.port_rotation_id = data['loading']['portRotationId']
        self.port_json = {'portDetails': data['loading']['loadingInformation']['berthDetails']}
        
        self.loadable1_json = {'planDetails': [p_ for p_ in data['loading']['loadablePlanPortWiseDetails'] if p_['portRotationId'] == self.port_rotation_id][0]
                              }
        
        self.loadable_json = {'planDetails': []}
        for p__, p_ in enumerate(data['loading']['loadablePlanPortWiseDetails']):
            if p_['portRotationId'] == self.port_rotation_id:
                self.loadable_json['planDetails'] = p_
                
                if len(p_['arrivalCondition']['loadablePlanStowageDetails']) == 0:
                    self.first_loading_port = True 
                else:
                    self.first_loading_port = False 
                
                break
            
        print('first_loading_port :',   self.first_loading_port)              
    
    
        
        
        #
        self.loading_info_json = {'trimAllowed':data['loading']['loadingInformation']["loadingDetails"]["trimAllowed"],
                                  "loadingRates":data['loading']['loadingInformation']["loadingRates"],
                                  "loadingStages":data['loading']['loadingInformation']["loadingStages"],
                                  "loadingSequences":data['loading']['loadingInformation']["loadingSequences"],
                                  "toppingOffSequence":data['loading']['loadingInformation']["toppingOffSequence"],
                                  "loadableQuantityCargoDetails":data['loading']['loadingInformation']["loadableQuantityCargoDetails"],
                                  "loadingMachinesInUses":data['loading']['loadingInformation']["machineryInUses"]["loadingMachinesInUses"]
                                  }
        
        self.loading_information = data['loading']['loadingInformation']
        
        
        self.config = data['config']
        self.error = {}
        self.solver = self.config['solver'] #_SOLVER_ ## config
        
        self.vessel_id   = data['loading']['vesselId']
        self.port_code  = data['loading'].get('portCode', "")
        self.process_id = data['processId']
        self.information_id = data['loading']['loadingInformation']['loadingInfoId']
        
        self.module = 'LOADING'
        self.has_loadicator = self.vessel_json['vessel']['vessel'].get('hasLoadicator',False)
        
        self.max_draft = data['loading']['loadingInformation']['berthDetails'][0].get('maxDraft', None)
        self.max_draft = 30.0 if self.max_draft in [None] else self.max_draft
        self.max_airdraft = data['loading']['loadingInformation']['berthDetails'][0].get('airDraftLimitation', None)
        self.max_airdraft = 100.0 if self.max_airdraft in [None] else self.max_airdraft
        self.mode = ""
        

    def prepare_data(self):
        
        self.error = {}
        
        self.vessel = Vessel(self, loading=True)
        #self.vessel._get_onhand(self) # ROB
        self.vessel._get_onboard(self, loading = True) # Arrival condition
        
        
        self.loading = LoadingOperations(self)
        self.loading._gen_topping()
        
        if not self.loading.error:
            self.loading._get_ballast_requirements()
            self.get_param()
        else:
            self.error = {**self.error, **self.loading.error}
        
    def get_param(self, base_draft = None, min_int_trim = 0.96, max_int_trim = 1.1):
        
        
        self.limits = {}
        self.limits['draft'] = {}
        self.limits['draft']['loadline'] = 100
        self.limits['draft']['maxDraft'] =  self.max_draft 
        self.limits['maxAirDraft'] = self.max_airdraft
        #self.limits['sfbm'] = self.sf_bm_frac
        #self.limits['feedback'] = {'feedbackLoop': self.feedbackLoop,'feedbackLoopCount':self.feedbackLoopCount}
       
        
        self.seawater_density = self.loading.seawater_density  ##           
        self.deballast_percent = round(7000/self.loading.staggering_param['maxShoreRate'],3)-0.001  #0.4
        
        self.loadable = {}
        self.loadable['parcel'] = {c_:{}  for c_ in self.loading.preloaded_cargos + self.loading.info['loading_order']}
        self.loadable['lastVirtualPort'] = self.loading.seq['numPort']
        for k_, v_ in self.loading.info['density'].items():
            self.loadable['parcel'][k_]['mintempSG'] = v_
            self.loadable['parcel'][k_]['maxtempSG'] = v_
            
        for k_, v_ in self.loading.info['api'].items():
            self.loadable['parcel'][k_]['api'] = v_
        
        for k_, v_ in self.loading.info['temperature'].items():
            self.loadable['parcel'][k_]['temperature'] = v_
        
        self.loadable['operation'], self.loadable['toLoadPort1'] = {},{}
        self.loadable['toLoad'] = {}
        self.loadable['toLoadCargoTank'] = {}
        self.loadable['manualOperation'] = {} # cargo tank port amount
        self.loadable['preloadOperation'] = {} # cargo tank port amount
        
        self.loadable['ballastOperation'] = {t_:{}  for t_ in self.vessel.info['ballastTanks'] if t_ not in self.vessel.info['banBallast']} # tank port amount
        self.loadable['fixedBallastPort'] = []
        self.trim_upper, self.trim_lower  = {}, {}
        
        port_ = 0
        density_ = self.loading.info['density']
        
        # preloaded cargo
        #first_cargo_ = self.loading.info['loading_order'][0]
        wt_ = 0
        for k_, v_ in self.loading.info['cargo_plans'][0].items():
            # print(k_, v_)
            
            cargo_ = v_[0]['cargo']
            if cargo_ not in self.loadable['preloadOperation']:
                self.loadable['preloadOperation'][cargo_] = {}
            
            self.loadable['preloadOperation'][cargo_][k_] = v_[0]['quantityMT']
            wt_ += v_[0]['quantityMT']
            
            if len(v_) > 1:
                cargo_ = v_[1]['cargo']
                if cargo_ not in self.loadable['preloadOperation']:
                    self.loadable['preloadOperation'][cargo_] = {}
                
                self.loadable['preloadOperation'][cargo_][k_] = v_[1]['quantityMT']
                wt_ += v_[1]['quantityMT']
                
            
        
        self.loadable['stages'], self.loadable['stageTimes'] = {}, {}
        self.loadable['toLoadPort'] = {0:round(wt_,1)} ###
        
        zero_ballast_ = []
        for c__, c_ in enumerate(self.loading.info['loading_order']):
            last_cargo_ = True if c__+1 == len(self.loading.info['loading_order']) else False
            
            self.loadable['operation'][c_] = {}
            self.loadable['toLoad'][c_] = 0.0
            self.loadable['manualOperation'][c_] = {t_:{}  for t_ in self.vessel.info['cargoTanks']}
            self.loadable['toLoadCargoTank'][c_] = {} #{t_:0.  for t_ in self.vessel.info['cargoTanks']}
            
            for k_, v_ in  self.loading.info['cargo_plans'][-1].items():
                if v_[0]['cargo'] == c_:
                    self.loadable['toLoadCargoTank'][c_][k_] = v_[0]['quantityMT']
                elif len(v_) == 2 and v_[1]['cargo'] == c_:
                    self.loadable['toLoadCargoTank'][c_][k_] = v_[1]['quantityMT']
                    
            toLoadTank_ = {t_:0.  for t_ in self.vessel.info['cargoTanks']}
            
            
            for d_ in self.loading.seq[c_]['loadingInfo']: # for each column
                
                if self.loading.seq[c_]['loadingInfo'][d_]['Weight'] not in [None, np.nan]:
                    port_ += 1
                    wt_ = round(self.loading.seq[c_]['loadingInfo'][d_]['Weight'],1) 
                    self.loadable['operation'][c_][port_] = wt_        
                    # print(port_,self.plans.seq[c_]['loadingInfo'][d_]['Weight'])
                    self.loadable['toLoadPort'][port_] = wt_ + self.loadable['toLoadPort'][port_-1]  ## accumulated at each port
                    
                    self.loadable['toLoadPort1'][port_] = wt_       ## at each port
                    self.loadable['stages'][port_] = d_
                    self.loadable['stageTimes'][port_] = self.loading.seq[c_]['loadingInfo'][d_]['Time']
                    
                    for e_ in self.loading.seq[c_]['loadingInfo'][d_].iteritems():
                        # print(e_)
                        if e_[1] not in [None] and e_[0] not in ['Time', 'Weight']:
                            # print(e_)
                            if e_[0][-1] not in ['W']:
                                wt_ = round(e_[1][1]*density_[c_],1)
                                
                                t1_ = e_[0]
                                final_wt_t1_ = round(wt_ + toLoadTank_[t1_],1)
                                diff1_ = (final_wt_t1_-self.loadable['toLoadCargoTank'][c_][t1_])
                                
                                # print(t1_, final_wt_t1_, diff1_)
                                
                                if (diff1_ <= -1):
                                    self.loadable['manualOperation'][c_][t1_][port_] = wt_
                                
                                    self.loadable['toLoad'][c_] += wt_
                                    toLoadTank_[e_[0]] += wt_
                                else:
                                    wt1_ = self.loadable['toLoadCargoTank'][c_][t1_] - toLoadTank_[t1_]
                                    
                                    self.loadable['manualOperation'][c_][t1_][port_] = wt1_
                                    
                                    self.loadable['toLoad'][c_] += wt1_
                                    
                                    toLoadTank_[t1_] += wt1_
                                    # print('--', t1_, toLoadTank_[t1_])
                                    
                                
                            else:
                                t1_, t2_ = e_[0][:-1]+'P', e_[0][:-1]+'S'
                                wt_ = round(e_[1][1]*density_[c_]/2,1)
                                
                                final_wt_t1_ = round(wt_ + toLoadTank_[t1_],1)
                                final_wt_t2_ = round(wt_ + toLoadTank_[t2_],1)
                                
                                diff1_ = (final_wt_t1_-self.loadable['toLoadCargoTank'][c_][t1_])
                                diff2_ = (final_wt_t2_-self.loadable['toLoadCargoTank'][c_][t2_])
                                
                                # print(t1_,t2_, final_wt_t1_,final_wt_t2_)
                                
                                if (diff1_ <= -1 and diff2_ <= -1):
                                    
                                    self.loadable['manualOperation'][c_][t1_][port_] = wt_
                                    self.loadable['manualOperation'][c_][t2_][port_] = wt_
                                    
                                    self.loadable['toLoad'][c_] += (2*wt_)
                                    
                                    toLoadTank_[t1_] += wt_
                                    toLoadTank_[t2_] += wt_
                                    
                                else:
                                    
                                    wt1_ = self.loadable['toLoadCargoTank'][c_][t1_] - toLoadTank_[t1_]
                                    wt2_ = self.loadable['toLoadCargoTank'][c_][t2_] - toLoadTank_[t2_]
                                                                     
                                    self.loadable['manualOperation'][c_][t1_][port_] = wt1_
                                    self.loadable['manualOperation'][c_][t2_][port_] = wt2_
                                    
                                    self.loadable['toLoad'][c_] += (wt1_ + wt2_)
                                    
                                    toLoadTank_[t1_] += wt1_
                                    toLoadTank_[t2_] += wt2_
                                    # print('--', t1_, toLoadTank_[t1_], t2_, toLoadTank_[t2_])
                                    
                                    # exit()
                
                # for single cargo loading only                
                # if len(self.loading.info['loading_order']) > 1:
                #     exit()
                
                max_trim_ = self.loading_info_json['trimAllowed']['maximumTrim']
                max_trim_ = max_trim_ if max_trim_ not in [None] else 3.0
                
                top_trim_ = self.loading_info_json['trimAllowed']['finalTrim']
                top_trim_ = top_trim_ if top_trim_ not in [None] else 1.0
                
                
                
                if d_ in self.loading.seq[c_]['fixBallast'] or (last_cargo_ and  d_[0:3] in ['Top']) or d_ in self.loading.seq[c_]['initBallast']:
                    # print(d_)
                    self.loadable['fixedBallastPort'].append(str(port_))
                    if d_ in ['Initial1'] or d_ in self.loading.seq[c_]['initBallast']:
                        print(d_, 'arrival ballast')
                        zero_ballast_.append(port_)
                        for k_, v_ in self.loading.info['ballast'][0].items():
                            self.loadable['ballastOperation'][k_][str(port_)] = v_[0]['quantityMT']
                            
                    else:
                        print(d_, 'departure ballast')
                        zero_ballast_.append(port_)
                        for k_, v_ in self.loading.info['ballast'][-1].items():
                            self.loadable['ballastOperation'][k_][str(port_)] = v_[0]['quantityMT']
                        
                if not last_cargo_ and d_ in [self.loading.seq[c_]['justBeforeTopping'] + str(c__+1)]:
                    a_, b_ = min(max_trim_, top_trim_), 0.05
                    print(d_,'justBeforeTopping trim -- constraint:', b_, a_)
                    self.trim_upper[str(port_)] = a_
                    self.trim_lower[str(port_)] = b_
                    
                elif not last_cargo_ and d_ in [self.loading.seq[c_]['lastStage'] + str(c__+1)]:
                    a_, b_ = max_int_trim, min_int_trim
                    print(d_,'last intermeditate stage -- trim constraint:', b_, a_)
                    self.trim_upper[str(port_)] =  a_
                    self.trim_lower[str(port_)] =  b_
                    
                elif  d_[0:3] in ['Max']:
                    a_, b_ = max_trim_, 0.05
                    print(d_,'Max loading -- trim constraint:', b_, a_)
                    self.trim_upper[str(port_)] =  a_
                    self.trim_lower[str(port_)] =  b_
                    
        
        self.LCGport = {t_:{} for t_ in self.vessel.info['cargoTanks']}
        
        for s__, s_ in enumerate(self.loading.seq['stages']):
            loading_cargo_ = self.loading.info['loading_order'][int(s_[-1])-1]
            stage_ = s_[:-1]
            # print(s__+1, self.loading.info["cargo_tank"][loading_cargo_])
            for i_, r_ in self.loading.seq[loading_cargo_]['gantt'][stage_].items():
                if i_ not in ["Time"] and r_ not in [None]:
                    if len(r_) == 2:
                        tank_, vol_ = i_, r_[1]
                        # print(tank_, vol_)
                        if tank_[-1] == 'W':
                            tank_ = tank_[0] + 'P'
                            if tank_ in self.vessel.info['tankLCG']['lcg']:
                                lcg_ = np.interp(vol_, self.vessel.info['tankLCG']['lcg'][tank_]['vol'],
                                                     self.vessel.info['tankLCG']['lcg'][tank_]['lcg'])
                                
                                self.LCGport[tank_[0] + 'P'][s__+1] = round(lcg_,4)
                                self.LCGport[tank_[0] + 'S'][s__+1] = round(lcg_,4)
                          
                        else:
                                
                            if tank_ in self.vessel.info['tankLCG']['lcg']:
                                lcg_ = np.interp(vol_, self.vessel.info['tankLCG']['lcg'][tank_]['vol'],
                                                     self.vessel.info['tankLCG']['lcg'][tank_]['lcg'])
                                self.LCGport[tank_][s__+1] = round(lcg_,4)
                          
                        
                    else:
                        tank_, vol_ = i_, r_[1] + r_[3]
                        # print(tank_, vol_)
                        if tank_ in self.vessel.info['tankLCG']['lcg']:
                            lcg_ = np.interp(vol_, self.vessel.info['tankLCG']['lcg'][tank_]['vol'],
                                                 self.vessel.info['tankLCG']['lcg'][tank_]['lcg'])
                            self.LCGport[tank_][s__+1] = round(lcg_,4)
                          
                    
            
          
            
        self.vessel.info['incInitBallast'] = []
        self.vessel.info['decInitBallast'] = []
        
        for t_ in self.vessel.info['ballastTanks']:
            # print(t_)
            if t_ not in self.vessel.info['banBallast']:
                # print(t_)
                in_ = self.loading.info['ballast'][0].get(t_, [{}])[0].get('quantityMT', 0.)
                out_ = self.loading.info['ballast'][-1].get(t_, [{}])[0].get('quantityMT', 0.)
                
                if float(out_) >= float(in_):
                    self.vessel.info['incInitBallast'].append(t_)
                else:
                    self.vessel.info['decInitBallast'].append(t_)
                
            
        lightweight_ = self.vessel.info['lightweight']['weight']
        max_deadweight_ = 1e6 #self.vessel.info['draftCondition']['deadweight']
        
        cont_weight_ = self.vessel.info['deadweightConst']['weight'] # + self.vessel.info['onboard']['totalWeight']
        
        misc_weight_ = sum([v_[0]['quantityMT'] for k_,v_ in self.loading.info['ROB'][1].items()])
        
        ballast_ = sum([v_[0]['quantityMT']  for k_, v_ in self.loading.info['ballast'][0].items()])
        
        self.displacement_lower, self.displacement_upper = {}, {}
        self.base_draft = {}
        self.sf_base_value, self.sf_draft_corr, self.sf_trim_corr = {}, {}, {}
        self.bm_base_value, self.bm_draft_corr, self.bm_trim_corr = {}, {}, {}
        self.sf_bm_frac = self.config.get('sf_bm_frac', 0.95)  ##
        
        for p_ in range(1, self.loadable['lastVirtualPort']+1):  # exact to virtual
            # print(p_)
            
            cargo_to_load_ = self.loadable['toLoadPort1'][p_]
            
            if p_ not in zero_ballast_:
                ballast_ = max(0.,ballast_- self.deballast_percent*cargo_to_load_)
            
            cargo_weight_  = self.loadable['toLoadPort'][p_] #* 0.98
            
            # print(p_, cargo_weight_)
            
            est_deadweight_ = min(cont_weight_ + misc_weight_ + cargo_weight_ + ballast_, max_deadweight_)
            est_displacement_ = lightweight_ + est_deadweight_
            
            
            lower_displacement_limit_ = 120000
            # seawater_density_ = self.seawater_density
            est_displacement_ = max(lower_displacement_limit_, est_displacement_)  
            
            ## upper bound displacement
            # upper_draft_limit_ = min(loadline_, self.port.info['portRotation'][port_code_]['maxDraft']) - 0.001
            # upper_displacement_limit_ = np.interp(upper_draft_limit_, self.vessel.info['hydrostatic']['draft'], self.vessel.info['hydrostatic']['displacement'])
            ## correct displacement to port seawater density
            upper_displacement_limit_  = 1e6
            est_displacement_ = min(est_displacement_, upper_displacement_limit_)
            self.displacement_lower[str(p_)] = lower_displacement_limit_
            self.displacement_upper[str(p_)] = upper_displacement_limit_
            
            est_draft_ = np.interp(est_displacement_, self.vessel.info['hydrostatic']['displacement'], self.vessel.info['hydrostatic']['draft'])
            
            # base draft for BM and SF
            trim_ = 0.5*(self.trim_lower.get(str(p_),0.) + self.trim_upper.get(str(p_),0.))
            
            if self.vessel_id in [1]:
                base_draft__ = int(np.floor(est_draft_+trim_/2))
            elif self.vessel_id in [2]:
                base_draft__ = int(np.floor(est_draft_))
                
            base_draft_ = base_draft__ if p_  == 1 else max(base_draft__, self.base_draft[str(p_-1)])
            if base_draft:
                self.base_draft[str(p_)] = base_draft[str(p_)]
            else:
                self.base_draft[str(p_)] = base_draft_
            # print(p_,trim_,base_draft_)
            
            
            # self.base_draft ={'1': 11, '2': 13, '3': 13, '4': 17, '5': 19, '6': 19, '7': 9}
            
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
            
            
    
    def write_ampl(self, file = 'input_load.dat', listMOM = None, IIS = True, ave_trim = None):
        
        if not self.error and self.solver in ['AMPL']:
            
            slopP = [t_ for t_ in self.vessel.info['slopTank'] if t_[-1] == 'P'][0]
            slopS = [t_ for t_ in self.vessel.info['slopTank'] if t_[-1] == 'S'][0]
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
                
                str1 = 'set slopP := '
                str1 += slopP
                print(str1+';', file=text_file) 
                
                str1 = 'set slopS := '
                str1 += slopS
                print(str1+';', file=text_file) 
                ##
                print('# set of tanks compatible with cargo c',file=text_file)
                for i_,j_ in self.loadable['parcel'].items():
                    str1 = 'set Tc[' + str(i_) + '] := '
                    for j_ in cargo_tanks_:
                        if j_ not in self.vessel.info['banCargo'].get(i_,[]):
                            str1 += j_ + ' '
                    print(str1+';', file=text_file)
                    
                ## 
                print('# set of loaded tanks (preloaded condition)',file=text_file)
                preloaded_tanks_ = []
                str1 = 'set T_loaded:= '
                for k_, v_ in self.loadable['preloadOperation'].items():
                    for k1_, v1_ in v_.items():
                        if k1_ not in preloaded_tanks_:
                            str1 += k1_ + ' '
                            preloaded_tanks_.append(k1_)
                print(str1+';', file=text_file)
                
                ##
                print('# set of all cargoes',file=text_file)
                str1 = 'set C:= '
                for i_,j_ in self.loadable['parcel'].items():
                    str1 += i_ + ' '
                print(str1+';', file=text_file)
                
                print('# set of all loaded cargoes (partial loading condition)',file=text_file)
                str1 = 'set C_loaded:= '
                for k_, v_ in self.loadable['preloadOperation'].items():
                    str1 += k_ + ' '
                print(str1+';', file=text_file)
                
                print('# 1 if cargo c has been loaded in tank t (partial loading condition)',file=text_file)
                str1 = 'param I_loaded := '
                print(str1, file=text_file)
                for k_, v_ in self.loadable['preloadOperation'].items():
                    str1 = '[' + k_ + ', *] := '
                    for k1_, v1_ in v_.items():
                        str1 += k1_ + ' ' + '1 '
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                #            
                str1 = 'param W_loaded   := ' 
                print(str1, file=text_file) 
                # no discharging of the preloaded cargo
                
                # for k_, v_ in self.loadable['preloadOperation'].items():
                #     for k1_, v1_ in v_.items():
                #         str1 = k_ + ' ' + self.tanks.cargo_tanks[k1_]['tankName'] + ' ' + str(k1_) + ' ' + str(v1_)
                #         print(str1, file=text_file)
                print(';', file=text_file)
    
                #
                print('# weight of cargo c remained in tank t at initial state (before ship entering the first port)',file=text_file)#  
                str1 = 'param W0  := ' 
                print(str1, file=text_file) 
                for k_, v_ in self.loadable['preloadOperation'].items():
                    str1 = '[' + k_ + ', *] := '
                    for k1_, v1_ in v_.items():
                        str1 += k1_ + ' ' +  "{:.1f}".format(v1_) + ' ' 
                    print(str1, file=text_file)
                    
                print(';', file=text_file)
                
                ## 
                print('# total number of ports in the booking list',file=text_file)#   
                str1 = 'param NP := ' + str(self.loadable['lastVirtualPort']) # to virtual ports 
                print(str1+';', file=text_file)
                
                print('# the last loading port',file=text_file)#  
                str1 = 'param LP := ' + str(self.loadable['lastVirtualPort']) # to virtual ports
                print(str1+';', file=text_file)
    
                print('# cargo density @ low temperature (in t/m3)',file=text_file)#  
                str1 = 'param densityCargo_High  := ' 
                for i_,j_ in self.loadable['parcel'].items():
                    str1 +=  str(i_) + ' ' + "{:.6f}".format(j_['mintempSG'])  + ' '
                print(str1+';', file=text_file)
     
                print('# cargo density @ high temperature (in t/m3)',file=text_file)#  
                str1 = 'param densityCargo_Low  := ' 
                density_ = []
                for i_,j_ in self.loadable['parcel'].items():
                    density_.append(j_['maxtempSG'])
                    str1 +=  str(i_) + ' ' + "{:.6f}".format(j_['maxtempSG'])  + ' '
                print(str1+';', file=text_file)
    #           
                str1 = 'param aveCargoDensity  := ' 
                str1 += "{:.4f}".format(np.mean(density_))  + ' '
                print(str1+';', file=text_file)
                
                print('# weight (in metric tone) of cargo to be moved at port p',file=text_file)#  
                str1 = 'param Wcp  := ' 
                print(str1, file=text_file) 
                for i_, j_ in self.loadable['operation'].items():
                    str1 = '[' + str(i_) + ', *] := '
                    for k_,v_ in j_.items():
                        if int(k_) > 0:
                            str1 += str(k_) + ' ' + "{:.1f}".format(int(v_*10)/10) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                
                print('# loading ports',file=text_file)#  
                str1 = 'set loadPort  := ' 
                for i_, j_ in self.loadable['toLoadPort1'].items():
                    str1 += str(i_) + ' '
                print(str1+';', file=text_file)
                
                str1 = 'param loadingPortAmt  := ' 
                for i_, j_ in self.loadable['toLoadPort1'].items():
                    str1 += str(i_)  + ' ' +  "{:.1f}".format(int(j_*10)/10)  + ' '
                print(str1+';', file=text_file)
                
                print('# intended cargo to load',file=text_file)#  
                str1 = 'param toLoad  := ' 
                for i_, j_ in self.loadable['toLoad'].items():
                    str1 += i_ + ' ' +  "{:.1f}".format(j_)  + ' '
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
                for i_, j_ in self.vessel.info['onboard'].items():
                    if i_ not in ['totalWeight']:
                        str1 += i_ + ' ' +  "{:.3f}".format(j_['wt'])  + ' '
                print(str1+';', file=text_file)
                
                
                ##
                print('# locked tank',file=text_file)#   
                locked_tank_ = []
                str1 = 'set T_locked := ' 
                for k_, v_ in self.loadable['manualOperation'].items():
                    for k1_, v1_ in v_.items():
                        if k1_ not in locked_tank_ and len(v1_) > 0:
                            str1 += k1_ + ' ' 
                            locked_tank_.append(k1_)
                        
                                
                print(str1+';', file=text_file)
                
                print('# locked cargo',file=text_file)#  
                locked_cargo_= []
                str1 = 'set C_locked := ' 
                for k_, v_ in self.loadable['manualOperation'].items():
                    if k_ not in locked_cargo_:
                        str1 += k_ + ' '
                        locked_cargo_.append(k_)
                        
                print(str1+';', file=text_file)
                
                print('# 1 if tank t is locked for cargo c',file=text_file)#  
                str1 = 'param A_locked  := ' 
                print(str1, file=text_file) 
                for k_, v_ in self.loadable['manualOperation'].items():
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
                for k_, v_ in self.loadable['manualOperation'].items():
                    for k1_, v1_ in v_.items():
                        for k2_, v2_ in v1_.items():
                            # tank_ = self.vessel.info['tankId'][int(v2_['tankId'])]
                            
                            str1 = k_ + ' ' + k1_  + ' ' + str(k2_) + ' ' + "{:.1f}".format(v2_)
                            print(str1, file=text_file)
                print(';', file=text_file)
                
                
                str1 = 'param B_locked := '
                print(str1, file=text_file) 
                for k_, v_ in self.loadable['ballastOperation'].items():
                    tank_ = k_
                    str1 = '[' + tank_ + ', *] := '
                    for k__, v__ in v_.items():
                        if k__ not in ['0']:
                            # fill_ = v__/self.vessel.info['ballastTanks'][k_]['capacityCubm']/1.025
                            # if fill_ > 0.99 and int(k__) > 1:
                            #    print(k_, k__,  fill_, 0.99*self.vessel.info['ballastTanks'][k_]['capacityCubm']*1.025)
                            #    vv_ = 0.99*self.vessel.info['ballastTanks'][k_]['capacityCubm']*1.025
                            #    str1 += k__ + ' ' + "{:.3f}".format(int(vv_*100)/100) + ' '
                            # else:
                                str1 += k__ + ' ' + "{:.3f}".format(v__) + ' '
                    print(str1, file=text_file)
                print(';', file=text_file)  
                
                str1 = 'set fixBallastPort := '
                for k_ in self.loadable['fixedBallastPort']:
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
                for i_, j_ in self.loading.info['ROB'][1].items():
                    str1 = '['+ i_ + ',*] = '
                    for p_ in range(1,self.loadable['lastVirtualPort']+1):
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
                        str1 += i_ + ' ' + "{:.2f}".format(j_-0.1) + ' '
                      
                print(str1+';', file=text_file)
                
                str1 = 'set minTB := '
                for i_ in self.loading.info['eduction']:
                    if i_ not in  self.vessel.info['banBallast']:
                        str1 += i_ + ' '
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
                for p_ in range(1,self.loadable['lastVirtualPort']+1):
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
                
                
                print('# diff vol ',file=text_file)#
                str1 = 'param diffVol := 1' 
                print(str1+';', file=text_file)
                
                print('# deballast percent ',file=text_file)#
                str1 = 'param deballastPercent := ' + "{:.4f}".format(self.deballast_percent) 
                print(str1+';', file=text_file)
                
                
                print('# initial ballast ',file=text_file)#
                str1 = 'param initBallast := '
                for k_, v_ in self.loading.info['ballast'][0].items():
                    str1 += str(k_) + ' ' + "{:.3f}".format(v_[0]['quantityMT'])  + ' '
                print(str1+';', file=text_file)
                
                print('# inc initial ballast ',file=text_file)#
                str1 = 'set incTB := '
                for k_ in self.vessel.info['incInitBallast']:
                    str1 += str(k_) + ' '
                print(str1+';', file=text_file)
                
                print('# dec initial ballast ',file=text_file)#
                str1 = 'set decTB := '
                for k_ in self.vessel.info['decInitBallast']:
                    str1 += str(k_) + ' '
                print(str1+';', file=text_file)
                
                ##
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
                str1 = 'set depArrPort2 := '
                for k__, k_  in enumerate(self.loading.seq['sameBallast']):
                    str1 += '('+ str(k_)  + ',' + str(k_+1) + ') '
                print(str1+';', file=text_file)
                
                # same weight
                str1 = 'set sameBallastPort := '
                for k__, k_  in enumerate(self.loading.seq['sameBallast']):
                    str1 += str(k_)  + ' '
                print(str1+';', file=text_file)
                
                
                print('# rotating ports ',file=text_file)#
                str1 = 'set rotatingPort1 := '
                for k_  in range(0, self.loadable['lastVirtualPort']):
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
                
                # print('# first loading Port',file=text_file)#
                # str1 = 'param firstloadingPort := ' #+ self.loadable.info['arrDepVirtualPort']['1D']
                # print(str1+';', file=text_file)
                
                print('# deballast tanks', file=text_file)
                str1 = 'set toDeballastTank := '
                for i_ in self.loading.info['tankToDeballast']:
                    str1 += str(i_)  + ' '
                print(str1+';', file=text_file)
                
                print('# deballast limit', file=text_file)
                str1 = 'param ballastLimit := '
                for i_, j_ in self.loading.seq['ballastLimit'].items():
                    if j_ > 0:
                        str1 += str(i_) + ' ' +  "{:.3f}".format(j_) + ' '
                print(str1+';', file=text_file)
                
                
                
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
                
                
                print('# LCGs for cargo tanks', file=text_file)
                str1 = 'param LCGtport := '
                print(str1, file=text_file)
                for i_, j_ in self.vessel.info['cargoTanks'].items():
                    str1 = '['+ i_ + ',*] = '
                    for k1_ in range(1, self.loadable['lastVirtualPort']):
                        # lcg_ = j_['lcg']
                        lcg_ = self.LCGport.get(i_, {}).get(k1_, j_['lcg'])
                        str1 += str(k1_) + ' ' + "{:.4f}".format(lcg_) + ' '
                                    
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                
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
                
                print('# TCGs for others tanks', file=text_file)
                str1 = 'param TCGtp := '
                print(str1, file=text_file)
                for i_, j_ in self.loading.info['ROB'][1].items():
                    str1 = '['+ i_ + ',*] = '
                    for p_ in range(1,self.loadable['lastVirtualPort']+1):
                        str1 += str(p_) + ' ' + "{:.4f}".format(j_[0]['tcg']) + ' '
                            
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                print('# LCGs for others tanks', file=text_file)
                str1 = 'param LCGtp := '
                print(str1, file=text_file)
                for i_, j_ in self.loading.info['ROB'][1].items():
                    str1 = '['+ i_ + ',*] = '
                    for p_ in range(1,self.loadable['lastVirtualPort']+1):
                        str1 += str(p_) + ' ' + "{:.4f}".format(j_[0]['lcg']) + ' '
                            
                    print(str1, file=text_file)
                print(';', file=text_file)
                
                if listMOM:
                    print('# Limits of List MOM', file=text_file)
                    str1 = 'param ListMOM := 10000' 
                    print(str1+';', file=text_file)
                
                
                print('# slopes of LCB x Disp curve', file=text_file)
                str1 = 'param pwLCB := ' +  str(len(self.vessel.info['lcb_mtc']['lcb']['slopes']))
                print(str1+';', file=text_file)
                
                
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
                
                if ave_trim:
                    print('# ave trim', file=text_file)
                    str1 = 'param ave_trim := '
                    for i_, j_ in ave_trim.items():
                        str1 += str(i_) + ' ' +  "{:.2f}".format(j_) + ' '
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
                print(str1+';', file=text_file)
                
                print('# adjustment for LCB, MTC and draft ',file=text_file)#                
                str1 = 'param adjLCB := ' + str(self.config['adj_LCB'])
                print(str1+';', file=text_file)
                str1 = 'param adjMeanDraft := ' + str(self.config['adj_mean_draft'])
                print(str1+';', file=text_file)
                str1 = 'param adjMTC := ' + str(self.config['adj_MTC'])
                print(str1+';', file=text_file)
                
                
                print('# runtime limit ',file=text_file)#  
                str1 = 'param runtimeLimit := ' + str(self.config.get('timeLimit', 30))
                print(str1+';', file=text_file)
                
              
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
    
        