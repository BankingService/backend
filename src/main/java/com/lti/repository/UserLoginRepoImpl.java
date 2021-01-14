package com.lti.repository;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entities.AccountInfo;
import com.lti.entities.CustomerInfo;
import com.lti.entities.Status;
import com.lti.entities.UserLoginCredentials;
import com.lti.entities.UserLoginInfo;


@Repository
@Transactional
public class UserLoginRepoImpl implements UserLoginRepo {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public int findCustomer(UserLoginCredentials user) {
		System.out.println(user.getCustomerId());
		System.out.println(user.getLoginPassword());
		//AccountInfo ac = em.find(AccountInfo.class, user.getCustomerId());
		return em.find(UserLoginCredentials.class, user.getCustomerId()) != null ? 1 : 0;
	}

	@Override
	public int checkCredentials(UserLoginCredentials user) {
		// AccountInfo ac = em.find(AccountInfo.class, user.getCustomerId());
		List<UserLoginCredentials> i = null;
		CustomerInfo c = em.find(CustomerInfo.class, user.getCustomerId().getCustomerId().getCustomerId()); 
		if(c.getStatusId().getStatusId()==2) {
		i = em.createQuery("from UserLoginCredentials u where u.customerId =:id and u.loginPassword =: pass",
						UserLoginCredentials.class)
				.setParameter("id", user.getCustomerId()).setParameter("pass", user.getLoginPassword()).getResultList();
		}
		if (i != null) {
			System.out.println("Size " + i.size());
			int size = i.size();
			if (size == 1)
				return 1;
			else
				return 0;
		}
		return 0;
	}

	@Override
	public AccountInfo updateLoginInfo(UserLoginCredentials user) {
		try {
			System.out.println("hello2");

			//AccountInfo ac = em.find(AccountInfo.class, user.getCustomerId());
			UserLoginInfo res = em.find(UserLoginInfo.class, user.getCustomerId());

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));

			InetAddress myIP = InetAddress.getLocalHost();
			System.out.println(myIP.getHostAddress());

			if (res != null) {
				res.setLastLoginDateTime(dtf.format(now));
				res.setInvalidAttempts(0);
				res.setLastLoginDateTime(dtf.format(now));
				res.setLastLoginIpAddress(myIP.getHostAddress());
				em.merge(res);
				em.flush();
			} else {
				UserLoginInfo ul = new UserLoginInfo();
				ul.setCustomerId(user.getCustomerId());
				ul.setInvalidAttempts(0);
				ul.setLastLoginDateTime(dtf.format(now));
				ul.setLastLoginIpAddress(myIP.getHostAddress());
				em.persist(ul);
				em.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		AccountInfo ac = em.createQuery("from AccountInfo c where c.customerId =: id", AccountInfo.class)
				.setParameter("id", user.getCustomerId().getCustomerId()).getSingleResult();
		System.out.println("Account Info : "+ac);
		return ac;

	}

	@Override
	public String updateLoginInfoInvalidAttempts(UserLoginCredentials user) {

		try {
			AccountInfo ac = em.find(AccountInfo.class, user.getCustomerId());
			UserLoginInfo uli = em.find(UserLoginInfo.class, user.getCustomerId());

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));

			InetAddress myIP = InetAddress.getLocalHost();
			System.out.println(myIP.getHostAddress());

			if (uli != null) {

				int invalidAttempts = uli.getInvalidAttempts();
				System.out.println(invalidAttempts);
				if (invalidAttempts < 3) {
					uli.setInvalidAttempts(invalidAttempts + 1);
					em.merge(uli);
					em.flush();
					System.out.println(uli.getInvalidAttempts());
				} else {
					System.out.println("hello");
					CustomerInfo c = em.find(CustomerInfo.class, ac.getCustomerId().getCustomerId());
					System.out.println(c);
					c.setStatusId(em.find(Status.class, 4));
					em.merge(c);
					em.flush();
					
					return "Account Blocked";
				}

			} else {

				UserLoginInfo ul = new UserLoginInfo();
				ul.setCustomerId(user.getCustomerId());
				ul.setInvalidAttempts(1);
				ul.setLastLoginDateTime(dtf.format(now));
				ul.setLastLoginIpAddress(myIP.getHostAddress());
				em.persist(ul);
				em.flush();

			}

			return "Invalid Id or Password";

		} catch (Exception e) {
			return "Failure";
		}
	}

	@Override
	public CustomerInfo getCustomerDetails(UserLoginCredentials user) {
		
		AccountInfo ac = em.find(AccountInfo.class, user.getCustomerId());
		CustomerInfo c = em.find(CustomerInfo.class, ac.getCustomerId().getCustomerId());
		return c;
	}

	@Override
	public AccountInfo getAccountDetails(UserLoginCredentials user) {

		AccountInfo ac = em.find(AccountInfo.class, user.getCustomerId());
		return ac;
	}
}
