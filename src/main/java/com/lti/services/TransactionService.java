package com.lti.services;

import com.lti.dto.TransactionDetailsDTO;
import com.lti.dto.TransactionDto;

public interface TransactionService {

	TransactionDetailsDTO userTransaction(TransactionDto transaction);

	int generateOtp(int custid);

	
}
