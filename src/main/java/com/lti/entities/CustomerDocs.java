package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class CustomerDocs {

	@Id
	@SequenceGenerator(name="customerDocId",initialValue=2001,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customerDocId")
	private int customerDocId;
	
	@OneToOne
	@JoinColumn
	private CustomerInfo customerId;
	
	private MultipartFile aadharCard;
	private MultipartFile panCard;

	public CustomerDocs() {

	}

	public CustomerDocs(CustomerInfo customerId, MultipartFile aadharCard, MultipartFile panCard) {
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
