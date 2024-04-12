package com.example.demo;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	private final JavaMailSender mailSender;
	
	public EmailService(JavaMailSender javaMailSender) {
		this.mailSender = javaMailSender;
	}

	public void sendEmail(Email email) {
		var message = new SimpleMailMessage();
		message.setFrom("noreply@email.com");
		message.setTo(email.to());
		message.setSubject(email.subject());
		message.setText(email.body());
		mailSender.send(message);
	}
}
