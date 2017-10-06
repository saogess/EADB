package com.EADB.service;

import java.util.List;

import com.EADB.model.LeaveEntity;
import com.EADB.model.LeaveNum;

/**
 *创建时间：2017年9月20日下午3:42:32
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:LeaveService.java
 *类说明：
 */

public interface LeaveService {
	//请假
	boolean LeaveInsert(LeaveEntity l);
	
	//个人请假信息查询
	List<LeaveEntity> LeaveQuery(String username);
	
	//请假信息删除
	boolean LeaveDelete(String lId);
	
	//个人请假次数查询
	LeaveNum QueryNum(String username);
	
	//请求销假
	boolean LeaveCancel(LeaveEntity l);
	
	//根据id查询
	LeaveEntity LeaveEntityQueryById(int lId);
	
	//修改
	boolean LeaveUpdate(LeaveEntity l);
	
	//每月修改默认请假次数
	boolean NumUpdate(LeaveNum ln);
	
	//经理审核
	boolean LeaveExam(LeaveEntity l);
	
	//经理查询所有请假信息
	List<LeaveEntity> LeaveQueryAll();
	
	//查询所有销假信息
	List<LeaveEntity> QueryByCanceltype(String lCanceltype);
	
	//销假批准
	boolean LeaveCancelUpdate(LeaveEntity l);

}
