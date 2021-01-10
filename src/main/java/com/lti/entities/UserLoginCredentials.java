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
	private UserLoginInfo Id;

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

	public UserLoginInfo getId() {
		return Id;
	}

	public void setId(UserLoginInfo id) {
		Id = id;
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
