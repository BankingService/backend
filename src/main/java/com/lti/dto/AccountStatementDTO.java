package com.lti.dto;

import java.time.LocalDateTime;

public class AccountStatementDTO {
	private LocalDateTime date;
	private int transactionId;
	private String message;
	private String transactionType;
	private double transactionAmount;
	private float updatedBalance;

	public AccountStatementDTO() {
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime localDateTime) {
		this.date = localDateTime;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public float getUpdatedBalance() {
		return updatedBalance;
	}

	public void setUpdatedBalance(float updatedBalance) {
		this.updatedBalance = updatedBalance;
	}

}
