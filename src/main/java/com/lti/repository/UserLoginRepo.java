package com.lti.repository;

import com.lti.entities.AccountInfo;
import com.lti.entities.CustomerInfo;
import com.lti.entities.UserLoginCredentials;
import com.lti.entities.UserLoginInfo;

public interface UserLoginRepo {

	int findCustomer(UserLoginCredentials user);

	int checkCredentials(UserLoginCredentials user);

	AccountInfo updateLoginInfo(UserLoginCredentials user);

	String updateLoginInfoInvalidAttempts(UserLoginCredentials user);

	CustomerInfo getCustomerDetails(UserLoginCredentials user);

	AccountInfo getAccountDetails(UserLoginCredentials user);

	CustomerInfo getCustomerInfo(int custid);

	CustomerInfo getCustomerInfo(String accNo);

	void updateUserLoginCredentials(int custid, String loginPassword, String transactionPassword);

	int verifyCustomerId(int custid);

	int verifyAccountNumber(String accNo);

	CustomerInfo editCustomerInfo(CustomerInfo custInfo);

	int verifyProfilePassword(int custid, String profilePassword);

	UserLoginInfo getLogoutDetails(int custid);

	AccountInfo getAccount(int customerId);

	UserLoginCredentials getCredentials(AccountInfo ai);

	String getUserAttempt(UserLoginCredentials user);

}
