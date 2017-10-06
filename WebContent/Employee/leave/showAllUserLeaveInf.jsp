<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示全部请假信息</title>
<base href="http://localhost:8080/2017_EADB_Project_Web/Employee/">
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
    	<table class="table" width="1000px" height="100px" align="center">
    		<tr>
				<th>用户编号</th>
				<th>用户姓名</th>
				<th>请假开始时间</th>
				<th>请假天数</th>
				<th>操作</th>
    		</tr>
    		<c:forEach items="${leavelist}" var="leave">
    		<tr>
				<td>${leave.userid}</td>
				<td>${leave.username}</td>
				<td>${leave.lStarttime}</td>
				<td>${leave.lDays}</td>
    			<td><a href="<%=request.getContextPath() %>/leaveServlet?type=leavequerybyid&lId=${leave.lId }">审核</a></td>
    		</tr>
    		</c:forEach>
    	</table>
</body>
</html>