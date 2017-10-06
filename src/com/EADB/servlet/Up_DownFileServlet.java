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
 *����ʱ�䣺2017��9��26������9:01:16
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:Up_DownFileServlet.java
 *��˵�����ļ����ϴ�������servlet
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
		//�ϴ��ļ�
		if("upload".equals(type)){
			uploadFileInf(request,response);
		}
		//�鿴�ļ���ȫ����
		if("findAll".equals(type)){
			findAllFileInf(request,response);
		}
		//�����ļ�
		if("downLoad".equals(type)){
			downLoadFileInf(request,response);
		}
	}
	
	//�����ļ�
	private void downLoadFileInf(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException {
		//��ȡ����
		int fId=Integer.parseInt(request.getParameter("fId")); 	//�����ļ���Id
		//��ȡ�����ļ�����
		FileService fs=new FileServiceImp();
		FileInf f=fs.findByFnumService(fId);
		
		//ԭʼ�ļ���
		try {
			String fName=f.getfName();
			System.out.println(fName);
			fName=URLEncoder.encode(fName, "utf-8");
			
			//�����ļ���·��
			String path = this.getServletContext().getRealPath("/file");
			//���������ļ��ķ�ʽ(����Ϊ����)
			response.setContentType("application/x-download");
			response.setHeader("content-disposition", "attachment;fileName="+fName);
			//��ȡ�����ļ���������
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

	//�鿴�ļ���ȫ����
	private void findAllFileInf(HttpServletRequest request,HttpServletResponse response) {
		//���÷�����ȡ����
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

	//�ϴ��ļ�
	@SuppressWarnings("static-access")
	private void uploadFileInf(HttpServletRequest request,HttpServletResponse response) {
		//��ȡҳ�������
		HttpSession session=request.getSession();
		Manager m=(Manager)session.getAttribute("mInf");
		int maId=m.getId();
		//��ȡʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fTime = sdf.format(date);
		String fNum="";
		String fName="";
		String fPath="";
		try {
			//�����ļ�����
			FileItemFactory fatory = new DiskFileItemFactory();
			//�ж��㵱ǰҳ���ύ���е���������
			ServletFileUpload upload = new ServletFileUpload(fatory);
			//�ж�
			if(upload.isMultipartContent(request)){
				//����������ݷ��ڼ�����
				@SuppressWarnings("unchecked")
				List<FileItem> list=upload.parseRequest(request);
				//����
				for(FileItem item : list){
					//��ͨ�ı�
					if(item.isFormField()){
						//��ȡ�ı���ֵ
						String name = item.getFieldName();
						if("fNum".equals(name)){
								fNum=new String(item.getString().getBytes("iso-8859-1"),"utf-8");
						}
						if("fName".equals(name)){
							fName=new String(item.getString().getBytes("iso-8859-1"),"utf-8");
						}
					}else{
						//��ȡ�ϴ��ļ�������
						String name=item.getName();
						//�����ļ������ظ�����
						String id=UUID.randomUUID().toString();
						//ƴ������
						name=id+name.substring(name.lastIndexOf('.'),name.length());
						//�õ��ϴ��ļ�����ʵ·��
						String path=this.getServletContext().getRealPath("/file");
						//����Ҫ�ϴ����ļ�����
						File test=new File(path);
						if(test.exists()&&test.isDirectory()){
							File file = new File(path,name);
							fPath=name;
							//�ϴ�
							item.write(file);
							item.delete();   //ɾ���������ʱ��������ʱ�ļ�
						}else{
							test.mkdir();
							File file = new File(path,name);
							fPath=name;
							//�ϴ�
							item.write(file);
							item.delete();   //ɾ���������ʱ��������ʱ�ļ�
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//��װ����
		FileInf f=new FileInf();
		f.setfNum(fNum);
		f.setfName(fName);
		f.setfPath(fPath);
		f.setfTime(fTime);
		f.setMaId(maId);
		//���÷���������Ϣ����
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
