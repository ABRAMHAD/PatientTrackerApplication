package com.patientTracker.demo.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

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
public class AdminControllerTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(AdminControllerTest.class);
	
	
	@Autowired
	private AdminController adminController;
	
	
	@Test
	public void testGetDoctorById() throws Exception{
		LOG.info("testGetDoctorById");
		
		HttpStatus expected = HttpStatus.OK;
		
		ResponseEntity<Doctor> actual = adminController.getDocById(2);
		assertEquals(expected, actual.getStatusCode());
	}
	
	@Test
	public void testGetPatientById() throws Exception{
		LOG.info("testGetPatientById");
		
		HttpStatus expected = HttpStatus.OK;
		
		ResponseEntity<Patient> actual = adminController.getPatientById(2);
		assertEquals(expected, actual.getStatusCode());
	}
	
//	boolean result = adminService.addDoctor(expected) != null;
//	assertTrue(result);
	
//	public void addPatientTest() throws Exception{
//		LOG.info("testAddPatient");
//		
//		HttpStatus expected = HttpStatus.OK;
//		
//		ResponseEntity<Patient> actual = adminController.getPatient();
//	    assertEquals(expected, actual.getStatusCode());
//	}
	
	
//	@Test
//	public void testgetAllDoctor() throws Exception{
//		
//		LOG.info("testgetAllDoctor");
//		
//		HttpStatus expected = HttpStatus.OK;
//		List<Doctor> actual = adminController.getDoctor();
//		
//		assertEquals(expected, actual);
//		
//	}
	
	
	

}
