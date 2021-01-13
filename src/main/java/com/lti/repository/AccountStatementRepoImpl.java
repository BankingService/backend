package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dto.AccountStatementRequest;
import com.lti.entities.UserTransaction;

@Repository
@Transactional
public class AccountStatementRepoImpl implements AccountStatementRepo {

	@PersistenceContext
	EntityManager em;
	
//	SELECT column_name(s)
//	FROM table_name
//	WHERE ROWNUM <= number

	@Override
	public List<UserTransaction> getStatement(AccountStatementRequest accRequest) {
		String query = "from UserTransaction ut where "
				+ "(ut.fromAccountNumber =:accNumber) "
				+ "and (transactionDateTime >=:fromDate and transactionDateTime <=:toDate)";

		List<UserTransaction> usrTrans = em.createQuery(query).setParameter("accNumber", accRequest.getAccountNumber())
				.setParameter("fromDate", accRequest.getFromDate()).setParameter("toDate", accRequest.getToDate()).getResultList();
		System.out.println(usrTrans);
		return usrTrans;
	}


}
