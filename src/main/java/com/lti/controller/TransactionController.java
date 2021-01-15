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
import com.lti.dto.TransactionDetailsDTO;
import com.lti.dto.TransactionDto;
import com.lti.entities.UserTransaction;
import com.lti.services.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {
	
	@Autowired
	TransactionService service;
	
	@PostMapping(path = "/transact/")
	public TransactionDetailsDTO userTransaction(@RequestBody TransactionDto transaction) {
		try {
			transaction.setTransactionDateTime(LocalDateTime.now());
			TransactionDetailsDTO status = service.userTransaction(transaction);
			return status;
		} catch (Exception e) {
			TransactionDetailsDTO status = new TransactionDetailsDTO();
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
			status.setMessage(String.valueOf(otp));
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("User Not Registered");
			return status;
		}

	}
}
