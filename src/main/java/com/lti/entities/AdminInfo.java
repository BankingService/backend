package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AdminInfo {
 
	@Id
	private int adminId;
	
//	@OneToOne
//	@JoinColumn(name = "customerId")
//	private CustomerInfo customerId;
	
	private String adminName;
	private String adminPassword;

	public AdminInfo() {

	}

	public AdminInfo(int adminId) {
		this.adminId = adminId;
	}

//	public CustomerInfo getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomer(CustomerInfo customerId) {
//		this.customerId = customerId;
//	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}
