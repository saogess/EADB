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
 *����ʱ�䣺2017��9��20������3:44:46
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:LeaveServlet.java
 *��˵����
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
		//���
		if("leaveinsert".equals(type)){
			Leaveinsert(request,response);
		}
		//���������Ϣ��ѯ
		if("leavequery".equals(type)){
			Leavequery(request,response);
		}
		//���������Ϣɾ��
		if("leavedelete".equals(type)){
			Leavedelete(request,response);
		}
		//������ٴ�����ѯ
		if("querynum".equals(type)){
			Querynum(request,response);
		}
		//��������
		if("leavecancel".equals(type)){
			Leavecancel(request,response);
		}
		//�޸�(ֻ���޸�δ��˵�)
		if("leaveupdate".equals(type)){
			Leaveupdate(request,response);
		}
		//�������
		if("leaveexam".equals(type)){
			Leaveexam(request,response);
		}
		//�����ѯ������Ϣ
		if("leavequeryall".equals(type)){
			Leavequeryall(request,response);
		}
		//�������id��ѯ��Ϣ
		if("leavequerybyid".equals(type)){
			Leavequerybyid(request,response);
		}
		//������׼
		if("leaveCancelUpdate".equals(type)){
			LeaveCancelUpdate(request,response);
		}
		//��ѯ����������Ϣ
		if("queryByAudittype".equals(type)){
			QueryByAudittype(request,response);
		}
	}

	
	/**
	 * @param request
	 * @param response
	 * ��ѯ����������Ϣ
	 * @throws UnsupportedEncodingException 
	 */
	private void QueryByAudittype(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String lCanceltype = "����׼";
		//����service��
		LeaveService leaveService = new LeaveServiceImpl();
		List<LeaveEntity> list = leaveService.QueryByCanceltype(lCanceltype);
		//System.out.println(list);
		
		HttpSession session = request.getSession();
		if(list == null){
			session.setAttribute("message", "���ݿ���û�в�ѯ�������Ϣ������");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//������Ϣ��session
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
	 * ������׼
	 * @throws UnsupportedEncodingException 
	 */
	private void LeaveCancelUpdate(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int lId = Integer.parseInt(request.getParameter("lId"));
		String lCanceltype = "������";
		
		HttpSession session = request.getSession();
		//����service��
		LeaveService leaveService = new LeaveServiceImpl();
		LeaveEntity leaveEntity = leaveService.LeaveEntityQueryById(lId);
		
		leaveEntity.setlCanceltype(lCanceltype);
		
		boolean flag = leaveService.LeaveCancelUpdate(leaveEntity);
		String url = "";
		if(flag){
			session.setAttribute("message", "���ٳɹ�������");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "����ʧ�ܣ�����");
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
	 * ����id��ѯ��Ϣ
	 * @throws UnsupportedEncodingException 
	 */
	private void Leavequerybyid(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//��ȡ����
		int lId = Integer.parseInt(request.getParameter("lId"));
		
		//����service��
		LeaveService leaveService = new LeaveServiceImpl();
		LeaveEntity leaveEntity = leaveService.LeaveEntityQueryById(lId);
		
		
		HttpSession session = request.getSession();
		if(leaveEntity == null){
			session.setAttribute("message", "���ݿ���û�в�ѯ�������Ϣ������");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//������Ϣ��session
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
	 * �����ѯ������Ϣ
	 * @throws UnsupportedEncodingException 
	 */
	private void Leavequeryall(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
			//��������ݽ��б��봦��
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
				
			//����service��
			LeaveService leaveService = new LeaveServiceImpl();
			List<LeaveEntity> list = leaveService.LeaveQueryAll();
			//System.out.println(list);
			
			HttpSession session = request.getSession();
			if(list == null){
				session.setAttribute("message", "���ݿ���û�в�ѯ�������Ϣ������");
				try {
					request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
				}  catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				//������Ϣ��session
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
	 * �������
	 * @throws UnsupportedEncodingException 
	 */
	private void Leaveexam(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//��ȡ����
		String lLeavetype = request.getParameter("lLeavetype");
		String lAudittype = "�����";
		
		//��ȡsession�еľ�����Ϣ�������Ϣ
		HttpSession session = request.getSession();
		
		LeaveEntity l = (LeaveEntity) session.getAttribute("leaveEntity");
		
		l.setlLeavetype(lLeavetype);
		l.setlAudittype(lAudittype);
		
		//����service��
		LeaveService leaveService = new LeaveServiceImpl();
		boolean flag = leaveService.LeaveExam(l);
		String url = "";
		if(flag){
			session.setAttribute("message", "��˳ɹ�������");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "���ʧ�ܣ�����");
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
	 * �޸�(ֻ���޸�δ��˵�)
	 * @throws UnsupportedEncodingException 
	 */
	private void Leaveupdate(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//��ȡ����
		int lId = Integer.parseInt(request.getParameter("lId"));
		//��ȡsession
		HttpSession session = request.getSession();
		//����service��
		LeaveService leaveService = new LeaveServiceImpl();
		LeaveEntity leaveEntity = leaveService.LeaveEntityQueryById(lId);
		
		String url = "";
		if(leaveEntity == null){
			session.setAttribute("message", "û�в�ѯ�����������Ϣ������");
			url = "Employee/message.jsp";
		}else{
			String userid = leaveEntity.getUserid();
			String username = leaveEntity.getUsername();
			String lLeavetype = leaveEntity.getlLeavetype();
			String lAudittype = leaveEntity.getlAudittype();
			String lCanceltype = leaveEntity.getlCanceltype();

			if("�����".equals(lAudittype)){
				String lReason = request.getParameter("lReason");
				String lStarttime = request.getParameter("lStarttime");
				String lDays = request.getParameter("lDays");

				leaveEntity.setlReason(lReason);
				leaveEntity.setlStarttime(lStarttime);
				leaveEntity.setlDays(lDays);
				
				boolean flag = leaveService.LeaveUpdate(leaveEntity);
				
				if(flag){
					session.setAttribute("message", "�޸ĳɹ�������");
					//�޸ĳɹ�
					url = "Employee/message.jsp";
				}else{
					session.setAttribute("message", "�޸�ʧ�ܣ�����");
					//�޸�ʧ��
					url = "Employee/message.jsp";
				}
			
			}else{
				//System.out.println("��Ϣ�ѱ���ˣ������޸�");
				session.setAttribute("message", "��Ϣ�ѱ���ˣ������޸ģ�����");
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
	 * ��������
	 * @throws UnsupportedEncodingException 
	 */
	private void Leavecancel(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//��ȡ����
		String id = request.getParameter("lId");
		
		//��ȡsession
		HttpSession session=request.getSession();
		String url = "";
		
		//�ж�ҳ�洩�����ַ����Ƿ�ȫ������
		if(id.matches("^\\d+$")){
			int lId = Integer.parseInt(id);
			
			//����service��
			LeaveService leaveService = new LeaveServiceImpl();
			LeaveEntity leaveEntity = leaveService.LeaveEntityQueryById(lId);
			
			if(leaveEntity == null){
				session.setAttribute("message", "û�в�ѯ�����������Ϣ������");
				url = "Employee/message.jsp";
			}else{
				String lCanceltype = "����׼";
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
					session.setAttribute("message", "���������������ύ����ȴ�������");
					url = "Employee/message.jsp";
				}else{
					session.setAttribute("message", "��������ʧ�ܣ�����");
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
	 * ������ٴ�����ѯ
	 * @throws UnsupportedEncodingException 
	 */
	private void Querynum(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//��ȡsession
		HttpSession session = request.getSession();
		//��session�л�ȡ��ǰ�û�
		UserEntity u = (UserEntity) session.getAttribute("userEntity");
		String username = u.getUsername();
		
		
		LeaveService leaveService = new LeaveServiceImpl();
		LeaveNum ln = leaveService.QueryNum(username);
		//System.out.println(ln);
		//System.out.println(u);
		if(ln == null){
			session.setAttribute("message", "������˼��û�в�ѯ����Ϣ������");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//request.setAttribute("commodity", commodity);
			//������Ϣ��session
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
	 * ���������Ϣɾ��
	 * @throws UnsupportedEncodingException 
	 */
	private void Leavedelete(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//��ȡsession
		HttpSession session = request.getSession();
		//��ȡ��ǰ�����Ϣ
		//LeaveEntity l = (LeaveEntity) session.getAttribute("");
		//System.out.println(l);
		String lId = request.getParameter("lId");
		LeaveService leaveService = new LeaveServiceImpl();
		boolean flag = leaveService.LeaveDelete(lId);
		String url = "";
		if(flag){
			session.setAttribute("message", "ɾ���ɹ�������");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "ɾ��ʧ�ܣ�����");
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
	 * ���������Ϣ��ѯ
	 * @throws UnsupportedEncodingException 
	 */
	private void Leavequery(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//��ȡsession
		HttpSession session = request.getSession();
		//��session�л�ȡ��ǰ�û�
		UserEntity u = (UserEntity) session.getAttribute("userEntity");
		String username = u.getUsername();
		LeaveService leaveService = new LeaveServiceImpl();
		List<LeaveEntity> list = leaveService.LeaveQuery(username);
		//System.out.println(list);
		//System.out.println(u);
		if(list == null){
			session.setAttribute("message", "���ݿ���û�����������Ϣ������");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//request.setAttribute("commodity", commodity);
			//������Ϣ��session
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
	 * ���
	 * @throws UnsupportedEncodingException 
	 */
	private void Leaveinsert(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//��ȡsession
		HttpSession session = request.getSession();
		//��session�л�ȡ��ǰ�û�
		UserEntity u = (UserEntity) session.getAttribute("userEntity");
		String username = u.getUsername();
		String userid = u.getUserid();
		/*System.out.println(username);
		System.out.println(userid);*/
		//��ȡҳ������
		String lReason = request.getParameter("lReason");
		String lStarttime = request.getParameter("lStarttime");
		String lDays = request.getParameter("lDays");
		/*String lLeavetype = request.getParameter("lLeavetype");
		String lAudittype = request.getParameter("lAudittype");*/
		String lLeavetype = "δ���";
		String lAudittype = "�����";
		String lCanceltype = "δ����";		
		
		//��װ����
		LeaveEntity l = new LeaveEntity();
		l.setUserid(userid);
		l.setUsername(username);
		l.setlReason(lReason);
		l.setlStarttime(lStarttime);
		l.setlDays(lDays);
		l.setlLeavetype(lLeavetype);
		l.setlAudittype(lAudittype);
		l.setlCanceltype(lCanceltype);
		
		//����service��
		LeaveService leaveService = new LeaveServiceImpl();
		boolean flag = leaveService.LeaveInsert(l);
		
		//���ʱ��ѯʣ�����
		LeaveNum ln = leaveService.QueryNum(username);
		int nNum = ln.getLnNum();
		
		String url = "";
		if(flag&&nNum>0){
			session.setAttribute("message", "������ٳɹ��������ĵȴ�������ˣ�����");
			url = "Employee/message.jsp";
		}else if(flag&&nNum<=0){
			session.setAttribute("message", "�����µ���ٴ��������꣡�������������Ч������");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "�������ʧ�ܣ�����");
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
