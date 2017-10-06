package com.EADB.service;

import java.util.List;

import com.EADB.model.ManagerDiary;

/**
 *创建时间：2017年9月22日上午9:20:07
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:ManagerDiaryService.java
 *类说明：经理日志服务层接口
 */

public interface ManagerDiaryService {
	//添加经理日志
	public boolean insertManagerDiary(ManagerDiary md);
	
	//查询日志信息
	public List<ManagerDiary> showAllManagerDiary(String mid);
	
	//查询日志信息(内容)
	public ManagerDiary showOneManagerDiary(int dId);
	
	//修改经理日志
	public boolean updateManagerDairy(ManagerDiary md);
}
