package com.airtel.common.words.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public ServiceException(String message) {
		this.message = message;
	}

	public String getMessage() {

		return this.message;
	}
}
