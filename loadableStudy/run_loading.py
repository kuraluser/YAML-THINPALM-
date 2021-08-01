# -*- coding: utf-8 -*-
"""
Created on Wed Jul 14 16:30:15 2021

@author: I2R
"""

import json
from uuid import uuid4

from api_loading import gen_sequence


fname = 'loading_information_65b.json' # 1 single cargo
# fname = 'loading_information_40a.json' # preload and 1 single cargo loading
fname = 'loading_information_40c.json'



## to be modified in main.py --------------------------------------------
data = {}

with open(fname) as f_:
    data_ = json.load(f_)
    data['loading'] = data_
    data['loading']['infoId'] = data_["loadingInformation"]["loadingInfoId"]
        
        
with open('vessel_info.json') as f_:    
    data['vessel'] = json.load(f_)
    
    
data['processId'] = str(uuid4())    


if __name__ == "__main__":

    result = gen_sequence(data)
    
    # with open('result.json', 'w') as f_:  
    #     json.dump(message, f_)