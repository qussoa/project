<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
*{
font-family: Cafe24Oneprettynight;
}
@font-face {
	font-family: 'Cafe24Oneprettynight';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Oneprettynight.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

header {
	background-color: rgba(0, 255, 45, 0.6);
	padding: 1rem;
	color: green;
}

nav {
	display: flex;
	background-color: green;
	padding: 14px 16px;
}

nav button {
	background-color: rgba(0, 255, 255, 0.72);
	padding: 14px 16px;
	outline: 0;
	color: white;
	font-size: 15px;
}

section.main-container {
	display: flex;
	flex-wrap: wrap;
}

div.d-box {
	width: 300px;
	margin: 20px;
	border: 1px solid red;
	border-radius: 10px;
	padding: 10px 16px;
}

b {
	color: blue;
}

a.title {
	color: inherit;
	text-decoration: none;
}

p.title {
	font-size: 20px;
	font-size: bold; white-space : nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

div.d-box:hover {
	background-color: #ddd;
	color: inherit;
	text-decoration: none;
	color: inherit;
}

input, select {
	padding: 8px;
	margin: 5px;
}
</style>
<title>□□□ 나의 JSP page □□□</title>
</head>

<body>
	<header>
		<h3>네이버 검색</h3>
	</header>
	<nav>
		<form action="${rootPath}/naver/news">
			<select name="cat">
				<option value="news">뉴스</option>
				<option value="book">도서</option>
				<option value="movie">영화</option>
			</select> <input name="search" placeholder="검색어를 입력한 후 Enter">
			<button>검색</button>
		</form>
	</nav>
	<section class="main-container">
		<c:forEach items="${NAVER_ITEMS}" var="item">
			<a href="${item.link}" target="_new" class="title">
		
				<div class="d-box">
					<p class="title">${item.title}</p>
					<c:if test="${item.image != null }">
					<img src="${item.image}">
					</c:if>
					<p>${item.description}</p>
				</div>
			</a>
		</c:forEach>
	</section>
</body>
</html>