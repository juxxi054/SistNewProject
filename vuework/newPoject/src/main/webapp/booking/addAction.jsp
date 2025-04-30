<%@page import="booking.BookingDao"%>
<%@page import="booking.BookingDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8");

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
  dto.setName(name);
  dto.setGender(gender);
  dto.setBookday(bookday);
  dto.setInwon(inwon);
  dto.setMessage(message);
  dto.setFoodphoto(foodname);
  dto.setFoodprice(foodprice);
  
  BookingDao dao=new BookingDao();
  dao.insertBooking(dto);
  
  //목록
  response.sendRedirect("bookingList.jsp");
  
  
  
%>