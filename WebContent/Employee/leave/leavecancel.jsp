<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form accept-charset="UTF-8" action="<%=request.getContextPath()%>/leaveServlet?type=leavecancel" method="post">
<div>
	<h1 align="center">销假请求</h1>
	请输入要销假的信息编号：<input type="text" id="lId" name="lId"  placeholder="请输入编号"/>
</div><br>
	<div align="center"><input type="image" src="../image/ok-32.png" width="50px" height="30px">&nbsp;&nbsp;<input type="image" src="../image/cancel.png" onclick="reset()" width="70px" height="30px"></div>
</form>
</body>
</html>