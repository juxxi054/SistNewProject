<%@page import="data.Dao.GuestAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String idx=request.getParameter("idx");
  GuestAnswerDao dao=new GuestAnswerDao();
  dao.deleteGuestAnswer(idx);
%>