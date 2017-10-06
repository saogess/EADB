/**
*����ʱ�䣺2017-9-25����6:25:17
*��Ŀ���ƣ�
2017_EADB_Project_Web
*@author �����
*@version 1.0
*@since JDK 1.7.0_21
*�ļ�����:SessionListner.java
*��˵����
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
		// ��ȡsession
		HttpSession session = se.getSession();
		// ��ȡ�����Ķ���
		ServletContext servletContext = session.getServletContext();
		
		//��ȡ�����Ķ����е������û��б� 
		List<ManagerEntity> userList = (List<ManagerEntity>)servletContext.getAttribute("onlineList");
		
		//��session�л�ȡ��ǰ�û�����
		ManagerEntity user = (ManagerEntity)session.getAttribute("admin");
		
		if(userList!=null)
		{
			userList.remove(user);
		}
	}

}


