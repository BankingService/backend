package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AccountStatementDTO;
import com.lti.dto.AccountStatementRequest;
import com.lti.services.AccountStatementService;

@RestController
@CrossOrigin
public class AccountStatementControler {

	@Autowired
	AccountStatementService service;

	@PostMapping(path = "/accountStatement/")
	public List<AccountStatementDTO> getAccountStatement(@RequestBody AccountStatementRequest accRequest) {
		try {
			List<AccountStatementDTO> aDTO = service.getStatement(accRequest);
			return aDTO;
		} catch (Exception e) {
			List<AccountStatementDTO> aDTO = new ArrayList<AccountStatementDTO>();
			aDTO.get(0).setMessage("FAILED");
			return aDTO;
		}
	}

}
