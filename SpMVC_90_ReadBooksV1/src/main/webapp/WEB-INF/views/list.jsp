<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${ pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>□□□ 나의 JSP page □□□</title>
<script>
	$(function() {

		$(".content-body").click(function(e) {
			// id에 설정된 값을 가져오기
			let id = $(this).attr("data-id")

			//alert(d_code)
			/*
				현재페이지를 /dept/view를 전환하라
				주소창에 /dept/view를 입력하여 서버에 전송
				// id 변수 값을 싫어서 보내라
			 */
			document.location.href = "${rootPath}/rblist?rb_bcode=" + id
		})
		// 현재 보고 있는 화면의 scrollTop값을 추출
		// 변수에 임시 보관

	})
</script>
<style>
</style>
</head>
<body>
	<header>
		<h3>도서정보</h3>
	</header>
	<section class="list">
		<article class="body">

			<table>
				<tr>
					<th>ISBN</th>
					<th>도서명</th>
					<th>출판사</th>
					<th>저자</th>
					<th>구입일자</th>
					<th>구입가격</th>
				</tr>

				<c:choose>
					<c:when test="${empty BOOKLIST}">
						<tr>
							<td colspan="6">도서정보없음</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${BOOKLIST}" var="bookDTO" varStatus="info">
							<tr class="content-body" data-id="${bookDTO.b_code}">
								<td>${bookDTO.b_code}</td>
								<td>${bookDTO.b_name}</td>
								<td>${bookDTO.b_auther}</td>
								<td>${bookDTO.b_comp}</td>
								<td>${bookDTO.b_year}</td>
								<td>${bookDTO.b_iprice}</td>
								<td><a href="${rootPath}/update?id=${bookDTO.b_code}">수정</a>
									<a href="${rootPath}/delete?id=${bookDTO.b_code}">삭제</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>

		</article>
	</section>
	<a href="${rootPath}/insert">추가</a>

</body>
</html>