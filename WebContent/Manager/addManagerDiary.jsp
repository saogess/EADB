<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经理日志</title>
</head>
<body>
		<form action="<%=request.getContextPath()%>/managerDiaryServlet?type=add" method="post">
				<p>日志标题：(不超过20个字)</p>
				<input type="text" name="title" id="title" placeholder="请输入您的日志标题" maxlength="20" />
		<hr />
				<p>日志内容：(不超过1000个字)</p>
				<textarea name="managerDiary" id="managerDiary" cols="100" rows="15" maxlength="1000" placeholder="请编辑您的日志"></textarea>
		<hr />
				<input type="submit" value="保存" />
		</form>
</body>
</html>