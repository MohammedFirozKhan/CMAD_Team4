# -*- coding: utf-8 -*-
import requests
from time import strptime

with open('failed_10.txt', 'r', errors='ignore') as file_obj:
    file_contents = file_obj.readlines()
    print(len(file_contents))
    file_contents.remove('\n')
    print(len(file_contents))

logs = []
url = 'http://localhost:8080/log'

for line in file_contents:
    elements = line.split(':')
    log_dict = {}

    if len(elements) >= 6:
        hostName = elements[1].strip().split(' ')[0]
        timeStamp = elements[2].split(' ')[-1] + ':' + elements[3] + ':' + elements[4].split(' ')[0]
        month = strptime('%s' %elements[2].split(' ')[0],'%b').tm_mon
        day = elements[2].split(' ')[2]
        date = '%s-%s' %(day,month)
        processName = elements[5].split('[')[0].strip()
        log_event = elements[6].strip().strip('%').lower()
        if 'error' in log_event:
            logLevel = 'error'
        elif 'minor' in log_event or 'state_change' in log_event:
            logLevel = 'minor'
        elif 'info' in log_event:
            logLevel = 'info'
        elif 'critical' in log_event:
            logLevel = 'critical'
        elif 'major' in log_event:
            logLevel = 'major'
        else:
            logLevel = 'info'

        logMsg = elements[7].strip()
        log_dict['hostName'] = hostName
        log_dict['timeStamp'] = timeStamp
        log_dict['date'] = date
        log_dict['processName'] = processName
        log_dict['logLevel'] = logLevel
        log_dict['logMsg'] = logMsg
        op = requests.post(url=url, json = log_dict)