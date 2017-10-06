package com.EADB.service.imp;

import java.util.List;

import com.EADB.dao.LeaveDao;
import com.EADB.dao.imp.LeaveDaoImpl;
import com.EADB.model.LeaveEntity;
import com.EADB.model.LeaveNum;
import com.EADB.service.LeaveService;

/**
 *创建时间：2017年9月20日下午3:43:05
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:LeaveServiceImpl.java
 *类说明：
 */

public class LeaveServiceImpl implements LeaveService{
	//请假
	public boolean LeaveInsert(LeaveEntity l){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveInsert(l);
	}
	
	//个人请假信息查询
	public List<LeaveEntity> LeaveQuery(String username){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveQuery(username);
	}
	
	//请假信息删除
	public boolean LeaveDelete(String lId){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveDelete(lId);
	}
	
	//个人请假次数查询
	public LeaveNum QueryNum(String username){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.QueryNum(username);
	}
	
	//请求销假
	public boolean LeaveCancel(LeaveEntity l){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveCancel(l);
	}
	
	//根据id查询
	public LeaveEntity LeaveEntityQueryById(int lId){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveEntityQueryById(lId);
	}
	
	//修改
	public boolean LeaveUpdate(LeaveEntity l){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveUpdate(l);
	}
	
	//每月修改默认请假次数
	public boolean NumUpdate(LeaveNum ln){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.NumUpdate(ln);
	}
	
	//经理审核
	public boolean LeaveExam(LeaveEntity l){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveExam(l);
	}
	
	//经理查询所有请假信息
	public List<LeaveEntity> LeaveQueryAll(){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveQueryAll();
	}
	
	//查询所有销假信息
	public List<LeaveEntity> QueryByCanceltype(String lCanceltype){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.QueryByCanceltype(lCanceltype);
	}
	
	//销假批准
	public boolean LeaveCancelUpdate(LeaveEntity l){
		LeaveDao leavedao = new LeaveDaoImpl();
		return leavedao.LeaveCancelUpdate(l);
	}

}
