<%@page import="mymall.MymallDto"%>
<%@page import="mymall.MymallDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript">
function funcDel(num) {
	var yes=confirm("삭제하시겠습니까?");
	if(yes){
		
		location.href="delete.jsp?num="+num;
	}
}
</script>
<title>Insert title here</title>
</head>
<%
 String num=request.getParameter("num");
 MymallDao dao=new MymallDao();
 MymallDto dto=dao.getData(num);
%>

<body>
 <div style="margin: 100px 100px; width: 600px;">
 <table class="table table-bordered">
  <caption align="top"><h2 class="alert alert-success"><%=dto.getSangpum()%>의 상세페이지</h2></caption>
        <tr>
           <th width="200" class="table-success">상품이미지</th>
           <td>
     <img src="../image/쇼핑몰사진/<%=dto.getPhoto()%>.jpg" width="100" height="100" alt="상품 이미지">
   </td>
</tr>
 
  <tr>
           <th width="200" class="table-success">상품명</th>
            <td><%=dto.getSangpum()%></td>
</tr>

 <tr>
           <th width="200" class="table-success">가격</th>
            <td><%=dto.getPrice()%></td>
</tr>

<tr>
    <th width="200" class="table-success">색상</th>
    <td>
        <%= dto.getColor() %>
        <div style="display:inline-block; width:40px; height:40px; margin-left:10px; background-color:<%= dto.getColor() %>; border:1px solid #000;"></div>
    </td>
</tr>

 <tr>
           <th width="200" class="table-success">입고일</th>
           <td><%=dto.getIpgoday()%></td>
</tr>

 <tr>
          <td colspan="2" align="right">
            <input type="button" class="btn btn-success" value="수정"
            onclick="location.href='updateAction.jsp?num=<%=dto.getNum()%>'">
            <input type="button" class="btn btn-success" value="삭제"
            onclick="funcDel(<%=num%>)">
            <input type="button" class="btn btn-success" value="목록"
            onclick="location.href='mallList.jsp'">
          </td>
        </tr>
 
 </table>
 </div>
</body>
</html>