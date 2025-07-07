<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
  <h3 class="alert alert-success">총 ${count }개의 자동차 정보가 있습니다</h3>
  <br>
  <table class="table table-bordered" style="width: 800px;">
     <tr class="table-warning">
       <th width="80">번호</th>
       <th width="180">자동차명</th>
       <th width="120">색상</th>
       <th width="150">가격</th>
       <th width="180">구입일</th>
       <th width="180">등록일</th>
       <th width="180">편집</th>
     </tr>
  </table>
</body>
</html>