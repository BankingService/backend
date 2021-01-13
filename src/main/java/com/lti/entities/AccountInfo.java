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
	private String accountNumber;

	private String ifsc;
	private float accountBalance;

	public AccountInfo() {
		
	}

	public CustomerInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerInfo customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

}
