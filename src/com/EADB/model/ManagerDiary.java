package com.EADB.model;

/**
 *����ʱ�䣺2017��9��21������5:56:03
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:ManagerDiary.java
 *��˵����������ռǷ�װ��
 */

public class ManagerDiary {
	private int dId;
	private int managerId;
	private String dTitle;
	private String dContent;
	private String dStarttime;
	private String dModifytime;
	private String mid;
	private String managername;
	public String getdTitle() {
		return dTitle;
	}
	public void setdTitle(String dTitle) {
		this.dTitle = dTitle;
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
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
	@Override
	public String toString() {
		return "��ţ�"+this.dId+"--������"+this.managername+"--��ʼʱ�䣺"
				+ ""+this.dStarttime+"--�޸�ʱ�䣺"+this.dModifytime+"--���⣺"+this.dTitle+"--���ݣ�"+this.dContent;
	}
}
