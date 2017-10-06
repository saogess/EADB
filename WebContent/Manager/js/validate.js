
//去空格
function trim(str){
     return str.replace(/\s+/g,"");
 }

//检验用户ID的合法性
function checkUserId(){
	var userIdNode= document.getElementById("userId");
	var userIdSpan = document.getElementById("userIdSpan");
	var userId = trim(userIdNode.value);
	//验证用户ID的格式
	var reg =/^[0-9]{2}[a-z]{2}[0-9]{2}$/i;
	if(reg.test(userId)){
		//符合
		userIdSpan.innerHTML="格式正确!".fontcolor("blue");
		return true;
	}else{
		userIdSpan.innerHTML="格式错误！(以字母开始长度为7位)".fontcolor("red");
		return false;
	}
}

//验证用户名不能为空
function checkUserName(){
	var userNameNode=document.getElementById("userName");
	var userNameSpan=document.getElementById("userNameSpan");
	var userName=trim(userNameNode.value);
	//验证用户名不能为空
	if(userName==""){
		userNameSpan.innerHTML="用户名不能为空！".fontcolor("red");
		return false;
	}else{
		userNameSpan.innerHTML="输入正确！".fontcolor("blue");
		return true;
	}
}

//确认密码的操作
function checkUserPassword(){
	var userPassword_1=document.getElementById("password_1");
	var userPassword_2=document.getElementById("password_2");
	var password_2_Span=document.getElementById("password_2_Span");
	var password_1=trim(userPassword_1.value);
	var password_2=trim(userPassword_2.value);
	//验证密码是否一致
	if(password_1==password_2){
//		password_2_Span.innerHTML=/img/right.png;
		password_2_Span.innerHTML="密码正确！".fontcolor("blue");
		return true;
	}else{
		password_2_Span.innerHTML="输入有误！请重新输入！".fontcolor("red");
		return false;
	}
}

//验证用户邮箱的正确格式
function  checkUserMail(){
	var userMailNode=document.getElementById("userMail");
	var userMailSpan=document.getElementById("userMailSpan");
	var userMail=trim(userMailNode.value);
	//验证邮箱的正确格式
	var reg =/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,4}$/;
	if(reg.test(userMail)){
		//符合要求
		userMailSpan.innerHTML="格式正确！".fontcolor("blue");
		return true;
	}else{
		userMailSpan.innerHTML="格式有误！请重新输入！".fontcolor("red");
		return false;
	}
}

//验证用户手机的正确格式
function  checkUserPhone(){
	var userPhoneNode=document.getElementById("Phone");
	var userPhoneSpan=document.getElementById("PhoneSpan");
	var userPhone=trim(userPhoneNode.value);
	//验证邮箱的正确格式
	var reg =/^(((1[0-9][0-9]{1}))+\d{8})$/;
	if(reg.test(userPhone)){
		//符合要求
		userPhoneSpan.innerHTML="格式正确！".fontcolor("blue");
		return true;
	}else{
		userPhoneSpan.innerHTML="格式有误！请重新输入！".fontcolor("red");
		return false;
	}
}

//生日的级联操作
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

//家庭住址的级联操作
var citys=[[],["朝阳区","东城区","西城区","海淀区","房山区","大兴区"],["黄浦区","静安区","徐汇区","长宁区","虹口区","普陀区","浦东新区"],
["广州市","深圳市","珠海市","汕头市","韶关市","佛山市","东莞市"],["太原","大同","运城","临汾","朔州"],["成都","绵阳","德阳","广元"]];

function showCity()
{
	//省
	var provienceNode= document.getElementById("Province");
	//获取选重项
	var selectedIndex =provienceNode.selectedIndex;
	//根据索引值查找城市
	var cityDates = citys[selectedIndex];
	var cityNode =document.getElementById("City");
	//只是选择第一项
	cityNode.options.length=1;
	for(var i=0;i<cityDates.length;i++){
		//<option>value</option>
		var optionNode = document.createElement("option");
		optionNode.innerHTML=cityDates[i];
		cityNode.appendChild(optionNode);
	}
}