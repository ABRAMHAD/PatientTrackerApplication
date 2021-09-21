package com.patientTracker.demo.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.patientTracker.demo.Entities.Doctor;
import com.patientTracker.demo.Entities.Patient;

@SpringBootTest
public class DoctorControllerTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(DoctorControllerTest.class);
	
	@Autowired
	private DoctorController doctorController;
	
	@Autowired
	private AdminController adminController;
	
	@Test
	public void testPatientById() throws Exception{
		LOG.info("testGetPatientById");
		
		HttpStatus expected = HttpStatus.OK;
		
		ResponseEntity<Patient> actual = adminController.getPatientById(2);
		assertEquals(expected, actual.getStatusCode());
	}
	

}
