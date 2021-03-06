/**
 * 
 */
package com.patientTracker.demo.Entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author user
 *
 */

@Entity
@Table(name = "PATIENT_TABLE")
public class Patient {

	@Id
	@Column(name = "P_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;

	@Column(name = "P_NAME", length = 20, nullable = false)
	private String pName;

	@Column(name = "P_GENDER", length = 10, nullable = false)
	private String gender;

	@Column(name = "P_AGE", nullable = false)
	private int age;

	@Column(name = "P_CONTACT", length = 20, nullable = false)
	private String contact;// long datatype

	@Column(name = "P_ADDRESS")
	private String address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Patient_Treatment", joinColumns = { @JoinColumn(name = "P_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "TREATMENT_ID") })
	private Set<TreatmentHistory> treatmentHistory = new HashSet<>();

	public Patient() {
		super();

	}

	public Patient(int pId, String pName, String gender, int age, String contact, String address) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.gender = gender;
		this.age = age;
		this.contact = contact;
		this.address = address;

	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<TreatmentHistory> getTreatmentHistory() {
		return treatmentHistory;
	}

	public void setTreatmentHistory(Set<TreatmentHistory> treatmentHistory) {
		this.treatmentHistory = treatmentHistory;
	}

	@Override
	public String toString() {
		return "Patient [pId=" + pId + ", pName=" + pName + ", gender=" + gender + ", age=" + age + ", contact="
				+ contact + ", address=" + address + "]";
	}

}