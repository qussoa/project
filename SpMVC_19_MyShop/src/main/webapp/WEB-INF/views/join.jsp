<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.login-form {
	width: 400px;
	padding: 40px;
	background: #F0E5DE;
	text-align: center;
	z-index: 10;
	border-radius: 20px;
	box-shadow: 12px 12px 2px 1px #ABD0CE;
	margin: 2px auto;
}

.login-form h2 {
	color: #7C7877;
	font-weight: 500px;
}

.login-form h3 {
	color: #7C7877;
	font-weight: 300px;
	background-color: #F0E5DE;
	border-radius: 20px;
}

.login-form input {
	background: none;
	margin: 10px auto;
	text-align: center;
	border: 2px solid #ABD0CE;
	padding: 14px 10px;
	width: 200px;
	outline: none;
	color: #7C7877;
	border-radius: 25px;
	transition: 0.2s
}

.login-form input:focus {
	width: 200px;
	border-color: #ABD0CE;
}

.login-form button {
	border: 2px solid #ABD0CE;
	padding: 14px 40px;
	background: none;
	display: block;
	margin: 2px auto;
	padding: 14px 40px;
	outline: none;
	color: #7C7877;
	border-radius: 25px;
	cursor: pointer;
}

.login-form button:hover {
	background-color: #ABD0CE;
	color: #F0E5DE;
}

.naver_login img {
	border-radius: 10px;
}

/*
	div box에 img를 2개 가져오고 
	초기에는 2번째 이미지를 감춰둔다
*/
.naver_login img:last-child {
	display: none;
}

.naver_login:hover img:last-child {
	display: inline-block;
}

.naver_login:hover img:first-child {
	display: none;
}
</style>
<script>
	$(function() {

		$("#btn-join").click(function() {

			// 유효성 검사 
			// id, password가 입력되지 않았을 때 경고
			let username = $("#username")
			let password = $("#password")
			let re_password = $("#re_password")

			if (username.val() == "") {
				alert("아이디를 입력하시오")
				username.focus()
				return false;
			}
			if (password.val() == "") {
				alert("비밀번호를 입력하시오")
				password.focus()
				return false;
			}
			if (re_password.val() == "") {
				alert("비밀번호 재확인 입력하시오")
				re_password.focus()
				return false;
			}
			if (password.val() != re_password.val()) {
				alert("비밀번호 재확인 입력하시오")
				re_password.focus()
				return false;
			}
			$("form").submit()
		})
	})
</script>

<form:form method="POST" action="${rootPath}/auth/join"
	class="login-form">
	<h2>JOIN</h2>
	<input type="text" id="username" name="username" placeholder="USER ID">
	<input type="password" id="password" name="password"
		placeholder="USER PW">
	<input type="password" id="re_password" name="re_password"
		placeholder="USER ReEnter PW">
	<button type="button" id="btn-join">JOIN</button>
</form:form>










