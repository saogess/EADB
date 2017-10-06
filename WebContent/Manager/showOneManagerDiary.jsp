<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经理日志</title>
<script language="javascript">  
	function sumbit_sure(){  
		var gnl=confirm("确定修改？");  
		if(gnl==true){  
			return true;  
		}else{  
			return false;  
		}  
	}  
</script> 
</head>
<body>
		<form action="<%=request.getContextPath()%>/diaryServlet?type=update&mid=${requestScope.details.dId}" onsubmit="return sumbit_sure()" method="post">
				日志标题：<input type="text" value="${requestScope.details.dTitle}" name="title" id="title" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				创作时间：<input type="text" value="${requestScope.details.dStarttime}" disabled="disabled" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				修改时间：<input type="text" value="${requestScope.details.dModifytime}" disabled="disabled" />
		<hr />
				<p>日志内容：</p>
				${requestScope.details.dContent}
		<hr />
				<p>日志内容修改为：(不超过1000个字)</p>
				<textarea name="managerDiary" id="managerDiary" cols="100" rows="15" maxlength="1000" placeholder="请编辑您的日志"></textarea>
		<hr />
				<input type="submit" value="修改" />
		</form>
</body>
</html>