<%@page import="hoewon.HoewonDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="hoewon.HoewonDao"%>
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
  //db선언
  HoewonDao dao=new HoewonDao();
  //List가져오기
  List<HoewonDto> list=dao.getHoewonList();
  %>
<body>
  <!--번호   회원명   비밀번호    아이디   가입날짜  수정/삭제 -->
  <div style="margin: 100px 100px; width: 800px;">
	<b>총 <%=list.size()%> 명의 멤버가 있습니다</b>
	<button type="button" class="btn btn-info"
	onclick="location.href='../hlog/loginform.jsp'"
	style="margin-left:400px;">Login</button>
	<br>
	<table class="table table-bordered">
		<caption align="top"><b>전체 회원 명단</b></caption>
		<tr bgcolor="#ccc">
			<th width="80">번호</th>
			<th width="120">아이디</th>
			<th width="120">회원명</th>
			<th width="150">핸드폰</th>
			<th width="200">가입일</th>
			<th width="150">관리</th>			
		</tr>
		<%
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		int i=1;
		for(HoewonDto dto:list)
		{%>
		  
			<tr align="center">
				<td><%=i++%></td>
				<td><%=dto.getMid()%></td>
				<td><b><%=dto.getName()%></b></td>
				<td><%=dto.getHp() %></td>
				
				<td><%=sdf.format(dto.getGaipday()) %></td>
				<td>
									
					<button type="button" class="btn btn-danger btn-sm"
					onclick="location.href='deletePassForm.jsp?num=<%=dto.getNum()%>'">강퇴</button>					
				</td>
			</tr>
		<%}
		%>
	</table>
</div>
  
</body>
</html>