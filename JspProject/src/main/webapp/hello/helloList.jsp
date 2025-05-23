<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Vector"%>
<%@page import="hello.HelloDao"%>
<%@page import="hello.HelloDto"%>
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
</head>
<% 
HelloDao dao=new HelloDao();
Vector<HelloDto> list=dao.getAllHelloDatas();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 ");
%>
<body>
<div style="margin: 50px 100px;">
  <button type="button" class="btn btn-info btn-sm"
  onclick="location.href='InsertForm.jsp'" style="margin-left: 800px;">글쓰기</button>
   <table class="table table-bordered" style="width: 1000px;">
       <caption align="top"><b>HelloJsp 전체 목록 출력</b></caption>
       <tr class="table-warning">
          <th width="80">번호</th>
          <th width="120">이름</th>
          <th width="300">주소</th>
          <th width="200">전화번호</th>
          <th width="200">가입날짜</th>
          <th width="150">편집</th>
       </tr>
       
       <%
         for(int i=0;i<list.size();i++)
         {
        	 HelloDto dto=list.get(i);
        	 %>
        	 <tr>
        	   <td align="center"><%=i+1 %></td>
        	   <td><%=dto.getName() %></td>
        	   <td><%=dto.getAddr() %></td>
        	   <td><%=dto.getHp() %></td>
        	   <td><%=sdf.format(dto.getCurdate()) %></td>
        	   <td>
        	      <button type="button" class="btn btn-success btn-sm"
        	      onclick="location.href='UpdateInsertForm2.jsp?num=<%=dto.getNum()%>'">수정</button>
        	      <button type="button" class="btn btn-danger btn-sm"
        	      onclick="location.href='delete.jsp?num=<%=dto.getNum()%>'">삭제</button>
        	   </td>
        	 </tr>
         <%}
       %>
       
       
   </table>
</div>
</body>
</html>