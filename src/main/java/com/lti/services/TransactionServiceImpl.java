package com.lti.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.TransactionDto;
import com.lti.repository.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepo transaction;
	
	Random rand = new Random();
	
	@Override
	public String userTransaction(TransactionDto usertransaction) {
		if (transaction.isBalance(usertransaction)) {
			if (transaction.isValidPwd(usertransaction)) {
				int transactionId = rand.nextInt(100000)+ (int)usertransaction.getTransactionAmount();
				List<Float> balance = transaction.updateAccBalance(usertransaction);
				String transactionType = "DEBIT";
				transaction.transact(usertransaction, balance.get(0), transactionType, transactionId);
				transactionType = "CREDIT";
				transaction.transact(usertransaction, balance.get(1), transactionType, transactionId);
				return "SUCCESS";
			} else {
				return "INVALID TRANSACTION PASSWORD";
			}
		} else {
			return "INSUFFICIENT FUND";
		}
	}

}
