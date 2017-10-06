package com.EADB.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.LeaveDao;
import com.EADB.model.LeaveEntity;
import com.EADB.model.LeaveNum;
import com.EADB.util.JDBCUtil;

/**
 *创建时间：2017年9月20日下午3:18:10
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:LeaveDaoImpl.java
 *类说明：
 */

public class LeaveDaoImpl implements LeaveDao{
	//请假
	@SuppressWarnings("resource")
	public boolean LeaveInsert(LeaveEntity l){
		Connection conn = null;
		PreparedStatement pst = null;
		int result1 = 0;
		int result2 = 0;
		boolean flag = false;
		//向请假表插入信息
		String sql1 = "insert into leaveinf(userid,username,lReason,lStarttime,lDays,lLeavetype,lAudittype,lCanceltype)"+ 
				"values(?,?,?,?,?,?,?,?)";
		//修改请假次数表剩余请假次数
		String sql2 = "update leavenum set lnNum=lnNum-1 where username=?";
		try {
			conn = JDBCUtil.getConnection();
			//取消事务自动提交
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sql1);
			pst.setString(1, l.getUserid());
			pst.setString(2, l.getUsername());
			pst.setString(3, l.getlReason());
			pst.setString(4, l.getlStarttime());
			pst.setString(5, l.getlDays());
			pst.setString(6, l.getlLeavetype());
			pst.setString(7, l.getlAudittype());
			pst.setString(8,l.getlCanceltype());
			result1 = pst.executeUpdate();
			pst = conn.prepareStatement(sql2);
			pst.setString(1, l.getUsername());
			result2 = pst.executeUpdate();
			//手动提交
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
				JDBCUtil.close(conn, pst);
		}
		if (result1>0&&result2>0) {
			flag = true;
		}
		return flag;
	}
	
	//个人请假信息查询
	public List<LeaveEntity> LeaveQuery(String username){
		//准备sql语句
		String sql = "select * from leaveinf where username=?";
		//准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(username);
		//调用数据库公共处理类
		return JDBCUtil.QueryListExcute(sql, paras, LeaveEntity.class);
	}
	
	//请假信息删除
	public boolean LeaveDelete(String lId){
		boolean flag=false;
		//准备sql语句
		String sql = "delete from leaveinf where lId=?"; 
		//准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(lId);
		//调用数据库公共处理类
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}
	
	//个人请假次数查询
	public LeaveNum QueryNum(String username){
		//准备sql语句
		String sql = "select * from leavenum where username=?";
		//准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(username);
		//调用数据库公共处理类
		return JDBCUtil.findBySingleObject(sql, paras, LeaveNum.class);
	}
	
	//请求销假
	public boolean LeaveCancel(LeaveEntity l){
		boolean flag=false;
		//准备sql语句
		String sql = "update leaveinf set lCanceltype=? where lId=?"; 
		//准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(l.getlCanceltype());
		paras.add(l.getlId());
		//调用数据库公共处理类
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}
	
	//根据id查询
	public LeaveEntity LeaveEntityQueryById(int lId){
		//准备sql语句
		String sql = "select * from leaveinf where lId=?";
		//准备参数的值
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(lId);
		//调用数据库公共处理类
		return JDBCUtil.findBySingleObject(sql, paras, LeaveEntity.class);
	}
	
	//修改(只能修改未审核的)
	public boolean LeaveUpdate(LeaveEntity l){
		boolean flag=false;
		//准备SQL语句
		String sql="update leaveinf set lReason=?,lStarttime=?,lDays=? where lId=?";
		//准备参数的值
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(l.getlReason());
		list.add(l.getlStarttime());
		list.add(l.getlDays());
		list.add(l.getlId());
		//进行数据库操作
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	
	//每月修改所有人默认请假次数
	public boolean NumUpdate(LeaveNum ln){
		boolean flag=false;
		//准备SQL语句
		String sql="update leavenum set lnNum=?";
		//准备参数的值
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(ln.getLnNum());
		//进行数据库操作
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//经理审核
	public boolean LeaveExam(LeaveEntity l) {
		boolean flag=false;
		//准备SQL语句
		String sql="update leaveinf set lLeavetype=?,lAudittype=? where lId=? and lAudittype=?";
		//准备参数的值
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(l.getlLeavetype());
		list.add(l.getlAudittype());
		list.add(l.getlId());
		list.add("待审核");
		//进行数据库操作
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//经理查询所有请假信息
	public List<LeaveEntity> LeaveQueryAll(){
		List<LeaveEntity> list=new ArrayList<LeaveEntity>();
		//准备SQL语句
		String sql="select * from leaveinf";
		//进行数据库操作
		list=JDBCUtil.QueryListExcute(sql, null, LeaveEntity.class);
		return list;
	}
	
	//查询所有销假信息
	public List<LeaveEntity> QueryByCanceltype(String lCanceltype){
		List<LeaveEntity> list=new ArrayList<LeaveEntity>();
		//准备SQL语句
		String sql="select * from leaveinf where lCanceltype=?";
		//准备参数的值
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(lCanceltype);
		//进行数据库操作
		list=JDBCUtil.QueryListExcute(sql, paras, LeaveEntity.class);
		return list;
	}
	
	//销假批准
	public boolean LeaveCancelUpdate(LeaveEntity l){
		boolean flag=false;
		//准备SQL语句
		String sql="update leaveinf set lCanceltype=? where lId=?";
		//准备参数的值
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(l.getlCanceltype());
		list.add(l.getlId());
		//进行数据库操作
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}

}
