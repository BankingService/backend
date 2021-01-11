package com.lti.repository;

import com.lti.entities.AdminInfo;
import com.lti.entities.ApplicationReference;

public interface AdminRepo {

	public void adminLogin(AdminInfo adminInfo);
	public void viewAcceptedCustomers();
	public void viewPendingCustomers();
	public void viewPendingCustomersById(int id);
	public void insertAccountInfo(int aid,int refid);
	public void updateCustomerInfo(int aid,int refid);
	public void deleteApplicationReference(int refid);
	public void updateAppReference(int refid);

}
