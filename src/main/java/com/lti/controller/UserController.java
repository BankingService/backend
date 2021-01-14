package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginStatus;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entities.AccountInfo;
import com.lti.entities.CustomerInfo;
import com.lti.entities.UserLoginCredentials;
import com.lti.services.UserLoginService;


@RestController
@CrossOrigin
public class UserController {

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
		} catch (Exception e) {
			a.setStatus(StatusType.FAILURE);
			a.setMessage("Something went wrong");
			return a;
		}

	}
	
	@GetMapping(path="/forgotpassword/{custid}")
	public Status forgotPassword(@PathVariable("custid") int custid) {
		
		Status status = new Status();
		try {
		int otp = service.forgotPassword(custid);
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("The otp is : "+otp);
		return status;
		}catch(Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("User Not Registered");
			return status;
	}
		
	}
	
	@GetMapping(path="/forgotuserid/{accno}")
	public Status generateOtp(@PathVariable("accno") String accNo) {
		Status status = new Status();
		try {
		int otp = service.forgotUserId(accNo);
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("The otp is : "+otp);
		return status;
		}catch(Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Invalid Account Number");
			return status;
		}
	}
	
	@GetMapping(path="/setnewpassword/{custid}/{loginPassword}/{transactionPassword}")
	public Status setNewPassword(@PathVariable("custid") int custid, @PathVariable("loginPassword") String loginPassword, 
			@PathVariable("transactionPassword") String transactionPassword) {
		Status status = new Status();
		try {
			  service.setNewPassword(custid,loginPassword,transactionPassword);
				status.setStatus(StatusType.SUCCESS);
				status.setMessage("Password reset done succesfully");
				return status;
		}catch(Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Something went wrong");
			return status;
		}
	}
	
	@GetMapping(path="/otpverified/{custid}")
	public Status generateMail(@PathVariable("custid") int custid) {
		Status status = new Status();
		try {
			  service.generateMail(custid);
				status.setStatus(StatusType.SUCCESS);
				status.setMessage("Mail has been sent to your registered email Id");
				return status;
		}catch(Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Something went wrong");
			return status;
		}
	}
	
	@GetMapping(path="/viewProfile/{custId}")
	public CustomerInfo getCustomerDetails(@PathVariable("custId") int custid) {
		CustomerInfo details = service.getCustomerDetails(custid);
		return details;
	}
	
	@PostMapping(path="/editCustomerDetails")
	public CustomerInfo editCustomerDetails(@RequestBody CustomerInfo custInfo) {
		CustomerInfo details = service.editCustomerDetails(custInfo);
		return details;
	}
	
}




