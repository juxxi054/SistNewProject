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
<title>Insert title here</title>
<style type="text/css">
  body *{
     font-family: 'Nanum Myeongjo';
  }
</style>
<script type="text/javascript">
   function check(){
	    var len=$("input[name='food']:checked").length;
	    if(len<2){
	    	alert("주문메뉴는 최소 2개이상 선택해 주세요");
	    	return false;
	    }
   }
</script>
</head>
<%
  //num
  String num=request.getParameter("num");
  //dao
  BookingDao dao=new BookingDao();
  //num에대한 dto
  BookingDto dto=dao.getBooking(num);
%>
<body>
  <div style="margin: 100px 100px; width: 650px;">
  
  <!-- onsubmit이벤트는 action이 호출되기 전에 발생
  리턴값을 false로 받으면 action이 호출되지 않는다 -->
     <form action="updateAction.jsp" method="post" onsubmit="return check()">
     <input type="hidden" name="num" value="<%=num%>">
        <table class="table table-bordered">
           <tr>
             <th width="100" style="background-color: beige;">예약자명</th>
             <td>
               <input type="text" name="name" class="form-control"
               autofocus="autofocus" required="required" style="width: 200px;"
               value="<%=dto.getName() %>" >
             </td>
           </tr>
           
           <tr>
             <th width="100" style="background-color: beige;">성별</th>
             <td>
               <label>
                  <input type="radio" name="gender" value="f"
                  <%=dto.getGender().equalsIgnoreCase("f")?"checked":"" %>>
                  <img alt="" src="../image/bookimage/female.png" width="50">
               </label>
               &nbsp;
               <label>
                  <input type="radio" name="gender" value="m" 
                  <%=dto.getGender().equalsIgnoreCase("m")?"checked":"" %>>
                  <img alt="" src="../image/bookimage/male.png" width="50">
               </label>
             </td>
             
           </tr>
           
           <tr>
             <th width="100" style="background-color: beige;">예약시간</th>
             <td>
               <input type="datetime-local" name="bookday" class="form-control"
               style="width: 300px;" required="required"
               value="<%=dto.getBookday()%>">
             </td>
           </tr>
           
           <tr>
             <th width="100" style="background-color: beige;">인원수</th>
             <td>
               <input type="number" name="inwon" min="2" max="6"
               class="form-control" style="width: 80px;" value="<%=dto.getInwon()%>">
             </td>
           </tr>
           
           <tr>
              <th width="100" style="background-color: beige;">메뉴선택</th>
              <td>
                 
                 <%
                   //메뉴명
                   String [] inputFood={"갈비찜.jpg","에그샌드위치.jpg","에그인헬.jpg","망고샤벳.jpg","치킨꼬치.jpg"};
                   //가격
                   String [] inputPrice={"23000","12000","18000","15000","23000"};
                   //음식명
                   String []title={"갈비찜","에그샌드위치","에그인헬","망고샤벳","치킨꼬치"};
                   //db에 저장된 선택메뉴들
                   String [] selectFood=dto.getFoodphoto().split(",");
                   
                   for(int i=0;i<inputFood.length;i++)
                   {
                	   boolean find=false;
                	   
                	   for(int j=0;j<selectFood.length;j++)
                	   {
                		   if(inputFood[i].equals(selectFood[j]))
                			   find=true;
                	   }
                	   %>
                	   
                	   <label>
                	     <input type="checkbox" name="food" value="<%=inputFood[i]%>,<%=inputPrice[i]%>"
                	     <%=find?"checked":"" %>><%=title[i] %><br>
                	     <img alt="" src="../image/bookimage/<%=inputFood[i]%>" width="80"
                	     height="80" border="1">
                	   </label>
                   <%}
                 %>
                 
                 
                 
              </td>
           </tr>
           
           <tr>
              <th width="100" style="background-color: beige;">메세지</th>
              <td>
                <textarea style="width: 500px; height: 80px;"
                class="form-control" required="required" name="message">
                 <%=dto.getMessage() %>
                </textarea>
              </td>
           </tr>
           
           <tr>
             <td colspan="2" align="center">
                <button type="submit" class="btn btn-outline-danger"
                style="width: 120px;">예약수정</button>
                <button type="reset" class="btn btn-outline-danger"
                style="width: 120px;">다시하기</button>
                <button type="button" class="btn btn-outline-danger"
                style="width: 120px;" onclick="location.href='bookingList.jsp'">예약목록</button>
             </td>
           </tr>
        </table>
     </form>
  </div>
</body>
</html>