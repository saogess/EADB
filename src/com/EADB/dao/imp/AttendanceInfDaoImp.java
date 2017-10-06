package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.EADB.dao.AttendanceInfDao;
import com.EADB.model.Attendance;
import com.EADB.model.UserEntity;
import com.EADB.util.JDBCUtil;

/**
 *创建时间：2017年9月20日下午5:44:01
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:AttendanceInfDaoImp.java
 *类说明：用户考勤的实现层
 */

public class AttendanceInfDaoImp implements AttendanceInfDao{
	//查找员工信息
	public UserEntity findIdByUid(String userid) {
		//准备SQL语句
		String sql="select * from userinf where userid=?";
		//准备SQL参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(userid);
		UserEntity u=JDBCUtil.findBySingleObject(sql, paras, UserEntity.class);
		return u;
	}
	
	//考勤信息的显示。（查询全部考勤信息）
	public List<Attendance> findAllAttendanceInf() {
		List<Attendance> list=new ArrayList<Attendance>();
		//准备SQL语句。
		String sql="select u.userid,u.username,a.time,a.atype,a.inf from userinf as u,attendanceInf as a where a.uid=u.uId";
		//进行数据库操作
		list=JDBCUtil.QueryListExcute(sql, null, Attendance.class);
		return list;
	}
	
	//考勤信息的显示。（查询个人的签到信息）
	public List<Attendance> findByUserIdAttendanceInf(String userid) {
		List<Attendance> list=new ArrayList<Attendance>();
		//准备SQL语句。
		String sql="select u.userid,u.username,a.time,a.atype,a.inf from userinf as u,attendanceInf as a where u.userid=? and a.uid=u.uId";
		//准备参数的值
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(userid);
		//进行数据库操作
		list=JDBCUtil.QueryListExcute(sql, paras, Attendance.class);
		return list;
	}
	
	//考勤信息的插入操作。(签到、签退操作)
	public boolean insertAttendanceInf(Attendance a) {
		//准备SQL语句。
		String sql="insert into attendanceInf(uid,time,atype,inf) values (?,?,?,?)";
		//准备参数的值
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(a.getUid());
		paras.add(a.getTime());
		paras.add(a.getAtype());
		paras.add(a.getInf());
		//进行数据库操作
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}
	
	//考勤信息的修改操作。
	public boolean updateAttendanceInf(Attendance a) {
		//准备SQL语句。
		String sql="update attendanceInf set time=?,atype=?,inf=? where uid=?";
		//准备参数的值
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(a.getTime());
		list.add(a.getAtype());
		list.add(a.getInf());
		list.add(a.getUid());
		//进行数据库操作
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//考勤信息的删除操作。（单条删除）
	public boolean deleteAttendanceInf(int uid) {
		//准备SQL语句。
		String sql="delete from attendanceInf where uid=?";
		//准备参数的值
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(uid);
		//进行数据库操作
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//考勤信息的删除操作。（请空表）
	@Test
	public boolean deleteAllAttendanceInf() {
		//准备SQL语句。
		String sql="truncate table attendanceInf";
		//进行数据库操作
		JDBCUtil.InsertUpdateDeleteExcute(sql, null);
		return true;
	}
}
