package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.DiaryDao;
import com.EADB.model.Diary;
import com.EADB.util.JDBCUtil;

/**
 *����ʱ�䣺2017��9��21������4:11:48
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:DiaryDaoImpl.java
 *��˵����
 */

public class DiaryDaoImpl implements DiaryDao{
	//����ռ�
	public boolean DiaryInsert(Diary d){
		boolean flag=false;
		//׼��SQL���
		String sql="insert into diary(uId,dTitle,dContent,dStarttime,dModifytime) "
				+ "values(?,?,?,?,?)";
		//׼��������ֵ
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(d.getuId());
		list.add(d.getdTitle());
		list.add(d.getdContent());
		list.add(d.getdStarttime());
		list.add(d.getdModifytime());
		/*list.add(u.getuPicUrl());*/
		//�������ݿ⹫��������
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//�����ռ���Ϣ��ѯ
	public List<Diary> DiaryQuery(int uId){
		//׼��sql���
		String sql = "SELECT u.userid,u.username,d.dId,d.dTitle,d.dContent,d.dStarttime,d.dModifytime FROM userinf AS u,diary AS d WHERE u.uId=d.uId AND d.uId=?";
		//׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(uId);
		//�������ݿ⹫��������
		return JDBCUtil.QueryListExcute(sql, paras, Diary.class);
	}
	
	//�޸�
	public boolean DiaryUpdate(Diary d){
		boolean flag=false;
		//׼��SQL���
		String sql="update diary set dTitle=?,dContent=?,dModifytime=? where dId=?";
		//׼��������ֵ
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(d.getdTitle());
		list.add(d.getdContent());
		list.add(d.getdModifytime());
		list.add(d.getdId());
		//�������ݿ����
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//����id��ѯ
	public Diary DiaryQueryById(int dId){
		//׼��sql���
		String sql = "select * from diary where dId=?";
		//׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(dId);
		//�������ݿ⹫��������
		return JDBCUtil.findBySingleObject(sql, paras, Diary.class);
	}

}
