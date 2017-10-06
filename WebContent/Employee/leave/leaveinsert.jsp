<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form accept-charset="UTF-8" action="<%=request.getContextPath()%>/leaveServlet?type=leaveinsert" method="post">
<div>
	<h1 align="center">请假申请</h1>
	<table border="0px" width="1000px" height="20px" align="center">
		<tr>
			<th>请假理由：</th>
			<td><input type="text" id="lReason" name="lReason"  placeholder="请输入理由" /></td>
		</tr>
		<tr>
			<th>请假开始时间：</th>
			<td><input type="text" id="lStarttime" name="lStarttime" placeholder="请输入开始时间" /></td>
		</tr>
		<tr>
			<th>请假天数：</th>
			<td><input type="text" id="lDays" name="lDays" placeholder="请输入天数" /></td>
		</tr>
	</table>
</div><br>
	<div align="center"><input type="image" src="../image/ok-32.png" width="50px" height="30px">&nbsp;&nbsp;<input type="image" src="../image/cancel.png" onclick="reset()" width="70px" height="30px"></div>
</form>
</body>
</html>