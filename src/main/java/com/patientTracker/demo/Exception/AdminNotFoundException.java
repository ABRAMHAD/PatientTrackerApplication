package com.patientTracker.demo.Exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdminNotFoundException extends RuntimeException {
	private static final long serialVersionUID =1L;
	
	public AdminNotFoundException(String msg) {
		super(msg);
	}
}
