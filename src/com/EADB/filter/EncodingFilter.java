package com.EADB.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *����ʱ�䣺2017��9��14������10:08:20
 *��Ŀ���ƣ�20170912_shoppingCart
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:EncodingFilter.java
 *��˵���������������
 */

public class EncodingFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		//�������ﴦ������
		//post�����Ĵ���ʽ
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//get�����Ĵ���ʽ
		//��ҳ�洫�������ݽ��������ݴ���
		HttpServletRequest proxyRequst=
				(HttpServletRequest)Proxy.newProxyInstance(request.getClass().getClassLoader()	//ָ����ǰʹ�õ��������
					, new Class[]{HttpServletRequest.class}, //��Ŀ�����ʵ�ֵĽӿ�����
					new InvocationHandler()   //�¼�������
					{
						@Override
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
							//��ȡ������
							String methodName =method.getName();
							//����һ������ֵ
							Object returnValue=null;
							//getParameter
							if("getParameter".equals(methodName))
							{
								//�����
								String value = request.getParameter(args[0].toString());
								//��ǰ�ύ�ķ�ʽ
								String methodSubmit= request.getMethod();
								if("GET".equals(methodSubmit))
								{
									//�������ĵ�����
									if(value!=null&& !"".equals(value))
									{
										//��������
										value = new String(value.getBytes("ISO8859-1"),"utf-8");
									}
								}
								return value;
							}else
							{
								//�����ķ������ǲ���������ִ��
								returnValue=method.invoke(request, args);
							}
							return returnValue;
						}
					});
			//�����������洦��Ĵ������
			chain.doFilter(proxyRequst, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
}
