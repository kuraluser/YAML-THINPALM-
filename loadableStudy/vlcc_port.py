# -*- coding: utf-8 -*-
"""
Created on Fri Nov 27 12:05:21 2020

@author: I2R
"""

class Port:
    def __init__(self, inputs):
        
        last_loading_port_ = max([p_['portOrder'] for p_ in inputs.port_json['portRotation'] if p_["operationId"] == 1])
        
        
        ports_info_ = {}
        ports_info_['portRotation'] = {}
        ports_info_['portOrder'], ports_info_['idPortOrder'] = {}, {}
        ports_info_['portOrderId'] = {}
        
        ports_info_['lastLoadingPort'] = last_loading_port_
        
        port_details_ = {}
        for p__, p_ in enumerate(inputs.port_json['portDetails']):
            port_details_[p_['id']] = {'densitySeaWater':p_['densitySeaWater'],
                                       'code': p_['code'], 'tideHeight': float(p_["tideHeight"]) if p_.get("tideHeight",None) not in [None, ""] else 0.}
           
        for p__, p_ in enumerate(inputs.port_json['portRotation']):
            if p_['portOrder'] <= last_loading_port_ + 1:
                detail_ = port_details_[p_['portId']]
                ports_info_['portRotation'][detail_['code']] = {}
                ports_info_['portRotation'][detail_['code']]['order'] = p_['portOrder']
                ports_info_['portRotation'][detail_['code']]['maxDraft'] = p_['maxDraft']
                ports_info_['portRotation'][detail_['code']]['portId'] = p_['portId']
                ports_info_['portRotation'][detail_['code']]['seawaterDensity'] = float(detail_['densitySeaWater']) if detail_['densitySeaWater'] not in ["",None] else 1.025
                ports_info_['portRotation'][detail_['code']]['portRotationId'] = p_['id']
                
                ports_info_['portOrder'][str(p_['portOrder'])] = detail_['code']
                ports_info_['idPortOrder'][str(p_['portId'])] = str(p_['portOrder']) # id:order
                ports_info_['portOrderId'][str(p_['portOrder'])] = str(p_['portId']) # order:id
                
                ports_info_['portRotation'][detail_['code']]['operationId'] = p_['operationId']
                ports_info_['portRotation'][detail_['code']]['maxAirDraft'] = float(p_["maxAirDraft"]) if p_.get("maxAirDraft",None) not in [None, ""] else 200
                ports_info_['portRotation'][detail_['code']]['tideHeight'] = detail_['tideHeight']
                
            ## berth info
        
        ports_info_['numPort'] = len(ports_info_['portRotation'])
#        print(ports_info_['portOrder'])
        # arrival and departure ports for ballast synchronize
        # ports_info_['ballastList'] = [2*i_-1 for i_ in range(1,last_loading_port_+1)] 
        # ports_info_['deBallastList'] = []
        # ports_info_['finalBallastPort'] = []
        ports_info_['operationId'] = {str(v_['portId']): str(v_['operationId']) for k_,v_ in ports_info_['portRotation'].items() }
        ports_info_['maxDraft'] = {str(v_['portId']): v_['maxDraft'] for k_,v_ in ports_info_['portRotation'].items() }
        ports_info_['maxAirDraft'] = {str(v_['portId']): v_['maxAirDraft'] for k_,v_ in ports_info_['portRotation'].items() }
        
        
                    
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
            
            
        
 
 
            
            
            
            
        
        