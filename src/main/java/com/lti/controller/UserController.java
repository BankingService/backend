package com.lti.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginStatus;
import com.lti.dto.LogoutDTO;
import com.lti.dto.Status;
import com.lti.dto.UserCredentialsDTO;
import com.lti.dto.Status.StatusType;
import com.lti.entities.AccountInfo;
import com.lti.entities.CustomerInfo;
import com.lti.entities.UserLoginCredentials;
import com.lti.entities.UserLoginInfo;
import com.lti.services.UserLoginService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserLoginService service;

	@PostMapping(path = "/userLogin")
	public Status loginInfo(@RequestBody UserCredentialsDTO userCredentials) {
		LoginStatus a = new LoginStatus();
		try {
			UserLoginCredentials user = service.findUser(userCredentials);
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

	@GetMapping(path = "/forgotpassword/{custid}")
	public Status forgotPassword(@PathVariable("custid") int custid) {

		Status status = new Status();
		try {
			int otp = service.forgotPassword(custid);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("The otp is : " + otp);
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("User Not Registered");
			return status;
		}

	}

	@GetMapping(path = "/forgotuserid/{accno}")
	public Status generateOtp(@PathVariable("accno") String accNo) {
		Status status = new Status();
		try {
			int otp = service.forgotUserId(accNo);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("The otp is : " + otp);
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Invalid Account Number");
			return status;
		}
	}

	@GetMapping(path = "/setnewpassword/{custid}/{loginPassword}/{transactionPassword}")
	public Status setNewPassword(@PathVariable("custid") int custid,
			@PathVariable("loginPassword") String loginPassword,
			@PathVariable("transactionPassword") String transactionPassword) {
		Status status = new Status();
		try {
			service.setNewPassword(custid, loginPassword, transactionPassword);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Password reset done succesfully");
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Something went wrong");
			return status;
		}
	}

	@GetMapping(path = "/forgotUserIdOtpVerified/{accno}") //when user forgets custid he enters accNo and otp is sent when otp is verified mail is sent with custId;
	public Status generateMail(@PathVariable("accno") String accNo) {
		Status status = new Status();
		try {
			service.generateMail(accNo);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Mail has been sent to your registered email Id");
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Something went wrong");
			return status;
		}
	}

	@GetMapping(path = "/viewProfileDetails/{custId}")
	public CustomerInfo getCustomerDetails(@PathVariable("custId") int custid) {
		System.out.println(custid);
		CustomerInfo details = service.getCustomerDetails(custid);
		return details;
	}

	@PostMapping(path = "/editCustomerDetails")
	public CustomerInfo editCustomerDetails(@RequestBody CustomerInfo custInfo) {
		CustomerInfo details = service.editCustomerDetails(custInfo);
		return details;
	}

	@GetMapping(path="/viewProfile/{custid}/{profilePassword}")
	public Status viewProfileUsingPassword(@PathVariable("custid") int custid,@PathVariable("profilePassword") String profilePassword) {
		Status s = new Status();
		try {
			int result = service.verifyProfilePassword(custid, profilePassword);
				if(result!=0) {
					s.setStatus(StatusType.SUCCESS);
					s.setMessage("Correct password");
					return s;
				}
				else {
					s.setStatus(StatusType.FAILURE);
					s.setMessage("Incorrect Password");
					return s;
				}	
			} catch (Exception e) {
				s.setStatus(StatusType.FAILURE);
				s.setMessage("Incorrect Password");
				return s;
			}		
		
	}
	
	@GetMapping(path="/logout/{custid}")
	public LogoutDTO logoutDetails(@PathVariable("custid") int custid) {
		LogoutDTO l = new LogoutDTO();
		try {
		UserLoginInfo u = service.getLogoutDetails(custid);
		if(u!=null) {
			l.setStatus(StatusType.SUCCESS);
			l.setMessage("Logout Success");
			l.setLastLoginDateTime(u.getLastLoginDateTime());
			l.setLastLoginIpAddress(u.getLastLoginIpAddress());
			return l;
		}else {
			l.setStatus(StatusType.FAILURE);
			l.setMessage("Logout Failed");
			return l;
		}
		}catch(Exception e) {
			l.setStatus(StatusType.FAILURE);
			l.setMessage("Logout Failed");
			return l;
		}
	}

}
