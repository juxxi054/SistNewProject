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

//세션저장
session.setAttribute("msg","happy");
session.setMaxInactiveInterval(10); //10초
%>
<h2>10초안에 선택하세요</h2>
<form action="sessionAction.jsp" method="post">
<h2>가고싶은 여행지는?</h2>
<input type="radio" value="" name="travel">미국&nbsp;
<input type="radio" value="" name="travel">터키&nbsp;
<input type="radio" value="" name="travel">일본&nbsp;
<input type="radio" value="" name="travel">스위스&nbsp;
<input type="radio" value="" name="travel" checked="checked">호주&nbsp;
<input type="submit" value="여행선택" class="btn btn-success">


</form>
</body>
</html>