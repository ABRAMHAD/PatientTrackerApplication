/**
 * 
 */
package com.patientTracker.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 * @author user
 *
 */
@Entity
@Table(name = "HISTORY_TABLE")
public class TreatmentHistory {

	@Id
	@Column(name = "TREATMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;

	@Column(name = "DATE_OF_ARRIVAL")
	private String dateOfArrival;

	@Column(name = "TREATMENT_COST")
	private int treatmentCost;

	@Column(name = "MEDICATION", length = 20, nullable = false)
	private String consultation;

	@Column(name = "DIESEASE", length = 20, nullable = false)
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String disease;

//	@ManyToOne()
//	@JoinColumn(name = "Patient_pId")
//	Patient patient;

//	@ManyToOne
//	@JoinColumn(name = "dId")
//	Doctor doctor;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "Patient_pId")
//	private Patient patient;


	public TreatmentHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TreatmentHistory(int tId, String dateOfArrival, int treatmentCost, String consultation, String disease) {
		super();
		this.tId = tId;
		this.dateOfArrival = dateOfArrival;
		this.treatmentCost = treatmentCost;
		this.consultation = consultation;
		this.disease = disease;
//		this.patient = patient;
//		this.doctor = doctor;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(String dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public int getTreatmentCost() {
		return treatmentCost;
	}

	public void setTreatmentCost(int treatmentCost) {
		this.treatmentCost = treatmentCost;
	}

	public String getConsultation() {
		return consultation;
	}

	public void setConsultation(String consultation) {
		this.consultation = consultation;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	

	@Override
	public String toString() {
		return "TreatmentHistory [tId=" + tId + ", dateOfArrival=" + dateOfArrival + ", treatmentCost=" + treatmentCost
				+ ", consultation=" + consultation + ", disease=" + disease + "]";
	}

}
