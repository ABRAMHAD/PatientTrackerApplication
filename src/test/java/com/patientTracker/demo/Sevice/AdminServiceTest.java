package com.patientTracker.demo.Sevice;





import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.patientTracker.demo.Entities.Admin;
import com.patientTracker.demo.Entities.Doctor;
import com.patientTracker.demo.Entities.Patient;
import com.patientTracker.demo.Repository.AdminRepo;
import com.patientTracker.demo.Services.AdminService;



@SpringBootTest
public class AdminServiceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(AdminServiceTest.class);
	
	@Autowired
	private AdminService adminService;
	
//	@Autowired
//	private AdminRepo adminRepo;
	

	
	@Test
	void testToAddAdmin() {
		Admin expected = new Admin() ;
		expected.setAdminId(1);
		expected.setUserName("pooja");
		expected.setPassword("pooja@1999");
		//boolean result = adminService.addAdmin(expected);
		boolean result = adminService.addAdmin(expected) != null;
		assertTrue(result);
	}
	
	@Test
	void testToAddDoctor() {
		Doctor expected = new Doctor() ;
		expected.setdId(3);
		expected.setdName("Manasi");
		expected.setPassword("manasi@1999");
		expected.setSpecialization("BDS");
		expected.setDoctorEmail("manasi@gmail.com");
		//boolean result = adminService.addAdmin(expected);
		boolean result = adminService.addDoctor(expected) != null;
		assertTrue(result);
	}
	@Test
	void testToAddPatient() {
		Patient expected = new Patient() ;
		expected.setpId(2);;
		expected.setAddress("Nashik");
		expected.setAge(22);
		expected.setContact("25413655");
		expected.setGender("Female");
		expected.setpName("Nayan");
		boolean result = adminService.addPatient(expected) != null;
		assertTrue(result);
	}
	@Test
	void testTogetAdmin() {
		Admin expected = new Admin() ;
		expected.setAdminId(1);
		expected.setUserName("pooja");
		expected.setPassword("pooja@1999");
		boolean result = adminService.addAdmin(expected) != null;
		assertTrue(result);
	}
	
	
	@Test
	public void testFindDoctorById() throws Exception{
		LOG.info("testDoctorById");
		Doctor expected = new Doctor(2,"Ishwari","ishwari@gmail.com","ishwari@gmail.com","MBBS");
		Doctor actual = adminService.getDoctorById(2);
		assertEquals(expected.getdId(), actual.getdId());
		
	}
	@Test
	public void testFindDoctorByIdNotFound() throws Exception{
		LOG.info("testNotDoctorById");
		Doctor unexpected = new Doctor(2,"Ishwari","ishwari@gmail.com","ishwari@gmail.com","MBBS");
		Doctor actual = adminService.getDoctorById(3);
		assertNotEquals(unexpected.getdId(), actual.getdId());
		
	}
	
	
	@Test
	public void testFindPatientById() throws Exception{
		LOG.info("testPatientById");
		Patient expected = new Patient(2,"Ashwini","Female",50, "54632179","Maharashtra");
		Patient actual = adminService.getPatientById(2);
		assertEquals(expected.getpId(), actual.getpId());
		
	}
	
//	@Test
//	void testToDeleteDoctor() {
//		Doctor expected = new Doctor();
//		expected.setdId(3);
//		expected.setdName("Manasi");
//		expected.setDoctorEmail("manasi@gmail.com");
//		expected.setPassword("manasi@1999");
//		expected.setSpecialization("BDS");
//		adminService.addDoctor(expected);
//		//boolean result = adminService.removeElection(expected.getElectionId());
//		boolean result = adminService.removeDoctor()
//		assertTrue(result);
//	}
	
	
	

	
	
	


}
