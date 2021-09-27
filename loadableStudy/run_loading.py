# -*- coding: utf-8 -*-
"""
Created on Wed Jul 14 16:30:15 2021

@author: I2R
"""

import json
from uuid import uuid4

from api_loading import gen_sequence

## load configuration --------------------------------------------------------
with open('config.json', "r") as f_:
   config = json.load(f_)
   
   
fname = 'loading_information_65c.json' # 1 single cargo
# fname = 'loading_information_40a.json' # preload and 1 single cargo loading
# fname = 'loading_information_40c.json'


# fname = 'loading_information_request_144v5.json'

# fname = 'loading_information_request_25.json'

# fname = 'loading_information_request_116b.json'
fname = 'loading_information_request_165.json'
fname = 'loading_information_request_167.json'
# fname = 'loading_information_request_122.json'
# fname = 'loading_information_request_100.json'

# fname = '100000032.json'
fname = 'loading_information_request_commingle.json'

fname = 'loading_information_voy25_first_port.json'
# fname = 'loading_information_voy25_second_port.json'

# fname = 'loadingDSS-4061.json'   # pass
# fname = 'loadingDSS-4057.json' # pass 

# fname = 'loading_info_167.json' # error in loading info
# fname = 'loading_informaton_100000133.json' # 3 cargos
# fname = 'loading_information_100000143.json' # not enough time for eduction 

# fname = 'loading_information_error_request_100000052.json'

# fname = 'loading_information_100000049.json'

fname = 'loading_information_request_100000058.json'
fname = 'loading_information_request_100000050.json'

## to be modified in main.py --------------------------------------------
data = {}

with open(fname) as f_:
    data_ = json.load(f_)
    data['loading'] = data_
    data['loading']['infoId'] = data_["loadingInformation"]["loadingInfoId"]
    
    vessel_id_ = data['loading']['vesselId']
        
        
with open('vessel_info'+str(vessel_id_)+'.json') as f_:    
    data['vessel'] = json.load(f_)
    
    
data['processId'] = str(uuid4())    
data['config'] = config["vessel"][str(vessel_id_)]

if __name__ == "__main__":


    result = gen_sequence(data)
    
    with open('result.json', 'w') as f_:  
        json.dump(result, f_)