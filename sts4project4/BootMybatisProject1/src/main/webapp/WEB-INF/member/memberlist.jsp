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
<script type="text/javascript">
   $(function(){
	   
	   $("#allcheck").click(function(){
		   
		  var chk =$(this).is(":checked");
		  console.log(chk);
		  
		  $(".del").prop("checked",chk);
	   });
	   
	   
	   //삭제버튼
	   $("#btnmemberdel").click(function(){
		   
		   //체크갯수
		   var cnt=$(".del:checked").length;
		   //alert(cnt);
		   
		   if(cnt==0){
			   alert("삭제할 회원을 최소한명 선택해주세요");
			   return;
		   }
		   
		   $(".del:checked").each(function(i,elt){
			   
			   var num=$(this).attr("num");
			   console.log(num);
			   
			   //삭제
			   $.ajax({
				  
				   type:"get",
				   url:"delete",
				   dataType:"html",
				   data:{"num":num},
				   success:function(){
					   alert("강퇴되었습니다");
					   location.reload();
				   }
			   });
		   });
	   });
	   
   });
</script>
</head>
<body>

<div class="container">
   <jsp:include page="../../layout/header.jsp"></jsp:include>
   

<br><br>
<table class="table table-bordered" style="width: 1000px;">
   <caption align="top"><b>전체회원명단</b></caption>
   <tr class="table-warning">
     <th width="100">번호</th>
     <th width="120">아이디</th>
     <th width="120">회원명</th>
     <th width="150">핸드폰</th>
     <th width="180">이메일</th>
     <th width="180">가입일</th>
     <th width="180">
       <input type="checkbox" id="allcheck">
       강퇴
     </th>
   </tr>
   
   <c:forEach  var="dto" items="${list }" varStatus="i">
     <tr align="center">
       <td>${i.count }</td>
       <td>${dto.id }</td>
       <td>${dto.name }</td>
       <td>${dto.hp }</td>
       <td>${dto.email }</td>
       <td>
          <fmt:formatDate value="${dto.gaipday }"
          pattern="yyyy-MM-dd HH:mm"/>
       </td>
       <td>
         <input type="checkbox" class="del" num="${dto.num }">
         
       </td>
     </tr>
   </c:forEach>
</table>

<button type="button" class="btn btn-danger" style="margin-left: 700px;"
id="btnmemberdel">Delete</button>
</div>
</body>
</html>