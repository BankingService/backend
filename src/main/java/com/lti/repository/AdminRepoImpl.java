package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entities.AccountInfo;
import com.lti.entities.AdminInfo;
import com.lti.entities.ApplicationReference;
import com.lti.entities.CustomerInfo;
import com.lti.entities.Status;

@Repository
public class AdminRepoImpl implements AdminRepo {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public void adminLogin(AdminInfo adminInfo) {

		int i = (int) entityManager.createQuery(
				"select admin.adminId from AdminInfo admin where admin.adminId =:user and admin.adminPassword=:pass")
				.setParameter("user", adminInfo.getAdminId()).setParameter("pass", adminInfo.getAdminPassword()).getSingleResult();
		if(i!=0)
			System.out.println("Login success");
	}

	@Override
	public void viewAcceptedCustomers() {

		List<CustomerInfo> list = entityManager.createQuery(
				"from CustomerInfo c where c.statusId = 2",CustomerInfo.class).getResultList();
		System.out.println(list);
	}

	@Override
	public void viewPendingCustomers() {
		List<CustomerInfo> list = entityManager.createQuery(
				"from CustomerInfo c where c.statusId = 1",CustomerInfo.class).getResultList();
		System.out.println(list);
		
	}

	@Override
	public void viewPendingCustomersById(int id) {
		CustomerInfo c = entityManager.createQuery(
				"from CustomerInfo c where c.customerId=: cid and c.statusId = 1",CustomerInfo.class)
				.setParameter("cid", id).getSingleResult();
		System.out.println(c);
	}

	@Override
	public void insertAccountInfo(int aid, int refid) {

		
		ApplicationReference appRef = (ApplicationReference) entityManager.createQuery(
				"from ApplicationReference a where a.referenceId =:id")
				.setParameter("id", refid).getSingleResult();
		AccountInfo accInfo = new AccountInfo();
		accInfo.setCustomerId(appRef.getCustomerId());
		accInfo.setIfsc("BANK001122");
		accInfo.setAccountBalance(1000.00);
		entityManager.persist(accInfo);
		entityManager.flush();
		
	}

	@Override
	public void updateCustomerInfo(int aid, int refid) {
		ApplicationReference apr = (ApplicationReference) entityManager.createQuery(
				"from ApplicationReference a where a.referenceId =:id")
				.setParameter("id", refid).getSingleResult();
		int custId = apr.getCustomerId().getCustomerId();
		CustomerInfo custInfo = entityManager.find(CustomerInfo.class, custId);
		custInfo.setApprovedBy(entityManager.find(AdminInfo.class, aid));
		custInfo.setStatusId(entityManager.find(Status.class, 2));
		entityManager.merge(custInfo);
		entityManager.flush();
	}

	@Override
	public void deleteApplicationReference(int refid) {
		entityManager.createQuery("delete from ApplicationReference ar where ar.referenceId = :rId").setParameter("rId", refid);
		
	}

	@Override
	public void updateAppReference(int refid) {

		ApplicationReference apr = entityManager.find(ApplicationReference.class, refid);
		apr.setStatusId(entityManager.find(Status.class, 3));
		entityManager.merge(apr);
		entityManager.flush();
	}

	
}
