package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entities.AdminInfo;
import com.lti.entities.ApplicationReference;
import com.lti.entities.CustomerAddress;
import com.lti.entities.CustomerInfo;
import com.lti.repository.CreateAccountRepo;

@Service
public class CreateAccountServiceImpl implements CreateAccountService {

	@Autowired
	CreateAccountRepo createAccount;

	@Autowired
	EmailServiceImpl email;

	@Override
	public int createAccount(CustomerInfo customerInfo) {
		try {
			if (createAccount.findCustomerId() != 1) {
				customerInfo = createAccount.updateAccount(customerInfo, createAccount.findCustomerId());
//				System.out.println(customerInfo.getCustomerId());
				createAccount.deleteAppRef(customerInfo);

			} else {
				createAccount.createAccount(customerInfo);
//				System.out.println(customerInfo.getCustomerId());
//				 System.out.println(customerInfo.getStatusId().getStatusMessage());

			}

			ApplicationReference appRef = new ApplicationReference();
			appRef.setCustomerId(customerInfo);
			appRef.setStatusId(customerInfo.getStatusId());
			createAccount.insertAppRef(appRef);
			return customerInfo.getCustomerId();

		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public String checkStatus(int refId) {
		String res = createAccount.checkStatus(refId);
		return res;
	}

	@Override
	public CustomerInfo setDefault(CustomerInfo customerInfo) {
		return createAccount.setDefaults(customerInfo);
	}

	@Override
	public int generateOtp(String emailId) {

		int randomPin = (int) (Math.random()*9000)+1000;
		
		String toEmail = emailId;
		
		String subject = "OTP";
		String msg = "Hi, "
				+ "\nYour OTP is : "+randomPin
				+ "\nThank You\n"
				+ "Best Regards,\n"
				+ "365 Bank";
		email.sendEmail(toEmail, subject, msg);
		
		return randomPin;
	}

}
