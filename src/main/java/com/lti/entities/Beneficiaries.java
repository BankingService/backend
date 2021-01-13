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
public class Beneficiaries implements Serializable {

	@Id
	@SequenceGenerator(name = "beneficiaryId", initialValue = 2001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beneficiaryId")
	private int beneficiaryID;
	private String beneficiaryAccountNumber;
	private String beneficiaryName;
	private String beneficiaryNickName;

	@OneToOne
	@JoinColumn(name = "customerId")
	private AccountInfo customerId;

	private String beneficiaryIfsc;

	public Beneficiaries() {

	}

	public Beneficiaries(int beneficiaryID, String beneficiaryAccountNumber, String beneficiaryName,
			String beneficiaryNickName, AccountInfo customerId, String beneficiaryIfsc) {
		this.beneficiaryID = beneficiaryID;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryNickName = beneficiaryNickName;
		this.customerId = customerId;
		this.beneficiaryIfsc = beneficiaryIfsc;
	}

	public int getBeneficiaryID() {
		return beneficiaryID;
	}

	public void setBeneficiaryID(int beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}

	public String getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBeneficiaryNickName() {
		return beneficiaryNickName;
	}

	public void setBeneficiaryNickName(String beneficiaryNickName) {
		this.beneficiaryNickName = beneficiaryNickName;
	}

	public AccountInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(AccountInfo customerId) {
		this.customerId = customerId;
	}

	public String getBeneficiaryIfsc() {
		return beneficiaryIfsc;
	}

	public void setBeneficiaryIfsc(String beneficiaryIfsc) {
		this.beneficiaryIfsc = beneficiaryIfsc;
	}

}
