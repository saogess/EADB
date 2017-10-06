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
 *创建时间：2017年9月19日下午4:36:00
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:ManagerInfServlet.java
 *类说明：经理相关操作的Servlet。
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
		//登录判断
		if("login".equals(type)){
			ManagerLogin(request,response);
		}
		//经理退出操作
		if("out".equals(type)){
			ManagerOut(request,response);
		}
		//mid验证操作
		if("loginMId".equals(type)){
			LoginMID(request,response);
		}
		//mid与密码相匹配验证
		if("loginMIdAndMpassword".equals(type)){
			LoginMIdAndMpassword(request,response);
		}
		//查看全部经理的信息
		if("showAll".equals(type)){
			showAllManagerInf(request,response);
		}
		//修改经理的个人信息
		if("update".equals(type)){
			updateManagerInf(request,response);
		}
		//增加经理的个人信息
		if("add".equals(type)){
			addManagerInf(request,response);
		}
	}

	//增加经理的个人信息
	private void addManagerInf(HttpServletRequest request,HttpServletResponse response) {
		//获取页面的参数
		String mid=request.getParameter("userId");
		String name=request.getParameter("userName");
		String position=request.getParameter("userPosition");
		String password=request.getParameter("password_2");
		String gender=request.getParameter("gender");
		String picture="";
		if("男".equals(gender)){
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
			province="北京";
		}else if("2".equals(index)){
			province="上海";
		}else if("3".equals(index)){
			province="广州";
		}else if("4".equals(index)){
			province="山西";
		}else{
			province="四川";
		}
		String address=province+request.getParameter("City");
		//封装数据
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
		//调用服务层方法
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

	//修改经理的个人信息
	private void updateManagerInf(HttpServletRequest request,HttpServletResponse response) {
		//获取页面的参数
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
				province="北京";
			}else if("2".equals(index)){
				province="上海";
			}else if("3".equals(index)){
				province="广州";
			}else if("4".equals(index)){
				province="山西";
			}else{
				province="四川";
			}
			address=province+request.getParameter("City");
		}
		String mail=request.getParameter("userMail");
		//封装数据
		Manager m=new Manager();
		m.setmPassword(password);
		m.setPhonenumber(phonenumber);
		m.setAddress(address);
		m.setMail(mail);
		HttpSession session=request.getSession();
		Manager m1=(Manager)session.getAttribute("mInf");
		m.setMid(m1.getMid());
		//调用服务层方法
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

	//查看全部经理的信息
	private void showAllManagerInf(HttpServletRequest request,HttpServletResponse response) {
		//调用服务层方法
		ManagerInfServiceImp mis=new ManagerInfServiceImp();
		List<Manager> list=mis.findAllManagerInfService();
		request.setAttribute("managersInf", list);
		try {
			request.getRequestDispatcher("Manager/showAllManagerInf.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	//mid与密码相匹配验证
	private void LoginMIdAndMpassword(HttpServletRequest request,HttpServletResponse response) {
		//获取页面的参数
		String mid=request.getParameter("mId");
		String password=request.getParameter("mPassword");
		response.setContentType("text/html;charset=utf-8");
		//封装数据
		Manager m=new Manager();
		m.setMid(mid);
		m.setmPassword(password);
		//调用服务层方法
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

	//mid验证操作
	private void LoginMID(HttpServletRequest request,HttpServletResponse response) {
		//获取页面的参数
		String mid=request.getParameter("managerId");
		response.setContentType("text/html;charset=utf-8");
		//封装数据
		Manager m=new Manager();
		m.setMid(mid);
		//调用服务层方法
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

	//经理退出操作
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

	//登录判断
	private void ManagerLogin(HttpServletRequest request,HttpServletResponse response) {
		//获取页面的参数
		String mid=request.getParameter("managerId");
		String mPassword=request.getParameter("mPassword");
		response.setContentType("text/html;charset=utf-8");
		//封装数据
		Manager m=new Manager();
		m.setMid(mid);
		m.setmPassword(mPassword);
		//调用服务层方法
		ManagerInfServiceImp mis=new ManagerInfServiceImp();
		Manager mi=mis.managerLoginService(m, 1);
		HttpSession session=request.getSession();
		String url="";
		if(mi==null){
			url="Manager/login.jsp";
		}else{
			//boolean test=true;
			//保存个人信息并放入session域
			session.setAttribute("mInf", mi);
			//在线的用户数据应该添加
			ServletContext servletContext = this.getServletContext();
			//获取在线用户集合
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
