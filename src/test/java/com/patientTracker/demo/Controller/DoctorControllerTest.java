package com.patientTracker.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.patientTracker.demo.Entities.Doctor;

@SpringBootTest
public class DoctorControllerTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(DoctorControllerTest.class);
	
	@Autowired
	private DoctorController doctorController;
	
	

}
