# -*- coding: utf-8 -*-
"""
Created on Mon Nov 16 15:06:16 2020

@author: phtan1
"""
import numpy as np
import pandas as pd
from pathlib import Path
import pickle
import pwlf
import matplotlib.pyplot as plt
import json
from scipy.interpolate import interp1d, interp2d
plt.style.use('seaborn-whitegrid')

# tank_info_ = {'DSWP':-1, 'DWP':-1, 'FWS':1, 'DSWS':1, 
#               'FO2P':-1, 'FO2S':1, 'FO1P':-1, 'FO1S':1, 'BFOSV':1, 'FOST':1, 'FOSV':1,
#               'DO1S':1,  'DO2S':1, 'DOSV1':1, 'DOSV2':1,
#               'SLS':1, '2C':1, '1P':-1, '1S':1, '2P':-1, '2S':1,  '5C':1, '1C':1, '3C':1, '4C':1, '3P':-1, '3S':1, '4P':-1, '4S':1, '5P':-1, '5S':1, 'SLP':-1,
#               'UFPT':1, 'LFPT':1, 'WB1P':-1,'WB1S':1, 'WB2P':-1, 'WB2S':1, 'WB3P':-1, 'WB3S':1, 'WB4P':-1, 'WB4S':1, 'WB5P':-1, 'WB5S':1, 'AWBP':-1, 'AWBS':1, 'APT':-1, 'FPTU':1, 
#                }


class Vessel:
    def __init__(self, inputs, loading=False):
        
        vessel_json = inputs.vessel_json['vessel']
        
        vessel_info_ = {}
        
        vessel_info_['hasLoadicator'] = vessel_json['vessel'].get('hasLoadicator', False)
        vessel_info_['banBallast'] = ['UFPT']   # 'AWBP','AWBS'
        if hasattr(inputs, 'loadable'):
            vessel_info_['banCargo'] = {k_:[] for k_,v_ in inputs.loadable.info['parcel'].items()}
        else:
            vessel_info_['banCargo'] = {}
        vessel_info_['slopTank'] = []
        
        
        ## 
        loadingRate_ = vessel_json.get('selectableParameter', [])
        if len(loadingRate_) == 0:
            loadingRate_ = [{'name': 'Manifolds', 'values': [{'type': 1, 'value': '1140.0000'}, {'type': 6, 'value': '6841.0000'}, {'type': 7, 'value': '7981.0000'}, {'type': 12, 'value': '13681.0000'}]}, {'name': 'DropLines', 'values': [{'type': 1, 'value': '1140.0000'}, {'type': 6, 'value': '6841.0000'}, {'type': 7, 'value': '7981.0000'}, {'type': 12, 'value': '13681.0000'}]}, {'name': 'BottomLines', 'values': [{'type': 1, 'value': '1534.0000'}, {'type': 6, 'value': '9205.0000'}, {'type': 7, 'value': '10739.0000'}, {'type': 12, 'value': '18409.0000'}]}, {'name': 'WingTankBranchLine', 'values': [{'type': 1, 'value': '659.0000'}, {'type': 6, 'value': '3950.0000'}, {'type': 7, 'value': '3950.0000'}, {'type': 12, 'value': '3950.0000'}]}, {'name': 'CentreTankBranchLine', 'values': [{'type': 1, 'value': '965.0000'}, {'type': 6, 'value': '5790.0000'}, {'type': 7, 'value': '5790.0000'}, {'type': 12, 'value': '5790.0000'}]}, {'name': 'PVValveWingTank', 'values': [{'type': 1, 'value': '7050.0000'}, {'type': 6, 'value': '7050.0000'}, {'type': 7, 'value': '7050.0000'}, {'type': 12, 'value': '7050.0000'}]}, {'name': 'PVValveCentreTank', 'values': [{'type': 1, 'value': '12000.0000'}, {'type': 6, 'value': '12000.0000'}, {'type': 7, 'value': '12000.0000'}, {'type': 12, 'value': '12000.0000'}]}, {'name': 'SlopTankBranchLine', 'values': [{'type': 1, 'value': '573.0000'}, {'type': 6, 'value': '3435.0000'}, {'type': 7, 'value': '3950.0000'}, {'type': 12, 'value': '3950.0000'}]}]
               
        vessel_info_['loadingRate6'] = {l_['name']: [float(l__['value']) for l__ in l_['values'] if l__['type'] == 6][0]   for l_ in loadingRate_}
        vessel_info_['loadingRate1'] = {l_['name']: [float(l__['value']) for l__ in l_['values'] if l__['type'] == 1][0]   for l_ in loadingRate_}
        
        ## 
        vessel_info_['name'] = vessel_json['vessel']['name']
        
        ##
        vessel_info_['lightweight'] = {}
        vessel_info_['lightweight']['weight'] = float(vessel_json['vessel']['lightweight'])
        vessel_info_['lightweight']['lcg'] = float(vessel_json['vessel']['lcg'])
        vessel_info_['lightweight']['vcg'] = vessel_json['vessel'].get('vcg', 15.34)
        vessel_info_['lightweight']['tcg'] = vessel_json['vessel'].get('tcg', 0.)
        ##
        vessel_info_['deadweightConst'] = {}
        vessel_info_['deadweightConst']['weight'] = float(vessel_json['vessel']['deadweightConstant'])
        vessel_info_['deadweightConst']['lcg'] = float(vessel_json['vessel']['deadweightConstantLcg'])
        vessel_info_['deadweightConst']['vcg'] = vessel_json['vessel'].get('deadweightConstantVcg',15.55)
        vessel_info_['deadweightConst']['tcg'] = vessel_json['vessel']['deadweightConstantTcg'] 
        ##
        vessel_info_['draftCondition'] = {}
        if inputs.module in ['LOADABLE']:
            condition_ = next(i_ for i_ in vessel_json['vesselDraftCondition'] if i_.get("draftConditionId")  == inputs.loadline_id and i_.get("draftExtreme")  == inputs.draft_mark)
            vessel_info_['draftCondition']['deadweight'] = float(condition_['deadWeight'])
            vessel_info_['draftCondition']['draftExtreme'] = float(condition_['draftExtreme'])
            vessel_info_['draftCondition']['displacement'] = float(condition_['displacement'])
        
        ##
        vessel_info_['height'] = float(vessel_json['vessel']['keelToMastHeight'])
        
        
        ## tanks
        vessel_info_['cargoTanks'], vessel_info_['ballastTanks']  = {}, {}
        vessel_info_['fuelTanks'], vessel_info_['dieselTanks'], vessel_info_['freshWaterTanks']  = {}, {}, {}
        categoryid_ = {1:'cargoTanks', 2:'ballastTanks', 3:'freshWaterTanks', 5:'fuelTanks', 6:'dieselTanks'}
        vessel_info_['tankId'], vessel_info_['tankName'], vessel_info_['category'] = {}, {}, {}
        for t_ in vessel_json['vesselTanks']:
            if t_['categoryId'] in categoryid_.keys():
                vessel_info_[categoryid_[t_['categoryId']]][t_['shortName']] = {'lcg': float(t_['lcg']), 'vcg': float(t_['vcg']), 
                                                                                     'tcg': t_['tcg'], 
                                                                                     'capacityCubm': t_['fullCapcityCubm'],
                                                                                     'slopTank': t_['slopTank'],
                                                                                     'tankId': t_['id'],
                                                                                     'name':t_['name'],
                                                                                     'inLoadicator':t_['isLoadicatorUsing']
                                                                                    }
                if t_['isLoadicatorUsing']:
                    vessel_info_['tankId'][t_['id']] = t_['shortName'] 
                    vessel_info_['tankName'][t_['shortName']] = t_['id'] 
                    vessel_info_['category'][t_['shortName']] = categoryid_[t_['categoryId']]
                    
                if t_['slopTank']:
                    vessel_info_['slopTank'].append(t_['shortName'])
                    
                    
        
        
                
