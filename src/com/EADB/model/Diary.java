package com.EADB.model;

/**
 *����ʱ�䣺2017��9��21������4:04:25
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:Diary.java
 *��˵����
 */

public class Diary {
	private int dId;   //id
	private int uId;   //�û�id
	private String userid;
	private String username;
	private String dTitle;   //����
	private String dContent;   //����
	private String dStarttime;   //��ʼʱ��
	private String dModifytime;   //����޸�ʱ��
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
