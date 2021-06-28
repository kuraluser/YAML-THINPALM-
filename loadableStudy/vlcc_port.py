# -*- coding: utf-8 -*-
"""
Created on Fri Nov 27 12:05:21 2020

@author: I2R
"""

class Port:
    def __init__(self, inputs):
        
        last_loading_port_ = max([p_['portOrder'] for p_ in inputs.port_json['portRotation'] if p_["operationId"] in [1,3,4]])
        
        
        ports_info_ = {}
        ports_info_['portRotation'] = {}
        ports_info_['portOrder'], ports_info_['idPortOrder'] = {}, {}
        ports_info_['portOrderId'] = {}
        ports_info_['firstPortBunker'] = False
        
        ports_info_['lastLoadingPort'] = last_loading_port_
        
        port_details_ = {}
        for p__, p_ in enumerate(inputs.port_json['portDetails']):
            port_details_[p_['id']] = {'densitySeaWater':p_['densitySeaWater'],
                                       'code': p_['code'], 'tideHeight': float(p_["tideHeight"]) if p_.get("tideHeight",None) not in [None, ""] else 0.,
                                       'seaWaterTemperature':p_.get('seaWaterTemperature', 0.),
                                       'ambientTemperature':p_.get('ambientTemperature', 0.)}
           
        for p__, p_ in enumerate(inputs.port_json['portRotation']):
            if p_['portOrder'] <= last_loading_port_ + 1:
                # print(p_['portId'])
                detail_ = port_details_[p_['portId']]
                ports_info_['portRotation'][detail_['code']] = {}
                ports_info_['portRotation'][detail_['code']]['order'] = p_['portOrder']
                ports_info_['portRotation'][detail_['code']]['maxDraft'] = p_['maxDraft']
                ports_info_['portRotation'][detail_['code']]['portId'] = p_['portId']
                ports_info_['portRotation'][detail_['code']]['seawaterDensity'] = float(p_['seaWaterDensity']) if p_['seaWaterDensity'] not in ["",None] else 1.025
                ports_info_['portRotation'][detail_['code']]['portRotationId'] = p_['id']
                
                ports_info_['portOrder'][str(p_['portOrder'])] = detail_['code']
                ports_info_['idPortOrder'][str(p_['portId'])] = str(p_['portOrder']) # id:order
                ports_info_['portOrderId'][str(p_['portOrder'])] = str(p_['portId']) # order:id
                
                ports_info_['portRotation'][detail_['code']]['operationId'] = p_['operationId']
                ports_info_['portRotation'][detail_['code']]['maxAirDraft'] = float(p_["maxAirDraft"]) if p_.get("maxAirDraft",None) not in [None, ""] else 200
                ports_info_['portRotation'][detail_['code']]['tideHeight'] = detail_['tideHeight']
                
                ports_info_['portRotation'][detail_['code']]['ambientTemperature'] = detail_['ambientTemperature']
                ports_info_['portRotation'][detail_['code']]['seaWaterTemperature'] = detail_['seaWaterTemperature']
                
                if p_['portOrder'] == 1 and p_['operationId'] not in [1]:
                    ports_info_['firstPortBunker'] = True
                    
                if p_['portOrder'] == 2 and p_['operationId'] not in [1] and ports_info_['firstPortBunker']:
                    ports_info_['firstPortBunker'] = True
                    inputs.error['Port Operation Error'] = ['One of the first two ports must be a loading port!!']
                    
                    
                
            ## berth info
        
        ports_info_['numPort'] = len(ports_info_['portRotation'])
        
#        print(ports_info_['portOrder'])
        # arrival and departure ports for ballast synchronize
        # ports_info_['ballastList'] = [2*i_-1 for i_ in range(1,last_loading_port_+1)] 
        # ports_info_['deBallastList'] = []
        # ports_info_['finalBallastPort'] = []
        ports_info_['operationId'] = {str(v_['portId']): str(v_['operationId']) for k_,v_ in ports_info_['portRotation'].items() }
        ports_info_['maxDraft'] = {str(v_['portId']): v_['maxDraft'] for k_,v_ in ports_info_['portRotation'].items() }
        ports_info_['maxAirDraft'] = {str(v_['portId']): v_['maxAirDraft'] for k_,v_ in ports_info_['portRotation'].items()}
        ports_info_['ambientTemperature'] = {str(v_['order']): float(v_['ambientTemperature']) for k_,v_ in ports_info_['portRotation'].items()}
        
        # print(ports_info_)
        
                    
        self.info = ports_info_     
        
		# error checking -----------------------------------------------------
        discharge_port_ = False
        for a_, (k_, v_) in enumerate(ports_info_['portOrder'].items()):
            oper_ = ports_info_['portRotation'][v_]['operationId']
            
            if oper_ in ['2',2]:
                discharge_port_ = True
                
            if oper_ in ['2',2] and int(k_) < len(ports_info_['portOrder']):
                if 'Port Rotation Error' not in inputs.error.keys():
                    inputs.error['Port Rotation Error'] = ['Discharging before loading!!']
                else:
                    inputs.error['Port Rotation Error'].append('Discharging before loading!!')
                
        if not discharge_port_:
            if 'Port Rotation Error' not in inputs.error.keys():
                inputs.error['Port Rotation Error'] = ['Discharging port not present!!']
            else:
                inputs.error['Port Rotation Error'].append('Discharging port not present!!')
                
        for k_, v_ in ports_info_['maxDraft'].items():
            if v_ in [None]:
                port_ =  ports_info_['portOrder'][ports_info_['idPortOrder'][k_]]
                if 'Max Draft Error' not in inputs.error.keys():
                    inputs.error['Max Draft Error'] = ['Max Draft Error at '+ port_ +'!!']
                else:
                    inputs.error['Max Draft Error'].append('Max Draft Error at '+ port_ +'!!')
                    
        port_order_ = list(ports_info_['portOrder'].keys())
        for p__ in range(1,ports_info_['numPort']+1):
            if str(p__)  not in  port_order_:
                # print(v_)
                if 'Port Order Error' not in inputs.error.keys():
                    inputs.error['Port Order Error'] = [v_ + ' in port ordering error!!']
                else:
                    inputs.error['Port Order Error'].append(v_ + ' in port ordering error!!')
                    
            
            
        
 
 
            
            
            
            
        
        