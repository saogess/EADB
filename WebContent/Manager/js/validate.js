
//ȥ�ո�
function trim(str){
     return str.replace(/\s+/g,"");
 }

//�����û�ID�ĺϷ���
function checkUserId(){
	var userIdNode= document.getElementById("userId");
	var userIdSpan = document.getElementById("userIdSpan");
	var userId = trim(userIdNode.value);
	//��֤�û�ID�ĸ�ʽ
	var reg =/^[0-9]{2}[a-z]{2}[0-9]{2}$/i;
	if(reg.test(userId)){
		//����
		userIdSpan.innerHTML="��ʽ��ȷ!".fontcolor("blue");
		return true;
	}else{
		userIdSpan.innerHTML="��ʽ����(����ĸ��ʼ����Ϊ7λ)".fontcolor("red");
		return false;
	}
}

//��֤�û�������Ϊ��
function checkUserName(){
	var userNameNode=document.getElementById("userName");
	var userNameSpan=document.getElementById("userNameSpan");
	var userName=trim(userNameNode.value);
	//��֤�û�������Ϊ��
	if(userName==""){
		userNameSpan.innerHTML="�û�������Ϊ�գ�".fontcolor("red");
		return false;
	}else{
		userNameSpan.innerHTML="������ȷ��".fontcolor("blue");
		return true;
	}
}

//ȷ������Ĳ���
function checkUserPassword(){
	var userPassword_1=document.getElementById("password_1");
	var userPassword_2=document.getElementById("password_2");
	var password_2_Span=document.getElementById("password_2_Span");
	var password_1=trim(userPassword_1.value);
	var password_2=trim(userPassword_2.value);
	//��֤�����Ƿ�һ��
	if(password_1==password_2){
//		password_2_Span.innerHTML=/img/right.png;
		password_2_Span.innerHTML="������ȷ��".fontcolor("blue");
		return true;
	}else{
		password_2_Span.innerHTML="�����������������룡".fontcolor("red");
		return false;
	}
}

//��֤�û��������ȷ��ʽ
function  checkUserMail(){
	var userMailNode=document.getElementById("userMail");
	var userMailSpan=document.getElementById("userMailSpan");
	var userMail=trim(userMailNode.value);
	//��֤�������ȷ��ʽ
	var reg =/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,4}$/;
	if(reg.test(userMail)){
		//����Ҫ��
		userMailSpan.innerHTML="��ʽ��ȷ��".fontcolor("blue");
		return true;
	}else{
		userMailSpan.innerHTML="��ʽ�������������룡".fontcolor("red");
		return false;
	}
}

//��֤�û��ֻ�����ȷ��ʽ
function  checkUserPhone(){
	var userPhoneNode=document.getElementById("Phone");
	var userPhoneSpan=document.getElementById("PhoneSpan");
	var userPhone=trim(userPhoneNode.value);
	//��֤�������ȷ��ʽ
	var reg =/^(((1[0-9][0-9]{1}))+\d{8})$/;
	if(reg.test(userPhone)){
		//����Ҫ��
		userPhoneSpan.innerHTML="��ʽ��ȷ��".fontcolor("blue");
		return true;
	}else{
		userPhoneSpan.innerHTML="��ʽ�������������룡".fontcolor("red");
		return false;
	}
}

//���յļ�������
function showBirthday(){
	//��ȡҳ������ꡢ��
	var yearNode=document.getElementById("year");
	var monthNode=document.getElementById("month");
	//��������ת��
	var year=parseInt(yearNode.value);
	var month=parseInt(monthNode.value);
	//�����ж�
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

//��ͥסַ�ļ�������
var citys=[[],["������","������","������","������","��ɽ��","������"],["������","������","�����","������","�����","������","�ֶ�����"],
["������","������","�麣��","��ͷ��","�ع���","��ɽ��","��ݸ��"],["̫ԭ","��ͬ","�˳�","�ٷ�","˷��"],["�ɶ�","����","����","��Ԫ"]];

function showCity()
{
	//ʡ
	var provienceNode= document.getElementById("Province");
	//��ȡѡ����
	var selectedIndex =provienceNode.selectedIndex;
	//��������ֵ���ҳ���
	var cityDates = citys[selectedIndex];
	var cityNode =document.getElementById("City");
	//ֻ��ѡ���һ��
	cityNode.options.length=1;
	for(var i=0;i<cityDates.length;i++){
		//<option>value</option>
		var optionNode = document.createElement("option");
		optionNode.innerHTML=cityDates[i];
		cityNode.appendChild(optionNode);
	}
}