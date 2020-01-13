<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${ pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
<%@ include file="/WEB-INF/views/include/include-css.jspf"%>
<link href="${rootPath}/css/list-table.css?ver=20191128" rel="stylesheet"
	type="text/css">
<link href="${rootPath}/css/top-scroll.css?ver=20191128" rel="stylesheet"
	type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<style>
p#insert {
	margin-left: 40px;
}
</style>
<script>
	$(function() {

		$(".content-body").click(function(e) {
			// id에 설정된 값을 가져오기
			let p_code = $(this).attr("id")
			alert(p_code)
			/*
				현재페이지를 /dept/view를 전환하라
				주소창에 /dept/view를 입력하여 서버에 전송
				// id 변수 값을 싫어서 보내라
			 */
			document.location.href = "${rootPath}/pro/view?p_code=" + p_code
		})
		var preScroll = $(window).scrollTop();

		$(window).scroll(function(e) {
			let curScroll = $(window).scrollTop();
			// 아래방향으로 스크롤 시도할 시
			if (preScroll > curScroll) {
				$("ul.main-menu").css("top", 0)
			} else {
				$("ul.main-menu").css("top", -80)
			}
			preScroll = curScroll
		})
	})
</script>
<body>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<section>
		<article>
			<p id="insert">
				<a href="${rootPath}/pro/insert"><button>새로등록</button></a>
			</p>
		</article>
		<%@ include file ="/WEB-INF/views/pro/list-body.jsp" %>	
	</section>

</body>
</html>