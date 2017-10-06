package com.EADB.dao;

import java.util.List;

import com.EADB.model.Diary;


/**
 *����ʱ�䣺2017��9��21������4:03:49
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:DiaryDao.java
 *��˵����
 */

public interface DiaryDao {
	//����ռ�
	boolean DiaryInsert(Diary d);
	
	//�����ռ���Ϣ��ѯ
	List<Diary> DiaryQuery(int uId);
	
	//�޸�
	boolean DiaryUpdate(Diary d);
	
	//����id��ѯ
	Diary DiaryQueryById(int dId);

}
