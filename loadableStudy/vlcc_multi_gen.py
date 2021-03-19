# -*- coding: utf-8 -*-
"""
Created on Tue Mar  2 17:19:26 2021

@author: I2R
"""

from copy import deepcopy
from vlcc_gen import Generate_plan
import numpy as np
from itertools import permutations

DEC_PLACE = 3

class Multiple_plans(object):
    
    def __init__(self, data, inputs):
#        self.outfile   = 'resmsg.json'
        self.input = inputs # original input
        self.json = data # original loadable
        self.multiple_input = deepcopy(inputs)
        # self.out = []
        
        
    def run(self):
        
        self.plans = {'ship_status':[], 'cargo_status':[], 'slop_qty':[], 'cargo_order':[],
                              'constraint':[], 'obj':[], 'cargo_tank':[],
                              'operation':[], 'rotation':[], 'message':{}}
        
        if not self.input.error:
            
            if self.input.gen_distinct_plan and len(self.input.loadable.info['rotationCheck']) > 0:
                
                list_ = self.input.loadable.info['rotationCheck'][0]
                permute_list_ = permutations(list_)
                for r__, r_ in enumerate(permute_list_):
                    print(r__, r_)
                    if r__ <= 5:
                        if list_ != list(r_):
                             new_input = self.multiple_input
                             new_input.cargo_rotation = list(r_)
                             new_input.loadable._create_operations(new_input) # operation and commingle
                             new_input.get_stability_param()
                             new_input.write_dat_file()
                             gen_output = Generate_plan(new_input)
                        else:
                            gen_output = Generate_plan(self.input)
                        
                        gen_output.run()
                        # gen_output.plan = {}
                        
                        if gen_output.plan.get('obj',[]):
                            ind_ = gen_output.plan['obj'].index(max(gen_output.plan['obj']))
                            self.plans['ship_status'].append(gen_output.plan['ship_status'][ind_])
                            self.plans['cargo_status'].append(gen_output.plan['cargo_status'][ind_])
                            self.plans['obj'].append(gen_output.plan['obj'][ind_])
                            self.plans['operation'].append(gen_output.plan['operation'][ind_])
                            self.plans['rotation'].append(list(r_))
                            self.plans['cargo_tank'].append(dict(gen_output.plan['cargo_tank'][ind_]))
                            self.plans['slop_qty'].append(gen_output.plan['slop_qty'][ind_])
                            self.plans['cargo_order'].append(gen_output.plan['cargo_order'][ind_])
                            
                            
                        else:
                            self.plans['message'] = {**self.plans['message'],**gen_output.plan.get('message',{})}
                
            elif self.input.gen_distinct_plan and len(self.input.loadable.info['parcel']) > 1:
                # single cargo at each port
                gen_output = Generate_plan(self.input)
                gen_output.run()
                
                
                # input("Press Enter to continue...")
                if gen_output.plan.get('obj',[]):
                    ind_ = gen_output.plan['obj'].index(max(gen_output.plan['obj']))
                    self.plans['ship_status'].append(gen_output.plan['ship_status'][ind_])
                    self.plans['cargo_status'].append(gen_output.plan['cargo_status'][ind_])
                    self.plans['obj'].append(gen_output.plan['obj'][ind_])
                    self.plans['operation'].append(gen_output.plan['operation'][ind_])
                    self.plans['rotation'].append([])
                    self.plans['cargo_tank'].append(dict(gen_output.plan['cargo_tank'][ind_]))
                    self.plans['slop_qty'].append(gen_output.plan['slop_qty'][ind_])
                    self.plans['cargo_order'].append(gen_output.plan['cargo_order'][ind_])
                            
                    
                    max_cargo_ = gen_output.max_tank_parcel
                    max_cargo_tank_ = list(gen_output.cargo_in_tank[ind_][max_cargo_])
                    
                    print('0 plan:',max_cargo_, max_cargo_tank_)
                    
                    for t_ in range(1,6): 
                        print('cargo max tank:',max_cargo_)
                        ban_tank_ = list(self.input.vessel.info['banCargo'][max_cargo_])
                        
                        rerun_ = False
                        if str(t_)+'C' in max_cargo_tank_:
                            ban_tank_ += [str(t_)+'C'] #[str(t_)+'P', str(t_)+'S']
                            rerun_ = True
                        elif str(t_)+'P' in max_cargo_tank_:
                            ban_tank_ += [str(t_)+'P', str(t_)+'S']
                            rerun_ = True
    
                             
                        if rerun_:
                            print('ban_tank:',ban_tank_)
                            new_input = self.multiple_input
                            new_input.vessel.info['banCargo'][max_cargo_] = ban_tank_
                            new_input.write_dat_file()
                            gen_output = Generate_plan(new_input)
                            gen_output.run()
                            
                            # input("Press Enter to continue...")
                            
                            if gen_output.plan.get('obj',[]):
                                ind_ = gen_output.plan['obj'].index(max(gen_output.plan['obj']))
                                self.plans['ship_status'].append(gen_output.plan['ship_status'][ind_])
                                self.plans['cargo_status'].append(gen_output.plan['cargo_status'][ind_])
                                self.plans['obj'].append(gen_output.plan['obj'][ind_])
                                self.plans['operation'].append(gen_output.plan['operation'][ind_])
                                self.plans['rotation'].append([])
                                self.plans['cargo_tank'].append(dict(gen_output.plan['cargo_tank'][ind_]))
                                self.plans['slop_qty'].append(gen_output.plan['slop_qty'][ind_])
                                self.plans['cargo_order'].append(gen_output.plan['cargo_order'][ind_])
                            
                    
                else:
                    self.plans['message'] = {**self.plans['message'], **gen_output.plan['message']}
                    
            else:
                
                gen_output = Generate_plan(self.input)
                gen_output.run()
                
                if gen_output.plan.get('obj',[]):
                    self.plans = gen_output.plan
                    self.plans['rotation'] = [[] for p_ in range(len(gen_output.plan['ship_status']))]
                
                else:
                    self.plans['message'] = {**self.plans['message'], **gen_output.plan['message']}
                        
                
                
                
               
            # final sorting
            if len(self.plans['obj']) > 0:
                sort_ = np.argsort(-np.array(self.plans['obj']))
                self.plans['ship_status'] = [self.plans['ship_status'][i_] for i_ in sort_]
                self.plans['cargo_status'] = [self.plans['cargo_status'][i_] for i_ in sort_]
                self.plans['obj'] = [self.plans['obj'][i_] for i_ in sort_]
                self.plans['operation'] = [self.plans['operation'][i_] for i_ in sort_]
                self.plans['rotation'] = [self.plans['rotation'][i_] for i_ in sort_]
                self.plans['cargo_tank'] = [self.plans['cargo_tank'][i_] for i_ in sort_]
                self.plans['slop_qty'] = [self.plans['slop_qty'][i_] for i_ in sort_]
                self.plans['cargo_order'] = [self.plans['cargo_order'][i_] for i_ in sort_]
                
                
            
    def gen_json(self, constraints, stability_values):
        data = {}
        data['message'] = None
        data['processId'] = self.input.process_id
        
        if len(self.plans['ship_status']) == 0:
            data['loadablePlanDetails'] = [] #self.plan['message']
            data['message'] = {**self.input.error, **self.plans['message']}
            
            data['errors'] = self._format_errors(data['message'])
                        
            return data
        
        
        
        # data['loadableStudyId'] = str(self.input.loadable_id)
        # data['vesselId'] = str(self.input.vessel_id)
        # data['voyageId'] = str(self.input.voyage_id)
        
        # all loading port
        path_ = [self.input.port.info['portOrder'][str(i_+1)]  for i_ in range(self.input.port.info['numPort'])]
        
        data['loadablePlanDetails'] = []
        for s_ in range(len(self.plans['ship_status'])):
            plan = {}
            plan['caseNumber'] = str(s_+1)
            plan['loadablePlanPortWiseDetails'] = []
            plan['constraints'] = constraints[str(s_)]
            plan['stabilityParameters'] = stability_values[s_][self.input.loadable.info['arrDepVirtualPort'][str(self.input.port.info['lastLoadingPort'])+'D']]
            plan['slopQuantity'] = str(self.plans['slop_qty'][s_])
            
            for p__,p_ in enumerate(path_):
                plan_ = {}
                plan_['portId'] = str(self.input.port.info['portRotation'][p_]['portId'])
                plan_['portCode'] = p_
                plan_['portRotationId'] = self.input.port.info['portRotation'][p_]['portRotationId']
                # arrival
                plan_['arrivalCondition'] = {"loadableQuantityCargoDetails":[],
                                              "loadableQuantityCommingleCargoDetails":[],
                                              "loadablePlanStowageDetails":[],
                                              "loadablePlanBallastDetails":[],
                                              "loadablePlanRoBDetails":[]}
                
                if p_ not in [path_[0]]:
                    # print(s_,p_, 'Get arrival info')
                    plan_['arrivalCondition']["loadableQuantityCargoDetails"] = self._get_status(s_, str(p__+1)+'A', 'total')
                    # get loadablePlanStowageDetails
                    plan_['arrivalCondition']["loadablePlanStowageDetails"] = self._get_status(s_, str(p__+1)+'A', 'cargoStatus')
                    # get loadablePlanBallastDetails
                    plan_['arrivalCondition']["loadablePlanBallastDetails"] = self._get_status(s_, str(p__+1)+'A', 'ballastStatus')
                    # get loadablePlanRoBDetails
                    plan_['arrivalCondition']["loadablePlanRoBDetails"] = self._get_status(s_, str(p__+1)+'A', 'robStatus')
                    # get loadableQuantityCommingleCargoDetails
                    plan_['arrivalCondition']["loadableQuantityCommingleCargoDetails"] = self._get_status(s_, str(p__+1)+'A', 'commingleStatus')
                    
                
                # departure
                plan_['departureCondition'] = {"loadableQuantityCargoDetails":[],
                                              "loadableQuantityCommingleCargoDetails":[],
                                              "loadablePlanStowageDetails":[],
                                              "loadablePlanBallastDetails":[],
                                              "loadablePlanRoBDetails":[]}
                
                if p_ not in [path_[-1]]:
                    # print(s_,p_,'Get departure info')
                    # get loadableQuantityCargoDetails
                    plan_['departureCondition']["loadableQuantityCargoDetails"] = self._get_status(s_, str(p__+1)+'D', 'total')
                    # get loadablePlanStowageDetails
                    plan_['departureCondition']["loadablePlanStowageDetails"] = self._get_status(s_, str(p__+1)+'D', 'cargoStatus')
                    # get loadablePlanBallastDetails
                    plan_['departureCondition']["loadablePlanBallastDetails"] = self._get_status(s_, str(p__+1)+'D', 'ballastStatus')
                    # get loadablePlanRoBDetails
                    plan_['departureCondition']["loadablePlanRoBDetails"] = self._get_status(s_, str(p__+1)+'D', 'robStatus')
                    # get loadableQuantityCommingleCargoDetails
                    plan_['departureCondition']["loadableQuantityCommingleCargoDetails"] = self._get_status(s_, str(p__+1)+'D', 'commingleStatus')
                    
                
                plan['loadablePlanPortWiseDetails'].append(plan_)
                
            data['loadablePlanDetails'].append(plan)
        data['message'] = {'limits':self.input.limits}
                
      
        return data
    
    
    def _get_status(self,sol,port,category):
        plan = []
        virtual_ = self.input.loadable.info['arrDepVirtualPort'][port]
        
        if category == 'total':
            
            for k_, v_ in self.plans['cargo_status'][sol][virtual_].items():
                if v_ > 0.:
                    info_ = {}
                    info_["cargoId"] = str(self.input.loadable.info['parcel'][k_]['cargoId'])
                    info_['cargoAbbreviation'] = self.input.loadable.info['parcel'][k_]['abbreviation']
                    info_['estimatedAPI'] = str(self.input.loadable.info['parcel'][k_]['api'])
                    info_['estimatedTemp'] = str(self.input.loadable.info['parcel'][k_]['temperature'])
                    info_['loadableMT'] = str(v_)
                    info_['priority'] = str(self.input.loadable.info['parcel'][k_]['priority'])
                    info_['colorCode'] = self.input.loadable.info['parcel'][k_]['color']
                    intend_ = self.input.loadable.info['toLoadIntend'][k_]
                    info_['orderedQuantity'] = str(round(intend_,DEC_PLACE))
                    info_['differencePercentage'] = str(round((v_-intend_)/intend_*100,2))
                    info_['loadingOrder'] = str(self.plans['cargo_order'][sol][k_])
                    info_["maxTolerance"] = str(self.input.loadable.info['parcel'][k_]['minMaxTol'][1])
                    info_["minTolerance"] = str(self.input.loadable.info['parcel'][k_]['minMaxTol'][0])
          
          
                    plan.append(info_)
            
        elif category == 'cargoStatus':
                        
            for k_,v_ in self.plans['ship_status'][sol][virtual_]['cargo'].items():
                # print(k_,v_)
                if type(v_[0]['parcel']) == str and v_[0]['parcel'] in self.input.loadable.info['parcel'].keys():
                    info_ = {}
                    info_['tank'] = k_
                    info_['quantityMT'] = str(abs(v_[0]['wt']))
                    
                    info_['cargoAbbreviation'] = self.input.loadable.info['parcel'][v_[0]['parcel']]['abbreviation']
                    info_['tankId'] = str(self.input.vessel.info['tankName'][k_])
                    info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                    info_['tankName'] = self.input.vessel.info['cargoTanks'][k_]['name']
                    
                    
                    info_['temperature'] = str(self.input.loadable.info['parcel'][v_[0]['parcel']]['temperature'])
                    info_['colorCode'] = self.input.loadable.info['parcel'][v_[0]['parcel']]['color']
                    info_['api'] = str(self.input.loadable.info['parcel'][v_[0]['parcel']]['api'])
                    
                    info_['cargoNominationId'] = v_[0]['parcel'][1:]
                    info_['onboard'] = self.input.vessel.info['onboard'].get(k_,{}).get('wt',0.)
                    
                    vol_ = abs(v_[0]['wt'])/v_[0]['SG']
                    info_['rdgUllage'] = str(round(self.input.vessel.info['ullage_func'][str(info_['tankId'])](vol_).tolist(), 2))
                   
                    plan.append(info_)
                    
                elif type(v_[0]['parcel']) == str:
                	# only onboard 
                    info_ = {}
                    info_['tank'] = k_
                    info_['quantityMT'] = str(abs(v_[0]['wt']))
                    info_['cargoAbbreviation'] = None
                    info_['tankId'] = str(self.input.vessel.info['tankName'][k_])
                    
                    
                    info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                    info_['tankName'] = self.input.vessel.info['cargoTanks'][k_]['name']
                    info_['temperature'] = None
                    info_['colorCode'] = self.input.vessel.info['cargoTanks'][k_]['colorCode']
                    info_['api'] = self.input.vessel.info['cargoTanks'][k_]['api']
                    
                    vol_ = abs(v_[0]['wt'])/v_[0]['SG']
                    info_['rdgUllage'] = str(round(self.input.vessel.info['ullage_func'][str(info_['tankId'])](vol_).tolist(), 2))
                    info_['cargoNominationId'] = ''
                    info_['onboard'] = self.input.vessel.info['onboard'].get(k_,{}).get('wt',0.)
                    
                    plan.append(info_)
                    
                    
                    
        elif category == 'commingleStatus':
            
            for k_,v_ in self.plans['ship_status'][sol][virtual_]['cargo'].items():
                if type(v_[0]['parcel']) == list:
                    info_ = {}
                    
                    info_['tank'] = k_
                    info_['quantity'] = str(abs(v_[0]['wt']))
                    info_['cargo1Abbreviation'] = self.input.loadable.info['parcel'][v_[0]['parcel'][0]]['abbreviation']
                    info_['cargo2Abbreviation'] = self.input.loadable.info['parcel'][v_[0]['parcel'][1]]['abbreviation']
                    info_['priority'] = str(self.input.loadable.info['commingleCargo']['priority'])
                    
                    info_['cargoNomination1Id'] = v_[0]['parcel'][0][1:]
                    info_['cargoNomination2Id'] = v_[0]['parcel'][1][1:]
                     
                    
                    
                    info_['priority'] = str(self.input.loadable.info['commingleCargo']['priority'])
                    info_['cargo1Percentage'] = str(round(v_[0]['wt1percent']*100,2))
                    info_['cargo2Percentage'] = str(round(v_[0]['wt2percent']*100,2))
                    info_['cargo1MT'] = str(v_[0]['wt1'])
                    info_['cargo2MT'] = str(v_[0]['wt2'])
                    
                    info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                    info_['temp'] = str(v_[0]['temperature'])
                    
                    info_['api'] =  str(round(v_[0]['api'],2))
                    info_['tankId'] = self.input.vessel.info['tankName'][k_]
                    info_['tankName'] = self.input.vessel.info['cargoTanks'][k_]['name']
                    vol_ = abs(v_[0]['wt'])/v_[0]['SG']
                    info_['rdgUllage'] = round(self.input.vessel.info['ullage_func'][str(info_['tankId'])](vol_).tolist(), 2)
                   
                    info_['onboard'] = self.input.vessel.info['onboard'].get(k_,{}).get('wt',0.)
                    plan.append(info_)
                
        elif category == 'ballastStatus':
            
            for k_,v_ in self.plans['ship_status'][sol][virtual_]['ballast'].items():
                info_ = {}
                info_['tank'] = k_
                info_['quantityMT'] = str(round(abs(v_[0]['wt']),2))
                info_['fillingRatio'] = str(round(v_[0]['fillRatio']*100,2))
                info_['sg'] = str(v_[0]['SG'])
                
                info_['tankId'] = str(self.input.vessel.info['tankName'][k_])
                info_['tankName'] = self.input.vessel.info['ballastTanks'][k_]['name']
                vol_ = np.floor(abs(v_[0]['wt'])/v_[0]['SG']) # + self.input.vessel.info['onboard'].get(k_,{}).get('vol',0.)
                
                try:
                    ul_= self.input.vessel.info['ullage_func'][str(info_['tankId'])](vol_).tolist()
                except:
                    print(k_, vol_)
                    ul_ = 0.
                info_['rdgLevel'] = str(round(ul_, 2))
                
                plan.append(info_)
                
                
        elif category == 'robStatus':
            
            for k_,v_ in self.plans['ship_status'][sol][virtual_]['other'].items():
                info_ = {}
                info_['tank'] = k_
                info_['quantity'] = str(abs(v_[0]['wt']))
                info_['sg'] = str(v_[0]['SG'])
                info_['tankId'] = str(self.input.vessel.info['tankName'][k_])
             
                plan.append(info_)
        
        return plan

    def _format_errors(self, message):
        errors = []
        for k_, v_ in message.items():
            errors.append({"errorHeading":k_, "errorDetails":v_})
        
        return errors
        
    
    def _cal_density(self, api, temperature_F):
        
        temperature = ((temperature_F - 32)*5/9*100+0.5)/100
        # temp_F_ = round(temperature*1.8+32,1)
        
        sg_60_ = round(141.5/(api+131.5),4) # SG@60F
        
        # density@15C in vacuum
        if sg_60_ < 0.68:
            density_15C_ = sg_60_ - 0.0001
        elif sg_60_ < 0.7389:
            density_15C_ = sg_60_ - 0.0002
        elif sg_60_ < 0.7929:
            density_15C_ = sg_60_ - 0.0003
        elif sg_60_ < 0.8609:
            density_15C_ = sg_60_ - 0.0004
        elif sg_60_ < 0.9549:
            density_15C_ = sg_60_ - 0.0005
        else:
            density_15C_ = sg_60_ - 0.0006
            
        vcf_ = np.exp(-(613.97231/(density_15C_*1000)**2)*(temperature-15.0)*(1.0+(0.8*(613.97231/(density_15C_*1000)**2)*(temperature-15.0))))
        
        # density@15C in air == density_15C_-0.0011
        density = (density_15C_-0.0011)*vcf_  # 
        
        # temp_diff_ = temperature - 15
        # density_ = density_15C_ - 0.0006*temp_diff_
        
#        print(temp_F_,sg_60_,round(density_15C_,4),round(vcf_,5),round(density_,4))
    
        return round(density,4)
    

                
        