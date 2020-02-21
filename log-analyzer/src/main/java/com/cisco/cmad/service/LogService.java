package com.cisco.cmad.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cisco.cmad.jpa.entity.Log;
import com.cisco.cmad.model.LogStatistic;

public interface LogService {
	
	List<Log> addLogs(List<Log> logs);
	
	Log addLog(Log log);
	
	List<LogStatistic> getLogStatistics(Integer interval);
	
	List<LogStatistic> getLogStatistics(Date startDate, Date endDate);
	
	Page<Log> getLogs(Date startDate, Date endDate, String logLevel, Pageable pageable);
	
	Page<Log> getLogs(Integer interval, String logLevel, Pageable pageable);
	

}
