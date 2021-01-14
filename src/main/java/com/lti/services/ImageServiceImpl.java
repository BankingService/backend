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
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;

@Service
public class ImageServiceImpl implements ImageService {
	

	@Override
	public List<String> imageUpload(ImageDto images) {
		String imgUploadLocation = "D://uploads";
		
		List<MultipartFile> pics = new ArrayList<MultipartFile>();
		pics.add(images.getAadharPic());
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
				return fileName;
			}
			
			fileName.add(newFileName);
//			customerService.updateProfilePic(customerId, newFileName);
//			Status status = new Status();
//			status.setStatus(StatusType.SUCCESS);
//			status.setMessage("Profile pic updated!");
		}
		
		return fileName;
	}

}
