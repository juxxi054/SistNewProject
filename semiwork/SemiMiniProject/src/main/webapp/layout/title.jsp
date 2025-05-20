<%@page import="data.Dao.MemberDao"%>
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
a{
color: black;
	text-decoration: none;
}
</style>
</head>
<%
   //프로젝트 경로구해기
   String root=request.getContextPath();
  //로그인세션
  String loginok=(String)session.getAttribute("loginok");
  //id
   String myid=(String)session.getAttribute("id");
  //dao,id==>name
 MemberDao dao=new MemberDao();
 String name=dao.getName(myid); 
%>
<body>
<div style="float:right; padding-right: 100px;"></div>
<a href="<%=root%>/">
   <img alt="" src="image2/title.png">
   
   <%
   if(loginok==null){%>
    
    <button type="button" class="btn btn-success" style="width:100px;"
    oclick=locaction.href=></button>
      
   <%} 
   
   %>
  
   
</a>
</body>
</html>