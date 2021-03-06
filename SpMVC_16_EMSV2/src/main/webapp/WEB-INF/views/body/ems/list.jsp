<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script>
$(function() {
	$(".email-list").click(function() {
		document.location.href="${rootPath}/ems/view/" + $(this).data("seq")
	})
})

</script>
<table class="main-list">
	<tr>
		<th>NO</th>
		<th>받는이메일</th>
		<th>받는 사람</th>
		<th>제목</th>
		<th>작성일자</th>
		<th>작성시각</th>
	</tr>
	<c:choose>
		<c:when test="${empty LIST}">
			<tr>
				<td colspan="6">데이터가 없음</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${LIST}" var="VO" varStatus="in">
				<tr data-seq="${VO.ems_seq}" class="email-list">
					<td>${in.index}</td>
					<td>${VO.from_email}</td>
					<td>${VO.from_name}</td>
					<td>${VO.subject}</td>
					<td>${VO.send_date}</td>
					<td>${VO.send_time}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<div style="padding:10px 25px">
	<button id="btn-email-send" onclick="location.href='${rootPath}/ems/input'">SEND</button>
</div>