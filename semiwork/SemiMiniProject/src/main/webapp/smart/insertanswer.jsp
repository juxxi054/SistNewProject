<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="data.Dao.SmartAnswerDao"/>
<jsp:useBean id="dto" class="data.Dto.SmartAnswerDto"/>
<jsp:setProperty property="*" name="dto"/>

<%
   dao.insertAnswer(dto);
%>