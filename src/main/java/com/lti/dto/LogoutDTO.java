package com.lti.dto;

public class LogoutDTO extends Status {

	private String lastLoginDateTime;
	private String lastLoginIpAddress;

	public LogoutDTO() {
	}

	public String getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	public void setLastLoginDateTime(String lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}

	public String getLastLoginIpAddress() {
		return lastLoginIpAddress;
	}

	public void setLastLoginIpAddress(String lastLoginIpAddress) {
		this.lastLoginIpAddress = lastLoginIpAddress;
	}

}
