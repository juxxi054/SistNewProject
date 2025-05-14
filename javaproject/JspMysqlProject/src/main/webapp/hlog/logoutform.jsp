<%@page import="hoewon.HoewonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
   
   HoewonDao dao=new HoewonDao();
   //세션에 저장된 id
   String id=(String)session.getAttribute("mid");
   
   //아이디에 해당하는 이름반환
   String name=dao.getHoewonName(id);
%>
<div style="margin: 200px 200px;">
<b><%=name %>님 로그인중</b>
<button type="button" class="btn btn-danger btn-sm"
onclick="location.href='logoutproc.jsp'">Logout</button>

<img alt="" src="../image/logoImg/img2.jpg">


</div>
</body>
</html>