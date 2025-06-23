<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
  <c:if test="${totalCount==0 }">
    <h3 class="alert alert-info">저장된 자동차 정보가 없습니다</h3>
  </c:if>
  <c:if test="${totalCount>0 }">
    <h3 class="alert alert-info">총 ${totalCount }개의 자동차 정보가 있습니다</h3>
  </c:if>
  <br>
  <button type="button" style="width: 150px;"
  onclick="location.href='writeform'" class="btn btn-outline-success">차 정보입력</button>
  <br><br>
  <table class="table table-bordered" style="width: 800px;">
  </table>
</body>
</html>