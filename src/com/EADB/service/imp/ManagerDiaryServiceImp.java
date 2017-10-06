package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.ManagerDiaryDao;
import com.EADB.dao.imp.ManagerDiaryDaoImp;
import com.EADB.model.ManagerDiary;
import com.EADB.service.ManagerDiaryService;

/**
 *创建时间：2017年9月22日上午9:21:47
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:ManagerDiaryServiceImp.java
 *类说明：经理日志服务层方法
 */

public class ManagerDiaryServiceImp implements ManagerDiaryService{

	//添加经理日志
	@Override
	public boolean insertManagerDiary(ManagerDiary md) {
		ManagerDiaryDao mdd=new ManagerDiaryDaoImp();
		boolean flag=mdd.insertDiary(md);
		return flag;
	}

	//查询日志信息
	@Override
	public List<ManagerDiary> showAllManagerDiary(String mid) {
		ManagerDiaryDao mdd=new ManagerDiaryDaoImp();
		List<ManagerDiary> list=mdd.findAllDiaryInf(mid);
		return list;
	}

	//查询日志信息(内容)
	@Override
	public ManagerDiary showOneManagerDiary(int dId) {
		ManagerDiaryDao mdd=new ManagerDiaryDaoImp();
		ManagerDiary md=mdd.findByDIdDiaryInf(dId);
		return md;
	}

	//修改经理日志
	@Override
	public boolean updateManagerDairy(ManagerDiary md) {
		ManagerDiaryDao mdd=new ManagerDiaryDaoImp();
		boolean flag=mdd.updateDiary(md);
		return flag;
	}

}
