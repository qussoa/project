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
		<article>
			<table>
				<tr>
					<th>NO</th>
					<th>상품코드</th>
					<th>상품명</th>
					<th>매입단가</th>
					<th>매출단가</th>
					<th>부가세</th>
				</tr>
				<c:choose>
					<c:when test="${empty PROLIST}">
						<tr>
							<td colspan="5">데이터가 없음</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${PROLIST }" var="dto" varStatus="info">
							<tr class="content-body" id="${dto.p_code}">
								<td>${info.count}</td>
								<td>${dto.p_code}</td>
								<td>${dto.p_name}</td>
								<td>${dto.p_iprice}</td>
								<td>${dto.p_oprice}</td>
								<td>${dto.p_vat}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</article>
	</section>

</body>
</html>