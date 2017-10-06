package com.EADB.service;

import java.util.List;

import com.EADB.model.Manager;

/**
 *创建时间：2017年9月19日下午4:16:11
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:ManagerInfService.java
 *类说明：经理信息的个人处理接口层。（经理权限）
 */

public interface ManagerInfService {
	/*
	 * 经理的登录操作
	 */
	public Manager managerLoginService(Manager m,int type);
	
	/*
	 * 经理的查询个人操作
	 */
	public Manager findByMidManagerInfService(String mid);
	
	/*
	 * 查询经理信息（全部）
	 */
	public List<Manager> findAllManagerInfService();
	
	/*
	 * 增加经理信息
	 */
	public boolean addManagerInfService(Manager m);
	
	/*
	 * 修改经理个人信息
	 */
	public boolean updateManagerInfService(Manager m);
	
	/*
	 * 删除经理信息操作
	 */
	public boolean deleteManagerInfService(Manager m);
}
