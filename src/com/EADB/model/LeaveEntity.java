package com.EADB.model;

/**
 *����ʱ�䣺2017��9��20������3:09:19
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:LeaveEntity.java
 *��˵����
 */

public class LeaveEntity {
	private int lId;
	private String userid; //�û����
	private String username; //�û���
	private String lReason; //�������
	private String lStarttime; //��ٿ�ʼʱ��
	private String lDays;  //�������
	private String lLeavetype; //�����˽��
	private String lAudittype; // ������״̬
	private String lCanceltype; //����״̬
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
