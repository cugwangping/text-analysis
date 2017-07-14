<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.UserDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
 <h1>
 <font size="4">用户名</font>
 </h1>
<% 
	UserDao ud = new UserDao();
	String[] username;
	username = ud.findAllUserName(); 
	int i=0;
	for(;i<username.length;i++){
%>
 <li>
 <font size="4">
 <%=username[i]%>
 </font>
 </li>
 <%
	}
 %>
 <form action="UserDelServlet" method="get">
 	请在此输入需要删除的用户的用户名(admin用户不可删除)<br>
 	<input type="text" name="username" />
 	<input type="submit" value="提交"/>
 </form>
</body>
</html>