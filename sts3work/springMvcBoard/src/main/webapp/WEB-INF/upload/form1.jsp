<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="save1" method="post" enctype="multipart/form-data">
<table class="table table-bordered" style="width: 400px;">
<caption><b>스프링 업로드_1개</b></caption>
<tr>
<th>제목</th>
<td>
<input type="text" name="title" class="form-control"
style="wodth: 200px;">
</td>
</tr>
<tr>
<th>업로드</th>
<td>
<input type="file" name="photo" class="form-control"
style="wodth: 200px;">
</td>
</tr>
<tr>
<td colspan="2" align="center">
<button type="submit" class="btn btn-success">업로드</button>
</td>
</tr>
</table>
</form>
</body>
</html>