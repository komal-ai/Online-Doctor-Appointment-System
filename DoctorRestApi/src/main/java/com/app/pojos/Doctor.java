package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="doctors")

public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private Integer  doctorId;
	
	@Column(name="first_name",length=30)
	private String  firstName;
	
	@Column(name="last_name",length = 30)
	private String  lastName;
	
	@Column(length = 30)
	private String   email;
	
	@Column(length = 30)
	private String password;
	
	private LocalDate dob;
	
	@Column(length = 30)
    private String address;
	
	@Column(length = 12,unique=true)
	private String phone;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;
	private double fees;

	@Column(name="flag" , nullable=false , columnDefinition="boolean default false")
	private boolean flag;

	@Enumerated(EnumType.STRING) //col type varchar (enum constant name)
	@Column(name="doctor_specialization",length = 20)
	private DoctorSpecialization doctorSpecialization;
   
	//Bi-directional mapping
	@OneToMany(mappedBy = "doctor")  //mandatory : if not supplied hibernate throws MappingExc.
	  @JsonIgnore
	private List<Appointment> appointments =new ArrayList<>(); 

//	//unidirectional mapping
//	@OneToMany(cascade=CascadeType.ALL,targetEntity=DoctorAvailability.class)
//	@JoinColumn(name="dr_id",referencedColumnName="doctor_id")
//	  @JsonIgnore
//	private List<DoctorAvailability> available=new ArrayList<>();
//	
   public 	Doctor() {
	   System.out.println("in doctor constructor "+getClass().getName());
   }
	
   
   public Doctor(String firstName, String lastName, String email, String password, LocalDate dob, String address,
		String phone, Gender gender, double fees, DoctorSpecialization doctorSpecialization,boolean flag) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.dob = dob;
	this.address = address;
	this.phone = phone;
	this.gender = gender;
	this.fees = fees;
	this.doctorSpecialization = doctorSpecialization;
   this.flag=flag;

}


	public Integer getDoctorId() {
	return doctorId;
    }


    public void setDoctorId(Integer doctorId) {
	this.doctorId = doctorId;
   }


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
//	public List<DoctorAvailability> getAvailable() {
//		return available;
//	}
//
//
//	public void setAvailable(List<DoctorAvailability> available) {
//		this.available = available;
//	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
	
	


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public DoctorSpecialization getDoctorSpecialization() {
		return doctorSpecialization;
	}
	public void setDoctorSpecialization(DoctorSpecialization doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	
	
	

public List<Appointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}


	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", dob=" + dob + ", address=" + address + ", phone=" + phone
				+ ", gender=" + gender + ", fees=" + fees + ", flag=" + flag + ", doctorSpecialization="
				+ doctorSpecialization + "]";
	}



	
	
	
	
	
}



