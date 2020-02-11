<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
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
		
		$(".naver_login").click(function() {
			document.location.href="${rootPath}/member/naver"
		})
		
		$("#btn-join").click(function() {
			document.location.href = "${rootPath}/member/join"
		})

		$("btn-login").click(
				function() {

					// 유효성 검사 
					// id, password가 입력되지 않았을 때 경고
					let u_id = $("#u_id").val()
					if (u_id == "") {
						alert("아이디를 입력하시오")
						$("#u_id").focus()
						return false;
					}

					/*
					var params = $("form").serialize();
					$.ajax({
						url : "${rootPath}/rest/member/login",
						type : 'POST',
						data: params,
						dataType:'json',
						success : function(result) {
							alert(result)
						}
					})
					
					 */
					$.post("${rootPath}/rest/member/login", $("form")
							.serialize(), function(result) {
						alert(result)
						document.location.href = document.location.href
						//alert(result)
					})

				})
	})
</script>

<form:form method="POST" action="${rootPath}/login" class="login-form">
	<h2>SIGN-IN</h2>
	<c:if test="${param.error != null }">
		<h3>you missed your id or password</h3>
	</c:if>
	<c:if test="${LOGIN_MSG == 'TRY'}">
		<h3>you have to sign-in</h3>
	</c:if>

	<c:if test="${LOGIN_MSG == 'NO_AUTH'}">
		<h3>ONLY READ AUTH</h3>
	</c:if>

	<c:if test="${LOGIN_MSG == '0'}">
		<h3>welcome sign-in</h3>
	</c:if>
	<!-- spring form tag를 사용하면 생략 가능
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
	 -->
	<input type="text" id="username" name="username" placeholder="USER ID">
	<input type="password" id="password" name="password"
		placeholder="USER PW">
	<button type="submit" id="btn-login">LOGIN</button>

	<button type="submit" id="btn-join">JOIN</button>
</form:form>










