package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BeneficiariesDTO;
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
	
	@GetMapping(path="/viewBeneficiaries/{custId}")
	public List<BeneficiariesDTO> viewBeneficiaries(@PathVariable("custId") int custid){
		List<BeneficiariesDTO> b = service.viewBeneficiaries(custid);
		return b;
	}
	
	@GetMapping(path = "/addBeneficiaryOtp/{custid}")
	public Status generateOtp(@PathVariable("custid") int custid) {

		Status status = new Status();
		try {
			int otp = service.generateOtp(custid);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("The otp is : " + otp);
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Failed");
			return status;
		}

	}
}
