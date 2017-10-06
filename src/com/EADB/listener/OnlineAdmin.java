/**
*����ʱ�䣺2017-9-25����5:52:31
*��Ŀ���ƣ�
2017_EADB_Project_Web
*@author �����
*@version 1.0
*@since JDK 1.7.0_21
*�ļ�����:OnlineAdmin.java
*��˵����
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
		
		//��ȡServletContext
		ServletContext servletContext = sce.getServletContext();
		//��ȡ�����û��б� 
		Object obj = servletContext.getAttribute("onlineList");
		if(obj!=null)
		{
			servletContext.removeAttribute("onlineList");
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//�����û����϶���
		List<ManagerEntity> onlineList= new ArrayList<ManagerEntity>();
		
		//����servletContext
		sce.getServletContext().setAttribute("onlineList", onlineList);
	}
}
