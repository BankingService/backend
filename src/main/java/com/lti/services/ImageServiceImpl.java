package com.lti.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lti.dto.ImageDto;
import com.lti.entities.ApplicationReference;
import com.lti.entities.CustomerDocs;
import com.lti.entities.CustomerInfo;
import com.lti.repository.CreateAccountRepo;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	CreateAccountRepo createAccount;
	
	@Autowired
	EmailServiceImpl email;
	

	@Override
	public int imageUpload(ImageDto images) {
		
		CustomerInfo customerInfo = createAccount.getCustomer(images.getCustomerId());
		
		String imgUploadLocation = "D://uploads/";
		List<MultipartFile> pics = new ArrayList<MultipartFile>();
		pics.add(images.getAadharCard());
		pics.add(images.getPanCard());
		
		List<String> fileName = new ArrayList<>();
		
		for(MultipartFile file : pics) {
			String uploadedFileName = file.getOriginalFilename();
			String newFileName =  (int)Math.random()+ "-" + uploadedFileName;
			String targetFileName = imgUploadLocation + newFileName;
			
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(targetFileName));
			} catch(IOException e) {
				e.printStackTrace(); //hoping no error would occur
//				Status status = new Status();
//				status.setStatus(StatusType.FAILURE);
//				status.setMessage("File upload failed!");
				return 0;
			}			
			fileName.add(newFileName);
//			customerService.updateProfilePic(customerId, newFileName);
//			Status status = new Status();
//			status.setStatus(StatusType.SUCCESS);
//			status.setMessage("Profile pic updated!");
		}
		CustomerDocs docs = new CustomerDocs();
//		System.out.println(fileName.get(0));
		docs.setAadharCard(fileName.get(0));
		docs.setPanCard(fileName.get(1));
		customerInfo.setCustomerDoc(docs);
		
		ApplicationReference apr = createAccount.completeAccount(customerInfo);
		String toEmail = customerInfo.getEmailId();
		System.out.println(apr.getRefernceId());
		String subject = "Account Creation Request";
		String msg = "Hi " + customerInfo.getFirstName() + ",\nCongratulations!!"
				+ "\nYour account opening request is registered successfully.\n"
				+ "Please not down this Reference Id: " + apr.getRefernceId() + " to check your status.\n"
				+ "Thank You\n" + "Regards\n" + "Bank";
		email.sendEmail(toEmail, subject, msg);
		return apr.getRefernceId();
	}

}
