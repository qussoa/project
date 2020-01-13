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
<link href="${rootPath}/css/list-table.css?ver=20191128001" rel="stylesheet"
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

article.body{
/*
	articl.body box의 폭을 978px로 고정하고
	내부의 content가 넘치더라도 body box의 폭은 그대로 유지하면서
	scroll을 표시하여 볼 수 있도록 만들어라
*/
width:95%;
overflow: auto;
margin: 10px auto;
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
			let d_code = $(this).attr("data-id")
			let name =$(this).attr("data-name")
			//alert(d_code)
			/*
				현재페이지를 /dept/view를 전환하라
				주소창에 /dept/view를 입력하여 서버에 전송
				// id 변수 값을 싫어서 보내라
			 */
			document.location.href = "${rootPath}/iolist/view?id=" + id
		})
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
	<section class="iolist">
		<article>
			<p id="insert">
				<a href="${rootPath}/iolist/insert"><button>새로등록</button></a>
			</p>
		</article>
		<article class="body">
			<table>
				<tr>
					<th>NO</th>
					<th>거래일자</th>
					<th>구분</th>
					<th>CD</th>
					<th>거래처명</th>
					<th>대표자명</th>
					<th>CD</th>
					<th>상품명</th>
					<th>매입단가</th>
					<th>매출단가</th>
					<th>부가세</th>
					<th>QTY 수량</th>
					<th>단가</th>
					<th>금액</th>
				</tr>
				<c:choose>
					<c:when test="${empty IOLIST}">
						<tr>
							<td colspan="5">데이터가 없음</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${IOLIST}" var="dto" varStatus="info">
							<tr class="content-body" data-id="${dto.io_seq}"
							data-name="홍길동">
								<td>${dto.io_seq}</td>
								<td>${dto.io_date}</td>
								<td>${dto.io_inout}</td>
								<td>${dto.io_dcode}</td>
								<td>${dto.io_dname}</td>
								<td>${dto.io_dceo}</td>
								<td>${dto.io_pcode}</td>
								<td>${dto.io_pname}</td>
								<td>${dto.io_iprice}</td>
								<td>${dto.io_oprice}</td>
								<td>${dto.io_vat}</td>
								<td>${dto.io_qty}</td>
								<td>${dto.io_price}</td>
								<td>${dto.io_total}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</article>
	</section>

</body>
</html>