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

	public List<TreatmentHistory> getTreatmentHistory();

	public String loginDoctor(Doctor doctor);

	public TreatmentHistory getPatientById(int pId);

}
