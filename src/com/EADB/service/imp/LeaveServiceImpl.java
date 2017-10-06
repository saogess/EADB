package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.LeaveDao;
import com.EADB.dao.imp.LeaveDaoImpl;
import com.EADB.model.LeaveEntity;
import com.EADB.model.LeaveNum;
import com.EADB.service.LeaveService;

/**
 *����ʱ�䣺2017��9��20������3:43:05
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:LeaveServiceImpl.java
 *��˵����
 */

public class LeaveServiceImpl implements LeaveService{
	//���
	public boolean LeaveInsert(LeaveEntity l){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveInsert(l);
	}
	
	//���������Ϣ��ѯ
	public List<LeaveEntity> LeaveQuery(String username){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveQuery(username);
	}
	
	//�����Ϣɾ��
	public boolean LeaveDelete(String lId){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveDelete(lId);
	}
	
	//������ٴ�����ѯ
	public LeaveNum QueryNum(String username){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.QueryNum(username);
	}
	
	//��������
	public boolean LeaveCancel(LeaveEntity l){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveCancel(l);
	}
	
	//����id��ѯ
	public LeaveEntity LeaveEntityQueryById(int lId){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveEntityQueryById(lId);
	}
	
	//�޸�
	public boolean LeaveUpdate(LeaveEntity l){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveUpdate(l);
	}
	
	//ÿ���޸�Ĭ����ٴ���
	public boolean NumUpdate(LeaveNum ln){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.NumUpdate(ln);
	}
	
	//�������
	public boolean LeaveExam(LeaveEntity l){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveExam(l);
	}
	
	//�����ѯ���������Ϣ
	public List<LeaveEntity> LeaveQueryAll(){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveQueryAll();
	}
	
	//��ѯ����������Ϣ
	public List<LeaveEntity> QueryByCanceltype(String lCanceltype){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.QueryByCanceltype(lCanceltype);
	}
	
	//������׼
	public boolean LeaveCancelUpdate(LeaveEntity l){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveCancelUpdate(l);
	}

}
