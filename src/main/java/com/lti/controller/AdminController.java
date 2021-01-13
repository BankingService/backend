package com.lti.controller;

import java.util.List;

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
			int result = service.adminLogin(adminInfo);
			if(result!=0) {
				a.setStatus(StatusType.SUCCESS);
				a.setMessage("Login success");
				a.setAdminId(adminInfo.getAdminId());
				a.setAdminName(adminInfo.getAdminName());
			}
			else {
				a.setStatus(StatusType.FAILURE);
				a.setMessage("Incorrect Id or Password");
			}
			return a;
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
	
	@GetMapping(path="/viewAccepted/{custId}")
	public CustomerInfo getDetails(@PathVariable("custId") int custid) {
		CustomerInfo details = service.viewAcceptedCustomersById(custid);
		return details;
	}
	
	@GetMapping(path="/viewPending/{refid}")
	public CustomerInfo get(@PathVariable("refid") int refid) {
		CustomerInfo details = service.viewPendingCustomersById(refid);
		return details;
	}
	
	@GetMapping(path="/viewAction/{aid}/{refid}/{action}")
	public Status actionPerformed(@PathVariable("aid") int aid,@PathVariable("refid") int refid, @PathVariable("action") String action) {
			try {
				int result = service.actionPerformed(aid, refid, action);
				Status a = new Status();
				if(result!=0) {
					a.setStatus(StatusType.SUCCESS);
					a.setMessage("Action Performed");
				} else {
					a.setStatus(StatusType.FAILURE);
					a.setMessage("Action Failed");
				}
				return a;
			} catch (Exception e) {
				Status a = new Status();
				a.setStatus(StatusType.FAILURE);
				a.setMessage("Action Failed");
				return a;
			}		
		
	}
}
