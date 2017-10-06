<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告信息查询</title>
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
<body>

    <!--公告信息查询-->
	<form action="<%=request.getContextPath()%>/noticeServlet?type=noticeAd" method="post">
    <div style="height: 515px">
        <div style="height: 80px"></div>
        <div class="lanren"><h1 style="font-family: 'Adobe 仿宋 Std R';border: 1px solid #c0c0c0;text-align: center">公告查询</h1></div>​
        <h3 class="text-muted" style="text-align: center">请在此输入查询信息</h3><br/>
        <div style="text-align: center">
            <input class="search_fence_text" type="text" name="adminid" id="adminid" style="margin: auto;margin-bottom: 20px;padding-left: 50px" ><br/>
            <input class="btn btn-s-ft btn-danger" type="submit" value="查询">
            <input class="btn btn-s-ft btn-default" type="submit" value="重置">
        </div>
    </div>
	</form>
</body>
</html></html>