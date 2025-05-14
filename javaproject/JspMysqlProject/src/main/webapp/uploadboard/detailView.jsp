<%@page import="uploadboard.uploadeDto"%>
<%@page import="uploadboard.uploadDao"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<style type="text/css">
  div.alist span.aday{
    float: right;
    font-size: 0.8em;
    color: #bbb;
  }
</style>
<script type="text/javascript">
  $(function(){
	  
	  //처음시작시 댓글목록 호출
	  list();
	  
	  //insert
	  var num=$("#num").val();
	  console.log(num);
	  
	  $("#btnSend").click(function(){
		  
		  var nickname=$("#nickname").val().trim();
		  var content=$("#content").val().trim();
		  
		  if(nickname==''){
			  alert('닉네임을 입력후 저장해주세요');
			  return;
		  }
		  if(content==''){
			  alert('댓글내용을 입력후 저장해주세요');
			  return;
		  }
		  
		  //ajax로 insert해보기
		  $.ajax({
			  
			  type:"get",
			  url:"../uploadboard/insertAnswer.jsp",
			  dataType:"html",
			  data:{"num":num,"nickname":nickname,"content":content},
			  success:function(){
				 // alert("insert_success");
				 //기존입력값 지우기
				 $("#nickname").val('');
				 $("#content").val('');
				 
				 //list호출
				 list();
			  },
			  statusCode:{
				  404:function(){
					  alert("파일이 없다");
				  },
				  500:function(){
					  alert("서버오류..코드 다시한번 볼것!!!")
				  }
			  }
		  });
		  
		  
	  });
	  
	  
	//삭제
	  $(document).on("click",".adel",function(){
		  
		  var a=confirm("댓글을 삭제하려면 [확인]을 눌러주세요");
		  //idx얻기
		  var idx=$(this).attr("idx");
		  //alert(idx);
		  
		  if(a){
			  $.ajax({
				  type:"get",
				  url:"../uploadboard/deleteAnswer.jsp",
				  dataType:"html",
				  data:{"idx":idx},
				  success:function(){
					  
					  alert("삭제되었습니다");
					  list();
				  },
				  statusCode:{
					  404:function(){
						  alert("파일이 없습니다");
					  },
					  500:function(){
						  alert("서버오류...코드다시볼것!!!")
					  }
				  }
			  });
		  }
	  });
			
	  //댓글버튼 누르면 댓글창보이게
	  $("b.acount").click(function(){
		  $("div.aupdateform").hide();
		  $("div.aform").toggle();
	  })
	  
	  //수정창 안보이게
	  $("div.aupdateform").hide();
	  
	  //수정버튼 누르면 수정폼
	  $(document).on("click",".amod",function(){
		  $("div.aform").hide();
		  $("div.aupdateform").show();
		  
		  var idx=$(this).attr("idx");
		  //alert(idx);
		  $("#idx").val(idx);
		  
		  $.ajax({
			  type:"get",
			  dataType:"json",
			  url:"../uploadboard/dtoAnswer.jsp",
			  data:{"idx":idx},
			  success:function(res){
				  $("#idx").val(res.idx);
				  $("#unickname").val(res.nick);
				  $("#ucontent").val(res.content);
				  
			  }
		  })
		  
	  });
	  
	  //수정
	  $("#btnUSend").click(function(){
		  
		  var idx=$("#idx").val();
		  var nick=$("#unickname").val();
		  var content=$("#ucontent").val();
		  //alert(nick+","+content);
		  
		  $.ajax({
			  type:"post",
			  url:"../uploadboard/updateAnswer.jsp",
			  dataType:"html",
			  data:{"idx":idx,"nickname":nick,"content":content},
			  success:function(){
				  list();
				  $("div.aupdateform").hide();
				  $("div.aform").show();
			  }
		  });
	  });
	  
  });
  	
				
			
  
  function list()
  {
	  //댓글출력
	  console.log("list num="+$("#num").val());
	  
	  $.ajax({
		  
		  type:"get",
		  url:"../uploadboard/listAnswer.jsp",
		  dataType:"json",
		  data:{"num":$("#num").val()},
		  success:function(res){
			  
			 //댓글갯수 출력
			  $("b.acount>span").text(res.length);
			 
			 var s="";
			 $.each(res,function(idx,item){
				 
				 s+="<div>"+item.nickname+": "+item.content;
				 s+="<span class='aday'>"+item.writeday+"</span>&nbsp;&nbsp;&nbsp;&nbsp;";
				 s+="<i class='bi bi-trash' idx="+item.idx+"></i>";
				 s+="<i class='bi bi-pencil-square' idx="+item.idx+"></i>";
				 
			 });
			 
			 $("div.alist").html(s);
		  }
	  });
  }
</script>
</head>
<%
  String num=request.getParameter("num");
  uploadDao dao=new uploadDao();
  uploadeDto dto=dao.getData(num);
  //조회수
  dao.updateReadcount(num);
  
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
  //현재페이지번호 
  String currentPage=request.getParameter("currentPage");

%>
<body>

<input type="hidden" id="num" value="<%=num%>">
<!--제목 작성자 작성일 조회수  이미지  내용
  글쓰기,수정,삭제,목록 버튼 -->
  <div style="margin: 100px 100px;">
  <table class="table table-bordered" style="width: 600px;">
     <tr>
       <td>
         <h4><b><%=dto.getSubject() %></b></h4>
         <br>
         <span><%=dto.getWriter() %></span><br>
         <span style="color: gray; font-size: 9pt;"><%=sdf.format(dto.getWriteday()) %></span>
         <span style="color: gray; font-size: 9pt;">조회수: <%=dto.getReadcount() %></span>
       </td>
      
     </tr>
     <tr>
       <td style="padding-left: 50px;">
          <%=dto.getContent().replace("\n", "<br>") %>
          <br><br>
          <!-- 이미지 누르면 원래사이즈-->
          <a href="../save/<%=dto.getImgname()%>">
            <img alt="" src="../save/<%=dto.getImgname()%>" style="max-width: 200px;">
          </a>
       </td>
     </tr>
     
     
     <!-- 댓글 -->
     <tr>
       <td>
          <b class="acount">댓글<span>0</span></b>
          <div class="alist">
              댓글목록
          </div>
          <div class="aform input-group">
            <input type="text" id="nickname" class="form-control"
            style="width: 80px;" placeholder="닉네임">
            <input type="text" id="content" class="form-control"
            style="width: 300px; margin-left: 10px;" placeholder="댓글메세지">
            <button type="button" id="btnSend"
            class="btn btn-info btn-sm" style="margin-left: 10px;">저장</button>
          </div>
       </td>
     </tr>
     
     
     
     
     
     <tr>
       <td align="right">
         <button type="button" class="btn btn-outline-primary"
         onclick="location.href='addForm.jsp'">글쓰기</button>
          <button type="button" class="btn btn-outline-primary"
         onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>'">수정</button>
          <button type="button" class="btn btn-outline-primary"
         onclick="location.href='deletePassForm.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>'">삭제</button>
          <button type="button" class="btn btn-outline-primary"
         onclick="location.href='boardList.jsp?currentPage=<%=currentPage%>'">목록</button>
       </td>
     </tr>
  </table>
  </div>
</body>
</html>