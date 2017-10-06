package com.EADB.service;

import java.util.List;

import com.EADB.model.FileInf;

/**
 *创建时间：2017年9月26日上午8:53:21
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:FileService.java
 *类说明：文件信息的服务层接口
 */

public interface FileService {
	//上传文件
	public boolean insertFileService(FileInf f);
	//查看全部文件信息
	public List<FileInf> findAllFileService();
	//查看文件详细
	public FileInf findByFnumService(int fId);
}
