package com.szy.model;

//用户信息
public class Info {
	private String c_id;
	private String c_name;
	private String c_passwd;
	private String c_sex=null;
	private String c_age;
	private String c_profile;
	
	public Info() {
		super();
	}
	
	public Info(String c_name, String c_sex) {
		super();
		this.c_name = c_name;
		this.c_sex = c_sex;
	}

	public Info(String c_name, String c_passwd, String c_sex, String c_age, String c_profile) {
		super();
		this.c_name = c_name;
		this.c_passwd = c_passwd;
		this.c_sex = c_sex;
		this.c_age = c_age;
		this.c_profile = c_profile;
	}
	
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_passwd() {
		return c_passwd;
	}
	public void setC_passwd(String c_passwd) {
		this.c_passwd = c_passwd;
	}
	public String getC_sex() {
		return c_sex;
	}
	public void setC_sex(String c_sex) {
		this.c_sex = c_sex;
	}
	public String getC_age() {
		return c_age;
	}
	public void setC_age(String c_age) {
		this.c_age = c_age;
	}
	public String getC_profile() {
		return c_profile;
	}
	public void setC_profile(String c_profile) {
		this.c_profile = c_profile;
	}
}
