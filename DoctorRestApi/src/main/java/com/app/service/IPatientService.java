package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Doctor;
import com.app.pojos.Patient;

public interface IPatientService {
   
	//get all patients details
	List<Patient> getAllPatients();
	
	//get patient details by name
	Optional<Patient> getPatientDetails(String patientName);
	
	//find by patient id
	 Optional<Patient> getPatientById(int patientId);
	 Patient getEmailAndPassword(String email,String password);
	 Patient AddPatient(Patient  patient);
	 
}
