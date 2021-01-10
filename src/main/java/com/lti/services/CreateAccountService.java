package com.lti.services;

import com.lti.entities.CustomerAddress;
import com.lti.entities.CustomerInfo;

public interface CreateAccountService {
  
	public void createAccount(CustomerInfo customerInfo);
	public void createAccountAdd(CustomerAddress customerAddress);
	
}
