<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Poetsen+One&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<%
//세션에서 아이디와 체크값 얻기
String myid=(String)session.getAttribute("idok");
String saveid=(String)session.getAttribute("saveok");

boolean save=true;

if(saveid==null)
{
	myid="";
	save=false; //체크하지 않을때만 flase 그외는 초기값이 true이므로 true가 됨
}

%>
<body>
<div style="margin: 100px 200px; width: 200px;">
<h2 class="alert alert-succes">회원로그인</h2>
<form action="loginAction.jsp" method="post">
<input type="text" name="id" class="form=control"
style="width:200px;" placeholder="로그인할 아이디"
required="required" value="<%=myid%>"><br>

<input type="text" name="id" class="form=control"
style="width:200px;" placeholder="로그인할 비밀번호"
required="required">
<br>

<button type="submit" class="btn btn-success btn-lg"
style="width: 200px;">로그인 </button>

<input type="checkbox" name="savechk"
<%=save?"checked":"" %>>아이디저장

</form>

</div>
</body>
</html>