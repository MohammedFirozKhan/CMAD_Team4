package com.cisco.cmad.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cisco.cmad.jpa.entity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long>{
	
	  @Query(value = "select log.log_Level as logLevel, count(log.log_Level) as logCount from LOG log where log.date >= (now() - interval :interval day) GROUP BY log.log_Level",nativeQuery = true)
	  <T>  List<T> getLogStats(@Param("interval") Integer interval, Class<T> type);
	  	  
	  Page<Log> findByDateGreaterThanEqual(Date date, Pageable pagable);
	  
	  
	  Page<Log> findByLogLevelAndDateGreaterThanEqual(String logLevel, Date date, Pageable pagable);
	  

	
	

}
