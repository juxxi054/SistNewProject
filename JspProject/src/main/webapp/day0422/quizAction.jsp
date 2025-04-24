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
String name=request.getParameter("s_name");
String ji=request.getParameter("cbarea");
String day=request.getParameter("ipsaday");
String present=request.getParameter("gift");
String lunch=request.getParameter("food");
String[] it = request.getParameterValues("lang");
String color=request.getParameter("colors");

%>

<h4>
사원명:<%=name%><br>
근무지역:<%=ji==null? "국내":"해외" %><br>
입사일자: <%= day %><br>
명절선물: <img src="<%= present %>" width="50"><br><br>
맛있었던 점심메뉴: <%= lunch %><br><br>
가능 IT언어:
<%
if (it == null) {
%>
    <b>가능 언어 없음</b>
<%
} else {
    for (int i = 0; i < it.length; i++) {
%>
        [<%= it[i] %>] &nbsp;
<%
    }
%>
    <b>총 <%= it.length %>개의 언어 선택함</b><br>
<%
}
%>
 배경색: <div style="width:100px; height:20px; background-color:<%= color %>;"></div><br>

</h4>

</body>
</html>
