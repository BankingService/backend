package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class CustomerDocs {

	private CustomerInfo customerId;
	private MultipartFile aadharCard;
	private MultipartFile panCard;

	public CustomerDocs() {

	}

	public CustomerDocs(CustomerInfo customerId, MultipartFile aadharCard, MultipartFile panCard) {
		super();
		this.customerId = customerId;
		this.aadharCard = aadharCard;
		this.panCard = panCard;
	}

	public CustomerInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerInfo customerId) {
		this.customerId = customerId;
	}

	public MultipartFile getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(MultipartFile aadharCard) {
		this.aadharCard = aadharCard;
	}

	public MultipartFile getPanCard() {
		return panCard;
	}

	public void setPanCard(MultipartFile panCard) {
		this.panCard = panCard;
	}

	@Override
	public String toString() {
		return "CustomerDocs [customerId=" + customerId + ", aadharCard=" + aadharCard + ", panCard=" + panCard + "]";
	}

}
