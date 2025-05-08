<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="uploadAction.jsp" method="post"
enctype="multipart/form-data">
  <table class="table table-bordered" style="width: 500px;">
    <tr>
      <th>이름</th>
      <td>
        <input type="text" name="name">
      </td>
    </tr>
    <tr>
      <th>제목</th>
      <td>
        <input type="text" name="subject">
      </td>
    </tr>
    <tr>
      <th>파일</th>
      <td>
        <input type="file" name="uploadFile">
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <button type="submit">업로드</button>
      </td>
    </tr>
  </table>
</form>
</body>
</html>