package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ApplicationReference {

	@Id
	@SequenceGenerator(name = "referenceId", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referenceId")
	private int referenceId;
	
	@OneToOne
	private Status statusId;
	
	@OneToOne
	private CustomerInfo customerId;

	public ApplicationReference() {
	}

	public ApplicationReference(int referenceId) {
		this.referenceId = referenceId;
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
