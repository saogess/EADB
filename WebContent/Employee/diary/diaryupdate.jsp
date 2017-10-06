<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form accept-charset="UTF-8" action="<%=request.getContextPath()%>/diaryServlet?type=diaryupdate" method="post">
<div>
	<h1 align="center">每日总结修改</h1>
	<h2>请输入要修改的日记编号：<input type="text" id="dId" name="dId"  placeholder="请输入日记编号"/></h2>
	<table border="0px" width="2000px" height="20px" align="center">
		<tr>
			<th>标题</th>
			<td><input type="text" id="dTitle" name="dTitle"  placeholder="请输入标题" /></td>
		</tr>
		<tr>
			<th>内容</th>
			<td><textarea name="dContent" style="margin:0px;width:300px;height:100px;"></textarea></td>
		</tr>
	</table>
</div><br>
	<div align="center"><input type="image" src="../image/ok-32.png" width="50px" height="30px">&nbsp;&nbsp;<input type="image" src="../image/cancel.png" onclick="reset()" width="70px" height="30px"></div>
</form>
</body>
</html>