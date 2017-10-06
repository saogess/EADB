package com.EADB.dao;

import java.util.List;

import com.EADB.model.ManagerDiary;

/**
 *����ʱ�䣺2017��9��21������6:03:38
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:ManagerDiaryDao.java
 *��˵���������ռǵĽӿڲ�
 */

public interface ManagerDiaryDao {
	//�鿴�ռ�(����)
	public List<ManagerDiary> findAllDiaryInf(String mid);
	
	//�鿴�ռ�(����)
	public ManagerDiary findByDIdDiaryInf(int id);
	
	//����ռ�
	public boolean insertDiary(ManagerDiary md);
	
	//�޸��ռ�
	public boolean updateDiary(ManagerDiary md);
	
	//ɾ���ռ�
	public boolean deleteDiary(ManagerDiary md);
	
}
