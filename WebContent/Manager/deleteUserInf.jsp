<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除员工信息</title>
<script language="javascript">  
	function sumbit_sure(){  
		var gnl=confirm("确定删除？");  
		if(gnl==true){  
			return true;  
		}else{  
			return false;  
		}  
	}  
</script>
</head>
<body>
		<div id="PersonInf" style="font-size: 30px;color: royalblue;font-family: '楷体';">
			删除员工信息</div>
			<hr />
			
		<form method="post" onsubmit="return sumbit_sure()" action="<%=request.getContextPath() %>/loginServlet?type=userEntityDelete">
		
			<table border="0px" width="630px" align="center">
				<tr>
					<td style="width: 90px;">员工&nbsp;&nbsp;I&nbsp;D：</td>
					<td style="width: 250px;"><input type="text" id="userId" name="userId"/></td>
					<td><span id="userIdSpan"></span></td>
				</tr>
			</table>
			
			<hr />
		
			<div align="center">
				<input type="submit" value="提交"/> &nbsp;&nbsp;
				<input type="reset"  value="重置"/>
			</div>
		
		</form>
</body>
</html>