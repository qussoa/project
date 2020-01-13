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
<link href="${rootPath}/css/top-scroll.css" rel="stylesheet"
	type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<style>
p#insert {
	margin-left: 40px;
}

* {
	font-family: GyeonggiBatang;
}

@font-face {
	font-family: 'GyeonggiBatang';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/GyeonggiBatang.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}
</style>
<script>
	$(function() {

		$(".content-body").click(function(e) {
			// id에 설정된 값을 가져오기
			let id = $(this).attr("id")
			
			/*
				현재페이지를 /dept/view를 전환하라
				주소창에 /dept/view를 입력하여 서버에 전송
				// id 변수 값을 싫어서 보내라
			 */
			document.location.href = "${rootPath}/iolist/view?id=" + id		})
		// 현재 보고 있는 화면의 scrollTop값을 추출
		// 변수에 임시 보관
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
	<section class="dept">
		<article>
			<p id="insert">
				<a href="${rootPath}/dept/insert"><button>새로등록</button></a>
			</p>
		</article>
		<%@ include file="/WEB-INF/views/dept/list-body.jsp" %>
	</section>

</body>
</html>