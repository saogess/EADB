package com.EADB.model;

/**
 *����ʱ�䣺2017��9��20������7:58:42
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:Number.java
 *��˵����
 */

public class LeaveNum {
	private int lnId;
	private String username;
	private int lnNum=5;
	public int getLnId() {
		return lnId;
	}
	public void setLnId(int lnId) {
		this.lnId = lnId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getLnNum() {
		return lnNum;
	}
	public void setLnNum(int lnNum) {
		this.lnNum = lnNum;
	}
	
	

}
