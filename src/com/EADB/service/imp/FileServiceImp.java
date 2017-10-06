package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.FileDao;
import com.EADB.dao.imp.FileDaoImp;
import com.EADB.model.FileInf;
import com.EADB.service.FileService;

/**
 *����ʱ�䣺2017��9��26������8:57:00
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:FileServiceImp.java
 *��˵�����ļ���Ϣ�ķ����ʵ�ַ���
 */

public class FileServiceImp implements FileService{

	@Override
	public boolean insertFileService(FileInf f) {
		FileDao fd=new FileDaoImp();
		boolean flag=fd.insertFile(f);
		return flag;
	}

	@Override
	public List<FileInf> findAllFileService() {
		FileDao fd=new FileDaoImp();
		List<FileInf> list=fd.findAllFile();
		return list;
	}

	@Override
	public FileInf findByFnumService(int fId) {
		FileDao fd=new FileDaoImp();
		FileInf f=fd.findByFnumFile(fId);
		return f;
	}

}
