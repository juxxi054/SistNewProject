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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<style type="text/css">
		body *{
            font-family: 'Nanum Myeongjo';
        }
        
       
        a:link,a:visited {
			color: black;
			text-decoration: none;
		}
		
		a:hover {
			color: hotpink;
		}
		
		ul.mymenu{
			list-style: none;
			margin: 50px;
			display: block;
			
		}

		  ul.mymenu li{
			float: left;
			 width: 100px;
			height: 40px;
			line-height: 40px;
			text-align: center;
			 background-color: #ffe4e1; 
			margin-right: 10px;
			border: 1px solid gray;
			border-radius: 20px; 
		} 
		
		 ul.mymenu li:hover{
			background-color: gray;
			box-shadow: 5px 5px 5px gray;
		} 
 
		.loginimg{
		  width: 100px;
		  height: 100px;
		  border-radius: 100px;
		}
</style>
</head>
<!-- 프로젝트 절대경로 -->
<c:set var="root" value="<%=request.getContextPath() %>"/>

<body>

 <div style="margin-left: 200px;">
  <!-- 제목 -->
  <a href="${root }/">
    <img src="../image2/title.png" >
  </a>

  <!-- 버튼 영역 -->
  <div style="margin-left: 500px;">
  
  <span>
  <!-- 로그인시 본인의 프로필로 저장 -->
  <c:if test="${sessionScope.loginok==null }">
  	<img src="../image2/user.png" class="loginimg">
  </c:if>
  <c:if test="${sessionScope.loginok!=null }">
  	<img src="../membersave/${sessionScope.loginphoto }" class="loginimg">
  </c:if>
  
  
  &nbsp;</span>
  
  
  <!--로그인 로그아웃시 버튼변경  -->
  <c:if test="${sessionScope.loginok==null }">
    <button type="button" class="btn btn-success"
      data-bs-toggle="modal" data-bs-target="#myLoginModal">
      Login
    </button>
  </c:if>
  <c:if test="${sessionScope.loginok!=null }">
    <button type="button" class="btn btn-danger"
      data-bs-toggle="modal"  id="btnlogout">
      Logout
    </button>
  </c:if>
    
   
       
 
  </div>
</div>

<!-- The Modal -->
<div class="modal" id="myLoginModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

     
      <!-- Modal body -->
      <div class="modal-body">
        <div class="container mt-5" style="max-width: 400px;">
   
    
      <div class="mb-3">
        <label for="inputId" class="form-label">아이디</label>
        <input type="text" class="form-control" id="loginid" placeholder="아이디를 입력하세요">
      </div>
      <div class="mb-3">
        <label for="inputPassword" class="form-label">비밀번호</label>
        <input type="password" class="form-control" id="loginpass" placeholder="비밀번호를 입력하세요">
      </div>
      
      
      	<button type="button" class="btn btn-primary w-100" id="btnlogin">로그인</button>
      
   
  </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

 
 <ul class="mymenu">
    
    <li>
       <a href="${root }/">Home</a>&nbsp;
    </li>
    <li>
       <a href="${root }/ipgo/list">상품목록</a>
    </li>
    <li>
       <a href="${root }/member/form">회원가입</a>
    </li>
    <li>
       <a href="${root }/member/list">회원목록</a>
    </li>
    
    <c:if test="${sessionScope.loginok!=null }">
	    <li>
	       <a href="${root }/member/mypage">마이페이지</a>
	    </li>
    </c:if>
    
    
    
    <li>
       <a href="${root }/board/list">회원게시판</a>
    </li>
 </ul>
 
 <script type="text/javascript">
 
     //로그인버튼 클릭시 로그인되게
     $("#btnlogin").click(function(){
    	 
    	 //아이디,패스 읽기
    	 var id=$("#loginid").val();
    	 var pass=$("#loginpass").val();
    	 
    	 
    	 $.ajax({
    		 type:"get",
    		 dataType:"json",
    		 url:"/member/login",
    		 data:{"id":id,"pass":pass},
    		 success:function(res){
    			 if(res.result=='fail')
    				 alert("아이디나 비밀번호가 맞지않습니다");
    			 else
    				 location.reload();
    		 }
    		 
    	 });
    	 	 
     });
     
     
     //로그아웃
    	 $("#btnlogout").click(function(){
    		 
    		 $.ajax({
    			 type:"get",
    			 url:"/member/logout",
    			 dataType:"html",
    			 success:function(){
    				 location.href="${root}/";
    			 }
    		 });
    		 
    	 });    
 </script>
</body>
</html>