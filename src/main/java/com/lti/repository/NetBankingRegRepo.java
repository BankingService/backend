package com.lti.repository;

import com.lti.entities.UserLoginCredentials;

public interface NetBankingRegRepo {

	void registerUser(UserLoginCredentials userCredentials);

	boolean isInfoPresent(UserLoginCredentials userCredentials);

}
