<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<style type="text/css">
    @import url(http://fonts.googleapis.com/css?family=Open+Sans:300,400);
    ul.countdown {
        list-style: none;
        margin: 75px 0;
        padding: 0;
        display: block;
        text-align: center;
    }
    ul.countdown li {
        display: inline-block;
    }
    ul.countdown li span {
        font-size: 80px;
        font-weight: 300;
        line-height: 80px;
    }
    ul.countdown li.seperator {
        font-size: 80px;
        line-height: 70px;
        vertical-align: top;
    }
    ul.countdown li p {
        color: #a7abb1;
        font-size: 14px;
    }
	div.box>span{
	color:#c0c0c0;
	font-style:italic;
	}
</style>
<body>
<div class="userthing">
    <div class="userthing_balance">
    <br/>
		   &nbsp;&nbsp;&nbsp;&nbsp;<span id="clock"></span>
		<script type="text/javascript">
			// 定义获取和更新时间的函数
			function showTime() {
			    var curTime = new Date();
			    $("#clock").html(curTime.toLocaleString());
			    setTimeout("showTime()", 1000);
			}
			// 页面加载完成后执行上面的自定义函数
			$(function(){
			    showTime()
			})
		</script>
    </div>
    <div class="userthing_function">
        <div class="userthing_function_1">
            <a href="#" class="btn btn-s-ft btn-danger">&nbsp;&nbsp;签到</a>
        </div>
        <div class="userthing_function_1">
            <a href="#" class="btn btn-s-ft btn-warning">&nbsp;&nbsp;帮助</a>
        </div>
    </div>
</div>
<div class="top">
    <div class="top_content">
        <div class="top_logo">
            <img src="<%=request.getContextPath()%>/Employee/image/logo.png" height="60" width="220"/></div>
        <div class="top_img">
            <div class="top_img_photo"></div>
            <div class="top_img_position"><a class="outa" href="user/regist.jsp">信息录入</a></div>
            <div class="top_img_punch"><a class="outa" href="user/login.jsp">登录</a></div>
        </div>
    </div>
</div>
    <div class="between">
        <div class="between_body">
            <div class="between_body_list">
                <div class="between_body_list_top">
                    <a href="index.jsp" class="btn btn-s-md btn-success">&nbsp;&nbsp;&nbsp;&nbsp;<img src="image/home.png" height="16" width="20">&nbsp;首页</a>
                    <div class="between_body_list_label">
                        <a href="admin.jsp">&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/Employee/image/folder.png">&nbsp;功能列表</a>
                    </div>
                            <div class="between_body_list_content ">
                                <div class="navi_body">
                        <div class="navi_head ">
                                        <span>
                                            <p class="navi_title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个人信息管理</p>
                                            <p><a href="user/findAll.jsp"  class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查看所有员工信息</a></p>
                                            <p><a href="user/findByName.jsp"  class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查看个人信息</a></p>
                                            <p><a href="user/update.jsp"  class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改个人信息</a></p>
                                        </span>
                        </div>
                    </div>
                    <div class="navi_body">
                        <div class="navi_head ">
                                        <span>
                                            <p class="navi_title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请假信息管理</p>
                                            <p><a href="leave/leaveinsert.jsp" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请请假</a></p>
                                            <p><a href="leave/leavequery.jsp" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个人请假信息查询</a></p>
                                            <p><a href="leave/leavecancel.jsp" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请销假</a></p>
                                        </span>
                        </div>
                    </div>
                    <div class="navi_body">
                        <div class="navi_head ">
                                        <span>
                                            <p class="navi_title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其他功能</p>
                                            <p><a href="diary/diaryinsert.jsp" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编写每日总结日记</a></p>
                                            <p><a href="diary/diaryquery.jsp" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个人日记查询</a></p>
                                            <p><a href="diary/diaryupdate.jsp" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日记修改</a></p>                                        
                                        </span>
                        </div>
                    </div>
                            </div>

                </div>

            </div>
            <div class="between_body_content">
                <div class="between_body_content_top">
                    <div class="between_body_content_top_search">
                        &nbsp;&nbsp;<a>公告信息：</a>
                        <div id="newslist">
                            <ul id="contain">
                                <li><a>公告信息栏未添加数据库与具体操作</a></li>
                                <li><a>嘀嘀快车哈哈哈哈哈</a></li>
                                <li><a>公告信息栏未添加数据库与具体操作</a></li>
                                <li><a>百度云盘呵呵呵呵呵</a></li>
                            </ul>
                        </div>
                        <script language="JavaScript">
                            function xx(){
                                var container=document.getElementById("contain");
                                container.appendChild(container.firstChild);
                            }
                            setInterval("xx()",4000);
                        </script>
                    </div>
                    <div class="between_body_content_top_buy" >
                        <div class="lanren">
                            <input name="email" type="image" src="<%=request.getContextPath()%>/Employee/image/email.png" style="outline:none;border: none">
                            <script type="text/javascript">
                                $(".lanren").click(function(){
                                    $(".email_thing").slideToggle(1000);
                                });
                            </script>
                        </div>
                        <div class="email_thing">

                        </div>
                    </div>
                </div>
                <div class="between_body_content_bottom">
                    
                    <iframe id="window" name="window" src="" height="515px" width="998px" frameborder="0" ></iframe>
                </div>
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