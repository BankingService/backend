package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entities.CustomerAddress;
import com.lti.entities.CustomerInfo;
import com.lti.services.CreateAccountService;

@RestController
public class CreateAccountController {

	@Autowired
	CreateAccountService service;

	@RequestMapping(value = "/customerInfo", method = RequestMethod.POST)
	public void customerInfo(@RequestBody CustomerInfo customerInfo) {
		try {
			service.createAccount(customerInfo);

		} catch (Exception e) {

		}
	}

	@RequestMapping(value = "/customerAddress", method = RequestMethod.POST)
	public void customerAddress(@RequestBody CustomerAddress customerAddress) {
		try {
			service.createAccountAdd(customerAddress);
		} catch (Exception e) {

		}
	}

}
