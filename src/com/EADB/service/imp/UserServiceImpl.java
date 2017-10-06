package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.UserDao;
import com.EADB.dao.imp.UserDaoImpl;
import com.EADB.model.FileEntity;
import com.EADB.model.LeaveNum;
import com.EADB.model.UserEntity;
import com.EADB.service.UserService;

/**
 *创建时间：2017年9月18日上午10:00:28
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:UserServiceImpl.java
 *类说明：
 */

public class UserServiceImpl implements UserService{
	//注册
	public boolean UserRegist(UserEntity u){
		UserDao userdao = new UserDaoImpl();
		return userdao.UserRegist(u);
	}
	
	//用户登录
	public UserEntity UserLogin(UserEntity u,int type){
		UserDao userdao = new UserDaoImpl();
		return userdao.UserLogin(u,type);
	}
	
	/*//验证用户名是否正确
	public boolean validataUPhone(String uPhone){
		UserDao userdao = new UserDaoImpl();
		return userdao.validataUPhone(uPhone);
	}*/
	
	
	/*
	 * 查询所有的商品信息
	 */
	public List<UserEntity> findAllUserEntity(){
		UserDao userdao = new UserDaoImpl();
		return userdao.findAllUserEntity();
	}
	
	/*
	 * 查询单个商品信息
	 */
	public List<UserEntity> findByuNameUserEntity(String username){
		UserDao userdao = new UserDaoImpl();
		return userdao.findByuNameUserEntity(username);
	}
	
	/*
	 * 查询单个商品信息(精确)
	 */
	public UserEntity findByuName(String username){
		UserDao userdao = new UserDaoImpl();
		return userdao.findByuName(username);
	}
	
	/*
	 * 修改
	 */
	public boolean userEntityUpdate(UserEntity u){
		UserDao userdao = new UserDaoImpl();
		return userdao.userEntityUpdate(u);
	}
	
	/*
	 * 删除
	 */
	public boolean userEntityDelete(UserEntity u){
		UserDao userdao = new UserDaoImpl();
		return userdao.userEntityDelete(u);
	}
	
	//向请假次数表添加信息
	public boolean NumberRegist(LeaveNum ln){
		UserDao userdao = new UserDaoImpl();
		return userdao.NumberRegist(ln);
	}
	
	//上传头像
	public boolean FileInsert(FileEntity f){
		UserDao userdao = new UserDaoImpl();
		return userdao.FileInsert(f);
	}
	
	//查询头像
	public FileEntity findFile(String username){
		UserDao userdao = new UserDaoImpl();
		return userdao.findFile(username);
	}

}
