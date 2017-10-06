/*
*����ʱ�䣺2017-8-22����8:34:25
*��Ŀ���ƣ�2017_EADBproject
*@author �����
*@version 1.0
*@since JDK 1.7.0_21
*�ļ�����:NoticeServiceImpl.java
*��˵����������Ϣ�ķ����ʵ��
*/
package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.NoticeDao;
import com.EADB.dao.imp.NoticeDaoImp;
import com.EADB.model.Notice;
import com.EADB.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	/* 
	 * ��ӹ���
	 */
	public boolean noticeRegist(Notice notice) {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.noticeRegist(notice);
	}

	/* 
	 * ɾ������
	 */
	@Override
	public boolean noticeDelete(int id) {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.noticeDelete(id);
	}

	/* 
	 * ��ѯ����
	 */
	public List<Notice> queryNoticeInfo() {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.queryNoticeInfo();
	}

	/* 
	 * �޸�
	 */
	@Override
	public boolean noticeUpdate(Notice notice) {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.noticeUpdate(notice);
	}

	/*
	 * ��ѯ������
	 */
	@Override
	public Notice findByNotice(int nid) {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.findByNotice(nid);
	}

	/*
	 * ��ѯ���¹���
	 */
	@Override
	public List<Notice> queryNweNoticeInfo() {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.queryNweNoticeInfo();
	}

	/* ����ѯ
	 */
	@Override
	public List<Notice> NoticeQuery(int id) {
		NoticeDao noticedao=new NoticeDaoImp();
		return noticedao.NoticeQuery(id);
	}

}
