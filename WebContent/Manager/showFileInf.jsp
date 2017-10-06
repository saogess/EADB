<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示全部文件信息</title>
</head>
<body>
    	<table class="table" width="1000px" height="100px" align="center">
    		<tr>
    			<th>文件编号</th>
    			<th>文件名</th>
    			<th>上传时间</th>
    			<th>上传人</th>
    			<th>职位</th>
    		</tr>
    		<c:forEach items="${fileInfList}" var="fil">
    		<tr>
    			<td>${fil.fNum}</td>
    			<td><a href="<%=request.getContextPath()%>/FileInfServlet?type=downLoad&fId=${fil.fId}">${fil.fName}</a></td>
    			<td>${fil.fTime}</td>
    			<td>${fil.managername}</td>
    			<td>${fil.position}</td>
    		</tr>
    		</c:forEach>
    	</table>
</body>
</html>