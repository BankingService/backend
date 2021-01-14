package com.lti.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@Autowired
	private ImageService image;
	
	@Override
	public AdminInfo adminLogin(AdminInfo adminInfo) {
	
		AdminInfo ad = adminRepo.adminLogin(adminInfo);
		return ad;
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
	public List<ViewAcceptedCustomers> viewBlockedCustomers() {
		List<CustomerInfo> list = adminRepo.viewBlockedCustomers();
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
	public CustomerInfo viewPendingCustomersById(int refid,HttpServletRequest request) {
		CustomerInfo c = adminRepo.viewPendingCustomersById(refid);
		image.imageDownload(c.getCustomerId(), request);
		return c;
		
	}

	@Override
	public CustomerInfo viewAcceptedCustomersById(int custid,HttpServletRequest request) {
		image.imageDownload(custid, request);
		CustomerInfo c = adminRepo.viewAcceptedCustomersById(custid);
		return c;
		
	}
	
	@Override
	public CustomerInfo viewBlockedCustomersById(int custid,HttpServletRequest request) {
		image.imageDownload(custid, request);
		CustomerInfo c = adminRepo.viewBlockedCustomersById(custid);
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

	@Override
	public int actionPerformedUnblocking(int aid, int custid, String action) {
		try{
			if(action.equals("Accepted")){
				
			adminRepo.updateCustomerInfoStatusUnblocked(aid,custid);
			System.out.println("hello");
			adminRepo.updateUserLoginInfo(custid);
			
			CustomerInfo c = adminRepo.getdetailsAfterUpdation(custid);
			AccountInfo a = adminRepo.getAccountDetailsAfterUpdation(custid);
			
			String toEmail = c.getEmailId();
			
			String subject = "Account Unblocked";
			String msg = "Hi "
					+ c.getFirstName()
					+ ",\nCongratulations!!"
					+ "\nYour account has been unblocked.\n"
					+ "You can start using the services again.\n" 
					+ "User Id : "+c.getCustomerId()+"\n"
					+ "Account Number : "+a.getAccountNumber()+"\n"
					+ "Thank You\n"
					+ "Best Regards,\n"
					+ "Bank";
			email.sendEmail(toEmail, subject, msg);
					
			
			
		 } else {
			adminRepo.updateStatusCustomerInfoRejected(aid,custid);
		}
	}catch(Exception e) {
		return 0;
	}
		return 1;
	}

	
	

}
