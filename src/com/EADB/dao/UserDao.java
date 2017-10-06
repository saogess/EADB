package com.EADB.dao;

import java.util.List;

import com.EADB.model.FileEntity;
import com.EADB.model.LeaveNum;
import com.EADB.model.UserEntity;


/**
 *创建时间：2017年9月18日上午9:57:52
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:UserDao.java
 *类说明：
 */

public interface UserDao {
	//注册
	boolean UserRegist(UserEntity u);
	
	/*
	 * 用户登录
	 */
	UserEntity UserLogin(UserEntity u,int type);
	
	
	/*
	 * 验证用户名是否正确
	 */
	boolean validataUPhone(String userid);
	
	
	/*
	 * 查询所有的商品信息
	 */
	List<UserEntity> findAllUserEntity();
	
	/*
	 * 查询单个商品信息
	 */
	List<UserEntity> findByuNameUserEntity(String username);
	
	/*
	 * 查询单个商品信息(精确)
	 */
	UserEntity findByuName(String username);
	
	/*
	 * 修改
	 */
	boolean userEntityUpdate(UserEntity u);
	
	/*
	 * 删除
	 */
	boolean userEntityDelete(UserEntity u);
	
	//向请假次数表添加信息
	boolean NumberRegist(LeaveNum ln);
	
	//上传头像
	boolean FileInsert(FileEntity f);
	
	//查询头像
	FileEntity findFile(String username);

}
