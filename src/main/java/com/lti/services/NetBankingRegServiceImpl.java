package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entities.UserLoginCredentials;
import com.lti.repository.NetBankingRegRepo;

@Service
public class NetBankingRegServiceImpl implements NetBankingRegServices {

	@Autowired
	NetBankingRegRepo regRepo;

	@Override
	public String registerUser(UserLoginCredentials userCredentials) {
		if (!regRepo.isInfoPresent(userCredentials)) {
			regRepo.registerUser(userCredentials);
			return "SUCCESS";
		}
		return "ALREADY REGISTERED!";
	}

}
