package com.EADB.service;

import java.util.List;

import com.EADB.model.Attendance;

/**
 *����ʱ�䣺2017��9��21������8:06:01
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:AttendanceInfService.java
 *��˵�����û����ڵķ����ӿ�
 */

public interface AttendanceInfService {
	//��ѯԱ��������Ϣ��(����Ա��id��ѯ)
	public List<Attendance> findByUIdAttendanceInf(String userid);
	
	//��ѯȫ��Ա��������Ϣ��
	public List<Attendance> findAllAttendanceInf();
	
	//ɾ��Ա��������Ϣ��������ɾ����
	public boolean deleteByUidAttendanceInf(String uid);
	
	//ɾ��Ա��������Ϣ������ձ�
	public boolean deleteAllAttendanceInf();
	
}
