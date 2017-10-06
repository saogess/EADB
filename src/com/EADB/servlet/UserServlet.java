package com.EADB.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpRetryException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.EADB.dao.imp.UserDaoImpl;
import com.EADB.model.FileEntity;
import com.EADB.model.LeaveNum;
import com.EADB.model.UserEntity;
import com.EADB.service.UserService;
import com.EADB.service.imp.UserServiceImpl;

import net.sf.json.JSONArray;
/**
 *����ʱ�䣺2017��9��18������10:01:11
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:UserServlet.java
 *��˵�����û���ע�ᡢ��¼����ѯ���޸ġ�ɾ�����˳�
 */

@WebServlet("/loginServlet")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9143565324385953115L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if("regist".equals(type)){
			//ע��
			UserRegist(request,response);
		}
		//��¼�ж�
		if("login".equals(type)){
			UserLogin(request,response);
		}
		//�ֻ�����֤����
		if("loginphone".equals(type))
		{
			Loginphone(request,response);
		}
		//�ֻ�����������ƥ����֤
		if("loginphoneAndpwd".equals(type))
		{
			LoginphoneAndpwd(request,response);
		}
		//��ѯ����
		if("findAllUserEntity".equals(type)){
			FindAllUserEntity(request,response);
		}
		//��ѯ����(��ȷ)
		if("findByuName".equals(type)){
			FindByuName(request,response);
		}
		//�޸�
		if("userEntityUpdate".equals(type)){
			UserEntityUpdate(request,response);
		}
		//ɾ��
		if("userEntityDelete".equals(type)){
			UserEntityDelete(request,response);
		}
		//�˳�
		if("loginout".equals(type)){
			LoginOut(request, response);
		}
		//�ϴ�ͷ��
		if("userupload".equals(type)){
			Userupload(request, response);
		}
	}

	/**
	 * @param request
	 * @param response
	 * �ϴ�ͷ��
	 * @throws UnsupportedEncodingException 
	 */
	private void Userupload(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {

		request.setCharacterEncoding("utf-8"); 

		// ��װ���ݵĶ���
		FileEntity f = new FileEntity();

		// ��ȡsession
		HttpSession session = request.getSession();
		UserEntity u = (UserEntity) session.getAttribute("userEntity");

		String userid = u.getUserid();
		String username = u.getUsername();
		
		//��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss");
		String fDate = sdf.format(date);
		
		f.setUserid(userid);
		f.setUsername(username);
		f.setfDate(fDate);
		
		
        DiskFileItemFactory factory = new DiskFileItemFactory();// ��ô����ļ���Ŀ����  
                // ��ȡ�������µĹ����ļ���image�ļ��е�·��  
        String path=request.getSession().getServletContext().getRealPath("/")+"upload";  
        //System.out.println("�ļ�����·����" + path); 
        
        
        /** 
         * ���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬 ������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ ԭ�� 
         * �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ� ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem ��ʽ�� 
         * Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ���� 
         */  
        factory.setRepository(new File(path));  
        // ���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��  
        factory.setSizeThreshold(1024 * 1024);  
        // ��ˮƽ��API�ļ��ϴ�����  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        try {  
            // �����ϴ�����ļ�  
            List<FileItem> list = (List<FileItem>) upload.parseRequest(request);  
  
            for (FileItem item : list) {  
                // ��ȡ������������  
                String name = item.getFieldName();  
  
                // �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ  
                if (item.isFormField()) {  
                    // ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�  
                    String value = item.getString();  
  
                    request.setAttribute(name, value);  
                }  
                // �Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ  
                else {  
                    /** 
                     * ������������Ҫ��ȡ �ϴ��ļ������� 
                     */  
                    // ��ȡ·����  
                    String value = item.getName();  
                    // ���������һ����б��  
                    int start = value.lastIndexOf("/");  
                    // ��ȡ�ϴ��ļ��� �ַ������֣���1��ȥ����б�ܣ�  
                    String userpic = value.substring(start + 1);
                    
                    //System.out.println(userpic);
                    
                    request.setAttribute(name, userpic);  
                    // ����д��������  
                    OutputStream out = new FileOutputStream(new File(path,userpic));  
                    InputStream in = item.getInputStream();  
                    int length = 0;  
                    byte[] buf = new byte[1024];  
                    //System.out.println("��ȡ�ϴ��ļ����ܹ���������" + item.getSize()+"�ļ���Ϊ��"+path+"/"+userpic);  
                    //�����ݿ���д���ļ�·��  
                    f.setUserpic("upload/"+userpic);  
                    //Images images = new Images();  
                    //images.updateImage(image);//���ļ���д�����ݿ��С�<span style="font-family: Arial, Helvetica, sans-serif;">              </span>  
                    // in.read(buf) ÿ�ζ��������ݴ���� buf ������ 
                    
                 // �����ݿ�д����
    				UserService userService = new UserServiceImpl();
    				boolean flag = userService.FileInsert(f);
    				String url = "";
    				if(flag){
    					session.setAttribute("message", "�ϴ��ɹ�������");
    					while ((length = in.read(buf)) != -1) {  
                            // �� buf ������ ȡ������ д�� ���������������  
                            out.write(buf, 0, length);
    					url = "Employee/message.jsp";
    					}
    				}else{
    					session.setAttribute("message", "�ϴ�ʧ�ܣ�����");
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
  
        } catch (FileUploadException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  

	}

	/**
	 * @param request
	 * @param response
	 * �˳�
	 */
	private void LoginOut(HttpServletRequest request,
			HttpServletResponse response) {
		//��ȡsession
		HttpSession session =request.getSession(false);
		
		if(session!=null)
		{
			session.invalidate();
			//����(�����session��ע��)java.lang.IllegalStateException: getAttribute: Session already invalidated
			//UserEntity user = (UserEntity)session.getAttribute("userEntity");
		}
		try {
			response.sendRedirect(request.getContextPath()+"/Admin/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param request
	 * @param response
	 * ɾ��
	 * @throws UnsupportedEncodingException 
	 */
	private void UserEntityDelete(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//��ȡ���������
		String userId = request.getParameter("userId");
		//����service���ȡ�û���Ϣ
		UserDaoImpl udi=new UserDaoImpl();
		UserService userService = new UserServiceImpl();
		UserEntity u = udi.findByuId(userId);
		//ɾ��
		boolean flag = userService.userEntityDelete(u);
		// ��ȡsession
		HttpSession session=request.getSession();
		String url = "";
		if(flag){
			session.setAttribute("message", "ɾ���ɹ�������");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "ɾ��ʧ�ܣ�����");
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
	 * �޸�
	 * @throws UnsupportedEncodingException 
	 */
	private void UserEntityUpdate(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		// ��ȡsession
		HttpSession session=request.getSession();
		//��session�л�ȡ��ǰ�û�����
		UserEntity user = (UserEntity)session.getAttribute("userEntity");
		//System.out.println(user);
		String userid=user.getUserid();
		String username=user.getUsername();
		String usergender=user.getUsergender();
		String userbirthday=user.getUserbirthday();
		String userdept=user.getUserdept();
		
		//��ȡ����
		//String uName = request.getParameter("uName");
		String userpassword = request.getParameter("userpassword");
		//String uGender = request.getParameter("uGender");
		String useremail = request.getParameter("useremail");
		String userphone = request.getParameter("userphone");
		//String uBirthday = request.getParameter("uBirthday");
		String useraddress = request.getParameter("useraddress");
		
		
		//��װ����
		UserEntity u = new UserEntity();
		u.setUserid(userid);
		u.setUsername(username);
		u.setUserpassword(userpassword);
		u.setUsergender(usergender);
		u.setUseremail(useremail);
		u.setUserphone(userphone);
		u.setUserbirthday(userbirthday);
		u.setUseraddress(useraddress);
		u.setUserdept(userdept);
		
		//����service��
		UserService userService = new UserServiceImpl();
		boolean flag = userService.userEntityUpdate(u);
		String url = "";
		if(flag){
			session.setAttribute("message", "�޸ĳɹ�������");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "�޸�ʧ�ܣ�����");
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
	 * ��ѯ��������ȷ��
	 * @throws UnsupportedEncodingException 
	 */
	private void FindByuName(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// ��ȡsession
		HttpSession session=request.getSession();
		//��session�л�ȡ��ǰ�û�����
		UserEntity user = (UserEntity)session.getAttribute("userEntity");
		System.out.println(user);
		String username = user.getUsername();
		System.out.println(username);
		UserService userService = new UserServiceImpl();
		UserEntity u = userService.findByuName(username);
		System.out.println(u);
		if(u == null){
			//System.out.println("�û������ڣ�����");
			session.setAttribute("message", "����ѯ��Ա�������ڣ�����");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			session.setAttribute("userEntity", u);
		try {
			request.getRequestDispatcher("Employee/user/findByuName.jsp").forward(request, response);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

	/**
	 * @param request
	 * @param response
	 * ��ѯ����
	 */
	private void FindAllUserEntity(HttpServletRequest request,
			HttpServletResponse response) {
		//��������ݽ��б��봦��
		response.setCharacterEncoding("utf-8");
		
		//����service��
		UserService userService = new UserServiceImpl();
		List<UserEntity> list = userService.findAllUserEntity();
		//System.out.println(list);
		
		HttpSession session = request.getSession();
		if(list == null){
			session.setAttribute("message", "���ݿ���û�в�ѯ��Ա����Ϣ������");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//������Ϣ��session
			session.setAttribute("userlist", list);
			try {
				request.getRequestDispatcher("Employee/user/findAll.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}

		
	}

		//�û������������ƥ����֤
		private void LoginphoneAndpwd(HttpServletRequest request,HttpServletResponse response) {
			//��ȡҳ��Ĳ���
			String userid=request.getParameter("userid");
			String userpassword=request.getParameter("userpassword");
			response.setContentType("text/html;charset=utf-8");
			//��װ����
			UserEntity u=new UserEntity();
			u.setUserid(userid);
			u.setUserpassword(userpassword);
			//���÷���㷽��
			UserService userService=new UserServiceImpl();
			UserEntity ui=userService.UserLogin(u,1);
			PrintWriter out=null;
			try {
				out = response.getWriter();
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
		//�û������֤����
		private void Loginphone(HttpServletRequest request, HttpServletResponse response) {
			//��ȡҳ��Ĳ���
			String userid=request.getParameter("userid");
			response.setContentType("text/html;charset=utf-8");
			//��װ����
			UserEntity u=new UserEntity();
			u.setUserid(userid);
			//���÷���㷽��
			UserService userService=new UserServiceImpl();
			UserEntity ui=userService.UserLogin(u,0);
			PrintWriter out=null;
			try {
				out = response.getWriter();
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
		
		//�û���¼������
		private void UserLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
			//��ȡҳ��Ĳ���
			String userid=request.getParameter("userid");
			String userpassword=request.getParameter("userpassword");
			response.setContentType("text/html;charset=utf-8");
			//��װ����
			UserEntity u=new UserEntity();
			u.setUserid(userid);
			u.setUserpassword(userpassword);
			//System.out.println(u);
			//���÷���㷽��
			UserService userService=new UserServiceImpl();
			UserEntity ui=userService.UserLogin(u,1);
			HttpSession session=request.getSession();
			String url="";
			//�ж��Ƿ��¼�ɹ�
			if(ui==null){
				//���ص�¼ҳ
				url="Admin/login.jsp";
			}else{
				//���������Ϣ������session��
				session.setAttribute("userEntity", ui);
				
				//��ȡ�û���Ϣ
				String username = ui.getUsername();
				//���÷���㷽����ȡͷ����Ϣ
				FileEntity f = userService.findFile(username);
				//System.out.println(f);
				
				if(f != null){
					session.setAttribute("fileEntity", f);
					url="Employee/admin.jsp";
				}else{
					url="Employee/admin.jsp";
				}
				
			}
			//����ҳ����ת
			try {
				response.sendRedirect(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	/**
	 * ע��
	 * @throws UnsupportedEncodingException 
	 *  
	 */
	private void UserRegist(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//��ȡ����
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		String usergender = request.getParameter("usergender");
		String useremail = request.getParameter("useremail");
		String userphone = request.getParameter("userphone");
		String userbirthday = request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("date");
		String useraddress = request.getParameter("useraddress");
		String userdept = request.getParameter("userdept");

		
		//��װ����
		UserEntity u = new UserEntity();
		u.setUserid(userid);
		u.setUsername(username);
		u.setUserpassword(userpassword);
		u.setUsergender(usergender);
		u.setUseremail(useremail);
		u.setUserphone(userphone);
		u.setUserbirthday(userbirthday);
		u.setUseraddress(useraddress);
		u.setUserdept(userdept);
		/*u.setuPicUrl(uPicUrl);*/
		
		//������ٴ���Ĭ��ֵ
		int lnNum = 5;
		//��װ����
		LeaveNum ln = new LeaveNum();
		ln.setUsername(username);
		ln.setLnNum(lnNum);
		
		//����service��
		UserService userService = new UserServiceImpl();
		boolean flag = userService.UserRegist(u);
		String url = "";
		if(flag){
			boolean flag1 = userService.NumberRegist(ln);
			url = "Manager/success.jsp";
		}else{
			url = "Employee/user/regist.jsp";
		}
		
		/*try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
