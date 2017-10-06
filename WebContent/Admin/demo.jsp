<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员信息查询</title>
</head>
<style>
    body{
        background-color: #FFFFFF;
    }
</style>
<body>

<div style="height: 500px">
	<form method="post" action="demo.jsp" > 
		<div style="height: 80px"></div>
	        <div class="lanren"><h1 style="font-family: 'Adobe 仿宋 Std R';border: 1px solid #c0c0c0;text-align: center">备忘录</h1></div>​
	        <h3 class="text-muted" style="text-align: center">请在此输入信息</h3><br/>
	        
	        <div style="text-align: center">
	            <div style="font-size:16px;font-weight:normal;transition: color 0.5s ease-out;text-decoration: none;color: #a1a1a1;">
	            	<% 

					try{
					
					request.setCharacterEncoding("UTF-8"); 
					
					String mywords=request.getParameter("message");
					
					String t="";
					
					if(application.getAttribute("words")==null && mywords!=null){
					
					t=  mywords + "<br/>";
					
					application.setAttribute("words",(Object)t);
					
					out.println(t);
					
					}
					
					else if(mywords!=null){
					
					t=(String)application.getAttribute("words");
					
					t +=  mywords + "<br/>";
					
					application.setAttribute("words",(Object)t);
					
					out.println(t);
					
					}
					
					}
					
					catch(Exception e){
					
					}
					
					%>
	            </div>
				<input class="search_fence_text" type="text" name="message"  style="margin: auto;margin-bottom: 20px;padding-left: 50px" ><br/>

				<input class="btn btn-s-ft btn-danger" type="submit" value="提交">
				<input class="btn btn-s-ft btn-default" type="submit" value="查询">
			</div>
	</form> 
</div>
</body>
</html>