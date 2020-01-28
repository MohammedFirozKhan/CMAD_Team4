# CMAD_Team4
Log analyzer  using ReactJs, Spring Boot, Java , MySql, MongoDB

Rest APIs:
==========
1. Search : HTTP Method = GET
     Input parameters : Date, interval , page, pageSize
     Returns : {"timestamp":"timestamp", "level":"ERROR", "text":"log string", "process":"processId"}
     
2. GetStatistics: HTTP Method = GET
     Input parameters : Date, interval
     Returns : {"info": 2000, "Warn":100, "Critical":0, "Error": 2, "Debug":45}
     
3. StoreLogs: HTTP Method = POST
      Body: {"log" : "Log String........"}   
     

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
