package com.lti.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.TransactionDetailsDTO;
import com.lti.dto.TransactionDto;
import com.lti.dto.Status.StatusType;
import com.lti.entities.CustomerInfo;
import com.lti.entities.UserTransaction;
import com.lti.repository.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepo transaction;
	
	@Autowired
	private EmailServiceImpl email;
	
	Random rand = new Random();
	
	@Override
	public TransactionDetailsDTO userTransaction(TransactionDto usertransaction) {
		TransactionDetailsDTO status = new TransactionDetailsDTO();
		if (transaction.isBalance(usertransaction)) {
			if (transaction.isValidPwd(usertransaction)) {
				int transactionId = rand.nextInt(100000)+ (int)usertransaction.getTransactionAmount();
				List<Float> balance = transaction.updateAccBalance(usertransaction);
				String transactionType = "DEBIT";
				UserTransaction ut = transaction.transact(usertransaction, balance.get(0), transactionType, transactionId, usertransaction.getCustomerId());
				transactionType = "CREDIT";
				UserTransaction ut1 = transaction.transact(usertransaction, balance.get(1), transactionType, transactionId, usertransaction.getCustomerId());
//				System.out.println(ut.toString());
				status.setStatus(StatusType.SUCCESS);
				status.setMessage("Transaction Successfull");
				status.setTransactionId(ut.getTransactionID());
				status.setFromAccountNumber(ut.getFromAccountNumber());
				status.setToAccountNumber(ut.getToAccountNumber());
				status.setTransactionAmount(ut.getTransactionAmount());
				status.setTransactionDateTime(ut.getTransactionDateTime());
				status.setTransactionMode(ut.getTransactionModeId().getTransactionMode());
				status.setUpdatedBalance(ut.getUpdatedBalance());
				status.setRemark(ut.getRemark());
				return status;
			} else {
				status.setStatus(StatusType.FAILURE);
				status.setMessage("INVALID TRANSACTION PASSWORD");
				return status;
			}
			
		} else {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("INSUFFICIENT FUND");
			return status;
		}
	}

	@Override
	public int generateOtp(int custid) {
		int randomPin = (int) (Math.random()*9000)+1000;
		System.out.println(randomPin);
		
		CustomerInfo c = transaction.getCustomerInfo(custid);
		
		String toEmail = c.getEmailId();
		
		String subject = "OTP";
		String msg = "Hi "
				+ c.getFirstName()
				+", "
				+ "\nYour OTP is : "+randomPin
				+ "\nThank You\n"
				+ "Best Regards,\n"
				+ "Bank";
		email.sendEmail(toEmail, subject, msg);
		
		return randomPin;
	}

}
