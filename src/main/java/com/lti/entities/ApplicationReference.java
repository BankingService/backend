package com.lti.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class ApplicationReference {

	@Id
	@SequenceGenerator(name = "referenceId", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referenceId")
	private int refernceId;
	private String status;
	
	
	private CustomerInfo customerId;

	public ApplicationReference() {
	}

	public ApplicationReference(int refernceId, CustomerInfo customerId, String status) {
		this.refernceId = refernceId;
		this.customerId = customerId;
		this.status = status;
	}

	public int getRefernceId() {
		return refernceId;
	}

	public void setRefernceId(int refernceId) {
		this.refernceId = refernceId;
	}

	public CustomerInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerInfo customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
