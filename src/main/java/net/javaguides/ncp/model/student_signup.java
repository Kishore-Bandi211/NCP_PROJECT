package net.javaguides.ncp.model;

public class student_signup {
	private String email;
	private String password;
	private String reenter; 
	private String security;
	private String name;
	private String rollnum;
	
	public String getRollnum() {
		return rollnum;
	}
	public void setRollnum(String rollnum) {
		this.rollnum = rollnum;
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
	public String getReenter() {
		return reenter;
	}
	public void setReenter(String reenter) {
		this.reenter = reenter;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
