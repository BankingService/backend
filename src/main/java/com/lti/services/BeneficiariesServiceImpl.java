package com.lti.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.BeneficiariesDTO;
import com.lti.dto.ViewAcceptedCustomers;
import com.lti.entities.Beneficiaries;
import com.lti.entities.CustomerInfo;
import com.lti.repository.BeneficiariesRepo;

@Service
public class BeneficiariesServiceImpl implements BeneficiariesService {

	@Autowired
	private BeneficiariesRepo repo;
	
	@Autowired
	private EmailServiceImpl email;
	
	@Override
	public int addBeneficiary(Beneficiaries beneficiary, int custId) {
		try {
			repo.addBeneficiary(beneficiary,custId);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public List<BeneficiariesDTO> viewBeneficiaries(int custid) {
        
        List<Beneficiaries> list = repo.viewBeneficiaries(custid);
		List<BeneficiariesDTO> bdto = new ArrayList<BeneficiariesDTO>();
        for(Beneficiaries temp : list) {
            BeneficiariesDTO b = new BeneficiariesDTO();
            b.setBeneficiaryAccountNumber(temp.getBeneficiaryAccountNumber());
            bdto.add(b);
        }
        return bdto;
	}

	@Override
	public int generateOtp(int custid) {
		int randomPin = (int) (Math.random()*9000)+1000;
		System.out.println(randomPin);
		
		CustomerInfo c = repo.getCustomerInfo(custid);
		
		String toEmail = c.getEmailId();
		
		String subject = "OTP";
		String msg = "Hi "
				+ c.getFirstName()
				+", "
				+ "\nYour OTP is : "+randomPin
				+ "\nThank You\n"
				+ "Best Regards,\n"
				+ "Bank";
		email.sendEmail(toEmail, subject, msg);
		
		return randomPin;
	}
	

}
