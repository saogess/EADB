package com.EADB.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EADB.model.LeaveEntity;
import com.EADB.model.LeaveNum;
import com.EADB.model.UserEntity;
import com.EADB.service.LeaveService;
import com.EADB.service.imp.LeaveServiceImpl;
/**
 *创建时间：2017年9月20日下午3:44:46
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:LeaveServlet.java
 *类说明：
 */
@WebServlet("/leaveServlet")
public class LeaveServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2049315800050594017L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = request.getParameter("type");
		//请假
		if("leaveinsert".equals(type)){
			Leaveinsert(request,response);
		}
		//个人请假信息查询
		if("leavequery".equals(type)){
			Leavequery(request,response);
		}
		//个人请假信息删除
		if("leavedelete".equals(type)){
			Leavedelete(request,response);
		}
		//个人请假次数查询
		if("querynum".equals(type)){
			Querynum(request,response);
		}
		//请求销假
		if("leavecancel".equals(type)){
			Leavecancel(request,response);
		}
		//修改(只能修改未审核的)
		if("leaveupdate".equals(type)){
			Leaveupdate(request,response);
		}
		//经理审核
		if("leaveexam".equals(type)){
			Leaveexam(request,response);
		}
		//经理查询所有信息
		if("leavequeryall".equals(type)){
			Leavequeryall(request,response);
		}
		//经理根据id查询信息
		if("leavequerybyid".equals(type)){
			Leavequerybyid(request,response);
		}
		//销假批准
		if("leaveCancelUpdate".equals(type)){
			LeaveCancelUpdate(request,response);
		}
		//查询所有销假信息
		if("queryByAudittype".equals(type)){
			QueryByAudittype(request,response);
		}
	}

	
	/**
	 * @param request
	 * @param response
	 * 查询所有销假信息
	 * @throws UnsupportedEncodingException 
	 */
	private void QueryByAudittype(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String lCanceltype = "待批准";
		//调用service层
		LeaveService leaveService = new LeaveServiceImpl();
		List<LeaveEntity> list = leaveService.QueryByCanceltype(lCanceltype);
		//System.out.println(list);
		
		HttpSession session = request.getSession();
		if(list == null){
			session.setAttribute("message", "数据库中没有查询到请假信息！！！");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//保存信息到session
			session.setAttribute("leavecancellist", list);
			try {
				request.getRequestDispatcher("Employee/leave/showAllLeaveCancel.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * @param request
	 * @param response
	 * 销假批准
	 * @throws UnsupportedEncodingException 
	 */
	private void LeaveCancelUpdate(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int lId = Integer.parseInt(request.getParameter("lId"));
		String lCanceltype = "已销假";
		
		HttpSession session = request.getSession();
		//调用service层
		LeaveService leaveService = new LeaveServiceImpl();
		LeaveEntity leaveEntity = leaveService.LeaveEntityQueryById(lId);
		
		leaveEntity.setlCanceltype(lCanceltype);
		
		boolean flag = leaveService.LeaveCancelUpdate(leaveEntity);
		String url = "";
		if(flag){
			session.setAttribute("message", "销假成功！！！");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "销假失败！！！");
			url = "Employee/message.jsp";
		}
		

		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @param request
	 * @param response
	 * 根据id查询信息
	 * @throws UnsupportedEncodingException 
	 */
	private void Leavequerybyid(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取数据
		int lId = Integer.parseInt(request.getParameter("lId"));
		
		//调用service层
		LeaveService leaveService = new LeaveServiceImpl();
		LeaveEntity leaveEntity = leaveService.LeaveEntityQueryById(lId);
		
		
		HttpSession session = request.getSession();
		if(leaveEntity == null){
			session.setAttribute("message", "数据库中没有查询到请假信息！！！");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//保存信息到session
			session.setAttribute("leaveEntity", leaveEntity);
			try {
				request.getRequestDispatcher("Employee/leave/examUserLeaveInf.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * @param request
	 * @param response
	 * 经理查询所有信息
	 * @throws UnsupportedEncodingException 
	 */
	private void Leavequeryall(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
			//对输出数据进行编码处理
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
				
			//调用service层
			LeaveService leaveService = new LeaveServiceImpl();
			List<LeaveEntity> list = leaveService.LeaveQueryAll();
			//System.out.println(list);
			
			HttpSession session = request.getSession();
			if(list == null){
				session.setAttribute("message", "数据库中没有查询到请假信息！！！");
				try {
					request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
				}  catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				//保存信息到session
				session.setAttribute("leavelist", list);
				try {
					request.getRequestDispatcher("Employee/leave/showAllUserLeaveInf.jsp").forward(request, response);
				}  catch (Exception e) {
					e.printStackTrace();
				}
			}
	}


	/**
	 * @param request
	 * @param response
	 * 经理审核
	 * @throws UnsupportedEncodingException 
	 */
	private void Leaveexam(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取数据
		String lLeavetype = request.getParameter("lLeavetype");
		String lAudittype = "已审核";
		
		//获取session中的经理信息和请假信息
		HttpSession session = request.getSession();
		
		LeaveEntity l = (LeaveEntity) session.getAttribute("leaveEntity");
		
		l.setlLeavetype(lLeavetype);
		l.setlAudittype(lAudittype);
		
		//调用service层
		LeaveService leaveService = new LeaveServiceImpl();
		boolean flag = leaveService.LeaveExam(l);
		String url = "";
		if(flag){
			session.setAttribute("message", "审核成功！！！");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "审核失败！！！");
			url = "Employee/message.jsp";
		}
		

		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @param request
	 * @param response
	 * 修改(只能修改未审核的)
	 * @throws UnsupportedEncodingException 
	 */
	private void Leaveupdate(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取数据
		int lId = Integer.parseInt(request.getParameter("lId"));
		//获取session
		HttpSession session = request.getSession();
		//调用service层
		LeaveService leaveService = new LeaveServiceImpl();
		LeaveEntity leaveEntity = leaveService.LeaveEntityQueryById(lId);
		
		String url = "";
		if(leaveEntity == null){
			session.setAttribute("message", "没有查询到您的请假信息！！！");
			url = "Employee/message.jsp";
		}else{
			String userid = leaveEntity.getUserid();
			String username = leaveEntity.getUsername();
			String lLeavetype = leaveEntity.getlLeavetype();
			String lAudittype = leaveEntity.getlAudittype();
			String lCanceltype = leaveEntity.getlCanceltype();

			if("待审核".equals(lAudittype)){
				String lReason = request.getParameter("lReason");
				String lStarttime = request.getParameter("lStarttime");
				String lDays = request.getParameter("lDays");

				leaveEntity.setlReason(lReason);
				leaveEntity.setlStarttime(lStarttime);
				leaveEntity.setlDays(lDays);
				
				boolean flag = leaveService.LeaveUpdate(leaveEntity);
				
				if(flag){
					session.setAttribute("message", "修改成功！！！");
					//修改成功
					url = "Employee/message.jsp";
				}else{
					session.setAttribute("message", "修改失败！！！");
					//修改失败
					url = "Employee/message.jsp";
				}
			
			}else{
				//System.out.println("信息已被审核，不能修改");
				session.setAttribute("message", "信息已被审核，不能修改！！！");
				url = "Employee/message.jsp";
			}	
		}

		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @param request
	 * @param response
	 * 请求销假
	 * @throws UnsupportedEncodingException 
	 */
	private void Leavecancel(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取数据
		String id = request.getParameter("lId");
		
		//获取session
		HttpSession session=request.getSession();
		String url = "";
		
		//判断页面穿来的字符串是否全是数字
		if(id.matches("^\\d+$")){
			int lId = Integer.parseInt(id);
			
			//调用service层
			LeaveService leaveService = new LeaveServiceImpl();
			LeaveEntity leaveEntity = leaveService.LeaveEntityQueryById(lId);
			
			if(leaveEntity == null){
				session.setAttribute("message", "没有查询到您的请假信息！！！");
				url = "Employee/message.jsp";
			}else{
				String lCanceltype = "待批准";
				leaveEntity.setlCanceltype(lCanceltype);
				
				String userid = leaveEntity.getUserid();
				String username = leaveEntity.getUsername();
				String lReason = leaveEntity.getlReason();
				String lDays = leaveEntity.getlDays();
				String lStarttime = leaveEntity.getlStarttime();
				String lLeavetype = leaveEntity.getlLeavetype();
				String lAudittype = leaveEntity.getlAudittype();

				
				boolean flag = leaveService.LeaveCancel(leaveEntity);
				if(flag){
					session.setAttribute("message", "您的销假申请已提交，请等待！！！");
					url = "Employee/message.jsp";
				}else{
					session.setAttribute("message", "申请销假失败！！！");
					url = "Employee/message.jsp";
				}
			}
		}else{
			session.setAttribute("message", "您输入的编号有误，请输入一个数字！！！");
			url = "Employee/message.jsp";
		}
		
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @param request
	 * @param response
	 * 个人请假次数查询
	 * @throws UnsupportedEncodingException 
	 */
	private void Querynum(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取session
		HttpSession session = request.getSession();
		//从session中获取当前用户
		UserEntity u = (UserEntity) session.getAttribute("userEntity");
		String username = u.getUsername();
		
		
		LeaveService leaveService = new LeaveServiceImpl();
		LeaveNum ln = leaveService.QueryNum(username);
		//System.out.println(ln);
		//System.out.println(u);
		if(ln == null){
			session.setAttribute("message", "不好意思，没有查询到信息！！！");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//request.setAttribute("commodity", commodity);
			//保存信息到session
			session.setAttribute("leavenum", ln);
		try {
			request.getRequestDispatcher("Employee/leave/querynum.jsp").forward(request, response);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

	/**
	 * @param request
	 * @param response
	 * 个人请假信息删除
	 * @throws UnsupportedEncodingException 
	 */
	private void Leavedelete(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取session
		HttpSession session = request.getSession();
		//获取当前请假信息
		//LeaveEntity l = (LeaveEntity) session.getAttribute("");
		//System.out.println(l);
		String lId = request.getParameter("lId");
		LeaveService leaveService = new LeaveServiceImpl();
		boolean flag = leaveService.LeaveDelete(lId);
		String url = "";
		if(flag){
			session.setAttribute("message", "删除成功！！！");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "删除失败！！！");
			url = "Employe/message.jsp";
		}
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param request
	 * @param response
	 * 个人请假信息查询
	 * @throws UnsupportedEncodingException 
	 */
	private void Leavequery(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取session
		HttpSession session = request.getSession();
		//从session中获取当前用户
		UserEntity u = (UserEntity) session.getAttribute("userEntity");
		String username = u.getUsername();
		LeaveService leaveService = new LeaveServiceImpl();
		List<LeaveEntity> list = leaveService.LeaveQuery(username);
		//System.out.println(list);
		//System.out.println(u);
		if(list == null){
			session.setAttribute("message", "数据库中没有您的请假信息！！！");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//request.setAttribute("commodity", commodity);
			//保存信息到session
			session.setAttribute("leaveEntitylist", list);
		try {
			request.getRequestDispatcher("Employee/leave/leavequery.jsp").forward(request, response);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

	/**
	 * @param request
	 * @param response
	 * 请假
	 * @throws UnsupportedEncodingException 
	 */
	private void Leaveinsert(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取session
		HttpSession session = request.getSession();
		//从session中获取当前用户
		UserEntity u = (UserEntity) session.getAttribute("userEntity");
		String username = u.getUsername();
		String userid = u.getUserid();
		/*System.out.println(username);
		System.out.println(userid);*/
		//获取页面输入
		String lReason = request.getParameter("lReason");
		String lStarttime = request.getParameter("lStarttime");
		String lDays = request.getParameter("lDays");
		/*String lLeavetype = request.getParameter("lLeavetype");
		String lAudittype = request.getParameter("lAudittype");*/
		String lLeavetype = "未审核";
		String lAudittype = "待审核";
		String lCanceltype = "未申请";		
		
		//封装数据
		LeaveEntity l = new LeaveEntity();
		l.setUserid(userid);
		l.setUsername(username);
		l.setlReason(lReason);
		l.setlStarttime(lStarttime);
		l.setlDays(lDays);
		l.setlLeavetype(lLeavetype);
		l.setlAudittype(lAudittype);
		l.setlCanceltype(lCanceltype);
		
		//调用service层
		LeaveService leaveService = new LeaveServiceImpl();
		boolean flag = leaveService.LeaveInsert(l);
		
		//请假时查询剩余次数
		LeaveNum ln = leaveService.QueryNum(username);
		int nNum = ln.getLnNum();
		
		String url = "";
		if(flag&&nNum>0){
			session.setAttribute("message", "申请请假成功，请耐心等待经理审核！！！");
			url = "Employee/message.jsp";
		}else if(flag&&nNum<=0){
			session.setAttribute("message", "您本月的请假次数已用完！！！本次请假无效！！！");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "申请请假失败！！！");
			url = "Employee/message.jsp";
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
