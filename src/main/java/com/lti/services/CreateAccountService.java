package com.lti.services;

import com.lti.entities.CustomerInfo;

public interface CreateAccountService {
  
	public int createAccount(CustomerInfo customerInfo);

	public String checkStatus(int refId);

	
}
 