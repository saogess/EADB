package com.EADB.listener;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.EADB.model.LeaveNum;
import com.EADB.service.LeaveService;
import com.EADB.service.imp.LeaveServiceImpl;
/**
 *����ʱ�䣺2017��9��25������11:23:54
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:LeaveNumListener.java
 *��˵����
 */

public class LeaveNumListener implements ServletContextListener{

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//ʵ��ÿ������ٴ�����Ϊ5��
		Date d = new Date();//��ȡ��������ʱ�䡣����
		Calendar c= Calendar.getInstance(); 
		c.setTime(d); 
		if(c.get(Calendar.DAY_OF_MONTH) == 1) //��ǰ��1��
			{ 
			//�ó���Ա���뵳���ڣ����£�ͬ��ǰ�½��бȽ� �����ͬ ���Ͷ��� // 
			//д������жϴ��� 
			//System.out.println("1��");
			
			int lnNum = 5;
			LeaveNum ln = new LeaveNum();
			ln.setLnNum(lnNum);
			LeaveService leaveService = new LeaveServiceImpl();
			leaveService.NumUpdate(ln);
			
			
			} else //��ǰ����1�� ����¸���1�ſ�ʼִ�ж������� 
				{ 
				//System.out.println("����1��");
				c.set(Calendar.MONTH,c.get(Calendar.MONTH)+ 1);//����Ϊ���� 
				c.set(Calendar.DAY_OF_MONTH,1);//����Ϊ���µ�1�� 
				Timer timer =new Timer(); 
				timer.scheduleAtFixedRate(new TimerTask() { 
					public void run() { 
						//ÿ�춼���ж�һ�� �����ǰ������1�� //
						//run������д������жϴ��� 
						int lnNum = 5;
						LeaveNum ln = new LeaveNum();
						ln.setLnNum(lnNum);
						LeaveService leaveService = new LeaveServiceImpl();
						leaveService.NumUpdate(ln);
						}
					},
					c.getTime(),24* 3600*1000); //ÿ��ִ��һ��run()����... 
					
			}
	}
	

}
