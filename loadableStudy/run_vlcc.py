# -*- coding: utf-8 -*-
"""
Created on Sun Dec  6 12:24:27 2020

@author: I2R
"""
import json
from uuid import uuid4

from api_vlcc import gen_allocation

# import sys
# sys.stdout = open('log.txt', 'w')


fname = 'loadableStudy_4618.json' # 2 cargo at 1st port; 2 ports; zero ballast not possible at discharge port

fname = 'loadableStudy_4614.json' # api too high; max draft too low
fname = 'loadableStudy_4614a.json' # fixed; 2 cargo at 1st port; 2 ports;

fname = 'loadableStudy_4557.json' # api too high; max draft too low
fname = 'loadableStudy_4557a.json' # fixed




fname = 'loadableStudy_4826.json' # non-zero ballast at last loading port

# fname = 'loadableStudy_4601.json' # unload 210k total load;

fname = 'loadableStudy70rob2.json' #  non-zero ballast 20sec full load
fname = 'loadableStudy66c2.json'  # rotation at 2nd port; load more if non-zero ballast
fname = 'loadableStudy23c2.json' # rotation not required
fname = 'loadableStudy26c2.json' # commingle 4C:50 onboard


fname = 'result23c2.json' # manual mode corresponding

## to be modified in main.py --------------------------------------------
data = {}
with open(fname) as f_:
    data_ = json.load(f_)
    if data_.get('loadableStudy', []):
        # manual mode
        data['loadable'] = data_['loadableStudy']
        data['loadablePlanPortWiseDetails'] = data_['loadablePlanPortWiseDetails']
    else:
        data['loadable'] = data_
        
with open('vessel_info.json') as f_:    
    data['vessel'] = json.load(f_)

data['processId'] = str(uuid4())

#-------------------------------------------------------------------------------
# with open('result70rob2.json') as f_:
#     data["loadablePlanPortWiseDetails"] = json.load(f_)['plan']
    
    


if __name__ == "__main__":

    message = gen_allocation(data)
    
    with open('result.json', 'w') as f_:  
        json.dump(message, f_)



## %logstart -o