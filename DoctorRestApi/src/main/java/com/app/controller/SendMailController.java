package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.pojos.*;
import com.app.service.IDoctorService;

@Controller
@RequestMapping("/email")
@CrossOrigin(origins="http://localhost:4200")
public class SendMailController {
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private IDoctorService doctorService ;
	
//	@RequestMapping
//	public String showForm(Email e)
//	{
//	//	m.addAttribute(new Email());
//		return "send_mail";
//	}
	@PostMapping
	public String processForm( Email em,BindingResult res)
	{
		System.out.println(em.getDestEmail()+"  "+em.getMessage());
		SimpleMailMessage mesg=new SimpleMailMessage();
//		mesg.setTo(em.getDestEmail());
//		mesg.setSubject(em.getSubject());
//		mesg.setText(em.getMessage());
//		sender.send(mesg);
		mesg.setTo("gayatrisharma0513@gmail.com");
		
		mesg.setSubject("check mail");
		mesg.setText("successfull");
		sender.send(mesg);
		return "sent-mail";
	}

	@PostMapping("/doctor")
	public ResponseEntity<?> processForm(@RequestBody Doctor doctor ){
		Doctor d =null;
		String email=doctor.getEmail();
        String password =doctor.getPassword();	
        System.out.println(email+password);
        doctor.setFlag(true);
        System.out.println(doctor.isFlag());
        d=doctorService.AddDoctor(doctor);
        System.out.println(d);
    	SimpleMailMessage mesg=new SimpleMailMessage();
//		mesg.setTo(em.getDestEmail());
//		mesg.setSubject(em.getSubject());
//		mesg.setText(em.getMessage());
//		sender.send(mesg);
	mesg.setTo("latika1995singh@gmail.com");
		
		mesg.setSubject("Approval To login");
		mesg.setText("Thank You For your patience while we are working on it .You are approved to login your email-Id  "+email +"  password  "+password);
		sender.send(mesg);
		return  new ResponseEntity<>(doctor,HttpStatus.OK);
    	
    	
    	
	}
	
	
	
}
