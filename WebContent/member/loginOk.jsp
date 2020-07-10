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
	
	session.setAttribute("MyID", myID);
	session.setAttribute("MyName", myName);
	
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println(" location.href = '" + path + "/login/main.jsp'");
	script.println("</script>");
%>
</body>
</html>