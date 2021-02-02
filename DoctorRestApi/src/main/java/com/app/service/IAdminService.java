package com.app.service;


import java.util.Optional;

import com.app.pojos.Admin;


public interface IAdminService {


	//get admin details by name
	Optional<Admin> getAdminDetails(String adminName);
	
	//find by admin id
	 Optional<Admin> getAdminById(int adminId);
	 Admin getEmailAndPassword(String email,String password);
	// Admin addAdmin( Admin admin);
	 
	
}
