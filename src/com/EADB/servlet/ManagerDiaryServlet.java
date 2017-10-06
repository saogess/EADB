package com.EADB.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EADB.model.Manager;
import com.EADB.model.ManagerDiary;
import com.EADB.service.ManagerDiaryService;
import com.EADB.service.imp.ManagerDiaryServiceImp;

/**
 *创建时间：2017年9月22日上午9:08:21
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:ManagerDiaryServlet.java
 *类说明：经理日志功能
 */
@WebServlet("/managerDiaryServlet")
public class ManagerDiaryServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9124639939180693657L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String type=request.getParameter("type");
		//添加日志
		if("add".equals(type)){
			addManagerDiary(request,response);
		}
		//查询日志信息（查询标题）
		if("showAll".equals(type)){
			findAllManagerDiary(request,response);
		}
		//查询日志信息（详细内容）
		if("showOne".equals(type)){
			findOneManagerDiary(request,response);
		}
		//修改日志信息
		if("update".equals(type)){
			updateManagerDiary(request,response);
		}
	}

	//修改日志信息
	private void updateManagerDiary(HttpServletRequest request,HttpServletResponse response) {
		//创建服务层
		ManagerDiaryService mds=new ManagerDiaryServiceImp();
		//获取数据
		int dId=Integer.parseInt(request.getParameter("mid"));
		String title=request.getParameter("title");
		String content=request.getParameter("managerDiary");
		if(content==null||content==" "||content==""){
			ManagerDiary md1=mds.showOneManagerDiary(dId);
			content=md1.getdContent();
		}
		//获取时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);
		//封装数据
		ManagerDiary md=new ManagerDiary();
		md.setdId(dId);
		md.setdTitle(title);
		md.setdContent(content);
		md.setdModifytime(time);
		System.out.println(md);
		//调用服务层
		boolean flag=mds.updateManagerDairy(md);
		String url="";
		if(flag){
			url="Manager/success.jsp";
		}else{
			url="Manager/error.jsp";
		}
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	//查询日志信息（详细内容）
	private void findOneManagerDiary(HttpServletRequest request,HttpServletResponse response) {
		//获取数据
		int dId=Integer.parseInt(request.getParameter("mid"));
		//调用服务层
		ManagerDiaryService mds=new ManagerDiaryServiceImp();
		ManagerDiary md=mds.showOneManagerDiary(dId);
		request.setAttribute("details", md);
		try {
			request.getRequestDispatcher("Manager/showOneManagerDiary.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	//查询日志信息（查询标题）
	private void findAllManagerDiary(HttpServletRequest request,HttpServletResponse response) {
		//获取数据
		HttpSession session=request.getSession();
		Manager m=(Manager)session.getAttribute("mInf");
		//调用服务层
		ManagerDiaryService mds=new ManagerDiaryServiceImp();
		List<ManagerDiary> list=mds.showAllManagerDiary(m.getMid());
		request.setAttribute("managerDiarise", list);
		try {
			request.getRequestDispatcher("Manager/showAllManagerDiary.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	//添加日志
	private void addManagerDiary(HttpServletRequest request,HttpServletResponse response) {
		//获取数据
		String title=request.getParameter("title");
		String content=request.getParameter("managerDiary");
		HttpSession session=request.getSession();
		Manager m=(Manager)session.getAttribute("mInf");
		//获取时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);
		//封装数据
		ManagerDiary md=new ManagerDiary();
		md.setManagerId(m.getId());
		md.setdTitle(title);
		md.setdContent(content);
		md.setdStarttime(time);
		md.setdModifytime(time);
		//调用服务层
		ManagerDiaryService mds=new ManagerDiaryServiceImp();
		boolean flag=mds.insertManagerDiary(md);
		String url="";
		if(flag){
			url="Manager/success.jsp";
		}else{
			url="Manager/error.jsp";
		}
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
