package com.EADB.service.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.EADB.dao.AttendanceInfDao;
import com.EADB.dao.imp.AttendanceInfDaoImp;
import com.EADB.model.Attendance;
import com.EADB.model.UserEntity;
import com.EADB.service.AttendanceInfService;

/**
 *创建时间：2017年9月21日上午8:25:23
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:AttendanceInfServiceImp.java
 *类说明：用户考勤的服务层实现
 */

public class AttendanceInfServiceImp implements AttendanceInfService{

	//查询员工考勤信息。(根据员工id查询)
	@Override
	public List<Attendance> findByUIdAttendanceInf(String userid) {
		AttendanceInfDao aid=new AttendanceInfDaoImp();
		List<Attendance> list=aid.findByUserIdAttendanceInf(userid);
		return list;
	}

	//查询全部员工考勤信息。
	@Override
	public List<Attendance> findAllAttendanceInf() {
		AttendanceInfDao aid=new AttendanceInfDaoImp();
		List<Attendance> list=aid.findAllAttendanceInf();
		return list;
	}

	//删除员工考勤信息。（单条删除）
	@Override
	public boolean deleteByUidAttendanceInf(String uid) {
		AttendanceInfDao aid=new AttendanceInfDaoImp();
		UserEntity u=aid.findIdByUid(uid);
		boolean flag=aid.deleteAttendanceInf(u.getuId());
		return flag;
	}

	//删除员工考勤信息。（清空表）
	@Override
	public boolean deleteAllAttendanceInf() {
		AttendanceInfDao aid=new AttendanceInfDaoImp();
		boolean flag=aid.deleteAllAttendanceInf();
		return flag;
	}
	
	//员工考勤操作：员工签到与签退。
	public boolean SignInInsert(String uid) throws ParseException{
		AttendanceInfDao aid=new AttendanceInfDaoImp();
		//查询用户信息
		UserEntity u=aid.findIdByUid(uid);
		System.out.println(u);
		//设置签到时间。
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
		String time = sdf.format(date);   //把日期转换成指定的时间格式字符串
		//设置标准签到时间。
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String time1=sdf1.format(date);
		String morning = "08:00:00";
		String noon="12:00:00";
		String afternoon="14:30:00";
		String night="18:00:00";
		Date now=sdf1.parse(time1);
		Date signIn1= sdf1.parse(morning);		
		Date signOff1=sdf1.parse(noon);		
		Date signIn2=sdf1.parse(afternoon);		
		Date signOff2=sdf1.parse(night);		
		//签到类型的判断。
		String type;
		String inf;
		if(now.getTime()>signOff1.getTime()){
			inf="工作日下午";
			if(now.getTime()>=signOff1.getTime()&&now.getTime()<signIn2.getTime()){
				type = "正常签到";
			}else{
				type = "迟到，您将得到惩罚！";
			}
			if(now.getTime()>signOff2.getTime()){
				type = "正常签退";
			}else{
				type = "早退，您将得到惩罚！";
			}
		}else{
			inf="工作日上午";
			if(now.getTime()<=signIn1.getTime()){
				type = "正常签到";
			}else{
				type = "迟到";
			}
			if(now.getTime()>=signOff1.getTime()&&now.getTime()<signIn2.getTime()){
				type = "正常签退";
			}else{
				type = "早退，您将得到惩罚！";
			}
		}
		Attendance a=new Attendance(u.getuId(),uid,u.getUsername(),time,type,inf);
		boolean flag=aid.insertAttendanceInf(a);
		return flag;
	}
}
