<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
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

    <script type="text/javascript" src="<%=request.getContextPath()%>/Manager/js/ajax.js"></script>
    <script type="text/javascript">
    	//用户工号登录验证
		function managerIsExsit(val) {
			//获取到输入的值
			var userSpan=document.getElementById("manager");
			if(val==""){
				userSpan.innerHTML="工号不能为空！".fontcolor("red");
				return;
			}else{
				validateManagerId(val);
			}
		}
		//用户手机号与密码匹配登录验证
		function managerPasswordIsExsit(val){
			var userSpan=document.getElementById("manager");
			if(val==""){
				userSpan.innerHTML="密码不能为空！".fontcolor("red");
				return;
			}else{
				var managerId=document.getElementById("managerId").value;
				validateManagerIdAndPassword(managerId,val);
			}
		}
			
		function validateManagerIdAndPassword(managerId,mPassword){
			var userSpan=document.getElementById("manager");
			//1: 创建Ajax异步对象
			var ajax = createAJAX();
			var method ="POST";
			var url="<%=request.getContextPath()%>/managerLoginServlet?type=loginMIdAndMpassword";
			ajax.open(method,url);
			//必须要设置请求头信息
			ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
			//数据
			var content="mId="+managerId+"&mPassword="+mPassword;
			//3:
			ajax.send(content);
			//4
			ajax.onreadystatechange=function(){
				//5:
				if(ajax.readyState==4){
					if(ajax.status==200){
						var n=ajax.responseText;
						if(n==1){
							    userSpan.innerHTML="工号和密码不匹配！".fontcolor("red");
							}else{
								userSpan.innerHTML="";
							}
						}
					}
			    }
			}
		
	function validateManagerId(managerId){
		var userSpan=document.getElementById("manager");
		//1: 创建Ajax异步对象
		var ajax = createAJAX();
		var method ="POST";
		var url="<%=request.getContextPath()%>/managerLoginServlet?type=loginMId";
		ajax.open(method,url);
		//必须要设置请求头信息
		ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
		//数据
		var content="managerId="+managerId;
		//3:
		ajax.send(content);
		//4
		ajax.onreadystatechange=function(){
			//5:
			if(ajax.readyState==4){
				if(ajax.status==200){
					var n=ajax.responseText;
					if(n==1){
						userSpan.innerHTML="工号不存在！请查证后登录".fontcolor("red");
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
        <div class="top">
            <div class="top_content">
                <div class="top_logo">
                    <img src="image/logo.png" height="60" width="220"/></div>
                <div class="top_img" style="width: 205px;border: none" >
                    <div style="height: 30px" ></div>
                        <div class="userRe" style="width: 60px;height: 20px;margin-left: 5px;float: left">
                            <input name="sigup_img_content_register" type="image" src="image/userRe.png" style="float: right;outline:none;border: none" >
                        </div>
                    <div class="managerRe" style="width: 60px;height: 20px;margin-left: 5px;float: left">
                        <input name="sigup_img_content_register" type="image" src="image/manageRe.png" style="float: right;outline:none;border: none" >
                    </div>
                    <div class="adminRe" style="width: 60px;height: 20px;margin-left: 5px;float: left">
                        <input name="sigup_img_content_register" type="image" src="image/adminRe.png" style="float: right;outline:none;border: none" >
                    </div>

                    <!--<input name="sigup_img_content_register" type="image" src="image/register.png" style="float: right;outline:none;border: none" >-->
                    <script type="text/javascript">
                        $(".userRe").click(function(){
                            $(".sigup_img_content_userRe").slideToggle(1000);
                        });
                        $(".userRe").click(function(){
                            $(".sigup_img_content_sigup").slideToggle(1000);
                        });
                        $(".managerRe").click(function(){
                            $(".sigup_img_content_managerRe").slideToggle(1000);
                        });
                        $(".managerRe").click(function(){
                            $(".sigup_img_content_sigup").slideToggle(1000);
                        });
                        $(".adminRe").click(function(){
                            $(".sigup_img_content_register").slideToggle(1000);
                        });
                        $(".adminRe").click(function(){
                            $(".sigup_img_content_sigup").slideToggle(1000);
                        });
                    </script>
                </div>
            </div>
        </div>
        <div class="sigup_img">
            <img src="image/bgimg.jpg" height="600" width="1348px">

            <div class="sigup_img_content">
                <div class="sigup_img_content_sigup" >
                    <form action="<%=request.getContextPath() %>/adminServlet?type=login" method="post">
                        <div style="height: 30px"></div>
                        <div style="font-size:20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登陆</div>
                        <div align="center">
                            <table>
                                <tr><th></th><td>
                                    <div class="div-bor"><i class="icon-user"></i>
                                        <input type="text" name="loginName" style="height: 40px;width: 300px" class="form-control" id="username" placeholder="账号" ></div></td></tr>
                                <tr><th></th><td>
                                    <div class="div-bor"><i class="icon-psw"></i>
                                        <input type="password" name="password" style="height: 40px;width: 300px" class="form-control" id="password" placeholder="密码" ></div></td></tr>
                                <tr><th></th><td><input type="checkbox" id="check" class="regular-checkbox" /><label for="check"></label><a style="color: #1b1b1b">记住密码</a>
                                </td><td><a href="#" >登陆时遇到的问题</a></td></tr>
                                <tr><th></th><td><span id="data"></span></td><td></td></tr>
                                <tr><th></th><td><input class="btn btn-s-md btn-danger" type="submit" value="登陆"></td></tr>
                             </table>
                        </div>
                    </form>
                </div>
                <div class="sigup_img_content_userRe" >
                    <form action="<%=request.getContextPath()%>/loginServlet?type=login" method="post">
                        <div style="height: 30px"></div>
                        <div style="font-size:20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;员工登陆</div>
                        <div align="center">
                            <table>
                                <tr><th></th><td>
                                    <div class="div-bor"><i class="icon-user"></i>
                                        <input type="text" style="height: 40px;width: 300px" class="form-control" id="userid" name="userid" onblur="UserIsExsit(this.value)"  placeholder="账号" ></div></td></tr>
                                <tr><th></th><td>
                                    <div class="div-bor"><i class="icon-psw"></i>
                                        <input type="password" style="height: 40px;width: 300px" class="form-control" id="userpassword" name="userpassword" onblur="PasswordIsExsit(this.value)"  placeholder="密码" ></div></td></tr>
                                <tr><th></th><td><input type="checkbox" class="regular-checkbox" /><label for="check"></label><a style="color: #1b1b1b">记住密码</a>
                                </td><td><a href="#" >登陆时遇到的问题</a></td></tr>
                                <tr><th></th><td><span id="user"></span></td><td></td></tr>
                                <tr><th></th><td><input class="btn btn-s-md btn-danger" type="submit" value="登陆"></td></tr>
                            </table>
                        </div>
                    </form>
                </div>
                <div class="sigup_img_content_managerRe" >
                    <form action="<%=request.getContextPath()%>/managerLoginServlet?type=login" method="post">
                        <div style="height: 30px"></div>
                        <div style="font-size:20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;经理登陆</div>
                        <div align="center">
                            <table>
                                <tr><th></th><td>
                                    <div class="div-bor"><i class="icon-user"></i>
                                        <input type="text" name="managerId" style="height: 40px;width: 300px" class="form-control" id="managerId" placeholder="工号" onblur="managerIsExsit(this.value)" ></div></td></tr>
                                <tr><th></th><td>
                                    <div class="div-bor"><i class="icon-psw"></i>
                                        <input type="password" name="mPassword" style="height: 40px;width: 300px" class="form-control" id="mPassword" placeholder="密码" onblur="managerPasswordIsExsit(this.value)" ></div></td></tr>
                                <tr><th></th><td><input type="checkbox" id="re_check" class="regular-checkbox" /><label for="check"></label><a style="color: #1b1b1b">同意相关注册协议</a>
                                </td><td><a href="#" >登陆时遇到的问题</a></td></tr>
                                <tr><th></th><td><span id="manager"></span></td><td></td></tr>
                                <tr><th></th><td><input class="btn btn-s-md btn-success" type="submit" value="登录"></td></tr>
                            </table>
                        </div>
                    </form>
                </div>
                <div class="sigup_img_content_register">
                    <form action="<%=request.getContextPath() %>/adminServlet?type=add" method="post">
                        <div style="height: 30px"></div>
                        <div style="font-size:20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注册</div>
                        <div align="center">
                            <table>
                                <tr><th></th><td>
                                    <div class="div-bor"><i class="icon-user"></i>
                                        <input type="text" onblur="LoginNameIsExsit(this)" name="loginName" style="height: 40px;width: 300px" class="form-control" id="re_username" placeholder="账号" ></div></td></tr>
                                <tr><th></th><td>
                                    <div class="div-bor"><i class="icon-psw"></i>
                                        <input type="password" name="password" style="height: 40px;width: 300px" class="form-control" id="re_password" placeholder="密码" ></div></td></tr>
                                <tr><th></th><td><input type="checkbox" id="re_check" class="regular-checkbox" /><label for="check"></label><a style="color: #1b1b1b">同意相关注册协议</a>
                                </td><td><a href="#" >注册时遇到的问题</a></td></tr>
                                <tr><th></th><td><a></a><span id="loginSpan"></a></span></td><td></td></tr>
                                <tr><th></th><td><input class="btn btn-s-md btn-success" type="submit" value="注册"></td></tr>
                            </table>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="last">
            <a style=' height:70px;line-height:70px;overflow:hidden;' >
                关于公司 |
                服务协议 |
                运营中心 |
                辟谣中心 |
                公司客服 |
                联系邮箱 |
                侵权投诉 |
                Copyright © 2012-2017 Employee. All Rights Reserved.</a>
        </div>

</body>
</html>
