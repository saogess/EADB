<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
</head>
<div id="PersonInf" style="font-size: 30px;color: royalblue;font-family: '楷体';">
			<img src="${sessionScope.mInf.pictureurl}">修改个人信息</div>
			<hr />
			
		<form method="post" action="<%=request.getContextPath()%>/managerLoginServlet?type=update">
		
			<table border="0px" width="650px" align="center">
				<tr>
					<td style="width: 100px;">工作&nbsp;&nbsp;I&nbsp;D：</td>
					<td style="width: 250px;"><input type="text" id="userId" name="userId" value="${sessionScope.mInf.mid}" readonly="readonly" onblur="checkUserId();"/></td>
					<td><span id="userIdSpan"></span></td>
				</tr>
				
				<tr>
					<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
					<td><input type="text" id="userName" name="userName" value="${sessionScope.mInf.managername}" readonly="readonly" onblur="checkUserName();"/></td>
					<td><span id="userNameSpan"></span></td>
				</tr>
				
				<tr>
					<td>原先密码：</td>
					<td><input type="text" value="${sessionScope.mInf.mPassword}" name="pwd" id="pwd" readonly="readonly"/></td>
					<td><span id="userNameSpan"></span></td>
				</tr>
				
				<tr>
					<td>新&nbsp;&nbsp;密&nbsp;&nbsp;码：</td>
					<td><input type="password" id="password_1" name="password_1"/> </td>
					<td><span id="password_1_Span"></span></td>
				</tr>
				
				<tr>
					<td>确认密码：</td>
					<td> <input type="password" id="password_2" name="password_2" onblur="checkUserPassword();"> </td>
					<td><span id="password_2_Span"></span></td>
				</tr>
				
				<tr>
					<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
					<td> <input type="text" value="${sessionScope.mInf.gender}" readonly="readonly"/></td>
					<td><span></span></td>
				</tr>
				
				<tr>
					<td>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</td>
					<td> <input type="text" id="userMail" name="userMail" value="${sessionScope.mInf.mail}" onblur="checkUserMail();"/> </td>
					<td><span id="userMailSpan"></span></td>
				</tr>
				
				<tr>
					<td>手机号码：</td>
					<td> <input type="text" id="Phone" name="Phone" value="${sessionScope.mInf.phonenumber}" onblur="checkUserPhone();"/> </td>
					<td><span id="PhoneSpan"></span></td>
				</tr>
				
				<tr>
					<td>工作职位：</td>
					<td> <input type="text" value="${sessionScope.mInf.position}" readonly="readonly"/> </td>
					<td><span id="PhoneSpan"></span></td>
				</tr>
				
				<tr>
					<td>生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日：</td>
					<td><input type="text" value="${sessionScope.mInf.birthday}" readonly="readonly"></td>
					<td><span></span></td>
				</tr>
				
				<tr>
					<td>原家庭住址：</td>
					<td><input type="text" value="${sessionScope.mInf.address}" name="address" id="address" readonly="readonly"></td>
					<td><span></span></td>
				</tr>
				
				<tr>
					<td>现家庭住址：</td>
					<td>
						<select name="Province" id="Province" onchange="showCity()">
							<option value="0">-请选择省份-</option>
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