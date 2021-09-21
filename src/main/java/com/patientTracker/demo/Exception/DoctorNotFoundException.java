/**
 * 
 */
package com.patientTracker.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author user
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DoctorNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID =1L;
	
	public DoctorNotFoundException() {
		super();
	}
}
