package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.DiaryDao;
import com.EADB.model.Diary;
import com.EADB.util.JDBCUtil;

/**
 *创建时间：2017年9月21日下午4:11:48
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:DiaryDaoImpl.java
 *类说明：
 */

public class DiaryDaoImpl implements DiaryDao{
	//添加日记
	public boolean DiaryInsert(Diary d){
		boolean flag=false;
		//准备SQL语句
		String sql="insert into diary(uId,dTitle,dContent,dStarttime,dModifytime) "
				+ "values(?,?,?,?,?)";
		//准备参数的值
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(d.getuId());
		list.add(d.getdTitle());
		list.add(d.getdContent());
		list.add(d.getdStarttime());
		list.add(d.getdModifytime());
		/*list.add(u.getuPicUrl());*/
		//调用数据库公共处理类
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//个人日记信息查询
	public List<Diary> DiaryQuery(int uId){
		//准备sql语句
		String sql = "SELECT u.userid,u.username,d.dId,d.dTitle,d.dContent,d.dStarttime,d.dModifytime FROM userinf AS u,diary AS d WHERE u.uId=d.uId AND d.uId=?";
		//准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(uId);
		//调用数据库公共处理类
		return JDBCUtil.QueryListExcute(sql, paras, Diary.class);
	}
	
	//修改
	public boolean DiaryUpdate(Diary d){
		boolean flag=false;
		//准备SQL语句
		String sql="update diary set dTitle=?,dContent=?,dModifytime=? where dId=?";
		//准备参数的值
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(d.getdTitle());
		list.add(d.getdContent());
		list.add(d.getdModifytime());
		list.add(d.getdId());
		//进行数据库操作
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//根据id查询
	public Diary DiaryQueryById(int dId){
		//准备sql语句
		String sql = "select * from diary where dId=?";
		//准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(dId);
		//调用数据库公共处理类
		return JDBCUtil.findBySingleObject(sql, paras, Diary.class);
	}

}
