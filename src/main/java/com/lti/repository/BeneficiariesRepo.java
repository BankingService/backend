package com.lti.repository;

import java.util.List;

import com.lti.dto.GetBeneficiary;
import com.lti.entities.Beneficiaries;
import com.lti.entities.CustomerInfo;

public interface BeneficiariesRepo {

//	void addBeneficiary(Beneficiaries beneficiary, int custId);

	List<Beneficiaries> viewBeneficiaries(int custid);

	CustomerInfo getCustomerInfo(int custid);

	void addBeneficiary(GetBeneficiary beneficiary);

	int findBeneficiary(GetBeneficiary beneficiary);

}
