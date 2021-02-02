package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IPatientDao;
import com.app.pojos.Patient;

@Service //to tell the container this class contains all the  business  logic
@Transactional // optional not mandatory becoz including in JpaRepository
public  class PatientServiceImpl implements IPatientService  {

	@Autowired
	IPatientDao patientDao ;
	
	
	@Override
	public List<Patient> getAllPatients() {
		return patientDao.findAll();
		
	}


	@Override
	public Optional<Patient> getPatientDetails(String patientName) {
	
		return patientDao. findByFirstName( patientName);
	}

	@Override
	public Optional<Patient> getPatientById(int patientId) {

		return patientDao.findByPatientId(patientId);   
	
  }
    
	@Override
	public	Patient getEmailAndPassword(String email,String password) {
		return patientDao.findByEmailAndPassword(email, password);
	}


	@Override
	public Patient AddPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientDao.save(patient);
	}
	
}
