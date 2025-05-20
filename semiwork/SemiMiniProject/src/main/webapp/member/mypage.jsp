<%@page import="data.Dao.MemberDao"%>
<%@page import="data.Dto.MemberDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
  function delfunc(num){
	   //alert(num);
	   $("#delnum").val(num);
	   $("#myDelModal").modal('show');
	   
	   //삭제버튼 이벤트
	   $("button.btndel").click(function(){
		   
		   //num,pass읽기
		   var num=$("#delnum").val();
		   var pass=$("#delpass").val();
		   
		   //alert(num+","+pass);
		   //삭제파일 호출
		   location.href="member/deletemypage.jsp?num="+num+"&pass="+pass;
	   });
  }

</script>
</head>
<%
  MemberDao dao=new MemberDao();
  List<MemberDto> list=dao.getAllMembers();
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 HH시");
  
  String loginok=(String)session.getAttribute("loginok");
  String myid=(String)session.getAttribute("mid");
%>
<body>
  <div style="margin: 200px 100px;  width: 700px;">
    <h3 class="alert alert-warning" style="width: 700px;">회원정보</h3>
    <table class="table table-bordered">
        <%
          for(MemberDto dto:list)
          {
          
        	if(loginok!=null && myid.equals(dto.getId())){%>
        		
        		<tr>
        	    <td rowspan="4" align="center" valign="middle">
        	      <img alt="" src="image2/user.png" 
        	      style="width: 100px; height: 100px; border-radius: 100px;">
        	    </td>
        	    <td>회원명: <%=dto.getName() %></td>
        	    <td rowspan="4" align="center" valign="middle">
        	      <button type="button" class="btn btn-outline-warning btn-sm"
        	      onclick="location.href='index.jsp?main=member/updateform.jsp?num=<%=dto.getNum()%>'">수정</button><br><br>
        	      <button type="button" 
        	      class="btn btn-outline-danger btn-sm" onclick="delfunc('<%=dto.getNum()%>')">탈퇴</button>
        	    </td>
        	  </tr>
        	  <tr>
        	    <td>
        	      아이디: <%=dto.getId() %>
        	    </td>
        	  </tr>
        	  <tr>
        	    <td>
        	       이메일: <%=dto.getEmail() %>
        	    </td>
        	  </tr>
        	  <tr>
        	    <td>
        	       가입일: <%=sdf.format(dto.getGaipday()) %>
        	    </td>
        	  </tr>
         <% }
        %>
        	<%}
          
          %>
        	  
    </table>
  </div>
  
  
  <!-- Modal -->
<div class="modal fade" id="myDelModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">삭제확인</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      <input type="hidden" id="delnum">
        <b>삭제비밀번호:  </b>
        <input type="password" class="form-control" style="width: 120px;" id="delpass">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary btndel">Delete</button>
      </div>
    </div>
  </div>
</div>
  
  
  
  
</body>
</html>