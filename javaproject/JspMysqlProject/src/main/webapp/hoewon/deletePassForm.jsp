<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Poetsen+One&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<style type="text/css">
#wrap{
position: absolute;
left: 50%;
top: 50%;
transform: translate(-50%,-50%);
}
</style>
</head>
<%
//num을 읽어서 form 에 hidden으로 넣는다
  String num=request.getParameter("num");
%>
<body>
<div id="wrap">
   <form action="deleteAction.jsp" >
   <input type="hidden" name="num" value="<%=num%>">
      <h4 class="alert alert-info" style="width: 150px;">비밀번호</h4>
      <input type="password" class="form-control"
      name="pass" style="width: 150px;" required="required">
      <br>
      <button type="submit" class="btn btn-danger btn-sm"
      style="width: 150px;">삭제</button>
   </form>
</div>
</body>
</html>