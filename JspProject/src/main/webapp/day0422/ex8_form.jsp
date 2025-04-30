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
<h2>여러 데이터 전송하기</h2>
<form action="ex8_action.jsp" method="post">
<table class="table table-bordered" style="width: 300px;">
<tr>
<th>이름</th>
<td>
<input type="text" name="name"
placeholder="이름입력" required="required"
class="from-control">
</td>
</tr>

<tr>
<th>비밀번호</th>
<td>
<input type="password" name="pass"
placeholder="비번입력" required="required"
class="from-control">
</td>
</tr>

<tr>
<th>운전면허</th>
<td>
<input type="checkbox" name="licdiver">&nbsp;운전면허
</td>
</tr>

<tr>
<td colspan="2" align="center">
<button type="submit" class="btn btn-success">전송</button>
</td>
</tr>

</table>
</form>

</body>
</html>
