# -*- coding: utf-8 -*-
"""
Created on Fri Nov 20 10:59:03 2020

@author: I2R
"""
DEC_PLACE = 3
import numpy as np
import itertools

class Loadable:
    def __init__(self, inputs):
        
        cargos_info_ = {}
        cargos_info_['parcel'] = {}
        cargos_info_['sg'] = []
        cargos_info_['maxPriority'] = 0
        cargos_info_['priority'] = {i_:[] for i_ in range(10)}
        
        
        
        # operations_ = {}
        
        for c__, c_ in enumerate(inputs.loadable_json['cargoNomination']):
#            print(c_)
            cargo_id_ = 'P' + str(c_['id'])
            
            cargos_info_['parcel'][cargo_id_] = {}
#            cargos_info_['parcel'][cargo_id_]['cargoName'] = c_['cargoname']
            cargos_info_['parcel'][cargo_id_]['cargoId']   = c_['cargoId']
            cargos_info_['parcel'][cargo_id_]['minMaxTol'] = [c_['minTolerance'], c_['maxTolerance']]
            cargos_info_['parcel'][cargo_id_]['priority']  = c_['priority']
            # cargos_info_['parcel'][cargo_id_]['temperature']  = c_['temperature']
            cargos_info_['parcel'][cargo_id_]['color']  = c_['color']
            cargos_info_['parcel'][cargo_id_]['api']  = c_['api']
            cargos_info_['parcel'][cargo_id_]['abbreviation']  = c_['abbreviation']
                        
            if c_['api'] > 90:
                message_ = 'API > 90 for cargoNomination ' + cargo_id_[1:] + '!!'
                if 'API Error' not in inputs.error.keys():
                    inputs.error['API Error'] = [message_]
                else:
                    inputs.error['API Error'].append(message_)
            
            ## temperature, correction factor
            first_loading_port_ = 1
            for o__, o_ in enumerate(inputs.loadable_json['cargoOperation']):
                if c_['id'] == o_['cargoNominationId']:
                    port_order_ = int(inputs.port.info['idPortOrder'][str(o_['portId'])])
                    first_loading_port_ = min(first_loading_port_, port_order_)
                    
            ambient_ = []
            for k_, v_ in inputs.port.info['ambientTemperature'].items():
                if first_loading_port_ <= int(k_):
                    ambient_.append(round(float(v_)*1.8+32,2))
                    
                
            temp_F_, api_ = c_['temperature'], c_['api']
            temp_F_ = max(temp_F_, inputs.air_temperature, max(ambient_))
            
            sg_ = self._cal_density(api_,temp_F_)
            
            cargos_info_['parcel'][cargo_id_]['temperature'] = temp_F_
