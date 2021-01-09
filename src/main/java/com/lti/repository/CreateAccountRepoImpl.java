package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entities.CustomerInfo;

@Repository
@Transactional
public class CreateAccountRepoImpl implements CreateAccountRepo {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void createAccount(CustomerInfo customerInfo) {
		
		entityManager.persist(customerInfo);
       
	}

}
