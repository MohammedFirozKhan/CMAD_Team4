package com.cisco.cmad.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.cmad.jpa.entity.Log;
import com.cisco.cmad.model.LogStatistic;
import com.cisco.cmad.service.LogServiceImpl;

@RestController
@CrossOrigin
public class LogController {
	
	@Autowired
	private LogServiceImpl logService;
	
	
	@PostMapping(path = "/logs")
	public ResponseEntity<List<Log>> addLogs(@RequestBody List<Log> logs) {
		return new ResponseEntity<List<Log>>(logService.addLogs(logs), HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/log")
	public ResponseEntity<Log> addLog(@RequestBody Log log) {
		return new ResponseEntity<Log>(logService.addLog(log), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/logs")
	public ResponseEntity<List<Log>> getLogs(@RequestParam("interval") Integer interval, @RequestParam("logLevel") String logLevel, @RequestParam("page") Integer page, @RequestParam("size") Integer size){
		return new ResponseEntity<List<Log>>(logService.getLogs(interval, logLevel, PageRequest.of(page, size)).getContent(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/logsBetween")
	public ResponseEntity<List<Log>> getLogs(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, @RequestParam("logLevel") String logLevel, @RequestParam("page") Integer page, @RequestParam("size") Integer size){
		return new ResponseEntity<List<Log>>(logService.getLogs(startDate, endDate, logLevel, PageRequest.of(page, size)).getContent(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/allLogs")
	public ResponseEntity<List<Log>> getLogs(){
		return new ResponseEntity<List<Log>>(logService.getLogs(), HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/stats")
	public ResponseEntity<List<LogStatistic>> getLogStatistics(@RequestParam("interval") Integer interval,Pageable pageable){
		return new ResponseEntity<List<LogStatistic>>(logService.getLogStatistics(interval), HttpStatus.OK);
	}
	
	@GetMapping(path = "/statsBetween")
	public ResponseEntity<List<LogStatistic>> getLogStatistics(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,Pageable pageable){
		return new ResponseEntity<List<LogStatistic>>(logService.getLogStatistics(startDate, endDate), HttpStatus.OK);
	}
	
	
	
	

}
