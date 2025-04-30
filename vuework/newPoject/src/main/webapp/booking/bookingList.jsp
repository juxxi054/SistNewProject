<%@page import="java.util.List"%>
<%@page import="booking.BookingDto"%>
<%@page import="java.util.Vector"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="booking.BookingDao"%>
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
  body *{
    font-family: 'Nanum Myeongjo';
  }
</style>
</head>
<%
  BookingDao dao=new BookingDao();
  List <BookingDto> list=dao.getAllBookings();
%>
<body>
<div  style="margin: 100px 100px; width: 700px;">
    <div>
       <h4 class="alert alert-success">전체 예약목록 확인</h4>
       <button type="button" class="btn btn-warning"
       onclick="location.href='bookingForm.jsp'"
       style="margin-left: 600px;">예약하기</button>
       
    </div>
    
    <h5>총 <%=list.size() %> 팀의 예약이 있습니다</h5>
    <br>
    <table  class="table table-bordered">
       <tr class="table-warning">
         <th width="100">번호</th>
         <th width="180">예약자명</th>
         <th width="100">인원수</th>
         <th width="180">예약시간</th>
         <th width="150">상세보기</th>
       </tr>
       
       <%
       for(int i=0;i<list.size();i++)
       {
    	   BookingDto dto=list.get(i);%>
    	   
    	   <tr>
    	     <td align="center"><b><%=i+1 %></b></td>
    	     <td>
    	     
    	     <img alt="" src="../image/bookimage/">
    	       <b><%=dto.getName() %></b>
    	     </td>
    	     <td align="center"><%=dto.getInwon() %></td>
    	     <td><%=dto.getBookday() %></td>
    	     <td align="center">
    	       <button type="button" class="btn btn-warning btn-sm"
    	       onclick="location.href='bookingView.jsp?num=<%=dto.getNum()%>'">상세보기</button>
    	     </td>
    	   </tr>
       <%}
       %>
    </table>
</div>
</body>
</html>