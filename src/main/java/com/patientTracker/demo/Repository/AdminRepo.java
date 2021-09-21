package com.patientTracker.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientTracker.demo.Entities.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

	Admin findByUserName(String userName);

	Admin findByPassword(String password);

}
