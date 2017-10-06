package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.DiaryDao;
import com.EADB.dao.imp.DiaryDaoImpl;
import com.EADB.model.Diary;
import com.EADB.service.DiaryService;

/**
 *����ʱ�䣺2017��9��21������4:17:13
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:DiaryServiceImpl.java
 *��˵����
 */

public class DiaryServiceImpl implements DiaryService{
	//����ռ�
	public boolean DiaryInsert(Diary d){
		DiaryDao diarydao = new DiaryDaoImpl();
		return diarydao.DiaryInsert(d);
	}
	
	//�����ռ���Ϣ��ѯ
	public List<Diary> DiaryQuery(int uId){
		DiaryDao diarydao = new DiaryDaoImpl();
		return diarydao.DiaryQuery(uId);
	}
	
	//�޸�
	public boolean DiaryUpdate(Diary d){
		DiaryDao diarydao = new DiaryDaoImpl();
		return diarydao.DiaryUpdate(d);
	}
	
	//����id��ѯ
	public Diary DiaryQueryById(int dId){
		DiaryDao diarydao = new DiaryDaoImpl();
		return diarydao.DiaryQueryById(dId);
	}

}
