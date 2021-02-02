package com.app.pojos;

public class Login {

	private String email;
	private String password;
	
	public Login(){
		System.out.println("in login constructor");
	}
	
	public Login(String email,String password){
	this.email=email;
	this.password=password;
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

	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + "]";
	}
	
	
}
