<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>登录界面</title>
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">    
  </head>  
    
  <body>  
<center>  
<div>  
<h1>欢迎登陆</h1>  
<form class="form-horizontal" role="form" action="LoginServlet" method="post">
  <div class="form-group">
	<label for="usern" class="col-sm-4 control-label">用户名</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" id="usern" name="username" placeholder="请输入用户名">
    </div>
  </div>
  <div class="form-group">
    <label for="psw" class="col-sm-4 control-label">密码</label>
    <div class="col-sm-3"><input type="text" class="form-control" id="psw" name="password" placeholder="请输入密码">
    </div>
  </div>
  <div class="form-group">
    <label for="psw" class="col-sm-4 control-label">验证码</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" id="verify" name="verifycode" placeholder="请输入验证码">
    </div>
   </div>
   <div class="form-group">
     <label for="pic" class="col-sm-4 control-label"></label>
    <div class="col-sm-5">
      <script type="javascript">  
      function change(){  
          var img =document.getElementById("verify");  
          img.src="VerifyCodeServlet?a="+new Date().getTime();  
      }  
    </script>
    <a href="javascript:change()"><img src="VerifyCodeServlet" id="verify" border="0"></a>
    </div>
  </div>
  <div class="form-group">
    <div>
      <button type="submit" class="btn btn-default col-sm-offset-4 col-sm-1">登录</button>
	  <button type="reset" class="btn btn-default col-sm-offset-1 col-sm-1">重置</button>
    </div>
    <a href="register.jsp"><font size="2"><i>没有帐号？点击注册</i></font></a>
  </div>
</form> 
</center>  
  </body>  
</html>  