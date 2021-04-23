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

# fname = 'loadableStudy_4614.json' # api too high; max draft too low
# fname = 'loadableStudy_4614a.json' # fixed; 2 cargo at 1st port; 2 ports;

# fname = 'loadableStudy_4557.json' # api too high; max draft too low
# fname = 'loadableStudy_4557a.json' # fixed




# fname = 'loadableStudy_4826.json' # non-zero ballast at last loading port

# fname = 'loadableStudy_4601.json' # unload 210k total load;

# fname = 'loadableStudy70rob2.json' #  non-zero ballast 20sec full load
# fname = 'loadableStudy66c2.json'  # rotation at 2nd port; load more if non-zero ballast
# fname = 'loadableStudy23c2.json' # rotation not required
# fname = 'loadableStudy26c2.json' # commingle 4C:50 onboard

# 
# fname = 'loadableStudy_4601.json' # partial load 200k 40% cargo deballast disable
fname = 'loadableStudy_5009.json'

# fname = 'loadableStudy_5233.json' # infeasible

# fname = 'result26c2.json' # manual mode corresponding; use with generate_manual_plan

# fname = 'pattern_validate_request.json'

# fname = 'loadablePattern_request_1418.json' # np port rotation
# fname = 'loadablePattern_request_2742.json' # discharge port first
# fname = 'loadablePattern_request_2885.json' # manual

# fname = 'loadableStudy_5572.json' # single cargo
# fname = 'loadableStudy_5574.json' # 
# fname = 'loadableStudy_5575.json' #
# fname = 'loadableStudy_5576.json' # Draft error
# fname = 'loadableStudy_5577.json' # Draft error
# fname = 'loadableStudy_5578.json' # Port rotation error
# fname = 'loadableStudy_5579.json' # 

# fname = 'loadablePattern_request_2251.json' # missing cargoNorminationId
# fname = 'loadableStudy_6066.json'


# fname = 'loadableStudy_5426.json'
# fname = 'loadablePattern_request_2251.json'

# fname = 'loadablePattern_request_2911.json'
# fname = 'loadableStudy_6165.json'

fname = 'loadableStudy_6164.json'
fname = 'loadableStudy_6318.json' # missing maxDraft at port 2
fname = 'loadableStudy_6159.json'

fname = 'request0421.json' # deballast limit relax
# fname = 'request0422a.json' # deballast limit relax
fname = 'request0422a.json'


## to be modified in main.py --------------------------------------------
data = {}
with open(fname) as f_:
    data_ = json.load(f_)
    if data_.get('loadableStudy', []):
        # manual mode
        data['loadable'] = data_['loadableStudy']
        data['loadablePlanPortWiseDetails'] = data_['loadablePlanPortWiseDetails']
        data['caseNumber'] = data_.get('caseNumber', None)
        data['loadable']['loadablePatternId'] = data_.get('loadablePatternId',111)
    else:
        data['loadable'] = data_
        
with open('vessel_info.json') as f_:    
    data['vessel'] = json.load(f_)

data['processId'] = str(uuid4())
data['ballastEdited'] = False






if __name__ == "__main__":

    message = gen_allocation(data)
    
    with open('result.json', 'w') as f_:  
        json.dump(message, f_)



## %logstart -o