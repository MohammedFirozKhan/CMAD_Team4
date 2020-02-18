# CMAD_Team4
Log analyzer  using ReactJs, Spring Boot, Java , MySql, MongoDB

Rest APIs:
==========
1. GET : http://localhost:8080/logs/?interval=40&logLevel=ALL&page=0&size=3
   
   Response : [
    {
        "logId": 11,
        "logLevel": "INFO",
        "logMsg": "test message",
        "processName": null,
        "hostName": "some IP",
        "date": "2020-01-13T00:00:00.000+0000"
    },
    {
        "logId": 12,
        "logLevel": "WARN",
        "logMsg": "test message",
        "processName": null,
        "hostName": "some IP",
        "date": "2020-01-13T00:00:00.000+0000"
    },
    {
        "logId": 13,
        "logLevel": "DEBUG",
        "logMsg": "test message",
        "processName": null,
        "hostName": "some IP",
        "date": "2020-01-13T00:00:00.000+0000"
    }
]
     
2. GET : http://localhost:8080/stats/?interval=40
   
   Response : [
    {
        "logLevel": "INFO",
        "logCount": 1
    },
    {
        "logLevel": "WARN",
        "logCount": 1
    },
    {
        "logLevel": "DEBUG",
        "logCount": 1
    },
    {
        "logLevel": "ERROR",
        "logCount": 2
    },
    {
        "logLevel": "FATAL",
        "logCount": 1
    },
    {
        "logLevel": "TRACE",
        "logCount": 4
    }
]
     
3. POST : http://localhost:8080/log
   
   Body: {
        "logLevel": "TRACE",
        "logMsg": "test message",
        "hostName":"some IP",
        "date":"2020-02-19T09:58:25",
        "processName":"some process Name"
        
    }

4. POST : http://localhost:8080/logs
  
  BODY : [{
        "logLevel": "TRACE",
        "logMsg": "test message",
        "hostName":"some IP",
        "date":"2020-02-19T09:58:25",
        "processName":"some process Name"
        
    },
    {
        "logLevel": "TRACE",
        "logMsg": "test message",
        "hostName":"some IP",
        "date":"2020-02-19T09:58:25",
        "processName":"some process Name"
        
    },
    {
        "logLevel": "ERROR",
        "logMsg": "test message",
        "hostName":"some IP",
        "date":"2020-02-19T09:58:25",
        "processName":"some process Name"
        
    }]
      
5. GET : http://localhost:8080/statsBetween/?startDate=2020-01-12&endDate=2020-02-12
 
 Response : 
    [
    {
        "logLevel": "INFO",
        "logCount": 1
    },
    {
        "logLevel": "WARN",
        "logCount": 1
    },
    {
        "logLevel": "DEBUG",
        "logCount": 1
    },
    {
        "logLevel": "ERROR",
        "logCount": 1
    },
    {
        "logLevel": "FATAL",
        "logCount": 1
    },
    {
        "logLevel": "TRACE",
        "logCount": 1
    }
]

6. GET : http://localhost:8080/logsBetween/?startDate=2020-01-13&endDate=2020-02-12&logLevel=ALL&page=0&size=1

RESPONSE :
  [
    {
        "logId": 11,
        "logLevel": "INFO",
        "logMsg": "test message",
        "processName": null,
        "hostName": "some IP",
        "date": "2020-01-13T00:00:00.000+0000"
    }
]


     

UI Components :
===============

1. Component to render logs table
2. Component to render Statistics 

Backend Spring Boot Java classes:
================================
 1. LogAnalyzerController 
 2. LogAnalyzerService 
 3. LogAnalyzerRepo
 4. LogEntity 
