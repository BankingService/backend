package com.lti.services;

import com.lti.entities.AccountInfo;
import com.lti.entities.UserLoginCredentials;

public interface UserLoginService {

	String loginCustomer(UserLoginCredentials user);

	AccountInfo viewAcceptedCustomersById(UserLoginCredentials user);
	

}
