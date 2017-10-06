package com.EADB.model;

/**
 * 创建时间：2017年8月19日 下午2:49:01 项目名称：ZBDBProject
 * @author 李佩恒
 * @version 1.0
 * @since JDK 1.7.0_21 文件名称：Admin.java 
 * 类说明：管理员封装类。
 */
public class ManagerEntity {

private int id;
	
	private String loginName;
	private String password;
	private String userName;
	private String photo;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ManagerEntity [id=" + id + ", loginName=" + loginName
				+ ", password=" + password + ", userName=" + userName
				+ ", photo=" + photo + ", email=" + email + "]";
	}
	

}
