package com.EADB.model;

/**
 *创建时间：2017年9月23日下午5:11:19
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:FileEntity.java
 *类说明：
 */

public class FileEntity {
	private int fId;
	private String userid;  //用户编号
	private String username;  //用户姓名
	private String userpic;  //图片路径
	private String fDate;  //上传时间
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