#                print(t_['shortName'],t_['name'])
                
        ##
        # vessel_info_['ullage'] = {}
        # for d_ in vessel_json['ullageDetails']:
        #     # print(d_['id'])
        #     if str(d_['tankId']) not in vessel_info_['ullage']:
        #         vessel_info_['ullage'][str(d_['tankId'])] = {'id': [d_['id']], 'depth':[float(d_['ullageDepth'])], 'vol':[float(d_['evenKeelCapacityCubm'])]}
        #     else:
        #         vessel_info_['ullage'][str(d_['tankId'])] ['depth'].append(float(d_['ullageDepth']))
        #         vessel_info_['ullage'][str(d_['tankId'])] ['vol'].append(float(d_['evenKeelCapacityCubm']))
        #         # vessel_info_['ullage'][str(d_['tankId'])] ['id'].append(d_['id'])
        
        ## linear approx ullage
        self._get_ullage_func(vessel_info_, {k_:v_ for k_,v_ in vessel_json.items() if k_ in ['ullageDetails','ullageTrimCorrections']})    
        vessel_info_['ullage30cm'] = {}
        for k_,v_ in vessel_info_['ballastTanks'].items():
            k1_ = str(vessel_info_['tankName'][k_])
            if k_ not in vessel_info_['banBallast']:
                vessel_info_['ullage30cm'][k_] = round(float(vessel_info_['ullageInvFunc'][k1_](0.3))*1.025,3)
        
        # self._get_ullage_corr(vessel_info_, vessel_json['ullageTrimCorrections'])
        
        ## 
        vessel_info_['hydrostatic'] = {}
        vessel_info_['hydrostatic']['draft'], vessel_info_['hydrostatic']['displacement'] = [], []
        vessel_info_['hydrostatic']['lcf'], vessel_info_['hydrostatic']['mtc'], vessel_info_['hydrostatic']['lcb'], vessel_info_['hydrostatic']['tkm'] = [], [], [], []
        
        for d_ in vessel_json['hydrostaticDatas']:
            #print(d_)
            vessel_info_['hydrostatic']['draft'].append(float(d_['draft']))
            vessel_info_['hydrostatic']['displacement'].append(float(d_['displacement']))
            vessel_info_['hydrostatic']['lcf'].append(float(d_['lcf']))
            vessel_info_['hydrostatic']['mtc'].append(float(d_['mtc']))
            vessel_info_['hydrostatic']['lcb'].append(float(d_['lcb']))
            vessel_info_['hydrostatic']['tkm'].append(float(d_['tkm']))
            
        
        ind_ = np.argsort(vessel_info_['hydrostatic']['displacement'])
        vessel_info_['hydrostatic']['draft'] = np.array(vessel_info_['hydrostatic']['draft'])[ind_]
        vessel_info_['hydrostatic']['displacement'] = np.array(vessel_info_['hydrostatic']['displacement'])[ind_]
        vessel_info_['hydrostatic']['lcf'] = np.array(vessel_info_['hydrostatic']['lcf'])[ind_]
        vessel_info_['hydrostatic']['mtc'] = np.array(vessel_info_['hydrostatic']['mtc'])[ind_]
        vessel_info_['hydrostatic']['lcb'] = np.array(vessel_info_['hydrostatic']['lcb'])[ind_]
        vessel_info_['hydrostatic']['tkm'] = np.array(vessel_info_['hydrostatic']['tkm'])[ind_]
        
        ## pw linear approx LCB x disp
        self._get_lcb_parameters(vessel_info_)    
            
        ##
        tcg_details_, lcg_details_ = {}, {}
        for d_ in vessel_json['vesselTankTCGs']:
            tank_name_ = vessel_info_['tankId'].get(d_['tankId'],None)
            if tank_name_:
                if tank_name_ not in tcg_details_.keys():
                    
                    if tank_name_ in vessel_info_['cargoTanks']:
                        type_ = 'cargo'
                    elif tank_name_ in vessel_info_['ballastTanks']:
                        type_ = 'ballast'
                    else:
                        type_ = 'other'
                    
                    tcg_details_[tank_name_] = {'tcg':[], 'vol':[],'type':type_}
                    lcg_details_[tank_name_] = {'lcg':[], 'vol':[],'type':type_}
                
                # tcg_details_[tank_name_]['tcg'].append(float(d_['tcg']) * tank_info_[tank_name_])
                tcg_details_[tank_name_]['tcg'].append(float(d_['tcg']))
                tcg_details_[tank_name_]['vol'].append(float(d_['capacity']))
                
                lcg_details_[tank_name_]['lcg'].append(float(d_['lcg']))
                lcg_details_[tank_name_]['vol'].append(float(d_['capacity']))
                
                
            else:
                # print(tank_name_,d_['tankId'])
                pass
            
        ## pw linear approx TCG x weight
        vessel_info_['tankTCG'] = {}
        vessel_info_['tankTCG']['tcg'] = tcg_details_
        self._get_tcg_parameters(vessel_info_, tcg_details_)   
        
        ##
        vessel_info_['tankLCG'] = {}
        vessel_info_['tankLCG']['lcg'] = lcg_details_
        self._get_lcg_parameters(vessel_info_, lcg_details_)  
        
        
        for k_, v_ in vessel_info_['cargoTanks'].items():
            vol_ = 0.98*v_['capacityCubm']
            lcg_data_ = lcg_details_[k_]
            lcg_ = np.interp(vol_, lcg_data_['vol'], lcg_data_['lcg'])
            # print(k_, lcg_, v_['lcg'])
            vessel_info_['cargoTanks'][k_]['lcg'] = lcg_
            
        # vessel_info_['cargoTanks']['SLP']['lcg'] = 106.6
        ##
        vessel_info_['KTM'] = vessel_json['vessel']['keelToMastHeight']
        vessel_info_['LPP'] = float(vessel_json['vessel']['lengthBetweenPerpendiculars'])
        
        ## BM and SF
        vessel_info_['SSTable'] = pd.DataFrame(vessel_json['bmandSF']['shearingForceType1'], dtype=np.float)
        vessel_info_['SBTable'] = pd.DataFrame(vessel_json['bmandSF']['bendingMomentType1'], dtype=np.float)
        vessel_info_['frames'] = []
        vessel_info_['tankGroupLCG'], vessel_info_['tankGroup']  = {}, {}
        vessel_info_['SFlimits'], vessel_info_['BMlimits'] = {}, {}
        vessel_info_['locations'], vessel_info_['alpha'], vessel_info_['BWCorr'],  vessel_info_['C4'] = [], [], [], []
        vessel_info_['centerTank'], vessel_info_['wingTank'], vessel_info_['ballastTankBSF'] = [], [], []
        vessel_info_['BSFlimits'] = {}
        vessel_info_['distStation'] = {}
        
        for d_ in vessel_json['bmandSF']['calculationSheetTankGroup']:
            vessel_info_['frames'].append(d_['frameNumber'])
            vessel_info_['tankGroupLCG'][str(d_['tankGroup'])] = float(d_['lcg'])
            vessel_info_['tankGroup'][str(d_['tankGroup'])] = {}
        
        for d_ in vessel_json['bmandSF']['calculationSheet']:
            info_ = {'wr': float(d_['weightRatio'])/100, 'lcg': float(d_['lcg'])}
            tank_ = vessel_info_['tankId'][d_['tankId']]
            vessel_info_['tankGroup'][str(d_['tankGroup'])][tank_] = info_
            
        
        for d_ in vessel_json['bmandSF']['minMaxValuesForBMAndSfs']:
            vessel_info_['SFlimits'][str(int(float(d_['frameNumber'])))] = [d_['minSf'], d_['maxSf']]
            vessel_info_['BMlimits'][str(int(float(d_['frameNumber'])))] = [d_['minBm'], d_['maxBm']]
            
        ## max BM 
        for d_ in vessel_json['bmandSF']['stationValues']:
            xx_ = str(int(float(d_['frameNumberFrom']))) +'-'+str(int(float((d_['frameNumberTo']))))
            vessel_info_['distStation'][xx_] = d_['distance']
            
        
        ## BSF
        for d_ in vessel_json['bmandSF']['innerBulkHeadValues']:
