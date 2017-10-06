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
		<h1 class="page-title" align="center">个人请假信息列表</h1>
		<a href="Employee/leave/leaveupdate.jsp">修改请假信息</a><br>
		<a href="<%=request.getContextPath()%>/leaveServlet?type=querynum">个人请假次数查询</a>
		<div class="well">
			<table class="table" width="1000px" height="100px" align="center">
				<thead>
					<tr>
						<th>编号</th>
						<th>用户编号</th>
						<th>用户姓名</th>
						<th>请假理由</th>
						<th>请假开始时间</th>
						<th>请假天数</th>
						<th>审核结果</th>
						<th>审核状态</th>
						<th>销假状态</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sessionScope.leaveEntitylist}" var="leave" >
							<tr >
								<td>${leave.lId}</td>
								<td>${leave.userid}</td>
								<td>${leave.username}</td>
								<td>${leave.lReason}</td>
								<td>${leave.lStarttime}</td>
								<td>${leave.lDays}</td>
								<td>${leave.lLeavetype }</td>
								<td>${leave.lAudittype}</td>
								<td>${leave.lCanceltype}</td>
							</tr>
					</c:forEach> 
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>