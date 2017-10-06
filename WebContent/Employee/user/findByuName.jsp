<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="span10">
		<h1 class="page-title">用户详细信息</h1>
		<div class="btn-toolbar">
			<button class="btn btn-primary" onclick="window.history.back(-1)">
				<i class="icon-save"></i> 返回
			</button>
		</div>
		<div class="well">
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane active in" id="home">
					<form id="tab">
						<label>编号：</label> <input readonly="readonly" type="text" value="${userEntity.userid}"
							class="input-xlarge"><br>
						<label>姓名：</label> <input readonly="readonly" type="text" value="${userEntity.username}"
							class="input-xlarge"><br>
						<label>性别：</label> <input readonly="readonly" type="text" value="${userEntity.usergender}"
							class="input-xlarge"><br>
						<label>邮箱：</label> <input readonly="readonly" type="text" value="${userEntity.useremail}"
							class="input-xlarge"><br>
						<label>电话：</label> <input readonly="readonly" type="text" value="${userEntity.userphone}"
							class="input-xlarge"><br>
						<label>生日：</label> <input readonly="readonly" type="text" value="${userEntity.userbirthday}"
							class="input-xlarge"><br>
						<label>地址：</label> <input readonly="readonly" type="text" value="${userEntity.useraddress}"
							class="input-xlarge"><br>
						<label>部门：</label> <input readonly="readonly" type="text" value="${userEntity.userdept}"
							class="input-xlarge"><br>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>