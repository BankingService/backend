package com.lti.entities;

import java.time.LocalDate;

import javax.persistence.Entity;


@Entity
public class UserLoginCredentials {

	private CustomerInfo customerId;
	private int invalidAttempts;
	private LocalDate lastLoginDateTime;
	private String lastLoginIpAddress;

	public UserLoginCredentials() {
	}

	public UserLoginCredentials(CustomerInfo customerId, int invalidAttempts, LocalDate lastLoginDateTime,
			String lastLoginIpAddress) {
		this.customerId = customerId;
		this.invalidAttempts = invalidAttempts;
		this.lastLoginDateTime = lastLoginDateTime;
		this.lastLoginIpAddress = lastLoginIpAddress;
	}

	public CustomerInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerInfo customerId) {
		this.customerId = customerId;
	}

	public int getInvalidAttempts() {
		return invalidAttempts;
	}

	public void setInvalidAttempts(int invalidAttempts) {
		this.invalidAttempts = invalidAttempts;
	}

	public LocalDate getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	public void setLastLoginDateTime(LocalDate lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}

	public String getLastLoginIpAddress() {
		return lastLoginIpAddress;
	}

	public void setLastLoginIpAddress(String lastLoginIpAddress) {
		this.lastLoginIpAddress = lastLoginIpAddress;
	}

}
