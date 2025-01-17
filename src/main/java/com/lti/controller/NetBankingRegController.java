package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.UserCredentialsDTO;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entities.AccountInfo;
import com.lti.entities.UserLoginCredentials;
import com.lti.services.NetBankingRegServices;

@RestController
@CrossOrigin
class NetBankingRegController {

	@Autowired
	NetBankingRegServices service;

	@PostMapping(path = "/register/")
	public Status register(@RequestBody UserCredentialsDTO registration) {
		Status status = new Status();
		try {
//			System.out.println(userCredentials.getCustomerId().getAccountNumber());
			String res = service.registerUser(registration);
			if(res.equals("SUCCESS")) {
				status.setStatus(StatusType.SUCCESS);
				status.setMessage("Net Banking registration successful");
				return status;
			}else {
				status.setStatus(StatusType.FAILURE);
				status.setMessage("User Already Registered");
				return status;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Something went wrong");
			return status;
		}

	}
	
	@GetMapping(path = "/getRegistrationOtp/{custid}")
	public Status generateOtp(@PathVariable("custid") int custid) {

		Status status = new Status();
		try {
			int otp = service.generateOtp(custid);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage(String.valueOf(otp));
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Invalid Customer ID");
			return status;
		}

	}
}
