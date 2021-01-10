package com.lti.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Transaction {

	@SequenceGenerator(name="transactionID",initialValue=10000,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="transactionId")
	@Id
	private int transactionID;
	private long fromAccountNumber;
	private long toAccountNumber;
	private double transactionAmount;
	private String transactionType;
	
	private int transactionModeId;
	
	private LocalDate transactionDateTime;
	private String transactionStatus;
	private double updatedBalance;
	private String remark;

	public Transaction() {
	}

	public Transaction(int transactionID, long fromAccountNumber, long toAccountNumber, double transactionAmount,
			int transactionModeId, String transactionType, LocalDate transactionDateTime, String transactionStatus,
			double updatedBalance, String remark) {
		this.transactionID = transactionID;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.transactionAmount = transactionAmount;
		this.transactionModeId = transactionModeId;
		this.transactionType = transactionType;
		this.transactionDateTime = transactionDateTime;
		this.transactionStatus = transactionStatus;
		this.updatedBalance = updatedBalance;
		this.remark = remark;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public long getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public long getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public int getTransactionModeId() {
		return transactionModeId;
	}

	public void setTransactionModeId(int transactionModeId) {
		this.transactionModeId = transactionModeId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDate transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public double getUpdatedBalance() {
		return updatedBalance;
	}

	public void setUpdatedBalance(double updatedBalance) {
		this.updatedBalance = updatedBalance;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
