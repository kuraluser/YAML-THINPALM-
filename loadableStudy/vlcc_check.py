# -*- coding: utf-8 -*-
"""
Created on Mon Nov 16 14:50:33 2020

@author: I2R
"""
import numpy as np
import json

DEC_PLACE = 3


class Check_plans:
    def __init__(self, input_param):
#        self.outfile   = 'resmsg.json'
        self.input = input_param
        self.stability_values = []
    
    def _check_plans(self, plans, cargo_tank):
        
        if not self.input.error:
            print(self.input.port.info.get('portOrder',[]))
            print(self.input.loadable.info.get('seawaterDensity',[]))
        
            if hasattr(self.input, 'base_draft'):
                print(self.input.base_draft)
                        
            for p__, p_ in enumerate(plans):
                print('plan:', p__, '---------------------------------------------------------------------------------------------')            
                stability_ = {}
                if len(cargo_tank) > 0:
                    for a_, b_ in cargo_tank[p__].items():
                        print(a_,b_)
                for k_, v_ in p_.items(): # each port
                    plan_ = {**v_['cargo'], **v_['ballast'], **v_['other']}
                    result = self._check_plan(plan_, k_, seawater_density=self.input.loadable.info['seawaterDensity'][k_])
                    
                    print('Port: ',k_,'Cargo:', round(result['wt']['cargoTanks'],DEC_PLACE), 'Ballast:', round(result['wt']['ballastTanks'],DEC_PLACE), 'Displacement:', round(result['disp'],DEC_PLACE), 'tcg_moment:', round(result['tcg_mom'],DEC_PLACE), 'Mean Draft:', round(result['dm'],DEC_PLACE), 'Trim:', round(result['trim'],DEC_PLACE))
                    print('frame:', result.get('maxBM',['NA','NA'])[0], 'BM:', result.get('maxBM',['NA','NA'])[1],'frame:', result.get('maxSF',['NA','NA'])[0], 'SF:', result.get('maxSF',['NA','NA'])[1])
                    
                    stability_[k_] = {'forwardDraft': "{:.2f}".format(result['df']), 
                                     'meanDraft': "{:.2f}".format(result['dm']),
                                     'afterDraft': "{:.2f}".format(result['da']),
                                     'trim': "{:.2f}".format(0.00 if round(result['trim'],2) == 0 else result['trim']),
                                     'heel': None,
                                     'airDraft': "{:.2f}".format(result['airDraft']),
                                     'bendinMoment': "{:.2f}".format(result['maxBM'][1]),
                                     'shearForce':  "{:.2f}".format(result['maxSF'][1])}
                    
                    # update correction ullage
                    trim_ = result['trim']
                    
                    for a_, b_ in plans[p__][k_]['cargo'].items():
                        tankId_ = self.input.vessel.info['tankName'][a_]
                        if str(tankId_) in self.input.vessel.info['ullage_func_corr'].keys():
                            cf_ = self.input.vessel.info['ullage_func_corr'][str(tankId_)](b_[0]['rdgUllage'],trim_)[0]
                            plans[p__][k_]['cargo'][a_][0]['correctionFactor'] = round(cf_,3)
                        else:
                            # print(str(tankId_), a_, 'Missing correction data!!')
                            plans[p__][k_]['cargo'][a_][0]['correctionFactor'] = -100
                        
                    for a_, b_ in plans[p__][k_]['ballast'].items():
                        tankId_ = self.input.vessel.info['tankName'][a_]
                        if str(tankId_) in self.input.vessel.info['ullage_func_corr'].keys():
                            cf_ = self.input.vessel.info['ullage_func_corr'][str(tankId_)](b_[0]['rdgLevel'],trim_)[0]
                            plans[p__][k_]['ballast'][a_][0]['correctionFactor'] = round(cf_,3)
                        else:
                            # print(str(tankId_), a_, 'Missing correction data!!')
                            plans[p__][k_]['ballast'][a_][0]['correctionFactor'] = -100
                    
                                     
                self.stability_values.append(stability_)
                
            #with open('ship_status.json', 'w') as fp:
            #    json.dump(plans, fp)     
            
                
                
                
                
                
    def _check_plan(self, plan, virtual_port, seawater_density = 1.025):
#        print(plan)
        
        result = {}
        
        lpp_ = self.input.vessel.info['LPP']
        
        lightweight_lmom_ = self.input.vessel.info['lightweight']['weight']*self.input.vessel.info['lightweight']['lcg']
        lightweight_vmom_ = self.input.vessel.info['lightweight']['weight']*self.input.vessel.info['lightweight']['vcg']
        
        other_lmom_ = self.input.vessel.info['deadweightConst']['weight']*self.input.vessel.info['deadweightConst']['lcg']
        other_vmom_ = self.input.vessel.info['deadweightConst']['weight']*self.input.vessel.info['deadweightConst']['vcg']
        
        
