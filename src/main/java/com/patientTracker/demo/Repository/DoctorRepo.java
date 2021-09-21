package com.patientTracker.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.patientTracker.demo.Entities.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

	//Doctor findByEmail(String doctorEmail);

	Doctor findByPassword(String password);
}
