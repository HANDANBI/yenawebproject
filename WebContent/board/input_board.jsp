<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vo.*,com.biz.*" %>
<%

	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <title>게시판</title>
 </head>
 <body>
 <%
 	String myID = (String)session.getAttribute("MyID");
 	String myName = (String)session.getAttribute("MyName");
 	
 	int mode = Integer.parseInt(request.getParameter("mode"));
 	BoardVO curVO = null;
 	
 	if(mode > 0){
 		curVO = new BoardBIZ().getView(mode);
 	}
 %>
 
    <%
   if(mode > 0)
   {
   %>       
 <form action = "/yenawebproject/bupdate" method="post">
    <%
   }else{
   %>
 <form action = "/yenawebproject/binsert" method="post">
 <%} %>
<!--  <form name=writeform method=post action="/yenawebproject/board/input_b_ok.jsp"> -->
<table>
  <tr>
   <td>
    <table width="100%" cellpadding="0" cellspacing="0" border="0">
     <tr style="background:url('table_mid.gif') repeat-x; text-align:center;">
      <td width="5"><img src="table_left.gif" width="5" height="30" /></td>
      <td>글쓰기</td>
      <td width="5"><img src="table_right.gif" width="5" height="30" /></td>
     </tr>
    </table>
   <table>
     <%
      if(mode > 0)
      {
      %>  
    <tr>
      <td>&nbsp;</td>
      <td align="center">글번호</td>
      <td><input name="ubid" size="50" maxlength="100" value="<%= mode %>" readonly="readonly"></td>
      <td>&nbsp;</td>
     </tr>      
       <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>    
       <tr>
      <td>&nbsp;</td>
      <td align="center">제목</td>
      <td><input name="title" size="50" maxlength="100" value="<%= curVO.getTitle() %>"></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">책 제목</td>
      <td><input name="booktitle" size="50" maxlength="50" value="<%= curVO.getBooktitle() %>"></td>
      <td>&nbsp;</td>
     </tr>
     <tr>
      <td>&nbsp;</td>
      <td align="center">장르</td>
      <td>
       <select name="genre" >
           <option value="소설">소설</option>
           <option value="인문">인문</option>
           <option value="경제경영">경제경영</option>
           <option value="IT">IT</option>
       </select></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr>
      <td>&nbsp;</td>
      <td align="center">내용</td>
      <td><textarea name="text" cols="50" rows="13"><%= curVO.getTitle() %></textarea></td>
      <td>&nbsp;</td>
     </tr>
       <%
      }else{
      %>
     <tr>
      <td>&nbsp;</td>
      <td align="center">제목</td>
      <td><input name="title" size="50" maxlength="100"></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">책 제목</td>
      <td><input name="booktitle" size="50" maxlength="50"></td>
      <td>&nbsp;</td>
     </tr>
     <tr>
      <td>&nbsp;</td>
      <td align="center">장르</td>
      <td>
       <select name="genre">
           <option value="소설">소설</option>
           <option value="인문">인문</option>
           <option value="경제경영">경제경영</option>
           <option value="IT">IT</option>
       </select></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr>
      <td>&nbsp;</td>
      <td align="center">내용</td>
      <td><textarea name="text" cols="50" rows="13"></textarea></td>
      <td>&nbsp;</td>
     </tr>
       <%
      }
      %>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
     <tr align="center">
      <td>&nbsp;</td>
      <td colspan="2">
      <%--  <input type=button value="등록" OnClick="window.location='<%=application.getContextPath()%>/binsert'" > --%>
      <%
      if(mode > 0)
      {
      %>       
       <button type="submit">수정</button>
       <%
      }else{
      %>       
       <button type="submit">등록</button>
       <%
      }
      %>
       <input type=button value="취소" OnClick="window.location='<%=application.getContextPath()%>/blist'" >
       
      <td>&nbsp;</td>
     </tr>
    </table>
   </td>
  </tr>
 </table>
 </form>
</body> 
</html>