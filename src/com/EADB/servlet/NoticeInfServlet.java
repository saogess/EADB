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
 *����ʱ�䣺2017��9��22������3:40:38
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author �����
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:NoticeInfServlet.java
 *��˵����������Ϣ��Servlet
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
		//��ӹ���
		if("add".equals(type)){
			addNotice(request,response);
		}
		//��ѯ����
		if("show".equals(type)){
			showByIdNotice(request,response);
		}
		//�޸Ĺ���
		if("update".equals(type)){
			updateNotice(request,response);
		}
		//ɾ������
		if("delete".equals(type)){
			deleteNotice(request,response);
		}
		//ȫ������
		if("all".equals(type)){
			showAllNotice(request,response);
		}
		//ȫ������
		if("noticeAd".equals(type)){
			NoticeAdquery(request,response);
		}
	}
	//����ѯ
	private void NoticeAdquery(HttpServletRequest request,
		HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int id=Integer.parseInt(request.getParameter("adminid"));
		
		NoticeService ns=new NoticeServiceImpl();
		List<Notice> list = ns.NoticeQuery(id);
		System.err.println(list);
		//���÷����
						
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
	

	//ɾ������
	private void deleteNotice(HttpServletRequest request,HttpServletResponse response) {
		//��ȡ����
		int id=Integer.parseInt(request.getParameter("nid"));
		//���÷����
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

	//�޸Ĺ���
	private void updateNotice(HttpServletRequest request,HttpServletResponse response) {
		//��ȡ����
		int id=Integer.parseInt(request.getParameter("noticeId"));
		String date=request.getParameter("data");
		String inf=request.getParameter("status");
		HttpSession session=request.getSession();
		ManagerEntity a=(ManagerEntity)session.getAttribute("");
		int aid=1;//a.getId()
		//��װ����
		Notice n=new Notice();
		n.setNid(id);
		n.setTime(date);
		n.setNotice(inf);
		n.setAdminid(aid);
		//���÷����
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
	//�鿴ȫ���������Ϣ
		private void showAllNotice(HttpServletRequest request,HttpServletResponse response) {
			//���÷���㷽��
			NoticeService ns=new NoticeServiceImpl();
			List<Notice> list=ns.queryNoticeInfo();
			request.setAttribute("Notice", list);
			try {
				request.getRequestDispatcher("Admin/showAllNotice.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

	//��ѯ����
	private void showByIdNotice(HttpServletRequest request,HttpServletResponse response) {
		//��ȡ����
		int id=Integer.parseInt(request.getParameter("id"));
		//���÷����
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

	//��ӹ���
	private void addNotice(HttpServletRequest request,HttpServletResponse response) {
		//��ȡ����
		int id=Integer.parseInt(request.getParameter("noticeId"));
		String date=request.getParameter("data");
		String inf=request.getParameter("status");
		HttpSession session=request.getSession();
		ManagerEntity a=(ManagerEntity)session.getAttribute("");
		int aid=1;//a.getId()
		//��װ����
		Notice n=new Notice();
		n.setNid(id);
		n.setTime(date);
		n.setNotice(inf);
		n.setAdminid(aid);
		//���÷����
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
