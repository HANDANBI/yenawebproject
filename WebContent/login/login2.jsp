<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<img alt="booki" src="bookicon.png" width="30" height="30"/>
		<a class="navbar-brand" href='<%=application.getContextPath()%>'>북적북적</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-tatget="#navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
	
	<%
	//자바코드 작성부분
	String path = application.getContextPath();
	
	%>
	<div id="navbar" class="collapse navbar-collapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href='<%=application.getContextPath()%>'>메인</a>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
					회원관리
				</a> 
				<div class="dropdown-menu" aria-labelledby="dropdown">
					<a class="dropdown-item" href= '<%=path%>/member/insert.html'> 1.회원가입</a>
					<a class="dropdown-item" href= '<%=path%>/login/input_login.html'> 2.로그인</a>
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
<div id="id01" class="container">
  
  <form class="modal-content animate" action="<%=application.getContextPath()%>/mlogin" method="post">
    <div class="jumbotron" style="padding-top: 20px;">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
     		<h3 style="text-align : center;">로그인 화면</h3>
    

    <div class="container">
      <label for="uname"><b>Username</b></label>
      <input class="form-control"  type="text" placeholder="Enter Username" name="id" required>
		<br>
      <label for="psw"><b>Password</b></label>
      <input class="form-control" type="password" placeholder="Enter Password" name="pw" required>
        <br>
      <button type="submit" class="btn btn-primary form-control">Login</button>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      
    </div>
    </div>
  </form>
</div>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/popper.js"></script>
	<script src="../js/bootstrap.min.js"></script>
<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
</body>
</html>