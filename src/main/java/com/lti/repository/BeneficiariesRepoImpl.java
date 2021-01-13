package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dto.Status;
import com.lti.entities.AccountInfo;
import com.lti.entities.Beneficiaries;
import com.lti.entities.CustomerInfo;
import com.lti.entities.UserLoginCredentials;

@Repository
@Transactional
public class BeneficiariesRepoImpl implements BeneficiariesRepo {

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public void addBeneficiary(Beneficiaries beneficiary, int custId) {
		
		CustomerInfo c = em.find(CustomerInfo.class,custId);
		AccountInfo ac = em.find(AccountInfo.class, c.getCustomerId());
		UserLoginCredentials u = em.find(UserLoginCredentials.class, ac);
		
		Beneficiaries b = new Beneficiaries();
		b.setBeneficiaryAccountNumber(beneficiary.getBeneficiaryAccountNumber());
		b.setBeneficiaryName(beneficiary.getBeneficiaryName());
		b.setBeneficiaryNickName(beneficiary.getBeneficiaryNickName());
		b.setBeneficiaryIfsc(beneficiary.getBeneficiaryIfsc());
		b.setCustomerId(u.getCustomerId());
		
		em.persist(b);
		em.flush();
	
	}

}