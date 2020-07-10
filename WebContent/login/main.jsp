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
		<a class="navbar-brand" href='<%=application.getContextPath()%>'>��������</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-tatget="#navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
	<div id="navbar" class="collapse navbar-collapse">	
		
		<ul class="navbar-nav mr-auto">
			<li  class="nav-item active">
				<a class="nav-link" href='<%=application.getContextPath()%>'>����</a>
			</li>
			
			<%
			if(id != null){
			%>
			<li class="nav-item active">
				<a class="nav-link" href= '<%=application.getContextPath()%>/blist'>�Խ���</a>
			</li>
			</li>
				<li class="nav-item active">
				<a class="nav-link" href= '<%=application.getContextPath()%>/imlist'>å�ڶ��Խ���</a>
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
		<a class="nav-link"><%= id %>�� �α���</a>
		<%}else{%>
		<a class="nav-link">������ �޴��� ���÷��� �α��� ���ּ���</a>
		<%} %>
			</li>
		</ul>
		<%
			if(id == null){
		%>
			<ul class="nav navbar-nav navbar-right">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
					�����ϱ�
				</a> 
				<div class="dropdown-menu" aria-labelledby="dropdown">
					<a class="dropdown-item" href= '<%=application.getContextPath()%>/member/insert.html'> 1.ȸ������</a>
					<a class="dropdown-item" href= '<%=application.getContextPath()%>/login/login2.jsp'> 2.�α���</a>
				</div>
			</li>
			
		</ul> 	
		<%		
		}else{
		%>
		<ul class="nav navbar-nav navbar-right">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
					ȸ������
				</a> 
				<div class="dropdown-menu" aria-labelledby="dropdown">
					<a href= '<%=application.getContextPath()%>/login/logout.jsp'>�α׾ƿ�</a>
				</div>
			</li>
		</ul> 
		<% } %>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search" placeholder="������ �Է��ϼ���" aria-label="searsh">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">�˻�</button>
		</form>
	</div>
	</nav>
	<div class="container">
		<div class ="jumbotron">
			<h1> �������! <b>��������</b> �Դϴ�</h1>
			<h2> ���� ���� ����ִ� å�� �����ϰ� �ڶ����ּ��� </h2>
			<p> �α����� �Ͻø� �� ���� �޴��� ���� �� �ֽ��ϴ� </p>
			<p> ȸ������ �� �پ��� �̺�Ʈ���� ������ ������! </p>			
			<%
			if(id != null){
			%>
			<p><a class="btn btn-primary btn-pull" href="<%=application.getContextPath()%>/iminsert" role="button">�� å �ڶ��ϱ�</a></p>
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
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��� : ����� ���ʱ�</p>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�Ͻ� : �ٷ� ����! </p>		
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�ذ��� �����ϴ� å�� �� �������ּ����</p>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.����Ʈ�� ���� ����� �ڶ��ϱ�</p>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.�����ϴ� å �����ϰ� ���� ����Ƽ�� �ޱ�</p>
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