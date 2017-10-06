<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告信息添加</title>
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

    <!--公告信息添加-->
    <div style="height: 10px"></div>
    <div class="admin_sigup" style="margin-left: 300px;" >
        <form action="<%=request.getContextPath()%>/noticeServlet?type=add" method="post">
            <div style="height: 30px"></div>
            <div style="font-size:20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公告信息添加</div>
            <div align="center">
                <table>
                    <br/>
                    <tr><th></th><td>
                        <div class="div-bor"><i class="icon-dial"></i>
                            <input type="text" style="height: 40px;width: 300px" class="form-control" name="noticeId" id="noticeId" placeholder="公告编号" ></div></td></tr>
                    <tr><th></th><td>
                        <br/>
                        <div class="div-bor"><i class="icon-date"></i>
                            <input type="text" style="height: 40px;width: 300px" class="form-control" name="data" id="data" placeholder="日期" ></div></td></tr>
                    <tr><th></th><td>
                        <br/>
                        <div class="div-bor">
                            <textarea maxlength="200" id="status" name="status" style="font-size: 16px;padding-left:34px;" placeholder="公告信息"  rows="4" cols="36" onkeydown='countChar("status","counter");' onkeyup='countChar("status","counter");'></textarea>
                            <div style="position:absolute;height: 15px;width: 60px; background-color: #ffffff;font-size:12px  ">
                                <span id="counter">200</span>/200字<br/></span>
                            </div>
                        </div></td></tr>
                    <tr><th></th><td>
                        <br/>
                        <div class="div-bor"><i class="icon-user"></i>
                            <input type="text" style="height: 40px;width: 300px" class="form-control" id="admin" placeholder="管理" ></div></td></tr>
                    <tr><th></th><td>
                        <br/>
                    </td><td><a href="#" >添加时遇到的问题</a></td></tr>
                    <tr><th></th><td><a>添加验证</a></td><td></td></tr>
                    <tr><th></th><td><input class="btn btn-s-md btn-danger" type="submit" value="提交"></td></tr>
                </table>
            </div>
        </form>
    </div>

</body>
</html>