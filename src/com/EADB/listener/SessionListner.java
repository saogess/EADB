/**
*创建时间：2017-9-25下午6:25:17
*项目名称：
2017_EADB_Project_Web
*@author 李佩恒
*@version 1.0
*@since JDK 1.7.0_21
*文件名称:SessionListner.java
*类说明：
*/


package com.EADB.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.EADB.model.ManagerEntity;

public class SessionListner implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// 获取session
		HttpSession session = se.getSession();
		// 获取上下文对象
		ServletContext servletContext = session.getServletContext();
		
		//获取上下文对象中的在线用户列表 
		List<ManagerEntity> userList = (List<ManagerEntity>)servletContext.getAttribute("onlineList");
		
		//从session中获取当前用户对象
		ManagerEntity user = (ManagerEntity)session.getAttribute("admin");
		
		if(userList!=null)
		{
			userList.remove(user);
		}
	}

}


