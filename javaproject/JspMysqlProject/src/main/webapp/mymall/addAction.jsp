<%@page import="mymall.MymallDao"%>
<%@page import="mymall.MymallDto"%>
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
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String sangpum=request.getParameter("sangpum");
String photo=request.getParameter("photo");
String color=request.getParameter("color");
int price=Integer.parseInt(request.getParameter("price"));
String ipgoday=request.getParameter("ipgoday");
String writeday=request.getParameter("writeday");

//dto
MymallDto dto=new MymallDto();
dto.setSanmgpum(sangpum);
dto.setPhoto(photo);
dto.setColor(color);
dto.setPrice(price);
dto.setIpgoday(ipgoday);

MymallDao dao=new MymallDao();
dao.insertMall(dto);

//목록
response.sendRedirect("mallList.jsp");



%>

</body>
</html>