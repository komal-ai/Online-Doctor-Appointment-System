package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDoctorAvailibiltyDao;
import com.app.pojos.DoctorAvailability;


@Service
@Transactional

public class DoctorAvailabilityServiceImpl implements IDoctorAvailabilityService {
	
	@Autowired
	IDoctorAvailibiltyDao doctorAvailibiltyDao;
	
	@Override
	public List<DoctorAvailability> getDoctorAvailabilityByDoctorId(int doctorId) {
		
		return	 doctorAvailibiltyDao.getDoctorAvailabilityByDoctorId(doctorId,false); 
	}

	@Override
	public DoctorAvailability changeStatus(int doctorAvailabilityId, boolean flag) {
		DoctorAvailability d=	doctorAvailibiltyDao.findByDoctorAvailabilityId(doctorAvailabilityId);
		d.setFlag(flag);
   	return doctorAvailibiltyDao.save(d);
	}

	@Override
	public List<LocalDate> getDatesByDoctorId(int doctorId) {
		return doctorAvailibiltyDao.findDistinctBySlotDate(doctorId);
	}

	@Override
	public List<DoctorAvailability> getTimeListBasedOnDate(int doctorId,LocalDate date) {
		// TODO Auto-generated method stub
		List<DoctorAvailability> list= doctorAvailibiltyDao.findBySlotDateAndFlag( doctorId,date,false);
		for(DoctorAvailability l:list)
			System.out.println(l);
		return list;
	}

	@Override
	public void changeFlagAfterCancelBooking(int doctorId,LocalDate date, LocalTime startTime ,LocalTime endTime) {
		
		DoctorAvailability d=	doctorAvailibiltyDao.findByStartTimeAndEndTime(doctorId,date,startTime,endTime);
		System.out.println(d );
		d.setFlag(false);
		doctorAvailibiltyDao.save(d);
		
		
	}
	
	

}
