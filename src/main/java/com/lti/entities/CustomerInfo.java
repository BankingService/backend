package com.lti.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class CustomerInfo {

	@Id
	private int customerId;
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fatherName;
	private long mobileNumber;
	private String emailId;
	private long aadharCardNo;
	private Date dateOfBirth;
	private String occupationType;
	private String sourceOfIncome;
	private long grossAnnualIncome;
	private String panNumber;

	@Value("0000")
	private int approvedBy;

	@Value("Pending")
	private String status;

	public CustomerInfo() {
	}

	public CustomerInfo(int customerId, String title, String firstName, String middleName, String lastName,
			String fatherName, long mobileNumber, String emailId, long aadharCardNo, Date dateOfBirth,
			String occupationType, String sourceOfIncome, long grossAnnualIncome, String panNumber, int approvedBy,
			String status) {
		this.customerId = customerId;
		this.title = title;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.aadharCardNo = aadharCardNo;
		this.dateOfBirth = dateOfBirth;
		this.occupationType = occupationType;
		this.sourceOfIncome = sourceOfIncome;
		this.grossAnnualIncome = grossAnnualIncome;
		this.panNumber = panNumber;
		this.approvedBy = approvedBy;
		this.status = status;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getAadharCardNo() {
		return aadharCardNo;
	}

	public void setAadharCardNo(long aadharCardNo) {
		this.aadharCardNo = aadharCardNo;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public String getSourceOfIncome() {
		return sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		this.sourceOfIncome = sourceOfIncome;
	}

	public long getGrossAnnualIncome() {
		return grossAnnualIncome;
	}

	public void setGrossAnnualIncome(long grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public int getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}