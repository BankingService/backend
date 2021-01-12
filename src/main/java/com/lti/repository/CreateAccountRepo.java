package com.lti.repository;

import com.lti.entities.ApplicationReference;
import com.lti.entities.CustomerInfo;
import com.lti.entities.Status;

public interface CreateAccountRepo {

	public void createAccount(CustomerInfo customerInfo);

	public CustomerInfo updateAccount(CustomerInfo customerInfo, int id);

	public void insertAppRef(ApplicationReference appRef);

	public void deleteAppRef(CustomerInfo customerInfo);

	public int findCustomerId();

	public String checkStatus(int refId);

}
