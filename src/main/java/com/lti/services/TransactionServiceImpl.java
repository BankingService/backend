package com.lti.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.TransactionDto;
import com.lti.entities.UserTransaction;
import com.lti.repository.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepo transaction;
	@Autowired
	EmailServiceImpl email;
	
	Random rand = new Random();
	
	@Override
	public String userTransaction(TransactionDto usertransaction) {
		if (transaction.isBalance(usertransaction)) {
			if (transaction.isValidPwd(usertransaction)) {
				int transactionId = rand.nextInt(100000)+ (int)usertransaction.getTransactionAmount();
				List<Float> balance = transaction.updateAccBalance(usertransaction);
				String transactionType = "DEBIT";
				UserTransaction ut = transaction.transact(usertransaction, balance.get(0), transactionType, transactionId, usertransaction.getCustomerId());
				transactionType = "CREDIT";
				UserTransaction ut1 = transaction.transact(usertransaction, balance.get(1), transactionType, transactionId, usertransaction.getCustomerId());
				System.out.println(ut.toString());
				return ut.toString();
			} else {
				return "INVALID TRANSACTION PASSWORD";
			}
		} else {
			return "INSUFFICIENT FUND";
		}
	}

}
