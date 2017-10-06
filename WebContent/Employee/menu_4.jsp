<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>日志</title>
</head>
<body>
		<div class="middle_left_menu">
			<ul>
				<li><a href="diary/diaryinsert.jsp" target="right"><div class="mennuInf">
					编写每日总结日记&nbsp;&nbsp;&nbsp;&nbsp;
				</div></a></li>
				<li><a href="<%=request.getContextPath()%>/diaryServlet?type=diaryquery" target="right"><div class="mennuInf">
					个人日记查询&nbsp;&nbsp;&nbsp;&nbsp;
				</div></a></li>
				<li><a href="diary/diaryupdate.jsp" target="right"><div class="mennuInf">
					修改日记&nbsp;&nbsp;&nbsp;&nbsp;
				</div></a></li>
			</ul>
		</div>
</body>
</html>