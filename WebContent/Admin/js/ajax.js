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
    		alert("您当前的浏览器内核不支持ajax,请更换浏览器........");
    	}	
    }
    
    return ajax;
}