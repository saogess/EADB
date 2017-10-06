<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录界面</title>
    <link rel="icon" href="../image/star.ico" type="image/x-icon">
    <link type="text/css" href="../css/style.css" rel="stylesheet">
    <link type="text/css" href="../css/checkbox.css" rel="stylesheet">
    <script type="text/javascript" src="<%=request.getContextPath()%>/Employee/js/ajax.js"></script>
    <script type="text/javascript">
    	//用户编号登录验证
		function  UserIsExsit(val) {
			//获取到输入的值
			var userSpan=document.getElementById("user");
			if(val==""){
				userSpan.innerHTML="用户编号不能为空！".fontcolor("red");
				return;
			}else{
				validatePhone(val);
			}
		}
		//用户手机号与密码匹配登录验证
		function PasswordIsExsit(val)
		{
			var userSpan=document.getElementById("user");
			if(val==""){
				userSpan.innerHTML="密码不能为空！".fontcolor("red");
				return;
			}else{
				var userid=document.getElementById("userid").value;
				validatePhoneAndPassword(userid,val);
			}
		}
			
		function validatePhoneAndPassword(userid,userpassword){
			var userSpan=document.getElementById("user");
			//1: 创建Ajax异步对象
			var ajax = createAJAX();
			var method ="POST";
			var url="<%=request.getContextPath()%>/loginServlet?type=loginphoneAndpwd";
			ajax.open(method,url);
			//必须要设置请求头信息
			ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
			//数据
			var content="userid="+userid+"&userpassword="+userpassword;
			//3:
			ajax.send(content);
			//4
			ajax.onreadystatechange=function(){
				//5:
				if(ajax.readyState==4){
					if(ajax.status==200){
						var n=ajax.responseText;
						if(n==1){
							    userSpan.innerHTML="用戶编号和密码不匹配！".fontcolor("red");
							}else{
								userSpan.innerHTML="";
							}
						}
					}
			    }
			}
		
	function validatePhone(userid){
		var userSpan=document.getElementById("user");
		//1: 创建Ajax异步对象
		var ajax = createAJAX();
		var method ="POST";
		var url="<%=request.getContextPath()%>/loginServlet?type=loginphone";
		ajax.open(method,url);
		//必须要设置请求头信息
		ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
		//数据
		var content="userid="+userid;
		//3:
		ajax.send(content);
		//4
		ajax.onreadystatechange=function(){
			//5:
			if(ajax.readyState==4){
				if(ajax.status==200){
					var n=ajax.responseText;
					if(n==1){
						userSpan.innerHTML="用戶编号不存在！".fontcolor("red");
						}else{
							userSpan.innerHTML="";
						}
					}
				}
		    }
		}
</script>
</head>
<style>
    .icon-user{
        position: absolute;
        left: 0;z-index:5;
        background-image: url(image/user.png);
        margin-top: 5px;
        width: 35px;
        height: 32px;
    }
    .icon-psw{
        position: absolute;
        left: 0;z-index:5;
        background-image: url(image/lock.png);
        margin-top: 5px;
        width: 35px;
        height: 32px;
    }
</style>
<body>
	<form action="<%=request.getContextPath()%>/loginServlet?type=login" method="post">
					<div style="height: 30px"></div>
						<div align="center">
						<h1>登录</h1>
						<table>
							<tr><th></th><td>
								<div class="div-bor"><i class="icon-user"></i>
									<input type="text" style="height: 40px;width: 300px" class="form-control" id="userid" name="userid" onblur="UserIsExsit(this.value)" placeholder="用户编号" ></div></td></tr>
							<tr><th></th><td>
								<div class="div-bor"><i class="icon-psw"></i>
									<input type="password" style="height: 40px;width: 300px" class="form-control" id="userpassword" name="userpassword" onblur="PasswordIsExsit(this.value)"  placeholder="密码" ></div></td></tr>
							<tr><th></th><td><input type="checkbox" id="check" class="regular-checkbox" /><label for="check"></label><a>记住密码</a>
								</td><td><a href="Employee/user/login.jsp" >不是员工请先注册</a></td></tr>
							<tr><th></th><td><input class="btn btn-s-md btn-success" type="submit" value="登陆"></td></tr>
							<tr><span id="user"></span></tr>
						</table>
						</div>
	</form>
</body>
</html>