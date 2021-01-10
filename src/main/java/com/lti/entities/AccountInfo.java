package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class AccountInfo {

	@Id
	@SequenceGenerator(name = "accountNumber", initialValue = 274527368, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountNumber")
	private Long accountNumber;

	@OneToOne
	private CustomerInfo customerId;

	private String ifsc;
	private Double accountBalance;

	public AccountInfo() {
	}
	
	public AccountInfo(String ifsc, Double accountBalance) {
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
