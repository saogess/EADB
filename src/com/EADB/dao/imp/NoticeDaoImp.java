/**
*����ʱ�䣺2017-8-22����8:33:22
*��Ŀ���ƣ�
2017_EADBproject
*@author �����
*@version 1.0
*@since JDK 1.7.0_21
*�ļ�����:NoticeDaoImp.java
*��˵�������湦�ܵ�dao��ʵ�ַ���
*/
package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.NoticeDao;
import com.EADB.model.ManagerEntity;
import com.EADB.model.Notice;
import com.EADB.util.JDBCUtil;

public class NoticeDaoImp implements NoticeDao {
	/* 
	 * �������
	 */
	public boolean noticeRegist(Notice notice) {
		boolean flag = false;
		//׼��SQL���
		String strsql = "insert into noticeInf (nid,time,notice,adminid) values (?,?,?,?)";
		//׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(notice.getNid());
		paras.add(notice.getTime());
		paras.add(notice.getNotice());
		paras.add(notice.getAdminid());
		// ���ù���������
		flag = JDBCUtil.InsertUpdateDeleteExcute(strsql, paras);
		return flag;
	}
	
	/* 
	 * ��ѯ���й���
	 */
	public List<Notice> queryNoticeInfo(){
		List<Notice> noticeList = new ArrayList<Notice>();
		// ׼����ѯsql���
		String strSql = "select * from noticeInf";
		//û�в����Ϳ��Դ���null
		noticeList =JDBCUtil.QueryListExcute(strSql, null, Notice.class);	
		return noticeList;
	}

	/* 
	 * �޸�
	 */
	@Override
	public boolean noticeUpdate(Notice notice) {
		boolean flag = false;
		// ׼��SQL���
		String strsql = "update noticeInf set time=?,notice=? where nid=?";
		// ׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(notice.getTime());
		paras.add(notice.getNotice());
		paras.add(notice.getNid());
		//���ù���������
		flag = JDBCUtil.InsertUpdateDeleteExcute(strsql, paras);
		return flag;
	}

	/* 
	 * ɾ������
	 */
	@Override
	public boolean noticeDelete(int id) {
		boolean flag = false;
		String strsql = "delete from noticeInf where nid=?"; // ?��ʾһ��ռλ�����������ͽ�Ԥ�������
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(id);
		//���ù���������
		flag = JDBCUtil.InsertUpdateDeleteExcute(strsql, paras);
		return flag;
	}

	/*
	 * ��ѯ������
	 */
	@Override
	public Notice findByNotice(int nid) {
		//׼��SQL��䡣
		String sql="select * from noticeinf where nid=?";
		//׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(nid);
		//���ù���������
		Notice n=JDBCUtil.findBySingleObject(sql, paras, Notice.class);
		return n;
	}

	/* 
	 * ��ѯ���¹���
	 */
	@Override
	public List<Notice> queryNweNoticeInfo() {
		List<Notice> noticeList = new ArrayList<Notice>();
		//׼����ѯSQL���
		String strSql = "SELECT * FROM noticeinf ORDER BY noticeinf.id DESC LIMIT 1";
		//û�в����Ϳ��Դ���null
		noticeList =JDBCUtil.QueryListExcute(strSql, null, Notice.class);	
		return noticeList;
	}
	
	//����ѯ
	public List<Notice> NoticeQuery(int id){
	//׼��sql���
	String sql = "SELECT a.id AS uid,a.userName,n.id,n.nid,n.time,n.notice,n.adminid FROM admin AS a,noticeinf AS n WHERE a.id=n.adminid AND n.adminid=?";
	//׼��������ֵ
	ArrayList<Object> paras = new ArrayList<Object>();
	paras.add(id);
	//�������ݿ⹫��������
	return JDBCUtil.QueryListExcute(sql, paras, Notice.class);
	
}

}
