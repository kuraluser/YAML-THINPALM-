import requests
import json

api_url = "https://cpdss-dev.alphaorimarine.com/cpdss/api/cloud/vessel-details/1?enableValveSeq=true"
response = requests.get(api_url)
res = response.json()

with open('../loadableStudy/vessel_info1.json', 'w') as f:
    print('yes')
    json.dump(res, f, indent=4)