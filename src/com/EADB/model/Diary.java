package com.EADB.model;

/**
 *创建时间：2017年9月21日下午4:04:25
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:Diary.java
 *类说明：
 */

public class Diary {
	private int dId;   //id
	private int uId;   //用户id
	private String userid;
	private String username;
	private String dTitle;   //标题
	private String dContent;   //内容
	private String dStarttime;   //开始时间
	private String dModifytime;   //最后修改时间
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
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
	public String getdTitle() {
		return dTitle;
	}
	public void setdTitle(String dTitle) {
		this.dTitle = dTitle;
	}
	public String getdContent() {
		return dContent;
	}
	public void setdContent(String dContent) {
		this.dContent = dContent;
	}
	public String getdStarttime() {
		return dStarttime;
	}
	public void setdStarttime(String dStarttime) {
		this.dStarttime = dStarttime;
	}
	public String getdModifytime() {
		return dModifytime;
	}
	public void setdModifytime(String dModifytime) {
		this.dModifytime = dModifytime;
	}
	

}
