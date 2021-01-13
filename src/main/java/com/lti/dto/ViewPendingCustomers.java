package com.lti.dto;

public class ViewPendingCustomers {

	private int referenceId;
	private int customerId;
	
	public ViewPendingCustomers() {
		// TODO Auto-generated constructor stub
	}

	public int getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "ViewPendingCustomers [referenceId=" + referenceId + ", customerId=" + customerId + "]";
	}
	
}
