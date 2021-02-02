package com.app.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.pojos.Admin;
import com.app.pojos.Patient;
import com.app.service.IAdminService;



@CrossOrigin(origins="http://localhost:4200")
@RestController //@Controller =>at class level + @Responsebody added on  the return type of all req handling method
@RequestMapping ("/admin")
public class AdminController {

        @Autowired
		private IAdminService adminService ;
		
		
		public	AdminController() {
			System.out.println("in constructor of"+getClass().getName());
		}
		
		
		@CrossOrigin(origins="http://localhost:4200")
		@PostMapping("/login")
		public ResponseEntity<?> adminLogin(@RequestBody Admin admin ){
			String email=admin.getEmail();
	        String password =admin.getPassword();
	        if(email != null &&  !" ".equals(email)) 
             admin= adminService.getEmailAndPassword(email, password);
			System.out.println(admin + "iiiixxXXXX");
		     if(admin!=null) { 
		    	 System.out.println(admin + "iiiixxXXXX");
			return new  ResponseEntity<>(admin,HttpStatus.OK);
		     }
			
		   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
//		
//		public ResponseEntity<?> patientLogin(@RequestBody Patient patient ){
//			String email=patient.getEmail();
//	        String password =patient.getPassword();	
//			if(email != null &&  !" ".equals(email)) 
//		     patient= patientService.getEmailAndPassword(email, password);
//		     
//		     if(patient != null)
//			return new  ResponseEntity<>(patient,HttpStatus.OK);
//			
//		   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		
		
		
		
		
		
		
		
		
		
		@RequestMapping("/  name/{patientName}")
		public ResponseEntity<?> getAdminDetails(@PathVariable String  adminName){
			
			   Optional<Admin> adminDetails= adminService.getAdminDetails(adminName);
			    if(adminDetails.isPresent()) 
			    	return new  ResponseEntity<>(adminDetails,HttpStatus.OK);
			    
			     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		

		@GetMapping("/{adminId}")
  		public ResponseEntity<?> getPatientById(@PathVariable Integer  adminId ){
			
			Optional<Admin> adminDetails= adminService.getAdminById(adminId);
			   if(adminDetails.isPresent()) 
			    	return new  ResponseEntity<>(adminDetails,HttpStatus.OK);
			    
			     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		

	
		
	}

	



