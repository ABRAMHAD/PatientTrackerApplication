package com.patientTracker.demo.Sevice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.patientTracker.demo.Controller.DoctorControllerTest;
import com.patientTracker.demo.Entities.Doctor;
import com.patientTracker.demo.Services.AdminService;

@SpringBootTest
public class DoctorServices {
	
	private static final Logger LOG = LoggerFactory.getLogger(DoctorControllerTest.class);
	
	@Autowired
	private AdminService adminService;
	
	@Test
	public void testFindDoctorById() throws Exception{
		LOG.info("testDoctorById");
		Doctor expected = new Doctor(3,"Manasi","manasi@gmail.com","manasi@1999","BDS");
		Doctor actual = adminService.getDoctorById(3);
		assertEquals(expected.getdId(), actual.getdId());
		
	}
	@Test
	public void testFindDoctorByIdNotFound() throws Exception{
		LOG.info("testNotDoctorById");
		Doctor unexpected = new Doctor(3,"Manasi","manasi@gmail.com","manasi@1999","BDS");
		Doctor actual = adminService.getDoctorById(9);
		assertNotEquals(unexpected.getdId(), actual.getdId());
		
	}

}
