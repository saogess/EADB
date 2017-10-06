package com.EADB.dao;

import java.util.List;

import com.EADB.model.Diary;


/**
 *创建时间：2017年9月21日下午4:03:49
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:DiaryDao.java
 *类说明：
 */

public interface DiaryDao {
	//添加日记
	boolean DiaryInsert(Diary d);
	
	//个人日记信息查询
	List<Diary> DiaryQuery(int uId);
	
	//修改
	boolean DiaryUpdate(Diary d);
	
	//根据id查询
	Diary DiaryQueryById(int dId);

}
