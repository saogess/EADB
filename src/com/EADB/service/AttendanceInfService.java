package com.EADB.service;

import java.util.List;

import com.EADB.model.Attendance;

/**
 *创建时间：2017年9月21日上午8:06:01
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:AttendanceInfService.java
 *类说明：用户考勤的服务层接口
 */

public interface AttendanceInfService {
	//查询员工考勤信息。(根据员工id查询)
	public List<Attendance> findByUIdAttendanceInf(String userid);
	
	//查询全部员工考勤信息。
	public List<Attendance> findAllAttendanceInf();
	
	//删除员工考勤信息。（单条删除）
	public boolean deleteByUidAttendanceInf(String uid);
	
	//删除员工考勤信息。（清空表）
	public boolean deleteAllAttendanceInf();
	
}
