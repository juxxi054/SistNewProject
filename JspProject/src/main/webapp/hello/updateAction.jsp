<%@page import="hello.HelloDao"%>
<%@page import="hello.HelloDto"%>
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
<%
request.setCharacterEncoding("utf-8");
//데이터 읽어서 dto 넣기
String num=request.getParameter("num");
String name=request.getParameter("name");
String addr=request.getParameter("addr");
String hp=request.getParameter("hp");

HelloDto dto=new HelloDto();
dto.setNum(num);
dto.setName(name);
dto.setAddr(addr);
dto.setHp(hp);

HelloDao dao=new HelloDao();
//dao의 update메서드 호출해서 수정된 dto를 넘긴다

dao.updateHello(dto);

//목록파일로 이동

response.sendRedirect("helloList.jsp");

%>
</body>
</html>