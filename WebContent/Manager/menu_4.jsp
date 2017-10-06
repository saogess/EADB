<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>菜单栏4</title>
</head>
<body>
		<div class="middle_left_menu">
			<ul>
				<li><a href="<%=request.getContextPath()%>/leaveServlet?type=leavequeryall" target="right"><div class="mennuInf">
					查看所有请假信息&nbsp;&nbsp;&nbsp;&nbsp;>
				</div></a></li>
				<li><a href="<%=request.getContextPath()%>/leaveServlet?type=queryByAudittype" target="right"><div class="mennuInf">
					查看所有销假信息&nbsp;&nbsp;&nbsp;&nbsp;>
				</div></a></li>
			</ul>
		</div>
</body>
</html>