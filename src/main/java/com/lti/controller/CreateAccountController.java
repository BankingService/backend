package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CreateAccount;
import com.lti.dto.CreateAccountRequest;
import com.lti.dto.ImageDto;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entities.CustomerDocs;
import com.lti.entities.CustomerInfo;
import com.lti.services.CreateAccountService;
import com.lti.services.ImageService;

@RestController
@CrossOrigin
public class CreateAccountController {
	
	
	@Autowired
	CreateAccountService service;
	
	@Autowired
	ImageService imgService;
	

	@PostMapping(path = "/createAccount")
	public  CreateAccountRequest customerInfo(@RequestBody CustomerInfo customerInfo) {
		CreateAccountRequest status = new CreateAccountRequest();
		try {
			
//			List<String> fileName = imgService.imageUpload(createAccount.getImages());
//			CustomerInfo customerInfo = createAccount.getCustomerInfo();
//			CustomerDocs docs = new CustomerDocs();
//			docs.setAadharCard(fileName.get(0));
//			docs.setPanCard(fileName.get(1));
//			customerInfo.setCustomerDoc(docs);
			customerInfo = service.setDefault(customerInfo);
			int customerId = service.createAccount(customerInfo);
			status.setMsg("Account Creation Request Submitted Successfully");
			status.setId(customerId);
			return status;
		} catch (Exception e) {
			e.printStackTrace();
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
			status.setMessage("INVALID REFERENCE ID");
			return status;
		}
		
	}
	
	
	@PostMapping(path = "createAccount/docs/")
	public Status setDocs(ImageDto images) {
		Status status = new Status();
		try {
			int refId = imgService.imageUpload(images);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("RefId : "+ refId);
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Request Failed");
			return status;
		}	
		
	}
	
	@GetMapping(path = "/verifyEmailOtp/{emailId}")
	public Status generateOtp(@PathVariable("emailId") String emailId) {

		Status status = new Status();
		try {
			int otp = service.generateOtp(emailId);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage(String.valueOf(otp));
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("User Not Registered");
			return status;
		}

	}
}
