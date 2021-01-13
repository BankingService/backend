package com.lti.services;

import java.util.List;

import com.lti.dto.ViewAcceptedCustomers;
import com.lti.dto.ViewPendingCustomers;
import com.lti.entities.AdminInfo;
import com.lti.entities.CustomerInfo;

public interface AdminService {

	public int adminLogin(AdminInfo adminInfo);
	public List<ViewAcceptedCustomers> viewAcceptedCustomers();
	public List<ViewPendingCustomers> viewPendingCustomers();
	public CustomerInfo viewPendingCustomersById(int refid);
	public CustomerInfo viewAcceptedCustomersById(int custid);
	public int actionPerformed(int aid, int refid, String action);
}
