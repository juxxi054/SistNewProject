<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>

<h3 class="alert alert-info">3번째 출력</h3>
<br>
<h4>메뉴이름 입력후 엔터를 눌러주세요</h4>
<input type="text" id="search" class="form-control"
style="width:150px";>
<br><br>
<h2 id="foodname"></h2>
<br>
<img alt="" src="" id="photo">

<script type="text/javascript">
//메뉴명 입력후 엔터 누르면 출력
$("#search").keyup(function (e) {

	if(e.keyCode==13)
		{
		
		$.ajax({
			
			typr="get",
			dataType="json",
			url="list3",
			data:{"name",name},
			success:function(res){
				
				$("#foodName").text(res.name);
				$("#photo").attr("src","photo/Food/"+res.photo);
			}
		
		})
		
		}
	
})

</script>
</body>
</html>