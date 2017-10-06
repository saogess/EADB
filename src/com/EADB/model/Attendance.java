package com.EADB.model;

/**
 *创建时间：2017年8月21日上午11:08:45
 *项目名称：2017_EADBproject
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:attendance.java
 *类说明：考勤信息的封装类。
 */

public class Attendance {
	private int id;
	private int uid;
	private String time;
	private String atype;
	private String inf;
	private String username;
	private String userid;
	//无参构造
	public Attendance() {}
	//带参构造
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
		return "{员工号："+this.userid+"--姓名："+this.username+"--签到时间："+this.time+"--签到信息："+this.inf+this.atype+"}";
	}
	
}
