package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name="admin")

public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="admin_id")
	private Integer  adminId;
	@Column(length = 30,name="first_name")
	private String  firstName;
	@Column(length = 30,name="last_name")
	private String  lastName;
	@Column(length = 30,unique = true)
	private String   email;
	private String password;
	private String address;
	@Column(length = 12)
	private String phone;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;
	
	
	
	   public 	Admin() {
		   System.out.println("in doctor constructor "+getClass().getName());
	   }
	
	
	public Admin(String first_name, String last_name, String email, String password, String address, String phone,
			Gender gender) {
		super();
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}







	public Integer getAdminId() {
		return adminId;
	}


	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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
		return "Admin [admin_id=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", address=" + address + ", phone=" + phone + ", gender=" + gender
				+ "]";
	}
	
	
	
	
}
