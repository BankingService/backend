package com.lti.services;

import java.util.List;

import com.lti.dto.BeneficiariesDTO;
import com.lti.dto.GetBeneficiary;
import com.lti.entities.Beneficiaries;
 
public interface BeneficiariesService {

//	int addBeneficiary(Beneficiaries beneficiary, int custId);

	List<BeneficiariesDTO> viewBeneficiaries(int custid);

	int generateOtp(int custid);

	int addBeneficiary(GetBeneficiary beneficiary);

}
