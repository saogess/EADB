package com.EADB.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EADB.model.Attendance;
import com.EADB.model.UserEntity;
import com.EADB.service.AttendanceInfService;
import com.EADB.service.imp.AttendanceInfServiceImp;

/**
 *����ʱ�䣺2017��9��21������9:06:30
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:AttendanceInfServlet.java
 *��˵�������ڹ��ܵ���ز���
 */

@WebServlet("/AttendanceServlet")
public class AttendanceInfServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 327967199216082344L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String type=request.getParameter("type");
		//�鿴ȫ��Ա��������Ϣ
		if("showAll".equals(type)){
			showAllAttendanceInf(request,response);
		}
		//�鿴�̶�Ա��������Ϣ
		if("showPersonal".equals(type)){
			showPersonalAttendanceInf(request,response);
		}
		//Ա������
		if("userAttend".equals(type)){
			userAttendMethod(request,response);
		}
		//ɾ������Ա��������Ϣ
		if("deletePersonal".equals(type)){
			deletePersonalUserAttendMethod(request,response);
		}
		//ɾ������Ա��������Ϣ
		if("deleteAll".equals(type)){
			deleteAllUserAttendMethod(request,response);
		}
}
	//���Ա��������Ϣ
	private void deleteAllUserAttendMethod(HttpServletRequest request,HttpServletResponse response) {
		//���÷���㷽��
		AttendanceInfServiceImp ais=new AttendanceInfServiceImp();
		boolean flag=ais.deleteAllAttendanceInf();
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

	//ɾ������Ա��������Ϣ
	private void deletePersonalUserAttendMethod(HttpServletRequest request,HttpServletResponse response) {
		//��ȡҳ�����
		String userid=request.getParameter("userid");
		//���÷���㷽��
		AttendanceInfServiceImp ais=new AttendanceInfServiceImp();
		boolean flag=ais.deleteByUidAttendanceInf(userid);
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

	//Ա������
	private void userAttendMethod(HttpServletRequest request,HttpServletResponse response) {
		//��ȡҳ�����
		//String userid=request.getParameter("userid");
		HttpSession session=request.getSession();
		UserEntity u=(UserEntity)session.getAttribute("userEntity");
		String userid = u.getUserid();
		//���÷���㷽��
		AttendanceInfServiceImp ais=new AttendanceInfServiceImp();
		boolean flag=false;
		try {
			flag=ais.SignInInsert(userid);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(flag){
			showPersonalAttendanceInf(request,response);
		}else{
			try {
				request.getRequestDispatcher("Employee/userAttendance.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	//�鿴�̶�Ա��������Ϣ
	private void showPersonalAttendanceInf(HttpServletRequest request,HttpServletResponse response) {
		//��ȡҳ�����
		HttpSession session=request.getSession();
		UserEntity u=(UserEntity)session.getAttribute("userEntity");
		String userid = u.getUserid();
		//���÷���㷽��
		AttendanceInfService ais=new AttendanceInfServiceImp();
		List<Attendance> list=ais.findByUIdAttendanceInf(userid);
		if(list == null){
			request.setAttribute("message", "û�в�ѯ��������Ϣ��");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}else{
			request.setAttribute("AttendanceInf", list);
			try {
				request.getRequestDispatcher("Manager/showAllAttendanceInf.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	//�鿴ȫ��Ա��������Ϣ
	private void showAllAttendanceInf(HttpServletRequest request,HttpServletResponse response) {
		//���÷���㷽��
		AttendanceInfService ais=new AttendanceInfServiceImp();
		List<Attendance> list=ais.findAllAttendanceInf();
		System.out.println(list);
		request.setAttribute("AttendanceInf", list);
		try {
			request.getRequestDispatcher("Manager/showAllAttendanceInf.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
