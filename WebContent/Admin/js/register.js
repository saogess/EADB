//ȥ�ո�
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
        userNameSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='�û�������Ϊ��.'>";
        return false;
    }else
    {
        userNameSpan.innerHTML="";
        return true;
    }


    return true;
}

//�����û��ĺϷ���
function checkUserName()
{
    var userNameNode= document.getElementById("userName");
    var userNameSpan = document.getElementById("userNameSpan");
    var userName = trim(userNameNode.value);
    //��֤�û������ĸ�ʽ
    var reg =/^[a-z]{2}[a-z0-9]{4}$/i;
    if(reg.test(userName))
    {
        //����
        userNameSpan.innerHTML="&nbsp;&nbsp;&nbsp;<img src=\"image/great.png\" width=\"15\" height=\"15\">";
        return true;
    }else
    {
        userNameSpan.innerHTML=" &nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='��ʽ���󣺱�������ĸ��ʼ,������6λ.'>";
        return false;
    }
}
//��������Ϸ���
function checkPassWord() {
    var passWordNode= document.getElementById("passWord");
    var passWordSpan = document.getElementById("passWordSpan");
    var passWord = trim(passWordNode.value);
    //��֤�û������ĸ�ʽ
    var reg =/^[0-9]{6}$/i;
    if(reg.test(passWord))
    {
        //����
        passWordSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/great.png\" width=\"15\" height=\"15\">";
        return true;
    }else
    {
        passWordSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='��ʽ��������ȫΪ���֣�������6λ.'>";
        return false;
    }
}

//ȷ������Ϸ���
function checkConfirmPsw() {
    var passWordNode= document.getElementById("passWord");
    var passWord = trim(passWordNode.value);

    var confirmPswNode= document.getElementById("confirmPsw");
    var confirmPswSpan = document.getElementById("confirmPswSpan");
    var confirmPsw = trim(confirmPswNode.value);
    //��֤�û�����ĸ�ʽ
    var reg =/^[0-9]{6}$/i;

    if(reg.test(confirmPsw))
    {
        if(passWord==confirmPsw){
            //����
            confirmPswSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/great.png\" width=\"15\" height=\"15\">";
            return true;
        }else{
            confirmPswSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='���벻һ�£����������룡'>";
            return false;
        }
    }else
    {
        confirmPswSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='��ʽ��������ȫΪ���֣�������6λ.'>";
        return false;
    }
}
//��֤�绰
function checkMobile()
{
    var mobileNode = document.getElementById("mobile");
    var mobile = trim(mobileNode.value);
    var mobileSpan = document.getElementById("mobileSpan");
    var reg=/^[0]?(86)?1\d{10}$/;
    if(reg.test(mobile))
    {
        //����
        mobileSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/great.png\" width=\"15\" height=\"15\">";
        return true;
    }else
    {
        mobileSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='��ʽ���󣺱�������Ϸ����ֻ�����(11λ).'>";
        return false;
    }
}
//ͼƬ��ʾ
function showImage () {
    var r= new FileReader();
    f=document.getElementById('file').files[0];
    r.readAsDataURL(f);
    r.onload=function  (e) {
        document.getElementById('show').src=this.result;
    };
}

//����ͳ��
function countChar(textareaName,spanName)
{
    document.getElementById(spanName).innerHTML = 200 - document.getElementById(textareaName).value.length;
    if (document.getElementById(textareaName).value.length>200){
        document.getElementById(spanName).innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='�޷���������.'>";
        document.getElementById(textareaName).readonly='true';
    }
}
/*
  ʵ����֤�������
*/
function loadCode()
{
    createCode();
}
function createCode() {
    code = "";
    var codeLength = 5; //��֤��ĳ���
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
    spanCode.style.fontFamily = "������κ" ;
}
function validateCode()
{
    var inputCode = document.getElementById("inputCode").value;
    var loadCodeSpan = document.getElementById("loadCodeSpan");
    if (inputCode.length <= 0)
    {
        loadCodeSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='��������֤��.'>";
        return false;
    }
    else if (inputCode.toUpperCase() != code.toUpperCase())
    {
        loadCodeSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/error.png\" width=\"15\" height=\"15\" title='��֤���������������.'>";
        createCode();
        return false;
    }
    else
    {
        //����
        loadCodeSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"image/great.png\" width=\"15\" height=\"15\">";
        return true;
    }
}