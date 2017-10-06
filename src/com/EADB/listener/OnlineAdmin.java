/**
*创建时间：2017-9-25下午5:52:31
*项目名称：
2017_EADB_Project_Web
*@author 李佩恒
*@version 1.0
*@since JDK 1.7.0_21
*文件名称:OnlineAdmin.java
*类说明：
*/


package com.EADB.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.EADB.model.ManagerEntity;

/**
 * @author lenovo
 *
 */
public class OnlineAdmin implements ServletContextListener {


	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		//获取ServletContext
		ServletContext servletContext = sce.getServletContext();
		//获取在线用户列表 
		Object obj = servletContext.getAttribute("onlineList");
		if(obj!=null)
		{
			servletContext.removeAttribute("onlineList");
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//创建用户集合对象
		List<ManagerEntity> onlineList= new ArrayList<ManagerEntity>();
		
		//放在servletContext
		sce.getServletContext().setAttribute("onlineList", onlineList);
	}
}
