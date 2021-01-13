package com.lti.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class UserTransaction {

	@Id
	@SequenceGenerator(name = "id", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	private int id;

	private int transactionID;

	private String fromAccountNumber;
	private String toAccountNumber;
	private double transactionAmount;

	@OneToOne(targetEntity = TransactionMode.class)
	@JoinColumn(name = "transactionModeId")
	private TransactionMode transactionModeId;
	private String transactionType;
	private LocalDateTime transactionDateTime;
	private float updatedBalance;
	private String remark;

	public UserTransaction() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public TransactionMode getTransactionModeId() {
		return transactionModeId;
	}

	public void setTransactionModeId(TransactionMode transactionModeId) {
		this.transactionModeId = transactionModeId;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

//	public String getTransactionStatus() {
//		return transactionStatus;
//	}
//
//	public void setTransactionStatus(String transactionStatus) {
//		this.transactionStatus = transactionStatus;
//	}

	public float getUpdatedBalance() {
		return updatedBalance;
	}

	public void setUpdatedBalance(float updatedBalance) {
		this.updatedBalance = updatedBalance;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "UserTransaction [id=" + id + ", transactionID=" + transactionID + ", fromAccountNumber="
				+ fromAccountNumber + ", toAccountNumber=" + toAccountNumber + ", transactionAmount="
				+ transactionAmount + ", transactionModeId=" + transactionModeId + ", transactionType="
				+ transactionType + ", transactionDateTime=" + transactionDateTime + ", updatedBalance="
				+ updatedBalance + ", remark=" + remark + "]";
	}

}
