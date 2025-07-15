<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<style type="text/css">
  body{
    width: 100%;
    margin: 0 ;
  }
  
    .container {
      display: flex;
      flex-direction: column; /* 세로로 쌓기 */
      align-items: center;     /* 가로 정렬 중앙 */
      justify-content: center; /* 세로 정렬 중앙 */
      height: 100%;
    }
</style>

</head>
<body>
<div class="container">
   <jsp:include page="../../layout/header.jsp"></jsp:include>
   <br><br><br>
<form action="insert" method="post" enctype="multipart/form-data">
     <table class="table table-bordered" style="width: 500px;">
        <caption align="top"><b>회원전용게시판</b></caption>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="subject" class="form-control"
            style="width: 350px;" required="required">
          </td>
        </tr>
        <tr>
          <th>업로드</th>
          <td>
            <input type="file" name="upload" class="form-control"
            style="width: 300px;" >
          </td>
        </tr>
        <tr>
          
          <td colspan="2">
            <textarea style="width: 480px; height: 100px"
            name="content" required="required" class="form-control"></textarea>
          </td>
        </tr>
        
        <tr>
          <td colspan="2" align="center">
            <button type="submit" class="btn btn-outline-info">저장</button>
            <button type="button" class="btn btn-outline-success"
            onclick="location.href='list'">목록</button>
          </td>
        </tr>
     </table>
  </form>
  </div>
</body>
</html>