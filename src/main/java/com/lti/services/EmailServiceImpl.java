package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl{
	
	@Autowired
	private MailSender mailSender;
	
	public void sendEmail(String toEmail, String subject, String msg) {
		try {
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("bank.24.7.365@gmail.com");
			message.setTo(toEmail);
			message.setSubject(subject);
			message.setText(msg);
			mailSender.send(message);
			System.out.println("Message sent successfully");
			
		} catch (Exception e) {
			System.out.println("Message not sent");
		}
	}
}
