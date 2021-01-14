package com.lti.repository;

import java.util.List;

import com.lti.entities.AccountInfo;
import com.lti.entities.AdminInfo;
import com.lti.entities.ApplicationReference;
import com.lti.entities.CustomerInfo;

public interface AdminRepo {

	public AdminInfo adminLogin(AdminInfo adminInfo);
	
	public List<CustomerInfo> viewAcceptedCustomers();
	public CustomerInfo viewAcceptedCustomersById(int custid);
	
	public List<ApplicationReference> viewPendingCustomers();
	public CustomerInfo viewPendingCustomersById(int refid);
	
	public List<CustomerInfo> viewBlockedCustomers();
	public CustomerInfo viewBlockedCustomersById(int custid);
	
	public void insertAccountInfo(int aid,int refid);
	public void updateCustomerInfo(int aid,int refid);
	public void deleteApplicationReference(int refid);
	
	public void updateStatusAppReference(int refid);
	public void updateStatusCustomerInfo(int aid,int refid);

	public CustomerInfo getdetails(int refid);

	public AccountInfo getAccountDetails(int refid);

	public void updateCustomerInfoStatusUnblocked(int aid, int custid);

	public void updateStatusCustomerInfoRejected(int aid, int custid);

	public void updateUserLoginInfo(int custid);

	public AccountInfo getAccountDetailsAfterUpdation(int custid);

	public CustomerInfo getdetailsAfterUpdation(int custid);



}
