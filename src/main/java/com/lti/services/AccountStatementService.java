package com.lti.services;

import java.util.List;

import com.lti.dto.AccountStatementDTO;
import com.lti.dto.AccountStatementRequest;

public interface AccountStatementService {

	List<AccountStatementDTO> getStatement(AccountStatementRequest accRequest);


}
