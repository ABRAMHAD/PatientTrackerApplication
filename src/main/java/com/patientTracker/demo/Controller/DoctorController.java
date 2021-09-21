/**
 * 
 */
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patientTracker.demo.Entities.Doctor;
import com.patientTracker.demo.Entities.Patient;
import com.patientTracker.demo.Entities.TreatmentHistory;
import com.patientTracker.demo.Repository.TreatmentHistoryRepository;
import com.patientTracker.demo.Services.AdminService;
import com.patientTracker.demo.Services.DoctorService;

/**
 * @author user
 *
 */
@RestController
//@RequestMapping("/doctor")
@RequestMapping("/Doctor")
public class DoctorController {
	
	private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	private AdminService adminService;

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private TreatmentHistoryRepository treatment;

	//Login doctor
	@PostMapping("/Login_Doctor")
	public String login(@RequestBody Doctor doctor) {
		LOG.info("Login Doctor");
		return this.doctorService.loginDoctor(doctor);
	}
	
	//Add patient
	@PostMapping("/addPatient")
	public Patient addPatient(@RequestBody Patient patient) {
		LOG.info("addPatient");
		return this.adminService.addPatient(patient);
	}
	
	//Get patient
	@GetMapping("/getPatient")
	public List<Patient> getPatient() {
		LOG.info("getPatient");
		return this.adminService.getPatient();
	}
	
	//Get patient by Id
	@GetMapping("/searchPatientById/{pId}")
	public ResponseEntity<Patient> getPatientById(@PathVariable int pId) {
		LOG.info("getPatientById");
		Patient pat = adminService.getPatientById(pId);
		return new ResponseEntity<Patient>(pat, HttpStatus.OK);
	}

	//Update patient by Id
	@PutMapping("/updatePatient/{patientId}")
	public Patient updatePatient(@RequestBody Patient patient) {
		LOG.info("updatePatient");
		return this.adminService.updatePatient(patient);
	}

//	//Add Treatment History
//	@PostMapping("/addTreatmentHistory")
//	public TreatmentHistory addTreatmentHistory(@RequestBody TreatmentHistory treatmentHistory) {
//		return this.doctorService.addTreatmentHistory(treatmentHistory);
//
//	}

	//Get TreatmentHistory 
	@GetMapping("/viewTreatmentHistory")
	public List<TreatmentHistory> getTreatmentHistory() {
		// return this.doctorService.getTreatmentHistory();
		LOG.info("ViewTreatmentHistory");
		return this.doctorService.getTreatmentHistory();
	}

	@DeleteMapping(path="/deletePatient/{pId}")
	public int deletePatient(@PathVariable int pId) {
	return this.adminService.deletePatient(pId);
	}
	
	//Get Patient History
	@GetMapping(path="/search_History/{pId}")
	public ResponseEntity<TreatmentHistory> getTreatmentHistoryById(@PathVariable int pId) {
		LOG.info("getTreatmentHistoryById");
		TreatmentHistory trt = doctorService.getPatientById(pId);
		return new ResponseEntity<TreatmentHistory>(trt,HttpStatus.OK);
	}	
}
