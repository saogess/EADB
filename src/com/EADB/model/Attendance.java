package com.EADB.model;

/**
 *����ʱ�䣺2017��8��21������11:08:45
 *��Ŀ���ƣ�2017_EADBproject
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:attendance.java
 *��˵����������Ϣ�ķ�װ�ࡣ
 */

public class Attendance {
	private int id;
	private int uid;
	private String time;
	private String atype;
	private String inf;
	private String username;
	private String userid;
	//�޲ι���
	public Attendance() {}
	//���ι���
	public Attendance(int id,String userid,String username,String time,String atype,String inf) {
		this.uid=id;
		this.userid=userid;
		this.username=username;
		this.time=time;
		this.atype=atype;
		this.inf=inf;
	}
	
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public String getInf() {
		return inf;
	}
	public void setInf(String inf) {
		this.inf = inf;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{Ա���ţ�"+this.userid+"--������"+this.username+"--ǩ��ʱ�䣺"+this.time+"--ǩ����Ϣ��"+this.inf+this.atype+"}";
	}
	
}
