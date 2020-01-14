<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
</head>
<body>
	<form method="POST">
		<fieldset>
			<legend>도서정보입력</legend>
			<label for="b_code" class="in-label">도서코드</label>
			<div class="in-box">
				<input name="b_code" id="b_code" value="${bookDTO.b_code}">
			</div>
			<label for="b_name" class="in-label">도서명</label>
			<div class="in-box">
				<input name="b_name" id="b_name" value="${bookDTO.b_name}">
			</div>
			<label for="b_auther" class="in-label">저자</label>
			<div class="in-box">
				<input name="b_auther" id="b_auther" value="${bookDTO.b_auther}">
			</div>
			<label for="b_comp" class="in-label">출판사</label>
			<div class="in-box">
				<input name="b_comp" id="b_comp" value="${bookDTO.b_comp}">
			</div>
			<label for="b_year" class="in-label">출판년도</label>
			<div class="in-box">
				<input name="b_year" id="b_year" value="${bookDTO.b_year}">
			</div>
			<label for="b_iprice" class="in-label">도서가격</label>
			<div class="in-box">
				<input name="b_iprice" id="b_iprice" value="${bookDTO.b_iprice}">
			</div>
			<label class="in-label"></label>
			<div class="in-box">
				<button>저장</button>
			</div>
		</fieldset>
	</form>
</body>
</html>



