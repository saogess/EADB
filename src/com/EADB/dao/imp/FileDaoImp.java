package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.FileDao;
import com.EADB.model.FileInf;
import com.EADB.util.JDBCUtil;

/**
 *创建时间：2017年9月26日上午8:36:16
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:FileDaoImp.java
 *类说明：文件管理的Dao实现层
 */

public class FileDaoImp implements FileDao{

	//新增文件信息
	@Override
	public boolean insertFile(FileInf f) {
		//准备SQL语句
		String sql="INSERT INTO fileinf(fNum,fName,fTime,fPath,maId) VALUES (?,?,?,?,?)";
		//填写SQL语句参数
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(f.getfNum());
		paras.add(f.getfName());
		paras.add(f.getfTime());
		paras.add(f.getfPath());
		paras.add(f.getMaId());
		//执行数据库操作
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}

	//查看文件信息(全部)
	@Override
	public List<FileInf> findAllFile() {
		//准备SQL语句
		String sql="SELECT f.fId,m.mid,m.managername,m.position,f.fNum,f.fName,f.fTime FROM fileinf AS f,manager AS m WHERE f.maId=m.id";
		//执行数据库操作
		List<FileInf> list=JDBCUtil.QueryListExcute(sql, null, FileInf.class);
		return list;
	}

	//查看文件信息(单个)
	@Override
	public FileInf findByFnumFile(int fId) {
		//准备SQL语句
		String sql="SELECT m.mid,m.managername,m.position,f.fNum,f.fName,f.fTime,f.fPath "
				+ "FROM fileinf AS f,manager AS m WHERE f.fId=? AND f.maId=m.id";
		//填写SQL语句参数
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(fId);
		//执行数据库操作
		FileInf f=JDBCUtil.findBySingleObject(sql, paras, FileInf.class);
		return f;
	}

}
