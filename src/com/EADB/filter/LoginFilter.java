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
 *����ʱ�䣺2017��9��28������10:42:33
 *��Ŀ���ƣ�2017_EADB_Project_Web_update
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:LoginFilter.java
 *��˵������¼������
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
		//���Ƚ������е�ServletRequest��ServletResponseǿתΪHttp...  
        HttpServletRequest hreq= (HttpServletRequest) request;  
        HttpServletResponse hresp= (HttpServletResponse) response;  
  
        //��ȡ�����е�·��
        String uriStr =hreq.getRequestURI();
       // System.out.println(uriStr);
        //��ȡsession����  
        HttpSession hsess=hreq.getSession();  
        //��ȡsession������flag��ֵ��ǿתΪString����  
        UserEntity u =  (UserEntity) hsess.getAttribute("userEntity");
        
        //System.out.println(u);
  
        //����û���¼������ҳ������ִ�е�¼������ִ��ע������Ļ�  
        // ������ֱ��ת������һ��������д���  
        //�������������򶼽���Ȩ��У��
        
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
		//���й��˴���
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri = request.getRequestURI();
		if(canIgnore(request)){
			chain.doFilter(request, response);
			return ;
		}else{
			//��������,�ж�session�Ƿ����
			HttpSession session = request.getSession(false);
			if(session!=null){
				//�Ѿ���¼��
				Object info1 = session.getAttribute("admin");
				Object info2 = session.getAttribute("userEntity");
				Object info3 = session.getAttribute("mInf");
				if(info1!=null||info2!=null||info3!=null){
					//����
					chain.doFilter(request, response);
					return;
				}else{
					//�����ȡ���û���Ϊ�գ�˵��û�е�¼��������session����
					uri = "/Admin/login.jsp";
				}
			}else{
				//�϶�û�е�¼ 
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
