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

[type=radio],[type=checkbox] {
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
		<legend>회원가입</legend>
		<form:form modelAttribute="userDTO" autocomplete="on"
			class="user-form">
			
			

			<form:input type="email" path="u_id" class="in-box"
				placeholder="e-mail 주소 " /><br />		
			<form:input type="password" path="u_password" class="in-box"
				placeholder="비밀번호 입력" /><br />

			<input type="password" id="re_password" placeholder="비밀번호 재확인" />

			<form:input path="u_name" class="in-box" placeholder="이름 입력" /><br />
			<form:input path="u_nick" class="in-box" placeholder="별명 입력" /><br />

			<form:input type="number" path="u_tel" class="in-box" placeholder="전화번호 입력" />
			<br />
			
			<div class="cat-box">
				<form:checkboxes path="u_hobby" items="${HO_LIST}" itemLabel="h_name"
					itemValue="h_code" />

			</div>
			<button>ENTER</button>
		</form:form>
	</fieldset>
</body>
</html>