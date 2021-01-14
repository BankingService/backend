package com.lti.services;

import java.util.List;

import com.lti.dto.ViewAcceptedCustomers;
import com.lti.dto.ViewPendingCustomers;
import com.lti.entities.AdminInfo;
import com.lti.entities.CustomerInfo;

public interface AdminService {

	public AdminInfo adminLogin(AdminInfo adminInfo);
	
	public List<ViewAcceptedCustomers> viewAcceptedCustomers();
	public List<ViewPendingCustomers> viewPendingCustomers();
	public List<ViewAcceptedCustomers> viewBlockedCustomers();
	
	public CustomerInfo viewPendingCustomersById(int refid);
	public CustomerInfo viewAcceptedCustomersById(int custid);
	public CustomerInfo viewBlockedCustomersById(int custid);
	
	public int actionPerformed(int aid, int refid, String action);

	public int actionPerformedUnblocking(int aid, int custid, String action);

}
