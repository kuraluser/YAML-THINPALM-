# -*- coding: utf-8 -*-
"""
Created on Fri Nov 27 17:21:13 2020

@author: I2R
"""

import requests
import json


#fname1 = 'out.json'
#data1 = {'mean':50, 'variance':100}
#with open(fname1, 'w') as f:  
#    json.dump(data1, f)


fname1 = 'loadableStudy_4618.json' # 2 cargo at 1st port; 2 ports; zero ballast not possible at discharge port
fname1 = 'loadableStudy_4614.json' # api too high; max draft too low
fname1 = 'loadableStudy_4614a.json' # fixed; 2 cargo at 1st port; 2 ports;

fname = 'loadableStudy_4826.json' # non-zero ballast at last loading port

# fname1 = 'result66c2.json' # manual mode corresponding zero ballast at discharge
# fname1 = 'result23c2.json' # manual mode corresponding zero ballast at discharge


headers = {'Accept' : 'application/json', 'Content-Type' : 'application/json'}
#
url1 = 'http://127.0.0.1:8000/new_loadable'
rr1 = requests.post(url1, data=open(fname1, 'rb'), headers=headers)
obj1 = json.loads(rr1.content.decode('utf-8'))

with open('obj1.json', 'w') as f:  
    json.dump(obj1, f)

fname2 = 'serial.json'
data2 = {'processId': obj1['processId']}
with open(fname2, 'w') as f:  
    json.dump(data2, f)






# uvicorn main:app --reload --host 0.0.0.0 --port:8000