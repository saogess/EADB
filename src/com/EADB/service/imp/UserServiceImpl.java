package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.UserDao;
import com.EADB.dao.imp.UserDaoImpl;
import com.EADB.model.FileEntity;
import com.EADB.model.LeaveNum;
import com.EADB.model.UserEntity;
import com.EADB.service.UserService;

/**
 *����ʱ�䣺2017��9��18������10:00:28
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:UserServiceImpl.java
 *��˵����
 */

public class UserServiceImpl implements UserService{
	//ע��
	public boolean UserRegist(UserEntity u){
		UserDao userdao = new UserDaoImpl();
		return userdao.UserRegist(u);
	}
	
	//�û���¼
	public UserEntity UserLogin(UserEntity u,int type){
		UserDao userdao = new UserDaoImpl();
		return userdao.UserLogin(u,type);
	}
	
	/*//��֤�û����Ƿ���ȷ
	public boolean validataUPhone(String uPhone){
		UserDao userdao = new UserDaoImpl();
		return userdao.validataUPhone(uPhone);
	}*/
	
	
	/*
	 * ��ѯ���е���Ʒ��Ϣ
	 */
	public List<UserEntity> findAllUserEntity(){
		UserDao userdao = new UserDaoImpl();
		return userdao.findAllUserEntity();
	}
	
	/*
	 * ��ѯ������Ʒ��Ϣ
	 */
	public List<UserEntity> findByuNameUserEntity(String username){
		UserDao userdao = new UserDaoImpl();
		return userdao.findByuNameUserEntity(username);
	}
	
	/*
	 * ��ѯ������Ʒ��Ϣ(��ȷ)
	 */
	public UserEntity findByuName(String username){
		UserDao userdao = new UserDaoImpl();
		return userdao.findByuName(username);
	}
	
	/*
	 * �޸�
	 */
	public boolean userEntityUpdate(UserEntity u){
		UserDao userdao = new UserDaoImpl();
		return userdao.userEntityUpdate(u);
	}
	
	/*
	 * ɾ��
	 */
	public boolean userEntityDelete(UserEntity u){
		UserDao userdao = new UserDaoImpl();
		return userdao.userEntityDelete(u);
	}
	
	//����ٴ����������Ϣ
	public boolean NumberRegist(LeaveNum ln){
		UserDao userdao = new UserDaoImpl();
		return userdao.NumberRegist(ln);
	}
	
	//�ϴ�ͷ��
	public boolean FileInsert(FileEntity f){
		UserDao userdao = new UserDaoImpl();
		return userdao.FileInsert(f);
	}
	
	//��ѯͷ��
	public FileEntity findFile(String username){
		UserDao userdao = new UserDaoImpl();
		return userdao.findFile(username);
	}

}
