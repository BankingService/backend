package com.lti.repository;

import com.lti.entities.CustomerAddress;
import com.lti.entities.CustomerInfo;

public interface CreateAccountRepo {
	
	public void createAccount(CustomerInfo customerInfo);
	public void createAccountAdd(CustomerAddress customerAddress);

}