#        print(self.input_param.vessel.info['lightweight']['weight'], self.input_param.vessel.info['lightweight']['vcg'])
#        print(self.input_param.vessel.info['deadweight_const']['weight'], self.input_param.vessel.info['deadweight_const']['vcg'])
        
        total_ = {'cargoTanks':0, 'ballastTanks':0, 'fuelTanks':0, 'dieselTanks':0, 'freshWaterTanks':0}
        l_mom_ = lightweight_lmom_ + other_lmom_
        v_mom_ = lightweight_vmom_ + other_vmom_
        
        t_mom_ = 0.
        disp_ = self.input.vessel.info['lightweight']['weight'] + self.input.vessel.info['deadweightConst']['weight']
        for k_, v_ in plan.items():
            # print(k_,v_)
            type_ = self.input.vessel.info['category'][k_]
            
            l_mom_ += v_[0]['wt']*self.input.vessel.info[type_][k_]['lcg']
            v_mom_ += v_[0]['wt']*self.input.vessel.info[type_][k_]['vcg']
            t_mom_ += v_[0]['wt']*v_[0]['tcg']
            # print(k_, v_[0]['wt'], v_[0]['tcg'], v_[0]['wt']*v_[0]['tcg'])
            # print(k_, v_[0]['wt'], self.input.vessel.info[type_][k_]['lcg'], v_[0]['wt']*self.input.vessel.info[type_][k_]['lcg'])
            
            total_[type_] +=  v_[0]['wt']
            disp_ += v_[0]['wt']
                
                
        result['disp'] =  disp_
        result['wt'] = total_
        result['tcg_mom'] = t_mom_
#        print(disp_,cargo_total_,fuel_total_, diesel_total_, fresh_total_)
#        print(l_mom_,v_mom_)
        
#        l_mom_,v_mom_ = -3802896, 5744799

        disp1_ = disp_*1.025/seawater_density

        draft_ = np.interp(disp1_, self.input.vessel.info['hydrostatic']['displacement'], self.input.vessel.info['hydrostatic']['draft'])
        mtc_   = np.interp(disp1_, self.input.vessel.info['hydrostatic']['displacement'], self.input.vessel.info['hydrostatic']['mtc'])
        lcb_ = np.interp(disp1_, self.input.vessel.info['hydrostatic']['displacement'], self.input.vessel.info['hydrostatic']['lcb'])
        lcf_   = np.interp(disp1_, self.input.vessel.info['hydrostatic']['displacement'], self.input.vessel.info['hydrostatic']['lcf'])
        # mid.f = lcf; mid.b = lcb
#        print(draft_,mtc_,lcb_,lcf_)
        lcg_ = l_mom_/ disp_
        bg_ = lcg_ - lcb_
        trim_ = bg_*disp_/mtc_/100
        
        # print(disp_, mtc_, lcb_)
        
        df_ = draft_ -  (0.5*lpp_ + lcf_)/lpp_*trim_
        da_ = df_ + trim_
        dm_ = (df_ + da_)/2
#        print("{:.2f}".format(trim_),"{:.2f}".format(df_),"{:.2f}".format(da_),"{:.2f}".format(dm_))
        result['trim'] = trim_
        result['df'] = df_
        result['da'] = da_
        result['dm'] = dm_
        result['dc'] = draft_
        
        
        km_ = np.interp(disp_, self.input.vessel.info['hydrostatic']['displacement'], self.input.vessel.info['hydrostatic']['tkm'])
        kg_ = v_mom_/disp_
        gm_ = km_ - kg_
#        print(km_,gm_)
        
        result['km'] = km_
        result['gm'] = gm_
        
        # air draft
        port_order_ =  self.input.loadable.info['virtualArrDepPort'][virtual_port][:-1]
        origin_port_ = self.input.port.info['portOrder'][port_order_]
        tide_ = self.input.port.info['portRotation'][origin_port_]['tideHeight']
        result['airDraft'] = self.input.vessel.info['height'] - da_ + tide_
        
        
        #
        #
