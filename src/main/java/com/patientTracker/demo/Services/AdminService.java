package com.patientTracker.demo.Services;

import java.util.List;

//import java.util.List;

import com.patientTracker.demo.Entities.Admin;
import com.patientTracker.demo.Entities.Doctor;
import com.patientTracker.demo.Entities.Patient;

public interface AdminService {

	public Admin addAdmin(Admin admin);

	public List<Admin> getAdmin();

	public String loginAdmin(Admin admin);

	public Doctor addDoctor(Doctor doctor);

	public Doctor updateDoctor(Doctor doctor);

	public List<Doctor> getDoctor();

	public Patient addPatient(Patient patient);

	public List<Patient> getPatient();

	public Patient updatePatient(Patient patient);

	public int deletePatient(int pId);

	public int deleteDoctor(int dId);

	public Doctor getDoctorById(int dId);

	public Patient getPatientById(int pId);

	// public void deletePatient(long parseLong);

}
