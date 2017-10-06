package com.EADB.service.imp;   

import java.util.List;

import com.EADB.dao.AdminDao;
import com.EADB.dao.imp.AdminDaoImp;
import com.EADB.model.ManagerEntity;
import com.EADB.service.AdminService;

/**  
 * ����ʱ�䣺2017��8��19�� ����2:56:38  
 * ��Ŀ���ƣ�ZBDBProject  
 * @author Alex  
 * @version 1.0   
 * @since JDK 1.7.0_21  
 * �ļ����ƣ�UserServiceImpl.java  
 * ��˵����  
 *    �û�ҵ����ʵ����
 */
public class AdminServiceImpl implements AdminService {

	/*
	 * �û���¼
	 */
	@Override
	public ManagerEntity userLogin(ManagerEntity userEntity,int type) {
		//�������ݲ�ӿ����͵ı�����ʹ�øñ���ָ��ʵ�ָýӿ����ʵ����Ķ���
		AdminDao userdao=new AdminDaoImp();
		return userdao.userLogin(userEntity, type);
	}

	/*
	 * �û��˺���֤
	 */
	@Override
	public boolean validateLoginNameIsExsit(String loginName) {
		AdminDao userdao=new AdminDaoImp();
		return userdao.validataLoginName(loginName);
	}

	/*
	 * ��ѯ���е��û�
	 */
	public List<ManagerEntity> queryUserInfo()
	{
		AdminDao userdao=new AdminDaoImp();
		return userdao.queryUserInfo();
	}
	
	/*
	 * ע�� 
	 */
	public boolean regist(ManagerEntity userEntity)
	{
		AdminDao userdao=new AdminDaoImp();
		return userdao.regist(userEntity);
	}

	/* 
	 * ɾ��
	 */
	public boolean managerDelete(ManagerEntity userEntity) {
		AdminDao userdao=new AdminDaoImp();
		return userdao.managerDelete(userEntity);
	}
	
	/* 
	 * ��ѯ����
	 */
	public ManagerEntity findByloginName(String loginName) {
		AdminDao userdao=new AdminDaoImp();
		ManagerEntity managerEntity=userdao.findByloginName(loginName);
		return managerEntity;
	}

	/* 
	 * �޸�
	 */
	public boolean managerUpdate(ManagerEntity userEntity) {
		AdminDao userdao=new AdminDaoImp();
		return userdao.managerUpdate(userEntity);
	}

	/* (non-Javadoc)
	 * @see com.EADB.service.AdminService#findUserByLoginNameAndPassword(com.EADB.model.ManagerEntity)
	 */
	@Override
	public ManagerEntity findUserByLoginNameAndPassword(ManagerEntity userEntity) {
		AdminDao userDao = new AdminDaoImp();
		return userDao.findUserByLoginNameAndPassword(userEntity);
	}

}
  

