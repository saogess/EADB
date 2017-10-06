<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经理信息上传</title>
</head>
<body>
		<div id="PersonInf" style="font-size: 30px;color: royalblue;font-family: '楷体';">
			上传公共文件</div>
			<hr />
			
		<form method="post" action="<%=request.getContextPath()%>/FileInfServlet?type=upload" enctype="multipart/form-data">
		
			<table border="0px" width="630px" align="center">
				<tr>
					<td style="width: 90px;">文件编号：</td>
					<td style="width: 250px;"><input type="text" id="fNum" name="fNum"/></td>
					<td><span id="fNumSpan"></span></td>
				</tr>
				
				<tr>
					<td>文件名：</td>
					<td><input type="text" id="fName" name="fName" /></td>
					<td><span id="fNameSpan"></span></td>
				</tr>
				
				<tr>
					<td>选择文件：</td>
					<td><input type="file" id="file" name="file" /></td>
					<td><span id="fileSpan"></span></td>
				</tr>
				
			</table>
			
			<hr />
		
			<div align="center">
				<input type="submit" value="上传"/> &nbsp;&nbsp;
				<input type="reset"  value="重置"/>
			</div>
		</form>
	</body>
</html>