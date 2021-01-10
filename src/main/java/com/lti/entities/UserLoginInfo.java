package com.lti.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserLoginInfo implements Serializable {

	@Id
	@OneToOne(targetEntity = UserLoginCredentials.class)
	@JoinColumn(name = "customerId")
	private AccountInfo customerId;
	
	private int invalidAttempts;
	private LocalDate lastLoginDateTime;
	private String lastLoginIpAddress;

	public UserLoginInfo() {
	}

	public UserLoginInfo(int invalidAttempts, LocalDate lastLoginDateTime, String lastLoginIpAddress) {

		this.invalidAttempts = invalidAttempts;
		this.lastLoginDateTime = lastLoginDateTime;
		this.lastLoginIpAddress = lastLoginIpAddress;
	}

	public AccountInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(AccountInfo customerId) {
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
