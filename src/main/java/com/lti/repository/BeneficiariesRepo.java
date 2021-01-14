package com.lti.repository;

import java.util.List;

import com.lti.entities.Beneficiaries;

public interface BeneficiariesRepo {

	void addBeneficiary(Beneficiaries beneficiary, int custId);

	List<Beneficiaries> viewBeneficiaries(int custid);

}
