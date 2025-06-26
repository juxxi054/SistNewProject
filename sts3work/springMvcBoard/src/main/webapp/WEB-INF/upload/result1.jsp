<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>제목: ${title }</h2>


<c:if test="${fileName=='no' }">
<b>이미지 없음</b>
</c:if>
<c:if test="${fileName!='no' }>
<img="">
</c:if>

<h2>업로드할 실제경로: ${path }</h2>
</body>
</html>