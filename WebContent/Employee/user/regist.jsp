<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.main{
	background-image: url(../image/love-you.jpg);
}
</style>
</head>
<body>
<form accept-charset="UTF-8" method="post" action="<%=request.getContextPath()%>/loginServlet?type=regist" >
  <div style="height:50px;">
  <div style="margin:0 0 0 20px;font-size:40px;float:left;">员工信息录入</div>
  <div style="margin:0 auto;font-size:20px;float:left;">请正确填写个人信息</div>
  </div>
  <hr>
  <div class="main">
  <table border="0px" width="800px" height="500px" align="center" >
		<tr>
			<th class="td1">用户编号：</th>
			<td><input type="text" id="userid" name="userid" onblur="checkUserId()" placeholder="请输入用户编号" />
			<span id="userIdSpan"></span>
			</td>
		</tr>
		<tr>
			<th class="td1">用户姓名：</th>
			<td><input type="text" id="username" name="username" onblur="checkUserName()" placeholder="请输入用户姓名"/>
			<span id="userNameSpan"></span>
		</td>
		</tr>
		<tr>
			<th class="td1">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</th>
			<td><input type="password" id="userpassword" name="userpassword" placeholder="请输入密码,至少6位" onblur="checkPassword()"/>
			<span id="passwordSpan"></span>
			</td>
		</tr>
		<tr>
			<th>确认密码：</th>
			<td><input type="password" id="userpassword1" name="userpassword1" placeholder="请再次输入密码" onblur="checkPassword1()"/>
			<span id="passwordSpan1"></span>
			</td>
		</tr>
		<tr>
			<th>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</th>
			<td>男<input type="radio" name="usergender" value="男" checked="checked"/>&nbsp;&nbsp;&nbsp;&nbsp;女<input type="radio" name="usergender" value="女"/>
			</td>
		</tr>
		<tr>
			<th>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</th>
			<td><input name="useremail" id="useremail" type="text" placeholder="请输入常用邮箱" onblur="checkEmail()" />
			<span id="emailSpan"></span>
			</td>
		</tr>
		<tr>
			<th>手机号码：</th>
			<td><input type="text" name="userphone" id="userphone" placeholder="请输入手机号码" onblur="checkPhone()"/>
			<span id="phoneSpan"></span>
			</td>
		</tr>
		<tr>
			<th>出生日期：</th>
			<td>
				<select name="year" id="year" >
					<option >=请选择年份=</option>
					<option >1991</option>
					<option >1992</option>
					<option >1993</option>
					<option >1994</option>
					<option >1995</option>
					<option >1996</option>
					<option >1997</option>
					<option >1998</option>
					<option >1999</option>
					<option >2000</option>
				</select>
				<select name="month" id="month" onchange="showBirthday()">
					<option >=请选择月份=</option>
					<option >1</option>
					<option >2</option>
					<option >3</option>
					<option >4</option>
					<option >5</option>
					<option >6</option>
					<option >7</option>
					<option >8</option>
					<option >9</option>
					<option >10</option>
					<option >11</option>
					<option >12</option>
				</select>
				<select name="date" id="date" >
					<option >=请选择日期=</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>家庭住址：</th>
			<td><textarea name="useraddress" style="margin:0px;width:290px;height:20px;"></textarea></td>
		</tr>
		<tr>
			<th>所属部门：</th>
			<td>
				<select name="userdept" id=""userdept"" >
					<option >=请选择部门=</option>
					<option >研发部</option>
					<option >人力资源部</option>
					<option >销售部</option>
					<option >后勤部</option>
				</select>
			</td>
		</tr>>
  </table>
  </div>
  <hr>
  <div align="center"><input type="image" src="../image/ok-32.png" width="50px" height="30px">&nbsp;&nbsp;<input type="image" src="../image/cancel.png" onclick="reset()" width="70px" height="30px"></div>
</form>
</body>

<script type="text/javascript">

