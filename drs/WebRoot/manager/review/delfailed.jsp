<%@ page contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>评论失败提醒</title>
<script language="javascript">
var count = 5;//记数器

function countdown()
{ 
count--;

if(count == 1)
{
window.location.href='reviewlist.jsp';
}

if(document.layers)
{   
document.layers.showtime.document.write(count);   
document.layers.showtime.document.close();   
}   
else if(document.all)
{
showtime.innerHTML=count+" 秒后自动返回 ...";
}

setTimeout("countdown()",1000);   
}   
</script>

</head>
<body bgcolor="#F4F6F6" onLoad="countdown();">
<center>
<span id="showtime"></span>
</center>
<h1 align="center">删除评论失败......
</h1>
</body>
</html>