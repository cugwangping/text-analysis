<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ReviewDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论列表</title>
</head>
<body>
 <h1>
 <font size="4">所有评论</font>
 </h1>
<% 
	ReviewDao rd = new ReviewDao();
	String[] ReviewInfo;
	ReviewInfo = rd.findAllReview(); 
	int i=0;
	for(;i<ReviewInfo.length;i++){
%>
 <li>
 <font size="4">
 <%=ReviewInfo[i]%>
 </font>
 </li>
 <br>
 <%
	}
 %>
 <form action="../../ReviewDelServlet" method="get">
 	<br><br>请在此输入需要删除的评论(输入评论ID)：<br>
 	<input type="text" name="review_id" />
 	<input type="submit" value="提交"/>
 </form>
</body>
</html>