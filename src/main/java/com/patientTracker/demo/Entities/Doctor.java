package com.patientTracker.demo.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "DOCTOR_TABLE")
public class Doctor {

	@Id
	@Column(name = "DOCTOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dId;

	@Column(name = "DOCTOR_NAME", length = 20, nullable = false)
	private String dName;

	@Column(name = "SPECIALIZATION", length = 20, nullable = false)
	private String specialization;

	@Column(name = "DOCTOR_EMAIL", length = 20, nullable = false, unique = true)
	@Pattern(regexp = "^[a-zA-Z_]+" + "@" + "[a-zA-Z]+\\.[a-zA-Z]{2,7}$", message = "Please Enter Valid Email")
	private String doctorEmail;

	@Column(name = "PASSWORD", length = 20, nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9]+" +"[@#$%^&+=]*" + "(?=\\S+$).{8,20}$")
	private String password;

	@OneToMany
	@JoinColumn(name = "tId")
	private List<TreatmentHistory> treatmentHistory;

	public Doctor() {
		super();
	}

	public Doctor(int dId, String dName, String specialization, String doctorEmail, String password) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.specialization = specialization;
		this.doctorEmail = doctorEmail;
		this.password = password;
	
	}

	public int getdId() {
		return dId;
	}

	//doctor
	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TreatmentHistory> getTreatmentHistory() {
		return treatmentHistory;
	}

	public void setTreatmentHistory(List<TreatmentHistory> treatmentHistory) {
		this.treatmentHistory = treatmentHistory;
	}

	@Override
	public String toString() {
		return "Doctor [dId=" + dId + ", dName=" + dName + ", specialization=" + specialization + ", doctorEmail="
				+ doctorEmail + ", password=" + password + "]";
	}

}