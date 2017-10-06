<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看全部员工考勤信息</title>
</head>
<body>
    	<table class="table" width="1000px" height="100px" align="center">
    		<tr>
    			<th>工作ID</th>
    			<th>姓名</th>
    			<th>考勤时间</th>
    			<th>考勤状态</th>
    			<th>考勤信息</th>
    		</tr>
    		<c:forEach items="${AttendanceInf}" var="a">
    		<tr>
    			<td>${a.userid}</td>
    			<td>${a.username}</td>
    			<td>${a.time}</td>
    			<td>${a.atype}</td>
    			<td>${a.inf}</td>
    		</tr>
    		</c:forEach>
    	</table>
    	
 	</body>
</html>