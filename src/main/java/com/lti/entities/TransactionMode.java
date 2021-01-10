package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransactionMode {

	@Id
	private int transactionModeId;
	private String transactionMode;
	private float transactionFee;

	public TransactionMode() {
	}

	public TransactionMode(int transactionModeId, String transactionMode, float transactionFee) {
		this.transactionModeId = transactionModeId;
		this.transactionMode = transactionMode;
		this.transactionFee = transactionFee;
	}

	public int getTransactionModeId() {
		return transactionModeId;
	}

	public void setTransactionModeId(int transactionModeId) {
		this.transactionModeId = transactionModeId;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public float getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(float transactionFee) {
		this.transactionFee = transactionFee;
	}

}
