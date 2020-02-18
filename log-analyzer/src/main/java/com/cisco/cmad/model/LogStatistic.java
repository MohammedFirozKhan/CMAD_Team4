package com.cisco.cmad.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "logLevel", "logCount" })
public interface LogStatistic {

	@JsonProperty("logLevel")
	public String getLogLevel();

	@JsonProperty("logCount")
	public Long getLogCount();

}
