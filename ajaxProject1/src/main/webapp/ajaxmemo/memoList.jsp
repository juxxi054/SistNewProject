<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="ajaxmemo.MemoDto"%>
<%@page import="java.util.List"%>
<%@page import="ajaxmemo.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  MemoDao dao=new MemoDao();
  //전체목록 가져오기
  List<MemoDto>list=dao.getAllMemos();
  
  JSONArray arr=new JSONArray();
  
  //arr에 size만 내보내기
  /*JSONObject size=new JSONObject();
  size.put("size", list.size());
  arr.add(size);*/
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
  for(MemoDto dto:list)
  {
	  JSONObject ob=new JSONObject();
	  ob.put("num", dto.getNum());
	  ob.put("writer", dto.getWriter());
	  ob.put("content", dto.getContent());
	  ob.put("emot", dto.getEmot());
	  ob.put("writeday", sdf.format(dto.getWriteday())  );
	  
	  //arr에추가
	  arr.add(ob);
  }
  
%>

<%=arr.toString()%>