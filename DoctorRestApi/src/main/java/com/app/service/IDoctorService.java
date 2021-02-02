package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.pojos.Doctor;
import com.app.pojos.DoctorSpecialization;


public interface IDoctorService {

	List<Doctor> getAllDoctors();
	Optional<Doctor> getDoctorDetails(String doctorName);
	Doctor getEmailAndPassword(String email,String  password);
	Doctor AddDoctor( Doctor doctor);
	Optional<Doctor> 	getDoctorById(int doctorId);
	
	List<Doctor>  getDoctorsListByFlag(boolean value);
//	List<Doctor> findAllByDoctorSpecializationAndFlag(DoctorSpecialization specialization,boolean value);
//	List<Doctor> findAllByDoctorSpecialization(DoctorSpecialization specialization);
	List<Doctor> findAllByDoctorSpecialization(DoctorSpecialization specialization,boolean flag);
}
