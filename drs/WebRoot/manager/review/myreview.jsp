<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ReviewDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path %>/easyui/locale/easyui-lang-zh_CN.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的评论</title>
</head>
<body>
<table class="table">
   <thead>
      <tr>
         <th>我的评论</th>
      </tr>
   </thead>
	<tbody>
	<% 
	ReviewDao rd = new ReviewDao();
	//String[] ReviewInfo;
	String name = (String)session.getAttribute("username");
	List<String> ReviewInfo = rd.findByUserName(name); 
	int i=0;
	for(;i<ReviewInfo.size();i++){
	%>
	<td>
 	<%=ReviewInfo.get(i)%>
 	<%
	}
 	%>
 	</td>
</table>
 <form action="../../ReviewDelServlet" method="get">
 	<br><br>请在此输入需要删除的评论(输入评论ID)：<br>
 	<input type="text" name="review_id" />
 	<input type="submit" value="提交"/>
 </form>
</body>
</html>