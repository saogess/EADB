package com.EADB.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.EADB.model.Manager;

/**
 *创建时间：2017年9月25日上午10:33:47
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:ManagerSessionListener.java
 *类说明：经理的session监听器
 */

public class ManagerSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent s) {
		//获取session对象
		HttpSession session=s.getSession();
		//获取当前用户
		Manager m=(Manager)session.getAttribute("mInf");
		//在ServletContext对象中删除对应用户
		ServletContext sc=session.getServletContext();
		@SuppressWarnings("unchecked")
		List<Manager> list=(List<Manager>)sc.getAttribute("managerOnlineList");
		if(m!=null){
			list.remove(m);   //把当前登录用户从在线用户集合中移除
		}
	}
	
}
