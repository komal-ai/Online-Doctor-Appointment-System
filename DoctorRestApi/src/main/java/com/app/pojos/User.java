package com.app.pojos;

public class User {
 public int patientId;
public String firstName;
public String lastName;
public Address addr;

 public User(){
		 System.out.println("in user class");
		 }

public int getPatientId() {
	return patientId;
}

public void setPatientId(int patientId) {
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

public Address getAddr() {
return addr;
}

public void setAddr(Address addr) {
	this.addr = addr;
}
 
 

}
