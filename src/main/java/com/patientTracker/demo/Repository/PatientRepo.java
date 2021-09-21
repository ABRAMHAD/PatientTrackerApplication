package com.patientTracker.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientTracker.demo.Entities.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

	//public List<Patient> findByTreatmentHistory_tId(int id);
	
}
