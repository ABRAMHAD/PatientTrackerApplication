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
import com.patientTracker.demo.Exception.AdminExistsException;
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
	public Admin addAdmin(Admin admin) throws AdminExistsException {
		
		if(adminRepo.existsById(admin.getAdminId())) {
			throw new AdminExistsException("Admin Id exists already");
		}
		else {
			Admin adminObj = adminRepo.save(admin);
			return adminObj;
		}
	}
	
	//Get admin
	@Override
	public List<Admin> getAdmin() throws AdminNotFoundException {
		LOG.info("getAdmin");
		List<Admin> adminList = adminRepo.findAll();
		if(!adminList.isEmpty())
		{
			return adminList;
		}else
		{
			LOG.error("Admin Not Found Exception thrown");
			throw new AdminNotFoundException("Admin List does not exist.");
		}
			
	}
	
	//Login admin
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
		}else {
			throw new BadRequestException("Invalid user name or password.");
		}

	}

	//Add Doctor
	@Override
	public Doctor addDoctor(Doctor doctor) throws DoctorNotFoundException {
		
		LOG.info("addDoctor");
		
		
		if(!doctorRepo.existsById(doctor.getdId()))
		{
			Doctor doctorAdd = doctorRepo.save(doctor);
			return doctorAdd;	
		}
		else
		{
			LOG.error("Doctor Not Found Exception thrown");
			throw new DoctorNotFoundException("Doctor cannot be added as id "+ doctor.getdId() + " already exist in Database.");
		}
		
	}
	
	
	
	//Get Doctor
	@Override
	public Doctor getDoctorById(int dId) {
		LOG.info("getDoctorById "  +dId);
		Optional<Doctor> optDoc= doctorRepo.findById(dId);
		if(optDoc.isEmpty()) {
			LOG.error("Doctor not found");
			throw new DoctorNotFoundException("Doctor with "+dId+" does not exist.");
		}else
			return optDoc.get();
	}
	
	//Update doctor
	@Override
	public Doctor updateDoctor(Doctor doctor) throws DoctorNotFoundException {
		LOG.info("updateDoctor");
		if(doctorRepo.existsById(doctor.getdId()))
		{
			Doctor doctorUpdate = doctorRepo.save(doctor);
			return doctorUpdate;
		}
		else
		{
			LOG.error("Doctor Not Found Exception thrown");
			throw new DoctorNotFoundException("Doctor with Id "+doctor.getdId()+ " cannot be updated as it does not exist in DB");
		}
	}
	
	/*
	 * @Override
	public Movie updateMovie(Movie movie) throws MovieNotFoundException {
		logger.debug("updateMovie method is accessed in MovieService");
		
		if(repository.existsById(movie.getMovieId()))
		{
			Movie movieUpdate = repository.save(movie);
			return movieUpdate;
		}
		else
		{
			logger.error("Movie Not Found Exception thrown");
			throw new MovieNotFoundException("Movie with Id "+movie.getMovieId()+ " cannot be updated as it does not exist in DB");
		}
	}
	 */

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
	public Patient addPatient(Patient patient) throws PatientNotFoundException {
		LOG.info("addPatient");
		if(!patientRepo.existsById(patient.getpId()))
		{
			Patient patientAdd = patientRepo.save(patient);
			return patientAdd;	
		}else
		{
			LOG.error("Patient Not Found Exception thrown");
			throw new PatientNotFoundException("Patient cannot be added as id "+patient.getpId()+ " already exist in Database.");
		}
	}
	
	
	//Get patient by Id
	@Override
	public Patient getPatientById(int pId) {
		LOG.info("getPatientById "  +pId);
		Optional<Patient> optPat= patientRepo.findById(pId);
		if(optPat.isEmpty()) {
			LOG.error("Patient not found");
			throw new PatientNotFoundException("hi");
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
