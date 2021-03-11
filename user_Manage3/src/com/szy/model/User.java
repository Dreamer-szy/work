package com.szy.model;

//用户实体
public class User {

	private String id;
	private String username;
	private String passwd;
	private String sex;
	private int age;
	private String profile;
	
	public User() {
		super();
	}
	
	public User( String username, String passwd) {
		super();
		this.username = username;
		this.passwd = passwd;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwd=" + passwd + ", sex=" + sex + ", age=" + age
				+ ", profile=" + profile + "]";
	}
	
	
}
