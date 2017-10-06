package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.ManagerInfDao;
import com.EADB.dao.imp.ManagerInfDaoImp;
import com.EADB.model.Manager;
import com.EADB.service.ManagerInfService;

/**
 *����ʱ�䣺2017��9��19������4:17:29
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:ManagerInfServiceImp.java
 *��˵����������Ϣ�ĸ��˴���ʵ�ֲ㡣������Ȩ�ޣ�
 */

public class ManagerInfServiceImp implements ManagerInfService{

	@Override
	public Manager managerLoginService(Manager m, int type) {
		//�������ݲ�ӿ����͵ı�����ʹ�øñ���ָ��ʵ�ָýӿ����ʵ����Ķ���
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
