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
		<h1 class="page-title" align="center">日记列表</h1>
		<a href="Employee/diary/diaryupdate.jsp">修改日记</a>
		<div class="well">
			<table class="table" width="1000px" height="100px" align="center">
				<thead>
					<tr>
						<th>编号</th>
						<th>用户编号</th>
						<th>用户名</th>
						<th>标题</th>
						<th>内容</th>
						<th>创建时间</th>
						<th>最后修改时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sessionScope.diarylist}" var="diary" >
							<tr >
								<td>${diary.dId}</td>
								<td>${diary.userid}</td>
								<td>${diary.username}</td>
								<td>${diary.dTitle}</td>
								<td>${diary.dContent }</td>
								<td>${diary.dStarttime}</td>
								<td>${diary.dModifytime}</td>
							</tr>
					</c:forEach> 
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>