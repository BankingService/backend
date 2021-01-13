package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entities.Beneficiaries;
import com.lti.services.BeneficiariesService;

@RestController
@CrossOrigin
public class BeneficiaryController {

	@Autowired
	private BeneficiariesService service;

	@PostMapping(path = "/addBeneficiary/{custId}")
	public Status add(@RequestBody Beneficiaries beneficiary, @PathVariable("custId") int custId) {
		Status s =new Status();
		try {
			int result = service.addBeneficiary(beneficiary, custId);
			if(result!=0) {
				s.setStatus(StatusType.SUCCESS);
				s.setMessage("Beneficiary Added");
				return s;
			}
			else {
				s.setStatus(StatusType.FAILURE);
				s.setMessage("Adding Beneficiary failed");
				return s;
			}

		} catch (Exception e) {
			s.setStatus(StatusType.FAILURE);
			s.setMessage("Something went wrong");
			return s;
		}
	}
}
