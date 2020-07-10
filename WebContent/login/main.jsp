<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
<title>book</title>
<link rel ="stylesheet" href="../css/bootstrap.min.css">
<link rel ="stylesheet" href="../css/custom.css">
</head>
<body>
	<%
		String id = null;
		String name = null;
		if(session.getAttribute("MyID") !=null){
			id= (String) session.getAttribute("MyID");
			name = (String) session.getAttribute("MyName");
		}
	%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<img alt="booki" src="bookicon.png" width="30" height="30"/>
		<a class="navbar-brand" href='<%=application.getContextPath()%>'>북적북적</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-tatget="#navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
	<div id="navbar" class="collapse navbar-collapse">	
		
		<ul class="navbar-nav mr-auto">
			<li  class="nav-item active">
				<a class="nav-link" href='<%=application.getContextPath()%>'>메인</a>
			</li>
			
			<%
			if(id != null){
			%>
			<li class="nav-item active">
				<a class="nav-link" href= '<%=application.getContextPath()%>/blist'>게시판</a>
			</li>
			</li>
				<li class="nav-item active">
				<a class="nav-link" href= '<%=application.getContextPath()%>/imlist'>책자랑게시판</a>
			</li>
			<%
			}
			%>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li  class="nav-item active">
		<%
			if(id != null){
		%>
		<a class="nav-link"><%= id %>님 로그인</a>
		<%}else{%>
		<a class="nav-link">숨겨진 메뉴를 보시려면 로그인 해주세요</a>
		<%} %>
			</li>
		</ul>
		<%
			if(id == null){
		%>
			<ul class="nav navbar-nav navbar-right">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
					접속하기
				</a> 
				<div class="dropdown-menu" aria-labelledby="dropdown">
					<a class="dropdown-item" href= '<%=application.getContextPath()%>/member/insert.html'> 1.회원가입</a>
					<a class="dropdown-item" href= '<%=application.getContextPath()%>/login/login2.jsp'> 2.로그인</a>
				</div>
			</li>
			
		</ul> 	
		<%		
		}else{
		%>
		<ul class="nav navbar-nav navbar-right">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
					회원관리
				</a> 
				<div class="dropdown-menu" aria-labelledby="dropdown">
					<a href= '<%=application.getContextPath()%>/login/logout.jsp'>로그아웃</a>
				</div>
			</li>
		</ul> 
		<% } %>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search" placeholder="내용을 입력하세요" aria-label="searsh">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
		</form>
	</div>
	</nav>
	<div class="container">
		<div class ="jumbotron">
			<h1> 어서오세요! <b>북적북적</b> 입니다</h1>
			<h2> 내가 읽은 재미있는 책을 리뷰하고 자랑해주세요 </h2>
			<p> 로그인을 하시면 더 많은 메뉴를 보실 수 있습니다 </p>
			<p> 회원가입 후 다양한 이벤트에도 참여해 보세요! </p>			
			<%
			if(id != null){
			%>
			<p><a class="btn btn-primary btn-pull" href="<%=application.getContextPath()%>/iminsert" role="button">내 책 자랑하기</a></p>
			<%
			}
			%>
		</div>
	</div>
	<div class="container">
		<div id ="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- <ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1" ></li>
				<li data-target="#myCarousel" data-slide-to="2" ></li>
			</ol>
			 -->
			<div class="container">
				<div class ="jumbotron">
					<img src="../img/7.jpg" width="50%" height="700" >
						<a class="navbar-brand">
								<h1>&nbsp;&nbsp;&nbsp;BEST BOOK EVENT</h1>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;장소 : 서울시 서초구</p>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일시 : 바로 오늘! </p>		
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;※가장 좋아하는 책을 꼭 지참해주세요※</p>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.사이트에 서평 남기고 자랑하기</p>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.좋아하는 책 공유하고 무료 기프티콘 받기</p>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </p>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </p>
								
									
						</a>
				</div>
				
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/popper.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	
</body>
</html>