package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginStatus;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entities.AccountInfo;
import com.lti.entities.UserLoginCredentials;
import com.lti.services.UserLoginService;


@RestController
@CrossOrigin
public class UserLoginController {

	@Autowired
	private UserLoginService service;

	@PostMapping(path = "/userLogin")
	public Status loginInfo(@RequestBody UserLoginCredentials user) {
		LoginStatus a = new LoginStatus();
		try {
			String result = service.loginCustomer(user);
			
			if (result.equals("Login Success")) {
				a.setStatus(StatusType.SUCCESS);
				a.setMessage("Login Success");
				
				AccountInfo details = service.viewAcceptedCustomersById(user);
				a.setCustomerId(details.getCustomerId().getCustomerId());
				a.setAccountNumber(details.getAccountNumber());
				a.setIfsc(details.getIfsc());
				a.setAccountBalance(details.getAccountBalance());
				
			} else if (result.equals("Invalid Id or Password")) {
				a.setStatus(StatusType.FAILURE);
				a.setMessage("Incorrect Id or Password");
			} else if (result.equals("Account Blocked")) {
				a.setStatus(StatusType.FAILURE);
				a.setMessage("Account Blocked");
			} else {
				a.setStatus(StatusType.FAILURE);
				a.setMessage("Customer not present");
			}
			return a;
		} catch (

		Exception e) {
			a.setStatus(StatusType.FAILURE);
			a.setMessage("Something went wrong");
			return a;
		}

	}
}




