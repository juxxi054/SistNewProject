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
  <h2>Market정보 수정하기</h2>
  <form action="update" method="post" enctype="multipart/form-data">
     <input type="hidden" name="num" value="${dto.num }">
     <b>상품명: </b>
      <input type="text" name="sangpum" value="${dto.sangpum }"><br>
      <b>가격: </b>
      <input type="text" name="price" value="${dto.price }"><br>
      <b>이미지: </b>
      <input type="file" name="photo" ><br>
      <button type="submit" class="btn btn-danger">DB수정</button>
  </form>
</body>
</html>