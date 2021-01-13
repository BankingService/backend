package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entities.UserLoginCredentials;
import com.lti.services.UserLoginService;

@RestController
public class UserLoginController {

	@Autowired
	private UserLoginService service;

	@PostMapping(path = "/userLogin")
	public Status loginInfo(@RequestBody UserLoginCredentials user) {
		try {
			String result = service.loginCustomer(user);
			Status a = new Status();
			if (result.equals("Login Success")) {
				a.setStatus(StatusType.SUCCESS);
				a.setMessage("Login Success");
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
			Status a = new Status();
			a.setStatus(StatusType.FAILURE);
			a.setMessage("Something went wrong");
			return a;
		}

	}
}
