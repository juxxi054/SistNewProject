<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<style type="text/css">
#myimg {
	position: absolute;
	left: 600px;
	top: 100px;
	max-width: 300px;
}
</style>
<script type="text/javascript">
	$(function() {

		$("#upload").change(function(e) {
			const file = e.target.files[0];
			if (file) {
				const reader = new FileReader();

				reader.onload = function(event) {
					$("#myimg").attr("src", event.target.result);
				};

				reader.readAsDataURL(file);
			}

		});
	});
</script>
</head>
<body>
	<div style="margin: 100px 100px; width: 500px;">
		<form action="update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${dto.num }">
			<table class="table table-bordered">
				<tr>
					<th class="table-success" width="100">작성자</th>
					<td><input type="text" name="writer" required="required"
						class="form-control" style="width: 150px;" value="${dto.writer }">
					</td>
				</tr>
				<tr>
					<th class="table-success" width="100">제목</th>
					<td><input type="text" name="subject" required="required"
						class="form-control" style="width: 350px;" value="${dto.subject }">
					</td>
				</tr>
				<tr>
					<th class="table-success">상품이미지</th>
					<td><input type="file" name="upload" class="form-control"
						id="upload" style="width: 300px;"></td>
				</tr>

				<tr>
					<td colspan="2"><textarea
							style="width: 480px; height: 100px;" required="required"
							name="content" class="form-control">
           ${dto.content }
           </textarea></td>
				</tr>



				<tr>
					<td colspan="2" align="center"><input type="submit"
						class="btn btn-outline-success" value="상품저장"> <input
						type="button" class="btn btn-outline-info" value="상품목록"
						onclick="location.href='list'"></td>
				</tr>
			</table>
		</form>

		<img alt="" src="../save/${dto.photo }" id="myimg">
	</div>
</body>
</html>