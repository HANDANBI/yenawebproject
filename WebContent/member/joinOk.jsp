<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.vo.*,com.dao.*, com.biz.*" %>
<%@ page import="java.io.PrintWriter" %>

<%request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String path = application.getContextPath();
	String myID = request.getParameter("id");
	String myName = new LoginBIZ().getName(myID);
%>
	<h1> �α��� ����! ^0^</h1>
	<h2> ID : <%=myID %></h2>
	<h2> Name : <%=myName %></h2>
	<a href= '<%=path%>/login/login2.jsp'>�α����Ϸ� ����</a>
</body>
</html>