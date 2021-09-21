package com.patientTracker.demo.entities;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.patientTracker.demo.Entities.Admin;
import com.patientTracker.demo.Sevice.AdminServiceTest;

@SpringBootTest
public class AdminTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(AdminServiceTest.class);
	
	@Test
	void testAdmin() {
//		Admin expected = new Admin() ;
//		expected.setAdminId(1);
//		expected.setUserName("pooja");
//		expected.setPassword("pooja@1999");
//		//boolean result = adminService.addAdmin(expected);
//		boolean result = adminService.addAdmin(expected) != null;
//		assertTrue(result);
	}

}
