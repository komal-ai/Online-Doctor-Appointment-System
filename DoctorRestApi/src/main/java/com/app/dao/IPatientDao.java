package com.app.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Patient;


public interface IPatientDao extends JpaRepository<Patient,Integer> {

//List<Patient> findAll();
	
//search by patient name
Optional<Patient>  findByFirstName(String patientName);
Optional<Patient> findByPatientId(Integer patientId);  
Patient  findByEmailAndPassword(String email,String password   );  

}
