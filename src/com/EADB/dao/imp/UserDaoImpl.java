package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.UserDao;
import com.EADB.model.FileEntity;
import com.EADB.model.LeaveNum;
import com.EADB.model.UserEntity;
import com.EADB.util.JDBCUtil;

/**
 *创建时间：2017年9月18日上午9:58:34
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:UserDaoImpl.java
 *类说明：
 */

public class UserDaoImpl implements UserDao {
	//注册
	public boolean UserRegist(UserEntity u){
		boolean flag=false;
		//准备SQL语句
		String sql="insert into userinf(userid,username,userpassword,usergender,useremail,userphone,userbirthday,useraddress,userdept) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		//准备参数的值
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(u.getUserid());
		list.add(u.getUsername());
		list.add(u.getUserpassword());
		list.add(u.getUsergender());
		list.add(u.getUseremail());
		list.add(u.getUserphone());
		list.add(u.getUserbirthday());
		list.add(u.getUseraddress());
		list.add(u.getUserdept());
		/*list.add(u.getuPicUrl());*/
		//调用数据库公共处理类
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}

	/*
	 * 用户登录
	 */
	@Override
	public UserEntity UserLogin(UserEntity u,int type) {
		//准备SQL语句
				String sql1 = "select * from userinf where userid=?";
				String sql2 = "select * from userinf where userid=? and userpassword=?";
				//准备SQL参数的值
				ArrayList<Object> paras = new ArrayList<Object>();
				//手机号验证操作
				if(type==0){
					paras.add(u.getUserid());
					u=JDBCUtil.findBySingleObject(sql1, paras,UserEntity.class);
				}
				//登录验证操作
				if(type==1){
					paras.add(u.getUserid());
					paras.add(u.getUserpassword());
					u=JDBCUtil.findBySingleObject(sql2, paras,UserEntity.class);
				}
				//调用数据库公共处理类
				return u != null ? u : null;
	}
	
	
	/*
	 * 验证用户编号是否正确
	 */
	@Override
	public boolean validataUPhone(String userid) {
		//准备SQL语句
				String sql = "select * from userinf where userid=?";
				//准备SQL参数的值
				ArrayList<Object> paras = new ArrayList<Object>();
				paras.add(userid);
				//调用数据库公共处理类
				UserEntity u=JDBCUtil.findBySingleObject(sql, paras,UserEntity.class);
				return u != null ? true : false;
	}
	
	
	/*
	 * 查询所有
	 */
	public List<UserEntity> findAllUserEntity(){
		List<UserEntity> list=new ArrayList<UserEntity>();
		//准备SQL语句
		String sql="select * from userinf";
		//进行数据库操作
		list=JDBCUtil.QueryListExcute(sql, null, UserEntity.class);
		return list;
	}
	
	/*
	 * 查询单个
	 */
	public List<UserEntity> findByuNameUserEntity(String username){
		List<UserEntity> list=new ArrayList<UserEntity>();
		//准备SQL语句
		String sql="select * from userinf where username like ?";
		//进行数据库操作
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(username+"%");
		list=JDBCUtil.QueryListExcute(sql, paras, UserEntity.class);
		return list;
	}
	
	/*
	 * 查询单个(精确)
	 */
	public UserEntity findByuName(String username){
		//准备SQL语句
		String sql="select * from userinf where username=?";
		//进行数据库操作
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(username);
		return JDBCUtil.findBySingleObject(sql, paras, UserEntity.class);
	}
	
	/*
	 * 查询单个(精确)
	 */
	public UserEntity findByuId(String uId){
		//准备SQL语句
		String sql="select * from userinf where userid=?";
		//进行数据库操作
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(uId);
		return JDBCUtil.findBySingleObject(sql, paras, UserEntity.class);
	}
	
	/*
	 * 修改
	 */
	public boolean userEntityUpdate(UserEntity u){
		boolean flag=false;
		//准备SQL语句
		String sql="update userinf set userpassword=?,useremail=?,userphone=?,useraddress=? where username=?";
		//准备参数的值
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(u.getUserpassword());
		list.add(u.getUseremail());
		list.add(u.getUserphone());
		list.add(u.getUseraddress());
		list.add(u.getUsername());
		//进行数据库操作
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	/*
	 * 删除
	 */
	public boolean userEntityDelete(UserEntity u){
		boolean flag=false;
		//准备SQL语句
		String sql="delete from userinf where userid=?";
		//准备参数的值
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(u.getUserid());
		//进行数据库操作
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	
	//向请假次数表添加信息
	public boolean NumberRegist(LeaveNum ln){
		boolean flag=false;
		//准备SQL语句
		String sql="insert into leavenum(username,lnNum) values(?,?)";
		//准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(ln.getUsername());
		paras.add(ln.getLnNum());
		//调用数据库公共处理类
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}
	
	//上传头像
	public boolean FileInsert(FileEntity f){
		boolean flag=false;
		//准备SQL语句
		String sql="insert into filepic(userid,username,userpic,fDate) "
				+ "values(?,?,?,?)";
		//准备参数的值
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(f.getUserid());
		list.add(f.getUsername());
		list.add(f.getUserpic());
		list.add(f.getfDate());
		//调用数据库公共处理类
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//查询头像
	public FileEntity findFile(String username){
		//准备SQL语句
		String sql="select * from filepic where username=?";
		//进行数据库操作
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(username);
		return JDBCUtil.findBySingleObject(sql, paras, FileEntity.class);
	}

}
