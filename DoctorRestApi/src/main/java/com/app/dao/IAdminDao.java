package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;

public interface IAdminDao  extends JpaRepository<Admin,Integer> {

	Optional<Admin>  findByFirstName(String adminName);
	Optional<Admin> findByAdminId(Integer adminId);
	
	Admin  findByEmailAndPassword(String email,String password );  
}
