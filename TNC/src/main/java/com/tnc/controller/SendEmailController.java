package com.tnc.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tnc.utils.StringUtils;

@Controller
@RequestMapping("/sendEmail.do")
public class SendEmailController {
 
    @Autowired
    private JavaMailSender mailSender;
     
    @RequestMapping(method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request) {
        // takes input from e-mail form
        String recipientAddress = request.getParameter("recipient");
        String subject;
        String message; 
        
        try {
			subject = StringUtils.getThai(request.getParameter("subject"));
			message = StringUtils.getThai(request.getParameter("message")); 
			
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
			MimeMessageHelper helper = new MimeMessageHelper(email);
			helper.setTo(recipientAddress);
			helper.setSubject(subject);
			helper.setText(message, true);
			
			// sends the e-mail
			mailSender.send(email);
        
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         
        // forwards to the view named "Result"
        return "/mail/Result";
    }
}