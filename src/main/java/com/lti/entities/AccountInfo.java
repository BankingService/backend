package com.lti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class AccountInfo implements Serializable{

	@Id()
	@OneToOne
	@JoinColumn(name = "customerId")
	private CustomerInfo customerId;
	
	@SequenceGenerator(name = "accountNumber", initialValue = 274527368, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountNumber")
	private Long accountNumber;


	private String ifsc;
	private Double accountBalance;

	public AccountInfo() {
	
	}
	
	public AccountInfo(Long accountNumber, String ifsc, Double accountBalance) {
		this.accountNumber = accountNumber;
		this.ifsc = ifsc;
		this.accountBalance = accountBalance;
	}
	
	public CustomerInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerInfo customerId) {
		this.customerId = customerId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

}
