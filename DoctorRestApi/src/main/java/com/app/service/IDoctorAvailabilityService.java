package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Optional;

import com.app.pojos.DoctorAvailability;

public interface IDoctorAvailabilityService {

	List<DoctorAvailability>  getDoctorAvailabilityByDoctorId(int doctorId);
	DoctorAvailability changeStatus(int doctorAvailabilityId,boolean flag);
	
	List<LocalDate>	getDatesByDoctorId(int doctorId);
	List<DoctorAvailability> getTimeListBasedOnDate(int doctorId,LocalDate date);
	
	void changeFlagAfterCancelBooking(int doctorId,LocalDate date, LocalTime startTime ,LocalTime endTime); 
}
