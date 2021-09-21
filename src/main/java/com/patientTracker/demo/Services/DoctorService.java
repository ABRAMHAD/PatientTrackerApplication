/**
 * 
 */
package com.patientTracker.demo.Services;

import java.util.List;

import com.patientTracker.demo.Entities.Doctor;
import com.patientTracker.demo.Entities.Patient;
import com.patientTracker.demo.Entities.TreatmentHistory;

/**
 * @author user
 *
 */
public interface DoctorService {

	//public TreatmentHistory addTreatmentHistory(TreatmentHistory treatmentHistory);

	public List<TreatmentHistory> getTreatmentHistory();

	public String loginDoctor(Doctor doctor);

	public TreatmentHistory getPatientById(int pId);
	
	//public TreatmentHistory findByPatient(int pId);
	
	//public List<Patient> findByTreatmentHistory_tId(int id);
	
	//public TreatmentHistory findByPId(int pId);

	//public TreatmentHistory getTreatmentHistoryById(int pId);
	//public int findById(Patient pId);

}
