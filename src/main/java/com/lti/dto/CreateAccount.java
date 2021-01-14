package com.lti.dto;

import com.lti.entities.CustomerInfo;

public class CreateAccount {

	private CustomerInfo customerInfo;
	private ImageDto images;

	public CreateAccount() {

	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public ImageDto getImages() {
		return images;
	}

	public void setImages(ImageDto images) {
		this.images = images;
	}

}
