package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entities.AccountInfo;
import com.lti.entities.AdminInfo;
import com.lti.entities.ApplicationReference;
import com.lti.entities.CustomerInfo;
import com.lti.entities.Status;

@Repository
@Transactional
public class AdminRepoImpl implements AdminRepo {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public int adminLogin(AdminInfo adminInfo) {

		int i = (int) entityManager.createQuery(
				"select admin.adminId from AdminInfo admin where admin.adminId =:user and admin.adminPassword=:pass")
				.setParameter("user", adminInfo.getAdminId()).setParameter("pass", adminInfo.getAdminPassword()).getSingleResult();
		if(i!=0)
			return 1;
		return 0;
	}

	@Override
	public List<CustomerInfo> viewAcceptedCustomers() {

		List<CustomerInfo> list = entityManager.createQuery(
				"from CustomerInfo c where c.statusId = 2",CustomerInfo.class).getResultList();
	
		return list;
	}

	@Override
	public  List<ApplicationReference> viewPendingCustomers() {
		List<ApplicationReference> list = entityManager.createQuery(
				"from ApplicationReference r where r.statusId = 1",ApplicationReference.class).getResultList();
		return list;
		
	}

	@Override
	public CustomerInfo viewPendingCustomersById(int refid) {
		
		ApplicationReference appRef = (ApplicationReference) entityManager.createQuery(
				"from ApplicationReference a where a.referenceId =:id")
				.setParameter("id", refid).getSingleResult();
		
		int custId = appRef.getCustomerId().getCustomerId();
		
		CustomerInfo c = entityManager.createQuery(
				"from CustomerInfo c where c.customerId=: cid and c.statusId = 1",CustomerInfo.class)
				.setParameter("cid", custId).getSingleResult();

		return c;
	}

	@Override
	public CustomerInfo viewAcceptedCustomersById(int custid) {
		CustomerInfo c = entityManager.createQuery(
				"from CustomerInfo c where c.customerId=: cid and c.statusId = 2",CustomerInfo.class)
				.setParameter("cid", custid).getSingleResult();

		return c;
	}

	
	@Override
	public void insertAccountInfo(int aid, int refid) {

		
		ApplicationReference appRef = (ApplicationReference) entityManager.createQuery(
				"from ApplicationReference a where a.referenceId =:id")
				.setParameter("id", refid).getSingleResult();
		
		CustomerInfo custInfo = entityManager.find(CustomerInfo.class, appRef.getCustomerId().getCustomerId());
		AccountInfo accInfo = new AccountInfo();
		accInfo.setCustomerId(custInfo);
		Long accNo = appRef.getCustomerId().getCustomerId()+23452L;
		accInfo.setAccountNumber(String.valueOf(accNo));
		accInfo.setIfsc("BANK001122");
		accInfo.setAccountBalance(1000);
				
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
		entityManager.createQuery("delete from ApplicationReference ar where ar.referenceId = :rId").setParameter("rId", refid).executeUpdate();
		
	}

	@Override
	public void updateStatusAppReference(int refid) {

		ApplicationReference apr = entityManager.find(ApplicationReference.class, refid);
		apr.setStatusId(entityManager.find(Status.class, 3));
		entityManager.merge(apr);
		entityManager.flush();
	}

	@Override
	public void updateStatusCustomerInfo(int aid,int refid) {
		ApplicationReference apr = entityManager.find(ApplicationReference.class, refid);
		CustomerInfo custInfo = apr.getCustomerId();
		custInfo.setStatusId(entityManager.find(Status.class, 3));
		custInfo.setApprovedBy(entityManager.find(AdminInfo.class, aid));
		entityManager.merge(custInfo);
		entityManager.flush();
	
	}

	@Override
	public CustomerInfo getdetails(int refid) {
		ApplicationReference apr = entityManager.find(ApplicationReference.class, refid);
		CustomerInfo custInfo = new CustomerInfo();
		custInfo.setCustomerId(apr.getCustomerId().getCustomerId());
		custInfo.setEmailId(apr.getCustomerId().getEmailId());
		custInfo.setFirstName(apr.getCustomerId().getFirstName());
		return custInfo;
	}

	@Override
	public AccountInfo getAccountDetails(int refid) {
		ApplicationReference apr = entityManager.find(ApplicationReference.class, refid);
		int custId = apr.getCustomerId().getCustomerId();
		AccountInfo a = entityManager.find(AccountInfo.class, custId);
		return a;
	}

	
	
}
