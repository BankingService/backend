package com.lti.dto;

public class Status {

	public static enum StatusType {
		SUCCESS, FAILURE;
	}

	private StatusType status;
	private String message;

	public Status() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

}
