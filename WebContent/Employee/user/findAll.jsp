<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="span10">
		<h1 class="page-title" align="center">所有用户信息列表</h1>
		<div class="well">
			<table class="table" width="1000px" height="100px" align="center">
				<thead>
					<tr>
						<th>用户编号</th>
						<th>用户姓名</th>
						<th>性别</th>
						<th>邮箱</th>
						<th>电话</th>
						<th>生日</th>
						<th>地址</th>
						<th>部门</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sessionScope.userlist}" var="user" >
							<tr   >
								<td>${user.userid}</td>
								<td>${user.username}</td>
								<td>${user.usergender}</td>
								<td>${user.useremail}</td>
								<td>${user.userphone}</td>
								<td>${user.userbirthday}</td>
								<td>${user.useraddress }</td>
								<td>${user.userdept}</td>
							</tr>
					</c:forEach> 
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>