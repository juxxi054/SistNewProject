<%@page import="day0422.StudentInfoDto"%>
<%@page import="java.util.Vector"%>
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
<h3>여기는 ex7_forward 입니다</h3>
<%
//request에 저장된 list얻기
Vector<StudentInfoDto> list=(Vector<StudentInfoDto>)request.getAttribute("list");

    //redirect로 이동시 request는 새로 생성이 되므로 list는 당연히 없음
    if(list==null)
    	out.print("list가 없다");
    else
    	out.print("list 가 있다");
%>
</body>
</html>
