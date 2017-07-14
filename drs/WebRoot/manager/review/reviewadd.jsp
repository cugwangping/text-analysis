<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/myjs.js"></script>
	 <script type="text/javascript" src="<%=path %>/easyui/locale/easyui-lang-zh_CN.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论添加</title>

</head>
<body>
<center>   
<form class="form-horizontal" role="form" action="../../AddReviewServlet" method="post">
  <div class="form-group">
	<label for="reviewID" class="col-sm-3 control-label">评论ID</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="reviewID" name="reviewID" placeholder="请输入评论ID">
    </div>
  </div>
  <div class="form-group">
    <label for="businessname" class="col-sm-3 control-label">酒店名</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="businessname" name="businessname" placeholder="请输入酒店名">
    </div>
   </div>
   <div class="form-group">
    <label for="stars" class="col-sm-3 control-label">评价星级</label>
    <div class="col-sm-5">
  <input type="radio" name="stars" value="0" checked>0★
  <input type="radio" name="stars" value="1">1★
  <input type="radio" name="stars" value="2">2★
  <input type="radio" name="stars" value="3">3★
  <input type="radio" name="stars" value="4">4★
  <input type="radio" name="stars" value="5">5★
    </div>
   </div>
   <div class="form-group">
    <label for="businessname" class="col-sm-3 control-label">内容</label>
    <div class="col-sm-5">
		<textarea name="content" style="width:50%;height:80px;"></textarea>
    </div>
   <div class="col-sm-offset-3 col-sm-1"> 
      <button type="submit" class="btn btn-default">确定</button>
      <button type="reset" class="btn btn-default">重置</button>
    </div>
  </div>
</form> 
</center>  
</body>
</html>