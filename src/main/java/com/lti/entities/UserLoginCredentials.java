package com.lti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity

public class UserLoginCredentials implements Serializable {
 
	@Id
	@OneToOne(targetEntity = AccountInfo.class)
	@JoinColumn(name = "customerId")
	private AccountInfo customerId;

	private String loginPassword;
	private String profilePassword;
	private String transactionPassword;

	public UserLoginCredentials() {
	}

	public UserLoginCredentials(String loginPassword, String profilePassword, String transactionPassword) {
		this.loginPassword = loginPassword;
		this.profilePassword = profilePassword;
		this.transactionPassword = transactionPassword;

	}

	

	public AccountInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(AccountInfo customerId) {
		this.customerId = customerId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getProfilePassword() {
		return profilePassword;
	}

	public void setProfilePassword(String profilePassword) {
		this.profilePassword = profilePassword;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}
}