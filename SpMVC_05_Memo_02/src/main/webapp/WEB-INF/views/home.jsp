<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
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
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html, body {
	font-family: BinggraeMelona;
	height: 100%;
}

body {
	width: 100;
	display: flex;
	flex-flow: column wrap;
}

header {
	background-color: #D9D4CF;
	text-align: center;
	margin: 0.8rem;
	color: #7C7877;
	font-size: 50px;
}

footer {
	flex: 0 0 auto;
	background-color: #D9D4CF;
	color: #7C7877;
	text-align: center;
	padding: 0.2rem;
	background-color: #D9D4CF;
}

section#main-body {
	/* flex: 1 0 auto 화면 가득히 box 채우기*/
	flex-grow: 1; /* 최대화 크기*/
	flex-shrink: 0; /* 최소화 */
	flex-basis: auto;
	background-color: #F0E5DE;
	display: flex;
}

section#main-body article {
	flex: 5;
}

section#main-body aside {
	flex: 1;
	border: 5px solid #D9D4CF;
	background-color: #F0E5DE;
	padding: 16px;
	border-radius: 10px;
}

section#main-body ul {
	list-style: none;
	margin-left: 16px;
	color: #7C7877;
}

section#main-body li a {
	/*
	a tag width, height를 설정하기 위해서
	display를 block inline-block
*/
	display: inline-block;
	width: 100px;
	border-bottom: 1px solid #D9D4CF;
	padding: 10px 16px;
	text-decoration: none;
}

section#main-body li a:hover {
	background-color: #ABD0CE;
	color: #7C7877;
}

article.list {
	border: 1px solid #D9D4CF;
	height: 80%;
	overflow: auto;
}

div.b-box {
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 0.8rem;
}

div.b-box button {
	background-color: #ABD0CE;
	color: #F0E5DE;
	font-weight: bold;
	padding: 8px 16px;
	border: 0px;
	border-radius: 5px;
}

div.s-box button:hover {
	background-color: #ABD0CE
}

div.s-box input {
	display: block;
	width: 90%;
	margin: 10px auto;
}
</style>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>□□□ 나의 JSP page □□□</title>
<script src="${rootPath}/js/jquery-3.4.1.js"></script>

<script>
$(function() {
	$("#btn-insert").click(function() {
		document.location.href="${rootPath}/memo/insert"
	})
})

</script>
</head>
<body>
	<header>simple memo</header>
	<h3></h3>
	<section id="main-body">
		<article>
			<div class="s-box">
				<form>
					<input type="text" name="search">
				</form>
			</div>
			<article class="list">
				<%@ include file="/WEB-INF/views/list.jsp"%>
			</article>
			<div class="b-box">
				<button id="btn-insert">write</button>
			</div>
		</article>
		<aside>
			<ul>
				<li><a href="#">to-do</a></li>
				<li><a href="#">약속</a></li>
				<li><a href="#">중요메모</a></li>
			</ul>
		</aside>
	</section>

	<footer>
		<address>CopyRight &copy; qussoa@naver.com</address>
	</footer>

</body>
</html>