#            print(d_)
            if '' not in (d_['foreAlpha'], d_['aftAlpha']):
                vessel_info_['locations'].append(str(int(float(d_['frameNumber']))) + 'f')
                vessel_info_['locations'].append(str(int(float(d_['frameNumber']))) + 'a')
                vessel_info_['alpha'].append(float(d_['aftAlpha']))
                vessel_info_['alpha'].append(float(d_['foreAlpha']))
                vessel_info_['BWCorr'].append(float(d_['aftBWCorrection']))
                vessel_info_['BWCorr'].append(float(d_['foreBWCorrection']))
                vessel_info_['C4'].append(float(d_['aftC4']))
                vessel_info_['C4'].append(float(d_['foreC4']))
                
                center_tanks_  = [vessel_info_['tankId'][int(t_)] for t_ in str(d_['aftCenterCargoTankId']).split(',')]
                wing_tanks_    = [vessel_info_['tankId'][int(t_)] for t_ in str(d_['aftWingTankIds']).split(',')]
                ballast_tanks_ = [vessel_info_['tankId'][int(t_)] for t_ in str(d_['aftBallstTanks']).split(',')]
                
                vessel_info_['centerTank'].append({'tanks':center_tanks_,'C1':float(d_['aftC1'])})
                vessel_info_['wingTank'].append({'tanks':wing_tanks_,'C2':float(d_['aftC2'])})
                vessel_info_['ballastTankBSF'].append({'tanks':ballast_tanks_,'C3':float(d_['aftC3'])})
                
                center_tanks_  = [vessel_info_['tankId'][int(t_)] for t_ in str(d_['foreCenterCargoTankId']).split(',')]
                wing_tanks_    = [vessel_info_['tankId'][int(t_)] for t_ in str(d_['foreWingTankIds']).split(',')]
                ballast_tanks_ = [vessel_info_['tankId'][int(t_)] for t_ in str(d_['foreBallstTanks']).split(',')]
                
                vessel_info_['centerTank'].append({'tanks':center_tanks_,'C1':float(d_['foreC1'])})
                vessel_info_['wingTank'].append({'tanks':wing_tanks_,'C2':float(d_['foreC2'])})
                vessel_info_['ballastTankBSF'].append({'tanks':ballast_tanks_,'C3':float(d_['foreC3'])})
                
                vessel_info_['BSFlimits'][str(int(float(d_['frameNumber']))) + 'f'] = [float(d_['foreMinAllowence'])*1000, float(d_['foreMaxAllowence'])*1000]
                vessel_info_['BSFlimits'][str(int(float(d_['frameNumber']))) + 'a'] = [float(d_['aftMinFlAllowence'])*1000, float(d_['aftMaxFlAllowence'])*1000]
    
                
            elif d_['aftAlpha'] == '':
                vessel_info_['locations'].append(str(int(float(d_['frameNumber']))) + 'f')
                vessel_info_['alpha'].append(float(d_['foreAlpha']))
                vessel_info_['BWCorr'].append(float(d_['foreBWCorrection']))
                vessel_info_['C4'].append(float(d_['foreC4']))
                
                center_tanks_  = [vessel_info_['tankId'][int(t_)] for t_ in str(d_['foreCenterCargoTankId']).split(',')]
                wing_tanks_    = [vessel_info_['tankId'][int(t_)] for t_ in str(d_['foreWingTankIds']).split(',')]
                ballast_tanks_ = [vessel_info_['tankId'][int(t_)] for t_ in str(d_['foreBallstTanks']).split(',')]
                
                vessel_info_['centerTank'].append({'tanks':center_tanks_,'C1':float(d_['foreC1'])})
                vessel_info_['wingTank'].append({'tanks':wing_tanks_,'C2':float(d_['foreC2'])})
                vessel_info_['ballastTankBSF'].append({'tanks':ballast_tanks_,'C3':float(d_['foreC3'])})
                
                vessel_info_['BSFlimits'][str(int(float(d_['frameNumber']))) + 'f'] = [float(d_['foreMinAllowence'])*1000, float(d_['foreMaxAllowence'])*1000]
                

            elif d_['foreAlpha'] == '':
                vessel_info_['locations'].append(str(int(float(d_['frameNumber']))) + 'a')
                vessel_info_['alpha'].append(float(d_['aftAlpha']))
                vessel_info_['BWCorr'].append(float(d_['aftBWCorrection']))
                vessel_info_['C4'].append(float(d_['aftC4']))
                
                center_tanks_  = [vessel_info_['tankId'][int(t_)] for t_ in str(d_['aftCenterCargoTankId']).split(',')]
                wing_tanks_    = [vessel_info_['tankId'][int(t_)] for t_ in str(d_['aftWingTankIds']).split(',')]
                ballast_tanks_ = [vessel_info_['tankId'][int(t_)] for t_ in str(d_['aftBallstTanks']).split(',')]
                
                vessel_info_['centerTank'].append({'tanks':center_tanks_,'C1':float(d_['aftC1'])})
                vessel_info_['wingTank'].append({'tanks':wing_tanks_,'C2':float(d_['aftC2'])})
                vessel_info_['ballastTankBSF'].append({'tanks':ballast_tanks_,'C3':float(d_['aftC3'])})
                
                vessel_info_['BSFlimits'][str(int(float(d_['frameNumber']))) + 'a'] = [float(d_['aftMinFlAllowence'])*1000, float(d_['aftMaxFlAllowence'])*1000]
                
            else: 
                print('Error!!')
        
        self.info = vessel_info_     
        
    def _get_onboard(self, inputs, loading = False): 
        onboard_json = inputs.vessel_json['onBoard']
        self.info['onboard'] = {} # leftover
        self.info['onboard']['totalWeight'] = 0. # leftover
        if hasattr(inputs, 'loadable'):
            ave_sg_ = np.mean(inputs.loadable.info['sg'])
        else:
            ave_sg_ = 1.0
        
        for o__, o_ in enumerate(onboard_json):
            tank_ = self.info['tankId'][o_['tankId']]
            # port_order_ = '1A'
            
            # print(o_)
            wt_ = float(o_['plannedArrivalWeight']) if o_['plannedArrivalWeight'] not in [None] else 0.
            vol1_ = float(o_['volume']) if o_['volume'] not in [None] else 0.
            if wt_ > 0. and vol1_ > 0.:
                if tank_ not in self.info['onboard'].keys():
                    self.info['onboard'][tank_] = {}
                
                
                vol_ =  max(vol1_, wt_/ave_sg_)
                self.info['onboard'][tank_]= {'vol': vol_, 'wt': wt_, 'vol1':vol1_}
                self.info['onboard']['totalWeight'] += wt_
                self.info['cargoTanks'][tank_]['api'] = o_.get('api',None)
                self.info['cargoTanks'][tank_]['colorCode'] = o_.get('colorCode',None)
                self.info['cargoTanks'][tank_]['sg'] = wt_/vol1_
                
                # inputs.loadOnTop = False
                if not inputs.loadOnTop:
                    
                    for k_,v_ in inputs.loadable.info['parcel'].items():
                        self.info['banCargo'][k_].append(tank_)
                    # fixed tcg
                    tcg_data_ = self.info['tankTCG']['tcg'][tank_] # tcg_data
                    tcg_ = np.interp(vol1_, tcg_data_['vol'], tcg_data_['tcg'])
                    self.info['cargoTanks'][tank_]['tcg'] = tcg_
                    # fixed lcg
                    
                    ## remove from pw-linear
                    self.info['tankTCG']['tcg_pw'].pop(tank_,None)
                    # self.info['tankTCG']['tcg_pw'].pop('1P',None)
                    
        if inputs.module in ['LOADABLE']:
            ## balllast -------------------------------------------------
            self.info['initBallast'] = {'wt': {'LFPT':4800,
                                      'WB1P':9000, 'WB1S':9000,
                                      'WB2P':9000, 'WB2S':9000,
                                      'WB3P':9000, 'WB3S':9000,
                                      'WB4P':8900, 'WB4S':8900,
                                      'WB5P':7600, 'WB5S':7600},
                                        'dec':['APT','LFPT','WB1P','WB1S','WB2P','WB2S','WB3P','WB3S','WB4P','WB4S','WB5P','WB5S','AWBP','AWBS'],
                                        'inc':[]}
            
            
            self.info['finalBallast'] = {}
            ## ballast requirements
            loading_port_ = [int(inputs.loadable.info['arrDepVirtualPort'][str(i_)+'D']) for i_ in range(1,inputs.port.info['numPort'])]
            # self.info['loadingNotLast'] = loading_port_[:-1]
            self.info['loading'] = loading_port_
            # self.info['depArr'] = loading_port_
            if len(inputs.loadable.info.get('rotationVirtual',[]))> 0:
                #self.info['rotationVirtual'] = [inputs.loadable.info['rotationVirtual'][0]-1] + inputs.loadable.info['rotationVirtual']
                self.info['rotationVirtual'] = [[l_[0]-1]+l_ for l_ in inputs.loadable.info['rotationVirtual']] 
            else:
                self.info['rotationVirtual'] = []  
            ## cargo tank requirements
            tanks_ = ['SLS', '1P', '1S', '2P', '2S', '4P', '4S', '5P', '3P', '3S', '5S']
            capacity_ = sum([0.98*v_['capacityCubm']  for k_,v_ in self.info['cargoTanks'].items() if k_ in tanks_])
            
            asym_ = True
            self.info['maxCargo'] = []
            if len(inputs.loadable.info['toLoadIntend']) > 1 and inputs.mode in ['Auto']:
                for k_,v_ in inputs.loadable.info['toLoadIntend'].items():
                    vol_need_ = v_/inputs.loadable.info['parcel'][k_]['SG']
                    if (vol_need_ > .99*capacity_):
                        asym_ = False
                        self.info['maxCargo'].append(k_)
            
            self.info['notSym'] = [('SLS','SLP')]
            if asym_ and inputs.mode in ['Auto']:
                self.info['notSym'] += [('1P','1C'), ('2P','2C'), ('3P','3C'), ('4P','4C'), ('5P','5C')]
                
                
    def _set_preloaded(self, inputs): 
        
        if inputs.loadable.info['initialBallast']:
            self.info['initBallast'] = {'wt':{}, 'dec':[], 'inc':[]}
            
            for k_, v_ in inputs.loadable.info['initialBallast'].items():
                tank_ = self.info['tankId'][k_]
                self.info['initBallast']['wt'][tank_] = v_
            
            self.info['initBallast']['inc'] = ['LFPT','WB1P','WB1S','WB2P','WB2S','WB3P','WB3S','WB4P','WB4S','WB5P','WB5S']
            
        
            
        if  inputs.loadable.info['preloadOperation']:
            info_ = {}
            for k_, v_ in inputs.loadable.info['preloadOperation'].items():
                info_[k_] = {}
                for k1_, v1_ in v_.items():
                    tank_ = self.info['tankId'][k1_]
                    info_[k_][tank_] = v1_
                    
            inputs.loadable.info['preloadOperation'] = info_

        
    def _get_onhand(self, inputs): 
        ## virtual ports
        DENSITY = {'DSWP':1.0, 'DWP':1.0, 'FWS':1.0, 'DSWS':1.0,
                   'FO2P':0.98, 'FO2S':0.98, 'FO1P':0.98, 'FO1S':0.98, 'BFOSV':0.98, 'FOST':0.98, 'FOSV':0.98,
                   'DO1S':0.88,  'DO2S':0.88, 'DOSV1':0.88, 'DOSV2':0.88}
        
        onhand_json = inputs.vessel_json['onHand']
        self.info['onhand'] = {} # ROB
        self.info['onhand1'] = {} # ROB
        for o__, o_ in enumerate(onhand_json):
            tank_ = self.info['tankId'].get(o_['tankId'],None)
            # print(tank_, o_['portId'])
            if tank_ and str(o_['portId']) in inputs.port.info['idPortOrder'].keys():
                port_order_  = inputs.port.info['idPortOrder'][str(o_['portId'])]
                tcg_data_ = self.info['tankTCG']['tcg'][tank_] # tcg_data
                lcg_data_ = self.info['tankLCG']['lcg'][tank_] # lcg_data
                
                if tank_ not in self.info['onhand'].keys():
                    self.info['onhand'][tank_] = {}
                    
                    
                if port_order_+'A' not in self.info['onhand1'].keys():
                    self.info['onhand1'][port_order_+'A'] = {}
                
                if port_order_+'D' not in self.info['onhand1'].keys():
                    self.info['onhand1'][port_order_+'D'] = {}
                    
                # print(o_)
                wt_ = float(o_['arrivalQuantity']) if o_['arrivalQuantity'] not in [None] else 0.
                vol_ = wt_/DENSITY[tank_]
                # vol_ = float(o_['arrivalVolume']) if o_['arrivalVolume'] not in [None] else 0.
                
                # print(vol_)
                if vol_ > 0:
                    tcg_ = np.interp(vol_, tcg_data_['vol'], tcg_data_['tcg'])
                    lcg_ = np.interp(vol_, lcg_data_['vol'], lcg_data_['lcg'])
                    self.info['onhand'][tank_][port_order_+'A'] = {'wt': wt_, 'vol': vol_, 'tcg':tcg_, 'lcg':lcg_}
                    self.info['onhand1'][port_order_+'A'][tank_] = wt_
                    
                wt_ = float(o_['departureQuantity']) if o_['departureQuantity'] not in [None] else 0.
                vol_ = wt_/DENSITY[tank_]
                # vol_ = float(o_['departureVolume']) if o_['arrivalVolume'] not in [None] else 0.
                # print(vol_)
                if vol_ > 0:
                    tcg_ = np.interp(vol_, tcg_data_['vol'], tcg_data_['tcg'])
                    lcg_ = np.interp(vol_, lcg_data_['vol'], lcg_data_['lcg'])
                    
                    self.info['onhand'][tank_][port_order_+'D'] = {'wt': wt_, 'vol': vol_,'tcg':tcg_, 'lcg':lcg_}
                    self.info['onhand1'][port_order_+'D'][tank_] = wt_
                
          
        self.info['sameROB'] = []
        for p_ in range(1,inputs.port.info['numPort']):
            p1_, p2_ = str(p_)+'D', str(p_+1)+'A'
            # port1_, port2_ = inputs.port.info['portOrder'][p1_[:-1]], inputs.port.info['portOrder'][p2_[:-1]]
            wt1_ = sum([v_ for k_,v_ in self.info['onhand1'].get(p1_,{}).items()])
            wt2_ = sum([v_ for k_,v_ in self.info['onhand1'].get(p2_,{}).items()])
            
            if abs(wt1_-wt2_) <= 200:
            # if (self.info['onhand1'].get(p1_,{}) == self.info['onhand1'].get(p2_,{})) and (inputs.port.info['portRotation'][port1_]['seawaterDensity'] == inputs.port.info['portRotation'][port2_]['seawaterDensity']):
                print('ROB:', p1_, p2_, inputs.loadable.info['arrDepVirtualPort'][p1_], inputs.loadable.info['arrDepVirtualPort'][p2_])
                self.info['sameROB'].append((inputs.loadable.info['arrDepVirtualPort'][p1_],inputs.loadable.info['arrDepVirtualPort'][p2_]))
            
        # print(self.info['onhand'])      
    
    def _get_lcg_parameters(self, vessel_info_, lcg_details_):
        
        if not Path(vessel_info_['name']+'_lcg_pw.pickle').is_file():
            npw_ = 10
            parameters_ = {'npw':npw_}
            for k_, v_ in lcg_details_.items():
                
                
                if k_ not in vessel_info_['banBallast'] and  v_['type'] in ['ballast'] and abs(v_['lcg'][-1]-v_['lcg'][2]) > 0.1:
                #if k_ not in vessel_info_['banBallast'] and  v_['type'] in ['ballast','cargo'] and abs(v_['lcg'][-1]-v_['lcg'][2]) > 0.1:
                    print(k_, v_['lcg'][-1], v_['lcg'][0], v_['lcg'][1] ,v_['lcg'][2])
                    
                    lcg_weight_ = np.array(v_['vol'])*1.025 # density == 1 
                    lcg_mom_ = lcg_weight_ * np.array(v_['lcg'])/1000
                    
                    my_pwlf = pwlf.PiecewiseLinFit(lcg_weight_, lcg_mom_)
                    # fit the data for four line segments
                    breaks = my_pwlf.fit(npw_)
                    slopes = my_pwlf.calc_slopes()
                    intercepts = my_pwlf.intercepts
                    
                    ## predict for the determined points
                    xHat = np.linspace(min(v_['vol']), max(v_['vol']), num=1000)
                    yHat = np.zeros(len(xHat))
                    
                    for i__,i_ in enumerate(xHat):
                        
                        m_ = np.where(i_ <= breaks[1:])[0][0]
                        yHat[i__] = slopes[m_]*i_ + intercepts[m_]
                        
