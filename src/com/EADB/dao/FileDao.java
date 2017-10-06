package com.EADB.dao;

import java.util.List;

import com.EADB.model.FileInf;

/**
 *����ʱ�䣺2017��9��26������8:33:30
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:FileDao.java
 *��˵�����ļ������Dao�ӿ�
 */

public interface FileDao {
	//�����ļ���Ϣ
	public boolean insertFile(FileInf f);
	//�鿴�ļ���Ϣ(ȫ��)
	public List<FileInf> findAllFile();
	//�鿴�ļ���Ϣ(����)
	public FileInf findByFnumFile(int fId);
}
