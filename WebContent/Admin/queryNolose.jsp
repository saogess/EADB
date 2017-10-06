<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作失败</title>
</head>
<style>
    body{
        background-color: #FFFFFF;
    }
</style>
<script type="text/javascript">

    window.onload =function() {
        var i = 2;
        setInterval(function(){
            if(i == 0) {
                location.href = "notice_query.jsp";
            }
            document.getElementById("test").innerHTML = i--;

        },1000);
    };
</script>
<body>

<!--失败跳转界面-->

<div style="height: 515px">
    <div style="height: 80px"></div>
    <div class="lanren"><h1 style="font-family: 'Adobe 仿宋 Std R';border: 1px solid #c0c0c0;text-align: center">查询失败</h1></div>​
    <h3 class="text-muted" style="text-align: center">请等待<span id="test">3</span>秒后跳转回查询页面</h3><br/>
    <div style="text-align: center">
        <img src="image/queryLose.gif" style="height: 150px;width:150px;"><br/>
        <a href="Admin/countd.jsp" class="btn btn-s-ft btn-danger" >主页</a>
        <a href="Admin/admin_query.jsp" class="btn btn-s-ft btn-default" >返回</a>
    </div>
</div>

</body>
</html></html>