package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entities.AdminInfo;
import com.lti.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public void adminLogin(AdminInfo adminInfo) {
	
		adminRepo.adminLogin(adminInfo);
	}

	@Override
	public void viewAcceptedCustomers() {

		adminRepo.viewAcceptedCustomers();
	}

	@Override
	public void viewPendingCustomers() {
		adminRepo.viewPendingCustomers();
		
	}

	@Override
	public void viewPendingCustomersById(int id) {
		adminRepo.viewPendingCustomersById(id);
		
	}

	@Override
	public void actionPerformed(int aid, int refid, String action) {
		if(action.equals("Accepted")){
			adminRepo.insertAccountInfo(aid,refid);
			adminRepo.updateCustomerInfo(aid,refid);
			adminRepo.deleteApplicationReference(refid);

		} else {
			adminRepo.updateAppReference(refid);
		}
	}

}
