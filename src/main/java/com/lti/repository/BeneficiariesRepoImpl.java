package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dto.GetBeneficiary;
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
	public void addBeneficiary(GetBeneficiary beneficiary) {
		
		CustomerInfo c = em.find(CustomerInfo.class,beneficiary.getCustomerId());
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

	
	@Override
	public List<Beneficiaries> viewBeneficiaries(int custid) {

		CustomerInfo c = em.find(CustomerInfo.class,custid);
		AccountInfo ac = em.find(AccountInfo.class, c.getCustomerId());
		UserLoginCredentials u = em.find(UserLoginCredentials.class, ac);
		
		List<Beneficiaries> b = em.createQuery("from Beneficiaries bn where bn.customerId =:id",Beneficiaries.class)
				.setParameter("id", u.getCustomerId()).getResultList();
		return b;
	}

	@Override
	public CustomerInfo getCustomerInfo(int custid) {
		return em.find(CustomerInfo.class, custid);
	}

	@Override
	public int findBeneficiary(GetBeneficiary beneficiary) {
//		CustomerInfo c = em.find(CustomerInfo.class,beneficiary.getCustomerId());
		AccountInfo ac = em.find(AccountInfo.class, beneficiary.getCustomerId());
		
		System.out.println(ac);
		
	//	UserLoginCredentials u = em.find(UserLoginCredentials.class, ac.getCustomerId());

//		System.out.println(u);
		
//		Beneficiaries b = em.find(Beneficiaries.class, ac.getCustomerId());
//		System.out.println(b);
		
		List<Beneficiaries> i =  em.createQuery("from Beneficiaries bn where bn.customerId =:id and bn.beneficiaryAccountNumber =:accNo", Beneficiaries.class)
				.setParameter("id", ac).setParameter("accNo", beneficiary.getBeneficiaryAccountNumber()).getResultList();
		System.out.println(i);
		System.out.println(i.size());
		if(i.size()==0)
			return 0;
		else 
			return 1;
	}

}
