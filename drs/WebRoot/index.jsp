<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="dao.BusinessDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
    String[] weekdays={"","sunday","monday","tuesday","wendnesday","thursday","friday","staurday"};
    String[] days=new String[42];
    for(int i=0;i<42;i++)
    	days[i]="";
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date());
    int year=calendar.get(Calendar.YEAR);
    int month=calendar.get(Calendar.MONTH);
    int today=calendar.get(Calendar.DAY_OF_MONTH);
    int weekday=calendar.get(Calendar.DAY_OF_WEEK);   
    String now=year+"/"+(month+1)+"/"+today+" "+" "+weekdays[weekday];
%>

<html>
  <head>
     <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path %>/easyui/locale/easyui-lang-zh_CN.js"></script>
    <title>基于文本分析的酒店推荐系统</title>
	<script type="text/javascript">
		function openUrl(url){
	       window.open(url);
	   }
		function showTime(showWhere){
            var now=new Date();
	        var hour=now.getHours();
	        var minu=now.getMinutes();
	        var sec=now.getSeconds();
         
            if(hour<10) hour="0"+hour;
         	if(minu<10) minu="0"+minu;
         	if(sec<10) sec="0"+sec;
         	
         	showWhere.value=hour+":"+minu+":"+sec;
            setTimeout("showTime(time)",1000);
        }
    </script>
  <img src="images/top.gif" class="img-rounded" width="100%" height="35%"> 
  </head>
  <body onload="showTime(time)">
  	<center>
  	 
  <ul class="nav nav-pills">
  	<li><a href="#"><%=now%></a><input type="text" id="time" size=9 readonly="readonly"></li>
	<li class="active col-sm-2"><a href="index.jsp"><b>主页</b></a></li>
	<li class="col-sm-2"><a href="login.jsp"><b>登录</b></a></li>
	<li class="col-sm-2"><a href="register.jsp"><b>注册</b></a></li>
	<li class="col-sm-3"><a href="login.jsp"><b>我的评论</b></a></li>
	</ul>
  <form class="form-horizontal" role="form" action="/user/search.do">
  <div class="form-group">
	<input type="hidden" name="method" value="post">
    <div class="col-sm-offset-7 col-sm-5">
    	您好:游客！请先登录。
    </div>
  </div>
</form> 
</center>
<table class="table">
   <thead>
      <tr>
         <th>酒店</th>
         <th>评论</th>
      </tr>
   </thead>
	<% 
	BusinessDao bd = new BusinessDao();
	String[] businessname;
	businessname = bd.findAllBusinessName(); 
	int i=0;
	for(;i<businessname.length;i++){
	%>
	<tbody>
	<td>
 	<%=businessname[i]%>
 	</td>
 	<td>
 	<a onclick="openUrl('login.jsp')"><font color="#FF0000">评论</font></a>
	 </td>
 	<%
	}
 	%>
</table>
  </body>
</html>
