# -*- coding: utf-8 -*-
"""
Created on Fri Nov 27 12:05:21 2020

@author: I2R
"""

class Port:
    def __init__(self, inputs):
        ports_info_ = {}
        ports_info_['bunkering'], ports_info_['normalOp'] = {},{}
        ## remove bunkering operation if loading/discharging are done at the same port
        # port_operation_ = {}
        for p__, p_ in enumerate(inputs.port_json['portRotation']):
            # if p_['portId'] not in port_operation_.keys():
            #     port_operation_[p_['portId']] = [p_['operationId']]
            # else:
            #     port_operation_[p_['portId']].append(p_['operationId'])
                
                
            if p_['operationId'] not in [1,2]:
                ports_info_['bunkering'][p__] = p_
            else:
                ports_info_['normalOp'][p__] = p_['portId']
                
        print('bunkering:', list(ports_info_['bunkering'].keys()))
                
        # for k_, v_ in port_operation_.items():
        #     if len(v_) > 1:
        #         oper_ = [l_  for l_ in v_ if l_ in [1,2]]
        #         port_operation_[k_] = oper_
                
        # print('port_operation:', port_operation_)     
        ## assume either loading or discharging but not both
        port_rotation_, order_ = [], 1
        for p__, p_ in enumerate(inputs.port_json['portRotation']):
            # if p_['operationId'] in [3,4]:
            #     print(p_)
            port_rotation_.append(p_)
            port_rotation_[order_-1]['portOrder'] = order_
            order_ += 1
            
        if inputs.module in ['LOADABLE']:
            last_loading_port_ = max([p_['portOrder'] for p_ in port_rotation_ if p_["operationId"] in [1,3,4]])
        else:
            last_loading_port_ = 0
        
        
        ports_info_['portRotation'] = {}
        ports_info_['portOrder'], ports_info_['idPortOrder'] = {}, {}
        ports_info_['portOrderId'] = {}
        ports_info_['firstPortBunker'] = False
        
        ports_info_['lastLoadingPort'] = last_loading_port_
        
        ports_info_['seawaterDensity'] = {}
        ports_info_['tide'] = {}
        ports_info_['portRotationId'] = {}
        ports_info_['portRotationId1'] = {}
        
        ports_info_['cargoSeq'] = {}
        ports_info_['maxEmptyTanks'] = {}
        ports_info_['cowType'] = {}

        port_details_ = {}
        for p__, p_ in enumerate(inputs.port_json['portDetails']):
            port_details_[p_['id']] = {'densitySeaWater':p_['densitySeaWater'],
                                       'code': p_['code'], 'tideHeight': float(p_["tideHeight"]) if p_.get("tideHeight",None) not in [None, ""] else 0.,
                                       'seaWaterTemperature':p_.get('seaWaterTemperature', 0.),
                                       'ambientTemperature':p_.get('ambientTemperature', 0.)}
           
        last_port_ = last_loading_port_ + 1 if inputs.module == 'LOADABLE' else len(port_rotation_) + 1
        for p__, p_ in enumerate(port_rotation_): #inputs.port_json['portRotation']):
            if p_['portOrder'] <= last_port_:
                # print(p_['portId'])
                detail_ = port_details_[p_['portId']]
                
                densitySeaWater_ = detail_.get('densitySeaWater', 1.025)
                if densitySeaWater_ in [None, ""]:
                    densitySeaWater_ = 1.025
                    
                code_ = detail_['code'] + str(p_['operationId'])
                portId_ = int(str(p_['portId'])+str(p_['operationId']))
                
                ports_info_['seawaterDensity'][str(portId_)] = float(densitySeaWater_)
                ports_info_['tide'][str(portId_)] = float(detail_['tideHeight'])
                ports_info_['portRotationId'][str(p_['id'])] = portId_
                ports_info_['portRotationId1'][str(portId_)] = p_['id']

                ports_info_['portRotation'][code_] = {}
                ports_info_['portRotation'][code_]['order'] = p_['portOrder']
                ports_info_['portRotation'][code_]['maxDraft'] = float(p_['maxDraft'])
                ports_info_['portRotation'][code_]['portId'] = portId_
                ports_info_['portRotation'][code_]['seawaterDensity'] = float(p_['seaWaterDensity']) if p_['seaWaterDensity'] not in ["",None] else 1.025
                ports_info_['portRotation'][code_]['portRotationId'] = p_['id']
                
                if inputs.module in ['DISCHARGE']:
                    ports_info_['portRotation'][code_]['cowAllowed']  = p_.get('cow', True)
                    ports_info_['portRotation'][code_]['freshCrudeOil']  = p_.get('freshCrudeOil', False)
                    ports_info_['portRotation'][code_]['freshCrudeOilTime']  = p_.get('freshCrudeOil', 1)
                    
                
                
                # if inputs.module == 'LOADABLE':
                #    ports_info_['portRotation'][code_]['maxDraft'] = p_['maxDraft'] - float(inputs.draftsag)/400
                
                ports_info_['portOrder'][str(p_['portOrder'])] = code_
                ports_info_['idPortOrder'][str(portId_)] = str(p_['portOrder']) # id:order
                ports_info_['portOrderId'][str(p_['portOrder'])] = str(portId_) # order:id
                
                ports_info_['portRotation'][code_]['operationId'] = p_['operationId']
                ports_info_['portRotation'][code_]['maxAirDraft'] = float(p_["maxAirDraft"]) if p_.get("maxAirDraft",None) not in [None, ""] else 200
                ports_info_['portRotation'][code_]['tideHeight'] = detail_['tideHeight']
                
                ports_info_['portRotation'][code_]['ambientTemperature'] = detail_['ambientTemperature']
                ports_info_['portRotation'][code_]['seaWaterTemperature'] = detail_['seaWaterTemperature']
                
                if p_['portOrder'] == 1 and p_['operationId'] not in [1, 2]:
                    ports_info_['firstPortBunker'] = True
                    
                if p_['portOrder'] == 2 and p_['operationId'] not in [1] and ports_info_['firstPortBunker']:
                    ports_info_['firstPortBunker'] = True
                    inputs.error['Port Operation Error'] = ['One of the first two ports must be a loading port!!']
                    
                    
                
            ## berth info
        
        ports_info_['numPort'] = len(ports_info_['portRotation'])
        for k_, v_ in ports_info_['cowType'].items():
            if v_ not in [0,1]:
                if 'Cow Type Error' not in inputs.error.keys():
                    inputs.error['Cow Type Error'] = ['Manual COW at port  ' + str(k_[:-1]) + ' not supported yet!!']
                else:
                    inputs.error['Cow Type Error'].append('Manual COW at port  ' + str(k_[:-1]) + ' not supported yet!!')
        
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
        
      #   if inputs.module == 'LOADABLE':
    		# # error checking -----------------------------------------------------
      #       discharge_port_ = False
      #       for a_, (k_, v_) in enumerate(ports_info_['portOrder'].items()):
      #           oper_ = ports_info_['portRotation'][v_]['operationId']
                
      #           if oper_ in ['2',2]:
      #               discharge_port_ = True
                    
      #           if oper_ in ['2',2] and int(k_) < ports_info_['lastLoadingPort']:
      #               if 'Port Rotation Error' not in inputs.error.keys():
      #                   inputs.error['Port Rotation Error'] = ['Discharging before loading!!']
      #               else:
      #                   inputs.error['Port Rotation Error'].append('Discharging before loading!!')
                    
      #       if not discharge_port_:
      #           if 'Port Rotation Error' not in inputs.error.keys():
      #               inputs.error['Port Rotation Error'] = ['Discharging port not present!!']
      #           else:
      #               inputs.error['Port Rotation Error'].append('Discharging port not present!!')
                    
      #       for k_, v_ in ports_info_['maxDraft'].items():
      #           if v_ in [None]:
      #               port_ =  ports_info_['portOrder'][ports_info_['idPortOrder'][k_]]
      #               if 'Max Draft Error' not in inputs.error.keys():
      #                   inputs.error['Max Draft Error'] = ['Max Draft Error at '+ port_ +'!!']
      #               else:
      #                   inputs.error['Max Draft Error'].append('Max Draft Error at '+ port_ +'!!')
                        
      #       port_order_ = list(ports_info_['portOrder'].keys())
      #       for p__ in range(1,ports_info_['numPort']+1):
      #           if str(p__)  not in  port_order_:
      #               # print(v_)
      #               if 'Port Order Error' not in inputs.error.keys():
      #                   inputs.error['Port Order Error'] = ['Port order ' + str(p__) + ' is missing!!']
      #               else:
      #                   inputs.error['Port Order Error'].append('Port order ' + str(p__) + ' is missing!!')
                    
            
            
        
 
 
            
            
            
            
        
        