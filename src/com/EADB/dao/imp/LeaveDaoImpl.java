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
 *����ʱ�䣺2017��9��20������3:18:10
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:LeaveDaoImpl.java
 *��˵����
 */

public class LeaveDaoImpl implements LeaveDao{
	//���
	@SuppressWarnings("resource")
	public boolean LeaveInsert(LeaveEntity l){
		Connection conn = null;
		PreparedStatement pst = null;
		int result1 = 0;
		int result2 = 0;
		boolean flag = false;
		//����ٱ������Ϣ
		String sql1 = "insert into leaveinf(userid,username,lReason,lStarttime,lDays,lLeavetype,lAudittype,lCanceltype)"+ 
				"values(?,?,?,?,?,?,?,?)";
		//�޸���ٴ�����ʣ����ٴ���
		String sql2 = "update leavenum set lnNum=lnNum-1 where username=?";
		try {
			conn = JDBCUtil.getConnection();
			//ȡ�������Զ��ύ
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
			//�ֶ��ύ
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
	
	//���������Ϣ��ѯ
	public List<LeaveEntity> LeaveQuery(String username){
		//׼��sql���
		String sql = "select * from leaveinf where username=?";
		//׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(username);
		//�������ݿ⹫��������
		return JDBCUtil.QueryListExcute(sql, paras, LeaveEntity.class);
	}
	
	//�����Ϣɾ��
	public boolean LeaveDelete(String lId){
		boolean flag=false;
		//׼��sql���
		String sql = "delete from leaveinf where lId=?"; 
		//׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(lId);
		//�������ݿ⹫��������
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}
	
	//������ٴ�����ѯ
	public LeaveNum QueryNum(String username){
		//׼��sql���
		String sql = "select * from leavenum where username=?";
		//׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(username);
		//�������ݿ⹫��������
		return JDBCUtil.findBySingleObject(sql, paras, LeaveNum.class);
	}
	
	//��������
	public boolean LeaveCancel(LeaveEntity l){
		boolean flag=false;
		//׼��sql���
		String sql = "update leaveinf set lCanceltype=? where lId=?"; 
		//׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(l.getlCanceltype());
		paras.add(l.getlId());
		//�������ݿ⹫��������
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}
	
	//����id��ѯ
	public LeaveEntity LeaveEntityQueryById(int lId){
		//׼��sql���
		String sql = "select * from leaveinf where lId=?";
		//׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(lId);
		//�������ݿ⹫��������
		return JDBCUtil.findBySingleObject(sql, paras, LeaveEntity.class);
	}
	
	//�޸�(ֻ���޸�δ��˵�)
	public boolean LeaveUpdate(LeaveEntity l){
		boolean flag=false;
		//׼��SQL���
		String sql="update leaveinf set lReason=?,lStarttime=?,lDays=? where lId=?";
		//׼��������ֵ
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(l.getlReason());
		list.add(l.getlStarttime());
		list.add(l.getlDays());
		list.add(l.getlId());
		//�������ݿ����
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	
	//ÿ���޸�������Ĭ����ٴ���
	public boolean NumUpdate(LeaveNum ln){
		boolean flag=false;
		//׼��SQL���
		String sql="update leavenum set lnNum=?";
		//׼��������ֵ
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(ln.getLnNum());
		//�������ݿ����
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//�������
	public boolean LeaveExam(LeaveEntity l) {
		boolean flag=false;
		//׼��SQL���
		String sql="update leaveinf set lLeavetype=?,lAudittype=? where lId=? and lAudittype=?";
		//׼��������ֵ
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(l.getlLeavetype());
		list.add(l.getlAudittype());
		list.add(l.getlId());
		list.add("�����");
		//�������ݿ����
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//�����ѯ���������Ϣ
	public List<LeaveEntity> LeaveQueryAll(){
		List<LeaveEntity> list=new ArrayList<LeaveEntity>();
		//׼��SQL���
		String sql="select * from leaveinf";
		//�������ݿ����
		list=JDBCUtil.QueryListExcute(sql, null, LeaveEntity.class);
		return list;
	}
	
	//��ѯ����������Ϣ
	public List<LeaveEntity> QueryByCanceltype(String lCanceltype){
		List<LeaveEntity> list=new ArrayList<LeaveEntity>();
		//׼��SQL���
		String sql="select * from leaveinf where lCanceltype=?";
		//׼��������ֵ
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(lCanceltype);
		//�������ݿ����
		list=JDBCUtil.QueryListExcute(sql, paras, LeaveEntity.class);
		return list;
	}
	
	//������׼
	public boolean LeaveCancelUpdate(LeaveEntity l){
		boolean flag=false;
		//׼��SQL���
		String sql="update leaveinf set lCanceltype=? where lId=?";
		//׼��������ֵ
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(l.getlCanceltype());
		list.add(l.getlId());
		//�������ݿ����
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}

}
