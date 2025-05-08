<%@page import="login.loginDao"%>
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
<body>
<%
   //세션에 저장한 아이디를 읽어온다
   String id=(String)session.getAttribute("idok");
   //아이디에 해당하는 이름을 dao로 부터 얻기
   loginDao dao=new loginDao();
   String name=dao.getName(id);
%>
<br><br>
<div style="margin: 100px 200px;">
<b><%=name %></b> 님이 로그인중입니다
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" class="btn btn-danger btn-sm"
onclick="location.href='logoutAction.jsp'">로그아웃</button>
<br><br>

<img alt="" src="../image/logoImg/img2.jpg">
</div>

</body>
</html>