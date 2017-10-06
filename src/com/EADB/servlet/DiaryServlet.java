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
 *����ʱ�䣺2017��9��21������4:19:43
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:DiaryServlet.java
 *��˵����
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
		//�ռ�
		if("diaryinsert".equals(type)){
			Diaryinsert(request,response);
		}
		//�����ռ���Ϣ��ѯ
		if("diaryquery".equals(type)){
			Diaryquery(request,response);
		}
		//�����ռ���Ϣ�޸�
		if("diaryupdate".equals(type)){
			Diaryupdate(request,response);
		}
		
		
	}

	/**
	 * @param request
	 * @param response
	 * �����ռ��޸�
	 * @throws UnsupportedEncodingException 
	 */
	private void Diaryupdate(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

				
		String id = request.getParameter("dId");
		//System.out.println(id);
		// ��ȡsession
		HttpSession session=request.getSession();
		String url = "";
		//�ж�ҳ�洩�����ַ����Ƿ�ȫ������
		if(id.matches("^\\d+$")){
			int dId = Integer.parseInt(id);
			//System.out.println(dId);
			
			//��ȡ����
			String dTitle = request.getParameter("dTitle");
			String dContent = request.getParameter("dContent");
			//��ȡ��ǰʱ��
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss");
			String dModifytime = sdf.format(date);
			

			//����service��
			DiaryService diaryService = new DiaryServiceImpl();
			Diary diary = diaryService.DiaryQueryById(dId);
			
			
			if(diary == null){
				session.setAttribute("message", "�ռ���Ϣ�����ڣ�����");
				url = "Employee/message.jsp";
			}else{
				int uId = diary.getuId();
				String dStarttime = diary.getdStarttime();
				diary.setdTitle(dTitle);
				diary.setdContent(dContent);
				diary.setdModifytime(dModifytime);
				boolean flag = diaryService.DiaryUpdate(diary);
				if(flag){
					session.setAttribute("message", "�޸ĳɹ�������");
					url = "Employee/message.jsp";
				}else{
					session.setAttribute("message", "�޸�ʧ�ܣ�����");
					url = "Employee/message.jsp";
				}
			}

			
		}else{
			session.setAttribute("message", "������ı������������һ�����֣�����");
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
	 * �����ռǲ�ѯ
	 * @throws UnsupportedEncodingException 
	 */
	private void Diaryquery(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//��ȡsession
		HttpSession session = request.getSession();
		//��session�л�ȡ��ǰ�û�
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
			session.setAttribute("message", "�ռ���Ϣ�����ڣ�����");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//������Ϣ��session
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
	 * �ռ�
	 * @throws UnsupportedEncodingException 
	 */
	private void Diaryinsert(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//��ȡsession
		HttpSession session = request.getSession();
		//��session�л�ȡ��ǰ�û�
		UserEntity u = (UserEntity) session.getAttribute("userEntity");
		int uId = u.getuId();
		System.out.println(uId);
		//��ȡҳ������
		String dTitle = request.getParameter("dTitle");
		String dContent = request.getParameter("dContent");
		//String lStarttime = request.getParameter("dStarttime");
		//String lDays = request.getParameter("dModifytime");
		//��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss");
		String dStarttime = sdf.format(date);
		String dModifytime = null;
		//��װ����
		Diary d = new Diary();
		d.setuId(uId);
		d.setdTitle(dTitle);
		d.setdContent(dContent);
		d.setdStarttime(dStarttime);
		d.setdModifytime(dModifytime);
		
		//����service��
		DiaryService diaryService = new DiaryServiceImpl();
		boolean flag = diaryService.DiaryInsert(d);
		
		String url = "";
		if(flag){
			session.setAttribute("message", "�ռǱ�д�ɹ�������");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "�ռǱ�дʧ�ܣ�����");
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
