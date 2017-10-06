package com.EADB.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.EADB.model.FileInf;
import com.EADB.model.Manager;
import com.EADB.service.FileService;
import com.EADB.service.imp.FileServiceImp;

/**
 *创建时间：2017年9月26日上午9:01:16
 *项目名称：2017_EADB_Project_Web
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:Up_DownFileServlet.java
 *类说明：文件的上传与下载servlet
 */

@WebServlet("/FileInfServlet")
public class Up_DownFileServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3046642759948512067L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String type=request.getParameter("type");
		//上传文件
		if("upload".equals(type)){
			uploadFileInf(request,response);
		}
		//查看文件（全部）
		if("findAll".equals(type)){
			findAllFileInf(request,response);
		}
		//下载文件
		if("downLoad".equals(type)){
			downLoadFileInf(request,response);
		}
	}
	
	//下载文件
	private void downLoadFileInf(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException {
		//获取参数
		int fId=Integer.parseInt(request.getParameter("fId")); 	//下载文件的Id
		//获取下载文件对象
		FileService fs=new FileServiceImp();
		FileInf f=fs.findByFnumService(fId);
		
		//原始文件名
		try {
			String fName=f.getfName();
			System.out.println(fName);
			fName=URLEncoder.encode(fName, "utf-8");
			
			//下载文件的路径
			String path = this.getServletContext().getRealPath("/file");
			//设置下载文件的方式(设置为下载)
			response.setContentType("application/x-download");
			response.setHeader("content-disposition", "attachment;fileName="+fName);
			//获取下载文件的流对象
			InputStream inputStream = new FileInputStream(new File(path,f.getfPath()));
			OutputStream outputStream;
			outputStream = response.getOutputStream();
			byte[] buf = new byte[1024];
			int lenght = 0;
			while ((lenght = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, lenght);
			}
			outputStream.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//查看文件（全部）
	private void findAllFileInf(HttpServletRequest request,HttpServletResponse response) {
		//调用服务层获取数据
		FileService fs=new FileServiceImp();
		List<FileInf> list=fs.findAllFileService();
		System.out.println(list);
		request.setAttribute("fileInfList", list);
		try {
			request.getRequestDispatcher("Manager/showFileInf.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	//上传文件
	@SuppressWarnings("static-access")
	private void uploadFileInf(HttpServletRequest request,HttpServletResponse response) {
		//获取页面的数据
		HttpSession session=request.getSession();
		Manager m=(Manager)session.getAttribute("mInf");
		int maId=m.getId();
		//获取时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fTime = sdf.format(date);
		String fNum="";
		String fName="";
		String fPath="";
		try {
			//创建文件工厂
			FileItemFactory fatory = new DiskFileItemFactory();
			//判断你当前页面提交表单中的数据类型
			ServletFileUpload upload = new ServletFileUpload(fatory);
			//判断
			if(upload.isMultipartContent(request)){
				//把请求的数据放在集合中
				@SuppressWarnings("unchecked")
				List<FileItem> list=upload.parseRequest(request);
				//遍历
				for(FileItem item : list){
					//普通文本
					if(item.isFormField()){
						//获取文本的值
						String name = item.getFieldName();
						if("fNum".equals(name)){
								fNum=new String(item.getString().getBytes("iso-8859-1"),"utf-8");
						}
						if("fName".equals(name)){
							fName=new String(item.getString().getBytes("iso-8859-1"),"utf-8");
						}
					}else{
						//获取上传文件的名称
						String name=item.getName();
						//处理文件名不重复问题
						String id=UUID.randomUUID().toString();
						//拼接起来
						name=id+name.substring(name.lastIndexOf('.'),name.length());
						//得到上传文件的真实路径
						String path=this.getServletContext().getRealPath("/file");
						//创建要上传的文件对象
						File test=new File(path);
						if(test.exists()&&test.isDirectory()){
							File file = new File(path,name);
							fPath=name;
							//上传
							item.write(file);
							item.delete();   //删除组件运行时产生的临时文件
						}else{
							test.mkdir();
							File file = new File(path,name);
							fPath=name;
							//上传
							item.write(file);
							item.delete();   //删除组件运行时产生的临时文件
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//封装数据
		FileInf f=new FileInf();
		f.setfNum(fNum);
		f.setfName(fName);
		f.setfPath(fPath);
		f.setfTime(fTime);
		f.setMaId(maId);
		//调用服务层进行信息保存
		FileService fs=new FileServiceImp();
		boolean flag=fs.insertFileService(f);
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
