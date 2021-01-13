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
public class AccountInfo implements Serializable {
	 
	@Id
	@OneToOne
	@JoinColumn(name = "customerId")
	private CustomerInfo customerId;

//	@Id
//	@Column(name="accountNumber", columnDefinition = " NUMBER(19,0) DEFAULT ON NULL sensor_seq.nextval", insertable = false)
//	@org.hibernate.annotations.Generated(GenerationTime.INSERT)
//	@SequenceGenerator(name = "customerDocId", initialValue = 2001, allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerDocId")
	private long accountNumber;

	private String ifsc;
	private double accountBalance;
	
	public AccountInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerInfo customerId) {
		this.customerId = customerId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public AccountInfo(CustomerInfo customerId, long accountNumber, String ifsc, double accountBalance) {
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.ifsc = ifsc;
		this.accountBalance = accountBalance;
	}
	
//	@OneToOne
//	private Beneficiaries beneficiary;

	
	

}
