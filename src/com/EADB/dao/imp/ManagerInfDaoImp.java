package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.ManagerInfDao;
import com.EADB.model.Manager;
import com.EADB.util.JDBCUtil;

/**
 *创建时间：2017年8月21日上午9:21:55
 *项目名称：2017_EADBproject
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:managerInfDao.java
 *类说明：
 *		经理信息的相关操作。
 */

public class ManagerInfDaoImp implements ManagerInfDao{
	//经理登录的操作。
	public Manager managerLogin(Manager m,int type) {
		//准备sql语句。
		String sql1="select * from manager where mid=?";
		String sql2="select * from manager where mid=? and mPassword=?";
		//准备SQL参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		//工号验证操作
		if(type==0){
			paras.add(m.getMid());
			m=JDBCUtil.findBySingleObject(sql1, paras,Manager.class);
		}
		//登录验证操作
		if(type==1){
			paras.add(m.getMid());
			paras.add(m.getmPassword());
			m=JDBCUtil.findBySingleObject(sql2, paras,Manager.class);
		}
		//调用数据库公共处理类
		return m != null ? m : null;
	}
	
	//经理信息的查询全部操作。
	public List<Manager> findAllManagerInf() {
		List<Manager> list=new ArrayList<Manager>();
		//准备SQL语句
		String sql="select * from manager";
		//进行数据库操作
		list=JDBCUtil.QueryListExcute(sql, null, Manager.class);
		return list;
	}
	
	//经理信息的查询个人操作。
	public Manager findByMidManagerInf(String mid) {
		//准备SQL语句
		String sql="select * from manager where mid=?";
		//进行数据库操作
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(mid);
		Manager m=JDBCUtil.findBySingleObject(sql, paras,Manager.class);
		return m;
	}
	
	//经理信息的插入操作。
	public boolean insertManagerInf(Manager m) {
		boolean flag=false;
		//准备SQL语句
		String sql="insert into manager(mid,managername,mPassword,gender,birthday,phonenumber,address,mail,pictureurl,position) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		//准备参数的值
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(m.getMid());
		list.add(m.getManagername());
		list.add(m.getmPassword());
		list.add(m.getGender());
		list.add(m.getBirthday());
		list.add(m.getPhonenumber());
		list.add(m.getAddress());
		list.add(m.getMail());
		list.add(m.getPictureurl());
		list.add(m.getPosition());
		//进行数据库操作
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//经理信息的修改操作。
	public boolean updateManagerInf(Manager m) {
		boolean flag=false;
		//准备SQL语句
		String sql="update manager set mPassword=?,phonenumber=?,address=?,mail=? where mid=?";
		//准备参数的值
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(m.getmPassword());
		list.add(m.getPhonenumber());
		list.add(m.getAddress());
		list.add(m.getMail());
		list.add(m.getMid());
		//进行数据库操作
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//经理信息的删除操作。
	public boolean deleteManagerInf(Manager m) {
		boolean flag=false;
		//准备SQL语句
		String sql="delete from manager where mid=? and managername=?";
		//准备参数的值
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(m.getMid());
		list.add(m.getManagername());
		//进行数据库操作
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}

}
