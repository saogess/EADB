<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加个人信息</title>
</head>
<body>
		<div id="PersonInf" style="font-size: 30px;color: royalblue;font-family: '楷体';">
			增添个人信息</div>
			<hr />
			
		<form method="post" action="<%=request.getContextPath()%>/managerLoginServlet?type=add">
		
			<table border="0px" width="630px" align="center">
				<tr>
					<td style="width: 90px;">工作&nbsp;&nbsp;I&nbsp;D：</td>
					<td style="width: 250px;"><input type="text" id="userId" name="userId" onblur="checkUserId();"/></td>
					<td><span id="userIdSpan"></span></td>
				</tr>
				
				<tr>
					<td>姓名：</td>
					<td><input type="text" id="userName" name="userName" onblur="checkUserName();"/></td>
					<td><span id="userNameSpan"></span></td>
				</tr>
				
				<tr>
					<td>职位：</td>
					<td><input type="text" id="userPosition" name="userPosition""/></td>
					<td><span id="userPositionSpan"></span></td>
				</tr>
				
				<tr>
					<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
					<td><input type="password" id="password_1" name="password_1"/> </td>
					<td><span id="password_1_Span"></span></td>
				</tr>
				
				<tr>
					<td>确认密码：</td>
					<td> <input type="password"/ id="password_2" name="password_2" onblur="checkUserPassword();"> </td>
					<td><span id="password_2_Span"></span></td>
				</tr>
				
				<tr>
					<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
					<td> <input type="radio" name="gender" value="男" checked="checked"/>男 &nbsp; 
						<input type="radio" name="gender" value="女"/>女</td>
					<td><span></span></td>
				</tr>
				
				<tr>
					<td>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</td>
					<td> <input type="text" id="userMail" name="userMail" onblur="checkUserMail();"/> </td>
					<td><span id="userMailSpan"></span></td>
				</tr>
				
				<tr>
					<td>手机号码：</td>
					<td> <input type="text" id="Phone" name="Phone" onblur="checkUserPhone();"/> </td>
					<td><span id="PhoneSpan"></span></td>
				</tr>
				
				<tr>
					<td>生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日：</td>
					<td> 
						<select name="year" id="year">
							<option value="">-请选择年份-</option>
							<option value="1991">1991</option>
							<option value="1992">1992</option>
							<option value="1993">1993</option>
							<option value="1994">1994</option>
							<option value="1995">1995</option>
							<option value="1996">1996</option>
							<option value="1997">1997</option>
							<option value="1998">1998</option>
							<option value="1999">1999</option>
							<option value="2000">2000</option>
							<option value="2001">2001</option>
							<option value="2002">2002</option>
							<option value="2003">2003</option>
							<option value="2004">2004</option>
							<option value="2005">2005</option>
							<option value="2006">2006</option>
							<option value="2007">2007</option>
							<option value="2008">2008</option>
							<option value="2009">2009</option>
							<option value="2010">2010</option>
						</select> 
					
						<select name="month" id="month" onchange="showBirthday();">
							<option value="">-请选择月份-</option>
							<option value="1">01</option>
							<option value="2">02</option>
							<option value="3">03</option>
							<option value="4">04</option>
							<option value="5">05</option>
							<option value="6">06</option>
							<option value="7">07</option>
							<option value="8">08</option>
							<option value="9">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>

						<select name="date" id="date">
							<option value="">-请选择日期-</option>
						</select>

					<td><span></span></td>
				</tr>
				
				<tr>
					<td>家庭住址：</td>
					<td>
						<select name="Province" id="Province" onchange="showCity()">
							<option value="">-请选择省份-</option>
							<option value="1">北京</option>
							<option value="2">上海</option>
							<option value="3">广州</option>
							<option value="4">山西</option>
							<option value="5">四川</option>
						</select> 
					
						<select name="City" id="City">
							<option value="">-请选择地区-</option>
							
						</select>
						
					</td>
					<td><span></span></td>
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