package com.EADB.dao;

import java.util.List;

import com.EADB.model.ManagerDiary;

/**
 *创建时间：2017年9月21日下午6:03:38
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:ManagerDiaryDao.java
 *类说明：经理日记的接口层
 */

public interface ManagerDiaryDao {
	//查看日记(标题)
	public List<ManagerDiary> findAllDiaryInf(String mid);
	
	//查看日记(内容)
	public ManagerDiary findByDIdDiaryInf(int id);
	
	//添加日记
	public boolean insertDiary(ManagerDiary md);
	
	//修改日记
	public boolean updateDiary(ManagerDiary md);
	
	//删除日记
	public boolean deleteDiary(ManagerDiary md);
	
}
