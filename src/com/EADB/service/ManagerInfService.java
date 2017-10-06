package com.EADB.service;

import java.util.List;

import com.EADB.model.Manager;

/**
 *����ʱ�䣺2017��9��19������4:16:11
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:ManagerInfService.java
 *��˵����������Ϣ�ĸ��˴���ӿڲ㡣������Ȩ�ޣ�
 */

public interface ManagerInfService {
	/*
	 * ����ĵ�¼����
	 */
	public Manager managerLoginService(Manager m,int type);
	
	/*
	 * ����Ĳ�ѯ���˲���
	 */
	public Manager findByMidManagerInfService(String mid);
	
	/*
	 * ��ѯ������Ϣ��ȫ����
	 */
	public List<Manager> findAllManagerInfService();
	
	/*
	 * ���Ӿ�����Ϣ
	 */
	public boolean addManagerInfService(Manager m);
	
	/*
	 * �޸ľ��������Ϣ
	 */
	public boolean updateManagerInfService(Manager m);
	
	/*
	 * ɾ��������Ϣ����
	 */
	public boolean deleteManagerInfService(Manager m);
}
