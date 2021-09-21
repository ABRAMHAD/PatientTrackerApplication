/**
 * 
 */
package com.patientTracker.demo.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.patientTracker.demo.Controller.DoctorController;
import com.patientTracker.demo.Entities.Doctor;
import com.patientTracker.demo.Entities.Patient;
import com.patientTracker.demo.Entities.TreatmentHistory;
import com.patientTracker.demo.Exception.AdminNotFoundException;
import com.patientTracker.demo.Exception.BadRequestException;
import com.patientTracker.demo.Exception.PatientNotFoundException;
import com.patientTracker.demo.Exception.TreatmentHistoryNotFoundException;
import com.patientTracker.demo.Repository.DoctorRepo;
import com.patientTracker.demo.Repository.PatientRepo;
import com.patientTracker.demo.Repository.TreatmentHistoryRepository;

/**
 * @author user
 *
 */
@Service
public class DoctorServiceImpl implements DoctorService {

	private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);

	public DoctorServiceImpl() {

	}

	@Autowired
	TreatmentHistoryRepository treatmentHistoryRepo;

	@Autowired
	DoctorRepo doctorRepo;
	
	@Autowired
	PatientRepo patientRepo;

	//Add treatment history
//	@Override
//	public TreatmentHistory addTreatmentHistory(TreatmentHistory treatmentHistory) {
//		treatmentHistoryRepo.save(treatmentHistory);
//		return treatmentHistory;
//	}

	//get treatment history
	@Override
	public List<TreatmentHistory> getTreatmentHistory() {
		return this.treatmentHistoryRepo.findAll();
	}

	//Login Doctor
	@Override
	public String loginDoctor(Doctor doctor) {
		LOG.info("login Doctor");
		LOG.info(doctor.toString());
		// Doctor doctor2 = doctorRepo.findByEmail(doctor.getDoctorEmail());
		Doctor doctor2 = doctorRepo.findByPassword(doctor.getPassword());
		// LOG.info(doctor2.toString());
		if (doctor.getPassword().equals(doctor2.getPassword())) {
			LOG.info(doctor.toString());
			LOG.info(doctor2.toString());
			return "Login Succesful";
		} else {
			throw new BadRequestException("Invalid username or password");
		}

	}

	@Override
	public TreatmentHistory getPatientById(int pId) {
		LOG.info("getTreatmentHistoryById");
		Optional<TreatmentHistory> optTrt = treatmentHistoryRepo.findById(pId);
		if(optTrt.isEmpty()) {
			LOG.info("Treatment history not found");
			throw new TreatmentHistoryNotFoundException();
		}else
			return optTrt.get();
	}

	



//	@Override
//	public List<Patient> findByTreatmentHistory_tId(int id) {
//		return patientRepo.findByTreatmentHistory_tId(id);
//	}

	


//	@Override
//	public int findById(Patient pId) {
//		LOG.info("getTreatmentHistoryById" +pId);
//		
//		return 0;
//	}

	//get treatmentHistory
//	@Override
//	public TreatmentHistory getTreatmentHistoryById(int pId) {
//		LOG.info("getTreatmentHistoryById "  +pId);
//		Optional<TreatmentHistory> optPat= treatmentHistoryRepo.findById(pId);
//		if(optPat.isEmpty()) {
//			LOG.error("TreatmentHistory not found");
//			throw new PatientNotFoundException();
//		}else
//			return optPat.get();
//		
//		
//	}

}
