<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel ="stylesheet" href="../css/bootstrap.min.css">
<link rel ="stylesheet" href="../css/custom.css">
<script type="text/javascript">
	function sendlt(){
		f = document.myForm;
		
		str=f.ititle.value;
		str=str.trim();
		
		if(!str){
			alert("제목을 입력하세요");
			f.ititle.focus();
			return;
		}
		f.ititle.value = str; 
		
		str=f.uploadFile.value;
		if(!str){
			alert("이미지 파일을 선택하세요");
			f.uploadFile.focus();
			return;
		}
		
		f.action= "/yenawebproject/iminsert_ok";
		f.submit();
	}
</script>
</head>
<body>
<form action = "<%=cp%>/iminsert_ok" method="post" enctype="multipart/form-data" name="myForm">
	<table cellpadding="2" id="bbs">
		<tr>
			<td id="bbs_title" colspan="3">
			이미지 등록
			</td>
		</tr>
		<tr><td height="1" colspan="3" style="border-botton:1px solid #DBDBDB;"></td></tr>
		<tr>
			<td align="center" width="100">제&nbsp;&nbsp;&nbsp;&nbsp;목</td>
			<td colspan="2">
			<input type="text" name="ititle" class="boxTF" size="74" /></td>
		</tr>
		<tr><td height="1" colspan="3" style="border-botton:1px solid #DBDBDB;"></td></tr>
		<tr>
			<td align="center" width="100">파&nbsp;&nbsp;&nbsp;&nbsp;일</td>
			<td class="bbsCreated_bottomLine" colspan="2">
			<input type="file" name="uploadFile" class="boxTF" size="74" /></td>
		</tr>
		<tr><td height="1" colspan="3" style="border-botton:1px solid #DBDBDB;"></td></tr>
		<tr id = "bbsCreated_footer">
			<td align="center" colspan="3">
			<input type="button" value="파일등록" onclick="sendlt()"/>
			<input type="button" value="다시입력" onclick="document.myForm.ititle.focus();"/>
			<input type="button" value="작성취소" onclick="javascript:location.href='<%=cp%>/imlist';"/></td>
		</tr>
	</table>
</form>
</body>
</html>