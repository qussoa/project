<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>친구찾기</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.ui.position.min.js"></script>
<script>
	$(function() {
		$("#btn-add").click(function() {
			document.location.href = '${rootPath}/friend/input'
		})
		
		$("$search-box").click(function() {
			let friend = $("#search-box").val()
			document.location.href="${rootPath}/friend/list?fr_name=" + friend
		})
	})
</script>
<body class="text-center">
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">FRIEND</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="${rootPath}/">HOME</a> <a
						class="nav-link" href="#">LOGIN</a> <a class="nav-link" href="#">JOIN</a>
				</nav>
			</div>
		</header>
		<main role="main" class="inner cover">
			<h4 class="cover-heading">FRIEND LIST</h4>
			<form>
				<input type="text" name="friend" id="search-box">
				<button class="btn btn-secondary" id="btn-add" >검색</button>
			</form>
			<section>
				<c:choose>
					<c:when test="${BODY == 'FR_INPUT'}">
						<%@ include file="/WEB-INF/views/include/fr_input.jsp"%>
					</c:when>
					<c:otherwise>
						<%@ include file="/WEB-INF/views/include/fr_list.jsp"%>
						<div class="lead">
							<button class="btn btn-secondary" id="btn-add" type="button">추가</button>
						</div>
					</c:otherwise>
				</c:choose>
			</section>
		</main>
		<footer class="mastFoot mt-auto">
			<div class="inner">
				<p>20200207 one day project by qussoa</p>
			</div>
		</footer>
	</div>
</body>
</html>






















