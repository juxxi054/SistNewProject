<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="mymall.MymallDto"%>
<%@page import="java.util.List"%>
<%@page import="mymall.MymallDao"%>
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
</head>
<% 
MymallDao dao=new MymallDao();
List<MymallDto> list=dao.getAllSangPums();
NumberFormat nf=NumberFormat.getCurrencyInstance();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
<div style=>
<h3 class="alert alert-info">MyMall 전체목록</h3>
<br>
<button type="button" class="btn btn-warning"
onclick="location.href='addForm.jsp'">상품추가</button>
<br>
<table class="table table-bordered">
<tr>
<th width="80">번호</th>
<th width="180">상품명</th>
<th width="80">색상</th>
<th width="180">가격</th>
<th width="180">등록일</th>

</tr>
<%
      if(list.size()==0){
    	  %>
    	  <tr>
    	    <td colspan="5" align="center">
    	      <b>등록된 상품이 없습니다</b>
    	    </td>
    	  </tr>
      <%}else{
    	  
    	  for(int i=0;i<list.size();i++)
    	  {
    		  MymallDto dto=list.get(i);
    		  %>
    		  
    		  <tr>
    		    <td><%=i+1 %></td>
    		    <td>
              <a href="detailPage.jsp?num=<%= dto.getNum() %>">
            <%= dto.getSangpum() %>
               </a>
    </td>
    		    <td style="background-color: <%=dto.getColor()%>"></td>
    		    <td align="right"><%=nf.format(dto.getPrice()) %></td>
    		    <td><%=sdf.format(dto.getWriteday()) %></td>
    		  </tr>
    	  <%}
    	  
      }
    %>
  </table>
</div>
</body>
</html>