package com.app.controller;

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
import com.app.pojos.Patient;
import com.app.service.IAppointmentService;
import com.app.service.IDoctorAvailabilityService;


@CrossOrigin(origins="http://localhost:4200")
@RestController //@Controller =>at class level + @Responsebody added on  the return type of all req handling method
@RequestMapping ("/app")
public class AppointmentController {

	
	@Autowired
	IAppointmentService appointmentService;
	
	@Autowired
	IDoctorAvailabilityService  doctorAvailabilityService;
	

	@GetMapping("/{appointmentId}")
	public ResponseEntity<?> getAppointmentById(@PathVariable Integer  appointmentId ){
		System.out.println(appointmentId+"  in  getAppointmentById method");
		Appointment patientDetails= appointmentService.getAppointmentById(appointmentId);
		   if(patientDetails != null) 
		    	return new  ResponseEntity<>(patientDetails,HttpStatus.OK);
		    
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping()
	public ResponseEntity<?> addAppointmentDetails(@RequestBody Appointment appointment)
	{  
		
		
		Appointment app=  appointmentService. addAppointmentDetails(appointment); 
		return ResponseEntity.ok(app);		
	}
	
	@GetMapping("/user/{patientId}")
	public ResponseEntity<?> getAppointmentListByPatientId(@PathVariable Integer  patientId ){
		System.out.println(patientId+"  in  getAppointmentByPatientId method");
		List<Appointment> appointmentList= appointmentService.getAppointmentListByPatientId(patientId);
		   if(!appointmentList.isEmpty() ) 
		    	return new  ResponseEntity<>(appointmentList,HttpStatus.OK);
		    
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/cancel/{appointmentId}")
	public ResponseEntity<?> cancelAppointmentByAppoitmentId(@PathVariable Integer  appointmentId ){
		System.out.println(appointmentId+"  in  cancel appointment  method");
		 Appointment appointment= appointmentService.cancelAppointment(appointmentId);
		   if(appointment !=null ) 
		    	return new  ResponseEntity<>(appointment,HttpStatus.OK);
		    
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
   

	@GetMapping("/patientlist/{doctorId}")
	public ResponseEntity<?> getPatientAppointmentListByDoctorId(@PathVariable Integer  doctorId ){
		System.out.println(doctorId+"  in  getPatientListByDoctorId method");
		List<Appointment> appointmentList= appointmentService.getPatientAppointmentListByDoctorId(doctorId);
		   if(!appointmentList.isEmpty() ) 
		    	return new  ResponseEntity<>(appointmentList,HttpStatus.OK);
		    
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	

}
