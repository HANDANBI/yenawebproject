<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp= request.getContextPath();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>이미지게시판</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>

<br/><br/>
 
<table width="800" align="center" style="font-family: 'Nanum Gothic', sans-serif; font-size:10pt;" cellspacing="2" cellpadding="1">
	<tr id="bbsList">
		<td id="bbsList_title"  colspan="3">
		<h1>책자랑 게시판</h1>
	<input type=button value="◀    메인으로 돌아가기" class="btn btn-link" OnClick="window.location='login/main.jsp'" >
		</td>
	</tr>
	<tr>
		<td align="left" colspan="2" width="400">
		Total ${totalArticle}        articles,${totalPage}page / Now Page id ${currentPage}
		</td>
		<td align="right" colspan="1" width="200">
	<%-- 		<input type="button" value="게시물 등록" onclick="javascript:location='<%=cp%>/image/iminsert.do';"/> --%>
			<input type="button" class="btn btn-link" value="게시물 등록" onclick="javascript:location='<%=cp%>/iminsert';"/>
		</td>
	</tr>
	<tr><td style="border-bottom:2px solid #DBDBDB;" colspan="3"></td></tr>
	<%
		int newLine=0;
		int articleCount=0;
		int cnt=0;
	%>
		<c:forEach var="vo" items="${lists}">
	<%
		if(newLine==0){
			out.print("<tr>");
		}
		newLine++;
		articleCount++;	
	%>	
		<td align="center" width="190">
			<input type="hidden" values="${vo.getBid()}" name="bid" />
			<a href="${imagePath}/${vo.getSavefilename()}">
				<img alt="" src="${imagePath}/${vo.getSavefilename()}" width="190" height="210"><br>
				${vo.getItitle()}  
			</a>
			&nbsp;&nbsp;&nbsp;
			<a href="${deletePath}?bid=${vo.getBid()}&currentPage=${currentPage}">삭제</a>
		</td>
	<%
		if(newLine==3){
			out.print("</tr>");
			newLine=0;
		}
	%>
		</c:forEach>
	<%
		while(newLine>0 && newLine<3){
			out.print("<td width='180'></td>");
			newLine++;
		}
		out.print("</tr>");
	%>
		
<c:if test="${dataCount!=0 }">
	<tr><td style="border-bottom:2px solid #DBDBDB;" colspan="3"></td></tr>
	<tr>
		<td align="center" colspan="3">
			${pageIndexList}			
		</td>
	</tr>
</c:if>
<c:if test="${dataCount==0}">
	<tr>
		<td align="center" colspan="3">
			등록된 파일이 없습니다.			
		</td>
	</tr>
	<tr><td style="border-bottom:2px solid #DBDBDB;" colspan="3"></td></tr>	
</c:if>
</table>
</body>
</html>