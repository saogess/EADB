package com.EADB.service;   

import java.util.List;

import com.EADB.model.ManagerEntity;

/**  
 * ����ʱ�䣺2017��8��19�� ����2:54:35  
 * ��Ŀ���ƣ�ZBDBProject  
 * @author Alex  
 * @version 1.0   
 * @since JDK 1.7.0_21  
 * �ļ����ƣ�IUserService.java  
 * ��˵����  
 *    �û�ҵ����ӿ���
 */
public interface AdminService {

	/*
	 * �û���¼
	 */
	ManagerEntity userLogin(ManagerEntity userEntity, int type);
	
	
	/*
	 * �û��˺���֤
	 */
	boolean validateLoginNameIsExsit(String loginName);
	
	
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
	
	/*
	 * ��ѯ������Ϣ
	 */
	ManagerEntity findByloginName(String loginName);

	/**
	 * �޸ĸ�����Ϣ
	 */
	boolean managerUpdate(ManagerEntity userEntity);


	/**
	 * @param m
	 * @return
	 */
	ManagerEntity findUserByLoginNameAndPassword(ManagerEntity userEntity);

	
}
  

