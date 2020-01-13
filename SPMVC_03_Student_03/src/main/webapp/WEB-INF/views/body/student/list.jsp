<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<p></p>
<p></p>
<p></p>
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	margin: 20px auto;
}

table tr {
	border: 1px dashed red;
}

/*
	td,th : td tag th tag 공통된 속성부여
*/
table td, table th {
	padding: 8px;
	vertical-align: top;
}

table th {
	text-align: left;
}

table tr:nth-child(odd) {
	background-color: #fff;
}

table tr:nth-child(even) {
	background-color: #ccc;
}

table tr:hover {
	background-color: silver;
	cursor: pointer;
}
</style>

<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>학과</th>
		<th>학년</th>
		<th>교수</th>
	</tr>
	<c:choose>
		<c:when test="${STDLIST == null}">
			<tr>
				<td colspan="5">데이터가 없다</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${STDLIST}" var="dto">
				<tr>
					<td>${dto.st_num}</td>
					<td>${dto.st_name}</td>
					<td>${dto.st_dept}</td>
					<td>${dto.st_grade}</td>
					<td>${dto.st_pro}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>




