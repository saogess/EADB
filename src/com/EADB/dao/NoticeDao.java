/**
*创建时间：2017-8-22上午8:32:49
*项目名称：
2017_EADBproject
*@author 李佩恒
*@version 1.0
*@since JDK 1.7.0_21
*文件名称:INoticeDao.java
*类说明：公告功能的dao层接口方法
*/
package com.EADB.dao;

import java.util.List;

import com.EADB.model.Notice;

public interface NoticeDao {

	/**
	 * 公告添加
	 */
	boolean noticeRegist(Notice noticeEntity);
	
	/**
	 * 公告删除
	 */
	boolean noticeDelete(int id);

	/*
	 * 查询所有公告
	 */
	List<Notice> queryNoticeInfo();
	
	/*
	 * 修改
	 */
	boolean noticeUpdate(Notice notice);
	
	/*
	 * 查询单个公告
	 */
	Notice findByNotice(int nid);

	/*
	 * 查询最新公告
	 */
	List<Notice> queryNweNoticeInfo();

	/**
	 * 多表查询
	 */
	List<Notice> NoticeQuery(int id);
}
