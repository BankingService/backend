package com.lti.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entities.AdminInfo;
import com.lti.services.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping(path="/loginAdmin")
	public void adminLogin(@RequestBody AdminInfo adminInfo) {
		try {			
			service.adminLogin(adminInfo);
		}
		catch(ServiceException e) {
			
		}
	}
	
	@GetMapping(path="/viewAccepted")
	public void viewAcceptedCustomer() {
		try {
			service.viewAcceptedCustomers();
		} catch (Exception e) {
			
		}
	}
	
	@GetMapping(path="/viewPending")
	public void viewPendingCustomer() {
		try {
			service.viewPendingCustomers();
		} catch (Exception e) {
			
		}
	}
	
	@GetMapping(path="/viewPending/{id}")
	public void get(@PathVariable("id") int id) {
		try {
			service.viewPendingCustomersById(id);
		} catch (Exception e) {
			
		}
	}
	
	@GetMapping(path="/viewAction/{aid,refid,action}")
	public void actionPerformed(@PathVariable("aid") int aid,@PathVariable("refid") int refid, @PathVariable("action") String action) {
		try {
			service.actionPerformed(aid, refid, action);
		} catch (Exception e) {

		}
	}
}
