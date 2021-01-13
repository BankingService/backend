package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entities.Beneficiaries;
import com.lti.repository.BeneficiariesRepo;

@Service
public class BeneficiariesServiceImpl implements BeneficiariesService {

	@Autowired
	private BeneficiariesRepo repo;
	
	@Override
	public int addBeneficiary(Beneficiaries beneficiary, int custId) {
		try {
			repo.addBeneficiary(beneficiary,custId);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

}
