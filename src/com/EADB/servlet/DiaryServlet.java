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

import com.EADB.model.Diary;
import com.EADB.model.UserEntity;
import com.EADB.service.DiaryService;
import com.EADB.service.imp.DiaryServiceImpl;

/**
 *创建时间：2017年9月21日下午4:19:43
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:DiaryServlet.java
 *类说明：
 */

@WebServlet("/diaryServlet")
public class DiaryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3923581161097178386L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		//日记
		if("diaryinsert".equals(type)){
			Diaryinsert(request,response);
		}
		//个人日记信息查询
		if("diaryquery".equals(type)){
			Diaryquery(request,response);
		}
		//个人日记信息修改
		if("diaryupdate".equals(type)){
			Diaryupdate(request,response);
		}
		
		
	}

	/**
	 * @param request
	 * @param response
	 * 个人日记修改
	 * @throws UnsupportedEncodingException 
	 */
	private void Diaryupdate(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

				
		String id = request.getParameter("dId");
		//System.out.println(id);
		// 获取session
		HttpSession session=request.getSession();
		String url = "";
		//判断页面穿来的字符串是否全是数字
		if(id.matches("^\\d+$")){
			int dId = Integer.parseInt(id);
			//System.out.println(dId);
			
			//获取数据
			String dTitle = request.getParameter("dTitle");
			String dContent = request.getParameter("dContent");
			//获取当前时间
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
			String dModifytime = sdf.format(date);
			

			//调用service层
			DiaryService diaryService = new DiaryServiceImpl();
			Diary diary = diaryService.DiaryQueryById(dId);
			
			
			if(diary == null){
				session.setAttribute("message", "日记信息不存在！！！");
				url = "Employee/message.jsp";
			}else{
				int uId = diary.getuId();
				String dStarttime = diary.getdStarttime();
				diary.setdTitle(dTitle);
				diary.setdContent(dContent);
				diary.setdModifytime(dModifytime);
				boolean flag = diaryService.DiaryUpdate(diary);
				if(flag){
					session.setAttribute("message", "修改成功！！！");
					url = "Employee/message.jsp";
				}else{
					session.setAttribute("message", "修改失败！！！");
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
	 * 个人日记查询
	 * @throws UnsupportedEncodingException 
	 */
	private void Diaryquery(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取session
		HttpSession session = request.getSession();
		//从session中获取当前用户
		UserEntity u = (UserEntity) session.getAttribute("userEntity");
		int uId = u.getuId();
		System.out.println(u);
		System.out.println(uId);
		//String username = u.getUsername();
		//String userid = u.getUserid();
		DiaryService diaryService = new DiaryServiceImpl();
		List<Diary> list = diaryService.DiaryQuery(uId);
		System.out.println(list);
		//System.out.println(u);
		if(list == null){
			session.setAttribute("message", "日记信息不存在！！！");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//保存信息到session
			session.setAttribute("diarylist", list);
		try {
			request.getRequestDispatcher("Employee/diary/diaryquery.jsp").forward(request, response);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

	/**
	 * @param request
	 * @param response
	 * 日记
	 * @throws UnsupportedEncodingException 
	 */
	private void Diaryinsert(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取session
		HttpSession session = request.getSession();
		//从session中获取当前用户
		UserEntity u = (UserEntity) session.getAttribute("userEntity");
		int uId = u.getuId();
		System.out.println(uId);
		//获取页面输入
		String dTitle = request.getParameter("dTitle");
		String dContent = request.getParameter("dContent");
		//String lStarttime = request.getParameter("dStarttime");
		//String lDays = request.getParameter("dModifytime");
		//获取当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		String dStarttime = sdf.format(date);
		String dModifytime = null;
		//封装数据
		Diary d = new Diary();
		d.setuId(uId);
		d.setdTitle(dTitle);
		d.setdContent(dContent);
		d.setdStarttime(dStarttime);
		d.setdModifytime(dModifytime);
		
		//调用service层
		DiaryService diaryService = new DiaryServiceImpl();
		boolean flag = diaryService.DiaryInsert(d);
		
		String url = "";
		if(flag){
			session.setAttribute("message", "日记编写成功！！！");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "日记编写失败！！！");
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
