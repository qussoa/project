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
			= "${rootPath}/pro/update?id=${PRODUCT_DTO.p_code}"
		})
		$(".btn-delete").click(
			function() {
			let p_code = "${PRODUCT_DTO.p_code}"
			let msg = "상품이름 : ${PRODUCT_DTO.p_name}\n"
			msg += "매입단가 : ${PRODUCT_DTO.p_iprice}"
			msg += "매출단가 : ${PRODUCT_DTO.p_oprice}"
			msg += "삭제할까요?"
		if (confirm(msg)) {
		document.location.href 
		= "${rootPath}/pro/delete?id=${PRODUCT_DTO.p_code}"
		}
		})
	})
</script>
<body>
	<%@ include file="/WEB-INF/views/include/include-pro-header.jspf"%>

	<section>
		<table>
			<tr>
				<th>상품코드</th>
				<td>${PRODUCT_DTO.p_code}</td>
				<th>상품명</th>
				<td>${PRODUCT_DTO.p_name}</td>
			</tr>
			<tr>
				<th>매입단가</th>
				<td>${PRODUCT_DTO.p_iprice}</td>
				<th>매출단가</th>
				<td>${PRODUCT_DTO.p_oprice}</td>
			</tr>
			<tr>
				<th>부가세</th>
				<td colspan="3">${PRODUCT_DTO.p_vat}</td>
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