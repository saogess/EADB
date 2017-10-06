package com.EADB.model;

/**
 *创建时间：2017年9月26日上午8:25:52
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:FileInf.java
 *类说明：文件信息的封装类
 */

public class FileInf {
	private int fId;
	private String fNum;
	private String fName;
	private String fTime;
	private String fPath;
	private int maId;
	private String mid;
	private String managername;
	private String position;
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getfNum() {
		return fNum;
	}
	public void setfNum(String fNum) {
		this.fNum = fNum;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfTime() {
		return fTime;
	}
	public void setfTime(String fTime) {
		this.fTime = fTime;
	}
	public String getfPath() {
		return fPath;
	}
	public void setfPath(String fPath) {
		this.fPath = fPath;
	}
	public int getMaId() {
		return maId;
	}
	public void setMaId(int maId) {
		this.maId = maId;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "{序号："+this.fId+"--文件编号："+this.fNum+"--文件名："+this.fName+"--上传时间："+this.fTime+"--上传路径："+this.fPath+
				"--上传人编号："+this.mid+"--姓名："+this.managername+"--职位："+this.position+"}";
	}
}
