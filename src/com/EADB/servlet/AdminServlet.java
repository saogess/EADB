/**
*����ʱ�䣺2017-9-22����9:18:44
*��Ŀ���ƣ�
2017_EADB_Project_Web
*@author �����
*@version 1.0
*@since JDK 1.7.0_21
*�ļ�����:AdminServlet.java
*��˵����
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
		//��ӹ���Ա
		if("add".equals(type)){
			addAdmin(request,response);
		}
		//��ѯ����Ա
		if("show".equals(type)){
			showByIdAdmin(request,response);
		}
		//�޸Ĺ���Ա
		if("update".equals(type)){
			updateAdmin(request,response);
		}
		//ɾ������Ա
		if("delete".equals(type)){
			deleteAdmin(request,response);
		}
		//��½��֤
		if("login".equals(type)){
			Login(request,response);
		}
		//��ѯȫ��
		if("all".equals(type)){
			showAllAdmin(request,response);
		}
		//�˳�
		if("out".equals(type)){
			LoginOut(request,response);
		}

	}

	
	/*
	 * �˳�
	 */
	private void LoginOut(HttpServletRequest request,
			HttpServletResponse response) {
		//��ȡsession
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

	//ɾ������Ա
	private void deleteAdmin(HttpServletRequest request,HttpServletResponse response) {
		//��ȡ����
		String login=request.getParameter("loginName");
		//��װ����
		ManagerEntity n=new ManagerEntity();
		n.setLoginName(login);
		//���÷����
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

	//�޸Ĺ���Ա
	private void updateAdmin(HttpServletRequest request,HttpServletResponse response) {
		//��ȡ����
		String login=request.getParameter("loginName");
		String psw=request.getParameter("password");
		String username=request.getParameter("username");
		String photourl=request.getParameter("photourl");
		String email=request.getParameter("email");
	
		//��װ����
		ManagerEntity n=new ManagerEntity();
		n.setLoginName(login);
		n.setPassword(psw);
		n.setUserName(username);
		n.setPhoto(photourl);
		n.setEmail(email);
		
		//���÷����
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

	//��ѯ����Ա
	private void showByIdAdmin(HttpServletRequest request,HttpServletResponse response) {
		//��ȡ����
		String loginName=request.getParameter("loginName");
		
		//���÷����
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
	//�鿴ȫ������Ա����Ϣ
		private void showAllAdmin(HttpServletRequest request,HttpServletResponse response) {
			//���÷���㷽��
			AdminService ns=new AdminServiceImpl();
			List<ManagerEntity> list=ns.queryUserInfo();
			request.setAttribute("Admin", list);
			try {
				request.getRequestDispatcher("Admin/showAllAdmin.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

	//��ӹ���Ա
	private void addAdmin(HttpServletRequest request,HttpServletResponse response) {
		//��ȡ����
//		int id=Integer.parseInt(request.getParameter("loginname"));
		String login=request.getParameter("loginName");
		String psw=request.getParameter("password");
		String username=request.getParameter("username");
		String photourl=request.getParameter("photourl");
		String email=request.getParameter("email");
		/*HttpSession session=request.getSession();
		Admin a=(Admin)session.getAttribute("");
		int aid=1;//a.getId()
*/		//��װ����
		ManagerEntity n=new ManagerEntity();
		n.setLoginName(login);
		n.setPassword(psw);
		n.setUserName(username);
		n.setPhoto(photourl);
		n.setEmail(email);
		//���÷����
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
	
	//��¼�ж�
		private void Login(HttpServletRequest request,HttpServletResponse response) {
			//��ȡҳ��Ĳ���
			String loginName=request.getParameter("loginName");
			String password=request.getParameter("password");
			response.setContentType("text/html;charset=utf-8");
			//��װ����
			ManagerEntity m=new ManagerEntity();
			m.setLoginName(loginName);
			m.setPassword(password);
			// ���÷����
			AdminService userService = new AdminServiceImpl();

			String url = "";
			ManagerEntity uEntity = new ManagerEntity();
			try {
				uEntity = userService.findUserByLoginNameAndPassword(m);
				// �ж�
				if (uEntity == null) {
					// ת����¼
					url = "/Admin/login.jsp";
				} else {
					// �ȱ��������Ϣ��session�Ự��
					HttpSession session = request.getSession();
					session.setAttribute("admin", uEntity);

					// ���ߵ��û�����Ӧ�����
					ServletContext servletContext = this.getServletContext();
					// ��ȡ�����û�����
					@SuppressWarnings("unchecked")
					List<ManagerEntity> onlineList = (List<ManagerEntity>) servletContext
							.getAttribute("onlineList");
					//�������û���Ϣ��ӵ��������
					servletContext.setAttribute("onlineList",onlineList);

					if (onlineList != null) {
						onlineList.add(uEntity);
					}

					// ת���¼�û��б�
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