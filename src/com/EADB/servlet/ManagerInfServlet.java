package com.EADB.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EADB.model.Manager;
import com.EADB.service.imp.ManagerInfServiceImp;

/**
 *����ʱ�䣺2017��9��19������4:36:00
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:ManagerInfServlet.java
 *��˵����������ز�����Servlet��
 */

@WebServlet("/managerLoginServlet")
public class ManagerInfServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9206393170482875147L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String type=request.getParameter("type");
		//��¼�ж�
		if("login".equals(type)){
			ManagerLogin(request,response);
		}
		//�����˳�����
		if("out".equals(type)){
			ManagerOut(request,response);
		}
		//mid��֤����
		if("loginMId".equals(type)){
			LoginMID(request,response);
		}
		//mid��������ƥ����֤
		if("loginMIdAndMpassword".equals(type)){
			LoginMIdAndMpassword(request,response);
		}
		//�鿴ȫ���������Ϣ
		if("showAll".equals(type)){
			showAllManagerInf(request,response);
		}
		//�޸ľ���ĸ�����Ϣ
		if("update".equals(type)){
			updateManagerInf(request,response);
		}
		//���Ӿ���ĸ�����Ϣ
		if("add".equals(type)){
			addManagerInf(request,response);
		}
	}

	//���Ӿ���ĸ�����Ϣ
	private void addManagerInf(HttpServletRequest request,HttpServletResponse response) {
		//��ȡҳ��Ĳ���
		String mid=request.getParameter("userId");
		String name=request.getParameter("userName");
		String position=request.getParameter("userPosition");
		String password=request.getParameter("password_2");
		String gender=request.getParameter("gender");
		String picture="";
		if("��".equals(gender)){
			picture="img/boy.png";
		}else{
			picture="img/girl.png";
		}
		String mail=request.getParameter("userMail");
		String phone=request.getParameter("Phone");
		String birthday=request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("date");
		String index=request.getParameter("Province");
		String province="";
		if("1".equals(index)){
			province="����";
		}else if("2".equals(index)){
			province="�Ϻ�";
		}else if("3".equals(index)){
			province="����";
		}else if("4".equals(index)){
			province="ɽ��";
		}else{
			province="�Ĵ�";
		}
		String address=province+request.getParameter("City");
		//��װ����
		Manager m=new Manager();
		m.setMid(mid);
		m.setManagername(name);
		m.setmPassword(password);
		m.setGender(gender);
		m.setPosition(position);
		m.setPictureurl(picture);
		m.setAddress(address);
		m.setBirthday(birthday);
		m.setMail(mail);
		m.setPhonenumber(phone);
		System.out.println(m);
		//���÷���㷽��
		ManagerInfServiceImp mis=new ManagerInfServiceImp();
		boolean flag=mis.addManagerInfService(m);
		if(flag){
			try {
				request.getRequestDispatcher("Manager/success.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.getRequestDispatcher("Manager/error.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	//�޸ľ���ĸ�����Ϣ
	private void updateManagerInf(HttpServletRequest request,HttpServletResponse response) {
		//��ȡҳ��Ĳ���
		String password="";
		String message=request.getParameter("password_2");
		if("".equals(message)){
			password=request.getParameter("pwd");
		}else{
			password=message;
		}
		String phonenumber=request.getParameter("Phone");
		String index=request.getParameter("Province");
		String address="";
		if("0".equals(index)){
			address=request.getParameter("address");
		}else{
			String province="";
			if("1".equals(index)){
				province="����";
			}else if("2".equals(index)){
				province="�Ϻ�";
			}else if("3".equals(index)){
				province="����";
			}else if("4".equals(index)){
				province="ɽ��";
			}else{
				province="�Ĵ�";
			}
			address=province+request.getParameter("City");
		}
		String mail=request.getParameter("userMail");
		//��װ����
		Manager m=new Manager();
		m.setmPassword(password);
		m.setPhonenumber(phonenumber);
		m.setAddress(address);
		m.setMail(mail);
		HttpSession session=request.getSession();
		Manager m1=(Manager)session.getAttribute("mInf");
		m.setMid(m1.getMid());
		//���÷���㷽��
		ManagerInfServiceImp mis=new ManagerInfServiceImp();
		boolean flag=mis.updateManagerInfService(m);
		m1=mis.findByMidManagerInfService(m1.getMid());
		if(flag){
			try {
				session.setAttribute("mInf", m1);
				request.getRequestDispatcher("Manager/showManagerInf.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.getRequestDispatcher("Manager/error.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	//�鿴ȫ���������Ϣ
	private void showAllManagerInf(HttpServletRequest request,HttpServletResponse response) {
		//���÷���㷽��
		ManagerInfServiceImp mis=new ManagerInfServiceImp();
		List<Manager> list=mis.findAllManagerInfService();
		request.setAttribute("managersInf", list);
		try {
			request.getRequestDispatcher("Manager/showAllManagerInf.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	//mid��������ƥ����֤
	private void LoginMIdAndMpassword(HttpServletRequest request,HttpServletResponse response) {
		//��ȡҳ��Ĳ���
		String mid=request.getParameter("mId");
		String password=request.getParameter("mPassword");
		response.setContentType("text/html;charset=utf-8");
		//��װ����
		Manager m=new Manager();
		m.setMid(mid);
		m.setmPassword(password);
		//���÷���㷽��
		ManagerInfServiceImp mis=new ManagerInfServiceImp();
		Manager ui=mis.managerLoginService(m, 1);
		PrintWriter out=null;
		try {
			out=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String i="0";
		if(ui==null)
		{
			i="1";
		}
		out.write(i);
		out.flush();
		out.close();
	}

	//mid��֤����
	private void LoginMID(HttpServletRequest request,HttpServletResponse response) {
		//��ȡҳ��Ĳ���
		String mid=request.getParameter("managerId");
		response.setContentType("text/html;charset=utf-8");
		//��װ����
		Manager m=new Manager();
		m.setMid(mid);
		//���÷���㷽��
		ManagerInfServiceImp mis=new ManagerInfServiceImp();
		Manager ui=mis.managerLoginService(m, 0);
		PrintWriter out=null;
		try {
			out=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String i="0";
		if(ui==null)
		{
			i="1";
		}
		out.write(i);
		out.flush();
		out.close();
	}

	//�����˳�����
	private void ManagerOut(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		if(session!=null){
			session.invalidate();
		}
		try {
			response.sendRedirect(request.getContextPath()+"/Admin/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//��¼�ж�
	private void ManagerLogin(HttpServletRequest request,HttpServletResponse response) {
		//��ȡҳ��Ĳ���
		String mid=request.getParameter("managerId");
		String mPassword=request.getParameter("mPassword");
		response.setContentType("text/html;charset=utf-8");
		//��װ����
		Manager m=new Manager();
		m.setMid(mid);
		m.setmPassword(mPassword);
		//���÷���㷽��
		ManagerInfServiceImp mis=new ManagerInfServiceImp();
		Manager mi=mis.managerLoginService(m, 1);
		HttpSession session=request.getSession();
		String url="";
		if(mi==null){
			url="Manager/login.jsp";
		}else{
			//boolean test=true;
			//���������Ϣ������session��
			session.setAttribute("mInf", mi);
			//���ߵ��û�����Ӧ�����
			ServletContext servletContext = this.getServletContext();
			//��ȡ�����û�����
			@SuppressWarnings("unchecked")
			List<Manager> managerOnlineList = (List<Manager>) servletContext.getAttribute("managerOnlineList");
			if(managerOnlineList!=null){
//				if(managerOnlineList.contains(mi)){
//					test=false;
//				}
//				
//				if(test){
					managerOnlineList.add(mi);
				//}
			}
			url="Manager/HomePage.jsp";
		}
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
