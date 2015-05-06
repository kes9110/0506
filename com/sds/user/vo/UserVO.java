package com.sds.user.vo;

public class UserVO {
	private String ID, password, name, role;

	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserVO(String iD, String password, String name, String role) {
		super();
		ID = iD;
		this.password = password;
		this.name = name;
		this.role = role;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserVO [ID=" + ID + ", password=" + password + ", name=" + name
				+ ", role=" + role + "]";
	}
	
	
	

}
