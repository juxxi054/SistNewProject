<%@page import="booking.BookingDto"%>
<%@page import="booking.BookingDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Poetsen+One&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<%
 String num=request.getParameter("num");
 BookingDao dao=new BookingDao();
 BookingDto dto=dao.getData(num);
%>
<style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: white;
        }
        .booking-card {
            max-width: 700px;
            margin: 80px auto;
            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
            border-radius: 10px;
            background-color: white;
            overflow: hidden;
        }
        .booking-header {
            background-color: #e9f4ef;
            color: black;
            padding: 20px;
            text-align: center;
            font-size: 24px;
            font-weight: 400;
        }
        table {
            margin-bottom: 0;
        }
        th {
            width: 200px;
            background-color: #e9f7ef !important;
        }
        .btn-group {
            padding: 15px;
            text-align: right;
        }
        .btn + .btn {
            margin-left: 10px;
        }
    </style>
</head>
<body>

<div class="booking-card">
    <div class="booking-header">
        <%=dto.getName() %>님의 예약 정보
    </div>
    <table class="table">
        <tr>
            <th>예약자명</th>
            <td><%=dto.getName() %></td>
        </tr>
        <tr>
            <th>주문시간</th>
            <td><%=dto.getWriteday() %></td>
        </tr>
        <tr>
            <th>인원수</th>
            <td><%=dto.getInwon() %>명</td>
        </tr>
        <tr>
            <th>예약시간</th>
            <td><%=dto.getBookday() %></td>
        </tr>
        <tr>
            <th>예약메세지</th>
            <td><%=dto.getMessage() %></td>
        </tr>
        <tr>
            <th>예약메뉴</th>
            <td><%=dto.getFoodphoto() %>
            <%=dto.getFoodprice() %></td>
        </tr>
         <tr>
            <th>금액</th>
          <td><%=dto.getFoodprice() %> 원</td>
        </tr>
    </table>
    <div class="btn-group">
        <button class="btn btn-success" onclick="location.href='bookingUpdate.jsp?num=<%=dto.getNum()%>'">수정</button>
        <button class="btn btn-danger" onclick="funcDel(<%=num%>)">예약취소</button>
        <button class="btn btn-secondary" onclick="location.href='bookingList.jsp'">목록</button>
    </div>
</div>

</body>
</html>