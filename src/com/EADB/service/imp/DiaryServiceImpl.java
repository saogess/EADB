package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.DiaryDao;
import com.EADB.dao.imp.DiaryDaoImpl;
import com.EADB.model.Diary;
import com.EADB.service.DiaryService;

/**
 *创建时间：2017年9月21日下午4:17:13
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:DiaryServiceImpl.java
 *类说明：
 */

public class DiaryServiceImpl implements DiaryService{
	//添加日记
	public boolean DiaryInsert(Diary d){
		DiaryDao diarydao = new DiaryDaoImpl();
		return diarydao.DiaryInsert(d);
	}
	
	//个人日记信息查询
	public List<Diary> DiaryQuery(int uId){
		DiaryDao diarydao = new DiaryDaoImpl();
		return diarydao.DiaryQuery(uId);
	}
	
	//修改
	public boolean DiaryUpdate(Diary d){
		DiaryDao diarydao = new DiaryDaoImpl();
		return diarydao.DiaryUpdate(d);
	}
	
	//根据id查询
	public Diary DiaryQueryById(int dId){
		DiaryDao diarydao = new DiaryDaoImpl();
		return diarydao.DiaryQueryById(dId);
	}

}
