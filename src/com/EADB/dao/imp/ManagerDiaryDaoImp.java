package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.ManagerDiaryDao;
import com.EADB.model.Manager;
import com.EADB.model.ManagerDiary;
import com.EADB.util.JDBCUtil;

/**
 *����ʱ�䣺2017��9��21������6:11:02
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:ManagerDiaryDaoImp.java
 *��˵���������ռǵ�ʵ�ֲ�
 */

public class ManagerDiaryDaoImp implements ManagerDiaryDao{

	//�鿴�ռ�(����)
	@Override
	public List<ManagerDiary> findAllDiaryInf(String mid) {
		//׼��SQL���
		String sql="SELECT m.mid,m.managername,d.dId,d.dStarttime,d.dModifytime,d.dTitle FROM managerdiary AS d,manager as m WHERE d.managerId=? and m.id=d.managerId";
		//��дSQL������
		ArrayList<Object> paras=new ArrayList<Object>();
		ManagerInfDaoImp midi=new ManagerInfDaoImp();
		Manager m=midi.findByMidManagerInf(mid);
		paras.add(m.getId());
		//ִ�����ݿ����
		List<ManagerDiary> list=JDBCUtil.QueryListExcute(sql, paras, ManagerDiary.class);
		return list;
	}

	//�鿴�ռ�(����)
	@Override
	public ManagerDiary findByDIdDiaryInf(int id) {
		//׼��SQL���
		String sql="SELECT d.dId,d.dStarttime,d.dModifytime,d.dTitle,d.dContent FROM managerdiary AS d WHERE dId=?";
		//��дSQL������
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(id);
		//ִ�����ݿ����
		ManagerDiary md=JDBCUtil.findBySingleObject(sql, paras, ManagerDiary.class);
		return md;
	}

	//����ռ�
	@Override
	public boolean insertDiary(ManagerDiary md) {
		//׼��SQL���
		String sql="INSERT INTO managerdiary(managerId,dTitle,dContent,dStarttime,dModifytime) VALUES (?,?,?,?,?)";
		//��дSQL������
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(md.getManagerId());
		paras.add(md.getdTitle());
		paras.add(md.getdContent());
		paras.add(md.getdStarttime());
		paras.add(md.getdModifytime());
		//ִ�����ݿ����
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}

	//�޸��ռ�
	@Override
	public boolean updateDiary(ManagerDiary md) {
		//׼��SQL���
		String sql="UPDATE managerdiary SET dTitle=?,dContent=?,dModifytime=? WHERE dId=?";
		//��дSQL������
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(md.getdTitle());
		paras.add(md.getdContent());
		paras.add(md.getdModifytime());
		paras.add(md.getdId());
		//ִ�����ݿ����
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}

	//ɾ���ռ�
	@Override
	public boolean deleteDiary(ManagerDiary md) {
		//׼��SQL���
		String sql="delete from managerdiary where dId=?";
		//��дSQL������
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(md.getdId());
		//ִ�����ݿ����
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}
	
}
