package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TransactionMode {
 
	@Id
	private int transactionModeId;

//	@OneToOne(mappedBy = "transactionModeId")
//	private UserTransaction transactionId;

	private String transactionMode;
	private int transactionFee;

	public TransactionMode() {
	}

	public TransactionMode(int transactionModeId, String transactionMode, int transactionFee) {
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

	public int getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(int transactionFee) {
		this.transactionFee = transactionFee;
	}

}
