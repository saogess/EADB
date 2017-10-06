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
            <img src="<%=request.getContextPath()%>/Admin/image/logo.png" height="60" width="220"/></div>
        <div class="top_img">
            <div class="top_img_photo"><img src="<%=request.getContextPath()%>/Admin/${sessionScope.admin.photo}" style="height: 40px;width: 40px;border-radius:50px;"></div>
            <div class="top_img_position"><a class="outa">${sessionScope.admin.email}</a></div>
            <div class="top_img_punch"><a class="outa">管理员</a></div>
            <div class="top_img_username"><a class="outa">${sessionScope.admin.userName}</a></div>
            <div class="top_img_mailbox">
                <input name="userthing" type="image" src="<%=request.getContextPath()%>/Admin/image/mailbox.png" width="16px" height="16px" style="outline:none;border: none">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                <script type="text/javascript">
                    $(":image").click(function(){
                        $(".userthing").slideToggle(1000);
                    });
                </script>
            </div>
            <div id="signout"><a href="<%=request.getContextPath()%>/adminServlet?type=out"><img src="<%=request.getContextPath()%>/Admin/image/sign_out.png"></a></div>
        </div>
    </div>
</div>
<div class="between">
    <div class="between_body">
        <div class="between_body_list">
            <div class="between_body_list_top">
                <a href="<%=request.getContextPath()%>/Admin/index.jsp" class="btn btn-s-md btn-success">&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/Admin/image/home.png" height="16" width="20">&nbsp;首页</a>
                <div class="between_body_list_label">
                    <a href="<%=request.getContextPath()%>/Admin/admin.jsp">&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/Admin/image/folder.png">&nbsp;功能列表</a>
                </div>
                <div class="between_body_list_content ">
                    <div class="navi_body">
                        <div class="navi_head ">
                                        <span>
                                            <p class="navi_title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个人信息</p>
                                            <p><a href="<%=request.getContextPath()%>/adminServlet?type=all" target="window" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全部管理员信息</a></p>
                                            <p><a href="<%=request.getContextPath()%>/Admin/admin_add.jsp" target="window" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理员信息添加</a></p>
                                            <p><a href="<%=request.getContextPath()%>/Admin/admin_query.jsp" target="window" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理员信息查询</a></p>
                                            
                                        </span>
                        </div>
                    </div>
                    <div class="navi_body">
                        <div class="navi_head ">
                                        <span>
                                            <p class="navi_title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公告信息</p>
                                            <p><a href="<%=request.getContextPath()%>/Admin/notice_add.jsp" target="window" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公告信息添加</a></p>
                                            <p><a href="<%=request.getContextPath()%>/Admin/notice_query.jsp" target="window" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公告信息查询</a></p>
                                            <p><a href="<%=request.getContextPath()%>/noticeServlet?type=all" target="window" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全部公告信息</a></p>
                                        </span>
                        </div>
                    </div>
                    <div class="navi_body">
                        <div class="navi_head ">
                                        <span>
                                            <p class="navi_title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其他功能</p>
                                            <p><a href="<%=request.getContextPath()%>/Admin/demo.jsp" target="window" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备忘录</a></p>
                                            <p><a href="<%=request.getContextPath()%>/Admin/notice_noadquery.jsp" target="window" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;多表查询</a></p>
                                            <p><a href="<%=request.getContextPath()%>/adminServlet?type=all" target="window" class="btn_list btn-s-md_list btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全部管理员信息</a></p>
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
                            <li><a>S7全球总决赛今日开赛！</a></li>
                            <li><a>国庆放假日期具体安排。</a></li>
                            <li><a>严禁在办公区以内吸烟。</a></li>
                            <li><a>新员工注意事项。</a></li>
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
                        <input name="email" type="image" src="<%=request.getContextPath()%>/Admin/image/email.png" style="outline:none;border: none">
                        <script type="text/javascript">
                            $(".lanren").click(function(){
                                $(".email_thing").slideToggle(1000);
                            });
                        </script>
                    </div>
                    <div class="email_thing">
						<div style="width:50px;height: 255px;float: left;background-color: #ebebeb">
                           <div style="width: 50px;height:50px;margin-top: 50px;">
                               <a href="<%=request.getContextPath()%>/Admin/online.jsp" target="windowsc" style="margin:0;padding:0;list-style:none;"><img src="<%=request.getContextPath()%>/Admin/image/connections.png"></a>
                           </div>
                           <div style="width: 50px;height:50px;margin-top: 50px;">
                            	<a href="<%=request.getContextPath()%>/Admin/online.jsp" target="windowsc" style="margin:0;padding:0;list-style:none;"><img src="<%=request.getContextPath()%>/Admin/image/Line.png"></a>
                            </div>
                        </div>
                        <iframe id="windowsc" name="windowsc" src="" style="width: 250px;height: 255px;float: right;border: none;"></iframe>
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