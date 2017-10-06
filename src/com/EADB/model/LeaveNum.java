package com.EADB.model;

/**
 *创建时间：2017年9月20日下午7:58:42
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:Number.java
 *类说明：
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
