<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="dao" class="com.dao.BoardDAO"/>
<jsp:useBean id="vo" class="com.vo.BoardVO"/>
<jsp:setProperty name="BoardVO" property="*" />

<%	
	request.setCharacterEncoding("euc-kr");
	int max = dao.getNewBid();
	dao.insertWrite(vo, max);
%>

  <script language=javascript>
   self.window.alert("�Է��� ���� �����Ͽ����ϴ�.");
   location.href="list_board.jsp"; 
</script>