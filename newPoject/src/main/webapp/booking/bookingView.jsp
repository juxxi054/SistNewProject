<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="booking.BookingDto"%>
<%@page import="booking.BookingDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<style type="text/css">
  body *{
    font-family: 'Nanum Myeongjo';
  }
</style>
<script type="text/javascript">
   function fundel(num){
	   
	  // alert(num); 삭제버튼에서 보낸 num값 확인
	  
	  var a=confirm("해당주문사항을 삭제하려면 [확인]을 눌러주세요");
	  //확인클릭시 a 는 true
	  if(a){
		  location.href="deleteBooking.jsp?num="+num;
	  }
   }
</script>
<title>Insert title here</title>
</head>
<body>
<%
	//num 읽기
	String num=request.getParameter("num");
	
	//dao 선언
	BookingDao dao=new BookingDao();
	
	//num 에 해당하는 dto 얻기
	BookingDto dto=dao.getBooking(num);
	
	//NumberFormat,SimpleDateFormat
	NumberFormat nf=NumberFormat.getCurrencyInstance();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//dto데이타를 출력하는데
	//foodphoto 는 컴마로 분리해서 이미지로 출력
	String []fphoto=dto.getFoodphoto().split(",");
			
	//foodprice 는 컴마로 분리해서 반복문에서 총금액에 더하는데
	//이때 int로 변환후 더해야한다
	String []fprice=dto.getFoodprice().split(",");
	
	int totalmoney=0;//총금액
%>
<div  style="margin: 30px 30px;width: 700px;">
	<h4  class="alert alert-danger">예약 상세보기</h4>
	<table class="table table-bordered" style="font-size: 20px;">
		<tr>
			<th width="100" style="background-color:#ffb6c1;">예약자명</th>
			<td>
				<img src="../image/bookimage/<%=dto.getGender().equalsIgnoreCase("m")?"male":"female"%>.png" width="40">
				&nbsp;
				<%=dto.getName()%>
			</td>
		</tr>
		<tr>
			<th width="100" style="background-color:#ffb6c1;">예약시간</th>
			<td><%=dto.getBookday()%></td>
		</tr>
		<tr>
			<th width="100" style="background-color:#ffb6c1;">예약인원수</th>
			<td><%=dto.getInwon()%>명</td>
		</tr>		
		<tr>
			<th width="100" style="background-color:#ffb6c1;">주문한시간</th>
			<td><%=sdf.format(dto.getWriteday())%></td>
		</tr>
		<tr>
			<th width="100" style="background-color:#ffb6c1;">주문메세지</th>
			<td>
				<pre><%=dto.getMessage()%></pre>
			</td>
		</tr>
		<tr>
			<th width="100" style="background-color:#ffb6c1;">주문메뉴</th>
			<td>
			<%			
			for(int i=0;i<fphoto.length;i++)
			{
				//숫자형태라도  문자열이므로 int로 변환후 계산
				int price=Integer.parseInt(fprice[i]);
				totalmoney+=price; //같은변수에 계속더해서 총금액구한다
				//이미지명에서 확장자를 뺀 파일명만 분리한다 ,split으로도 가능
				//.의 위치얻는방법
				int dotloc=fphoto[i].indexOf('.');
				//.의 위치 전까지 분리하기
				String menuname=fphoto[i].substring(0,dotloc);
				
				//split분리..방법2  m[0]으로 출력하면 됨
				//String [] m=fphoto[i].split("[.]");
				
			 %>
			 <div class="input-group">
				 <img src="../image/bookimage/<%=fphoto[i]%>" width="80" height="80" border="1"
				 style="margin-left: 30px;margin-bottom: 5px;">
				 
				 <h4 style="width: 200px;margin-left: 30px;"><%=menuname%></h4>
				 &nbsp;
				 <%=nf.format(price)%>
			 </div>
			 <br>
			<%}
			%>
			<h3>총 결재 금액 : <%=nf.format(totalmoney) %></h3>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" class="btn btn-warning"
					 style="width: 120px;" 
					 onclick="location.href='bookingUpdateForm.jsp?num=<%=num%>'">수정</button>
					 
				<button type="button" class="btn btn-danger"
					 style="width: 120px;" 
					 onclick="fundel(<%=num%>)">삭제</button>
					 
				<button type="button" class="btn btn-info"
					 style="width: 120px;" 
					 onclick="location.href='bookingList.jsp'">목록</button>
			</td>
		</tr>
	</table>

</div>
</body>
</html>