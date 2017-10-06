package com.EADB.dao;

import java.util.List;

import com.EADB.model.FileInf;

/**
 *创建时间：2017年9月26日上午8:33:30
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:FileDao.java
 *类说明：文件管理的Dao接口
 */

public interface FileDao {
	//新增文件信息
	public boolean insertFile(FileInf f);
	//查看文件信息(全部)
	public List<FileInf> findAllFile();
	//查看文件信息(单个)
	public FileInf findByFnumFile(int fId);
}
