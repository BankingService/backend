package com.lti.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.dto.TransactionDto;
import com.lti.services.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {
	
	@Autowired
	TransactionService service;
	
	@PostMapping(path = "/transact/")
	public Status userTransaction(@RequestBody TransactionDto transaction) {
		Status status = new Status();
		try {
			transaction.setTransactionDateTime(LocalDateTime.now());
			String res = service.userTransaction(transaction);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage(res);
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("TRANSACTION FAILED");
			return status;
		}
		
	}
	
	@GetMapping(path = "/getTransactionOtp/{custid}")
	public Status generateOtp(@PathVariable("custid") int custid) {

		Status status = new Status();
		try {
			int otp = service.generateOtp(custid);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("The otp is : " + otp);
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("User Not Registered");
			return status;
		}

	}
}
