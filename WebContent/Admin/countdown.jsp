<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页倒计时</title>
</head>
<style type="text/css">
	body{
        background-color: #FFFFFF;
    }
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
		<div style="height: 515px">
		<div style="height: 30px"></div>
		<div class="lanren" style="width: 200px;margin-top:100px "><h1 style="font-family: 'Adobe 仿宋 Std R'; font-size: 30px; border: 1px solid #c0c0c0;text-align: center">验收倒计时</h1></div>​
		<h3 class="text-muted" style="text-align: center">点击左上方功能列表进入系统</h3><br/>
		<ul class="countdown">
		    <li> <span class="days">00</span>
		
		    </li>
		    <li class="seperator">.</li>
		    <li> <span class="hours">00</span>
		
		    </li>
		    <li class="seperator">:</li>
		    <li> <span class="minutes">00</span>
		
		    </li>
		    <li class="seperator">:</li>
		    <li> <span class="seconds" style="color: #ff3a3f;">00</span>
		
		    </li>
		</ul>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.downCount.js"></script>
		<div style="display: none">
		<script class="source" type="text/javascript">
		   $('.countdown').downCount({
		       date: '09/29/2017 12:00:00',
		       offset: +10
		   }, function () {
		       alert('倒计时结束!');
		   });
		</script>
		</div>
		</div>
</body>
</html>