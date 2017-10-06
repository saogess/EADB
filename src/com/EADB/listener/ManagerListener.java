package com.EADB.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.EADB.model.Manager;

/**
 *����ʱ�䣺2017��9��25������10:14:24
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:UserListener.java
 *��˵�������߾�����Ϣ������
 */

public class ManagerListener implements ServletContextListener{

	//���������
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//��ȡservletContext����
		ServletContext sc=sce.getServletContext();
		//��ȡ���߾������
		Object obj=sc.getAttribute("managerOnlineList");
		//�Ƴ�
		if(obj!=null){
			sc.removeAttribute("managerOnlineList");
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//�������ϣ�������߾�����
		List<Manager> managerOnlineList=new ArrayList<Manager>();
		//����servletContext��
		sce.getServletContext().setAttribute("managerOnlineList", managerOnlineList);
	}
	
}
