package com.cisco.cmad.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "logId","logLevel", "logMsg", "processName", "hostName", "date" })
public class Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("logId")
	private Long logId;
	@JsonProperty("logLevel")
	private String logLevel;
	@JsonProperty("logMsg")
	private String logMsg;
	@JsonProperty("processName")
	private String processName;
	@JsonProperty("hostName")
	private String hostName;
	@JsonProperty("date")
	private Date date;
	

}
