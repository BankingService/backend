package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLoginInfo {

	@Id
	private int customerId;
	private String loginPassword;
	private String profilePassword;
	private String transactionPassword;

	public UserLoginInfo() {
	}

	public UserLoginInfo(int customerId, String loginPassword, String profilePassword, String transactionPassword) {
		this.customerId = customerId;
		this.loginPassword = loginPassword;
		this.profilePassword = profilePassword;
		this.transactionPassword = transactionPassword;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
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
