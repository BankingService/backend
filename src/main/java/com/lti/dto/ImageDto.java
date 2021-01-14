package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImageDto {

	private int customerId;
	private MultipartFile aadharCard;
	private MultipartFile panCard;

	public ImageDto() {

	}

	public MultipartFile getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(MultipartFile aadharPic) {
		this.aadharCard = aadharPic;
	}

	public MultipartFile getPanCard() {
		return panCard;
	}

	public void setPanCard(MultipartFile panCard) {
		this.panCard = panCard;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	


}
