package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.EADB.dao.AttendanceInfDao;
import com.EADB.model.Attendance;
import com.EADB.model.UserEntity;
import com.EADB.util.JDBCUtil;

/**
 *����ʱ�䣺2017��9��20������5:44:01
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:AttendanceInfDaoImp.java
 *��˵�����û����ڵ�ʵ�ֲ�
 */

public class AttendanceInfDaoImp implements AttendanceInfDao{
	//����Ա����Ϣ
	public UserEntity findIdByUid(String userid) {
		//׼��SQL���
		String sql="select * from userinf where userid=?";
		//׼��SQL������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(userid);
		UserEntity u=JDBCUtil.findBySingleObject(sql, paras, UserEntity.class);
		return u;
	}
	
	//������Ϣ����ʾ������ѯȫ��������Ϣ��
	public List<Attendance> findAllAttendanceInf() {
		List<Attendance> list=new ArrayList<Attendance>();
		//׼��SQL��䡣
		String sql="select u.userid,u.username,a.time,a.atype,a.inf from userinf as u,attendanceInf as a where a.uid=u.uId";
		//�������ݿ����
		list=JDBCUtil.QueryListExcute(sql, null, Attendance.class);
		return list;
	}
	
	//������Ϣ����ʾ������ѯ���˵�ǩ����Ϣ��
	public List<Attendance> findByUserIdAttendanceInf(String userid) {
		List<Attendance> list=new ArrayList<Attendance>();
		//׼��SQL��䡣
		String sql="select u.userid,u.username,a.time,a.atype,a.inf from userinf as u,attendanceInf as a where u.userid=? and a.uid=u.uId";
		//׼��������ֵ
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(userid);
		//�������ݿ����
		list=JDBCUtil.QueryListExcute(sql, paras, Attendance.class);
		return list;
	}
	
	//������Ϣ�Ĳ��������(ǩ����ǩ�˲���)
	public boolean insertAttendanceInf(Attendance a) {
		//׼��SQL��䡣
		String sql="insert into attendanceInf(uid,time,atype,inf) values (?,?,?,?)";
		//׼��������ֵ
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(a.getUid());
		paras.add(a.getTime());
		paras.add(a.getAtype());
		paras.add(a.getInf());
		//�������ݿ����
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}
	
	//������Ϣ���޸Ĳ�����
	public boolean updateAttendanceInf(Attendance a) {
		//׼��SQL��䡣
		String sql="update attendanceInf set time=?,atype=?,inf=? where uid=?";
		//׼��������ֵ
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(a.getTime());
		list.add(a.getAtype());
		list.add(a.getInf());
		list.add(a.getUid());
		//�������ݿ����
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//������Ϣ��ɾ��������������ɾ����
	public boolean deleteAttendanceInf(int uid) {
		//׼��SQL��䡣
		String sql="delete from attendanceInf where uid=?";
		//׼��������ֵ
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(uid);
		//�������ݿ����
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//������Ϣ��ɾ������������ձ�
	@Test
	public boolean deleteAllAttendanceInf() {
		//׼��SQL��䡣
		String sql="truncate table attendanceInf";
		//�������ݿ����
		JDBCUtil.InsertUpdateDeleteExcute(sql, null);
		return true;
	}
}
