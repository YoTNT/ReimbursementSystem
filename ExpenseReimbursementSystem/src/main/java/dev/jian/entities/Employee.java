package dev.jian.entities;

public class Employee {

	private int eId;
	private String username;
	private String password;
	
	public Employee() {
		super();
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
