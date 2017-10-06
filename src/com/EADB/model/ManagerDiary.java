package com.EADB.model;

/**
 *创建时间：2017年9月21日下午5:56:03
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:ManagerDiary.java
 *类说明：经理的日记封装包
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
		return "编号："+this.dId+"--姓名："+this.managername+"--开始时间："
				+ ""+this.dStarttime+"--修改时间："+this.dModifytime+"--标题："+this.dTitle+"--内容："+this.dContent;
	}
}
