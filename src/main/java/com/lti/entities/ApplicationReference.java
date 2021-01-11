package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


import org.hibernate.annotations.ManyToAny;

@Entity
public class ApplicationReference {
 
	@Id
	@SequenceGenerator(name = "referenceId", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referenceId")
	private int referenceId;
	
	@OneToOne
	@JoinColumn(name = "statusId")
	private Status statusId;
	
	@OneToOne
	@JoinColumn(name = "customerId")
	private CustomerInfo customerId;

	public ApplicationReference() {
	}

	public ApplicationReference(int referenceId) {
		this.referenceId = referenceId;
	}
	public int getRefernceId() {
		return referenceId;

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

	@Override
	public String toString() {
		return "ApplicationReference [referenceId=" + referenceId + ", statusId=" + statusId + ", customerId="
				+ customerId + "]";
	}
	
}
