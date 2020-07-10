<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*,com.vo.LoginVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	List<LoginVO> all = (List<LoginVO>)request.getAttribute("mall");
	
	%>
<div style="margin: 100px 100px 100px 100px; font-size : 1.5em;">
	<table border= "1">
	<tr><th>id</th><th>pw</th><th>name</th><th>email</th><th>addr</th>
	<th>수정</th>
	<th>삭제</th>
	</tr>
	<%for(LoginVO res : all){%>
	<tr><td><%=res.getId() %></td>	
		<td><%=res.getPw() %></td>
		<td><%=res.getName() %></td>
		<td><%=res.getEmail() %></td>
		<td><a href="mfind?no=<%=res.getId() %>">수정</a></td>	
		<td><a href="mdelete?no=<%=res.getId() %>">삭제</a></td>	
		<%} %>
	</tr>
	</table>
		<a href='<%=application.getContextPath()%>'> 홈으로 </a><br/>
		<a href='<%=application.getContextPath()%>/member/insert.html'> 회원가입 </a><br/><br/>
</div>
</body>
</html>