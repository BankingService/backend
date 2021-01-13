package com.lti.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dto.TransactionDto;
import com.lti.entities.AccountInfo;
import com.lti.entities.TransactionMode;
import com.lti.entities.UserLoginCredentials;
import com.lti.entities.UserTransaction;

@Repository
@Transactional
public class TransactionRepoImpl implements TransactionRepo {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean isBalance(TransactionDto usertransaction) {

		System.out.println(usertransaction.getFromAccountNumber());
		AccountInfo accInfo = (AccountInfo) em.createQuery("from AccountInfo ai where ai.accountNumber =: accNumber")
				.setParameter("accNumber", usertransaction.getFromAccountNumber()).getSingleResult();
		return accInfo.getAccountBalance() >= usertransaction.getTransactionAmount() ? true : false;
	}

	@Override
	public boolean isValidPwd(TransactionDto usertransaction) {
		System.out.println("checking pwd");
		AccountInfo accInfo = (AccountInfo) em.createQuery("from AccountInfo ai where ai.accountNumber =: accNumber")
				.setParameter("accNumber", usertransaction.getFromAccountNumber()).getSingleResult();
		UserLoginCredentials ulc = em.find(UserLoginCredentials.class, accInfo);
		return usertransaction.getTransactionPassword().equals(ulc.getTransactionPassword()) ? true : false;
	}

	@Override
	public List<Float> updateAccBalance(TransactionDto usertransaction) {
		List<Float> balance = new ArrayList<Float>();
//		AccountInfo acc1 = new AccountInfo();
		AccountInfo accInfo = (AccountInfo) em.createQuery("from AccountInfo ai where ai.accountNumber =: accNumber")
				.setParameter("accNumber", usertransaction.getFromAccountNumber()).getSingleResult();
		float bal = accInfo.getAccountBalance() - usertransaction.getTransactionAmount();
		accInfo.setAccountBalance(bal);
//		acc1.setAccountBalance(bal);
//		acc1.setCustomerId(accInfo.getCustomerId());
//		acc1.setAccountNumber(accInfo.getAccountNumber());
//		acc1.setIfsc(accInfo.getIfsc());
		em.detach(accInfo);
		em.merge(accInfo);
		em.flush();
		System.out.println(accInfo.getAccountBalance());
		balance.add(accInfo.getAccountBalance());
		try {
		AccountInfo ToAccInfo = (AccountInfo) em.createQuery("from AccountInfo ai where ai.accountNumber =: accNumber")
				.setParameter("accNumber", usertransaction.getToAccountNumber()).getSingleResult();
		ToAccInfo.setAccountBalance(ToAccInfo.getAccountBalance() + usertransaction.getTransactionAmount());
		em.merge(ToAccInfo);
		em.flush();
		balance.add(ToAccInfo.getAccountBalance());
		System.out.println(ToAccInfo.getAccountBalance());
		}catch(Exception e) {
			balance.add((float)0);
		}
		return balance;
	}

	@Override
	public void transact(TransactionDto usertransaction, Float balance, String transactionType, int transactionId) {

		UserTransaction ut = new UserTransaction();
		ut.setTransactionID(transactionId);
		if (transactionType.equals("CREDIT")) {
			ut.setFromAccountNumber(usertransaction.getToAccountNumber());
			ut.setToAccountNumber(usertransaction.getFromAccountNumber());
		} else {
			ut.setFromAccountNumber(usertransaction.getFromAccountNumber());
			ut.setToAccountNumber(usertransaction.getToAccountNumber());
		}
		ut.setTransactionAmount(usertransaction.getTransactionAmount());
		ut.setTransactionDateTime(usertransaction.getTransactionDateTime());
		ut.setTransactionModeId(em.find(TransactionMode.class, usertransaction.getTransactionModeId()));
		ut.setUpdatedBalance(balance);
		ut.setTransactionType(transactionType);
		ut.setRemark(usertransaction.getRemark());
		em.persist(ut);
		em.flush();
	}

}