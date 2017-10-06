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
 *创建时间：2017年9月25日上午11:23:54
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:LeaveNumListener.java
 *类说明：
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
		//实现每个月请假次数变为5次
		Date d = new Date();//获取服务器的时间。。。
		Calendar c= Calendar.getInstance(); 
		c.setTime(d); 
		if(c.get(Calendar.DAY_OF_MONTH) == 1) //当前是1号
			{ 
			//拿出党员的入党日期（年月）同当前月进行比较 如果相同 发送短信 // 
			//写下你的判断代码 
			//System.out.println("1号");
			
			int lnNum = 5;
			LeaveNum ln = new LeaveNum();
			ln.setLnNum(lnNum);
			LeaveService leaveService = new LeaveServiceImpl();
			leaveService.NumUpdate(ln);
			
			
			} else //当前不是1号 则从下个月1号开始执行定期任务 
				{ 
				//System.out.println("不是1号");
				c.set(Calendar.MONTH,c.get(Calendar.MONTH)+ 1);//设置为下月 
				c.set(Calendar.DAY_OF_MONTH,1);//设置为下月的1号 
				Timer timer =new Timer(); 
				timer.scheduleAtFixedRate(new TimerTask() { 
					public void run() { 
						//每天都来判断一下 如果当前日期是1号 //
						//run函数里写下你的判断代码 
						int lnNum = 5;
						LeaveNum ln = new LeaveNum();
						ln.setLnNum(lnNum);
						LeaveService leaveService = new LeaveServiceImpl();
						leaveService.NumUpdate(ln);
						}
					},
					c.getTime(),24* 3600*1000); //每天执行一次run()方法... 
					
			}
	}
	

}
