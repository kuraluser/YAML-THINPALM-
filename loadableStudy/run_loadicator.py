# -*- coding: utf-8 -*-
"""
Created on Sun Feb 14 14:38:01 2021

@author: I2R
"""
import json
from api_vlcc import loadicator

fname = 'loadable_pattern_loadicator_request.json' # single dict
fname = 'loadable_study_loadicator_request.json'

fname = 'loadicator-request0413.json'
fname = 'algo-request0413.json'

fname = 'loadicator_6001a.json'
fname = 'loadicator_6606.json'

fname = 'loadicator_6680.json'
fname = 'loadicator_0713.json'


with open(fname) as f_:    
    data = json.load(f_)

# limits = {'limits': {'draft': {'loadline': 20.943, '107327': 22.0, '107328': 22.0},
#   'operationId': {'107327': '1', '107328': '2'},
#   'id': 4468,
#   'vesselId': 1,
#   'voyageId': 115,
#   'airDraft': {'107327': 200, '107327': 200}}}


limits = {'limits': {'draft': {'loadline': 20.943, '359': 20.0, '1': 20.0},
  'operationId': {'359': '1', '1': '2'},
  'id': 6861,
  'vesselId': 1,
  'voyageId': 2042,
  'airDraft': {'359': 20.0, '1': 20.0}}}

if __name__ == "__main__":
    message = loadicator(data, limits)
    
    with open('result_loadicator.json', 'w') as f_:  
        json.dump(message, f_)