#                    yy = np.interp(xHat,tcgVolumes_,tcgValues_)
#                    mse = np.abs(yy-yHat)
                    
                    parameters_[k_] = {'slopes':slopes.tolist(), 'breaks':breaks[1:].tolist(), 'intercepts':intercepts.tolist()}
            
                    fig = plt.figure()
                    ax = plt.axes()
                    ax.plot(v_['vol'], lcg_mom_,'o')
                    ax.plot(xHat, yHat, '-')
                    ax.set_title(vessel_info_['name'] + ' Tank: ' + k_)
                    ax.set_xlabel("volume")
                    ax.set_ylabel("LCGMoment")
                    fig_name = vessel_info_['name'] + '_Tank_'+ k_
                    fig.savefig(fig_name + '.png')
                    plt.close(fig)
                        
                    print(k_ + ': LCG approximation done!!')
                    # with open(k_  +'_lcg_pw.pickle', 'wb') as fp_:
                    #     pickle.dump(parameters_, fp_)   
                        
                else:
                    
                    print(k_ + ': LCG approximation not needed!!')
                    # print(k_, v_['lcg'][-1], v_['lcg'][0], v_['lcg'][1] ,v_['lcg'][2])
            
            vessel_info_['tankLCG']['lcg_pw'] = parameters_
            with open(vessel_info_['name']  +'_lcg_pw.pickle', 'wb') as fp_:
                pickle.dump(parameters_, fp_)     
                
        else:
            
            with open(vessel_info_['name']  +'_lcg_pw.pickle', 'rb') as fp_:
                vessel_info_['tankLCG']['lcg_pw'] = pickle.load(fp_)
            
    
    def _get_tcg_parameters(self, vessel_info_, tcg_details_):
        
        # with open('tcg_data.json', 'w') as f_:  
        #     json.dump({'data':tcg_details_}, f_)

        
        if not Path(vessel_info_['name']+'_pw.pickle').is_file():
            npw_ = 10
            parameters_ = {'npw':npw_}
            
            for k_, v_ in tcg_details_.items():
                if v_['type'] in ['ballast','cargo'] and abs(v_['tcg'][-1]-v_['tcg'][2]) > 0.1:
                    
                    tcg_weight_ = np.array(v_['vol']) # density == 1 
                    tcg_mom_ = tcg_weight_ * np.array(v_['tcg'])
                    
                    my_pwlf = pwlf.PiecewiseLinFit(v_['vol'], tcg_mom_)
                    # fit the data for four line segments
                    breaks = my_pwlf.fit(npw_)
                    slopes = my_pwlf.calc_slopes()
                    intercepts = my_pwlf.intercepts
                    
                    ## predict for the determined points
                    xHat = np.linspace(min(v_['vol']), max(v_['vol']), num=1000)
                    yHat = np.zeros(len(xHat))
                    
                    for i__,i_ in enumerate(xHat):
                        
                        m_ = np.where(i_ <= breaks[1:])[0][0]
                        yHat[i__] = slopes[m_]*i_ + intercepts[m_]
                        
