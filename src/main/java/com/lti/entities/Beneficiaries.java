package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Beneficiaries {

	@Id
	private Long beneficiaryID;
	private Long beneficiaryAccountNumber;
	private String beneficiaryName;
	private String beneficiaryNickName;
	private int customerId;
	private String beneficiaryIfsc;

	public Beneficiaries(Long beneficiaryID, Long beneficiaryAccountNumber, String beneficiaryName,
			String beneficiaryNickName, int customerId, String beneficiaryIFSC) {
		this.beneficiaryID = beneficiaryID;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryNickName = beneficiaryNickName;
		this.customerId = customerId;
		this.beneficiaryIfsc = beneficiaryIFSC;
	}

	public Long getBeneficiaryID() {
		return beneficiaryID;
	}

	public void setBeneficiaryID(Long beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}

	public Long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(Long beneficiaryAccountNumber) {
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getBeneficiaryIFSC() {
		return beneficiaryIfsc;
	}

	public void setBeneficiaryIFSC(String beneficiaryIFSC) {
		this.beneficiaryIfsc = beneficiaryIFSC;
	}

}
