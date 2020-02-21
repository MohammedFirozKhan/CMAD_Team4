package com.cisco.cmad.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cisco.cmad.jpa.entity.Log;
import com.cisco.cmad.model.LogStatistic;
import com.cisco.cmad.repository.LogRepository;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogRepository logRepository;

	public List<Log> addLogs(List<Log> logs) {
		return logRepository.saveAll(logs);
	}

	public Log addLog(Log log) {
		return logRepository.save(log);
	}

	public List<LogStatistic> getLogStatistics(Integer interval) {

		return logRepository.getLogStats(interval, LogStatistic.class);

	}
	
	public List<LogStatistic> getLogStatistics(Date startDate, Date endDate) {

		return logRepository.getLogStats(startDate, endDate, LogStatistic.class);

	}
	
	
	public Page<Log> getLogs(Date startDate, Date endDate, String logLevel, Pageable pageable) {
		
		if (StringUtils.isBlank(logLevel) || "ALL".equalsIgnoreCase(logLevel)) {
			return logRepository.findByDateBetween(startDate, endDate, pageable);
		}

		return logRepository.findByLogLevelAndDateBetween(logLevel,startDate,endDate, pageable);

	}

	public Page<Log> getLogs(Integer interval, String logLevel, Pageable pageable) {
		
		Date startDate = convertIntervalToStartDate(interval);

		if (StringUtils.isBlank(logLevel) || "ALL".equalsIgnoreCase(logLevel)) {
			return logRepository.findByDateGreaterThanEqual(startDate, pageable);
		}

		return logRepository.findByLogLevelAndDateGreaterThanEqual(logLevel,startDate, pageable);

	}

	private Date convertIntervalToStartDate(Integer interval) {
		Date currentDate = new Date();
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.minusDays(interval);
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public List<Log> getLogs() {
		return logRepository.findAll();
	}

}
