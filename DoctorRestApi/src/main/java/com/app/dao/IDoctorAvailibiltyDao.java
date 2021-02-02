package com.app.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Admin;
import com.app.pojos.Appointment;
import com.app.pojos.DoctorAvailability;

public interface IDoctorAvailibiltyDao extends JpaRepository<DoctorAvailability,Integer> { 

	
	//List<DoctorAvailability> findBydoctorId(Integer doctorId); 
	
	@Query("from DoctorAvailability t where t.doctor.doctorId = :doctorId and t.flag=:flag ")
     public List<DoctorAvailability> getDoctorAvailabilityByDoctorId(@Param("doctorId") int doctorId,  boolean flag);

	DoctorAvailability findByDoctorAvailabilityId(Integer doctorAvailabilityId);
	
	@Query("select distinct t.slotDate from DoctorAvailability t where t.doctor.doctorId = :doctorId  ")
    public List<LocalDate> findDistinctBySlotDate(@Param("doctorId") int doctorId);

	@Query("select t from DoctorAvailability t where t.doctor.doctorId = :doctorId  and t.slotDate=:slotDate and t.flag=:flag")
	public  List<DoctorAvailability> findBySlotDateAndFlag(@Param ("doctorId") int doctorId, @Param("slotDate") LocalDate slotDate,@Param("flag") boolean flag);
	
	//@Query("from DoctorAvailability t where t.slotDate = :slotDate")
	//public DoctorAvailability findByStartTimeAndEndTime(@Param ("slotDate")LocalDate slotDate  ,LocalTime startTime,LocalTime endTime );

	@Query("select t from DoctorAvailability t where t.doctor.doctorId = :doctorId and  t.slotDate= :slotDate and t.startTime = :startTime and  t.endTime = :endTime")
	public DoctorAvailability  findByStartTimeAndEndTime(@Param("doctorId") int doctorId,@Param ("slotDate")LocalDate slotDate  , @Param("startTime") LocalTime startTime, @Param("endTime")  LocalTime endTime );
}
