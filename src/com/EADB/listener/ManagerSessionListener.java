package com.EADB.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.EADB.model.Manager;

/**
 *����ʱ�䣺2017��9��25������10:33:47
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:ManagerSessionListener.java
 *��˵���������session������
 */

public class ManagerSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent s) {
		//��ȡsession����
		HttpSession session=s.getSession();
		//��ȡ��ǰ�û�
		Manager m=(Manager)session.getAttribute("mInf");
		//��ServletContext������ɾ����Ӧ�û�
		ServletContext sc=session.getServletContext();
		@SuppressWarnings("unchecked")
		List<Manager> list=(List<Manager>)sc.getAttribute("managerOnlineList");
		if(m!=null){
			list.remove(m);   //�ѵ�ǰ��¼�û��������û��������Ƴ�
		}
	}
	
}