#                    yy = np.interp(xHat,tcgVolumes_,tcgValues_)
#                    mse = np.abs(yy-yHat)
                    
                    parameters_[k_] = {'slopes':slopes.tolist(), 'breaks':breaks[1:].tolist(), 'intercepts':intercepts.tolist()}
            
                    fig = plt.figure()
                    ax = plt.axes()
                    ax.plot(v_['vol'], tcg_mom_,'o')
                    ax.plot(xHat, yHat, '-')
                    ax.set_title(vessel_info_['name'] + ' Tank: ' + k_)
                    ax.set_xlabel("volume")
                    ax.set_ylabel("TCGMoment")
                    fig_name = vessel_info_['name'] + '_Tank_'+ k_
                    fig.savefig(fig_name + '.png')
                    plt.close(fig)
                        
                    print(k_ + ': TCG approximation done!!')
                else:
                    
                    print(k_ + ': TCG approximation not needed!!')
            
            vessel_info_['tankTCG']['tcg_pw'] = parameters_
            with open(vessel_info_['name']  +'_pw.pickle', 'wb') as fp_:
                pickle.dump(parameters_, fp_)     
                
        else:
            
            with open(vessel_info_['name']  +'_pw.pickle', 'rb') as fp_:
                vessel_info_['tankTCG']['tcg_pw'] = pickle.load(fp_)
    
    def _get_lcb_parameters(self, vessel_info_):
        
        if not Path(vessel_info_['name']+'_trim.pickle').is_file():
            npw_ = 10
            parameters_ = {'npw':npw_}
            
            # lower_draft_, upper_draft_ = 6, 22
            # lower_ind_ = np.where(vessel_info_['hydrostatic']['draft'] == lower_draft_)[0][0]
            # upper_ind_ = np.where(vessel_info_['hydrostatic']['draft'] == upper_draft_)[0][0]
            
            draft_ = vessel_info_['hydrostatic']['draft']
            lcb_   = vessel_info_['hydrostatic']['lcb']
            disp_  = vessel_info_['hydrostatic']['displacement']
            mtc_   = vessel_info_['hydrostatic']['mtc']
            
            with open('hydro_data.json', 'w') as f_:  
                json.dump({'draft':draft_.tolist(), 'lcb':lcb_.tolist(), 'disp':disp_.tolist(), 'mtc':mtc_.tolist() }, f_)

            
            # draft_ = vessel_info_['hydrostatic']['draft'][lower_ind_:upper_ind_]
            # lcb_   = vessel_info_['hydrostatic']['lcb'][lower_ind_:upper_ind_]
            # disp_  = vessel_info_['hydrostatic']['displacement'][lower_ind_:upper_ind_]
            # mtc_   = vessel_info_['hydrostatic']['mtc'][lower_ind_:upper_ind_]
                      
            ## LCB x disp ------------------------------------------------------------------------
            disp_lcb_ = lcb_ * disp_
            my_pwlf = pwlf.PiecewiseLinFit(disp_, disp_lcb_)
            # fit the data for four line segments
            breaks = my_pwlf.fit(npw_)
            slopes = my_pwlf.calc_slopes()
            intercepts = my_pwlf.intercepts
            
            ## predict for the determined points
            xHat = np.linspace(min(disp_), max(disp_), num=5000)
            yHat = np.zeros(len(xHat))
            
            for i__,i_ in enumerate(xHat):
                m_ = np.where(i_ <= breaks[1:])[0][0]
                yHat[i__] = slopes[m_]*i_ + intercepts[m_]
                
