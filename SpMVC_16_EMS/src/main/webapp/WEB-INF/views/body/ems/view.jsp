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
<script>
$(function() {
	
	let seq = "${emailVO.emsSeq}"
	$("#btn-update").click(function() {
		document.location.href="${rootPath}/ems/update/" + seq
	})
	$("#btn-delete").click(function() {
		document.location.href="${rootPath}/ems/delete/"
	})
})

</script>
<style>
article.email-view {
	display: flex;
	flex-flow: column;
	width: 100%;
}

div.div-box {
	display: flex;
	flex-wrap: nowrap;
	width: 95%;
	margin: 1px auto;
	border: 1px solid #999;
	padding: 5px;
}

div.ems-title {
	background-color: #ff7473;
	color: white;
	padding-right: 5px;
}

div.ems-body {
	padding-left: 10px;
}

div.div-box div:nth-child(odd) {
	width: 80%;
	text-align: right;
}

div.div-box  div:nth-child(even) {
	width: 100%;
	background-color: white;
	color: #ff7473;
}
</style>
</head>
<body>
	<header>
		<h2>Email View</h2>
	</header>
	<section>
		<article class="email-view">

			<div class="div-box">
				<div class="ems-title">NO</div>
				<div class="ems-body">${emailVO.emsSeq}</div>
			</div>
			<div class="div-box">
				<div class="ems-title">받는 이메일</div>
				<div class="ems-body">${emailVO.fromEmail}</div>
				<div class="ems-title">받는사람</div>
				<div class="ems-body">${emailVO.fromName}</div>
			</div>

			<div class="div-box">
				<div class="ems-title">보내는 이메일</div>
				<div class="ems-body">${emailVO.to_email}</div>
				<div class="ems-title">보내는 사람</div>
				<div class="ems-body">${emailVO.to_name}</div>
			</div>
			
				<div class="div-box">
				<div class="ems-title">작성일자</div>
				<div class="ems-body">${emailVO.sendDate}</div>
				<div class="ems-title">작성시각</div>
				<div class="ems-body">${emailVO.sendTime}</div>
			</div>
			
			<div class="div-box">
				<div class="ems-title">제목</div>
				<div class="ems-body">${emailVO.subject}</div>
			</div>
			<div class="div-box">
				<div class="ems-title">내용</div>
				<div class="ems-body">${emailVO.content}</div>
			</div>
		

		</article>
	</section>
	<div>
		<button type="button" id="btn-update">수정</button>
		<button type="button" id="btn-delete">삭제</button>
	</div>
</body>
</html>