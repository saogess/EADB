//去空格
function trim(str)
{
    return str.replace(/\s+/g,"");
}


function validate()
{
    var userNameNode= document.getElementById("userName");
    var userNameSpan = document.getElementById("userNameSpan");
    var userName = trim(userNameNode.value);
    if(userName=='')
    {
        userNameSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='用户名不能为空.'>";
        return false;
    }else
    {
        userNameSpan.innerHTML="";
        return true;
    }


    return true;
}

//检验用户的合法性
function checkUserName()
{
    var userNameNode= document.getElementById("userName");
    var userNameSpan = document.getElementById("userNameSpan");
    var userName = trim(userNameNode.value);
    //验证用户姓名的格式
    var reg =/^[a-z]{2}[a-z0-9]{4}$/i;
    if(reg.test(userName))
    {
        //符合
        userNameSpan.innerHTML="&nbsp;&nbsp;&nbsp;<img src=\"image/great.png\" width=\"15\" height=\"15\">";
        return true;
    }else
    {
        userNameSpan.innerHTML=" &nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='格式错误：必须以字母开始,长度是6位.'>";
        return false;
    }
}
//检验密码合法性
function checkPassWord() {
    var passWordNode= document.getElementById("passWord");
    var passWordSpan = document.getElementById("passWordSpan");
    var passWord = trim(passWordNode.value);
    //验证用户姓名的格式
    var reg =/^[0-9]{6}$/i;
    if(reg.test(passWord))
    {
        //符合
        passWordSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/great.png\" width=\"15\" height=\"15\">";
        return true;
    }else
    {
        passWordSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='格式错误：密码全为数字，长度是6位.'>";
        return false;
    }
}

//确认密码合法性
function checkConfirmPsw() {
    var passWordNode= document.getElementById("passWord");
    var passWord = trim(passWordNode.value);

    var confirmPswNode= document.getElementById("confirmPsw");
    var confirmPswSpan = document.getElementById("confirmPswSpan");
    var confirmPsw = trim(confirmPswNode.value);
    //验证用户密码的格式
    var reg =/^[0-9]{6}$/i;

    if(reg.test(confirmPsw))
    {
        if(passWord==confirmPsw){
            //符合
            confirmPswSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/great.png\" width=\"15\" height=\"15\">";
            return true;
        }else{
            confirmPswSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='密码不一致，请重新输入！'>";
            return false;
        }
    }else
    {
        confirmPswSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='格式错误：密码全为数字，长度是6位.'>";
        return false;
    }
}
//验证电话
function checkMobile()
{
    var mobileNode = document.getElementById("mobile");
    var mobile = trim(mobileNode.value);
    var mobileSpan = document.getElementById("mobileSpan");
    var reg=/^[0]?(86)?1\d{10}$/;
    if(reg.test(mobile))
    {
        //符合
        mobileSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/great.png\" width=\"15\" height=\"15\">";
        return true;
    }else
    {
        mobileSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='格式错误：必须输入合法的手机号码(11位).'>";
        return false;
    }
}
//图片显示
function showImage () {
    var r= new FileReader();
    f=document.getElementById('file').files[0];
    r.readAsDataURL(f);
    r.onload=function  (e) {
        document.getElementById('show').src=this.result;
    };
}

//字数统计
function countChar(textareaName,spanName)
{
    document.getElementById(spanName).innerHTML = 200 - document.getElementById(textareaName).value.length;
    if (document.getElementById(textareaName).value.length>200){
        document.getElementById(spanName).innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='无法继续输入.'>";
        document.getElementById(textareaName).readonly='true';
    }
}
/*
  实现验证码的生成
*/
function loadCode()
{
    createCode();
}
function createCode() {
    code = "";
    var codeLength = 5; //验证码的长度
    var checkCode = document.getElementById("checkCode");
    var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    for (var i = 0; i < codeLength; i++)
    {
        var charNum = Math.floor(Math.random() * 52);
        code += codeChars[charNum];
    }
    if (checkCode)
    {
        checkCode.className = "code";
        checkCode.innerHTML = code;
    }
    var spanCode= document.getElementById("spanCode");
    spanCode.innerHTML=code;
    spanCode.style.fontSize="30px";
    spanCode.style.color="#000";
    spanCode.style.backgroundColor= "#E3E3E3";
    spanCode.style.textDecoration="line-through";
    spanCode.style.fontFamily = "华文新魏" ;
}
function validateCode()
{
    var inputCode = document.getElementById("inputCode").value;
    var loadCodeSpan = document.getElementById("loadCodeSpan");
    if (inputCode.length <= 0)
    {
        loadCodeSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='请输入验证码.'>";
        return false;
    }
    else if (inputCode.toUpperCase() != code.toUpperCase())
    {
        loadCodeSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='验证码错误，请重新输入.'>";
        createCode();
        return false;
    }
    else
    {
        //符合
        loadCodeSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/great.png\" width=\"15\" height=\"15\">";
        return true;
    }
}