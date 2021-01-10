package com.lti.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserLoginCredentials implements Serializable {

	@Id
	@OneToOne(targetEntity = AccountInfo.class)
	private AccountInfo customerId;

	private int invalidAttempts;
	private LocalDate lastLoginDateTime;
	private String lastLoginIpAddress;

//	@OneToOne
//	private UserLoginInfo loginInfo;

	public UserLoginCredentials() {
	}

	public UserLoginCredentials(int invalidAttempts, LocalDate lastLoginDateTime, String lastLoginIpAddress) {
		this.invalidAttempts = invalidAttempts;
		this.lastLoginDateTime = lastLoginDateTime;
		this.lastLoginIpAddress = lastLoginIpAddress;
	}

//	public UserLoginInfo getLoginInfo() {
//		return loginInfo;
//	}
//
//	public void setLoginInfo(UserLoginInfo loginInfo) {
//		this.loginInfo = loginInfo;
//	}

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
