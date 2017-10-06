package com.EADB.model;

/**
 *创建时间：2017年9月20日下午3:09:19
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:LeaveEntity.java
 *类说明：
 */

public class LeaveEntity {
	private int lId;
	private String userid; //用户编号
	private String username; //用户名
	private String lReason; //请假理由
	private String lStarttime; //请假开始时间
	private String lDays;  //请假天数
	private String lLeavetype; //请假审核结果
	private String lAudittype; // 请假审核状态
	private String lCanceltype; //销假状态
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
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
	public String getlReason() {
		return lReason;
	}
	public void setlReason(String lReason) {
		this.lReason = lReason;
	}
	public String getlStarttime() {
		return lStarttime;
	}
	public void setlStarttime(String lStarttime) {
		this.lStarttime = lStarttime;
	}
	public String getlDays() {
		return lDays;
	}
	public void setlDays(String lDays) {
		this.lDays = lDays;
	}
	public String getlLeavetype() {
		return lLeavetype;
	}
	public void setlLeavetype(String lLeavetype) {
		this.lLeavetype = lLeavetype;
	}
	public String getlAudittype() {
		return lAudittype;
	}
	public void setlAudittype(String lAudittype) {
		this.lAudittype = lAudittype;
	}
	public String getlCanceltype() {
		return lCanceltype;
	}
	public void setlCanceltype(String lCanceltype) {
		this.lCanceltype = lCanceltype;
	}
	

}
