package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class AdminInfo {

	@Id
	@SequenceGenerator(name = "adminId", initialValue = 2021, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminId")
	private int adminId;
	
	@OneToOne(mappedBy = "approvedBy")
	@JoinColumn(name = "customerId")
	private CustomerInfo customerId;
	
	private String adminName;
	private String adminPassword;

	public AdminInfo() {

	}

	public AdminInfo(String adminName, String adminPassword) {
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public CustomerInfo getCustomerId() {
		return customerId;
	}

	public void setCustomer(CustomerInfo customerId) {
		this.customerId = customerId;
	}

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
