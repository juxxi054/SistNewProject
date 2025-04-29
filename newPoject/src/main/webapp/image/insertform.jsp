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
<body>
 <div style="margin-left:50px">
 <form action="./insertAction.jsp" method="post">
 <table class="table table-bordered" style="width: 600px";>
 <tr>
 <th>이름</th>
 <td>
 <input type="text" name="name" class="form-control"
 style="width:150px;" required="required">
 </td>
 </tr>
 
 <tr>
 <th>주소</th>
 <td>
 <input type="text" name="addr" class="form-control"
 style="width:150px;" required="required">
 </td>
 </tr>
 
 <tr>
 <th>핸드폰</th>
 <td>
 <input type="text" name="hp" class="form-control"
 style="width:150px;" required="required">
 </td>
 </tr>
 
 <tr>
 <td colspan="2" align="center">
 <input type="submit" value="DB전송" class="btn btn-success">
 <input type="button" value="목록이동" onclick="location.href='helloList.jsp'"
 class="btn btn-warning">
  
 </td>
 </tr>
 
 </table>
 </form>
 </div>
</body>
</html>
