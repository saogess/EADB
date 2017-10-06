package com.EADB.model;

/**
 *创建时间：2017年9月18日上午9:59:22
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:UserEntity.java
 *类说明：
 */

public class UserEntity {
	private int uId;
	private String userid;
	private String username;
	private String userpassword;
	private String usergender;
	private String useremail;
	private String userphone;
	private String userbirthday;
	private String useraddress;
	private String userdept;
	private String userpicUrl;
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUsergender() {
		return usergender;
	}
	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUserbirthday() {
		return userbirthday;
	}
	public void setUserbirthday(String userbirthday) {
		this.userbirthday = userbirthday;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	
	public String getUserdept() {
		return userdept;
	}
	public void setUserdept(String userdept) {
		this.userdept = userdept;
	}
	public String getUserpicUrl() {
		return userpicUrl;
	}
	public void setUserpicUrl(String userpicUrl) {
		this.userpicUrl = userpicUrl;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	

}
