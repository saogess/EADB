package com.EADB.dao;

import java.util.List;

import com.EADB.model.Attendance;
import com.EADB.model.UserEntity;

/**
 *创建时间：2017年9月21日上午7:59:30
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:AttendanceInfDao.java
 *类说明：用户考勤的接口层
 */

public interface AttendanceInfDao {
	//查找员工信息
	public UserEntity findIdByUid(String uid);
	
	//考勤信息的显示。（查询全部考勤信息）
	public List<Attendance> findAllAttendanceInf();
	
	//考勤信息的显示。（查询个人的签到信息）
	public List<Attendance> findByUserIdAttendanceInf(String userid);
	
	//考勤信息的插入操作。(签到、签退操作)
	public boolean insertAttendanceInf(Attendance a);
	
	//考勤信息的修改操作。
	public boolean updateAttendanceInf(Attendance a);
	
	//考勤信息的删除操作。（单条删除）
	public boolean deleteAttendanceInf(int uid);
		
	//考勤信息的删除操作。（请空表）
	public boolean deleteAllAttendanceInf();
}
