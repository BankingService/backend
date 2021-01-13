package com.lti.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.ViewAcceptedCustomers;
import com.lti.dto.ViewPendingCustomers;
import com.lti.entities.AccountInfo;
import com.lti.entities.AdminInfo;
import com.lti.entities.ApplicationReference;
import com.lti.entities.CustomerInfo;
import com.lti.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private EmailServiceImpl email;
	
	@Override
	public int adminLogin(AdminInfo adminInfo) {
	
		int result = adminRepo.adminLogin(adminInfo);
		if(result!=0)
			return 1;
		else 
			return 0;
	}

	@Override
	public List<ViewAcceptedCustomers> viewAcceptedCustomers() {

		List<CustomerInfo> list = adminRepo.viewAcceptedCustomers();
		List<ViewAcceptedCustomers> vac = new ArrayList<ViewAcceptedCustomers>();
        for(CustomerInfo cf : list) {
            ViewAcceptedCustomers v = new ViewAcceptedCustomers();
            v.setCustomerId(cf.getCustomerId());
            v.setFirstName(cf.getFirstName());
            v.setLastName(cf.getLastName());
            v.setMiddleName(cf.getMiddleName());
            v.setTitle(cf.getTitle());
            vac.add(v);
        }
        return vac;
		
	}

	@Override
	public  List<ViewPendingCustomers> viewPendingCustomers() {
		 List<ApplicationReference> list = adminRepo.viewPendingCustomers();
		 List<ViewPendingCustomers> vac = new ArrayList<ViewPendingCustomers>();
	        for(ApplicationReference af : list) {
	            ViewPendingCustomers v = new ViewPendingCustomers();
	            v.setReferenceId(af.getRefernceId());
	            v.setCustomerId(af.getCustomerId().getCustomerId());
	            vac.add(v);
	        }
	        return vac;
		
	}

	@Override
	public CustomerInfo viewPendingCustomersById(int refid) {
		CustomerInfo c = adminRepo.viewPendingCustomersById(refid);
		
		return c;
		
	}

	@Override
	public CustomerInfo viewAcceptedCustomersById(int custid) {
		CustomerInfo c = adminRepo.viewAcceptedCustomersById(custid);
		return c;
		
	}
	
	@Override
	public int actionPerformed(int aid, int refid, String action) {
		try{
			if(action.equals("Accepted")){
			adminRepo.insertAccountInfo(aid,refid);
			
			CustomerInfo c = adminRepo.getdetails(refid);
			AccountInfo a = adminRepo.getAccountDetails(refid);
			
			String toEmail = c.getEmailId();
			
			String subject = "Account Approved!!";
			String msg = "Hi "
					+ c.getFirstName()
					+ ",\nCongratulations!!"
					+ "\nYour account has been approved based on the documents you provided.\n"
					+ "Please note down the account details for fututre use : \n" 
					+ "User Id : "+c.getCustomerId()+"\n"
					+ "Account Number : "+a.getAccountNumber()+"\n"
					+ "As bonus we have added Rs. 1000 for registering with our bank.\n"
					+ "Thank You\n"
					+ "Best Regards,\n"
					+ "Bank";
			email.sendEmail(toEmail, subject, msg);
					
			adminRepo.updateCustomerInfo(aid,refid);
			adminRepo.deleteApplicationReference(refid);	
			
		 } else {
			adminRepo.updateStatusAppReference(refid);
			adminRepo.updateStatusCustomerInfo(aid,refid);
		}
	}catch(Exception e) {
		return 0;
	}
		return 1;
	}

	

}
