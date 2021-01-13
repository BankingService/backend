package com.lti.repository;

import java.util.List;

import com.lti.dto.AccountStatementRequest;
import com.lti.entities.UserTransaction;

public interface AccountStatementRepo {

	List<UserTransaction> getStatement(AccountStatementRequest accRequest);

}
