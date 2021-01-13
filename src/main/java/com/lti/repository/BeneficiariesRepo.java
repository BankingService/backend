package com.lti.repository;

import com.lti.entities.Beneficiaries;

public interface BeneficiariesRepo {

	void addBeneficiary(Beneficiaries beneficiary, int custId);

}
