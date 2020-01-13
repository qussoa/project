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
</head>
<body>
	<section class="rblist">
		<article class="rbody">
			<table>
				<h3>도서감상록</h3>
					<tr>
					<th>SEQ</th>
					<th>도서코드</th>
					<th>독서날짜</th>
					<th>독서시작날짜</th>
					<th>독서종료시각</th>
					<th>제목</th>
					<th>본문</th>
					<th>별점</th>
				</tr>
				<c:choose>
					<c:when test="${empty READLIST}">
						<tr>
							<td colspan="8">독후감 작성하기</td>
							<a href="${rootPath}/rbinsert">도서정보 수정</a>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${READLIST}" var="readBookDTO" varStatus="info">
							<tr class="content-detail" id="${readBookDTO.rb_seq}">
								<td>${readBookDTO.rb_seq}</td>
								<td>${readBookDTO.rb_bcode}</td>
								<td>${readBookDTO.rb_date}</td>
								<td>${readBookDTO.rb_stime}</td>
								<td>${readBookDTO.rb_rtime}</td>
								<td>${readBookDTO.rb_subject}</td>
								<td>${readBookDTO.rb_text}</td>
								<td>${readBookDTO.rb_star}</td>
							</tr>
							<td><a href="${rootPath}/rbupdate?id=${readBookDTO.rb_seq}">수정</a>
								<a href="${rootPath}/rbdelete?id=${readBookDTO.rb_seq}">삭제</a></td>
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</table>
		</article>
	</section>
</body>
</html>