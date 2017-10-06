package com.EADB.service;

import java.util.List;

import com.EADB.model.LeaveEntity;
import com.EADB.model.LeaveNum;

/**
 *����ʱ�䣺2017��9��20������3:42:32
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:LeaveService.java
 *��˵����
 */

public interface LeaveService {
	//���
	boolean LeaveInsert(LeaveEntity l);
	
	//���������Ϣ��ѯ
	List<LeaveEntity> LeaveQuery(String username);
	
	//�����Ϣɾ��
	boolean LeaveDelete(String lId);
	
	//������ٴ�����ѯ
	LeaveNum QueryNum(String username);
	
	//��������
	boolean LeaveCancel(LeaveEntity l);
	
	//����id��ѯ
	LeaveEntity LeaveEntityQueryById(int lId);
	
	//�޸�
	boolean LeaveUpdate(LeaveEntity l);
	
	//ÿ���޸�Ĭ����ٴ���
	boolean NumUpdate(LeaveNum ln);
	
	//�������
	boolean LeaveExam(LeaveEntity l);
	
	//�����ѯ���������Ϣ
	List<LeaveEntity> LeaveQueryAll();
	
	//��ѯ����������Ϣ
	List<LeaveEntity> QueryByCanceltype(String lCanceltype);
	
	//������׼
	boolean LeaveCancelUpdate(LeaveEntity l);

}
