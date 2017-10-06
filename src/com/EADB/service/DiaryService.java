package com.EADB.service;

import java.util.List;

import com.EADB.model.Diary;
/**
 *����ʱ�䣺2017��9��21������4:16:40
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:DiaryService.java
 *��˵����
 */

public interface DiaryService {
	//����ռ�
	boolean DiaryInsert(Diary d);
	
	//�����ռ���Ϣ��ѯ
	List<Diary> DiaryQuery(int uId);
	
	//�޸�
	boolean DiaryUpdate(Diary d);
	
	//����id��ѯ
	Diary DiaryQueryById(int dId);

}
