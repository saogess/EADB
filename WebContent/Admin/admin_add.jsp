<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员添加</title>
</head>
<style>
    body{
        background-color: #FFFFFF;
    }
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
    .icon-photo{
        position: absolute;
        left: 0;z-index:5;
        background-image: url(image/photo.png);
        margin-top: 10px;
        margin-left: 4px;
        width: 28px;
        height: 27px;
    }
    .icon-email{
        position: absolute;
        left: 0;z-index:5;
        background-image: url(image/email-1.png);
        margin-top: 5px;
        margin-left: 2px;
        width: 35px;
        height: 32px;
    }
    .icon-name{
        position: absolute;
        left: 0;z-index:5;
        background-image: url(image/business.png);
        margin-top: 10px;
        margin-left: 2px;
        width: 30px;
        height: 20px;
    }
    .icon-dial{
        position: absolute;
        left: 0;z-index:5;
        background-image: url(image/dial.png);
        margin-top: 10px;
        margin-left: 5px;
        width: 26px;
        height: 26px;
    }
    .icon-date{
        position: absolute;
        left: 0;z-index:5;
        background-image: url(image/date.png);
        margin-top: 10px;
        margin-left: 5px;
        width: 26px;
        height: 26px;
    }
    /*上传文件css*/
    .report-file {
        display: block;
        width: 95px;
        height: 40px;
        border: 1px solid #858585;
        background: none repeat scroll 0 0 #c0c0c0;
        color: #fff;
        text-align: center;
        float: left;
        position: absolute;
        margin-left: 240px;
    }
    .report-file span {
        cursor: pointer;
        display: block;
        line-height: 28px;
    }
    .file-prew {
        position: absolute;
        top: 0;
        left:0;
        width: 120px;
        height: 30px;
        font-size: 100px;
        opacity: 0;
        filter: alpha(opacity=0);
        cursor: pointer;
    }
</style>
<script type="text/javascript">
    //检验用户的合法性
    function checkLoginName()
    {
        var loginnameNode= document.getElementById("loginname");
        var data = document.getElementById("data");
        var loginname = trim(loginnameNode.value);
        //验证用户姓名的格式
        var reg =/^[a-z]{2}[a-z0-9]{4}$/i;
        if(reg.test(loginname))
        {
            //符合
            data.innerHTML="<a style='font-size: 10px'>登录名符合规则.</a>";
            return true;
        }else
        {
            data.innerHTML="<a style='font-size: 10px;color: #ff3a3f'>格式错误：字母开始,长度是6位.</a>";
            return false;
        }
    }
    //检验密码合法性
    function checkPassWord() {
        var passWordNode= document.getElementById("password");
        var passWordSpan = document.getElementById("data");
        var password = trim(passWordNode.value);
        //验证用户姓名的格式
        var reg =/^[0-9]{6}$/i;
        if(reg.test(password))
        {
            //符合
            passWordSpan.innerHTML="<a style='font-size: 10px'>密码符合规则.</a>";
            return true;
        }else
        {
            passWordSpan.innerHTML="<a style='font-size: 10px;color: #ff3a3f'>格式错误：密码全为数字，长度是6位.</a>";
            return false;
        }
    }
</script>
<body>

    <!--添加管理员信息  -->
    <div style="height: 10px"></div>
    <div class="admin_sigup" style="margin-left: 300px;" >
        <form action="<%=request.getContextPath()%>/adminServlet?type=add" method="post">
            <div style="height: 30px"></div>
            <div style="font-size:20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理员信息添加</div>
            <div align="center">
                <table>
                    <br/>
                    <tr><th></th><td>
                        <div class="div-bor"><i class="icon-user"></i>
                            <input type="text" style="height: 40px;width: 300px" class="form-control" id="loginname" name="loginName" placeholder="账号" onblur="checkLoginName();" /></div></td></tr>
                    <span id="userNameSpan"></span>
                    <tr><th></th><td>
                        <br/>
                        <div class="div-bor"><i class="icon-psw"></i>
                            <input type="text" style="height: 40px;width: 300px" class="form-control" id="password" name="password" placeholder="密码" onblur="checkPassWord();"/></div></td></tr>
                    <tr><th></th><td>
                        <br/>
                        <div class="div-bor"><i class="icon-name"></i>
                            <input type="text" style="height: 40px;width: 300px" class="form-control" id="username" name="username"  placeholder="姓名" ></div></td></tr>
                    <tr><th></th><td>
                        <br/>
                        <div class="div-bor"><i class="icon-photo"></i>
                            <div class="report-file">
                                <span>上传文件</span><input tabindex="3" size="3" id="photourl" name="photourl" class="file-prew" type="file" onchange="document.getElementById('textName').value=this.value">
                            </div>
                            <input type="text" id="textName" style="height: 40px;width: 200px" class="form-control" placeholder="头像"  />
                        </div>
                    </td></tr>
                    <tr><th></th><td>
                        <br/>
                        <div class="div-bor"><i class="icon-email"></i>
                            <input type="text" style="height: 40px;width: 300px" class="form-control" id="email" name="email" placeholder="邮箱" ></div></td></tr>
                    <tr><th></th><td><span id="data"></span>
                    </td><td><a href="#" >注册时遇到的问题</a></td></tr>
                    <tr><th></th><td></td><td></td></tr>
                    <tr><th></th><td><input class="btn btn-s-md btn-danger" type="submit" value="提交"></td></tr>
                </table>
            </div>
        </form>
    </div>

</body>
</html>