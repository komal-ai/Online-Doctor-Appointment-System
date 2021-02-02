package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

  @Entity
  @Table(name="appointments")
  public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private Integer appointmentId ;
	
	@Column(name="start_time")
    private  LocalTime startTime;
	
	@Column(name="end_time")
	private LocalTime endTime;
	
	private LocalDate appointmentDate;
	
   @Enumerated(EnumType.STRING)
   @Column(name="appointment_status",length=20)
	private AppointmentStatus  appointmentStatus ;
   
	private String feedback;
	
	@ManyToOne
	@JoinColumn(name ="patient_id",nullable = false)
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name ="doctor_id",nullable = false)
	private Doctor doctor;
	
	public Appointment() {
		   System.out.println("in appointment constructor "+getClass().getName());
	}

	public Appointment(LocalTime startTime, LocalTime endTime, LocalDate appointmentDate,
			AppointmentStatus appointmentStatus, String feedback) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
		this.feedback = feedback;
	}

	
	



	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}




	public Patient getPatient() {
		return patient;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointmentId + ", start_time=" + startTime + ", end_time=" + endTime
				+ ", appointmentDate=" + appointmentDate + ", appointmentStatus=" + appointmentStatus + ", feedback="
				+ feedback + "]";
	}

	
	
	
	
}



