package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Appointment;
import com.app.pojos.AppointmentStatus;
import com.app.pojos.DoctorAvailability;
import com.app.pojos.Patient;


public interface IAppointmentDao extends JpaRepository<Appointment,Integer> {

	Appointment findByAppointmentId(Integer appointmentId);  

	
	@Query("from Appointment t where t.patient.patientId = :patientId and t.appointmentStatus=:appointmentStatus ")
    public List<Appointment>  getAppointmentByPatientId(@Param("patientId") int patientId,@Param("appointmentStatus")  AppointmentStatus  appointmentStatus);
	
	

	@Query("from Appointment t where t.doctor.doctorId = :doctorId and t.appointmentStatus=:appointmentStatus ")
	 public List<Appointment> getAppointmentByDoctorId(@Param("doctorId") int  doctorId,@Param("appointmentStatus")AppointmentStatus  appointmentStatus);
}
