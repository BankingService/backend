package com.lti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminStatus;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.dto.ViewAcceptedCustomers;
import com.lti.dto.ViewPendingCustomers;
import com.lti.entities.AdminInfo;
import com.lti.entities.CustomerInfo;
import com.lti.services.AdminService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping(path="/loginAdmin")
	public AdminStatus adminLogin(@RequestBody AdminInfo adminInfo) {
		AdminStatus a = new AdminStatus();
		try {
			AdminInfo ad = service.adminLogin(adminInfo);
			if(ad!=null) {
				a.setStatus(StatusType.SUCCESS);
				a.setMessage("Login success");
				a.setAdminId(ad.getAdminId());
				a.setAdminName(ad.getAdminName());
				return a;
			}
			else {
				a.setStatus(StatusType.FAILURE);
				a.setMessage("Incorrect Id or Password");
				return a;
			}
			
		} catch (Exception e) {
			a.setStatus(StatusType.FAILURE);
			a.setMessage("Incorrect Id or Password");
			return a;
		}		
	}
	
	@GetMapping(path="/viewAccepted")
	public List<ViewAcceptedCustomers> viewAcceptedCustomer() {
		List<ViewAcceptedCustomers> vac = service.viewAcceptedCustomers();
		return vac;
	}
	
	@GetMapping(path="/viewPending")
	public List<ViewPendingCustomers> viewPendingCustomer() {
		List<ViewPendingCustomers> vac = service.viewPendingCustomers();
		return vac;
	}
	
	@GetMapping(path="/viewBlocked")
	public List<ViewAcceptedCustomers> viewBlockedCustomer() {
		List<ViewAcceptedCustomers> vac = service.viewBlockedCustomers();
		return vac;
	}
	
	@GetMapping(path="/viewAccepted/{custId}")
	public CustomerInfo getDetails(@PathVariable("custId") int custid,HttpServletRequest request) {
		CustomerInfo details = service.viewAcceptedCustomersById(custid,request);
		return details;
	}
	
	@GetMapping(path="/viewPending/{refid}")
	public CustomerInfo get(@PathVariable("refid") int refid,HttpServletRequest request) {
		CustomerInfo details = service.viewPendingCustomersById(refid,request);
		return details;
	}
	
	@GetMapping(path="/viewBlocked/{custId}")
	public CustomerInfo getDetailsBlocked(@PathVariable("custId") int custid,HttpServletRequest request) {
		CustomerInfo details = service.viewBlockedCustomersById(custid,request);
		return details;
	}
	
	@GetMapping(path="/viewAction/{aid}/{refid}/{action}")
	public Status actionPerformed(@PathVariable("aid") int aid,@PathVariable("refid") int refid, @PathVariable("action") String action) {
			try {
				int result = service.actionPerformed(aid, refid, action);
				Status a = new Status();
				if(result!=0) {
					a.setStatus(StatusType.SUCCESS);
					a.setMessage(action);
				} else {
					a.setStatus(StatusType.FAILURE);
					a.setMessage(action);
				}
				return a;
			} catch (Exception e) {
				Status a = new Status();
				a.setStatus(StatusType.FAILURE);
				a.setMessage("Something went wrong");
				return a;
			}		
		
	}
	
	@GetMapping(path="/performAction/{aid}/{custid}/{action}")
	public Status actionPerformedUnblocking(@PathVariable("aid") int aid,@PathVariable("custid") int custid, @PathVariable("action") String action) {
			try {
				int result = service.actionPerformedUnblocking(aid, custid, action);
				Status a = new Status();
				if(result!=0) {
					a.setStatus(StatusType.SUCCESS);
					a.setMessage(action);
				} else {
					a.setStatus(StatusType.FAILURE);
					a.setMessage(action);
				}
				return a;
			} catch (Exception e) {
				Status a = new Status();
				a.setStatus(StatusType.FAILURE);
				a.setMessage("Something went wrong");
				return a;
			}		
		
	}
	
}
