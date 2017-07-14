<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.BusinessDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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
 <font size="4">查询结果</font>
 </h1>
<% 
	List<String> businessInfo = (List<String>)session.getAttribute("result"); 
	int i=0;
	for(;i<businessInfo.size();i++){
%>
 <li>
 <font size="4">
 <%=businessInfo.get(i)%>
 </font>
 </li>
 <br>
 <br>
 <%
	}
 %>
</body>
</html>