package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Status {
 
	@Id
	private int statusId;
	
	private String statusMessage;
	
	@OneToOne
	private ApplicationReference appRefernce;

	

	public Status() {
	}

	public Status(int statusId, String statusMessage) {
		this.statusId = statusId;
		this.statusMessage = statusMessage;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	public ApplicationReference getAppRefernce() {
		return appRefernce;
	}

	public void setAppRefernce(ApplicationReference appRefernce) {
		this.appRefernce = appRefernce;
	}

}
