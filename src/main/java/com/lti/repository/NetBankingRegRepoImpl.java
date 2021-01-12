package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entities.UserLoginCredentials;

@Repository
@Transactional
public class NetBankingRegRepoImpl implements NetBankingRegRepo {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void registerUser(UserLoginCredentials userCredentials) {
		em.persist(userCredentials);
		em.flush();
	}

	@Override
	public boolean isInfoPresent(UserLoginCredentials userCredentials) {
		return em.find(UserLoginCredentials.class, userCredentials.getCustomerId()) != null ? true : false ;
	}
}
