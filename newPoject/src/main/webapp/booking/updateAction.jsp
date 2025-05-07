<%@page import="booking.BookingDao"%>
<%@page import="booking.BookingDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
  request.setCharacterEncoding("utf-8");

  String num=request.getParameter("num");
  String name=request.getParameter("name");
  String gender=request.getParameter("gender");
  String message=request.getParameter("message");
  int inwon=Integer.parseInt(request.getParameter("inwon"));
  String bookday=request.getParameter("bookday");
  
  //메뉴와 가격(,로 연결해서 dto에 넣는다)
  String foodname="";
  String foodprice="";
  
  String [] food=request.getParameterValues("food");
  
  for(String f:food)
  {
	  System.out.println(f);
	  //,로분리해서 앞에가 name,뒤는 price ,추가
	 String [] data=f.split(",");
	  foodname+=data[0]+",";
	  foodprice+=data[1]+",";
  }
  
  //반복문 나와서 마지막 ,지우기
  foodname=foodname.substring(0, foodname.length()-1);
  foodprice=foodprice.substring(0, foodprice.length()-1);
  
  System.out.println(foodname); 
  System.out.println(foodprice);
  
  //dto에담기
  BookingDto dto=new BookingDto();
  dto.setNum(num);
  dto.setName(name);
  dto.setGender(gender);
  dto.setBookday(bookday);
  dto.setInwon(inwon);
  dto.setMessage(message);
  dto.setFoodphoto(foodname);
  dto.setFoodprice(foodprice);
  
  //dao선언
  BookingDao dao=new BookingDao();
  //수정메서드 호출
  dao.updatebooking(dto);
  
  //예약상세페이지로
  response.sendRedirect("bookingView.jsp?num="+num);
  
  
  
%>
</body>
</html>