<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>菜单栏5</title>
</head>
<body>
		<div class="middle_left_menu">
			<ul>
				<li><a href="<%=request.getContextPath() %>/loginServlet?type=findAllUserEntity" target="right"><div class="mennuInf">
					查看所有员工信息&nbsp;&nbsp;&nbsp;&nbsp;>
				</div></a></li>
				<li><a href="<%=request.getContextPath()%>/Employee/user/regist.jsp" target="right"><div class="mennuInf">
					增加员工信息&nbsp;&nbsp;&nbsp;&nbsp;>
				</div></a></li>
				<li><a href="deleteUserInf.jsp" target="right"><div class="mennuInf">
					删除员工信息&nbsp;&nbsp;&nbsp;&nbsp;>
				</div></a></li>
			</ul>
		</div>
</body>
</html>