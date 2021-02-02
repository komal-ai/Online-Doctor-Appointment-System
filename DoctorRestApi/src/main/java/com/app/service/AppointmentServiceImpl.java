package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAppointmentDao;
import com.app.pojos.Appointment;
import com.app.pojos.AppointmentStatus;
import com.app.pojos.Patient;


@Service //to tell the container this class contains all the  business  logic
@Transactional // optional not mandatory becoz including in JpaRepository
public class AppointmentServiceImpl implements IAppointmentService{
	
	@Autowired
	IAppointmentDao appointmentDao;
	
	@Autowired
	IDoctorAvailabilityService  doctorAvailabilityService;

	@Override
	public 	Appointment  getAppointmentById(int appointmentId) {
		

		return appointmentDao. findByAppointmentId(appointmentId);
	}

	@Override
	public Appointment addAppointmentDetails(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointmentDao.save(appointment) ;
	}

	@Override
	public List<Appointment> getAppointmentListByPatientId(int patientId) {
		// TODO Auto-generated method stub
		AppointmentStatus app=AppointmentStatus.CONFIRM;
		return appointmentDao.getAppointmentByPatientId(patientId,app);
	}

	@Override
	public Appointment cancelAppointment(int appointmentId) {
		Appointment appointment=appointmentDao.findByAppointmentId(appointmentId);
	
		int doctorId=appointment.getDoctor().getDoctorId();
		doctorAvailabilityService.changeFlagAfterCancelBooking(doctorId,appointment.getAppointmentDate(),appointment.getStartTime(),appointment.getEndTime());
		
		appointment.setAppointmentStatus(AppointmentStatus.CANCEL);
		return appointmentDao.save(appointment);
	
	}

	@Override
	public List<Appointment> getPatientAppointmentListByDoctorId(int doctorId) {
		AppointmentStatus app=AppointmentStatus.CONFIRM;
		return appointmentDao.getAppointmentByDoctorId(doctorId,app);

	}

	
	
   
	
}
