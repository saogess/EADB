<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示全部日志信息</title>
</head>
<body>
    	<table class="table" width="1000px" height="100px" align="center">
    		<tr>
    			<th>工作ID</th>
    			<th>姓名</th>
    			<th>日志时间</th>
    			<th>修改时间</th>
    			<th>标题</th>
    		</tr>
    		<c:forEach items="${managerDiarise}" var="md">
    		<tr>
    			<td>${md.mid}</td>
    			<td>${md.managername}</td>
    			<td>${md.dStarttime}</td>
    			<td>${md.dModifytime}</td>
    			<td><a href="<%=request.getContextPath()%>/managerDiaryServlet?type=showOne&mid=${md.dId}">${md.dTitle}</a></td>
    		</tr>
    		</c:forEach>
    	</table>
</body>
</html>