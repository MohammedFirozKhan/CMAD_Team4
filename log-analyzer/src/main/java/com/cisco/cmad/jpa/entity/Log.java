package com.cisco.cmad.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long logId;
	private String logLevel;
	private String logMsg;
	private String processName;
	private String hostName;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date date;
	

}
