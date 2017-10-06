package com.EADB.service.imp;   

import java.util.List;

import com.EADB.dao.AdminDao;
import com.EADB.dao.imp.AdminDaoImp;
import com.EADB.model.ManagerEntity;
import com.EADB.service.AdminService;

/**  
 * 创建时间：2017年8月19日 下午2:56:38  
 * 项目名称：ZBDBProject  
 * @author Alex  
 * @version 1.0   
 * @since JDK 1.7.0_21  
 * 文件名称：UserServiceImpl.java  
 * 类说明：  
 *    用户业务处理实现类
 */
public class AdminServiceImpl implements AdminService {

	/*
	 * 用户登录
	 */
	@Override
	public ManagerEntity userLogin(ManagerEntity userEntity,int type) {
		//创建数据层接口类型的变量，使用该变量指向实现该接口类的实现类的对象
		AdminDao userdao=new AdminDaoImp();
		return userdao.userLogin(userEntity, type);
	}

	/*
	 * 用户账号验证
	 */
	@Override
	public boolean validateLoginNameIsExsit(String loginName) {
		AdminDao userdao=new AdminDaoImp();
		return userdao.validataLoginName(loginName);
	}

	/*
	 * 查询所有的用户
	 */
	public List<ManagerEntity> queryUserInfo()
	{
		AdminDao userdao=new AdminDaoImp();
		return userdao.queryUserInfo();
	}
	
	/*
	 * 注册 
	 */
	public boolean regist(ManagerEntity userEntity)
	{
		AdminDao userdao=new AdminDaoImp();
		return userdao.regist(userEntity);
	}

	/* 
	 * 删除
	 */
	public boolean managerDelete(ManagerEntity userEntity) {
		AdminDao userdao=new AdminDaoImp();
		return userdao.managerDelete(userEntity);
	}
	
	/* 
	 * 查询个人
	 */
	public ManagerEntity findByloginName(String loginName) {
		AdminDao userdao=new AdminDaoImp();
		ManagerEntity managerEntity=userdao.findByloginName(loginName);
		return managerEntity;
	}

	/* 
	 * 修改
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
  

