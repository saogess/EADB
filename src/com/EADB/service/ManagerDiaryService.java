package com.EADB.service;

import java.util.List;

import com.EADB.model.ManagerDiary;

/**
 *����ʱ�䣺2017��9��22������9:20:07
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:ManagerDiaryService.java
 *��˵����������־�����ӿ�
 */

public interface ManagerDiaryService {
	//��Ӿ�����־
	public boolean insertManagerDiary(ManagerDiary md);
	
	//��ѯ��־��Ϣ
	public List<ManagerDiary> showAllManagerDiary(String mid);
	
	//��ѯ��־��Ϣ(����)
	public ManagerDiary showOneManagerDiary(int dId);
	
	//�޸ľ�����־
	public boolean updateManagerDairy(ManagerDiary md);
}
