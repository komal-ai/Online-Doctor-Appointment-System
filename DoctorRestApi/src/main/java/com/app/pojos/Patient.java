package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="patients")

public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  patientId;
	
	@Column(name="first_name",length = 30)
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
	   //bi dir association between Patient 1<----->* Appointment
		@OneToMany(mappedBy = "patient",cascade=CascadeType.ALL)  //mandatory : if not supplied hibernate throws MappingExc.
		//mappedBy --name of asso property as it appeas in the owning side.
		  @JsonIgnore
		List<Appointment> appointments =new ArrayList<>(); 
	
	
	 public List<Appointment> getAppointments() {
			return appointments;
		}

		public void setAppointments(List<Appointment> appointments) {
			this.appointments = appointments;
		}

	public Patient() {
		 System.out.println("in patient constructor "+getClass().getName());
	 }

	public Patient(String firstName, String lastName, String email, String password, LocalDate dob,
			String address, String phone, Gender gender) {
		super();
	    this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}

     public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
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
	 
	@Override
	public String toString() {
		return "Patient [patient_id=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", dob=" + dob + ", address=" + address + ", phone=" + phone
				+ ", gender=" + gender + "]";
	}
	 
	 
}
