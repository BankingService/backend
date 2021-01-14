package com.lti.services;

import javax.servlet.http.HttpServletRequest;

import com.lti.dto.ImageDto;

public interface ImageService {

	public int imageUpload(ImageDto images);
	public void imageDownload(int customerId, HttpServletRequest request);

}
