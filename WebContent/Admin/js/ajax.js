function createAJAX()
{
    var ajax=null;
    try
    {
    	ajax= new ActiveXObject("micosoft.xmlhttp");
    }catch(ex)
    {
    	try
    	{
    		ajax = new XMLHttpRequest();
    	}catch(ex)
    	{
    		alert("����ǰ��������ں˲�֧��ajax,����������........");
    	}	
    }
    
    return ajax;
}