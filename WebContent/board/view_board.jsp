<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*,java.util.*,com.vo.*,com.biz.*"%>
<%


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <title>게시판</title>
 </head>
 <body>
 <% 
 	int bid = Integer.parseInt(request.getParameter("bid"));
 	BoardVO curVO= new BoardBIZ().getView(bid);
 %>
<table>
  <tr>
   <td>
    <table width="100%" cellpadding="0" cellspacing="0" border="0">
     <tr style="background:url('img/table_mid.gif') repeat-x; text-align:center;">
      <td width="5"><img src="img/table_left.gif" width="5" height="30" /></td>
      <td>내용</td>
      <td width="5"><img src="img/table_right.gif" width="5" height="30" /></td>
     </tr>
    </table>
   <table width="413">
     <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">글번호</td>
      <td width="319"><%=curVO.getBid() %></td>
      <td width="0">&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">추천수</td>
      <td width="319"><%=curVO.getGrade() %></td>
      <td width="0">&nbsp;</td>
     </tr>
	 <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">이름</td>
      <td width="319"><%=curVO.getBwriter() %></td>
      <td width="0">&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">작성일</td>
      <td width="319"><%=curVO.getTime() %></td>
      <td width="0">&nbsp;</td>
     </tr>
      <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">제목</td>
      <td width="319"><%=curVO.getTitle() %></td>
      <td width="0">&nbsp;</td>
     </tr>
    <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">장르</td>
      <td width="319"><%=curVO.getGenre() %></td>
      <td width="0">&nbsp;</td>
     </tr>
      <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
     <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">리뷰</td>
      <td width="319" height="200"><%=curVO.getText() %></td>
      <td width="0">&nbsp;</td>
     </tr>
     
<%--     
              <tr>
      <td width="0">리뷰</td>
                   <td width="399" colspan="2" height="200"><%=curVO.getText() %>
                </tr> --%>
<%

 	/* sql = "UPDATE board SET HIT=" + hit + " where NUM=" +idx; */
/* 	stmt.executeUpdate(sql);
 	rs.close();
 	stmt.close();
 	conn.close();
	 	} 
	}catch(SQLException e) {
}
	*/

%>
     <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
     <tr height="1" bgcolor="#82B5DF"><td colspan="4" width="407"></td></tr>
     <tr align="center">
      <td width="0">&nbsp;</td>
      <td colspan="2" width="399">
		<!-- <input type=button value="목록" OnClick="window.location='list.jsp'"> -->
		<input type=button value="좋아요" OnClick="window.location='<%=application.getContextPath()%>/blike?bid=<%=bid%>'">
		<input type=button value="목록" OnClick="window.location='<%=application.getContextPath()%>/blist'">
		<input type=button value="수정" OnClick="window.location='<%=application.getContextPath()%>/board/input_board.jsp?mode=<%=bid%>'">
		<input type=button value="삭제" OnClick="window.location='<%=application.getContextPath()%>/bdelete?bid=<%=bid%>'">
      <td width="0">&nbsp;</td>
     </tr>
    </table>
   </td>
  </tr>
 </table>
</body>

</html>