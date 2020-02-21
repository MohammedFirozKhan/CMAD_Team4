package com.cisco.cmad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LogNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogNotFoundException(String exception) {
		super(exception);
	}

	public LogNotFoundException(Throwable th) {
		super(th);
	}

	public LogNotFoundException(String exception, Throwable th) {
		super(exception, th);
	}

}
