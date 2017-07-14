<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.BusinessDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>酒店列表</title>
</head>
<body>
 <h1>
 <font size="4">酒店名称</font>
 </h1>
<% 
	BusinessDao bd = new BusinessDao();
	String[] businessname;
	businessname = bd.findBusinessName(); 
	int i=0;
	for(;i<businessname.length;i++){
%>
 <li>
 <font size="4">
 <%=businessname[i]%>
 </font>
 </li>
 <%
	}
 %>
 <form action="../../BusinessDelServlet" method="get">
 	<br><br>请在此输入需要删除的酒店名称：<br>
 	<input type="text" name="businessname" />
 	<input type="submit" value="提交"/>
 </form>
</body>
</html>