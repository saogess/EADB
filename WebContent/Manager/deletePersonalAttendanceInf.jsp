<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除考勤信息</title>
</head>
<body>
		<div style="text-align: center; margin: 50px">
	   <form method="post" action="<%=request.getContextPath()%>/AttendanceServlet?type=deletePersonal">
	  	 <p style="font-size: x-large;">请输入您想要删除的员工信息ID：</p>
	  	 <hr />
			<input type="text" value="请输入员工ID" name="userid" id="userid" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入员工ID';}">
		<hr />
			<input type="submit"  value="提交"/>
	  </form>
	</div>
	</body>
</html>