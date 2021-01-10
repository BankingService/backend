package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountInfo {

	@Id
	private int customerId;
	private Long accountNumber;
	private String ifsc;
	private Double accountBalance;

	public AccountInfo(int customerId, Long accountNumber, String ifsc, Double accountBalance) {
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.ifsc = ifsc;
		this.accountBalance = accountBalance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
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
