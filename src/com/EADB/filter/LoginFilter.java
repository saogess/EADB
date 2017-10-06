package com.EADB.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EADB.model.UserEntity;


/**
 *创建时间：2017年9月28日上午10:42:33
 *项目名称：2017_EADB_Project_Web_update
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:LoginFilter.java
 *类说明：登录拦截器
 */

public class LoginFilter implements Filter{

	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//首先将参数中的ServletRequest和ServletResponse强转为Http...  
        HttpServletRequest hreq= (HttpServletRequest) request;  
        HttpServletResponse hresp= (HttpServletResponse) response;  
  
        //获取请求中的路径
        String uriStr =hreq.getRequestURI();
       // System.out.println(uriStr);
        //获取session对象  
        HttpSession hsess=hreq.getSession();  
        //获取session对象中flag的值，强转为String类型  
        UserEntity u =  (UserEntity) hsess.getAttribute("userEntity");
        
        //System.out.println(u);
  
        //如果用户登录的是首页或者是执行登录或者是执行注册操作的话  
        // 将请求直接转发给下一个组件进行处理  
        //对于其他请求则都进行权限校验
        
        if(uriStr.indexOf("login.jsp") != -1 || uriStr.indexOf("index.jsp") != -1 || uriStr.indexOf("regist.jsp") != -1){
        	//System.out.println("1");
        	chain.doFilter(request, response);
        }else{
        	if(u != null){
        		//System.out.println("2");
        		chain.doFilter(request, response);
        	}else{
        		//System.out.println("3");
        		hresp.sendRedirect("/2017_EADB_Project_Web/Admin/login.jsp");
        	}
        }
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}
	
	
	
	/*private Set<String> prefixIignores = new HashSet<String>();
	@Override
	public void destroy() {
		prefixIignores=null;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException {
		//进行过滤处理
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri = request.getRequestURI();
		if(canIgnore(request)){
			chain.doFilter(request, response);
			return ;
		}else{
			//进行拦截,判断session是否存在
			HttpSession session = request.getSession(false);
			if(session!=null){
				//已经登录了
				Object info1 = session.getAttribute("admin");
				Object info2 = session.getAttribute("userEntity");
				Object info3 = session.getAttribute("mInf");
				if(info1!=null||info2!=null||info3!=null){
					//放行
					chain.doFilter(request, response);
					return;
				}else{
					//如果获取的用户名为空，说明没有登录，或者是session过期
					uri = "/Admin/login.jsp";
				}
			}else{
				//肯定没有登录 
				uri = "/Admin/login.jsp";
			}
			request.getRequestDispatcher(uri).forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String cp = ((HttpServletRequest) config.getServletContext()).getContextPath();
		String ignoresParam = config.getInitParameter("ignores");
		String[] ignoreArray = ignoresParam.split(",");
		for (String s : ignoreArray){
			prefixIignores.add(cp + s);
		}
	}

	private boolean canIgnore(HttpServletRequest request) {
		String url = request.getRequestURI();
		for (String ignore : prefixIignores) {
			if (url.startsWith(ignore)){
				return true;
			}
		}
		return false;
	}*/
}
