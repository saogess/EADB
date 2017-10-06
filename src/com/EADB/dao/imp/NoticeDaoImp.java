/**
*创建时间：2017-8-22上午8:33:22
*项目名称：
2017_EADBproject
*@author 李佩恒
*@version 1.0
*@since JDK 1.7.0_21
*文件名称:NoticeDaoImp.java
*类说明：公告功能的dao层实现方法
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
	 * 公告添加
	 */
	public boolean noticeRegist(Notice notice) {
		boolean flag = false;
		//准备SQL语句
		String strsql = "insert into noticeInf (nid,time,notice,adminid) values (?,?,?,?)";
		//准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(notice.getNid());
		paras.add(notice.getTime());
		paras.add(notice.getNotice());
		paras.add(notice.getAdminid());
		// 调用公共处理类
		flag = JDBCUtil.InsertUpdateDeleteExcute(strsql, paras);
		return flag;
	}
	
	/* 
	 * 查询所有公告
	 */
	public List<Notice> queryNoticeInfo(){
		List<Notice> noticeList = new ArrayList<Notice>();
		// 准备查询sql语句
		String strSql = "select * from noticeInf";
		//没有参数就可以传入null
		noticeList =JDBCUtil.QueryListExcute(strSql, null, Notice.class);	
		return noticeList;
	}

	/* 
	 * 修改
	 */
	@Override
	public boolean noticeUpdate(Notice notice) {
		boolean flag = false;
		// 准备SQL语句
		String strsql = "update noticeInf set time=?,notice=? where nid=?";
		// 准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(notice.getTime());
		paras.add(notice.getNotice());
		paras.add(notice.getNid());
		//调用公共处理类
		flag = JDBCUtil.InsertUpdateDeleteExcute(strsql, paras);
		return flag;
	}

	/* 
	 * 删除公告
	 */
	@Override
	public boolean noticeDelete(int id) {
		boolean flag = false;
		String strsql = "delete from noticeInf where nid=?"; // ?表示一个占位符，这条语句就叫预编译语句
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(id);
		//调用公共处理类
		flag = JDBCUtil.InsertUpdateDeleteExcute(strsql, paras);
		return flag;
	}

	/*
	 * 查询单公告
	 */
	@Override
	public Notice findByNotice(int nid) {
		//准备SQL语句。
		String sql="select * from noticeinf where nid=?";
		//准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(nid);
		//调用公共处理类
		Notice n=JDBCUtil.findBySingleObject(sql, paras, Notice.class);
		return n;
	}

	/* 
	 * 查询最新公告
	 */
	@Override
	public List<Notice> queryNweNoticeInfo() {
		List<Notice> noticeList = new ArrayList<Notice>();
		//准备查询SQL语句
		String strSql = "SELECT * FROM noticeinf ORDER BY noticeinf.id DESC LIMIT 1";
		//没有参数就可以传入null
		noticeList =JDBCUtil.QueryListExcute(strSql, null, Notice.class);	
		return noticeList;
	}
	
	//多表查询
	public List<Notice> NoticeQuery(int id){
	//准备sql语句
	String sql = "SELECT a.id AS uid,a.userName,n.id,n.nid,n.time,n.notice,n.adminid FROM admin AS a,noticeinf AS n WHERE a.id=n.adminid AND n.adminid=?";
	//准备参数的值
	ArrayList<Object> paras = new ArrayList<Object>();
	paras.add(id);
	//调用数据库公共处理类
	return JDBCUtil.QueryListExcute(sql, paras, Notice.class);
	
}

}
