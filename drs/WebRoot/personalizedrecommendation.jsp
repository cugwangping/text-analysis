<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.BusinessDao" %>
<%@ page import="dao.UserDao" %>
<%@ page import="personalrecom.PersonalRecommend" %>
<%@ page import="java.util.List" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个性化推荐</title>
</head>
<body>
 <h1>
 <font size="4">根据个人爱好推荐的酒店信息列表</font>
 </h1>
<% 	
	String username = (String)session.getAttribute("username");
	UserDao ud = new UserDao();
	String userID = ud.findUserID(username);
	//String userID = "_j1KnsWLVz3AU1mmm0G0";
	PersonalRecommend pr = new PersonalRecommend();
	List<String> businessID = pr.execPython(userID);
	BusinessDao bd = new BusinessDao();
	int i=0;
	for(;i<businessID.size();i++){
%>
 <li>
 <font size="4">
 <%=bd.findBusinessByID(businessID.get(i))%>
 </font>
 </li>
 <br>
 <%
	}
 %>
</body>
</html>