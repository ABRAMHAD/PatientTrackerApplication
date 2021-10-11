package com.patientTracker.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdminExistsException extends RuntimeException {
	public AdminExistsException(String msg) {
		//private static final long serialVersionUID =1
		
		super(msg);
	}
}
