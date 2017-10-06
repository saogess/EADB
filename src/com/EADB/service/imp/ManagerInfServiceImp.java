package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.ManagerInfDao;
import com.EADB.dao.imp.ManagerInfDaoImp;
import com.EADB.model.Manager;
import com.EADB.service.ManagerInfService;

/**
 *创建时间：2017年9月19日下午4:17:29
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:ManagerInfServiceImp.java
 *类说明：经理信息的个人处理实现层。（经理权限）
 */

public class ManagerInfServiceImp implements ManagerInfService{

	@Override
	public Manager managerLoginService(Manager m, int type) {
		//创建数据层接口类型的变量，使用该变量指向实现该接口类的实现类的对象
		ManagerInfDao mid=new ManagerInfDaoImp();
		Manager mi=mid.managerLogin(m, type);
		return mi;
	}

	@Override
	public Manager findByMidManagerInfService(String mid) {
		ManagerInfDao mids=new ManagerInfDaoImp();
		Manager m=mids.findByMidManagerInf(mid);
		return m;
	}

	@Override
	public List<Manager> findAllManagerInfService() {
		ManagerInfDao mids=new ManagerInfDaoImp();
		List<Manager> list=mids.findAllManagerInf();
		return list;
	}

	@Override
	public boolean updateManagerInfService(Manager m) {
		ManagerInfDao mids=new ManagerInfDaoImp();
		boolean flag=mids.updateManagerInf(m);
		return flag;
	}

	@Override
	public boolean deleteManagerInfService(Manager m) {
		ManagerInfDao mids=new ManagerInfDaoImp();
		boolean flag=mids.deleteManagerInf(m);
		return flag;
	}

	@Override
	public boolean addManagerInfService(Manager m) {
		ManagerInfDao mids=new ManagerInfDaoImp();
		boolean flag=mids.insertManagerInf(m);
		return flag;
	}
	
}
