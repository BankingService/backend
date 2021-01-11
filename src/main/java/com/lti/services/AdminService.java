package com.lti.services;

import com.lti.entities.AdminInfo;
import com.lti.entities.ApplicationReference;

public interface AdminService {

	public void adminLogin(AdminInfo adminInfo);
	public void viewAcceptedCustomers();
	public void viewPendingCustomers();
	public void viewPendingCustomersById(int id);
	public void actionPerformed(int aid, int refid, String action);
}
