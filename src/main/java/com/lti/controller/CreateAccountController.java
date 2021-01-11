package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entities.CustomerInfo;
import com.lti.services.CreateAccountService;

@RestController
public class CreateAccountController {

	@Autowired
	CreateAccountService service;

	@RequestMapping(value = "/customerInfo/", method = RequestMethod.POST)
	public List<String> customerInfo(@RequestBody CustomerInfo customerInfo) {
//			System.out.println(customerInfo.getCustomerId());
			int refId = service.createAccount(customerInfo);
			List<String> list = new ArrayList<String>();
			list.add("Account Created Successfully");
			list.add("Your Refernce Id: " + refId);
			return list;
	}


}
