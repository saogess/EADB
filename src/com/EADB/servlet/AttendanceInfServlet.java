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
 *创建时间：2017年9月21日上午9:06:30
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:AttendanceInfServlet.java
 *类说明：考勤功能的相关操作
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
		//查看全部员工考勤信息
		if("showAll".equals(type)){
			showAllAttendanceInf(request,response);
		}
		//查看固定员工考勤信息
		if("showPersonal".equals(type)){
			showPersonalAttendanceInf(request,response);
		}
		//员工考勤
		if("userAttend".equals(type)){
			userAttendMethod(request,response);
		}
		//删除单个员工考勤信息
		if("deletePersonal".equals(type)){
			deletePersonalUserAttendMethod(request,response);
		}
		//删除单个员工考勤信息
		if("deleteAll".equals(type)){
			deleteAllUserAttendMethod(request,response);
		}
}
	//清空员工考勤信息
	private void deleteAllUserAttendMethod(HttpServletRequest request,HttpServletResponse response) {
		//调用服务层方法
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

	//删除单个员工考勤信息
	private void deletePersonalUserAttendMethod(HttpServletRequest request,HttpServletResponse response) {
		//获取页面参数
		String userid=request.getParameter("userid");
		//调用服务层方法
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

	//员工考勤
	private void userAttendMethod(HttpServletRequest request,HttpServletResponse response) {
		//获取页面参数
		//String userid=request.getParameter("userid");
		HttpSession session=request.getSession();
		UserEntity u=(UserEntity)session.getAttribute("userEntity");
		String userid = u.getUserid();
		//调用服务层方法
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

	//查看固定员工考勤信息
	private void showPersonalAttendanceInf(HttpServletRequest request,HttpServletResponse response) {
		//获取页面参数
		HttpSession session=request.getSession();
		UserEntity u=(UserEntity)session.getAttribute("userEntity");
		String userid = u.getUserid();
		//调用服务层方法
		AttendanceInfService ais=new AttendanceInfServiceImp();
		List<Attendance> list=ais.findByUIdAttendanceInf(userid);
		if(list == null){
			request.setAttribute("message", "没有查询到您的信息！");
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

	//查看全部员工考勤信息
	private void showAllAttendanceInf(HttpServletRequest request,HttpServletResponse response) {
		//调用服务层方法
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
