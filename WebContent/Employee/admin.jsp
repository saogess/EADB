<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工主页</title>
</head>
<body>
	
		<div class="top">
			<div class="top_Logo">
				<img src="<%=request.getContextPath()%>/Employee/image/logo.png" />
			</div>
			<div class="top_function">
				<a href="menu_1.jsp" target="menu" style="font-size: 16px;">个人信息</a>
			</div>
			<div class="top_function">
				<a href="menu_2.jsp" target="menu" style="font-size: 16px;">请假</a>
			</div>
			<div class="top_function">
				<a href="menu_3.jsp" target="menu" style="font-size: 16px;">考勤</a>
			</div>
			<div class="top_function">
				<a href="menu_4.jsp" target="menu" style="font-size: 16px;">日志</a>
			</div>
			<div class="top_function">
				<a href="menu_5.jsp" target="menu" style="font-size: 16px;">其他</a>
			</div> 
			
			<div class="top_Inf">
					<img style="float:left; margin: 5px;" src="<%=request.getContextPath()%>/${sessionScope.fileEntity.userpic }" width="40px" height="40px" style="border-radius:50px"/>
					<li style="float: left; margin-left: 10px; font-family: '宋体'; font-weight: 700;font-size: large;">欢迎您：${sessionScope.userEntity.username}</li>
					<li style="float: left; margin-left: 10px; font-family: '宋体'; font-weight: 700;font-size: large;">${sessionScope.userEntity.userid}</li>
					<li style="float: left; margin-left: 10px; font-family: '宋体'; font-weight: 700;font-size: large;"><a href="user/upload.jsp" target="right">上传头像</a></li>
					<a href="<%=request.getContextPath() %>/loginServlet?type=loginout" style="float: right; margin-right: 10px; font-family: '宋体'; font-weight: 700;font-size: large;">退出</a>
			</div>
		</div>
		<div class="middle">
			<div class="middle_left">
				<iframe class="middle_left_menu" name="menu" src="menu_1.jsp"></iframe>
			</div>
			<iframe class="middle_right" name="right" scrolling="auto"></iframe>
			
		</div>
	
</body>
</html>