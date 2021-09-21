/**
 * 
 */
package com.patientTracker.demo.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.patientTracker.demo.Entities.Patient;
import com.patientTracker.demo.Entities.TreatmentHistory;

/**
 * @author user
 *
 */
@Repository
public interface TreatmentHistoryRepository extends JpaRepository<TreatmentHistory, Integer >{
	
	
	
	
	//public abstract int findById(Patient pId);
	// public boolean TreatmentHistory findByPId(int pId);
	 
//	@Query(name = "select t from TreatmentHistory t where t.pid = :pid")
//	 public abstract TreatmentHistory findByPatient(int pId);
//	
	
	
		
}
