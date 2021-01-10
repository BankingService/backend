package com.lti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.entities.CustomerInfo;

public interface CustomerRepo extends JpaRepository<CustomerInfo, Integer>{
	
	
}
