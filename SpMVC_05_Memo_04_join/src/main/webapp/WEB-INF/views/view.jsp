<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
<script src="${rootPath}/js/jquery-3.4.1.js"></script>

</head>
<style>
@font-face {
	font-family: 'BinggraeMelona';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/BinggraeMelona.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: BinggraeMelona;
}

table {
	width: 70%;
	margin: 20px auto;
	border-top: 2px solid #f1bbba;
	border-bottom: 1px solid #f1bbba;
}

table th {
	text-align: left;
	background-color: #f8ecc9;
	color: #a79c8e;
}

table th, table td {
	padding: 15px 0 16px 16px;
	border-bottom: 1px solid #f8ecc9;
}

caption {
	font-size: 25px;
	padding: 10px;
	font-weight: bold;
	color: #a79c8e;
}

div.btn-box {
	width: 70%;
	display: flex;
	margin: 5px auto;
	justify-content: center;
	align-items: center;
}

a.btn {
	border-radius: 3px;
	padding: 5px 11px;
	color: #f8ecc9;
	display: inline-block;
	border: 1px solid #a79c8e;
	background-color: #a79c8e;
	vertical-align: middle;
	text-decoration: none;
	margin: 10px;
}

a.btn:hover {
	cursor: pointer;
	background-color: #f8ecc9;
	color: #a79c8e;
}
</style>
<script>
	$(function() {
		$("#btn-update").on("click", function() {
			/*
				페이지 위에 겹쳐보이기
				뒤로가기 이전페이지 가능
			 */
			document.location.href = "${rootPath}/memo/update?id=${dto.m_seq}"

		})
		$("#btn-delete").click(function() {
			/*
			페이지 위에 새 페이지
			뒤로가기 history저장된 페이지로 이동
			 */
			if (confirm("메모를 삭제할까요?")) {
				let query = "${rootPath}/memo/delete?m_seq=${dto.m_seq}"
				document.location.replace(query)
			}
		})
	})
</script>
<body>
	<%
		/*
			private long m_seq;//	number
			private String m_date;//	varchar2(10 byte)
			private String m_time;//	varchar2(8 byte)
			private String m_auth;//	nvarchar2(20 char)
			private String m_subject;//	nvarchar2(125 char)
			private String m_text;//	nvarchar2(1000 char)
			private String m_flag;//	varchar2(1 byte)
			private String m_field;//	nvarchar2(20 char)
			private String m_ok;//	varchar2(1 byte)
			private String m_cat;//	nvarchar2(50 char)
		
		*/
	%>
	<table>
		<caption>simple memo</caption>
		<tr>
			<th>SEQ</th>
			<td>${dto.m_seq}</td>
			<th>작성자</th>
			<td>${dto.m_auth}</td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td>${dto.m_date}</td>
			<th>작성시각</th>
			<td>${dto.m_time}</td>
		</tr>

		<tr>
			<th>제목</th>
			<td colspan="3">${dto.m_subject}</td>
		</tr>
		<tr>
			<th>세부내용</th>
			<td colspan="3">${dto.m_text}</td>
		</tr>
	</table>
	<tr>
		<td colspan="4">
			<div class="btn-box">
				<a href="javascript:void(0)" class="btn" id="btn-update">수정</a> <a
					href="javascript:void(0)" class="btn" id="btn-delete">삭제</a>
			</div>
		</td>
	</tr>
</body>
</html>