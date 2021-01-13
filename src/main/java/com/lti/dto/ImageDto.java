package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImageDto {

	private int customerId;
	private MultipartFile aadharPic;
	private MultipartFile panCard;

	public ImageDto() {

	}

	public MultipartFile getAadharPic() {
		return aadharPic;
	}

	public void setAadharPic(MultipartFile aadharPic) {
		this.aadharPic = aadharPic;
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
