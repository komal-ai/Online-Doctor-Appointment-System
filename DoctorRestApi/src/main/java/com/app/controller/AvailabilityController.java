package com.app.controller;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Appointment;
import com.app.pojos.Date;
import com.app.pojos.Doctor;
import com.app.pojos.DoctorAvailability;
import com.app.service.IAppointmentService;
import com.app.service.IDoctorAvailabilityService;



@CrossOrigin(origins="http://localhost:4200")
@RestController //@Controller =>at class level + @Responsebody added on  the return type of all req handling method
@RequestMapping ("/slot")
public class AvailabilityController  {

	@Autowired
	IDoctorAvailabilityService  doctorAvailabilityService;
	
	@GetMapping("/{doctorId}")
	public ResponseEntity<?> getDoctorAvailabilityByDoctorId(@PathVariable Integer  doctorId ){
		System.out.println(doctorId+"  in  getAppointmentById method");
		List<DoctorAvailability>   slotDetails=doctorAvailabilityService.getDoctorAvailabilityByDoctorId(doctorId);
		   if(!slotDetails.isEmpty()) 
		    	return new  ResponseEntity<>(slotDetails,HttpStatus.OK);
		    
		     return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	

	@GetMapping("/flag/{doctorAvailabilityId}")
	public ResponseEntity<?> changeStatusByDoctorAvailabilityId(@PathVariable Integer  doctorAvailabilityId ){
		System.out.println(doctorAvailabilityId+"  in  getAppointmentById method");
		DoctorAvailability   slotDetails=doctorAvailabilityService.changeStatus(doctorAvailabilityId,true);
//		   if(!slotDetails.isEmpty()) 
	    	return new  ResponseEntity<>(slotDetails,HttpStatus.OK);
//		    
//		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/dates/{doctorId}")
	 public ResponseEntity<?> getDatesByDoctorId(@PathVariable Integer  doctorId) {
		System.out.println("  in  getAppointmentById method");
		List<LocalDate>   slotDetails=doctorAvailabilityService.getDatesByDoctorId(doctorId);
		   if(!slotDetails.isEmpty()) 
		    	return new  ResponseEntity<>(slotDetails,HttpStatus.OK);
		    
		     return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	@PostMapping()
	public  ResponseEntity<?> getTimeListBasedOnDate(@RequestBody Date date) {
		LocalDate d1=date.getDate();
		int doctorId=date.getDoctorId();
		System.out.println(d1);
		List<DoctorAvailability> timeList=doctorAvailabilityService.getTimeListBasedOnDate(doctorId,d1);
		System.out.println(date);
		  if(!timeList.isEmpty()) 
		return new  ResponseEntity<>(timeList,HttpStatus.OK);
		    return new ResponseEntity<>(null,HttpStatus.OK);
			}
	
	
//	@GetMapping("/check")
//	 public ResponseEntity<?> getDatesByDoctorId() {
//		doctorAvailabilityService.check();
//		   return new ResponseEntity<>(null,HttpStatus.OK);
//	}
	
	
}
