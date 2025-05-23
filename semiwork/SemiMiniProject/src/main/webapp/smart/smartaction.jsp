<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="data.Dto.SmartDto"/>
<jsp:useBean id="dao" class="data.Dao.SmartDao"/>
<jsp:setProperty property="*" name="dto"/>
<%
  dao.insertSmart(dto);
  response.sendRedirect("../index.jsp?main=smart/content.jsp?num="+dao.getMaxNum());
%>