package com.EADB.service;

import java.util.List;

import com.EADB.model.FileInf;

/**
 *����ʱ�䣺2017��9��26������8:53:21
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:FileService.java
 *��˵�����ļ���Ϣ�ķ����ӿ�
 */

public interface FileService {
	//�ϴ��ļ�
	public boolean insertFileService(FileInf f);
	//�鿴ȫ���ļ���Ϣ
	public List<FileInf> findAllFileService();
	//�鿴�ļ���ϸ
	public FileInf findByFnumService(int fId);
}
