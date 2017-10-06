<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线经理人数</title>
</head>
<body>
	<table class="table" width="1000px" height="100px" align="center">
		<tr>
			<td>当前在线经理列表如下：</td>
		</tr>
		<tr>
			<td>经理ID</td>
			<td>姓名</td>
			<td>性别</td>
			<td>手机号</td>
			<td>邮箱</td>
			<td>职位</td>
		</tr>
		<c:if test="${not empty applicationScope.managerOnlineList }">
			<c:forEach items="${applicationScope.managerOnlineList }" var="u">
				<tr>
					<td>${u.mid}</td>
					<td>${u.managername}</td>
					<td>${u.gender}</td>
					<td>${u.phonenumber}</td>
					<td>${u.mail}</td>
					<td>${u.position}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>