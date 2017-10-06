/**
*创建时间：2017-9-22下午9:18:44
*项目名称：
2017_EADB_Project_Web
*@author 李佩恒
*@version 1.0
*@since JDK 1.7.0_21
*文件名称:AdminServlet.java
*类说明：
*/


package com.EADB.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EADB.model.ManagerEntity;
import com.EADB.service.AdminService;
import com.EADB.service.imp.AdminServiceImpl;

/**
 * @author lenovo
 *
 */
@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6663669738745218420L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String type=request.getParameter("type");
		//添加管理员
		if("add".equals(type)){
			addAdmin(request,response);
		}
		//查询管理员
		if("show".equals(type)){
			showByIdAdmin(request,response);
		}
		//修改管理员
		if("update".equals(type)){
			updateAdmin(request,response);
		}
		//删除管理员
		if("delete".equals(type)){
			deleteAdmin(request,response);
		}
		//登陆验证
		if("login".equals(type)){
			Login(request,response);
		}
		//查询全部
		if("all".equals(type)){
			showAllAdmin(request,response);
		}
		//退出
		if("out".equals(type)){
			LoginOut(request,response);
		}

	}

	
	/*
	 * 退出
	 */
	private void LoginOut(HttpServletRequest request,
			HttpServletResponse response) {
		//获取session
		HttpSession session =request.getSession(false);
		if(session!=null)
		{
			session.invalidate();
		}
		
		try {
			response.sendRedirect(request.getContextPath()+"/Admin/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//删除管理员
	private void deleteAdmin(HttpServletRequest request,HttpServletResponse response) {
		//获取数据
		String login=request.getParameter("loginName");
		//封装数据
		ManagerEntity n=new ManagerEntity();
		n.setLoginName(login);
		//调用服务层
		AdminService ns=new AdminServiceImpl();
		boolean flag=ns.managerDelete(n);
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

	//修改管理员
	private void updateAdmin(HttpServletRequest request,HttpServletResponse response) {
		//获取数据
		String login=request.getParameter("loginName");
		String psw=request.getParameter("password");
		String username=request.getParameter("username");
		String photourl=request.getParameter("photourl");
		String email=request.getParameter("email");
	
		//封装数据
		ManagerEntity n=new ManagerEntity();
		n.setLoginName(login);
		n.setPassword(psw);
		n.setUserName(username);
		n.setPhoto(photourl);
		n.setEmail(email);
		
		//调用服务层
		AdminService ns=new AdminServiceImpl();
		boolean flag=ns.managerUpdate(n);
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

	//查询管理员
	private void showByIdAdmin(HttpServletRequest request,HttpServletResponse response) {
		//获取数据
		String loginName=request.getParameter("loginName");
		
		//调用服务层
		AdminService ns=new AdminServiceImpl();
		ManagerEntity a=ns.findByloginName(loginName);
		if(a==null){
			try {
				request.getRequestDispatcher("Admin/querylose.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("Admin", a);
			try {
				request.getRequestDispatcher("Admin/admin_news.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	//查看全部管理员的信息
		private void showAllAdmin(HttpServletRequest request,HttpServletResponse response) {
			//调用服务层方法
			AdminService ns=new AdminServiceImpl();
			List<ManagerEntity> list=ns.queryUserInfo();
			request.setAttribute("Admin", list);
			try {
				request.getRequestDispatcher("Admin/showAllAdmin.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

	//添加管理员
	private void addAdmin(HttpServletRequest request,HttpServletResponse response) {
		//获取数据
//		int id=Integer.parseInt(request.getParameter("loginname"));
		String login=request.getParameter("loginName");
		String psw=request.getParameter("password");
		String username=request.getParameter("username");
		String photourl=request.getParameter("photourl");
		String email=request.getParameter("email");
		/*HttpSession session=request.getSession();
		Admin a=(Admin)session.getAttribute("");
		int aid=1;//a.getId()
*/		//封装数据
		ManagerEntity n=new ManagerEntity();
		n.setLoginName(login);
		n.setPassword(psw);
		n.setUserName(username);
		n.setPhoto(photourl);
		n.setEmail(email);
		//调用服务层
		AdminService ns=new AdminServiceImpl();
		boolean flag=ns.regist(n);
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
	
	//登录判断
		private void Login(HttpServletRequest request,HttpServletResponse response) {
			//获取页面的参数
			String loginName=request.getParameter("loginName");
			String password=request.getParameter("password");
			response.setContentType("text/html;charset=utf-8");
			//封装数据
			ManagerEntity m=new ManagerEntity();
			m.setLoginName(loginName);
			m.setPassword(password);
			// 调用服务层
			AdminService userService = new AdminServiceImpl();

			String url = "";
			ManagerEntity uEntity = new ManagerEntity();
			try {
				uEntity = userService.findUserByLoginNameAndPassword(m);
				// 判断
				if (uEntity == null) {
					// 转到登录
					url = "/Admin/login.jsp";
				} else {
					// 先保存个人信息到session会话中
					HttpSession session = request.getSession();
					session.setAttribute("admin", uEntity);

					// 在线的用户数据应该添加
					ServletContext servletContext = this.getServletContext();
					// 获取在线用户集合
					@SuppressWarnings("unchecked")
					List<ManagerEntity> onlineList = (List<ManagerEntity>) servletContext
							.getAttribute("onlineList");
					//把在线用户信息添加到域对象中
					servletContext.setAttribute("onlineList",onlineList);

					if (onlineList != null) {
						onlineList.add(uEntity);
					}

					// 转向登录用户列表
					url = "/Admin/index.jsp";

				}
			} catch (Exception ex) {
				url = "/error.jsp";
			}

			try {
				request.getRequestDispatcher(url).forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}