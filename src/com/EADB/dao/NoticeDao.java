/**
*����ʱ�䣺2017-8-22����8:32:49
*��Ŀ���ƣ�
2017_EADBproject
*@author �����
*@version 1.0
*@since JDK 1.7.0_21
*�ļ�����:INoticeDao.java
*��˵�������湦�ܵ�dao��ӿڷ���
*/
package com.EADB.dao;

import java.util.List;

import com.EADB.model.Notice;

public interface NoticeDao {

	/**
	 * �������
	 */
	boolean noticeRegist(Notice noticeEntity);
	
	/**
	 * ����ɾ��
	 */
	boolean noticeDelete(int id);

	/*
	 * ��ѯ���й���
	 */
	List<Notice> queryNoticeInfo();
	
	/*
	 * �޸�
	 */
	boolean noticeUpdate(Notice notice);
	
	/*
	 * ��ѯ��������
	 */
	Notice findByNotice(int nid);

	/*
	 * ��ѯ���¹���
	 */
	List<Notice> queryNweNoticeInfo();

	/**
	 * ����ѯ
	 */
	List<Notice> NoticeQuery(int id);
}
