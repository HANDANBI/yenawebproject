<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, com.vo.*, com.biz.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <title>게시판</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
 </head>
 <body>
 
 <%
 	request.setCharacterEncoding("euc-kr");
	List<BoardVO> all = (List<BoardVO>)request.getAttribute("ball");
 	int total = (int)request.getAttribute("bcount");
 	out.print("총 게시물 : " + total + "개");		
 %>
 
 <div class="container">
 	<div class="row">
 	<div class="col">
 		<table width="30%" align="left" cellpadding="10" cellspacing="0" border="0">
 	<tr><td >
 	<input type=button value="북적북적메인으로" class="btn btn-info" OnClick="window.location='login/main.jsp'" ></td></tr>
 	</table>
 <table width="30%" align="right" cellpadding="10" cellspacing="0" border="0">
  <tr><td colspan="4" height="5"></td></tr>
  <tr align="right">
  <td> 
   <input type=button value="글쓰기" class="btn btn-link" OnClick="window.location='board/input_board.jsp?mode=0'" ></td>
  </tr>
</table>
	</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<table width="90%" align="center" cellpadding="0" cellspacing="0" border="0">
  <tr height="5"><td width="5"></td></tr>
 <tr style="background:url('table_mid.gif') repeat-x; text-align:center;">
   <td width="5"><img src="table_left.gif" width="5" height="30" /></td>
   <td width="73">번호</td>
   <td width="200">제목</td>
   <td width="150">책 제목</td>
   <td width="73">작성자</td>
   <td width="164">작성일</td>
   <td width="58">추천수</td>
   <td width="7"><img src="table_right.gif" width="5" height="30" /></td>
  </tr>
<%
	if(total==0) {
%>
 	<tr align="center" bgcolor="#FFFFFF" height="30">
 	 <td colspan="6">등록된 글이 없습니다.</td>
 	</tr>
<%
 	} else {
 		for(BoardVO curVO : all)
 		{
%>
<tr height="25" align="center">
	<td>&nbsp;</td>
	<td><%=curVO.getBid() %></td>
	<td align="left"><a href="board/view_board.jsp?bid=<%=curVO.getBid()%>"><%=curVO.getTitle() %></td>
	<td align="left"><%=curVO.getBooktitle() %></td>
	<td align="center"><%=curVO.getBwriter() %></td>
	<td align="center"><%=curVO.getTime() %></td>
	<td align="center"><%=curVO.getGrade() %></td>
	<td>&nbsp;</td>
</tr>
  <tr height="1" bgcolor="#D2D2D2"><td colspan="7"></td></tr>
<% 
		}
	}
%>
 <tr height="1" bgcolor="#82B5DF"><td colspan="7" width="752"></td></tr>
 </table>
 
</body> 
</html>