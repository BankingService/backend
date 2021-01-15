package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.UserCredentialsDTO;
import com.lti.entities.AccountInfo;
import com.lti.entities.CustomerInfo;
import com.lti.entities.UserLoginCredentials;
import com.lti.repository.NetBankingRegRepo;

@Service
public class NetBankingRegServiceImpl implements NetBankingRegServices {

	@Autowired
	private NetBankingRegRepo regRepo;
	
	@Autowired
	private EmailServiceImpl email;

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

	@Override
	public int generateOtp(int custid) {
		int randomPin = (int) (Math.random()*9000)+1000;
		System.out.println(randomPin);
		
		AccountInfo c = regRepo.getAccountInfo(custid);
		
		String toEmail = c.getCustomerId().getEmailId();
		
		String subject = "OTP";
		String msg = "Hi "
				+ c.getCustomerId().getFirstName()
				+", "
				+ "\nYour OTP is : "+randomPin
				+ "\nThank You\n"
				+ "Best Regards,\n"
				+ "Bank";
		email.sendEmail(toEmail, subject, msg);
		
		return randomPin;
	}

}
