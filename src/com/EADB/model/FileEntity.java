package com.EADB.model;

/**
 *����ʱ�䣺2017��9��23������5:11:19
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:FileEntity.java
 *��˵����
 */

public class FileEntity {
	private int fId;
	private String userid;  //�û����
	private String username;  //�û�����
	private String userpic;  //ͼƬ·��
	private String fDate;  //�ϴ�ʱ��
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
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
	public String getUserpic() {
		return userpic;
	}
	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}
	public String getfDate() {
		return fDate;
	}
	public void setfDate(String fDate) {
		this.fDate = fDate;
	}
	

}
