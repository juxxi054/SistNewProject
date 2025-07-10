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
    <div style="margin: 100px 200px; width: 600px;">
      <table class="table table-bordered" >
         <tr>
           <td>
              <h4><b>${dto.subject }</b></h4>
              <br>
              <i class="bi bi-person-circle fs-2" style="color: gray;"></i>
              <b>${dto.writer }</b>
              <span style="float: right;">
                <fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
              </span>
           </td>
         </tr>
         
         <tr height="400">
           <td>
              ${dto.content }
              
              <c:if test="${dto.photo!='no' }">
                 <br><br>
                 <img src="../save/${dto.photo }" style="max-width: 300px;">
              </c:if>
           </td>
         </tr>
         <tr>
           <td align="right">
             <button type="button" class="btn btn-outline-primary"
             onclick="location.href='form'">글쓰기</button>
             <button type="button" class="btn btn-outline-primary"
             onclick="location.href='updateform?num=${dto.num}'">수정</button>
             <button type="button" class="btn btn-outline-primary"
             onclick="remove('${dto.num}')">삭제</button>
             <button type="button" class="btn btn-outline-primary"
             onclick="location.href='list'">목록</button>
           </td>
         </tr>
      </table>
    </div>
    <script type="text/javascript">
      function remove(num){
    	  //alert(num);
    	  
    	  var ans=confirm("삭제하려면 [확인]을 눌러주세요");
    	  if(ans){
    		  location.href="delete?num="+num;
    	  }
      }
    </script>
    
</body>
</html>