#                    yy = np.interp(xHat,tcgVolumes_,tcgValues_)
#                    mse = np.abs(yy-yHat)
            
            parameters_['lcb'] = {'slopes':slopes.tolist(), 'breaks':breaks[1:].tolist(), 'intercepts':intercepts.tolist()}
    
            fig = plt.figure()
            ax = plt.axes()
            ax.plot(disp_, disp_lcb_,'x')
            ax.plot(xHat, yHat, '-')
            ax.set_title('LCB')
            ax.set_xlabel("disp")
            ax.set_ylabel("Disp x LCB")
            fig.savefig('LCB.png')
            plt.close(fig)
            
            print('LCB approximation done!!')
            
            ## MTC --------------------------------------------------------------
            my_pwlf = pwlf.PiecewiseLinFit(disp_, mtc_)
            # fit the data for four line segments
            breaks = my_pwlf.fit(npw_)
            slopes = my_pwlf.calc_slopes()
            intercepts = my_pwlf.intercepts
            
            ## predict for the determined points
            xHat = np.linspace(min(disp_), max(disp_), num=5000)
            yHat = np.zeros(len(xHat))
            
            for i__,i_ in enumerate(xHat):
                m_ = np.where(i_ <= breaks[1:])[0][0]
                yHat[i__] = slopes[m_]*i_ + intercepts[m_]
                