#            print(sg_, c_['sg'])
            
            cargos_info_['parcel'][cargo_id_]['SG']  = sg_
            cargos_info_['parcel'][cargo_id_]['maxtempSG']  = sg_
            cargos_info_['parcel'][cargo_id_]['mintempSG']  = sg_
            cargos_info_['sg'].append(sg_)
            
            cargos_info_['maxPriority'] = max(cargos_info_['maxPriority'], c_['priority'])
            cargos_info_['priority'][c_['priority']].append(cargo_id_)
       
        self.info = cargos_info_ 
        
        
    def _create_operations(self,inputs):
        
        cargos_info_ = {}
        cargos_info_['cargoPort'] = {k_:[] for k_,v_ in inputs.port.info['idPortOrder'].items()}
        cargos_info_['cargoRotation'] = {}
        cargos_info_['rotationCheck'] = []
        
        for o__, o_ in enumerate(inputs.loadable_json['cargoOperation']):
            cargos_info_['cargoPort'][str(o_['portId'])].append('P'+str(o_['cargoNominationId']))
            if len(cargos_info_['cargoPort'][str(o_['portId'])]) > 1:
                if inputs.cargo_rotation:
                    cargos_info_['cargoRotation'][str(o_['portId'])] = inputs.cargo_rotation
                else:
                    cargos_info_['cargoRotation'][str(o_['portId'])] = cargos_info_['cargoPort'][str(o_['portId'])]
                
        len_virtual_ports_ = len(inputs.port.info['portOrder'])*2 # without cargo rotation
        
        # order -> virtual order (only departure)
        virtual_port_ = {}
        arr_dep_virtual_port_ = {}
        max_virtual_port_ = 0
        virtual_arr_dep_ = {}
        rotation_virtual_, rotation_cargo_ = [], []
        
        print('cargo rotation:', cargos_info_['cargoRotation'])
        
        if len(cargos_info_['cargoRotation']) == 1:
            print('cargo rotation required')
            rotation_portId_ = [*cargos_info_['cargoRotation']][0]
            rotation_portOrder_ = inputs.port.info['idPortOrder'][rotation_portId_]
            rotation_cargo_ = cargos_info_['cargoRotation'][rotation_portId_]
            rotation_len_ = len(rotation_cargo_)
            
            # store current rotation
            cargos_info_['rotationCheck'].append(list(cargos_info_['cargoRotation'].values())[0])
            len_virtual_ports_ += rotation_len_-1
            
            k__ = 0
            for k_ in range(1,inputs.port.info['numPort']+1):
                if str(k_) == rotation_portOrder_:
                    arr_dep_virtual_port_[str(k_)+'A'] = str(2*int(k_)-1-1)
                    virtual_arr_dep_[str(2*int(k_)-1-1)] = str(k_)+'A'
                    virtual_port_[str(k_)] = {}
                    for c__, c_ in enumerate(rotation_cargo_):
                        v_ = 2*int(k_)-1 + c__
                        virtual_port_[str(k_)][c_] = str(v_)
                        rotation_virtual_.append(v_)
                    k__ = c__
                    
                    arr_dep_virtual_port_[str(k_)+'D'] = str(v_)
                    virtual_arr_dep_[str(v_)] = str(k_)+'D'
                    max_virtual_port_ = v_ if v_ > max_virtual_port_ else max_virtual_port_
                else:
                    v_ = 2*int(k_)-1 + k__
                    virtual_port_[str(k_)] = str(v_)
                    arr_dep_virtual_port_[str(k_)+'A'] = str(v_-1)
                    arr_dep_virtual_port_[str(k_)+'D'] = str(v_)
                    
                    virtual_arr_dep_[str(v_-1)] = str(k_)+'A'
                    virtual_arr_dep_[str(v_)] = str(k_)+'D'
                    
                    max_virtual_port_ = v_ if v_ > max_virtual_port_ else max_virtual_port_
                    
        else:
            print('cargo rotation not required or ignored')
            # order -> virtual order (only departure)
            virtual_port_ = {str(k_):str(2*int(k_)-1) for k_ in inputs.port.info['portOrderId']}
            # rotation_cargo_ = {}
            
            for k_ in range(1,inputs.port.info['numPort']+1):
                v_ = 2*int(k_)-1
                arr_dep_virtual_port_[str(k_)+'A'] = str(v_-1)
                arr_dep_virtual_port_[str(k_)+'D'] = str(v_)
                
                virtual_arr_dep_[str(v_-1)] = str(k_)+'A'
                virtual_arr_dep_[str(v_)] = str(k_)+'D'
                
                max_virtual_port_ = v_ if v_ > max_virtual_port_ else max_virtual_port_
                
        last_arr_ = '1A'
        for k_ in range(max_virtual_port_+1):
            arr_dep_ = virtual_arr_dep_.get(str(k_),'11NK')
            if arr_dep_ == '11NK':
                virtual_arr_dep_[str(k_)] = str(last_arr_[:-1])+'D'
                
            last_arr_ = arr_dep_ if arr_dep_[-1] == 'A' else last_arr_
            
        print(virtual_port_)    
        cargos_info_['virtualPort'] = virtual_port_
        cargos_info_['arrDepVirtualPort'] = arr_dep_virtual_port_
        cargos_info_['virtualArrDepPort'] = virtual_arr_dep_
        cargos_info_['lastVirtualPort'] = max_virtual_port_
        cargos_info_['rotationVirtual'] = rotation_virtual_ # rotation virtual port
        cargos_info_['rotationCargo']   = rotation_cargo_ # rotation virtual port
        
        # sea water density
        cargos_info_['seawaterDensity'] = {}
        for k_, v_ in cargos_info_['virtualArrDepPort'].items():
            port_name_ = inputs.port.info['portOrder'][v_[:-1]]
            cargos_info_['seawaterDensity'][k_] = inputs.port.info['portRotation'][port_name_]['seawaterDensity']
            
            
        # cargos_info_ = {}
        
        cargos_info_['commingleCargo'] = {}
        for c__, c_ in enumerate(inputs.loadable_json['commingleCargo']):
            # print('Commingle cargo!!')
            c1_ = 'P'+str(c_['cargoNomination1Id'])
            c2_ = 'P'+str(c_['cargoNomination2Id'])
            
            cargos_info_['commingleCargo']['parcel1'] = c1_
            cargos_info_['commingleCargo']['parcel2'] = c2_
            t1_, t2_ = self.info['parcel'][c1_]['temperature'], self.info['parcel'][c2_]['temperature']
            
            api1_ = self.info['parcel'][c1_]['api']
            api2_ = self.info['parcel'][c2_]['api']
              
            if str(c_['purposeXid']) == str(1):
                print('Commingle cargo in auto mode!!')
                if inputs.commingle_temperature in [None]:
                    cargos_info_['commingleCargo']['temperature'] = min(t1_,t2_) + abs(t1_-t2_)*0.6
                else:
                    cargos_info_['commingleCargo']['temperature'] = inputs.commingle_temperature
                print('approx commingle temperature:', cargos_info_['commingleCargo']['temperature'])
                
            else:
                print('Commingle cargo in manual mode!!')
                # inputs.error.append('Commingle cargo in manual mode not supported yet!!')
                # return
                
                wt1_ = float(c_['quantity'])*float(c_['cargo1Percentage'])*0.01
                wt2_ = float(c_['quantity'])*float(c_['cargo2Percentage'])*0.01
                
                cargos_info_['commingleCargo']['temperature'] = (wt1_*t1_ + wt2_*t2_)/(wt1_ + wt2_)
                print('approx commingle temperature:', cargos_info_['commingleCargo']['temperature'])
                cargos_info_['commingleCargo']['tank'] = [d_ for d_ in c_['tankIds'].split(',')]
                cargos_info_['commingleCargo']['wt1'] = wt1_
                cargos_info_['commingleCargo']['wt2'] = wt2_
                
            cargos_info_['commingleCargo']['SG1'] = self._cal_density(api1_, cargos_info_['commingleCargo']['temperature'])
            cargos_info_['commingleCargo']['SG2'] = self._cal_density(api2_, cargos_info_['commingleCargo']['temperature'])
            
            cargos_info_['commingleCargo']['api1'] = self.info['parcel'][c1_]['api']
            cargos_info_['commingleCargo']['api2'] = self.info['parcel'][c2_]['api']
            
            cargos_info_['commingleCargo']['t1'] = self.info['parcel'][c1_]['temperature']
            cargos_info_['commingleCargo']['t2'] = self.info['parcel'][c2_]['temperature']
            cargos_info_['commingleCargo']['priority'] = str(c_['priority'])
            cargos_info_['commingleCargo']['mode'] = str(c_['purposeXid'])
            
            cargos_info_['commingleCargo']['slopOnly'] = c_.get('isSlopOnly',False)
            cargos_info_['commingleCargo']['colorCode'] = c_.get('color', None)
            
                
        
        cargos_info_['operation'] = {k_:{}  for k_,v_ in self.info['parcel'].items()}
        cargos_info_['toLoad'] = {k_:0 for k_,v_ in self.info['parcel'].items()}
        cargos_info_['toLoadIntend']    = {k_:0 for k_,v_ in self.info['parcel'].items()}
        cargos_info_['toLoadMin'] = {k_:0 for k_,v_ in self.info['parcel'].items()}
        
        cargos_info_['toLoadPort'] = np.zeros(int(virtual_port_[str(inputs.port.info['numPort'])])+1) # exact ports to virtual ports
        cargos_info_['toLoadMinPort'] = np.zeros(int(virtual_port_[str(inputs.port.info['numPort'])])+1) # exact ports to virtual ports
        cargos_info_['cargoOrder'] = {str(p_):[] for p_ in range(1,max_virtual_port_+1)}
        for o__, o_ in enumerate(inputs.loadable_json['cargoOperation']):
            parcel_ = 'P'+str(o_['cargoNominationId'])
            qty__ = float(o_['quantity']) #if o_['operationId'] == 1 else -o_['quantity'] 
            order_ = inputs.port.info['idPortOrder'][str(o_['portId'])]
            # max qty
            qty_ = qty__ * (1+ 0.01*self.info['parcel'][parcel_]['minMaxTol'][1])
            # min qty
            qty_min_ = qty__ *(1 + 0.01*self.info['parcel'][parcel_]['minMaxTol'][0])
            
            
            cargos_info_['toLoad']['P'+str(o_['cargoNominationId'])] += qty_
            cargos_info_['toLoadIntend']['P'+str(o_['cargoNominationId'])] += qty__
            cargos_info_['toLoadMin']['P'+str(o_['cargoNominationId'])] += qty_min_
            
            if type(virtual_port_[str(order_)]) == dict:
                virtual_order_ = virtual_port_[str(order_)][parcel_]
            else:
                virtual_order_ = virtual_port_[str(order_)]
            
            cargos_info_['toLoadPort'][int(virtual_order_)] += qty_
            cargos_info_['toLoadMinPort'][int(virtual_order_)] += qty_min_
            cargos_info_['operation'][parcel_][virtual_order_] = qty_
            
            if qty_ > 0:
                cargos_info_['cargoOrder'][virtual_order_].append(parcel_)
                
            
            ## single loading port for each cargo set the discharging qty 
            ## no discharge info
            last_discharge_port_ = virtual_port_[str(inputs.port.info['numPort'])]
            if last_discharge_port_ not in cargos_info_['operation'][parcel_]:
                cargos_info_['operation'][parcel_][last_discharge_port_] = -qty_
            else:
                cargos_info_['operation'][parcel_][last_discharge_port_] += -qty_
                
            cargos_info_['toLoadPort'][int(last_discharge_port_)] += -qty_
            cargos_info_['toLoadMinPort'][int(last_discharge_port_)] += -qty_min_
            
            
            
        cargos_info_['toLoadPort1'] = {a__:a_ for a__, a_ in enumerate(cargos_info_['toLoadPort']) if a_ > 0} 
        cargos_info_['toLoadPort'] = np.cumsum(cargos_info_['toLoadPort'])
        cargos_info_['toLoadMinPort'] = np.cumsum(cargos_info_['toLoadMinPort'])
        
        cargos_info_['numParcel'] = len(self.info['parcel'])
        
        cargo_order_ = [v_ for k_,v_ in  cargos_info_['cargoOrder'].items()]
        cargo_order_ = list(itertools.chain.from_iterable(cargo_order_))
        cargos_info_['cargoOrder'] = {c_:c__+1 for c__,c_ in enumerate(cargo_order_)}
        
        
        # for k_, v_ in self.info['parcel'].items():
        #     loading_order_ = cargo_order_.index(k_) + 1
        #     self.info['parcel'][k_]['loadingOrder'] = loading_order_
        
        # cargos_info_['cargoRotation'] = {}
        # for p__, p_ in enumerate(inputs.port.info['ballastList']):
        #     cargos_ = [k_ for k_,v_ in cargos_info_['operation'].items() if v_.get(str(p_),0.) > 0.]
        #     if len(cargos_) > 1:
        #         # print(p_, cargos_)
        #         port_order_ = round(0.5*p_+0.51) # convert virtual port to exact port
        #         cargos_info_['cargoRotation'][str(port_order_)] = cargos_
            
        cargos_info_['manualOperation'] = {}
        for k_, v_ in inputs.loadable_json['loadingPlan'].items():
            order_ = k_
            for k__, v__ in v_.items():
                parcel_ = v__[0]['parcel']
                if parcel_ not in cargos_info_['manualOperation'].keys():
                    cargos_info_['manualOperation'][parcel_] = {}
                    
                qty_ = float(v__[0]['wt']) 
                tank_ = k__
                    
                if order_ not in cargos_info_['manualOperation'][parcel_].keys():
                    cargos_info_['manualOperation'][parcel_][order_] = [{'qty':qty_, 'tank':tank_}]
                else:
                    cargos_info_['manualOperation'][parcel_][order_].append({'qty':qty_, 'tank':tank_})
            
        cargos_info_['preloadOperation'] = {}
        
        cargos_info_['ballastOperation'] = {}
        cargos_info_['fixedBallastPort'] = []
        
        if inputs.mode in ['Auto']:
            for k_, v_ in inputs.loadable_json['ballastPlan'].items():
                order_ = k_
                cargos_info_['fixedBallastPort'].append(order_)
                for k__, v__ in v_.items():
                    tank_ = k__
                    qty_ = float(v__[0]['wt']) 
                    
                    if tank_ not in cargos_info_['ballastOperation'].keys():
                        cargos_info_['ballastOperation'][tank_] = [{'qty':qty_, 'order':order_}]
                    else:
                        cargos_info_['ballastOperation'][tank_].append({'qty':qty_, 'order':order_})
            
                
            
        if len(cargos_info_['fixedBallastPort']) > 0:
            # fixed ballast:
            cargos_info_['stablePorts'] = [str(i_)  for i_ in range(1,cargos_info_['lastVirtualPort']) if str(i_) not in  cargos_info_['fixedBallastPort']]    
        
        self.info = {**self.info, **cargos_info_}     
        
    def _create_man_operations(self,inputs):
        
        cargos_info_ = {}
        cargos_info_['cargoPort'] = {k_:[] for k_,v_ in inputs.port.info['idPortOrder'].items()}
        cargos_info_['cargoLastLoad'] = {k_:[] for k_,v_ in self.info['parcel'].items()}
        # cargos_info_['cargoRotation'] = {}
        # cargos_info_['rotationCheck'] = []
        
        for o__, o_ in enumerate(inputs.loadable_json['cargoOperation']):
            cargos_info_['cargoLastLoad']['P'+str(o_['cargoNominationId'])].append(inputs.port.info['idPortOrder'][str(o_['portId'])])
            cargos_info_['cargoPort'][str(o_['portId'])].append('P'+str(o_['cargoNominationId']))
            
            # if len(cargos_info_['cargoPort'][str(o_['portId'])]) > 1:
            #     if inputs.cargo_rotation:
            #         cargos_info_['cargoRotation'][str(o_['portId'])] = inputs.cargo_rotation
            #     else:
            #         cargos_info_['cargoRotation'][str(o_['portId'])] = cargos_info_['cargoPort'][str(o_['portId'])]
                
        len_virtual_ports_ = len(inputs.port.info['portOrder'])*2 # without cargo rotation
        cargos_info_['virtualArrDepPort'], cargos_info_['arrDepVirtualPort']  = {},{}
        for l_ in range(int(len_virtual_ports_/2)):
            virtual_port_ = 2*(l_)
            cargos_info_['virtualArrDepPort'][str(virtual_port_)] = str(l_+1)+'A'
            cargos_info_['virtualArrDepPort'][str(virtual_port_+1)] = str(l_+1)+'D'
            
            cargos_info_['arrDepVirtualPort'][str(l_+1)+'A'] = str(virtual_port_)
            cargos_info_['arrDepVirtualPort'][str(l_+1)+'D'] = str(virtual_port_+1)
            
        
        # sea water density ---------------------------------------------------------------------
        cargos_info_['seawaterDensity'] = {}
        for k_, v_ in cargos_info_['virtualArrDepPort'].items():
            port_name_ = inputs.port.info['portOrder'][v_[:-1]]
            cargos_info_['seawaterDensity'][k_] = inputs.port.info['portRotation'][port_name_]['seawaterDensity']
            
            
        # cargos_info_ = {}
        
        cargos_info_['commingleCargo'] = {}
        for c__, c_ in enumerate(inputs.loadable_json['commingleCargo']):
            # print('Commingle cargo!!')
            c1_ = 'P'+str(c_['cargoNomination1Id'])
            c2_ = 'P'+str(c_['cargoNomination2Id'])
            
            cargos_info_['commingleCargo']['parcel1'] = c1_
            cargos_info_['commingleCargo']['parcel2'] = c2_
            t1_, t2_ = self.info['parcel'][c1_]['temperature'], self.info['parcel'][c2_]['temperature']
            
            api1_ = self.info['parcel'][c1_]['api']
            api2_ = self.info['parcel'][c2_]['api']
              
            if str(c_['purposeXid']) == str(1):
                print('Commingle cargo in auto mode!!')
                cargos_info_['commingleCargo']['temperature'] = min(t1_,t2_) + abs(t1_-t2_)*0.6
                print('approx commingle temperature:', cargos_info_['commingleCargo']['temperature'])
                
            else:
                print('Commingle cargo in manual mode!!')
                # inputs.error.append('Commingle cargo in manual mode not supported yet!!')
                # return
                
                wt1_ = float(c_['quantity'])*float(c_['cargo1Percentage'])*0.01
                wt2_ = float(c_['quantity'])*float(c_['cargo2Percentage'])*0.01
                
                cargos_info_['commingleCargo']['temperature'] = (wt1_*t1_ + wt2_*t2_)/(wt1_ + wt2_)
                print('approx commingle temperature:', cargos_info_['commingleCargo']['temperature'])
                cargos_info_['commingleCargo']['tank'] = [d_ for d_ in c_['tankIds'].split(',')]
                cargos_info_['commingleCargo']['wt1'] = wt1_
                cargos_info_['commingleCargo']['wt2'] = wt2_
                
            cargos_info_['commingleCargo']['SG1'] = self._cal_density(api1_, cargos_info_['commingleCargo']['temperature'])
            cargos_info_['commingleCargo']['SG2'] = self._cal_density(api2_, cargos_info_['commingleCargo']['temperature'])
            
            cargos_info_['commingleCargo']['api1'] = self.info['parcel'][c1_]['api']
            cargos_info_['commingleCargo']['api2'] = self.info['parcel'][c2_]['api']
            
            cargos_info_['commingleCargo']['t1'] = self.info['parcel'][c1_]['temperature']
            cargos_info_['commingleCargo']['t2'] = self.info['parcel'][c2_]['temperature']
            cargos_info_['commingleCargo']['priority'] = str(c_['priority'])
            cargos_info_['commingleCargo']['mode'] = str(c_['purposeXid'])
            
            cargos_info_['commingleCargo']['slopOnly'] = c_.get('isSlopOnly',False)
            cargos_info_['commingleCargo']['colorCode'] = c_.get('color', None)
                
        
        cargos_info_['operation'] = {k_:{}  for k_,v_ in self.info['parcel'].items()}
        cargos_info_['toLoad'] = {k_:0 for k_,v_ in self.info['parcel'].items()}
        cargos_info_['toLoadIntend']    = {k_:0 for k_,v_ in self.info['parcel'].items()}
        cargos_info_['toLoadMin'] = {k_:0 for k_,v_ in self.info['parcel'].items()}
        
        max_virtual_port_ = len(cargos_info_['virtualArrDepPort'])
        cargos_info_['lastVirtualPort'] = max_virtual_port_-1
        cargos_info_['toLoadPort'] = np.zeros(max_virtual_port_) # exact ports to virtual ports
        cargos_info_['toLoadMinPort'] = np.zeros(max_virtual_port_) # exact ports to virtual ports
        cargos_info_['cargoOrder'] = {str(p_):[] for p_ in range(1,max_virtual_port_)}
        for o__, o_ in enumerate(inputs.loadable_json['cargoOperation']):
            parcel_ = 'P'+str(o_['cargoNominationId'])
            qty__ = float(o_['quantity']) #if o_['operationId'] == 1 else -o_['quantity'] 
            order_ = inputs.port.info['idPortOrder'][str(o_['portId'])]
            # max qty
            qty_ = qty__ * (1+ 0.01*self.info['parcel'][parcel_]['minMaxTol'][1])
            # min qty
            qty_min_ = qty__ *(1 + 0.01*self.info['parcel'][parcel_]['minMaxTol'][0])
            
            cargos_info_['toLoad']['P'+str(o_['cargoNominationId'])] += qty_
            cargos_info_['toLoadIntend']['P'+str(o_['cargoNominationId'])] += qty__
            cargos_info_['toLoadMin']['P'+str(o_['cargoNominationId'])] += qty_min_
            
            virtual_order_ = 2*(int(order_)-1) + 1
            # if type(virtual_port_[str(order_)]) == dict:
            #     virtual_order_ = virtual_port_[str(order_)][parcel_]
            # else:
            #     virtual_order_ = virtual_port_[str(order_)]
            
            cargos_info_['toLoadPort'][int(virtual_order_)] += qty_
            cargos_info_['toLoadMinPort'][int(virtual_order_)] += qty_min_
            cargos_info_['operation'][parcel_][virtual_order_] = qty_
            
            if qty_ > 0:
                cargos_info_['cargoOrder'][str(virtual_order_)].append(parcel_)
                
            
            ## single loading port for each cargo set the discharging qty 
            ## no discharge info
            last_discharge_port_ = max_virtual_port_-1
            if last_discharge_port_ not in cargos_info_['operation'][parcel_]:
                cargos_info_['operation'][parcel_][last_discharge_port_] = -qty_
            else:
                cargos_info_['operation'][parcel_][last_discharge_port_] += -qty_
                
            cargos_info_['toLoadPort'][int(last_discharge_port_)] += -qty_
            cargos_info_['toLoadMinPort'][int(last_discharge_port_)] += -qty_min_
            
            
        cargos_info_['toLoadPort1'] = {a__:a_ for a__, a_ in enumerate(cargos_info_['toLoadPort']) if a_ > 0} 
        cargos_info_['toLoadPort'] = np.cumsum(cargos_info_['toLoadPort'])
        cargos_info_['toLoadMinPort'] = np.cumsum(cargos_info_['toLoadMinPort'])
        cargos_info_['numParcel'] = len(self.info['parcel'])
        
        cargo_order_ = [v_ for k_,v_ in  cargos_info_['cargoOrder'].items()]
        cargo_order_ = list(itertools.chain.from_iterable(cargo_order_))
        cargos_info_['cargoOrder'] = {c_:c__+1 for c__,c_ in enumerate(cargo_order_)}
        
        
        # for k_, v_ in self.info['parcel'].items():
        #     loading_order_ = cargo_order_.index(k_) + 1
        #     self.info['parcel'][k_]['loadingOrder'] = loading_order_
        
        # cargos_info_['cargoRotation'] = {}
        # for p__, p_ in enumerate(inputs.port.info['ballastList']):
        #     cargos_ = [k_ for k_,v_ in cargos_info_['operation'].items() if v_.get(str(p_),0.) > 0.]
        #     if len(cargos_) > 1:
        #         # print(p_, cargos_)
        #         port_order_ = round(0.5*p_+0.51) # convert virtual port to exact port
        #         cargos_info_['cargoRotation'][str(port_order_)] = cargos_
        
        self._get_plan(inputs, cargos_info_)
            
        cargos_info_['manualOperation'] = {}
        for k_, v_ in inputs.loadable_json['loadingPlan'].items():
            order_ = cargos_info_['arrDepVirtualPort'][k_]
            for v__ in v_:
                parcel_ = v__['parcel']
                if parcel_ not in cargos_info_['manualOperation'].keys():
                    cargos_info_['manualOperation'][parcel_] = {}
                    
                qty_ = float(v__['wt']) 
                tank_ = v__['tankId']
                    
                if order_ not in cargos_info_['manualOperation'][parcel_].keys():
                    cargos_info_['manualOperation'][parcel_][order_] = [{'qty':qty_, 'tankId':tank_}]
                else:
                    cargos_info_['manualOperation'][parcel_][order_].append({'qty':qty_, 'tankId':tank_})
            
        cargos_info_['preloadOperation'] = {}
        
        cargos_info_['ballastOperation'] = {}
        if inputs.mode in ['FullManual']: 
            for k_, v_ in inputs.loadable_json['ballastPlan'].items():
                order_ = cargos_info_['arrDepVirtualPort'][k_]
                cargos_info_['ballastOperation'][order_] = v_
        
        cargos_info_['fixedBallastPort'] = []
        # for k_, v_ in inputs.loadable_json['ballastPlan'].items():
        #     order_ = cargos_info_['arrDepVirtualPort'][k_]
        #     cargos_info_['fixedBallastPort'].append(order_)
        #     for v__ in v_:
        #         tank_ = v__['tank']
        #         qty_ = float(v__['wt']) 
                
        #         if tank_ not in cargos_info_['ballastOperation'].keys():
        #             cargos_info_['ballastOperation'][tank_] = [{'qty':qty_, 'order':order_}]
        #         else:
        #             cargos_info_['ballastOperation'][tank_].append({'qty':qty_, 'order':order_})
            
                
            
        if len(cargos_info_['fixedBallastPort']) > 0:
            # fixed ballast:
            cargos_info_['stablePorts'] = [str(i_)  for i_ in range(1,cargos_info_['lastVirtualPort']) if str(i_) not in  cargos_info_['fixedBallastPort']]    
        
        self.info = {**self.info, **cargos_info_}     
             
  
        
    def _cal_density(self, api, temperature_F):
        
        # temperature = ((temperature_F - 32)*5/9*100+0.5)/100
        # temperature = (temperature_F - 32)/1.8
        # # temp_F_ = round(temperature*1.8+32,1)
        
        # if 10 <= api < 18.4:
        #     density15c = 141500/(api+131.5) - 0.55
        # elif 18.4 <= api < 31.9:
        #     density15c = 141500/(api+131.5) - 0.505
        # elif 31.9 <= api < 45.3:
        #     density15c = 141500/(api+131.5) - 0.44
        # elif 45.3 <= api < 57.6:
        #     density15c = 141500/(api+131.5) - 0.27
        # elif 57.6 <= api < 80.6:
        #     density15c = 141500/(api+131.5) - 0.16
        # elif 80.6 <= api < 85:
        #     density15c = 141500/(api+131.5) - 0.1
        # else:
        #     density15c = None
            
        # density_15C_ = density15c/1000
            
        # # density_15C_ = 141.5/(api+0.08775+131.5)
            
        # vcf_ = np.exp(-(613.97231/(density_15C_*1000)**2)*(temperature-15.0)*(1.0+(0.8*(613.97231/(density_15C_*1000)**2)*(temperature-15.0))))
        
        # # density@15C in air == density_15C_-0.0011
        # density = (density_15C_-0.0011)*vcf_  # 
        
        
        ## https://www.myseatime.com/blog/detail/cargo-calculations-on-tankers-astm-tables
    
        a60 = 341.0957/(141360.198/(api+131.5))**2
        dt = temperature_F-60
        vcf_ = np.exp(-a60*dt*(1+0.8*a60*dt))
        t13_ = (535.1911/(api+131.5)-0.0046189)*0.42/10
        density = t13_*vcf_*6.2898
        
    
        return round(density,6)
    
    def _get_plan(self,inputs, cargos_info):
        
        onboard_json = inputs.vessel_json['onBoard']
        # onboard_json = [{"id": 29632,"portId": 1,"tankId": 25580,
        #                  "cargoId": None,
        #                  "volume": "100",
        #                  "plannedArrivalWeight": "100.0000"
        #                  }]
        
        onBoard = {}
        for o__, o_ in enumerate(onboard_json):
            tank_ = o_['tankId']
            # port_order_ = '1A'
            
            # print(o_)
            wt_ = float(o_['plannedArrivalWeight']) if o_['plannedArrivalWeight'] not in [None] else 0.
            vol1_ = float(o_['volume']) if o_['volume'] not in [None] else 0.
            if wt_ > 0. and vol1_ > 0.:
                onBoard[tank_] = wt_
                
                
        
        
    
        loading_plan_, ballast_plan_ = {},{}
        
        plan_ = []
        
        for k_, v_ in inputs.port.info['portOrder'].items():
            plan_.append([q_ for q__, q_ in enumerate(inputs.loadable_json['planDetails']) if v_ == q_['portCode']][0])
        
        tank_cargo_ = {}
        for p__, p_ in enumerate(plan_):
            port_ = str(p__+1)
            # arrival and departure 
            arr_port_ = port_ + 'A'
            dep_port_ = port_ + 'D'
            
            loading_plan_[dep_port_] = []
            ballast_plan_[arr_port_] = []
            ballast_plan_[dep_port_] = []
            
            # only ballast
            arr_ballast_ = p_['arrivalCondition']['loadablePlanBallastDetails']
            # both ballast and cargo
            dep_ballast = p_['departureCondition']['loadablePlanBallastDetails']
            dep_cargo_  = p_['departureCondition']['loadablePlanStowageDetails']
            dep_commingle_ =  p_['departureCondition'].get('loadableQuantityCommingleCargoDetails',[])
            
            
            for l__, l_ in enumerate(arr_ballast_):
                tankId_ = l_['tankId']
                info_ = {}
                info_['wt'] = float(l_['quantityMT'])
                info_['tankId'] = tankId_
                ballast_plan_[arr_port_].append(info_)
                
                
            for l__, l_ in enumerate(dep_ballast):
                tankId_ = l_['tankId']
                info_ = {}
                info_['wt'] = float(l_['quantityMT'])
                info_['tankId'] = tankId_
                ballast_plan_[dep_port_].append(info_)
                
            
            for l__, l_ in enumerate(dep_commingle_):
                # print(l_)
                tankId_ = l_['tankId']
                if tankId_ not in tank_cargo_:
                    tank_cargo_[tankId_] = []
                
                for c_ in range(2):
                    parcel_ = 'P'+str(l_['cargoNomination'+ str(c_+1)+'Id'])
                    info_ = {}
                    info_['parcel'] = parcel_
                    info_['wt'] = float(l_['cargo'+str(c_+1)+'MT'])
                    info_['tankId'] = tankId_
                    info_['port'] = dep_port_
                    
                    if len(tank_cargo_[tankId_]) == 0:
                        tank_cargo_[tankId_].append(info_)
                        loading_plan_[dep_port_].append(info_)
                        
                    else:
                        # print('repeat cargo_tank')
                        total_wt_ = sum([0.]+[i_['wt']  for i_ in tank_cargo_[tankId_] if i_['parcel'] == info_['parcel']])
                        add_wt_ = info_['wt'] -  total_wt_
                        if add_wt_ > 0:
                            info_['wt'] = round(add_wt_,3)
                            tank_cargo_[tankId_].append(info_)
                            loading_plan_[dep_port_].append(info_)
                        
                        elif add_wt_ < 0:
                            last_port_ = max(cargos_info['cargoLastLoad'][parcel_])
                            pre_wt_ = [ i_['wt']  for i_ in tank_cargo_[tankId_] if i_['parcel'] == parcel_ and i_['port'] == last_port_ +'D']
                            new_load_ = pre_wt_[0] + add_wt_
                            if new_load_ > 0:
                                info1_ = {'parcel':parcel_, 'wt':pre_wt_[0], 'tankId':tankId_, 'port':last_port_ +'D'}
                                loading_plan_[last_port_+'D'].remove(info1_)
                                tank_cargo_[tankId_].remove(info1_)
                                
                                info1_['wt'] = new_load_
                                loading_plan_[last_port_+'D'].append(info1_)
                                tank_cargo_[tankId_].append(info1_)
                            else:
                                inputs.error.append('Error in adjusting manual allocation!!')
                    
                            
            
            for l__, l_ in enumerate(dep_cargo_):
                # parcel_ = l_['parcelId']
                tankId_ = l_['tankId']
                if tankId_ not in tank_cargo_:
                    tank_cargo_[tankId_] = []
                    
                parcel_ = 'P'+str(l_['cargoNominationId'])
                
                if str(l_['cargoNominationId']) not in ['']:
                    info_ = {}
                    info_['parcel'] = 'P'+ str(l_['cargoNominationId'])
                    info_['wt'] = float(l_['quantityMT'])
                    info_['tankId'] = tankId_
                    info_['port'] = dep_port_
                    onboard_ = onBoard.get(tankId_,0.)
                    
                    if onboard_ > 0:
                        print(tankId_,onboard_)
                    
                    # print(info_,l_)
                    if len(tank_cargo_[tankId_]) == 0:
                        info_['wt'] -= onboard_                        
                        tank_cargo_[tankId_].append(info_)
                        loading_plan_[dep_port_].append(info_)
                        
                    else:
                        # print('repeat cargo_tank')
                        total_wt_ = sum([0.]+[i_['wt']  for i_ in tank_cargo_[tankId_] if i_['parcel'] == parcel_])
                        add_wt_ = info_['wt'] -  total_wt_ - onboard_
                        if add_wt_ > 0:
                            info_['wt'] = round(add_wt_,3)
                            tank_cargo_[tankId_].append(info_)
                            loading_plan_[dep_port_].append(info_)
                            
                        elif add_wt_ < 0:
                            last_port_ = max(cargos_info['cargoLastLoad'][parcel_])
                            pre_wt_ = [ i_['wt']  for i_ in tank_cargo_[tankId_] if i_['parcel'] == parcel_ and i_['port'] == last_port_ +'D']
                            new_load_ = pre_wt_[0] + add_wt_
                            if new_load_ > 0:
                                info1_ = {'parcel':parcel_, 'wt':pre_wt_[0], 'tankId':tankId_, 'port':last_port_ +'D'}
                                loading_plan_[last_port_+'D'].remove(info1_)
                                tank_cargo_[tankId_].remove(info1_)
                                
                                info1_['wt'] = new_load_
                                loading_plan_[last_port_+'D'].append(info1_)
                                tank_cargo_[tankId_].append(info1_)
                            else:
                                inputs.error.append('Error in adjusting manual allocation!!')
                            
                    
                        
                
                
                    
                # if l_ not in tank_cargo_[]
             
            
            
            
            
            
        inputs.loadable_json['loadingPlan'] = loading_plan_
        inputs.loadable_json['ballastPlan'] = ballast_plan_
    
    
        # return loading_plan_,  ballast_plan_

        