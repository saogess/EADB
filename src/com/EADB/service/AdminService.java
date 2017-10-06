package com.EADB.service;   

import java.util.List;

import com.EADB.model.ManagerEntity;

/**  
 * 创建时间：2017年8月19日 下午2:54:35  
 * 项目名称：ZBDBProject  
 * @author Alex  
 * @version 1.0   
 * @since JDK 1.7.0_21  
 * 文件名称：IUserService.java  
 * 类说明：  
 *    用户业务处理接口类
 */
public interface AdminService {

	/*
	 * 用户登录
	 */
	ManagerEntity userLogin(ManagerEntity userEntity, int type);
	
	
	/*
	 * 用户账号验证
	 */
	boolean validateLoginNameIsExsit(String loginName);
	
	
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
	
	/*
	 * 查询单个信息
	 */
	ManagerEntity findByloginName(String loginName);

	/**
	 * 修改个人信息
	 */
	boolean managerUpdate(ManagerEntity userEntity);


	/**
	 * @param m
	 * @return
	 */
	ManagerEntity findUserByLoginNameAndPassword(ManagerEntity userEntity);

	
}
  

