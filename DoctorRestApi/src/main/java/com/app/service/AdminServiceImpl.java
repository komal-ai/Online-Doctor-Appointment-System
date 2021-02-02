package com.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin;
import com.app.pojos.Patient;


@Service
@Transactional

public class AdminServiceImpl  implements IAdminService{
	
	@Autowired
	private IAdminDao adminDao ;
	
	

	@Override
	public Optional<Admin> getAdminDetails(String adminName) {
	
		return adminDao. findByFirstName(adminName );
	}

	
	@Override
	public Optional<Admin> getAdminById(int adminId) {
		// TODO Auto-generated method stub
		return adminDao.findByAdminId(adminId);   
	}
	
	


	@Override
	public Admin getEmailAndPassword(String email, String password) {
	
		
		return adminDao.findByEmailAndPassword(email, password);
	
	}

//	@Override
//	public Admin addAdmin(Admin admin) {
//		// TODO Auto-generated method stub
//		return  adminDao.save(admin);
//	}
//	

}
