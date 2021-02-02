package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.pojos.Doctor;
import com.app.pojos.Patient;
import com.app.service.IPatientService;


@CrossOrigin(origins="http://localhost:4200")
@RestController //@Controller =>at class level + @Responsebody added on  the return type of all req handling method
@RequestMapping ("/patients")
public class PatientController {

	@Autowired
	private IPatientService patientService ;
	
	
	public	PatientController() {
		System.out.println("in constructor of"+getClass().getName());
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/login")
	public ResponseEntity<?> patientLogin(@RequestBody Patient patient ){
		String email=patient.getEmail();
        String password =patient.getPassword();	
		if(email != null &&  !" ".equals(email)) 
	     patient= patientService.getEmailAndPassword(email, password);
	     
	     if(patient != null)
		return new  ResponseEntity<>(patient,HttpStatus.OK);
		
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	//ResponseEntity=>entire Response packet represented by ResponseEntity
	@GetMapping
	public ResponseEntity<?> getAllPatients(){
		
		System.out.println("in getAllPatients method  of"+getClass().getName());
		//empty patient list:set status code 204(no content)
		
		List<Patient> patients=patientService.getAllPatients();
		if(patients.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
     return new  ResponseEntity<>(patients,HttpStatus.OK);
	}
	
	
	
	@RequestMapping("/  name/{patientName}")
	public ResponseEntity<?> getPatientDetails(@PathVariable String patientName ){
		
		   Optional<Patient> patientDetails= patientService.getPatientDetails(patientName);
		    if(patientDetails.isPresent()) 
		    	return new  ResponseEntity<>(patientDetails,HttpStatus.OK);
		    
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	

	@GetMapping("/{patientId}")
	public ResponseEntity<?> getPatientById(@PathVariable Integer  patientId ){
		
		Optional<Patient> patientDetails= patientService.getPatientById(patientId);
		   if(patientDetails.isPresent()) 
		    	return new  ResponseEntity<>(patientDetails,HttpStatus.OK);
		    
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//dispatcher servlet do un-marshalling/de serialization(json-->java obj)
	
		@PostMapping()
		public  ResponseEntity<?> AddPatient(@RequestBody Patient patient ) {
			System.out.println("in add patient");
				try {
					Patient savedPatient=	patientService.AddPatient(patient);
				return new ResponseEntity<>(savedPatient,HttpStatus.OK);
				}
				catch(RuntimeException ex) {
					ex.printStackTrace();
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			
		}
	
	
}
