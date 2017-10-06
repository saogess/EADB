<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核请假信息</title>
<script language="javascript">  
	function sumbit_sure(){  
		var gnl=confirm("确定审核？");  
		if(gnl==true){  
			return true;  
		}else{  
			return false;  
		}  
	}  
</script> 
</head>
<body>
		<form action="<%=request.getContextPath() %>/leaveServlet?type=leaveexam" onsubmit="return sumbit_sure()" method="post">
				编号：<input type="text" value="${sessionScope.leaveEntity.lId}" name="title" id="title" disabled="disabled"/><br>
				用户编号：<input type="text" value="${sessionScope.leaveEntity.userid}" disabled="disabled" /><br>
				用户姓名：<input type="text" value="${sessionScope.leaveEntity.username}" disabled="disabled" /><br>
				请假理由：<input type="text" value="${sessionScope.leaveEntity.lReason}" disabled="disabled" /><br>
				请假开始时间：<input type="text" value="${sessionScope.leaveEntity.lStarttime}" disabled="disabled" /><br>
				请假天数：<input type="text" value="${sessionScope.leaveEntity.lDays}" disabled="disabled" /><br>
				销假状态：<input type="text" value="${sessionScope.leaveEntity.lCanceltype}" disabled="disabled" /><br>
		<hr />
				<p>审核结果:</p>
				<textarea name="lLeavetype" id="lLeavetype" cols="100" rows="15" maxlength="1000" placeholder="请说明您的审核理由"></textarea>
		<hr />
				<input type="submit" value="审核" />
		</form>
</body>
</html>