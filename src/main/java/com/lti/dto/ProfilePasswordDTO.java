package com.lti.dto;

public class ProfilePasswordDTO {

	int customerId;
	String profilePassword;

	public ProfilePasswordDTO() {
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getProfilePassword() {
		return profilePassword;
	}

	public void setProfilePassword(String profilePassword) {
		this.profilePassword = profilePassword;
	}

}
