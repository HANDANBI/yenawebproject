<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, com.vo.*, com.biz.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
<title>book</title>
<link rel ="stylesheet" href="../css/bootstrap.min.css">
<link rel ="stylesheet" href="../css/custom.css">
 </head>
 <body>
 <script src="../js/jquery.min.js"></script>
<script src="../js/popper.js"></script>
<script src="../js/bootstrap.min.js"></script>
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href='<%=application.getContextPath()%>'>북적북적</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-tatget="#navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
	<div id="navbar" class="collapse navbar-collapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href='<%=application.getContextPath()%>'>메인</a>
			</li>
			<li class="nav-item active">
				<a class="nav-link" href= '<%=application.getContextPath()%>/blist'>게시판</a>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
					회원관리
				</a> 
				<div class="dropdown-menu" aria-labelledby="dropdown">
					<a class="dropdown-item" href= '<%=application.getContextPath()%>/member/insert.html'> 1.회원가입</a>
					<a class="dropdown-item" href= '<%=application.getContextPath()%>/login/input_login.html'> 2.로그인</a>
				</div>
			</li>
			
		</ul>
		<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button> 
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search" placeholder="내용을 입력하세요" aria-label="searsh">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
		</form>
	</div>
	</nav>
 <%
 	request.setCharacterEncoding("euc-kr");
	List<BoardVO> all = (List<BoardVO>)request.getAttribute("ball");
 	int total = (int)request.getAttribute("bcount");
 	out.print("총 게시물 : " + total + "개");		
 %>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
  <tr height="5"><td width="5"></td></tr>
 <tr style="background:url('img/table_mid.gif') repeat-x; text-align:center;">
   <td width="5"><img src="img/table_left.gif" width="5" height="30" /></td>
   <td width="73">번호</td>
   <td width="200">제목</td>
   <td width="150">책 제목</td>
   <td width="73">작성자</td>
   <td width="164">작성일</td>
   <td width="58">조회수</td>
   <td width="7"><img src="img/table_right.gif" width="5" height="30" /></td>
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
 
<table width="100%" cellpadding="0" cellspacing="0" border="0">
  <tr><td colspan="4" height="5"></td></tr>
  <tr align="center">
   <td><input type=button value="글쓰기" OnClick="window.location='board/input_board.jsp'" ></td>
  </tr>
</table>

</body> 
</html>