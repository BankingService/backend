package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entities.AdminInfo;
import com.lti.entities.CustomerAddress;
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

	@Override
	public void createAccountAdd(CustomerAddress customerAddress) {
		entityManager.persist(customerAddress);
		
	} 
	@Override
	public AdminInfo getAdminInfo(int id) {
		AdminInfo admin = entityManager.find(AdminInfo.class, id);
		return admin;
	}


}
