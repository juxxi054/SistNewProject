<%@page import="ajaxmemo.MemoDao"%>
<%@page import="ajaxmemo.MemoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8");
   
	//수정폼의 num,writer,content,emot
	String num=request.getParameter("unum");
	String writer=request.getParameter("uwriter");
	String content=request.getParameter("ucontent");
	String emot=request.getParameter("uemot");
	
	//dto에 넣기
	MemoDto dto=new MemoDto();
	dto.setNum(num);
	dto.setWriter(writer);
	dto.setContent(content);
	dto.setEmot(emot);
	
	//dao
	MemoDao dao=new MemoDao();
	//수정메서드 호출
	dao.updateMemo(dto);
%>