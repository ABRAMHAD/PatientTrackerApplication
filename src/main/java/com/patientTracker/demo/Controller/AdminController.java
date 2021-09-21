package com.patientTracker.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.patientTracker.demo.Entities.Admin;
import com.patientTracker.demo.Entities.Doctor;
import com.patientTracker.demo.Entities.Patient;
import com.patientTracker.demo.Services.AdminService;

@RestController
public class AdminController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	//Home Page for Home 
	@GetMapping("/Home")
	public String home() {
		return "Welcome to Patient Tracker System";
	}
	
	//Get the Admin
	@GetMapping("/getAdmin")
	public ResponseEntity<List<Admin>> getAdmin() {
		LOG.info("getAdmin");
		List<Admin> adminList = adminService.getAdmin();
		return new ResponseEntity<>(adminList,HttpStatus.OK);
	}
	
	//Add the admin
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		LOG.info("addAdmin");
		return this.adminService.addAdmin(admin);
	}
	
	//Admin Login
	@PostMapping(path = "login")
	public String login(@RequestBody Admin admin) {
		LOG.info("Login");
		return this.adminService.loginAdmin(admin);
	}
	
	//Add Doctor
	@PostMapping(path = "/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		LOG.info("addDoctor");
		return this.adminService.addDoctor(doctor);
	}
	
	//Get Doctor
	@GetMapping("/getDoctor")
	public List<Doctor> getDoctor() {
		LOG.info("getDoctor");
		return this.adminService.getDoctor();
	}
	
	//get doctor by Id
	@GetMapping("/searchDoctorById/{dId}")
	public ResponseEntity<Doctor> getDocById(@PathVariable int dId) {
		LOG.info("getDoctorById");
		Doctor doc = adminService.getDoctorById(dId);
		return new ResponseEntity<Doctor>(doc, HttpStatus.OK);
	}

	//Delete doctor by Id
	@DeleteMapping("/deleteDoctor/{dId}")
	public int deleteDoctor(@PathVariable int dId) {
		LOG.info("deleteDoctor");
		return this.adminService.deleteDoctor(dId);
	}

	//Update doctor by Id
	@PutMapping(path = "/updateDoctor/{doctorId}")
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		LOG.info("updateDoctor");
		return this.adminService.updateDoctor(doctor);
	}

	// Patient functions
	@PostMapping("/addPatient")
	public Patient addPatient(@RequestBody Patient patient) {
		LOG.info("addPatient");
		return this.adminService.addPatient(patient);
	}

	//Get patient
	@GetMapping(path = "/getPatient")
	public List<Patient> getPatient() {
		LOG.info("getPatient");
		return this.adminService.getPatient();
	}

	//get patient by Id
	@GetMapping("/searchPatientById/{pId}")
	public ResponseEntity<Patient> getPatientById(@PathVariable int pId) {
		LOG.info("getPatientById");
		Patient pat = adminService.getPatientById(pId);
		return new ResponseEntity<Patient>(pat, HttpStatus.OK);
	}
	
	//update patient by Id
	@PutMapping(path = "/updatePatient/{Patient_Id}")
	public Patient updatePatient(@RequestBody Patient patient) {
		return this.adminService.updatePatient(patient);
	}

//	@DeleteMapping(path = "/deletePatient/{Patient_Id}")
//	public int deletePatient(@PathVariable int pId) {
//		return adminService.deletePatient(pId);
//	}

}
