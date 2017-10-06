<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>菜单栏1</title>
</head>
<body>
		<div class="middle_left_menu">
			<ul>
				<li><a href="showManagerInf.jsp" target="right"><div class="mennuInf">
					查看个人信息&nbsp;&nbsp;&nbsp;&nbsp;>
				</div></a></li>
				<li><a href="updateManagerInf.jsp" target="right"><div class="mennuInf">
					修改个人信息&nbsp;&nbsp;&nbsp;&nbsp;>
				</div></a></li>
				<li><a href="<%=request.getContextPath()%>/managerLoginServlet?type=showAll" target="right"><div class="mennuInf">
					查看全部经理信息&nbsp;&nbsp;&nbsp;&nbsp;>
				</div></a></li>
				<li><a href="addManagerInf.jsp" target="right"><div class="mennuInf">
					增添经理信息&nbsp;&nbsp;&nbsp;&nbsp;>
				</div></a></li>
				
				<li><a href="online.jsp" target="right"><div class="mennuInf">
					查看在线人数信息&nbsp;&nbsp;&nbsp;&nbsp;>
				</div></a></li>
			</ul>
		</div>
</body>
</html>