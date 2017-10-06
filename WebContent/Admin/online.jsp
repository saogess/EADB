<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
    body{
        background-color: #FFFFFF;
    }
</style>
<body>
		<div style="height: 255px">
		<a >当前在线管理员：</a>
		<c:if test="${not empty applicationScope.onlineList }">
			<c:forEach items="${applicationScope.onlineList }" var="u">
			
			<div style="width: 240px;height:50px;border: 1px solid #c0c0c0;margin: 2px;">
       			<div style="height: 50px;width: 50px;float: left ">
           			<div style="width: 50px;height: 50px;border-radius:50px;position: relative;left: 10px;">
					<img src="${u.photo }" style="width: 50px;height: 50px;border-radius:50px;">
           			</div>
       			</div>
       			<div style="height: 50px;width: 100px;float: left;margin-left: 30px; ">
           			<div style="width: 100px;height: 20px;position: relative;top:4px;">
               			<a class="notype" >${u.userName }</a>
           			</div>
           			<div style="width: 100px;height: 20px;position: relative;top:6px;">
               			<a class="notype" >${u.loginName}</a>
           			</div>
       			</div>
    		</div>
				<%-- <tr>
					<td>${u.userName }</td>
					<td>${u.loginName}</td>
				</tr> --%>
			</c:forEach>
		</c:if>
		</div>
</body>
</html>