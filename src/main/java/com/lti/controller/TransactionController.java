package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.TransactionDto;
import com.lti.services.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService service;
	
	@PostMapping(path = "/transact/")
	public String userTransaction(@RequestBody TransactionDto transaction) {
		try {
			String res = service.userTransaction(transaction);
			return res;
		} catch (Exception e) {
			return "TRANSACTION FAILED";
		}
	}
}