#                    yy = np.interp(xHat,tcgVolumes_,tcgValues_)
#                    mse = np.abs(yy-yHat)
            
            parameters_['mtc'] = {'slopes':slopes.tolist(), 'breaks':breaks[1:].tolist(), 'intercepts':intercepts.tolist()}
    
            fig = plt.figure()
            ax = plt.axes()
            ax.plot(disp_, mtc_ ,'x')
            ax.plot(xHat, yHat, '-')
            ax.set_title('MTC')
            ax.set_xlabel("disp")
            ax.set_ylabel("MTC")
            fig.savefig('MTC.png')
            plt.close(fig)
            
            print('MTC approximation done!!')
            
            ## Draft --------------------------------------------------------------
          
            my_pwlf = pwlf.PiecewiseLinFit(disp_, draft_)
            # fit the data for four line segments
            breaks = my_pwlf.fit(npw_)
            slopes = my_pwlf.calc_slopes()
            intercepts = my_pwlf.intercepts
            
            ## predict for the determined points
            xHat = np.linspace(min(disp_), max(disp_), num=5000)
            yHat = np.zeros(len(xHat))
            
            for i__,i_ in enumerate(xHat):
                m_ = np.where(i_ <= breaks[1:])[0][0]
                yHat[i__] = slopes[m_]*i_ + intercepts[m_]
                
