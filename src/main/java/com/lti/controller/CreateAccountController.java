package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CreateAccountRequest;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entities.CustomerInfo;
import com.lti.services.CreateAccountService;

@RestController
@CrossOrigin
public class CreateAccountController {
	
	
	@Autowired
	CreateAccountService service;
	

	@RequestMapping(value = "/customerInfo/", method = RequestMethod.POST)
	public  CreateAccountRequest customerInfo(@RequestBody CustomerInfo customerInfo) {
		CreateAccountRequest status = new CreateAccountRequest();
		try {
			customerInfo = service.setDefault(customerInfo);
			int refId = service.createAccount(customerInfo);
			status.setMsg("Account Creation Request Submitted Successfully");
			status.setRefId(refId);
			return status;
		} catch (Exception e) {
			status.setMsg("Account Request Already Exist");
			return status;
		}
			
	}
	
	@GetMapping("/checkStatus/{refId}")
	public Status checkStatus(@PathVariable("refId") int refId) {
		Status status = new Status();
		try {
			String res = service.checkStatus(refId);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Your Account request is: "+ res);
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Account is Active");
			return status;
		}
		
	}


}
