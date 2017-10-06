package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.FileDao;
import com.EADB.model.FileInf;
import com.EADB.util.JDBCUtil;

/**
 *����ʱ�䣺2017��9��26������8:36:16
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:FileDaoImp.java
 *��˵�����ļ������Daoʵ�ֲ�
 */

public class FileDaoImp implements FileDao{

	//�����ļ���Ϣ
	@Override
	public boolean insertFile(FileInf f) {
		//׼��SQL���
		String sql="INSERT INTO fileinf(fNum,fName,fTime,fPath,maId) VALUES (?,?,?,?,?)";
		//��дSQL������
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(f.getfNum());
		paras.add(f.getfName());
		paras.add(f.getfTime());
		paras.add(f.getfPath());
		paras.add(f.getMaId());
		//ִ�����ݿ����
		boolean flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}

	//�鿴�ļ���Ϣ(ȫ��)
	@Override
	public List<FileInf> findAllFile() {
		//׼��SQL���
		String sql="SELECT f.fId,m.mid,m.managername,m.position,f.fNum,f.fName,f.fTime FROM fileinf AS f,manager AS m WHERE f.maId=m.id";
		//ִ�����ݿ����
		List<FileInf> list=JDBCUtil.QueryListExcute(sql, null, FileInf.class);
		return list;
	}

	//�鿴�ļ���Ϣ(����)
	@Override
	public FileInf findByFnumFile(int fId) {
		//׼��SQL���
		String sql="SELECT m.mid,m.managername,m.position,f.fNum,f.fName,f.fTime,f.fPath "
				+ "FROM fileinf AS f,manager AS m WHERE f.fId=? AND f.maId=m.id";
		//��дSQL������
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(fId);
		//ִ�����ݿ����
		FileInf f=JDBCUtil.findBySingleObject(sql, paras, FileInf.class);
		return f;
	}

}
