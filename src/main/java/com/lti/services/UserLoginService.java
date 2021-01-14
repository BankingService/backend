package com.lti.services;

import com.lti.entities.AccountInfo;
import com.lti.entities.UserLoginCredentials;

public interface UserLoginService {

	String loginCustomer(UserLoginCredentials user);

	AccountInfo viewAcceptedCustomersById(UserLoginCredentials user);

	int forgotPassword(int custid);

	int forgotUserId(String accNo);

	void setNewPassword(int custid, String loginPassword, String transactionPassword);

	void generateMail(int custid);
	

}
