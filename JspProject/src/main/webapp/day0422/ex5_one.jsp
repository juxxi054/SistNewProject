<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Poetsen+One&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<h3>ex5_oneInclude Include하기</h3>
<%
   request.setCharacterEncoding("utf-8"); //한글경로일경우
%>

<jsp:include page="ex5_oneinclude.jsp">
     <jsp:param value="오늘은 Jsp1일차!!!" name="msg"/>
 <jsp:param value="../image/j/01.png" name="imgname"/>
     <jsp:param value="홍길동" name="name"/>
     <jsp:param value="서울시 강서구" name="addr"/>
</jsp:include>
</body>
</html>

