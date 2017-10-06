package com.EADB.model;

/**
 * 创建时间：2017年8月19日 下午2:49:01 项目名称：ZBDBProject
 * @author 李佩恒
 * @version 1.0
 * @since JDK 1.7.0_21 文件名称：Admin.java 
 * 类说明：管理员封装类。
 */
public class Admin {
	private int id;
	private String aid;
	private String adminname;
	private String apassword;
	private String gender;
	private String birthday;
	private String phonenumber;
	private String address;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return this.id+"---"+this.aid+"---"+this.adminname+"---"+this.apassword+"---"+this.gender+"---"+this.birthday+"---"+this.phonenumber+"---"+this.address;
	}
}
