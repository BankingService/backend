package com.lti.repository;

import java.util.List;

import com.lti.dto.TransactionDto;
import com.lti.entities.CustomerInfo;
import com.lti.entities.UserTransaction;

public interface TransactionRepo {

	boolean isBalance(TransactionDto usertransaction);

	boolean isValidPwd(TransactionDto usertransaction);

	List<Float> updateAccBalance(TransactionDto usertransaction);

	UserTransaction transact(TransactionDto usertransaction, Float balance, String transactionType, int transactionId, int i);

	CustomerInfo getCustomerInfo(int custid);

}
