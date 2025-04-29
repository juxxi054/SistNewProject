<%@page import="gaip.GaipDto"%>
<%@page import="gaip.GaipDao"%>
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
<%

String num=request.getParameter("num");
GaipDao dao=new GaipDao();
GaipDto dto=dao.getData(num);
%>
<body>
<div style="margin: 100px 100px; width:600px";>
<table class="table table-bordered">
<caption align="top"><h2 class="alert alert-success"><%=dto.getName() %></h2></caption>
<tr>
<td width="200" class=table-sucess>연령대</td>
</tr>
<tr>
<th width="200" class="table-success">핸드폰</th>
<td><%=dto.getHp() %></td>
</tr>
<th width="200" class="table-success">생년월일</th>
<td><%=dto.getBirth() %></td>
</tr>
<th width="200" class="table-success">가능한언어</th>
<td><%=dto.getLang().equals("no")?"가능언어 없음":dto.getLang() %></td>
</tr>
<tr>
<td colspan="2 align="right">
<input type="button" class="btn btn-success" value="수정"
onclick="location.href='updateForm'">

</td>
</tr>

</table>

</div>
</body>
</html>
