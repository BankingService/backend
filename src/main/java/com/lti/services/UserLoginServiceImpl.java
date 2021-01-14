package com.lti.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entities.AccountInfo;
import com.lti.entities.CustomerInfo;
import com.lti.entities.UserLoginCredentials;
import com.lti.repository.UserLoginRepo;


@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginRepo repo;
	
	@Autowired
	private EmailServiceImpl email;

	@Override
	public String loginCustomer(UserLoginCredentials user) {
		int result = repo.findCustomer(user);
		System.out.println(result);
		List<String> res = new ArrayList<>();
		
		if (result == 1) {
			int check = repo.checkCredentials(user);
			System.out.println("check "+check);
			if (check == 1) {
				AccountInfo a = repo.updateLoginInfo(user);
				return "Login Success";
			} 
			else {
				String s = repo.updateLoginInfoInvalidAttempts(user);
				System.out.println(s);
				if (s.equals("Account Blocked")) {
					
					CustomerInfo c = repo.getCustomerDetails(user);
					AccountInfo a = repo.getAccountDetails(user);
					
					String toEmail = c.getEmailId();
					
					String subject = "Account Blocked";
					String msg = "Hi "
							+ c.getFirstName()
							+ ",\nWe are sorry to inform you that your account - has been block due to security breach.\n"
							+ "\nYou have exceeded the invalid login limit\n"
							+ "\nYour account will be reactivated within 24 hrs\n"
							+ "\n Following are the account details : \n" 
							+ "User Id : "+c.getCustomerId()+"\n"
							+ "Account Number : "+a.getAccountNumber()+"\n"
							+ "Best Regards,\n"
							+ "Bank";
					email.sendEmail(toEmail, subject, msg);
					
					return "Account Blocked";
				}
				return "Invalid Id or Password";
			}
		}
		return "Customer not present";
	}

	@Override
	public AccountInfo viewAcceptedCustomersById(UserLoginCredentials user) {
		AccountInfo a = repo.getAccountDetails(user);
		return a;
	}

	@Override
	public int forgotPassword(int custid) {
		int randomPin = (int) (Math.random()*9000)+1000;
		System.out.println(randomPin);
		
		CustomerInfo c = repo.getCustomerInfo(custid);
		
		String toEmail = c.getEmailId();
		
		String subject = "OTP";
		String msg = "Hi "
				+ c.getFirstName()
				+", "
				+ "\nYour OTP is : "+randomPin
				+ "\nThank You\n"
				+ "Best Regards,\n"
				+ "Bank";
		email.sendEmail(toEmail, subject, msg);
		
		return randomPin;
	}

	@Override
	public int forgotUserId(String accNo) {
		int randomPin = (int) (Math.random()*9000)+1000;
		System.out.println(randomPin);
		
		CustomerInfo c = repo.getCustomerInfo(accNo);
		
		String toEmail = c.getEmailId();
		
		String subject = "OTP";
		String msg = "Hi "
				+ c.getFirstName()
				+", "
				+ "\nYour OTP is : "+randomPin
				+ "\nThank You\n"
				+ "Best Regards,\n"
				+ "Bank";
		email.sendEmail(toEmail, subject, msg);
		
		return randomPin;
	}

	@Override
	public void setNewPassword(int custid, String loginPassword, String transactionPassword) {
		repo.updateUserLoginCredentials(custid,loginPassword,transactionPassword);
	}

	@Override
	public void generateMail(int custid) {
		CustomerInfo c = repo.getCustomerInfo(custid);
		
		String toEmail = c.getEmailId();
		
		String subject = "Customer ID";
		String msg = "Hi "
				+ c.getFirstName()
				+", "
				+ "\nThe OTP is succesfully verified.\n"
				+ "\nYour Customer ID is : "+c.getCustomerId()
				+ "\nThank You\n"
				+ "Best Regards,\n"
				+ "Bank";
		email.sendEmail(toEmail, subject, msg);
		
	}

}
