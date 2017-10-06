package com.EADB.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.EADB.model.Manager;

/**
 *创建时间：2017年9月25日上午10:14:24
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:UserListener.java
 *类说明：在线经理信息监听器
 */

public class ManagerListener implements ServletContextListener{

	//对象的销毁
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//获取servletContext对象
		ServletContext sc=sce.getServletContext();
		//获取在线经理对象
		Object obj=sc.getAttribute("managerOnlineList");
		//移除
		if(obj!=null){
			sc.removeAttribute("managerOnlineList");
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//创建集合：存放在线经理数
		List<Manager> managerOnlineList=new ArrayList<Manager>();
		//放入servletContext中
		sce.getServletContext().setAttribute("managerOnlineList", managerOnlineList);
	}
	
}
