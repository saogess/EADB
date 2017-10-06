<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/loginServlet?type=userupload" method="post" enctype="multipart/form-data">
	<h1>上传头像</h1>
	个人照片：<input name="pic" type="file"><br>
	<div align="center"><input type="image" src="../image/ok-32.png" width="50px" height="30px">&nbsp;&nbsp;<input type="image" src="../image/cancel.png" onclick="reset()" width="70px" height="30px"></div>
</form>
</body>
</html>