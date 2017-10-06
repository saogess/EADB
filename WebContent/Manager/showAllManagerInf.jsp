<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示全部经理的信息</title>
</head>
<body>
    	<table class="table" width="1000px" height="100px" align="center">
    		<tr>
    			<th  align="center">工作ID</th>
    			<th  align="center">姓名</th>
    			<th  align="center">职位</th>
    			<th  align="center">性别</th>
    			<th  align="center">生日</th>
    			<th  align="center">联系方式</th>
    			<th  align="center">家庭住址</th>
    			<th  align="center">邮箱</th>
    		</tr>
    		<c:forEach items="${managersInf}" var="m">
    		<tr>
    			<td>${m.mid}</td>
    			<td align="center">${m.managername}</td>
    			<td>${m.position}</td>
    			<td align="center">${m.gender}</td>
    			<td>${m.birthday}</td>
    			<td>${m.phonenumber}</td>
    			<td>${m.address}</td>
    			<td>${m.mail}</td>
    		</tr>
    		</c:forEach>
    	</table>
    	
 	</body>
</html>