package com.EADB.model;

/**
 *����ʱ�䣺2017��9��26������8:25:52
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:FileInf.java
 *��˵�����ļ���Ϣ�ķ�װ��
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
		return "{��ţ�"+this.fId+"--�ļ���ţ�"+this.fNum+"--�ļ�����"+this.fName+"--�ϴ�ʱ�䣺"+this.fTime+"--�ϴ�·����"+this.fPath+
				"--�ϴ��˱�ţ�"+this.mid+"--������"+this.managername+"--ְλ��"+this.position+"}";
	}
}
