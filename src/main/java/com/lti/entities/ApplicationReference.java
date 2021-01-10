package com.lti.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class ApplicationReference {

	@Id
	@SequenceGenerator(name = "referenceId", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referenceId")
	private int refernceId;
	private Status statusId;
	
	@OneToOne
	@JoinColumn
	private CustomerInfo customerId;

	public ApplicationReference() {
	}

	public ApplicationReference(int refernceId, CustomerInfo customerId, Status statusId) {
		this.refernceId = refernceId;
		this.customerId = customerId;
		this.statusId = statusId;
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

	public Status getStatusId() {
		return statusId;
	}

	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}

}
