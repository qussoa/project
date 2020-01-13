<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${ pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
<%@ include file="/WEB-INF/views/include/include-css.jspf"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<style>
p#insert {
	margin-left: 40px;
}

th {
	background-color: white;
	text-align: right;
}

td {
	background-color: white;
}

tr {
	background-color: white;
}

div.btn-box {
	display: flex;
	width: 100%;
	background-color: white;
	justify-content: center;
	align-content: center;
	padding: 10px;
	margin: 10px;
}

button {
	border-radius: 5px;
	outline: none;
	margin-right: 10px auto;
	padding: 10px 15px;
}

button:hover {
	background: green;
	color: white;
	cursor: pointer;
}

.btn-update {
	background-color: white;
	color: green;
}

.btn-delete {
	background-color: white;
	color: green;
}
</style>
<script>
	$(function() {
		$(".btn-update").click(function() {
			document.location.href
			= "${rootPath}/dept/update?id=${DEPT_DTO.d_code}"
		})
		$(".btn-delete").click(
			function() {
			let d_code = "${DEPT_DTO.d_code}"
			let msg = "거래처 : ${DEPT_DTO.d_name}\n"
			msg += "대표 : ${DEPT_DTO.d_ceo} "
			msg += "삭제할까요?"
		if (confirm(msg)) {
		document.location.href 
		= "${rootPath}/dept/delete?id=${DEPT_DTO.d_code}"
		}
		})
	})
</script>
<body>
	<%@ include file="/WEB-INF/views/include/include-dept-header.jspf"%>

	<section>
		<table>
			<tr>
				<th>거래처코드</th>
				<td>${DEPT_DTO.d_code}</td>
				<th>거래처명</th>
				<td>${DEPT_DTO.d_name}</td>
			</tr>
			<tr>
				<th>대표</th>
				<td>${DEPT_DTO.d_ceo}</td>
				<th>전화번호</th>
				<td>${DEPT_DTO.d_tel}</td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="3">${DEPT_DTO.d_addr}</td>
			</tr>
			<tr>
				<td colspan="4">
					<div class="btn-box">
						<button class="btn-update">수정</button>
						<button class="btn-delete">삭제</button>
					</div>
				</td>
			</tr>
		</table>

	</section>

</body>
</html>