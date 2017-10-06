package com.EADB.model;

/**
 *����ʱ�䣺2017��8��21������9:11:48
 *��Ŀ���ƣ�2017_EADBproject
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:manager.java
 *��˵����
 *		manager����Ϣ��װ��
 */

public class Manager {
	private int id;
	private String mid;
	private String managername;
	private String mPassword;
	private String gender;
	private String birthday;
	private String phonenumber;
	private String address;
	private String mail;
	private String pictureurl;
	private String position;
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	
	@Override
	public boolean equals(Object obj) {
		Manager manager= (Manager)obj;
		return this.id==manager.getId() && this.managername.equals(manager.getManagername());
	}
	
	@Override
	public int hashCode() {
		return this.id+this.managername.hashCode();
	}

	@Override
	public String toString() {
		return "{��ţ�"+this.id+"--���ţ�"+this.mid+"--������"+this.managername+"--���룺"+this.mPassword+"--�Ա�"+this.gender+
				"--���գ�"+this.birthday+"--�ֻ��ţ�"+this.phonenumber+"--��ַ��"+this.address+"-"+this.position+"-"+this.pictureurl+"}";
	}
	
}