//去空格
	function trim(str)
	{
		return str.replace(/\s+/g,"");
	}

	

	//验证用户编号合法性
	function checkUserId(){
		var userIdNode = document.getElementById("userid");
		var userIdSpan = document.getElementById("userIdSpan");
		var userId = trim(userIdNode.value);
		var reg =/^[0-9]{6}$/i;
		if(reg.test(userId)){
			//userIdSpan.innerHTML=("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"*格式正确*").fontcolor("green");
			userIdSpan.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../image/sign-check-icon.png" width="20px" height="20px" name="格式正确">';
			return true;
		}else{
			userIdSpan.innerHTML=('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../image/sign-error-icon.png" width="20px" height="20px" name="格式错误">*必须为年份+部门号+编号的格式*').fontcolor("red");
			return false;
		}
	}

	  //检验用户姓名的合法性
	  /* function checkUserName()
	  {
		  var userNameNode= document.getElementById("username");
		  var userNameSpan = document.getElementById("userNameSpan");
		  var userName = trim(userNameNode.value);
		  //验证用户姓名的格式
		  var reg =/^[a-z][a-z0-9]{5}$/i;
		  if(reg.test(userName))
		  {
			 //符合
			 userNameSpan.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="image/sign-check-icon.png" width="20px" height="20px" name="格式正确">';
			 return true;
		  }else
		  {
			  userNameSpan.innerHTML=('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="image/sign-error-icon.png" width="20px" height="20px" name="格式错误">*必须以字母开始,长度是6位.*').fontcolor("red");
			  return false;
		  }
	  } */

	  	  //检验密码的合法性
	  function checkPassword()
	  {
		  var passwordNode= document.getElementById("userpassword");
		  var passwordSpan = document.getElementById("passwordSpan");
		  var password = trim(passwordNode.value);
		  //验证用户姓名的格式
		  var reg =/^[a-zA-Z0-9]{6,}$/i;
		  if(reg.test(password))
		  {
			 //符合
			 passwordSpan.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../image/sign-check-icon.png" width="20px" height="20px" name="格式正确">';
			 return true;
		  }else
		  {
			  passwordSpan.innerHTML=('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../image/sign-error-icon.png" width="20px" height="20px" name="格式错误">*您的密码安全性较低，请设置安全性高的密码(至少6位)*').fontcolor("red");
			  return false;
		  }
	  }

	  //验证再次输入密码
	  function checkPassword1()
	  {
		  var passwordNode= document.getElementById("userpassword");
		  var password = trim(passwordNode.value);
		  var passwordNode1= document.getElementById("userpassword1");
		  var passwordSpan1 = document.getElementById("passwordSpan1");
		  var password1 = trim(passwordNode1.value);
		  if(password==password1)
		  {
			 //符合
			 passwordSpan1.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../image/sign-check-icon.png" width="20px" height="20px" name="格式正确">';
			 return true;
		  }else if(password1==null){
			  passwordSpan1.innerHTML=('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../image/sign-error-icon.png" width="20px" height="20px" name="格式错误">*请先输入密码*').fontcolor("red");			  
		  }else
		  {
			  passwordSpan1.innerHTML=('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../image/sign-error-icon.png" width="20px" height="20px" name="格式错误">*您的输入与上次不一致，请重新输入*').fontcolor("red");
			  return false;
		  }
	  }

	  	  //检验邮箱的合法性
	  function checkEmail()
	  {
		  var emailNode= document.getElementById("useremail");
		  var emailSpan = document.getElementById("emailSpan");
		  var email = trim(emailNode.value);
		 //"@"可以表示为"\x40","."可以表示为"\x2e",一个字母或数字可以用"\w"来表示,重复一次或多次"+"
		  //var reg =/^\w+\x40\w+\x2e\w+$/i;
		 var reg =/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,4}$/;
		  if(reg.test(email))
		  {
			 //符合
			 emailSpan.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../image/sign-check-icon.png" width="20px" height="20px" name="格式正确">';
			 return true;
		  }else
		  {
			  emailSpan.innerHTML=('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../image/sign-error-icon.png" width="20px" height="20px" name="格式错误">*请输入正确的邮箱格式*').fontcolor("red");
			  return false;
		  }
	  }

	  	//检验手机的合法性
	  function checkPhone()
	  {
		  var phoneNode= document.getElementById("userphone");
		  var phoneSpan = document.getElementById("phoneSpan");
		  var phone = trim(phoneNode.value);
		 //
		  var reg =/^[1][3,5,8][0-9]{9}$/i;
		  if(reg.test(phone))
		  {
			 //符合
			 phoneSpan.innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../image/sign-check-icon.png" width="20px" height="20px" name="格式正确">';
			 return true;
		  }else
		  {
			  phoneSpan.innerHTML=('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../image/sign-error-icon.png" width="20px" height="20px" name="格式错误">*请输入正确的11位手机号码*').fontcolor("red");
			  return false;
		  }
	  }

	  //出生日期的选择（级联操作）(1992,1996,2000是闰年2月有29天)
		function showBirthday(){
			//获取页面表单的年、月
			var yearNode=document.getElementById("year");
			var monthNode=document.getElementById("month");
			//数据类型转换
			var year=parseInt(yearNode.value);
			var month=parseInt(monthNode.value);
			//进行判断
			if (year%4==0) {
		//		dateNode.options.length=1;
				if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
					var dateNode=document.getElementById("date");
					dateNode.options.length=1;
					for(var i=1;i<32;i++){
						var optionNode = document.createElement("option");
				    	optionNode.innerHTML=i;
						dateNode.appendChild(optionNode);
					}
				}else if(month==4||month==6||month==9||month==11){
					var dateNode=document.getElementById("date");
					dateNode.options.length=1;
					for(var i=1;i<31;i++){
						var optionNode = document.createElement("option");
				    	optionNode.innerHTML=i;
						dateNode.appendChild(optionNode);
					}
				}else{
					var dateNode=document.getElementById("date");
					dateNode.options.length=1;
					for(var i=1;i<30;i++){
						var optionNode = document.createElement("option");
				    	optionNode.innerHTML=i;
						dateNode.appendChild(optionNode);
					}
				}
			} else{
				if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
					var dateNode=document.getElementById("date");
					dateNode.options.length=1;
					for(var i=1;i<32;i++){
						var optionNode = document.createElement("option");
				    	optionNode.innerHTML=i;
						dateNode.appendChild(optionNode);
					}
				}else if(month==4||month==6||month==9||month==11){
					var dateNode=document.getElementById("date");
					dateNode.options.length=1;
					for(var i=1;i<31;i++){
						var optionNode = document.createElement("option");
				    	optionNode.innerHTML=i;
						dateNode.appendChild(optionNode);
					}
				}else{
					var dateNode=document.getElementById("date");
					dateNode.options.length=1;
					for(var i=1;i<29;i++){
						var optionNode = document.createElement("option");
				    	optionNode.innerHTML=i;
						dateNode.appendChild(optionNode);
					}
				}
			}
		}
		
		
		/* //地址级联操作
		//声明省
		var pres = ["北京", "河北", "天津","浙江","四川","山西","云南"]; //直接声明Array
		//声明市
		var cities = [
		    ["朝阳区","东城区","西城区","海淀区","房山区"],
		    ["石家庄","唐山","秦皇岛","邯郸"],
		    ["东丽区","和平区","塘沽区","大港区","武清区"],
		    ["杭州","温州","金华","绍兴","丽水"],
		    ["成都","绵阳","德阳","广元"],
		    ["太原","大同","运城","临汾"],
		    ["昆明","大理","丽江"],
		];
		var areas = [
		    [
		        ['市辖区','密云县','延庆县'],
		        ['市辖区','密云县','延庆县'],
		        ['市辖区','密云县','延庆县'],
		        ['市辖区','密云县','延庆县'],
		        ['市辖区','密云县','延庆县']
		    ],
		    [
		        ['市辖区','长安区','桥东区','桥西区','新华区','井陉矿区'],
		        ['市辖区','路南区','路北区','古冶区','开平区','丰南区','丰润区'],
		        ['市辖区','海港区','山海关区','北戴河区','青龙满族自治县','昌黎县'],
		        ['市辖区','邯山区','丛台区','复兴区','峰峰矿区','邯郸县','临漳县']
		    ],
		    [
		        ['市辖区','宁河县','静海县','蓟　县'],
		        ['市辖区','宁河县','静海县','蓟　县'],
		        ['市辖区','宁河县','静海县','蓟　县'],
		        ['市辖区','宁河县','静海县','蓟　县'],
		        ['市辖区','宁河县','静海县','蓟　县']
		    ],
		    [
		        ['市辖区','上城区','下城区','江干区','拱墅区','西湖区'],
		        ['市辖区','鹿城区','龙湾区','瓯海区','洞头县','永嘉县'],
		        ['市辖区','婺城区','金东区','武义县','浦江县','磐安县'],
		        ['市辖区','越城区','绍兴县','新昌县','诸暨市'],
		        ['市辖区','莲都区','青田县','缙云县','遂昌县','松阳县']
		    ],
		    [
		        ['市辖区','锦江区','青羊区','金牛区','武侯区','成华区'],
		        ['市辖区','涪城区','游仙区','三台县','盐亭县','安　县'],
		        ['市辖区','旌阳区','中江县','罗江县','广汉市','什邡市'],
		        ['市辖区','市中区','元坝区','朝天区','旺苍县','青川县']
		    ],
		    [
		        ['市辖区','小店区','迎泽区','杏花岭区','尖草坪区','万柏林区','晋源区'],
		        ['市辖区','城　区','矿　区','南郊区','新荣区','阳高县','天镇县','广灵县'],
		        ['市辖区','盐湖区','临猗县','万荣县','闻喜县','稷山县','新绛县','绛　县'],
		        ['市辖区','尧都区','曲沃县','翼城县','襄汾县','洪洞县','古　县','安泽县','浮山县']
		    ],
		    [
		        ['市辖区','龙亭区','顺河回族区','鼓楼区','南关区'],
		        ['市辖区','龙亭区','顺河回族区','鼓楼区'],
		        ['市辖区','老城区','西工区','廛河回族区','涧西区']
		    ]
		]
		//设置一个省的公共下标
		var pIndex = -1;
		var preEle = document.getElementById("pre");
		var cityEle = document.getElementById("city");
		var areaEle = document.getElementById("area");
		//先设置省的值
		for (var i = 0; i < pres.length; i++) {
		    //声明option.<option value="pres[i]">Pres[i]</option>
		    var op = new Option(pres[i], i);
		    //添加
		    preEle.options.add(op);
		}
		function chg(obj) {
		    if (obj.value == -1) {
		        cityEle.options.length = 0;
		        areaEle.options.length = 0;
		    }
		    //获取值
		    var val = obj.value;
		    pIndex = obj.value;
		    //获取ctiry
		    var cs = cities[val];
		    //获取默认区
		    var as = areas[val][0];
		    //先清空市
		    cityEle.options.length = 0;
		    areaEle.options.length = 0;
		    for (var i = 0; i < cs.length; i++) {
		        var op = new Option(cs[i], i);
		        cityEle.options.add(op);
		    }
		    for (var i = 0; i < as.length; i++) {
		        var op = new Option(as[i], i);
		        areaEle.options.add(op);
		    }
		}
		function chg2(obj) {
		    var val = obj.selectedIndex;
		    var as = areas[pIndex][val];
		    areaEle.options.length = 0;
		    for (var i = 0; i < as.length; i++) {
		        var op = new Option(as[i], i);
		        areaEle.options.add(op);
		    }
		} */
</script>
</html>