#        
#        plan = {'1C':{'wt':25997},'1P':{'wt':17886},'1S':{'wt':17886},
#                   '2C':{'wt':24253},'2P':{'wt':17450},'2S':{'wt':17450},
#                   '3C':{'wt':24253},'3P':{'wt':17450},'3S':{'wt':17450},
#                   '4C':{'wt':24253},'4P':{'wt':17450},'4S':{'wt':17450},
#                   '5C':{'wt':29004},'5P':{'wt':14858},'5S':{'wt':14858},
#                   'SLP':{'wt':3541},'SLS':{'wt':3541},
#                   'da':20.74,
#                   'df':21.14,
#                   'trim':-0.4
#                   }
#        
#        da_,  trim_ = 20.74, -0.4
        base_drafts, indx = np.unique(self.input.vessel.info['SSTable']['baseDraft'].to_numpy(dtype=np.float), return_index=True)
        ind_ = np.where(da_ >= base_drafts)
        if len(ind_[0]) > 0:
            base_draft_ = base_drafts[ind_[0][-1]]
            
            frames_ = self.input.vessel.info['frames']
            tankGroup_ = self.input.vessel.info['tankGroup']
            tankGroupLCG_ = self.input.vessel.info['tankGroupLCG']
            df_sf_ = self.input.vessel.info['SSTable']
            df_bm_ = self.input.vessel.info['SBTable']
            SFlimits_ = self.input.vessel.info['SFlimits']
            BMlimits_ = self.input.vessel.info['BMlimits']
            
            locations_ = self.input.vessel.info['locations']
            center_tanks_ = self.input.vessel.info['centerTank']
            wing_tanks_ = self.input.vessel.info['wingTank']
            ballast_tanks_ = self.input.vessel.info['ballastTankBSF']
            alpha_ = self.input.vessel.info['alpha']
            BWCorr_ = self.input.vessel.info['BWCorr']
            dist_AP_ = [47.5, 62.2, 62.2, 106.3, 106.3, 155.3, 155.3, 204.3, 204.3, 253.3, 253.3, 308.9]
            C4_ = self.input.vessel.info['C4']
            BSFLimits_ = self.input.vessel.info['BSFlimits']
            # dist_station_  = self.input.vessel.info['distStation']
            
            W_, W0_ = np.zeros(len(frames_)), 0.
            M_, M0_ = np.zeros(len(frames_)), 0.
            SF_, BM_ = np.zeros(len(frames_)), np.zeros(len(frames_))
            SF_limits_,BM_limits_ = np.zeros(len(frames_)),np.zeros(len(frames_))
            SF_percent, BM_percent = np.zeros(len(frames_)), np.zeros(len(frames_))
            max_sf_, max_bm_ = [0.,0.], [0.,0.]
#
            for f__,f_ in enumerate(frames_):
    #            print('frame:', f_, '-----------------------------------------------------')
                w_, m_ = 0., 0.
                for k_, v_ in tankGroup_[str(f__+1)].items(): # 
                    load_ = plan.get(k_,{})[0].get('wt',0.)/1000 if plan.get(k_,{}) else 0.
                    ratio_ = v_.get('wr',0.)
                    lcg_ = v_.get('lcg',0.)
                    w__ = ratio_*load_
                    w_ += w__
                    m__ = w__ * lcg_
                    m_ += m__
                
    #                print(k_, 'wi:', w__, 'mi:', w__ ,'x', lcg_,'=',m__)
            
                W_[f__] = w_ + W0_
                W0_ += w_ 
                M_[f__] = m_ + M0_
                M0_ += m_ 
            
    #            print('sum wi:',W_[f__], 'sum mi:',M_[f__] )
                
                # SF
                df_ = df_sf_[df_sf_["frameNumber"].isin([float(f_)])]  
                df_ = df_[df_['baseDraft'].isin([base_draft_])]
                ss_ = df_['baseValue'].to_numpy()[0] + (da_ -  base_draft_)*df_['draftCorrection'].to_numpy()[0] + trim_*df_['trimCorrection'].to_numpy()[0]
           
                SF_[f__] = (ss_ - W_[f__])*1000
                SF_limits_[f__] = SFlimits_[str(f_)][0] if SF_[f__] < 0 else SFlimits_[str(f_)][1]
                SF_percent[f__] = SF_[f__]/SF_limits_[f__]*100
                if SF_percent[f__] > max_sf_[1]:
                    max_sf_ = [f_, round(SF_percent[f__],2)]
                # BM
                df_ = df_bm_[df_bm_["frameNumber"].isin([f_])]  
                df_ = df_[df_['baseDraft'].isin([base_draft_])]
                sb_ = df_['baseValue'].to_numpy()[0] + (da_-base_draft_)*df_['draftCorrection'].to_numpy()[0] + trim_*df_['trimCorrection'].to_numpy()[0]
    #            print(f_, ss_, sb_)
                BM_[f__] = (W_[f__] * tankGroupLCG_[str(f__+1)] - sb_ + M_[f__])*1000
                BM_limits_[f__] = BMlimits_[str(f_)][0] if BM_[f__] < 0 else BMlimits_[str(f_)][1]
                BM_percent[f__] = BM_[f__]/BM_limits_[f__]*100
                
                if BM_percent[f__] > max_bm_[1]:
                    max_bm_ = [f_, round(BM_percent[f__],2)]
                
                # print(f_, round(da_,3), round(W_[f__],3),round(ss_,3), round(SF_[f__]/1000,3), round(M_[f__],3), round(sb_,3), round(BM_[f__],3))
                
                # print(f_, round(da_,3), round(W_[f__],3),round(ss_,3), round(SF_[f__]/1000,3))
                # print(f_, round(da_,3), round(W_[f__],3),round(sb_,3), round(BM_[f__]/1000,3))
                
                # print(f_, ss_ ,sb_)
                # print(f_ ,SF_[f__]/1000,BM_[f__]/1000)
    #            
    #        
            
            result['SF'] = {f_:SF_percent[f__] for f__,f_ in enumerate(frames_)}   
            result['BM'] = {f_:BM_percent[f__] for f__,f_ in enumerate(frames_)}   
            result['maxSF'] = max_sf_  
            result['maxBM'] = max_bm_
            # print(W_)
            
                
            
