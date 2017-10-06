<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经理个人信息</title>
</head>
<body>
		<div id="PersonInf" style="font-size: 30px;color: royalblue;font-family: '楷体';">
			<img src="${sessionScope.mInf.pictureurl}">个人信息</div>
			<hr />
			
		<form method="post" action="#">
		
			<table class="table" width="500px" align="center">
				<tr>
					<td style="width: 200px;">工作&nbsp;&nbsp;I&nbsp;D：</td>
					<td>${sessionScope.mInf.mid}</td>
				</tr>
								
				<tr>
					<td>工作职位：</td>
					<td>${sessionScope.mInf.position}</td>
				</tr>
				
				<tr>
					<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
					<td>${sessionScope.mInf.managername}</td>
				</tr>
				
				<tr>
					<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
					<td>${sessionScope.mInf.mPassword}</td>
				</tr>
				
				<tr>
					<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
					<td>${sessionScope.mInf.gender}</td>
				</tr>
				
				<tr>
					<td>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</td>
					<td>${sessionScope.mInf.mail}</td>
				</tr>
				
				<tr>
					<td>手机号码：</td>
					<td>${sessionScope.mInf.phonenumber}</td>
				</tr>
				
				<tr>
					<td>生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日：</td>
					<td>${sessionScope.mInf.birthday}</td>
				</tr>
				
				<tr>
					<td>家庭住址：</td>
					<td>${sessionScope.mInf.address}</td>
				</tr>
								
			</table>
		</form>
		
	</body>
</html>