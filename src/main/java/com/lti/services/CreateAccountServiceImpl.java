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

			String toEmail = customerInfo.getEmailId();
			String subject = "Account Creation Request";
			String msg = "Hi " + customerInfo.getFirstName() + ",\nCongratulations!!"
					+ "\nYour account opening request is registered successfully.\n"
					+ "Please not down this Reference Id: " + appRef.getRefernceId() + " to check your status.\n"
					+ "Thank You\n" + "Regards\n" + "Bank";
			email.sendEmail(toEmail, subject, msg);
			return appRef.getRefernceId();

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

}
