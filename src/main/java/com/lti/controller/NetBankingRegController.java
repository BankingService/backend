package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entities.UserLoginCredentials;
import com.lti.services.NetBankingRegServices;

@RestController
class NetBankingRegController {

	@Autowired
	NetBankingRegServices service;

	@PostMapping(path = "/register/")
	public String register(@RequestBody UserLoginCredentials userCredentials) {
		try {
			System.out.println(userCredentials.getCustomerId().getAccountNumber());
			String res = service.registerUser(userCredentials);
			return res;
			
		} catch (Exception e) {
			return "FAILED";
		}

	}
}
