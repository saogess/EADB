package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.AdminDao;
import com.EADB.model.ManagerEntity;
import com.EADB.util.JDBCUtil;


/**
 * 创建时间：2017年8月19日 下午3:07:02 项目名称：ZBDBProject
 * 
 * @author Alex
 * @version 1.0
 * @since JDK 1.7.0_21 文件名称：UserDao.java 类说明：用户数据处理实现类
 */
public class AdminDaoImp implements AdminDao {
	/*
	 * 注册
	 */
	public boolean regist(ManagerEntity userEntity) {
		boolean flag = false;
		// 准备sql语句
		String strsql = "insert into admin (userName,loginname,password,photo,email) values (?,?,?,?,?)";
		// 准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(userEntity.getUserName());
		paras.add(userEntity.getLoginName());
		paras.add(userEntity.getPassword());
		paras.add(userEntity.getPhoto());
		paras.add(userEntity.getEmail());
		// 调用公共处理类
		flag = JDBCUtil.InsertUpdateDeleteExcute(strsql, paras);
		return flag;
	}

	/*
	 * 用户登录
	 */
	@Override
	public ManagerEntity userLogin(ManagerEntity userEntity,int type) {
		// 准备sql语句
		String strsql = "select * from admin where loginName=? and password=?";
		// 准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(userEntity.getLoginName());
		paras.add(userEntity.getPassword());
		// 调用公共处理类
		ManagerEntity uEntity = JDBCUtil.findBySingleObject(strsql, paras,
				ManagerEntity.class);
		return uEntity != null ? uEntity : null;
	}
	
	/*
	 * 删除数据
	 */
	public boolean managerDelete(ManagerEntity userEntity) {
		
		boolean flag = false;

		String strsql = "delete from admin where loginName=?"; // ?表示一个占位符，这条语句就叫预编译语句

		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(userEntity.getLoginName());

		// 调用公共处理类
		flag = JDBCUtil.InsertUpdateDeleteExcute(strsql, paras);
		return flag;
	}

	/*
	 * 验证用户名是否正确
	 */
	@Override
	public boolean validataLoginName(String loginName) {
		// 准备sql语句
		String strsql = "select * from admin where loginName=?";
		// 准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(loginName);
		// 调用公共处理类
		ManagerEntity uEntity = JDBCUtil.findBySingleObject(strsql, paras,
				ManagerEntity.class);
		return uEntity != null ? true : false;
	}

	/*
	 * 查询所有的用户
	 */
	public List<ManagerEntity> queryUserInfo() {
		List<ManagerEntity> userList = new ArrayList<ManagerEntity>();
		// 准备查询sql语句
		String strSql = "select * from admin";
		//没有参数就可以传入null
		userList =JDBCUtil.QueryListExcute(strSql, null, ManagerEntity.class);	
		return userList;
	}
	/*
	 * 管理员个人信息查询
	 */
	public ManagerEntity findByloginName(String loginName) {
		//准备sql语句。
		String sql="select * from admin where loginName=?";
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(loginName);
		ManagerEntity m=JDBCUtil.findBySingleObject(sql, paras, ManagerEntity.class);
		return m;
	}

	/* 
	 * 修改
	 */
	public boolean managerUpdate(ManagerEntity userEntity) {
		boolean flag = false;
		// 准备sql语句
		String strsql = "update admin set password=?,userName=?,photo=?,email=? where loginName=?";
		// 准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(userEntity.getPassword());
		paras.add(userEntity.getUserName());
		paras.add(userEntity.getPhoto());
		paras.add(userEntity.getEmail());
		paras.add(userEntity.getLoginName());
		// 调用公共处理类
		flag = JDBCUtil.InsertUpdateDeleteExcute(strsql, paras);
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.EADB.dao.AdminDao#findUserByLoginNameAndPassword(com.EADB.model.ManagerEntity)
	 */
	@Override
	public ManagerEntity findUserByLoginNameAndPassword(ManagerEntity userEntity) {
		//sql语句
		String sql="select * from admin "
				+ " where loginName=? and password=?";
		
		//参数
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(userEntity.getLoginName());
		paras.add(userEntity.getPassword());
		
		//调用数据处理公共方法
		JDBCUtil jdbcUtil = new JDBCUtil();
		return jdbcUtil.findBySingleObject(sql, paras, ManagerEntity.class);
	}
	




}
