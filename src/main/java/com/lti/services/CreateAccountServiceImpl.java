package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entities.AdminInfo;
import com.lti.entities.CustomerAddress;
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

	@Override 
	public void createAccountAdd(CustomerAddress customerAddress) {
		createAccount.createAccountAdd(customerAddress);
		
	}

	@Override
	public AdminInfo adminInfo(int id) {
		AdminInfo admin = createAccount.getAdminInfo(id);
		return admin;
	}

}
