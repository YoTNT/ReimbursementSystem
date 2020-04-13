package dev.jian.entities;

public class Manager {

	private int mId;
	private String name;
	private String username;
	private String password;
	
	
	public Manager() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
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
		return "Manager [mId=" + mId + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}	
}
