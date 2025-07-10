<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>

<div style="margin: 100px 100px; width: 800px;">
  <button type="button" class="btn btn-outline-primary"
  onclick="location.href='form'">글작성하기</button>
  <br>
  <h6 class="alert alert-success">총 ${count }개의 게시글이 있습니다</h6>
  <br>
 <table class="table table-bordered" >
		<tr class="table-warning">
			<th width="100">번호</th>
			<th width="400">제목</th>
			<th width="120">작성자</th>
			<th width="180">작성일</th>			
		</tr>
		<c:if test="${count==0}">
			<tr>
				<td colspan="4" align="center">
					<b>등록된 글이 없습니다</b>
				</td>
			</tr>
		</c:if>
		<c:if test="${count>0}">
			<c:forEach var="dto" items="${list}" varStatus="i">
				<c:set var="no" value="${count-i.index}"/>
				<tr>
					<td>${no}</td>
					<td>
						<a href="detail?num=${dto.num }" style="color: black; text-decoration: none;">
							${dto.subject}
						</a>
						
						<c:if test="${dto.photo!='no' }">
						    <i class="bi bi-card-image" style="color: gray;"></i>
						</c:if>
					</td>
					<td>${dto.writer}</td>
					<td>
						<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</div>
</body>
</html>