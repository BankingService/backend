package com.lti.services;

import com.lti.dto.UserCredentialsDTO;
import com.lti.entities.AccountInfo;
import com.lti.entities.CustomerInfo;
import com.lti.entities.UserLoginCredentials;
import com.lti.entities.UserLoginInfo;

public interface UserLoginService {

	String loginCustomer(UserLoginCredentials user);

	AccountInfo viewAcceptedCustomersById(UserLoginCredentials user);

	int forgotPassword(int custid);

	int forgotUserId(String accNo);

	void setNewPassword(int custid, String loginPassword, String transactionPassword);

	void generateMail(String accNo);

	CustomerInfo getCustomerDetails(int custid);

	CustomerInfo editCustomerDetails(CustomerInfo custInfo);

	int verifyProfilePassword(int custid, String profilePassword);

	UserLoginInfo getLogoutDetails(int custid);

	UserLoginCredentials findUser(UserCredentialsDTO userCredentials);

}
