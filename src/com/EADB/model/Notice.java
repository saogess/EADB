/**
*����ʱ�䣺2017-8-22����8:33:48
*��Ŀ���ƣ�
2017_EADBproject
*@author �����
*@version 1.0
*@since JDK 1.7.0_21
*�ļ�����:Notice.java
*��˵����
*/
package com.EADB.model;

public class Notice {
	private int uid;
	private String userName;
	private int id;
	private int nid;
	private String time;
	private String notice;
	private int adminid;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}




	public void setUid(int uid) {
		this.uid = uid;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public int getNid() {
		return nid;
	}




	public void setNid(int nid) {
		this.nid = nid;
	}




	public String getTime() {
		return time;
	}




	public void setTime(String time) {
		this.time = time;
	}




	public String getNotice() {
		return notice;
	}




	public void setNotice(String notice) {
		this.notice = notice;
	}




	public int getAdminid() {
		return adminid;
	}




	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}




	public String toString() {
		return this.id+"----"+this.nid+"-----"+this.time+"-----"+this.notice+"-----"+this.adminid;
	}
	
}
