package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class CustomerDocs {

	@Id
	@SequenceGenerator(name = "customerDocId", initialValue = 2001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerDocId")
	private int customerDocId;

	@OneToOne(mappedBy = "customerDoc")
	private CustomerInfo customerId;

	private String aadharCard;
	private String panCard;

	public CustomerDocs() {

	}

	public CustomerDocs(String aadharCard, String panCard) {
		this.aadharCard = aadharCard;
		this.panCard = panCard;
	}

	public int getCustomerDocId() {
		return customerDocId;
	}

	public void setCustomerDocId(int customerDocId) {
		this.customerDocId = customerDocId;
	}

	public CustomerInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerInfo customerId) {
		this.customerId = customerId;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	@Override
	public String toString() {
		return "CustomerDocs [customerId=" + customerId + ", aadharCard=" + aadharCard + ", panCard=" + panCard + "]";
	}

}
