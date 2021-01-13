package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entities.ApplicationReference;
import com.lti.entities.CustomerInfo;

@Repository
@Transactional
public class CreateAccountRepoImpl implements CreateAccountRepo {

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public void createAccount(CustomerInfo customerInfo) {

		em.persist(customerInfo);
		em.flush();
		System.out.println(customerInfo.getCustomerId());
	}

	@Override
	public int findCustomerId() {
		int res = 1;
		String query = "from ApplicationReference ar where ar.statusId = 3 ";
		List<ApplicationReference> appRef = em.createQuery(query, ApplicationReference.class).getResultList();
		if(!appRef.isEmpty())
		res = appRef.get(0).getCustomerId().getCustomerId();
//		System.out.println(appRef.getCustomerId().getCustomerId());
		return res;
	}

	@Override
	public CustomerInfo updateAccount(CustomerInfo customerInfo, int id) {
//		String query = "update"
		customerInfo.setCustomerId(id);
		em.merge(customerInfo);
		em.flush();
		return customerInfo;
	}

	@Override
	public void insertAppRef(ApplicationReference appRef) {
		em.persist(appRef);
		em.flush();
	}

	@Override
	public void deleteAppRef(CustomerInfo customerInfo) {
		String query = "delete from ApplicationReference ar where ar.customerId = :cId";
		em.createQuery(query).setParameter("cId", customerInfo).executeUpdate();
	}

	@Override
	public String checkStatus(int refId) {
		String query = "from ApplicationReference ar where ar.referenceId =: refId";
		ApplicationReference apr =  em.createQuery(query, ApplicationReference.class).setParameter("refId", refId).getSingleResult();
		return apr.getStatusId().getStatusMessage();
	}


}
