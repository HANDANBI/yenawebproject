<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
<title>book</title>
<link rel ="stylesheet" href="./css/bootstrap.min.css">
<link rel ="stylesheet" href="./css/custom.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<img alt="booki" src="./img/bookicon.png" width="30" height="30"/>
		<a class="navbar-brand" href="index.jsp" >��������</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-tatget="#navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
	
	<%
	//�ڹ��ڵ� �ۼ��κ�
	String path = application.getContextPath();
	//String myName = session.getAttribute("MyName");
	session.invalidate();
	%>
	<div id="navbar" class="collapse navbar-collapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href="<%=application.getContextPath()%>/login/main.jsp">����</a>
			</li>
			<li class="nav-item active">
				<a class="nav-link" href= '<%=path%>/blist'>�Խ���</a>
			</li>
				<li class="nav-item active">
				<a class="nav-link" href= '<%=path%>/board/list_image.jsp'>å�ڶ��Խ���</a>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
					ȸ������
				</a> 
				<div class="dropdown-menu" aria-labelledby="dropdown">
					<a class="dropdown-item" href= '<%=path%>/member/insert.html'> 1.ȸ������</a>
					<a class="dropdown-item" href= '<%=path%>/login/login2.jsp'> 2.�α���</a>
				</div>
			</li>
			
		</ul> 
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search" placeholder="������ �Է��ϼ���" aria-label="searsh">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">�˻�</button>
		</form>
	</div>
	<!-- <img src="./img/bookjek.jpg"> -->
	<script src="./js/jquery.min.js"></script>
	<script src="./js/popper.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	</nav>
</body>
</html>