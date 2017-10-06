package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.FileDao;
import com.EADB.dao.imp.FileDaoImp;
import com.EADB.model.FileInf;
import com.EADB.service.FileService;

/**
 *创建时间：2017年9月26日上午8:57:00
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:FileServiceImp.java
 *类说明：文件信息的服务层实现方法
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
