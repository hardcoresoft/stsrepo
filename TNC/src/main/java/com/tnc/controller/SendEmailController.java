package com.tnc.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sendEmail.do")
public class SendEmailController {
 
    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${email.to}")
    String recipientAddress;
    
    @Value("${email.subject}")
    String subject;
    
    @Value("${email.message}")
    String message;
    
    @RequestMapping(method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request) {
    	
        InternetAddress[] mailAddress = null;
        List<InternetAddress> mailList = new ArrayList<InternetAddress>();
        StringTokenizer stringTokenizer = new StringTokenizer(recipientAddress, ";");
        
        try {
        	
        	mailAddress = new InternetAddress [stringTokenizer.countTokens()];
        	while (stringTokenizer.hasMoreElements()) {
        		InternetAddress address = new InternetAddress();
        		address.setAddress(stringTokenizer.nextElement().toString());
        		mailList.add(address);
    		}
        	mailAddress  = mailList.toArray(new InternetAddress[mailList.size()]);
			
			// prints debug info
			System.out.println("To: " + recipientAddress);
			System.out.println("Subject: " + subject);
			System.out.println("Message: " + message);
			
			// creates a simple e-mail object
//			SimpleMailMessage email = new SimpleMailMessage();
//			email.setTo(recipientAddress);
//			email.setSubject(subject);
//			email.setText(message);
			
			MimeMessage email = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(email, true, "UTF-8");
			helper.setTo(mailAddress);
			helper.setSubject(subject);
			helper.setText(message, true);
			helper.addAttachment("test.txt", new File(""));
//			
//			// sends the e-mail
			mailSender.send(email);
        
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/mail/Error";
		}
         
        // forwards to the view named "Result"
        return "/mail/Result";
    }
}