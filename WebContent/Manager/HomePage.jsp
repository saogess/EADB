<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户主页</title>
</head>
<body>
		<div class="top">
			<div class="top_Logo">
				<img src="<%=request.getContextPath()%>/Manager/img/logo.png" />
			</div>
			<div class="top_function">
				<a href="Manager/menu_1.jsp" target="menu" style="font-size: 16px;">个人信息管理</a>
			</div>
			<div class="top_function">
				<a href="Manager/menu_2.jsp" target="menu" style="font-size: 16px;">考勤信息管理</a>
			</div>
			<div class="top_function">
				<a href="Manager/menu_3.jsp" target="menu" style="font-size: 16px;">日志管理</a>
			</div>
			<div class="top_function">
				<a href="Manager/menu_4.jsp" target="menu" style="font-size: 16px;">职员请假管理</a>
			</div>
			<div class="top_function">
				<a href="Manager/menu_5.jsp" target="menu" style="font-size: 16px;">职员信息管理</a>
			</div>
			
			<div class="top_Inf">
					<img style="float:left; margin: 5px;" src="<%=request.getContextPath()%>/Manager/${sessionScope.mInf.pictureurl}" />
					<li style="float: left; margin-left: 10px; font-family: '宋体'; font-weight: 700;font-size: large;">欢迎${sessionScope.mInf.managername}使用！</li>
					<li style="float: left; margin-left: 10px; font-family: '宋体'; font-weight: 700;font-size: large;">${sessionScope.mInf.address}</li>
					<li style="float: left; margin-left: 10px; font-family: '宋体'; font-weight: 700;font-size: large;">${sessionScope.mInf.phonenumber}</li>
					<a href="<%=request.getContextPath()%>/managerLoginServlet?type=out" style="float: right; margin-right: 10px; font-family: '宋体'; font-weight: 700;font-size: large;">退出</a>
			</div>
		</div>
		<div class="middle">
			<div class="middle_left">
				<!--<div class="middle_left_top">
					<img src="img/menu_1.png" width="35px" height="30px"/>
					<p>功能菜单</p>
				</div>-->
				<iframe class="middle_left_menu" name="menu" src="Manager/menu_1.jsp">
				</iframe>
			</div>
			<iframe class="middle_right" name="right" scrolling="auto"></iframe>
			
		</div>
	</body>
</html>