#                    yy = np.interp(xHat,tcgVolumes_,tcgValues_)
#                    mse = np.abs(yy-yHat)
            
            parameters_['draft'] = {'slopes':slopes.tolist(), 'breaks':breaks[1:].tolist(), 'intercepts':intercepts.tolist()}
    
            fig = plt.figure()
            ax = plt.axes()
            ax.plot(disp_, draft_,'x')
            ax.plot(xHat, yHat, '-')
            ax.set_title('Draft')
            ax.set_xlabel("disp")
            ax.set_ylabel("Draft")
            fig.savefig('Draft.png')
            plt.close(fig)
            
            print('Draft approximation done!!')
            
            vessel_info_['lcb_mtc'] = parameters_
            with open(vessel_info_['name']  +'_trim.pickle', 'wb') as fp_:
                pickle.dump(parameters_, fp_)     
                
        else:
            
            with open(vessel_info_['name']  +'_trim.pickle', 'rb') as fp_:
                vessel_info_['lcb_mtc'] = pickle.load(fp_)
                        
    def _get_ullage_func(self, vessel_info_, ullage_data):
        
        # with open('ullage_data.json', 'w') as f_:  
        #     json.dump({'data':vessel_info_['ullage']}, f_)
        
        if not Path(vessel_info_['name']+'_ullage.pickle').is_file():
            
            
            ullageDetails = pd.DataFrame(ullage_data['ullageDetails'], dtype=np.float)
            ullageTrimCorrections = pd.DataFrame(ullage_data['ullageTrimCorrections'], dtype=np.float)
            ullageTrimCorrections.drop(columns=['trimM2', 'trimM3', 'trimM4', 'trimM5'], inplace=True)
            
            ullage_func = {}
            ullage_inv_func = {}
            ullage_corr = {}
            ullage_data = {}
            
            for k_, v_ in vessel_info_['tankName'].items():
                
                print(k_,v_)
                
                ullage_ = ullageDetails[ullageDetails['tankId'] == v_]
                ullage_ = ullage_.sort_values(by='ullageDepth')
                
                ullage_corr_ = ullageTrimCorrections[ullageTrimCorrections['tankId'] == v_]
                ullage_corr_ = ullage_corr_.sort_values(by='ullageDepth')
                
                yy_ = []
                if k_ in vessel_info_['ballastTanks']:
                    yy_ = ullage_['soundDepth']
                elif k_ in vessel_info_['cargoTanks']:
                    yy_ = ullage_['ullageDepth']
                
                if len(yy_) >  0:
                    
                    ullage_func[str(v_)] = interp1d(ullage_['evenKeelCapacityCubm'], yy_)
                    ullage_inv_func[str(v_)] = interp1d(yy_, ullage_['evenKeelCapacityCubm'])
                    ullage_corr[str(v_)] = ullage_corr_.values.tolist()
                    ullage_data[str(v_)] = ullage_.values.tolist()
                    
                else:
                    print(k_,v_, 'is empty or not needed!!')
            
            vessel_info_['ullage']  = ullage_func
            vessel_info_['ullageCorr']  = ullage_corr
            
            with open(vessel_info_['name']  +'_ullage.pickle', 'wb') as fp_:
                pickle.dump([ullage_func, ullage_corr, ullage_inv_func, ullage_data], fp_)     
                
        else:
            
            with open(vessel_info_['name']  +'_ullage.pickle', 'rb') as fp_:
                vessel_info_['ullage'], vessel_info_['ullageCorr'], vessel_info_['ullageInvFunc'], _ = pickle.load(fp_)
            
    # def _get_ullage_corr(self, vessel_info_, ullageCorrDetails):
        
    #     # with open('ullage_data.json', 'w') as f_:  
    #     #     json.dump({'data':vessel_info_['ullage']}, f_)
        
    #     if not Path(vessel_info_['name']+'_ullage_corr.pickle').is_file():
            
    #         vessel_info_['ullageCorr'] = {}
            
    #         for d_ in ullageCorrDetails: #vessel_json['ullageDetails']:
    #             # print(d_['id'])
    #             if str(d_['tankId']) not in vessel_info_['ullageCorr']:
    #                 vessel_info_['ullageCorr'][str(d_['tankId'])] = {'depth':[float(d_['ullageDepth'])], 'corr':[[float(d_['trimM1']),float(d_['trim0']), float(d_['trim1']),
    #                                                                                                           float(d_['trim2']),float(d_['trim3']),float(d_['trim4']),
    #                                                                                                           float(d_['trim5']),float(d_['trim6'])]]}
    #             else:
    #                 vessel_info_['ullageCorr'][str(d_['tankId'])] ['depth'].append(float(d_['ullageDepth']))
    #                 vessel_info_['ullageCorr'][str(d_['tankId'])] ['corr'].append([float(d_['trimM1']),float(d_['trim0']), float(d_['trim1']),
    #                                                                                float(d_['trim2']),float(d_['trim3']),float(d_['trim4']),
    #                                                                                float(d_['trim5']),float(d_['trim6'])])
    #                 # vessel_info_['ullage'][str(d_['tankId'])] ['id'].append(d_['id'])
        
    #         func_ = {}
    #         for k_, v_ in vessel_info_['ullageCorr'].items():
                
    #             xx_, yy_, zz_ = [], [], []
    #             for a_, b_ in zip(v_['depth'], v_['corr']):
    #                 xx_ += [a_ for i_ in range(8)]
    #                 yy_ += [-1, 0, 1, 2, 3, 4, 5, 6]
    #                 zz_ += b_
                
    #             func_[k_] = interp2d(xx_, yy_, zz_)
            
    #         vessel_info_['ullage_corr'] = func_
            
    #         with open(vessel_info_['name']  +'_ullage_corr.pickle', 'wb') as fp_:
    #             pickle.dump(func_, fp_)     
                
    #     else:
            
    #         with open(vessel_info_['name']  +'_ullage_corr.pickle', 'rb') as fp_:
    #             vessel_info_['ullage_func_corr'] = pickle.load(fp_)
    
    
 
            
            
# {'WB5P': 25606, 'WB5S': 25607, 'AWBP': 25608, 'AWBS': 25609, 'APT': 25610, 'FO2P': 25614, 
#'FO2S': 25615, 'SLS': 25596, 'WB1S': 25599, 'WB2P': 25600, 'WB2S': 25601, 'WB3P': 25602, 'WB3S': 25603, 
#'WB4P': 25604, 'WB4S': 25605, '2C': 25581, '1P': 25585, '1S': 25586, '2P': 25587, '2S': 25588, 'DO1S': 25622, 
#'4P': 25591, '4S': 25592, '5P': 25593, '1C': 25580, '3C': 25582, '4C': 25583, '5C': 25584, '3P': 25589, '3S': 25590, 
#'5S': 25594, 'SLP': 25595, 'WB1P': 25598, 'FO1P': 25612, 'FO1S': 25613, 'DO2S': 25623, 'FOST': 25617, 
#'BFOSV': 25619, 'DOSV1': 25624, 'LFPT': 25597, 'UFPT': 25611, 'FOSV': 25616, 'DOSV2': 25625, 'DWP': 25636, 
#'FWS': 25637, 'DSWP': 25638, 'DSWS': 25639}
    
        
        
        
        