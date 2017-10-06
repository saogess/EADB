/**
*����ʱ�䣺2017-8-22����8:34:07
*��Ŀ���ƣ�2017_EADBproject
*@author �����
*@version 1.0
*@since JDK 1.7.0_21
*�ļ�����:NoticeService.java
*��˵����������Ϣ�ķ����ӿ�
*/
package com.EADB.service;

import java.util.List;

import com.EADB.model.Notice;

public interface NoticeService {

	/**
	 * �������
	 */
	boolean noticeRegist(Notice notice);

	/**
	 * ����ɾ��
	 */
	boolean noticeDelete(int id);

	/**
	 * ��ѯ���й���
	 */
	List<Notice> queryNoticeInfo();

	/**
	 * �޸�
	 */
	boolean noticeUpdate(Notice notice);

	/**
	 * ��ѯ��������
	 */
	Notice findByNotice(int id);

	/**
	 * ��ѯ���¹���
	 */
	List<Notice> queryNweNoticeInfo();

	/**
	 * @param id
	 * @return
	 */
	List<Notice> NoticeQuery(int id);

}
