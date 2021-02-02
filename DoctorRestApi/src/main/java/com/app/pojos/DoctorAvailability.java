package com.app.pojos;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;



@Entity
@Table(name="Doctor_availability")

public class DoctorAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doctor_availability_id")
	private Integer doctorAvailabilityId; 
    
    @Enumerated(EnumType.STRING) //col type varchar (enum constant name)
	@Column(name="day_in_week",length = 20)
     private DayInWeek day;
    
    @Column(name="starting_time")
    private LocalTime startTime ;
    
    @Column(name="end_time")
    private LocalTime endTime ;
	
    @Column(name="minute_per_patient")
    private int minutePerPatient;
	
	
	private LocalDate slotDate;
	
	@ManyToOne
	@JoinColumn(name="doctorId")
	private  Doctor doctor;
	
	@Column(name="flag" , nullable=false , columnDefinition="boolean default false")
	private boolean flag;
	
	public DoctorAvailability() {
		   System.out.println("in DoctorAvailability constructor "+getClass().getName());
	}
	

	

	public DoctorAvailability(DayInWeek day, LocalTime startTime, LocalTime endTime, int minutePerPatient,boolean flag) {
		super();
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.minutePerPatient = minutePerPatient;
		this.slotDate=slotDate;
		this.flag=flag;
		
	}




	public Integer getDoctorAvailabilityId() {
		return doctorAvailabilityId;
	}




	public void setDoctorAvailabilityId(Integer doctorAvailabilityId) {
		this.doctorAvailabilityId = doctorAvailabilityId;
	}




	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public DayInWeek getDay() {
		return day;
	}

	public void setDay(DayInWeek day) {
		this.day = day;
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


    public int getMinutePerPatient() {
		return minutePerPatient;
	}



	public void setMinutePerPatient(int minutePerPatient) {
		this.minutePerPatient = minutePerPatient;
	}
  
	

	public boolean isFlag() {
		return flag;
	}




	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	


	public LocalDate getSlotDate() {
		return slotDate;
	}




	public void setSlotDate(LocalDate slotDate) {
		this.slotDate = slotDate;
	}




	@Override
	public String toString() {
		return "DoctorAvailability [doctor_availability_id=" +doctorAvailabilityId  + ", day=" + day
				+ ", starting_time=" + startTime + ", end_time=" + endTime + ", minute_per_patient="
				+ minutePerPatient + "]";
	}

	
	
	
	
	
	
}


