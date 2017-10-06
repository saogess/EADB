/**
*创建时间：2017-8-22上午8:34:07
*项目名称：2017_EADBproject
*@author 李佩恒
*@version 1.0
*@since JDK 1.7.0_21
*文件名称:NoticeService.java
*类说明：公告信息的服务层接口
*/
package com.EADB.service;

import java.util.List;

import com.EADB.model.Notice;

public interface NoticeService {

	/**
	 * 公告添加
	 */
	boolean noticeRegist(Notice notice);

	/**
	 * 公告删除
	 */
	boolean noticeDelete(int id);

	/**
	 * 查询所有公告
	 */
	List<Notice> queryNoticeInfo();

	/**
	 * 修改
	 */
	boolean noticeUpdate(Notice notice);

	/**
	 * 查询单个公告
	 */
	Notice findByNotice(int id);

	/**
	 * 查询最新公告
	 */
	List<Notice> queryNweNoticeInfo();

	/**
	 * @param id
	 * @return
	 */
	List<Notice> NoticeQuery(int id);

}
