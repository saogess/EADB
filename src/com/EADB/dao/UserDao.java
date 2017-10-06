package com.EADB.dao;

import java.util.List;

import com.EADB.model.FileEntity;
import com.EADB.model.LeaveNum;
import com.EADB.model.UserEntity;


/**
 *����ʱ�䣺2017��9��18������9:57:52
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:UserDao.java
 *��˵����
 */

public interface UserDao {
	//ע��
	boolean UserRegist(UserEntity u);
	
	/*
	 * �û���¼
	 */
	UserEntity UserLogin(UserEntity u,int type);
	
	
	/*
	 * ��֤�û����Ƿ���ȷ
	 */
	boolean validataUPhone(String userid);
	
	
	/*
	 * ��ѯ���е���Ʒ��Ϣ
	 */
	List<UserEntity> findAllUserEntity();
	
	/*
	 * ��ѯ������Ʒ��Ϣ
	 */
	List<UserEntity> findByuNameUserEntity(String username);
	
	/*
	 * ��ѯ������Ʒ��Ϣ(��ȷ)
	 */
	UserEntity findByuName(String username);
	
	/*
	 * �޸�
	 */
	boolean userEntityUpdate(UserEntity u);
	
	/*
	 * ɾ��
	 */
	boolean userEntityDelete(UserEntity u);
	
	//����ٴ����������Ϣ
	boolean NumberRegist(LeaveNum ln);
	
	//�ϴ�ͷ��
	boolean FileInsert(FileEntity f);
	
	//��ѯͷ��
	FileEntity findFile(String username);

}
