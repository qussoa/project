<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function() { // <input>요소에 문자가 입력될 때마다 호출됨.

		$("#btn-search").click(function() {
			let book = $("#search-box").val()
			document.location.href = "${rootPath}/list?b_name=" + book
		})

	})
</script>
<style>
* {
 font-family: BinggraeMelona-Bold;

}
@font-face {
	font-family: 'BinggraeMelona-Bold';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/BinggraeMelona-Bold.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

header {
text-align: center;
font-size: 30px;
height: 50px;
margin: 0 auto;
}
 div {
 text-align: center;
 justify-content: center;
 }
</style>
<title>bookproject</title>
</head>
<body>
	<header>
		<h3>책을 찾아줘</h3>
	</header>
	<article>
		<div class="s-box">
			<form>
				<input type="text" name="book" id="search-box">
				<button type="button" id="btn-search">검색</button>
			</form>
		</div>
	</article>
	<div>
		<a href="${rootPath}/member/login">로그인</a><span></span> <a href="${rootPath}/member/join">회원등록</a>
	</div>
</body>
</html>