#        #
#        ##
#        zero_crossing = np.where(np.diff(np.sign(SF_)))[0][0] 
#        frm_ = str(frames_[zero_crossing]) + '-' + str(frames_[zero_crossing+1])
#        dist_ = dist_station_[frm_]
#        SFA, SFF = SF_[frames_.index(frames_[zero_crossing+1])], SF_[frames_.index(frames_[zero_crossing])]
#        L1 = abs(SFA)/(abs(SFA) + abs(SFF)) * dist_
#        L2 = dist_ - L1
#        
#        if 0 < L1 < dist_/3:
#            max_BM = BM_[zero_crossing+1] + 0.5*SFA*L1
#        elif 0 < L2 < dist_/3:
#            max_BM = BM_[zero_crossing] + 0.5*SFA*L2
#        else:
#            max_BM = 0.5*(BM_[zero_crossing+1] + BM_[zero_crossing])
#        
#        print('max_BM:', max_BM)
        
            ##
            BSF_limits_ = np.zeros(len(locations_))
            BSF_ = np.zeros(len(locations_))
            BSF_percent = np.zeros(len(locations_))
            max_bsf_ = [0.,0.]
            bsf_ = {}
            # print('BSF----------------------------------------------------')
            for t__, t_ in enumerate(zip(center_tanks_, wing_tanks_, ballast_tanks_)):
                loc_ = locations_[t__]
            
                sf_ = SF_[frames_.index(loc_[:-1])]*9.8
                x3_ = sf_*alpha_[t__]
                # print(sf_,x3_)
                # centre tanks
                load_ = sum([plan.get(i_,{})[0].get('wt',0.) if plan.get(i_,{}) else 0. for i_ in t_[0]['tanks']])*9.8
                x6_ = load_*t_[0]['C1']
                # print(load_,x6_)
                # wing_tanks
                load_ = sum([plan.get(i_,{})[0].get('wt',0.) if plan.get(i_,{}) else 0. for i_ in t_[1]['tanks']])*9.8
                x9_ = load_*t_[1]['C2']
                # print(load_,x9_)
                # ballast_tanks
                load_ = sum([plan.get(i_,{})[0].get('wt',0.) if plan.get(i_,{}) else 0. for i_ in t_[2]['tanks']])*9.8
                x12_ = load_*t_[2]['C3']
                # print(load_,x12_)
                
                x13_ = BWCorr_[t__]
                draft_ = da_ - trim_*dist_AP_[t__]/lpp_
                x16_ = draft_*C4_[t__]
                
                if load_ > 0:
                    x17_ = x6_ + x9_ + x12_ + x13_ + x16_
                else:
                    x17_ = x6_ + x9_ + x16_
                    
                # print(x17_)
                fl_ = x3_ + x17_
                # print(fl_)
                
                BSF_[t__] = fl_
                BSF_limits_[t__] = BSFLimits_[loc_][0] if fl_ < 0 else BSFLimits_[loc_][1]
                BSF_percent[t__] = BSF_[t__]/BSF_limits_[t__]*100
                bsf_[loc_] = BSF_percent[t__]
                if BSF_percent[t__] > max_bsf_[1]:
                    max_bsf_ = [loc_, BSF_percent[t__]]
                    
            result['BSF'] = bsf_ 
            
        return result
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        