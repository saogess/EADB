/*
*创建时间：2017-8-22上午8:34:25
*项目名称：2017_EADBproject
*@author 李佩恒
*@version 1.0
*@since JDK 1.7.0_21
*文件名称:NoticeServiceImpl.java
*类说明：公告信息的服务层实现
*/
package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.NoticeDao;
import com.EADB.dao.imp.NoticeDaoImp;
import com.EADB.model.Notice;
import com.EADB.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	/* 
	 * 添加公告
	 */
	public boolean noticeRegist(Notice notice) {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.noticeRegist(notice);
	}

	/* 
	 * 删除公告
	 */
	@Override
	public boolean noticeDelete(int id) {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.noticeDelete(id);
	}

	/* 
	 * 查询所有
	 */
	public List<Notice> queryNoticeInfo() {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.queryNoticeInfo();
	}

	/* 
	 * 修改
	 */
	@Override
	public boolean noticeUpdate(Notice notice) {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.noticeUpdate(notice);
	}

	/*
	 * 查询单公告
	 */
	@Override
	public Notice findByNotice(int nid) {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.findByNotice(nid);
	}

	/*
	 * 查询最新公告
	 */
	@Override
	public List<Notice> queryNweNoticeInfo() {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.queryNweNoticeInfo();
	}

	/* 多表查询
	 */
	@Override
	public List<Notice> NoticeQuery(int id) {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.NoticeQuery(id);
	}

}
