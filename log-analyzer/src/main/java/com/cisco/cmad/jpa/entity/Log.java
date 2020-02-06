package com.cisco.cmad.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long logId;
	private Date date;
	private String logLevel;
	private String logString;
	private String processId;

}
