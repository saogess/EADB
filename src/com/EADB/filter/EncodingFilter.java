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
 *创建时间：2017年9月14日上午10:08:20
 *项目名称：20170912_shoppingCart
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:EncodingFilter.java
 *类说明：编码过滤器。
 */

public class EncodingFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		//放在这里处理中文
		//post方法的处理方式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//get方法的处理方式
		//把页面传来的数据进行脏数据处理
		HttpServletRequest proxyRequst=
				(HttpServletRequest)Proxy.newProxyInstance(request.getClass().getClassLoader()	//指定当前使用的类加载器
					, new Class[]{HttpServletRequest.class}, //对目标对象实现的接口类型
					new InvocationHandler()   //事件处理器
					{
						@Override
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
							//获取方法名
							String methodName =method.getName();
							//定义一个返回值
							Object returnValue=null;
							//getParameter
							if("getParameter".equals(methodName))
							{
								//获参数
								String value = request.getParameter(args[0].toString());
								//当前提交的方式
								String methodSubmit= request.getMethod();
								if("GET".equals(methodSubmit))
								{
									//处理中文的乱码
									if(value!=null&& !"".equals(value))
									{
										//处理乱码
										value = new String(value.getBytes("ISO8859-1"),"utf-8");
									}
								}
								return value;
							}else
							{
								//其它的方法我们不处理，继续执行
								returnValue=method.invoke(request, args);
							}
							return returnValue;
						}
					});
			//传入我们上面处理的代理对象
			chain.doFilter(proxyRequst, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
}
