package com.EADB.dao;   

import java.util.List;

import com.EADB.model.ManagerEntity;

/**  
 * ����ʱ�䣺2017��8��19�� ����3:04:52  
 * ��Ŀ���ƣ�ZBDBProject  
 * @author Alex  
 * @version 1.0   
 * @since JDK 1.7.0_21  
 * �ļ����ƣ�IUserDao.java  
 * ��˵����  
 */
public interface AdminDao {

	/*
	 * �û���¼
	 */
	ManagerEntity userLogin(ManagerEntity userEntity, int type);
	/*
	 * ��֤�û����Ƿ���ȷ
	 */
	boolean validataLoginName(String loginName);
	
	/*
	 * ��ѯ���е��û�
	 */
	List<ManagerEntity> queryUserInfo();
	
	/*
	 * ע�� 
	 */
	boolean regist(ManagerEntity userEntity);
	
	/*
	 * ɾ��
	 */
	boolean managerDelete(ManagerEntity userEntity);


	/**
	 * ��ѯ����
	 */
	ManagerEntity findByloginName(String loginName);

	/*
	 * �޸�
	 */
	boolean managerUpdate(ManagerEntity userEntity);
	/**
	 * @param m
	 * @return
	 */
	ManagerEntity findUserByLoginNameAndPassword(ManagerEntity userEntity);

	
}
  

