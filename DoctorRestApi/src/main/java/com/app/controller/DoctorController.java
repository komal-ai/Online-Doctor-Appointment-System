
package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.pojos.Doctor;
import com.app.pojos.DoctorSpecialization;
import com.app.pojos.Patient;
import com.app.pojos.User;
import com.app.service.IDoctorService;
import com.app.service.IPatientService;


@CrossOrigin(origins="http://localhost:4200")
@RestController //@Controller =>at class level + @Responsebody added on  the return type of all req handling method
@RequestMapping ("/doctors")
public class DoctorController {

	@Autowired
	private IDoctorService doctorService ;
	
	
	public	DoctorController() {
		System.out.println("in constructor of"+getClass().getName());
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> doctorLogin(@RequestBody Doctor doctor){
		   System.out.println(doctor+"dfdf");
		String email=doctor.getEmail();
        String password =doctor.getPassword();	
        System.out.println(email+password);
		if(email != null &&  !" ".equals(email)) 
			doctor = doctorService.getEmailAndPassword(email, password);
	     System.out.println(doctor);
	     if(doctor != null)
		return new  ResponseEntity<>(doctor,HttpStatus.OK);
		
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	

	@PostMapping("/unique")
	public ResponseEntity<?> doctorLogin(@RequestBody User u){
		 
	     System.out.println(u);
	     if(u != null)
		return new  ResponseEntity<>(u,HttpStatus.OK);
		
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
	
	//ResponseEntity=>entire Response packet represented by ResponseEntity
	@GetMapping
	public ResponseEntity<?> getAllDoctors(){
		
		System.out.println("in  getAllDoctors method  of"+getClass().getName());
		//empty patient list:set status code 204(no content)
		
		List<Doctor> doctors=doctorService.getAllDoctors();
		if(doctors.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
     return new  ResponseEntity<>(doctors,HttpStatus.OK);
	}
	
	
	@GetMapping("/id/{doctorId}")
	public ResponseEntity<?> getPatientById(@PathVariable Integer doctorId   ){
		
		Optional<Doctor> doctorDetails= doctorService.getDoctorById(doctorId);
		   if(doctorDetails.isPresent()) 
		    	return new  ResponseEntity<>(doctorDetails,HttpStatus.OK);
		    
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
//	
//	@GetMapping("/{doctorName}")
//	public ResponseEntity<?> getDoctorDetails(@PathVariable String doctorName ){
//		
//		   Optional<Doctor> doctortDetails= doctorService.getDoctorDetails(doctorName);
//		    if(doctortDetails.isPresent()) 
//		    	return new  ResponseEntity<>(doctortDetails,HttpStatus.OK);
//		    
//		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
//	
	
	
	
	@GetMapping("/{doctorSpecialization}")
	public ResponseEntity<?> getAllDoctorBySpecialization(@PathVariable String doctorSpecialization ){
		System.out.println(doctorSpecialization+"  in getAllDoctorBySpecialization method");
		DoctorSpecialization spec=DoctorSpecialization.valueOf(doctorSpecialization);
		   List<Doctor> doctortDetails= doctorService. findAllByDoctorSpecialization(spec,true);
		    if(!doctortDetails.isEmpty()) 
		    	return new  ResponseEntity<>(doctortDetails,HttpStatus.OK);
		    
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	//dispatcher servlet do un-marshalling/de serialization(json-->java obj)

	@PostMapping()
	public  ResponseEntity<?> AddDoctor(@RequestBody Doctor doctor) {
		System.out.println("in add doctor");
			try {
				Doctor savedDoctor=	doctorService.AddDoctor(doctor);
			return new ResponseEntity<>(savedDoctor,HttpStatus.OK);
			}
			catch(RuntimeException ex) {
				ex.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}
	
	

	
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllDoctorsbyFlag(){
		

		System.out.println("in  getAllDoctors method  of"+getClass().getName());
		//empty patient list:set status code 204(no content)
		boolean value=false;
		List<Doctor> doctors=doctorService.getDoctorsListByFlag(value);
		if(doctors.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
     return new  ResponseEntity<>(doctors,HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/doctorlist")
	public ResponseEntity<?> getAllDoctorsList(){
		
		System.out.println("in  getAllDoctors method  of"+getClass().getName());
		//empty patient list:set status code 204(no content)
		boolean value=true;
		List<Doctor> doctors=doctorService.getDoctorsListByFlag(value);
		if(doctors.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
     return new  ResponseEntity<>(doctors,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
