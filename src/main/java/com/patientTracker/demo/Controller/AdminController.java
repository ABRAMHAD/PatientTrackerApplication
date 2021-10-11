package com.patientTracker.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.patientTracker.demo.Exception.AdminExistsException;
import com.patientTracker.demo.Exception.AdminNotFoundException;
import com.patientTracker.demo.Exception.DoctorNotFoundException;
import com.patientTracker.demo.Exception.PatientNotFoundException;
import com.patientTracker.demo.Repository.DoctorRepo;
import com.patientTracker.demo.Services.AdminService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class AdminController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DoctorRepo doctorRepo;

	// Home Page for Home
	@GetMapping("/Home")
	public String home() {
		return "Welcome to Patient Tracker System";
	}

	// Get the Admin
	@GetMapping("/getAdmin")
	public ResponseEntity<Object> getAdmin() {
		LOG.info("getAdmin");
		List<Admin> adminList =  new ArrayList<Admin>();
		try {
			adminList = adminService.getAdmin();
			return new ResponseEntity<Object>(adminList, HttpStatus.OK);
		}catch (AdminNotFoundException e) {
			return new ResponseEntity<Object>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
	
	/*
	 * @GetMapping("/viewMovieList")
	public ResponseEntity<Object> viewMovieList(){
		logger.debug("viewMovieList method is accessed from the MovieController");
		
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			movieList = service.viewMovieList();
			return new ResponseEntity<Object>(movieList, HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<Object>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
	 */

	// Add the Admin
	@PostMapping("/addAdmin")
	public ResponseEntity<Object> addAdmin(@Valid @RequestBody Admin admin) {
		LOG.info("addAdmin");
		Admin adminData;
		try {
			adminData = adminService.addAdmin(admin);
			return new ResponseEntity<Object>(adminData, HttpStatus.OK);
		} catch (AdminExistsException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	

	// Admin Login
	@PostMapping(path = "/loginAdmin")
	public String login(@RequestBody Admin admin) {
		LOG.info("Login");
		return this.adminService.loginAdmin(admin);
	}

	// Add Doctor
	@PostMapping(path = "/addDoctor")
	public ResponseEntity<Object> addDoctor(@RequestBody Doctor doctor) {
		LOG.info("addDoctor");
		Doctor doctorAdd = new Doctor();
		try {
			doctorAdd = adminService.addDoctor(doctor);
			return new ResponseEntity<Object>(doctorAdd, HttpStatus.CREATED);
		}
		catch (DoctorNotFoundException e) 
		{
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	

	// Get Doctor
	@GetMapping("/getDoctor")
	public List<Doctor> getDoctor() {
		LOG.info("getDoctor");
		return this.adminService.getDoctor();
	}

	// get doctor by Id
	@GetMapping("/getDoctorById/{dId}")
	public ResponseEntity<Doctor> getDocById(@PathVariable int dId) {
		LOG.info("getDoctorById");
		Doctor doc = adminService.getDoctorById(dId);
		return new ResponseEntity<Doctor>(doc, HttpStatus.OK);
	}

	// Delete doctor by Id
	@DeleteMapping("/deleteDoctor/{dId}")
	public int deleteDoctor(@PathVariable int dId) {
		LOG.info("deleteDoctor");
		return this.adminService.deleteDoctor(dId);
	}

	// Update doctor by Id
	@PutMapping(path = "/updateDoctor")
	public ResponseEntity<Object> updateDoctor(@RequestBody Doctor doctor) {
		LOG.info(doctor.toString());
		Doctor doctorUpdate = new Doctor();
		try {
			doctorUpdate = adminService.updateDoctor(doctor);
			return new ResponseEntity<Object>(doctorUpdate, HttpStatus.OK);
		} catch (DoctorNotFoundException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
//	@PutMapping("/updateDoctor/{dId}")
//	public ResponseEntity<Doctor> updateEmployee(@PathVariable Integer dId, @RequestBody Doctor doctor){
//		Doctor doc = doctorRepo.findById(dId)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + dId));
//		
//		employee.setFirstName(employeeDetails.getFirstName());
//		employee.setLastName(employeeDetails.getLastName());
//		employee.setEmailId(employeeDetails.getEmailId());
//		
//		Employee updatedEmployee = employeeRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}
	
	/*
	 * @PostMapping("/updateMovie")
	public ResponseEntity<Object> updateMovie(@Valid @RequestBody Movie movie){
		logger.debug("updateMovie method is accessed from the MovieController");
		
		Movie movieUpdate = new Movie();
		try {
			movieUpdate = service.updateMovie(movie);
			return new ResponseEntity<Object>(movieUpdate, HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	 */

	// Patient functions
	@PostMapping("/addPatient")
	public ResponseEntity<Object> addPatient(@Valid @RequestBody Patient patient) {
		LOG.info("addPatient");
		Patient patientAdd = new Patient();
		try {
			patientAdd = adminService.addPatient(patient);
			return new ResponseEntity<Object>(patientAdd, HttpStatus.CREATED);
		} 
		catch (PatientNotFoundException e) 
		{
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	

	// Get patient
	@GetMapping(path = "/getPatient")
	public List<Patient> getPatient() {
		LOG.info("getPatient");
		return this.adminService.getPatient();
	}

	// get patient by Id
	@GetMapping("/getPatientById/{pId}")
	public ResponseEntity<Patient> getPatientById(@PathVariable int pId) {
		LOG.info("getPatientById");
		Patient pat = adminService.getPatientById(pId);
		return new ResponseEntity<Patient>(pat, HttpStatus.OK);
	}

	// update patient by Id
	@PutMapping(path = "/updatePatient/{Patient_Id}")
	public Patient updatePatient(@RequestBody Patient patient) {
		return this.adminService.updatePatient(patient);
	}

//	@DeleteMapping(path = "/deletePatient/{Patient_Id}")
//	public int deletePatient(@PathVariable int pId) {
//		return adminService.deletePatient(pId);
//	}

}
