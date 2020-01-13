<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
<style>
@font-face {
	font-family: 'BinggraeMelona';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/BinggraeMelona.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: BinggraeMelona;
}

fieldset {
	width: 70%;
	margin: 20px auto;
	border: 1px solid #D9D4CF;
	border-radius: 10px;
}

legend {
	font-weight: bold;
	font-size: 20px;
}

input, textarea {
	display: inline-block;
	width: 90%;
	padding: 8px;
	margin: 5px;
	border-radius: 20px;
	outline: none;
}

input:focusm textarea:focus, button {
	border: 2px solid #D9D4CF;
	outline: none;
}

div.cat-box {
	width: 90%;
	padding: 6px;
	padding-top: 4px;
	padding-bottom: 10px;
}

[type=radio] {
	width: 24px;
	height: 24px;
	position: relative;
	margin-left: 15px;
	top: 6px;
	text-align: top;
}
</style>
</head>
<body>
	<fieldset>
		<legend>메모작성</legend>
		<form:form modelAttribute="dto" autocomplete="on" class="memo-form">
			<input name="m_seq" type="hidden"
				value='<c:out value="${dto.m_seq}" default="0"/>'>

			<div class="cat-box">
				<form:radiobuttons path="m_cat" items="${CATS}" itemLabel="catName"
					itemValue="catValue" />

			</div>
			<form:input path="m_auth" class="in-box" placeholder="작성자 id" />
			<br />
			<form:input type="date" path="m_date" class="in-box"
				placeholder="작성일자" />
			<br />
			<form:input type="time" path="m_time" class="in-box"
				placeholder="작성시각" />
			<br />

			<form:input path="m_subject" class="in-box" placeholder="제목" />
			<br />
			<form:textarea path="m_text" rows="5" />
			<br />
			<button>ENTER</button>
		</form:form>
	</fieldset>
</body>
</html>