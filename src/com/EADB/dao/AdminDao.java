package com.EADB.dao;   

import java.util.List;

import com.EADB.model.ManagerEntity;

/**  
 * 创建时间：2017年8月19日 下午3:04:52  
 * 项目名称：ZBDBProject  
 * @author Alex  
 * @version 1.0   
 * @since JDK 1.7.0_21  
 * 文件名称：IUserDao.java  
 * 类说明：  
 */
public interface AdminDao {

	/*
	 * 用户登录
	 */
	ManagerEntity userLogin(ManagerEntity userEntity, int type);
	/*
	 * 验证用户名是否正确
	 */
	boolean validataLoginName(String loginName);
	
	/*
	 * 查询所有的用户
	 */
	List<ManagerEntity> queryUserInfo();
	
	/*
	 * 注册 
	 */
	boolean regist(ManagerEntity userEntity);
	
	/*
	 * 删除
	 */
	boolean managerDelete(ManagerEntity userEntity);


	/**
	 * 查询个人
	 */
	ManagerEntity findByloginName(String loginName);

	/*
	 * 修改
	 */
	boolean managerUpdate(ManagerEntity userEntity);
	/**
	 * @param m
	 * @return
	 */
	ManagerEntity findUserByLoginNameAndPassword(ManagerEntity userEntity);

	
}
  

