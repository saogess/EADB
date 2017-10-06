package com.EADB.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EADB.model.Manager;
import com.EADB.model.ManagerEntity;
import com.EADB.model.Notice;
import com.EADB.service.NoticeService;
import com.EADB.service.imp.ManagerInfServiceImp;
import com.EADB.service.imp.NoticeServiceImpl;

/**
 *创建时间：2017年9月22日下午3:40:38
 *项目名称：2017_EADB_Project_Web
 *@author 李佩恒
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:NoticeInfServlet.java
 *类说明：公告信息的Servlet
 */
@WebServlet("/noticeServlet")
public class NoticeInfServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 541790341855535804L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String type=request.getParameter("type");
		//添加公告
		if("add".equals(type)){
			addNotice(request,response);
		}
		//查询公告
		if("show".equals(type)){
			showByIdNotice(request,response);
		}
		//修改公告
		if("update".equals(type)){
			updateNotice(request,response);
		}
		//删除公告
		if("delete".equals(type)){
			deleteNotice(request,response);
		}
		//全部公告
		if("all".equals(type)){
			showAllNotice(request,response);
		}
		//全部公告
		if("noticeAd".equals(type)){
			NoticeAdquery(request,response);
		}
	}
	//多表查询
	private void NoticeAdquery(HttpServletRequest request,
		HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int id=Integer.parseInt(request.getParameter("adminid"));
		
		NoticeService ns=new NoticeServiceImpl();
		List<Notice> list = ns.NoticeQuery(id);
		System.err.println(list);
		//调用服务层
						
		if(list==null){
			try {
				request.getRequestDispatcher("Admin/queryNolose.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("Notice", list);
			try {
				request.getRequestDispatcher("Admin/notice_listnews.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	//删除公告
	private void deleteNotice(HttpServletRequest request,HttpServletResponse response) {
		//获取数据
		int id=Integer.parseInt(request.getParameter("nid"));
		//调用服务层
		NoticeService ns=new NoticeServiceImpl();
		boolean flag=ns.noticeDelete(id);
		String url="";
		if(flag){
			url="Admin/success.jsp";
		}else{
			url="Admin/lose.jsp";
		}
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	//修改公告
	private void updateNotice(HttpServletRequest request,HttpServletResponse response) {
		//获取数据
		int id=Integer.parseInt(request.getParameter("noticeId"));
		String date=request.getParameter("data");
		String inf=request.getParameter("status");
		HttpSession session=request.getSession();
		ManagerEntity a=(ManagerEntity)session.getAttribute("");
		int aid=1;//a.getId()
		//封装数据
		Notice n=new Notice();
		n.setNid(id);
		n.setTime(date);
		n.setNotice(inf);
		n.setAdminid(aid);
		//调用服务层
		NoticeService ns=new NoticeServiceImpl();
		boolean flag=ns.noticeUpdate(n);
		String url="";
		if(flag){
			url="Admin/success.jsp";
		}else{
			url="Admin/lose.jsp";
		}
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	//查看全部公告的信息
		private void showAllNotice(HttpServletRequest request,HttpServletResponse response) {
			//调用服务层方法
			NoticeService ns=new NoticeServiceImpl();
			List<Notice> list=ns.queryNoticeInfo();
			request.setAttribute("Notice", list);
			try {
				request.getRequestDispatcher("Admin/showAllNotice.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

	//查询公告
	private void showByIdNotice(HttpServletRequest request,HttpServletResponse response) {
		//获取数据
		int id=Integer.parseInt(request.getParameter("id"));
		//调用服务层
		NoticeService ns=new NoticeServiceImpl();
		Notice n=ns.findByNotice(id);
		if(n==null){
			try {
				request.getRequestDispatcher("Admin/queryNolose.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("Notice", n);
			try {
				request.getRequestDispatcher("Admin/notice_news.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	//添加公告
	private void addNotice(HttpServletRequest request,HttpServletResponse response) {
		//获取数据
		int id=Integer.parseInt(request.getParameter("noticeId"));
		String date=request.getParameter("data");
		String inf=request.getParameter("status");
		HttpSession session=request.getSession();
		ManagerEntity a=(ManagerEntity)session.getAttribute("");
		int aid=1;//a.getId()
		//封装数据
		Notice n=new Notice();
		n.setNid(id);
		n.setTime(date);
		n.setNotice(inf);
		n.setAdminid(aid);
		//调用服务层
		NoticeService ns=new NoticeServiceImpl();
		boolean flag=ns.noticeRegist(n);
		String url="";
		if(flag){
			url="Admin/success.jsp";
		}else{
			url="Admin/lose.jsp";
		}
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
