package com.patientTracker.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientTracker.demo.Entities.Doctor;
import com.patientTracker.demo.Exception.DoctorNotFoundException;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

	Doctor findByPassword(String password);
	
		
}
