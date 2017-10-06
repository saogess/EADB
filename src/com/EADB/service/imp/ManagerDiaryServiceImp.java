package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.ManagerDiaryDao;
import com.EADB.dao.imp.ManagerDiaryDaoImp;
import com.EADB.model.ManagerDiary;
import com.EADB.service.ManagerDiaryService;

/**
 *����ʱ�䣺2017��9��22������9:21:47
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:ManagerDiaryServiceImp.java
 *��˵����������־����㷽��
 */

public class ManagerDiaryServiceImp implements ManagerDiaryService{

	//��Ӿ�����־
	@Override
	public boolean insertManagerDiary(ManagerDiary md) {
		ManagerDiaryDao mdd=new ManagerDiaryDaoImp();
		boolean flag=mdd.insertDiary(md);
		return flag;
	}

	//��ѯ��־��Ϣ
	@Override
	public List<ManagerDiary> showAllManagerDiary(String mid) {
		ManagerDiaryDao mdd=new ManagerDiaryDaoImp();
		List<ManagerDiary> list=mdd.findAllDiaryInf(mid);
		return list;
	}

	//��ѯ��־��Ϣ(����)
	@Override
	public ManagerDiary showOneManagerDiary(int dId) {
		ManagerDiaryDao mdd=new ManagerDiaryDaoImp();
		ManagerDiary md=mdd.findByDIdDiaryInf(dId);
		return md;
	}

	//�޸ľ�����־
	@Override
	public boolean updateManagerDairy(ManagerDiary md) {
		ManagerDiaryDao mdd=new ManagerDiaryDaoImp();
		boolean flag=mdd.updateDiary(md);
		return flag;
	}

}
