<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>请假</title>
</head>
<body>
		<div class="middle_left_menu">
			<ul>
				<li><a href="leave/leaveinsert.jsp" target="right"><div class="mennuInf">
					申请请假&nbsp;&nbsp;&nbsp;&nbsp;
				</div></a></li>
				<li><a href="<%=request.getContextPath()%>/leaveServlet?type=leavequery" target="right"><div class="mennuInf">
					个人请假信息查询&nbsp;&nbsp;&nbsp;&nbsp;
				</div></a></li>
				<li><a href="leave/leavecancel.jsp" target="right"><div class="mennuInf">
					申请销假&nbsp;&nbsp;&nbsp;&nbsp;
				</div></a></li>
				
			</ul>
		</div>
</body>
</html>