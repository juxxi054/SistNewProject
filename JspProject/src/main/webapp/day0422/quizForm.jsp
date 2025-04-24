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
<form action="quizAction.jsp">
<table>
<tr>
<th>사원명</th>
<td>
<input type="text" name="s_name" required="required">
</td>
</tr>
<tr>
         <th>근무지역</th>
         <td>
           <input type="checkbox" name="cbarea" >해외
         </td>
<tr>
<th>입사일자</th>
<td>
<input type="date" name="ipsaday" required="required">
</td>
</tr>

<tr>
<th>명절선물 선택 (택1)</th>
<td>
<select name="gift">
<option  value="../image/logoImg/acc01.png">시계</option>
<option  value="../image/logoImg/acc02.png">스카프</option>
<option  value="../image/logoImg/acc03.png">향수</option>
<option  value="../image/logoImg/acc04.png">가방</option>

</select>
</td>
</tr>

<tr>
<td>가장 좋았던 점심메뉴 (택1)</td>
<td>
<input type="radio" name="food" value="1">샌드위치 &nbsp;
<input type="radio" name="food" value="2">꼬치구이 &nbsp;
<input type="radio" name="food" value="3">순두부백반 &nbsp;
<input type="radio" name="food" value="4">에그덮밥 &nbsp;
<input type="radio" name="food" value="5">햄에그볶음밥 &nbsp;
</td>
</tr>

<tr>
<td>사원의 가능 IT 언어 (다중선택 가능))</td>
<td>
<input type="checkbox" name="lang" value="C언어">C언어 &nbsp;
<input type="checkbox" name="lang" value="JAVA">JAVA &nbsp;
<input type="checkbox" name="lang" value="VUE">VUE &nbsp;
<input type="checkbox" name="lang" value="ORACLE">ORACLE &nbsp;
<input type="checkbox" name="lang" value="NODEJS">NODEJS &nbsp;
</td>
</tr>

 <tr>
        <th>배경색 선택</th>
        <td>
          <input type="color" name="colors" value="#ffcccc">
        </td>
        
      </tr>
      
      <tr>
        <td>
          <input type="submit" value="사원선택결과">
        </td>
      </tr>
      

</table>
</form>
</body>
</html>
