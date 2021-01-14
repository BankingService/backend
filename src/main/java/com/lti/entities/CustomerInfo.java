package com.lti.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class CustomerInfo implements Serializable {
 
	@Id
	@SequenceGenerator(name = "customerId", initialValue = 11111111, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerId")
	private int customerId;

	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fatherName;
	private long mobileNumber;
	private String emailId;
	private long aadharCardNo;
	private LocalDate dateOfBirth;
	private String occupationType;
	private String sourceOfIncome;
	private long grossAnnualIncome;
	private String panNumber;

//	@Value("2021")
	@OneToOne
//	@JoinColumn(name = "adminId")
	private AdminInfo approvedBy;

	@Value("1")
	@OneToOne
//	@JoinColumn(name = "statusId")
	private Status statusId;

//	@OneToOne
//	@JoinColumn(name = "addressId")
	private CustomerAddress address;

//	@OneToOne(mappedBy = "customerId")
//	@JoinColumn(name = "customerDocId")
	private CustomerDocs customerDoc;

//	@OneToOne(mappedBy = "customerId")
//	@JoinColumn(name = "accountNumber")
//	private AccountInfo account;
	

//	@OneToOne
//	private ApplicationReference appReference;

	public CustomerInfo() {
	}

	public CustomerInfo(String title, String firstName, String middleName, String lastName,
			String fatherName, long mobileNumber, String emailId, long aadharCardNo, LocalDate dateOfBirth,
			String occupationType, String sourceOfIncome, long grossAnnualIncome, String panNumber, AdminInfo approvedBy,
			CustomerAddress address, CustomerDocs customerDoc, Status statusId) {
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
		this.address = address;
		this.customerDoc = customerDoc;
		this.statusId = statusId;
	}

//	public ApplicationReference getAppReference() {
//		return appReference;
//	}
//
//	public void setAppReference(ApplicationReference appReference) {
//		this.appReference = appReference;
//	}
//
//	public AccountInfo getAccount() {
//		return account;
//	}
//
//	public void setAccount(AccountInfo account) {
//		this.account = account;
//	}

	public CustomerDocs getCustomerDoc() {
		return customerDoc;
	}

	public void setCustomerDoc(CustomerDocs customerDoc) {
		this.customerDoc = customerDoc;
	}

	public CustomerAddress getAddress() {
		return address;
	}

	public void setAddress(CustomerAddress address) {
		this.address = address;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
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

	public AdminInfo getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(AdminInfo approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Status getStatusId() {
		return statusId;
	}

	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "CustomerInfo [customerId=" + customerId + ", title=" + title + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", fatherName=" + fatherName
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", aadharCardNo=" + aadharCardNo
				+ ", dateOfBirth=" + dateOfBirth + ", occupationType=" + occupationType + ", sourceOfIncome="
				+ sourceOfIncome + ", grossAnnualIncome=" + grossAnnualIncome + ", panNumber=" + panNumber
				+ ", approvedBy=" + approvedBy + ", statusId=" + statusId + ", address=" + address + ", customerDoc="
				+ customerDoc + "]";
	}
	

}