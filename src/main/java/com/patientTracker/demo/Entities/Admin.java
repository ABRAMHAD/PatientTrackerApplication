package com.patientTracker.demo.Entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("admin")
//@Scope(scopeName = "prototype")
@Entity
@Table(name = "ADMIN_TABLE")
public class Admin {
	@Id
	@Column(name = "ADMIN_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;

	@Column(name = "ADMIN_NAME", length = 20, nullable = false, unique = true)
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Please Enter Valid Name")
	private String userName;//

	@Column(name = "PASSWORD", length = 20, nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9]+" +"[@#$%^&+=]*" +"(?=\\S+$).{8,20}$")
	private String password;

	public Admin() {
		super();
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(long adminId, String userName, String password) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ", password=" + password + "]";
	}

}
