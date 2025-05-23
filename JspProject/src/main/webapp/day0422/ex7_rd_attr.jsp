<%@page import="java.util.Vector"%>
<%@page import="day0422.StudentInfoDto"%>
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
<h3>request에 Vector 저장후 불러오기 연습</h3>
<%
   Vector<StudentInfoDto> list=new Vector<>();
   list.add(new StudentInfoDto("조태민","강남구",88));
   list.add(new StudentInfoDto("김태민","강서구",98));
   list.add(new StudentInfoDto("김유진","해운대구",68));
   list.add(new StudentInfoDto("조우진","미사구",99));
   list.add(new StudentInfoDto("김민정","강동구",77));
   
   //데이타 Vector를 request에저장
   request.setAttribute("list", list);
   
   //forward:url안바뀜
   //redirect:url바뀜
   //<jsp:>  액션태그
   //jsp에서 sendRedirect하는 방법
   response.sendRedirect("ex7_redirect.jsp");
   
%>

</body>
</html>
