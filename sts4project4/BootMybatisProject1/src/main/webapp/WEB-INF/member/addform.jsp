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
    
    #showimg{
      width: 140px;
      height: 160px;
      border: 1px solid gray;
    }
</style>
<script type="text/javascript">
  $(function(){
	  
	  //버튼클릭시 사진을 불러오기
	  $("#btnphoto").click(function(){
		  $("#myphoto").trigger("click");
	  });
	  
	  //사진을 불러오면 이미지 미리보기
	  $("#myphoto").change(function(e) {
        const file = e.target.files[0];
        if (file) {
            const reader = new FileReader();
            
            reader.onload = function(event) {
                $("#showimg").attr("src", event.target.result);
            };
            
            reader.readAsDataURL(file);
        }

	  });
	  
	  
	  //2번째 비밀번호 입력시 체크
	  $("#pass2").keyup(function(){
		  
		  var p1=$("#pass").val();
		  var p2=$("#pass2").val();
		  
		  if(p1==p2)
			  $("span.passsuccess").text("ok");
		  else
			  $("span.passsuccess").text("fail");
	  });
	  
	  
	  
		//아이디 입력 중복체크
	  
	  $("#btnidcheck").click(function(){
		  
		  $.ajax({
			  
			  type:"get",
			  dataType:"json",
			  url:"idcheck",
			  data:{"id":$("#loginid").val()},
			  success:function(res){
				  if(res.idresult==0)
					  $("span.idsuccess").text("ok");
				  else{
					  $("span.idsuccess").text("fail");
					  $("#loginid").val('');
				  }
					 
			  }
		  });
		  
	  });
	  
	  
	  
  });

  //submit하기전에 호출
  function check(){
	  //사진
	 if($("#myphoto").val()==''){
		 alert("프로필사진을 넣어주세요");
		 return false;
	 }
	  
	  //중복체크
	  if($("span.idsuccess").text()!='ok'){
		  alert("아이디 중복체크를 해주세요");
			 return false;
	  }
	  
	  
	  //비밀번호
	  if($("span.passsuccess").text()!='ok'){
		  alert("비밀번호가 서로다릅니다");
			 return false;
	  }
  }

</script>
</head>
<body>
  <div class="container">
   <jsp:include page="../../layout/header.jsp"></jsp:include>
   <br><br><br>
   
   <form action="insert"  method="post" enctype="multipart/form-data" onsubmit="return check()">
     <table class="table table-bordered" style="width: 600px;">
        <caption align="top"><b>회원가입</b></caption>
        <tr>
          <td style="width: 250px;" rowspan="5" align="center">
              <input type="file" id="myphoto" name="myphoto" style="display: none;">
              <br>
              <button type="button" id="btnphoto"
              class="btn btn-secondary">프로필사진선택</button><br><br>
              <img alt="" id="showimg">
              
          </td>
          <td >
          <div class="input-group">
            <input type="text" placeholder="아이디입력" id="loginid"
            name="id" class="form-control" style="max-width: 120px;" required="required">&nbsp;&nbsp;&nbsp;
            <button type="button" class="btn btn-danger btn-sm"
            id="btnidcheck">중복체크</button>&nbsp;&nbsp;&nbsp;
            
            <span class="idsuccess" style="width: 60px; color: green;"></span>
            </div>
          </td>
        </tr>
        
        <tr>
          <td>
          <div class="input-group">
            <input type="password" style="width: 120px;" class="form-control" name="pass" id="pass"
            placeholder="숫자4자리" required="required">&nbsp&nbsp
            <input type="password" style="width: 120px;" class="form-control" id="pass2"
            placeholder="숫자4자리" required="required">  &nbsp&nbsp
            <span class="passsuccess" style="width: 60px;"></span>
            </div>
          </td>
        </tr>
        
        <tr>
          <td>
            <input type="text" name="name" style="width: 150px;" class="form-control"
            required="required" placeholder="이름입력">
          </td>
        </tr>
        <tr>
          <td>
            <input type="text" name="hp" style="width: 250px;" class="form-control"
            required="required" placeholder="전화번호입력">
          </td>
        </tr>
        <tr>
          <td>
            <input type="text" name="email" style="width: 300px;" class="form-control"
            required="required" placeholder="이메일입력">
          </td>
        </tr>
        
        <tr>
          <td colspan="2" align="center">
            <input type="submit" class="btn btn-outline-primary" value="회원가입" style="width: 200px;">
             
          </td>
        </tr>
     </table>
   </form>
   
   
   </div>
</body>
</html>