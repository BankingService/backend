package com.lti.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.AccountStatementDTO;
import com.lti.dto.AccountStatementRequest;
import com.lti.entities.UserTransaction;
import com.lti.repository.AccountStatementRepo;

@Service
public class AccountStatementServiceImpl implements AccountStatementService {

	@Autowired
	AccountStatementRepo repo;

	@Override
	public List<AccountStatementDTO> getStatement(AccountStatementRequest accRequest) {
		List<AccountStatementDTO> accStatement = new ArrayList<>();
		List<UserTransaction> res = repo.getStatement(accRequest);
		
		for(UserTransaction ci : res) {
			AccountStatementDTO aDTO = new AccountStatementDTO();
			aDTO.setTransactionId(ci.getTransactionID());
			aDTO.setDate(ci.getTransactionDateTime());
			aDTO.setTransactionAmount(ci.getTransactionAmount());
			aDTO.setUpdatedBalance(ci.getUpdatedBalance());
			if(ci.getFromAccountNumber().equals("0")) {
				aDTO.setMessage("TO ACCOUNT NO: "+ ci.getToAccountNumber() + ""
						+ " MODE:" + ci.getTransactionModeId().getTransactionMode());
			}else {
				aDTO.setMessage("FROM ACCOUNT NO: "+ ci.getFromAccountNumber() + ""
						+ " MODE:" + ci.getTransactionModeId().getTransactionMode());
			}
			aDTO.setTransactionType(ci.getTransactionType());
			
			accStatement.add(aDTO);
		}
		return accStatement;
	}
	
	

}
