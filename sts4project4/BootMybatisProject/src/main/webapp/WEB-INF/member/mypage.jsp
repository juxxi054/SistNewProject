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
	  
	  //버튼클릭시 파일열기
	  $(".btnnewphoto").click(function(){
		  $("#newphoto").trigger("click");
	  });
	  
	  
	  $("#newphoto").change(function(){
		  
		  var num=$(this).attr("num");
		  console.log(num);
		  
		  var form=new FormData();
		  form.append("photo",$("#newphoto")[0].files[0]);//선택한 1개만추가
		  form.append("num",num);
		  
		  console.dir(form);
		  
		  $.ajax({
			  
			  type:"post",
			  dataType:"html",
			  url:"updatephoto",
			  processData:false,
			  contentType:false,
			  data:form,
			  success:function(){
				  location.reload();
			  }
		  });
		  
	  });
	  
	  
	  //수정버튼 클릭할때 모달에 넣기
	  $(".btnupdate").click(function(){
		  
		 updatenum= $(this).attr("num");
		 //alert(updatenum);
		 
		 $.ajax({
			 type:"get",
			 dataType:"json",
			 url:"updateform",
			 data:{"num":updatenum},
			 success:function(res){
				 
				 console.dir(res);
				 $("#updatename").val(res.name);
				 $("#updatehp").val(res.hp);
				 $("#updateemail").val(res.email);
				 
			 }
		 })
	  });
	  
	  //수정
	  $("#btnupdateok").click(function(){
		  
		 var updatename= $("#updatename").val();
		 var updatehp= $("#updatehp").val();
		 var updateemail= $("#updateemail").val();
		 
		 var data="num="+updatenum+"&name="+updatename+"&hp="+updatehp+"&email="+updateemail;
		 
		// alert(data);
		
		$.ajax({
			
			type:"post",
			dataType:"html",
			url:"update",
			data:data,
			success:function(){
				location.reload();
			}
		});
		
	  });
	  
	  
	  //mypage탈퇴
	  $(".btndelete").click(function(){
		  
		  var num=$(this).attr("num");
		  //alert(num);
		  
		  var ok=confirm("정말 탈퇴하실건가요??");
		  if(ok){
			  $.ajax({
				  
				  type:"get",
				  dataType:"html",
				  url:"deleteme",
				  data:{"num":num},
				  success:function(){
					  alert("탈퇴하셨습니다");
					  location.href="${root}/";
				  }
				  
			  })
		  }
		  
	  });
	  
  });

</script>
</head>
<body>

<div class="container">
   <jsp:include page="../../layout/header.jsp"></jsp:include>
   
<div  style="margin: 200px; width: 600px;">
       <table class="table table-bordered">
          <c:forEach  var="dto" items="${list }">
          
          <c:if test="${sessionScope!=null && sessionScope.myid==dto.id }">
          
            <tr>
               <td style="width: 220px;" align="center" rowspan="5">
                  <img alt="" src="../membersave/${dto.photo }" width="200px;">
                  <br>
                  <input type="file" id="newphoto" style="display: none;" num="${dto.num }"><br>
                  <button type="button" class="btn btn-info btnnewphoto">사진수정</button>
               </td>
               <td>아이디:  ${dto.id }</td>
               <td rowspan="4" valign="middle" align="center">
                  <button type="button" class="btn btn-outline-warning btn-sm btnupdate" 
                  num="${dto.num }" 
                  data-bs-toggle="modal" data-bs-target="#myUpdateModal">수정</button><br><br>
                  <button type="button" class="btn btn-outline-danger btn-sm btndelete"
                  num="${dto.num }">탈퇴</button>
               </td>
            </tr>
            <tr>
              <td>${dto.name }</td>
            </tr>
            <tr>
              <td>${dto.hp }</td>
            </tr>
            <tr>
              <td>${dto.email }</td>
            </tr>
            <tr>
              <td>${dto.gaipday }</td>
            </tr>
            
           </c:if> 
            
           
          </c:forEach>
       </table>
    </div>
</div>

<!-- 수정모달 -->
<!-- The Modal -->
<div class="modal" id="myUpdateModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

     
      <!-- Modal body -->
      <div class="modal-body">
        <div class="container mt-5" style="max-width: 400px;">
   
    
      <div class="mb-3">
        <label for="inputId" class="form-label">이름</label>
        <input type="text" class="form-control" id="updatename" >
      </div>
      <div class="mb-3">
        <label for="inputPassword" class="form-label">전화번호</label>
        <input type="text" class="form-control" id="updatehp" >
      </div>
      <div class="mb-3">
        <label for="inputPassword" class="form-label">이메일</label>
        <input type="text" class="form-control" id="updateemail" >
      </div>
      
      	<button type="button" class="btn btn-primary w-100" id="btnupdateok">수정</button>
      
  </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>


</body>
</html>