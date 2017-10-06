package com.EADB.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EADB.model.Manager;
import com.EADB.model.ManagerDiary;
import com.EADB.service.ManagerDiaryService;
import com.EADB.service.imp.ManagerDiaryServiceImp;

/**
 *����ʱ�䣺2017��9��22������9:08:21
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:ManagerDiaryServlet.java
 *��˵����������־����
 */
@WebServlet("/managerDiaryServlet")
public class ManagerDiaryServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9124639939180693657L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String type=request.getParameter("type");
		//�����־
		if("add".equals(type)){
			addManagerDiary(request,response);
		}
		//��ѯ��־��Ϣ����ѯ���⣩
		if("showAll".equals(type)){
			findAllManagerDiary(request,response);
		}
		//��ѯ��־��Ϣ����ϸ���ݣ�
		if("showOne".equals(type)){
			findOneManagerDiary(request,response);
		}
		//�޸���־��Ϣ
		if("update".equals(type)){
			updateManagerDiary(request,response);
		}
	}

	//�޸���־��Ϣ
	private void updateManagerDiary(HttpServletRequest request,HttpServletResponse response) {
		//���������
		ManagerDiaryService mds=new ManagerDiaryServiceImp();
		//��ȡ����
		int dId=Integer.parseInt(request.getParameter("mid"));
		String title=request.getParameter("title");
		String content=request.getParameter("managerDiary");
		if(content==null||content==" "||content==""){
			ManagerDiary md1=mds.showOneManagerDiary(dId);
			content=md1.getdContent();
		}
		//��ȡʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);
		//��װ����
		ManagerDiary md=new ManagerDiary();
		md.setdId(dId);
		md.setdTitle(title);
		md.setdContent(content);
		md.setdModifytime(time);
		System.out.println(md);
		//���÷����
		boolean flag=mds.updateManagerDairy(md);
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

	//��ѯ��־��Ϣ����ϸ���ݣ�
	private void findOneManagerDiary(HttpServletRequest request,HttpServletResponse response) {
		//��ȡ����
		int dId=Integer.parseInt(request.getParameter("mid"));
		//���÷����
		ManagerDiaryService mds=new ManagerDiaryServiceImp();
		ManagerDiary md=mds.showOneManagerDiary(dId);
		request.setAttribute("details", md);
		try {
			request.getRequestDispatcher("Manager/showOneManagerDiary.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	//��ѯ��־��Ϣ����ѯ���⣩
	private void findAllManagerDiary(HttpServletRequest request,HttpServletResponse response) {
		//��ȡ����
		HttpSession session=request.getSession();
		Manager m=(Manager)session.getAttribute("mInf");
		//���÷����
		ManagerDiaryService mds=new ManagerDiaryServiceImp();
		List<ManagerDiary> list=mds.showAllManagerDiary(m.getMid());
		request.setAttribute("managerDiarise", list);
		try {
			request.getRequestDispatcher("Manager/showAllManagerDiary.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	//�����־
	private void addManagerDiary(HttpServletRequest request,HttpServletResponse response) {
		//��ȡ����
		String title=request.getParameter("title");
		String content=request.getParameter("managerDiary");
		HttpSession session=request.getSession();
		Manager m=(Manager)session.getAttribute("mInf");
		//��ȡʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);
		//��װ����
		ManagerDiary md=new ManagerDiary();
		md.setManagerId(m.getId());
		md.setdTitle(title);
		md.setdContent(content);
		md.setdStarttime(time);
		md.setdModifytime(time);
		//���÷����
		ManagerDiaryService mds=new ManagerDiaryServiceImp();
		boolean flag=mds.insertManagerDiary(md);
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
}
