package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.UserCredentialsDTO;
import com.lti.entities.AccountInfo;
import com.lti.entities.UserLoginCredentials;
import com.lti.repository.NetBankingRegRepo;

@Service
public class NetBankingRegServiceImpl implements NetBankingRegServices {

	@Autowired
	NetBankingRegRepo regRepo;

	@Override
	public String registerUser(UserCredentialsDTO registration) {
		AccountInfo ai = regRepo.getAccountInfo(registration.getCustomerId());
		UserLoginCredentials user = new UserLoginCredentials();
		user.setCustomerId(ai);
		user.setLoginPassword(registration.getLoginPassword());
		user.setProfilePassword(registration.getProfilePassword());
		user.setTransactionPassword(registration.getTransactionPassword());

		if (!regRepo.isInfoPresent(user)) {
			regRepo.registerUser(user);
			return "SUCCESS";
		}
		return "ALREADY REGISTERED!";
	}

}
