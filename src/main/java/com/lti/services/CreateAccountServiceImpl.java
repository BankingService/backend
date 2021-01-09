package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entities.CustomerInfo;
import com.lti.repository.CreateAccountRepo;

@Service
public class CreateAccountServiceImpl implements CreateAccountService {

	@Autowired
	CreateAccountRepo createAccount;
	
	@Override
	public void createAccount(CustomerInfo customerInfo) {
		createAccount.createAccount(customerInfo);

	}

}