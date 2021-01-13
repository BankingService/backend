package com.lti.repository;

import com.lti.entities.AccountInfo;
import com.lti.entities.CustomerInfo;
import com.lti.entities.UserLoginCredentials;

public interface UserLoginRepo {

	int findCustomer(UserLoginCredentials user);

	int checkCredentials(UserLoginCredentials user);

	AccountInfo updateLoginInfo(UserLoginCredentials user);

	String updateLoginInfoInvalidAttempts(UserLoginCredentials user);

	CustomerInfo getCustomerDetails(UserLoginCredentials user);

	AccountInfo getAccountDetails(UserLoginCredentials user);

	

}
