package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Beneficiaries {

	@Id
	@SequenceGenerator(name="beneficiaryId",initialValue=2001,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="beneficiaryId")
	private Long beneficiaryID;
	private Long beneficiaryAccountNumber;
	private String beneficiaryName;
	private String beneficiaryNickName;
	private AccountInfo customerId;
	private String beneficiaryIfsc;

	public Beneficiaries(Long beneficiaryID, Long beneficiaryAccountNumber, String beneficiaryName,
			String beneficiaryNickName, AccountInfo customerId, String beneficiaryIFSC) {
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

	public AccountInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(AccountInfo customerId) {
		this.customerId = customerId;
	}

	public String getBeneficiaryIFSC() {
		return beneficiaryIfsc;
	}

	public void setBeneficiaryIFSC(String beneficiaryIFSC) {
		this.beneficiaryIfsc = beneficiaryIFSC;
	}

}
