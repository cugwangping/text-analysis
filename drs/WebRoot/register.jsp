<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
   	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    <title>注册页面</title>
    <script src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript">
    function validatorName(object){
    var username = $(object).val();
    $.ajax(
    {
    	type:"POST",
    	url:"CheckUserNameServlet?username="+username,
    	data:name,
    	success:function(data){
    		if(data=="true"){
    			var msg1 = document.getElementById("showmessage");
    			msg1.innerHTML ="✔用户名可用！";
    		}
    		else{
    			var msg2 = document.getElementById("showmessage");
    			msg2.innerHTML ="✘改用户名已被注册！";
    		}
    	}
    }
    );
    }
    
    function validatorNickName(object){
    var name = $(object).val();
    $.ajax(
    {
    	type:"POST",
    	url:"validatorNickname?username="+username,
    	data:name,
    	success:function(data){
    		if(data=="true"){
    			var msg3 = document.getElementById("showmessage1");
    			msg3.innerHTML ="can use this nickname";
    		}
    		else{
    			var msg4 = document.getElementById("showmessage1");
    			msg4.innerHTML ="the nickname has been used";
    		}
    	}
    }
    );
    }
    
    function validatorpassword(object){
    var apsw = $(object).val();
    var psw = document.getElementById("psw").value;
    $.ajax(
    {
    	type:"POST",
    	url:"validatorpassword?apsw="+apsw+"&psw="+psw,
    	data:[apsw,psw],
    	success:function(data){
    		if(data=="true"){
    			var msg5 = document.getElementById("showmessage2");
    			msg5.innerHTML ="two password is the same";
    		}
    		else{
    			var msg6 = document.getElementById("showmessage2");
    			msg6.innerHTML ="two password is different";
    		}
    	}
    }
    );
    }
    </script>
  </head>
  
  <body>
  <center>
<h1>欢迎注册</h1>  
<form class="form-horizontal" role="form" action="RegisterServlet" method="post">
  <div class="form-group">
	<label for="user" class="col-sm-3 control-label">用户名</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="user" name="username" onblur="validatorName(this)" placeholder="请输入用户名">
    </div>
     <div class="col-sm-3">
     	<span id="showmessage"></span>
    </div>
  </div>
  <div class="form-group">
  <label for="user" class="col-sm-3 control-label">帐号</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="user" name="userID" onblur="validatorName(this)" placeholder="请输入用户帐号">
    </div>
     <div class="col-sm-3">
     	<span id="showmessage"></span>
    </div>
  </div>
  <div class="form-group">
    <label for="psw" class="col-sm-3 control-label">密码</label>
    <div class="col-sm-5"><input type="text" class="form-control" id="psw" name="password" placeholder="请输入密码">
    </div>
  </div>
  <div class="form-group">
    <label for="agpsw" class="col-sm-3 control-label">确认密码</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="agpsw" name="againpassword" onblur="validatorpassword(this)" placeholder="请确认密码">
    </div>
    <div class="col-sm-1">
    <span id="showmessage2"></span>
    </div>
   </div>
  <div class="form-group">
    <div class="col-sm-offset-3 col-sm-1">
      <button type="submit" class="btn btn-default">确定</button>
    </div>
    <div class="col-sm-offset-3 col-sm-1">
      <button type="reset" class="btn btn-default">重置</button>
    </div>
  </div>
</form> 
</center>
  </body>
</html>
