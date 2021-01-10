package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entities.AdminInfo;
import com.lti.entities.CustomerAddress;
import com.lti.entities.CustomerInfo;
import com.lti.services.CreateAccountService;

@RestController
public class CreateAccountController {

	@Autowired
	CreateAccountService service;

	@RequestMapping(value = "/customerInfo/", method = RequestMethod.POST)
	public void customerInfo(@RequestParam("title") String title, @RequestParam("firstName") String name, @RequestParam("approvedBy") String aby ) {
//	public void customerInfo(@RequestBody CustomerInfo customerInfo) {
		
		System.out.println("Ab to chal jaa "+Integer.parseInt(aby));
			CustomerInfo customerInfo = new CustomerInfo();
			
			customerInfo.setTitle(title);
			customerInfo.setFirstName(name);
			customerInfo.setApprovedBy(service.adminInfo(Integer.parseInt(aby)));
			service.createAccount(customerInfo);
//
//		
	}

	@RequestMapping(value = "/customerAddress", method = RequestMethod.POST)
	public void customerAddress(@RequestBody CustomerAddress customerAddress) {
		try {
			service.createAccountAdd(customerAddress);
		} catch (Exception e) {

		}
	}

}
