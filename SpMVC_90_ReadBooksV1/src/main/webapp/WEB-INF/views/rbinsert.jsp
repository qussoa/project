<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<legend>감상록 작성</legend>
			<label for="rb_seq" class="in-label">번호</label>
			<div class="in-box">
				<input name="rb_seq" id="rb_seq" value="${readBookDTO.rb_seq}">
			</div>
			<label for="rb_bcode" class="in-label">도서코드</label>
			<div class="in-box">
				<input name="rb_bcode" id="rb_bcode" value="${readBookDTO.rb_bcode}">
			</div>
			<label for="rb_date" class="in-label">독서날짜</label>
			<div class="in-box">
				<input name="rb_date" id="rb_date" value="${readBookDTO.rb_date}">
			</div>
			<label for="rb_stime" class="in-label">독서시작시각</label>
			<div class="in-box">
				<input name="rb_stime" id="rb_stime" value="${readBookDTO.rb_stime}">
			</div>
			<label for="rb_rtime" class="in-label">독서종료시각</label>
			<div class="in-box">
				<input name="rb_rtime" id="rb_rtime" value="${readBookDTO.rb_rtime}">
			</div>
			<label for="rb_subject" class="in-label">제목</label>
			<div class="in-box">
				<input name="rb_subject" id="rb_subject"
					value="${readBookDTO.rb_subject}">
			</div>
			<label for="rb_text" class="in-label">본문</label>
			<div class="in-box">
				<input name="rb_text" id="rb_text" value="${readBookDTO.rb_text}">
			</div>
			<label for="rb_star" class="in-label">별점</label>
			<div class="in-box">
				<input name="rb_star" id="rb_star" value="${readBookDTO.rb_star}">
			</div>
			<label class="in-label"></label>
			<div class="in-box">
				<button >저장</button>
			</div>
		</fieldset>
	</form>
</body>
</html>