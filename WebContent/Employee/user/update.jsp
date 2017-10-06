<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.main{
	background-image: url(../image/love-you.jpg);
}
</style>
</head>
<body>
<form accept-charset="UTF-8" method="post" action="<%=request.getContextPath()%>/loginServlet?type=userEntityUpdate" >
  <div style="height:50px;">
  <div style="margin:0 0 0 20px;font-size:40px;float:left;">员工信息修改</div>
  <div style="margin:0 auto;font-size:20px;float:left;">请正确填写个人信息</div>
  </div>
  <hr>
  <div class="main">
  <table border="0px" width="800px" height="500px" align="center">
		
		<tr>
			<th class="td1">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</th>
			<td><input type="password" id="userpassword" name="userpassword" placeholder="请输入密码,至少6位" onblur="checkPassword()"/>
			<span id="passwordSpan"></span>
			</td>
		</tr>
		<tr>
			<th>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</th>
			<td><input name="useremail" id="useremail" type="text" placeholder="请输入常用邮箱" onblur="checkEmail()" />
			<span id="emailSpan"></span>
			</td>
		</tr>
		<tr>
			<th>手机号码：</th>
			<td><input type="text" name="userphone" id="userphone" placeholder="请输入手机号码" onblur="checkPhone()"/>
			<span id="phoneSpan"></span>
			</td>
		</tr>
		
		<tr>
			<th>家庭住址：</th>
			<td><textarea name="useraddress" style="margin:0px;width:290px;height:20px;"></textarea></td>
		</tr>
  </table>
  </div>
  <hr>
  <div align="center"><input type="image" src="../image/ok-32.png" width="50px" height="30px">&nbsp;&nbsp;<input type="image" src="../image/cancel.png" onclick="reset()" width="70px" height="30px"></div>
</form>
</body>
</html>