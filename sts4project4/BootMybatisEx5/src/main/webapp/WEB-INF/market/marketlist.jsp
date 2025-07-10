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
</head>
<body>
 <button type="button" class="btn btn-info"
   onclick="location.href='addform'">상품입고</button><br><br>
   <c:if test="${count==0 }">
     <div class="alert alert-info">
        <b>저장된 상품이 없습니다</b>
     </div>
   </c:if>
   <c:if test="${count>0 }">
     <div class="alert alert-info">
        <b>총 ${count }개의 상품이 입고중입니다</b>
     </div>
   </c:if>
   
  <br>
  <c:forEach var="a" items="${list }">
    <table class="table table-bordered" style="width: 600px;">
       <tr>
         <td>
           <c:if test="${a.photoname!=null }">
             <img alt="" src="photo/${a.photoname }" style="width: 150px; height: 150px;"
             align="left" hspace="20">
           </c:if>
           <c:if test="${a.photoname==null }">
             <img alt="" src="photo/noimage.png" style="width: 150px; height: 150px;"
             align="left" hspace="20">
           </c:if>
           
           <h4>상품명: ${a.sangpum }</h4>
           <h4>가격: <fmt:formatNumber value="${a.price }" type="currency"/>  </h4>
           <h4>입고날짜: <fmt:formatDate value="${a.ipgoday }" pattern="yyyy-MM-dd HH:mm"/>  </h4>
           
           <button type="button" class="btn btn-success btn-sm"
           onclick="location.href='updateform?num=${a.num}'">수정</button>
           <button type="button" class="btn btn-danger btn-sm"
           onclick="location.href='delete?num=${a.num}'">삭제</button>
         </td>
       </tr>
    </table>
  
  </c:forEach>
</body>
</html>