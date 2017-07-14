<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>密码修改</title>
</head>
<body>
<center>  
<h1>密码修改</h1>  
<form class="form-horizontal" role="form" action="PasswordChangeServlet" method="post">
  <div class="form-group">
	<label for="newpass" class="col-sm-3 control-label">新密码</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="newpass" name="password" placeholder="请输入新密码">
    </div>
  </div>
  <div class="form-group">
    <label for="agpsw" class="col-sm-3 control-label">确认新密码</label>
    <div class="col-sm-5"><input type="text" class="form-control" id="agpsw" name="passwordAgain" placeholder="请确认新密码">
    </div>
  </div>
    <div class="form-group">
    <div>
      <button type="submit" class="btn btn-default col-sm-offset-3 col-sm-1">确定</button>
      <button type="reset" class="btn btn-default col-sm-offset-3 col-sm-1">重置</button>
    </div>
  </div>
</form> 
</center> 
</body>
</html>