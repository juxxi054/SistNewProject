<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="dao" class="uploadboard.UboardAnswerDao"/>
 <jsp:useBean id="dto" class="uploadboard.UboardAnswerDto"/>
 <jsp:setProperty property="*" name="dto"/>
<%
  dao.updateAnswer(dto);
%>