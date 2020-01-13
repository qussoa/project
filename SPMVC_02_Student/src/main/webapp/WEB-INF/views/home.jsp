<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<html>
<head>
<title>Home</title>
<style>
header {
	background: #E0F2F7;
	margin: 0;
	padding: 1rem;
	color: #086A87;
	text-align: center;
}

header h3 {
	font-size: 2rem;
}

ol {
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
	background-color: #EFF8FB;
}

ol a {
	display: block;
	text-decoration: none;
	padding: 14px 16px;
}

ol a:hover {
	background-color: #E0F2F7;
	color: blue;
	border-bottom: 3px solid #E0F2F7;
}

* {
	font-family: 'Nanum Myeongjo', serif;
	font-family: 'Indie Flower', cursive;
	font-family: 'Do Hyeon', sans-serif;
}
</style>
</head>
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Indie+Flower|Nanum+Myeongjo&display=swap"
	rel="stylesheet">

<body>

	<header>
		<h3>학생정보관리</h3>
	</header>
	<!-- Ul : unordered List 약자 -->
	<ol>
		<li><a href="${rootPath}/student/list">학생리스트</a></li>
		<li><a href="${rootPath}/student/search">학생검색</a></li>
		<li><a href="#">로그인</a></li>
		<li><a href="#">회원가입</a></li>
	</ol>
</body>
</html>
