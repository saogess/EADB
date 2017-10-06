package com.EADB.dao;

import java.util.List;

import com.EADB.model.Manager;

/**
 *����ʱ�䣺2017��9��19������3:47:39
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:ManagerInfDaoInterface.java
 *��˵����������Ϣ����ز����ӿڲ㡣
 */

public interface ManagerInfDao {
	//�����¼�Ĳ�����
	public Manager managerLogin(Manager m,int type);
	
	//������Ϣ�Ĳ�ѯȫ��������
	public List<Manager> findAllManagerInf();
	
	//������Ϣ�Ĳ�ѯ���˲�����
	public Manager findByMidManagerInf(String mid);
	
	//������Ϣ�Ĳ��������
	public boolean insertManagerInf(Manager m);
	
	//������Ϣ���޸Ĳ�����
	public boolean updateManagerInf(Manager m);
	
	//������Ϣ��ɾ��������
	public boolean deleteManagerInf(Manager m);
}
