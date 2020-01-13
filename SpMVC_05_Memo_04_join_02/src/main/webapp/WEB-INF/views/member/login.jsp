<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
<link rel="stylesheet" type="text/css" href="${rootPath}/css/login.css?ver=20191203"/>
</head>
<body>
	<form method="POST" action="${rootPath}/member/login" class="login-form">
		<h2>SIGN-IN</h2>
		<c:if test="${LOGIN_MSG == 'FAIL'}">
		<h3>you missed your id or password</h3>
		</c:if>
		<c:if test="${LOGIN_MSG == 'TRY'}">
		<h3>you have to sign-in</h3>
		</c:if>
		
		<c:if test="${LOGIN_MSG == 'NO_AUTH'}">
		<h3>ONLY READ AUTH </h3>
		</c:if>
		
		<c:if test="${LOGIN_MSG == '0'}">
		<h3>welcome sign-in</h3>
		</c:if>
		<input type="text" name="u_id" placeholder="USER ID">
		<input type="password" name="u_password" placeholder="USER PW">
		<button>LOGIN</button>
		<c:if test="${LOGIN_MSG == '0'}">
		<button>JOIN</button>
		</c:if>
	</form>
</body>
</html>