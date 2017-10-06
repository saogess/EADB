package com.EADB.dao;

import java.util.List;

import com.EADB.model.Attendance;
import com.EADB.model.UserEntity;

/**
 *����ʱ�䣺2017��9��21������7:59:30
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:AttendanceInfDao.java
 *��˵�����û����ڵĽӿڲ�
 */

public interface AttendanceInfDao {
	//����Ա����Ϣ
	public UserEntity findIdByUid(String uid);
	
	//������Ϣ����ʾ������ѯȫ��������Ϣ��
	public List<Attendance> findAllAttendanceInf();
	
	//������Ϣ����ʾ������ѯ���˵�ǩ����Ϣ��
	public List<Attendance> findByUserIdAttendanceInf(String userid);
	
	//������Ϣ�Ĳ��������(ǩ����ǩ�˲���)
	public boolean insertAttendanceInf(Attendance a);
	
	//������Ϣ���޸Ĳ�����
	public boolean updateAttendanceInf(Attendance a);
	
	//������Ϣ��ɾ��������������ɾ����
	public boolean deleteAttendanceInf(int uid);
		
	//������Ϣ��ɾ������������ձ�
	public boolean deleteAllAttendanceInf();
}
