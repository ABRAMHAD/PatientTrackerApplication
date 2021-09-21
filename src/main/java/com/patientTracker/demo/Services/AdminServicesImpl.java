package com.patientTracker.demo.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.patientTracker.demo.Controller.AdminController;
import com.patientTracker.demo.Entities.Admin;
import com.patientTracker.demo.Entities.Doctor;
import com.patientTracker.demo.Entities.Patient;
import com.patientTracker.demo.Exception.AdminNotFoundException;
import com.patientTracker.demo.Exception.BadRequestException;
import com.patientTracker.demo.Exception.DoctorNotFoundException;
import com.patientTracker.demo.Exception.PatientNotFoundException;
import com.patientTracker.demo.Repository.AdminRepo;
import com.patientTracker.demo.Repository.DoctorRepo;
import com.patientTracker.demo.Repository.PatientRepo;

@Service
public class AdminServicesImpl implements AdminService {

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	public AdminServicesImpl() {

	}

	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private DoctorRepo doctorRepo;

	@Autowired
	private PatientRepo patientRepo;
	
	
	//Add admin
	@Override
	public Admin addAdmin(Admin admin) {
		adminRepo.save(admin);
		return admin;
	}

	//Get admin
	@Override
	public List<Admin> getAdmin() {
		LOG.info("getAdmin");
		List<Admin> adminList = adminRepo.findAll();
		if (adminList.size() == 0) {
			LOG.error("No admin has added yet");
			throw new AdminNotFoundException();
		} else
			return adminList;
	}
	
	//Login Admin
	@Override
	public String loginAdmin(Admin admin) {
		LOG.info("login Admin");
		LOG.info(admin.toString());
		Admin admin2 = adminRepo.findByUserName(admin.getUserName());
		LOG.info(admin2.toString());
		if (admin.getUserName().equals(admin2.getUserName()) && admin.getPassword().equals(admin2.getPassword())) {
			LOG.info(admin.toString());
			LOG.info(admin2.toString());
			return "Login Succesful";
		} else {
			throw new BadRequestException("Invalid user name.");
		}

	}

	//Add Doctor
	@Override
	public Doctor addDoctor(Doctor doctor) {
		LOG.info("addDoctor");
		try {
			return doctorRepo.save(doctor);
		}catch(IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}

	}
	
	//Get Doctor
	@Override
	public Doctor getDoctorById(int dId) {
		LOG.info("getDoctorById "  +dId);
		Optional<Doctor> optDoc= doctorRepo.findById(dId);
		if(optDoc.isEmpty()) {
			LOG.error("Doctor not found");
			throw new DoctorNotFoundException();
		}else
			return optDoc.get();
	}
	
	//Update doctor
	@Override
	public Doctor updateDoctor(Doctor doctor) {
		LOG.info("updateDoctor");
		doctorRepo.save(doctor);
		return doctor;
	}

	//Delete doctor
	@Override
	public int deleteDoctor(int dId) {
		LOG.info("deleteDoctor");
		doctorRepo.deleteById(dId);
		return dId;
	}
	
	//Get doctor
	@Override
	public List<Doctor> getDoctor() {
		LOG.info("getAllDoctor");
		return this.doctorRepo.findAll();
	}

	// Patient Functions

	//Add patient
	@Override
	public Patient addPatient(Patient patient) {
		LOG.info("addPatient");
		try {
			return patientRepo.save(patient);
		}catch(IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}
	
	//Get patient by Id
	@Override
	public Patient getPatientById(int pId) {
		LOG.info("getPatientById "  +pId);
		Optional<Patient> optPat= patientRepo.findById(pId);
		if(optPat.isEmpty()) {
			LOG.error("Patient not found");
			throw new PatientNotFoundException();
		}else
			return optPat.get();
	}

	//Get patient by Id
	@Override
	public List<Patient> getPatient() {
		LOG.info("getAllPatient");
		return this.patientRepo.findAll();
	}

	//Update patient 
	@Override
	public Patient updatePatient(Patient patient) {
		LOG.info("updatePatient");
		patientRepo.save(patient);
		return patient;
	}

	//Delete patient
	@Override
	public int deletePatient(int pId) {
		LOG.info("deletePatient");
		patientRepo.deleteById(pId);
		return pId;
	}

	
	

//	@Override
//	public int deletePatient(int pId) {
//		patientRepo.deleteById(pId);
//		return pId;
//	}

//	@Override
//	public void deletePatient(int parseLong) {
//		Patient entity = patientRepo.getOne(parseLong);
//		patientRepo.delete(entity);
//		
//	}

}
