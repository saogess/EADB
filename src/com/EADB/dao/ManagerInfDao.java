package com.EADB.dao;

import java.util.List;

import com.EADB.model.Manager;

/**
 *创建时间：2017年9月19日下午3:47:39
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:ManagerInfDaoInterface.java
 *类说明：经理信息的相关操作接口层。
 */

public interface ManagerInfDao {
	//经理登录的操作。
	public Manager managerLogin(Manager m,int type);
	
	//经理信息的查询全部操作。
	public List<Manager> findAllManagerInf();
	
	//经理信息的查询个人操作。
	public Manager findByMidManagerInf(String mid);
	
	//经理信息的插入操作。
	public boolean insertManagerInf(Manager m);
	
	//经理信息的修改操作。
	public boolean updateManagerInf(Manager m);
	
	//经理信息的删除操作。
	public boolean deleteManagerInf(Manager m);
}
