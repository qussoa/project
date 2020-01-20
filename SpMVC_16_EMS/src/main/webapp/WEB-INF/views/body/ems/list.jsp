<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
				<tr>
					<td>NO</td>
					<td>받는이메일</td>
					<td>받는 사람</td>
					<td>제목</td>
					<td>작성일자</td>
					<td>작성시각</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<div style="padding:10px 25px">
	<button id="btn-email-send" onclick="location.href='${rootPath}/ems/input'">SEND</button>
</div>