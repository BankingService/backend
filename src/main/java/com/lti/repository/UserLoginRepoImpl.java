package com.lti.repository;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entities.AccountInfo;
import com.lti.entities.CustomerAddress;
import com.lti.entities.CustomerDocs;
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
//		System.out.println(user.getCustomerId());
//		System.out.println(user.getLoginPassword());
		// AccountInfo ac = em.find(AccountInfo.class, user.getCustomerId());
		return em.find(UserLoginCredentials.class, user.getCustomerId()) != null ? 1 : 0;
	}

	@Override
	public int checkCredentials(UserLoginCredentials user) {
		// AccountInfo ac = em.find(AccountInfo.class, user.getCustomerId());
//		List<UserLoginCredentials> i = null;
		int i = 0;
		CustomerInfo c = em.find(CustomerInfo.class, user.getCustomerId().getCustomerId().getCustomerId());
		if (c.getStatusId().getStatusId() == 2) {
			UserLoginCredentials ulc = em.find(UserLoginCredentials.class, user.getCustomerId());
			if (ulc.getLoginPassword().equals(user.getLoginPassword())) {
				i = 1;
			}
//		i = em.createQuery("from UserLoginCredentials u where u.customerId =:id and u.loginPassword =:pass",
//						UserLoginCredentials.class)
//				.setParameter("id", user.getCustomerId()).setParameter("pass", user.getLoginPassword()).getResultList();
		}
		if (i == 1) {
			System.out.println("Size " + i);
			int size = i;
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

			// AccountInfo ac = em.find(AccountInfo.class, user.getCustomerId());
			UserLoginInfo res = em.find(UserLoginInfo.class, user.getCustomerId());

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
//			System.out.println(dtf.format(now));

			InetAddress myIP = InetAddress.getLocalHost();
//			System.out.println(myIP.getHostAddress());

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
//		System.out.println("Account Info : "+ac);
		return ac;

	}

	@Override
	public String updateLoginInfoInvalidAttempts(UserLoginCredentials user) {

		try {
			AccountInfo ac = em.find(AccountInfo.class, user.getCustomerId());
			UserLoginInfo uli = em.find(UserLoginInfo.class, user.getCustomerId());

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
//			System.out.println(dtf.format(now));

			InetAddress myIP = InetAddress.getLocalHost();
//			System.out.println(myIP.getHostAddress());

			if (uli != null) {

				int invalidAttempts = uli.getInvalidAttempts();
				System.out.println(invalidAttempts);
				if (invalidAttempts < 3) {
					uli.setInvalidAttempts(invalidAttempts + 1);
					em.merge(uli);
					em.flush();
					System.out.println(uli.getInvalidAttempts());
				} else {
//					System.out.println("hello");
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

	@Override
	public CustomerInfo getCustomerInfo(int custid) {
		CustomerInfo c = em.find(CustomerInfo.class, custid);
		return c;
	}

	@Override
	public CustomerInfo getCustomerInfo(String accNo) {
		AccountInfo ac = em.createQuery("from AccountInfo a where a.accountNumber=: acc", AccountInfo.class)
				.setParameter("acc", accNo).getSingleResult();
		CustomerInfo c = em.find(CustomerInfo.class, ac.getCustomerId().getCustomerId());
		return c;
	}

	@Override
	public void updateUserLoginCredentials(int custid, String loginPassword, String transactionPassword) {
		CustomerInfo custInfo = em.find(CustomerInfo.class, custid);
//		System.out.println("hello2");
		AccountInfo a = em.find(AccountInfo.class, custInfo.getCustomerId());
//		System.out.println("hello3");
		UserLoginCredentials u = em.find(UserLoginCredentials.class, a);
		u.setLoginPassword(loginPassword);
		u.setTransactionPassword(transactionPassword);
		em.merge(u);
		em.flush();
	}

	@Override
	public int verifyCustomerId(int custid) {
		CustomerInfo custInfo = em.find(CustomerInfo.class, custid);
//		System.out.println("hello2");
		AccountInfo a = em.find(AccountInfo.class, custInfo.getCustomerId());
//		System.out.println("hello3");
		return em.find(UserLoginCredentials.class, a) != null ? 1 : 0;
	}

	@Override
	public int verifyAccountNumber(String accNo) {
		System.out.println("hello4");
		return em.createQuery("from AccountInfo a where a.accountNumber=: acc", AccountInfo.class)
				.setParameter("acc", accNo).getSingleResult() != null ? 1 : 0;
	}

//	@Override
//	public CustomerInfo editCustomerInfo(CustomerInfo custInfo) {
//
//		CustomerInfo c = em.find(CustomerInfo.class, custInfo.getCustomerId());
//		CustomerDocs docs = new CustomerDocs();
//		docs.setAadharCard(c.getCustomerDoc().getAadharCard());
//		docs.setPanCard(c.getCustomerDoc().getPanCard());
//		custInfo.setCustomerDoc(docs);
//		custInfo.setApprovedBy(c.getApprovedBy());
//		custInfo.setStatusId(c.getStatusId());
//		
//		
//		em.merge(custInfo);
//		em.flush();
//		return c;
//	}

	@Override
	public CustomerInfo editCustomerInfo(CustomerInfo custInfo) {

		CustomerInfo c = em.find(CustomerInfo.class, custInfo.getCustomerId());

		CustomerDocs docs = new CustomerDocs();
		docs.setAadharCard(c.getCustomerDoc().getAadharCard());
		docs.setPanCard(c.getCustomerDoc().getPanCard());

		custInfo.setTitle(c.getTitle());
		custInfo.setFirstName(c.getFirstName());
		custInfo.setMiddleName(c.getMiddleName());
		custInfo.setLastName(c.getLastName());
		custInfo.setFatherName(c.getFatherName());
		custInfo.setDateOfBirth(c.getDateOfBirth());

		custInfo.setAadharCardNo(c.getAadharCardNo());
		custInfo.setPanNumber(c.getPanNumber());

		custInfo.setCustomerDoc(docs);
		custInfo.setApprovedBy(c.getApprovedBy());
		custInfo.setStatusId(c.getStatusId());

		if (custInfo.getMobileNumber() == 0)
			custInfo.setMobileNumber(c.getMobileNumber());
		if (custInfo.getEmailId().isEmpty())
			custInfo.setEmailId(c.getEmailId());

		CustomerAddress add = new CustomerAddress();
		
		if (custInfo.getAddress().getcAddressLine1().isEmpty())
			add.setcAddressLine1(c.getAddress().getcAddressLine1());
		else
			add.setcAddressLine1(custInfo.getAddress().getcAddressLine1());

		if (custInfo.getAddress().getcAddressLine2().isEmpty())
			add.setcAddressLine2(c.getAddress().getcAddressLine2());
		else
			add.setcAddressLine2(custInfo.getAddress().getcAddressLine2());

		if (custInfo.getAddress().getcCity().isEmpty())
			add.setcCity(c.getAddress().getcCity());
		else
			add.setcCity(custInfo.getAddress().getcCity());

		if (custInfo.getAddress().getcLandMark().isEmpty())
			add.setcLandMark(c.getAddress().getcLandMark());
		else
			add.setcLandMark(custInfo.getAddress().getcLandMark());

		if (custInfo.getAddress().getcPincode() != 0)
			add.setcPincode(custInfo.getAddress().getcPincode());
		else
			add.setcPincode(c.getAddress().getcPincode());

		if (custInfo.getAddress().getcState().isEmpty())
			add.setcState(c.getAddress().getcState());
		else
			add.setcState(custInfo.getAddress().getcState());

		if (custInfo.getAddress().getpAddressLine1().isEmpty())
			add.setpAddressLine1(c.getAddress().getpAddressLine1());
		else
			add.setpAddressLine1(custInfo.getAddress().getpAddressLine1());

		if (custInfo.getAddress().getpAddressLine2().isEmpty())
			add.setpAddressLine2(c.getAddress().getpAddressLine2());
		else
			add.setpAddressLine2(custInfo.getAddress().getpAddressLine2());

		if (custInfo.getAddress().getpCity().isEmpty())
			add.setpCity(c.getAddress().getpCity());
		else
			add.setpCity(custInfo.getAddress().getpCity());

		if (custInfo.getAddress().getpLandMark().isEmpty())
			add.setpLandMark(c.getAddress().getpLandMark());
		else
			add.setpLandMark(custInfo.getAddress().getpLandMark());

		if (custInfo.getAddress().getpPincode() != 0)
			add.setpPincode(custInfo.getAddress().getpPincode());
		else
			add.setpPincode(c.getAddress().getpPincode());

		if (custInfo.getAddress().getpState().isEmpty())
			add.setpState(c.getAddress().getpState());
		else
			add.setpState(custInfo.getAddress().getpState());

		custInfo.setAddress(add);

		if (custInfo.getOccupationType().isEmpty())
			custInfo.setOccupationType(c.getOccupationType());

		if (custInfo.getSourceOfIncome().isEmpty())
			custInfo.setSourceOfIncome(c.getSourceOfIncome());

		if (custInfo.getGrossAnnualIncome() == 0)
			custInfo.setGrossAnnualIncome(c.getGrossAnnualIncome());

		em.merge(custInfo);
		em.flush();
		return c;
	}

	@Override
	public int verifyProfilePassword(int custid, String profilePassword) {

		CustomerInfo custInfo = em.find(CustomerInfo.class, custid);
		AccountInfo a = em.find(AccountInfo.class, custInfo.getCustomerId());
		UserLoginCredentials u = em.find(UserLoginCredentials.class, a);
		return em
				.createQuery("from UserLoginCredentials ulc where ulc.customerId =: id and ulc.profilePassword =: pass",
						UserLoginCredentials.class)
				.setParameter("id", u.getCustomerId()).setParameter("pass", profilePassword).getSingleResult() != null
						? 1
						: 0;
	}

	@Override
	public UserLoginInfo getLogoutDetails(int custid) {

		CustomerInfo custInfo = em.find(CustomerInfo.class, custid);
		AccountInfo a = em.find(AccountInfo.class, custInfo.getCustomerId());
		UserLoginInfo u = em.find(UserLoginInfo.class, a);
		return em.createQuery("from UserLoginInfo uli where uli.customerId =: id", UserLoginInfo.class)
				.setParameter("id", u.getCustomerId()).getSingleResult();
	}

	@Override
	public AccountInfo getAccount(int customerId) {
		AccountInfo ai = em.find(AccountInfo.class, customerId);
		return ai;
	}

	@Override
	public UserLoginCredentials getCredentials(AccountInfo ai) {
		UserLoginCredentials user = em.find(UserLoginCredentials.class, ai);
		em.detach(user);
		return user;
	}

	@Override
	public String getUserAttempt(UserLoginCredentials user) {
		UserLoginInfo uli = em.find(UserLoginInfo.class, user.getCustomerId());
		int res = 3 - uli.getInvalidAttempts();
		return String.valueOf(res);
	}
}
