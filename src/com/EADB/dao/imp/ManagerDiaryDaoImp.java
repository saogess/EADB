package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.ManagerDiaryDao;
import com.EADB.model.Manager;
import com.EADB.model.ManagerDiary;
import com.EADB.util.JDBCUtil;

/**
 *创建时间：2017年9月21日下午6:11:02
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:ManagerDiaryDaoImp.java
 *类说明：经理日记的实现层
 */

public class ManagerDiaryDaoImp implements ManagerDiaryDao{

	//查看日记(标题)
	@Override
	public List<ManagerDiary> findAllDiaryInf(String mid) {
		//准备SQL语句
		String sql="SELECT m.mid,m.managername,d.dId,d.dStarttime,d.dModifytime,d.dTitle FROM managerdiary AS d,manager as m WHERE d.managerId=? and m.id=d.managerId";
		//填写SQL语句参数
		ArrayList<Object> paras=new ArrayList<Object>();
		ManagerInfDaoImp midi=new ManagerInfDaoImp();
		Manager m=midi.findByMidManagerInf(mid);
		paras.add(m.getId());
		//执行数据库操作
		List<ManagerDiary> list=JDBCUtil.QueryListExcute(sql, paras, ManagerDiary.class);
		return list;
	}

	//查看日记(内容)
	@Override
	public ManagerDiary findByDIdDiaryInf(int id) {
		//准备SQL语句
		String sql="SELECT d.dId,d.dStarttime,d.dModifytime,d.dTitle,d.dContent FROM managerdiary AS d WHERE dId=?";
		//填写SQL语句参数
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(id);
		//执行数据库操作
		ManagerDiary md=JDBCUtil.findBySingleObject(sql, paras, ManagerDiary.class);
		return md;
	}

	//添加日记
	@Override
	public boolean insertDiary(ManagerDiary md) {
		//准备SQL语句
		String sql="INSERT INTO managerdiary(managerId,dTitle,dContent,dStarttime,dModifytime) VALUES (?,?,?,?,?)";
		//填写SQL语句参数
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(md.getManagerId());
		paras.add(md.getdTitle());
		paras.add(md.getdContent());
		paras.add(md.getdStarttime());
		paras.add(md.getdModifytime());
		//执行数据库操作
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}

	//修改日记
	@Override
	public boolean updateDiary(ManagerDiary md) {
		//准备SQL语句
		String sql="UPDATE managerdiary SET dTitle=?,dContent=?,dModifytime=? WHERE dId=?";
		//填写SQL语句参数
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(md.getdTitle());
		paras.add(md.getdContent());
		paras.add(md.getdModifytime());
		paras.add(md.getdId());
		//执行数据库操作
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}

	//删除日记
	@Override
	public boolean deleteDiary(ManagerDiary md) {
		//准备SQL语句
		String sql="delete from managerdiary where dId=?";
		//填写SQL语句参数
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(md.getdId());
		//执行数据库操作
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}
	
}
