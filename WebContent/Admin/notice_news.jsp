<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告查询结果</title>
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

    <!--公告查询结果-->

    <div style="height: 515px">
        <div style="height:10px;"></div>
        <div style="background-color: #ffffff;margin-left: 50px;  width: 400px;height: 200px;border: 1px solid #c0c0c0">

            <div style="width: 340px;height: 30px;background-color: #dcdcdc;position: relative;left: 20px;top:20px;">
                <a>${sessionScope.Notice.nid}</a>
                <a style="float: right">${sessionScope.Notice.time}</a>
            </div>
            <div style="width: 320px;height: 100px;background-color: #dcdcdc;position: relative;left: 38px;top:25px;border: 1px solid #c0c0c0">
                <a>${sessionScope.Notice.notice}</a>
            </div>
            <div style="width: 50px;height: 20px;background-color: #ffffff;position: relative;float: left;left: 240px;top:30px;">
                <a href="notice_revise.jsp" class="btn_a  btn-success" >修改</a>
            </div>
            <div style="width: 50px;height: 20px;background-color: #ffffff;position: relative;float: left; left: 260px;top:30px;">
                <a href="<%=request.getContextPath()%>/noticeServlet?type=delete&nid=${sessionScope.Notice.nid}" class="btn_a btn-success" >删除</a>
            </div>

        </div>
    </div>

</body>
</html>