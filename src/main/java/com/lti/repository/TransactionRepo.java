package com.lti.repository;

import java.util.List;

import com.lti.dto.TransactionDto;
import com.lti.entities.CustomerInfo;

public interface TransactionRepo {

	boolean isBalance(TransactionDto usertransaction);

	boolean isValidPwd(TransactionDto usertransaction);

	List<Float> updateAccBalance(TransactionDto usertransaction);

	void transact(TransactionDto usertransaction, Float balance, String transactionType, int transactionId);

	CustomerInfo getCustomerInfo(int custid);

}
