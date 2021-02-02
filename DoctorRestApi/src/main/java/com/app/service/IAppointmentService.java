package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.pojos.Appointment;


public interface IAppointmentService {
	
	
	Appointment  getAppointmentById(int appointmentId);
	Appointment	addAppointmentDetails( Appointment appointment);
	List<Appointment>   getAppointmentListByPatientId(int patientId);
	Appointment  cancelAppointment(int appointmentId);
	List<Appointment>  getPatientAppointmentListByDoctorId(int doctorId);
	
}
