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
 *创建时间：2017年9月18日上午10:01:11
 *项目名称：user
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:UserServlet.java
 *类说明：用户的注册、登录、查询、修改、删除及退出
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
			//注册
			UserRegist(request,response);
		}
		//登录判断
		if("login".equals(type)){
			UserLogin(request,response);
		}
		//手机号验证操作
		if("loginphone".equals(type))
		{
			Loginphone(request,response);
		}
		//手机号与密码相匹配验证
		if("loginphoneAndpwd".equals(type))
		{
			LoginphoneAndpwd(request,response);
		}
		//查询所有
		if("findAllUserEntity".equals(type)){
			FindAllUserEntity(request,response);
		}
		//查询单个(精确)
		if("findByuName".equals(type)){
			FindByuName(request,response);
		}
		//修改
		if("userEntityUpdate".equals(type)){
			UserEntityUpdate(request,response);
		}
		//删除
		if("userEntityDelete".equals(type)){
			UserEntityDelete(request,response);
		}
		//退出
		if("loginout".equals(type)){
			LoginOut(request, response);
		}
		//上传头像
		if("userupload".equals(type)){
			Userupload(request, response);
		}
	}

	/**
	 * @param request
	 * @param response
	 * 上传头像
	 * @throws UnsupportedEncodingException 
	 */
	private void Userupload(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {

		request.setCharacterEncoding("utf-8"); 

		// 封装数据的对象
		FileEntity f = new FileEntity();

		// 获取session
		HttpSession session = request.getSession();
		UserEntity u = (UserEntity) session.getAttribute("userEntity");

		String userid = u.getUserid();
		String username = u.getUsername();
		
		//获取当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		String fDate = sdf.format(date);
		
		f.setUserid(userid);
		f.setUsername(username);
		f.setfDate(fDate);
		
		
        DiskFileItemFactory factory = new DiskFileItemFactory();// 获得磁盘文件条目工厂  
                // 获取服务器下的工程文件中image文件夹的路径  
        String path=request.getSession().getServletContext().getRealPath("/")+"upload";  
        //System.out.println("文件保存路径：" + path); 
        
        
        /** 
         * 如果没以下两行设置的话，上传大的 文件 会占用 很多内存， 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同 原理 
         * 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的 
         * 然后再将其真正写到 对应目录的硬盘上 
         */  
        factory.setRepository(new File(path));  
        // 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室  
        factory.setSizeThreshold(1024 * 1024);  
        // 高水平的API文件上传处理  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        try {  
            // 可以上传多个文件  
            List<FileItem> list = (List<FileItem>) upload.parseRequest(request);  
  
            for (FileItem item : list) {  
                // 获取表单的属性名字  
                String name = item.getFieldName();  
  
                // 如果获取的 表单信息是普通的 文本 信息  
                if (item.isFormField()) {  
                    // 获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的  
                    String value = item.getString();  
  
                    request.setAttribute(name, value);  
                }  
                // 对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些  
                else {  
                    /** 
                     * 以下三步，主要获取 上传文件的名字 
                     */  
                    // 获取路径名  
                    String value = item.getName();  
                    // 索引到最后一个反斜杠  
                    int start = value.lastIndexOf("/");  
                    // 截取上传文件的 字符串名字，加1是去掉反斜杠，  
                    String userpic = value.substring(start + 1);
                    
                    //System.out.println(userpic);
                    
                    request.setAttribute(name, userpic);  
                    // 真正写到磁盘上  
                    OutputStream out = new FileOutputStream(new File(path,userpic));  
                    InputStream in = item.getInputStream();  
                    int length = 0;  
                    byte[] buf = new byte[1024];  
                    //System.out.println("获取上传文件的总共的容量：" + item.getSize()+"文件名为："+path+"/"+userpic);  
                    //向数据库中写入文件路径  
                    f.setUserpic("upload/"+userpic);  
                    //Images images = new Images();  
                    //images.updateImage(image);//把文件名写到数据库中。<span style="font-family: Arial, Helvetica, sans-serif;">              </span>  
                    // in.read(buf) 每次读到的数据存放在 buf 数组中 
                    
                 // 向数据库写数据
    				UserService userService = new UserServiceImpl();
    				boolean flag = userService.FileInsert(f);
    				String url = "";
    				if(flag){
    					session.setAttribute("message", "上传成功！！！");
    					while ((length = in.read(buf)) != -1) {  
                            // 在 buf 数组中 取出数据 写到 （输出流）磁盘上  
                            out.write(buf, 0, length);
    					url = "Employee/message.jsp";
    					}
    				}else{
    					session.setAttribute("message", "上传失败！！！");
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
	 * 退出
	 */
	private void LoginOut(HttpServletRequest request,
			HttpServletResponse response) {
		//获取session
		HttpSession session =request.getSession(false);
		
		if(session!=null)
		{
			session.invalidate();
			//报错：(请求的session已注销)java.lang.IllegalStateException: getAttribute: Session already invalidated
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
	 * 删除
	 * @throws UnsupportedEncodingException 
	 */
	private void UserEntityDelete(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取输入的数据
		String userId = request.getParameter("userId");
		//调用service层获取用户信息
		UserDaoImpl udi=new UserDaoImpl();
		UserService userService = new UserServiceImpl();
		UserEntity u = udi.findByuId(userId);
		//删除
		boolean flag = userService.userEntityDelete(u);
		// 获取session
		HttpSession session=request.getSession();
		String url = "";
		if(flag){
			session.setAttribute("message", "删除成功！！！");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "删除失败！！！");
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
	 * 修改
	 * @throws UnsupportedEncodingException 
	 */
	private void UserEntityUpdate(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		// 获取session
		HttpSession session=request.getSession();
		//从session中获取当前用户对象
		UserEntity user = (UserEntity)session.getAttribute("userEntity");
		//System.out.println(user);
		String userid=user.getUserid();
		String username=user.getUsername();
		String usergender=user.getUsergender();
		String userbirthday=user.getUserbirthday();
		String userdept=user.getUserdept();
		
		//获取数据
		//String uName = request.getParameter("uName");
		String userpassword = request.getParameter("userpassword");
		//String uGender = request.getParameter("uGender");
		String useremail = request.getParameter("useremail");
		String userphone = request.getParameter("userphone");
		//String uBirthday = request.getParameter("uBirthday");
		String useraddress = request.getParameter("useraddress");
		
		
		//封装数据
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
		
		//调用service层
		UserService userService = new UserServiceImpl();
		boolean flag = userService.userEntityUpdate(u);
		String url = "";
		if(flag){
			session.setAttribute("message", "修改成功！！！");
			url = "Employee/message.jsp";
		}else{
			session.setAttribute("message", "修改失败！！！");
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
	 * 查询单个（精确）
	 * @throws UnsupportedEncodingException 
	 */
	private void FindByuName(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取session
		HttpSession session=request.getSession();
		//从session中获取当前用户对象
		UserEntity user = (UserEntity)session.getAttribute("userEntity");
		System.out.println(user);
		String username = user.getUsername();
		System.out.println(username);
		UserService userService = new UserServiceImpl();
		UserEntity u = userService.findByuName(username);
		System.out.println(u);
		if(u == null){
			//System.out.println("用户不存在！！！");
			session.setAttribute("message", "您查询的员工不存在！！！");
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
	 * 查询所有
	 */
	private void FindAllUserEntity(HttpServletRequest request,
			HttpServletResponse response) {
		//对输出数据进行编码处理
		response.setCharacterEncoding("utf-8");
		
		//调用service层
		UserService userService = new UserServiceImpl();
		List<UserEntity> list = userService.findAllUserEntity();
		//System.out.println(list);
		
		HttpSession session = request.getSession();
		if(list == null){
			session.setAttribute("message", "数据库中没有查询到员工信息！！！");
			try {
				request.getRequestDispatcher("Employee/message.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//保存信息到session
			session.setAttribute("userlist", list);
			try {
				request.getRequestDispatcher("Employee/user/findAll.jsp").forward(request, response);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}

		
	}

		//用户编号与密码相匹配验证
		private void LoginphoneAndpwd(HttpServletRequest request,HttpServletResponse response) {
			//获取页面的参数
			String userid=request.getParameter("userid");
			String userpassword=request.getParameter("userpassword");
			response.setContentType("text/html;charset=utf-8");
			//封装数据
			UserEntity u=new UserEntity();
			u.setUserid(userid);
			u.setUserpassword(userpassword);
			//调用服务层方法
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
		//用户编号验证操作
		private void Loginphone(HttpServletRequest request, HttpServletResponse response) {
			//获取页面的参数
			String userid=request.getParameter("userid");
			response.setContentType("text/html;charset=utf-8");
			//封装数据
			UserEntity u=new UserEntity();
			u.setUserid(userid);
			//调用服务层方法
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
		
		//用户登录方法。
		private void UserLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
			//获取页面的参数
			String userid=request.getParameter("userid");
			String userpassword=request.getParameter("userpassword");
			response.setContentType("text/html;charset=utf-8");
			//封装数据
			UserEntity u=new UserEntity();
			u.setUserid(userid);
			u.setUserpassword(userpassword);
			//System.out.println(u);
			//调用服务层方法
			UserService userService=new UserServiceImpl();
			UserEntity ui=userService.UserLogin(u,1);
			HttpSession session=request.getSession();
			String url="";
			//判断是否登录成功
			if(ui==null){
				//返回登录页
				url="Admin/login.jsp";
			}else{
				//保存个人信息并放入session域
				session.setAttribute("userEntity", ui);
				
				//获取用户信息
				String username = ui.getUsername();
				//调用服务层方法获取头像信息
				FileEntity f = userService.findFile(username);
				//System.out.println(f);
				
				if(f != null){
					session.setAttribute("fileEntity", f);
					url="Employee/admin.jsp";
				}else{
					url="Employee/admin.jsp";
				}
				
			}
			//进行页面跳转
			try {
				response.sendRedirect(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	/**
	 * 注册
	 * @throws UnsupportedEncodingException 
	 *  
	 */
	private void UserRegist(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//获取数据
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		String usergender = request.getParameter("usergender");
		String useremail = request.getParameter("useremail");
		String userphone = request.getParameter("userphone");
		String userbirthday = request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("date");
		String useraddress = request.getParameter("useraddress");
		String userdept = request.getParameter("userdept");

		
		//封装数据
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
		
		//设置请假次数默认值
		int lnNum = 5;
		//封装数据
		LeaveNum ln = new LeaveNum();
		ln.setUsername(username);
		ln.setLnNum(lnNum);
		
		//调用service层
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
