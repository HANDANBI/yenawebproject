<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.vo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����ȭ��</title>
<style type="text/css">
	#mydiv{
		margin: 100px 100px 100px 100px;
		font-size:1.5em;
	}
</style>
</head>
<body>
<%
	LoginVO res = (LoginVO)request.getAttribute("mylogin");



%>
<div id="mydiv">
		<form action = "/Day50/mupdate" method="post">
			ID : <input type="text" name="id" readonly="readonly" 
							value=<%=res.getId()%> /><br/>
			name : <input type="text" name="name" value=<%=res.getName()%> /><br/> 
			email: <input type="text" name="email" value=<%=res.getEmail()%> /><br/>
			<input type="submit" value="����"/>
			<input type="reset" value="���"/>
		</form>
	</div>
</body>
</html>