<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
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
<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<script src="${rootPath}/js/summernote-ko-KR.min.js"></script>
<style>
body {
	border: 1px solid #aaa;
}
</style>
<script>
	$(function() {
		$("#btn-writer").click(function() {
			document.location.href = '${rootPath}/bbs/input'
		})
		
	var toolbar = [ [ 'style', [ 'bold', 'italic', 'underline' ] ],
				[ 'fontsize', [ 'fontsize' ] ],
				[ 'fontstyle', [ 'fontname' ] ], [ 'color', [ 'color' ] ],
				[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
				[ 'height', [ 'height' ] ], [ 'table', [ 'table' ] ],
				[ 'insert', [ 'link', 'hr', 'picture' ] ],
				[ 'view', [ 'fullscreen', 'codeview' ] ]

		]
				
	$("#bbs_content").summernote({
			
			lang : 'ko-KR',
			placeholder : '본문을 입력',
			witdh : '100%',
			toolbar : toolbar,
			height : '200px',
			// 이미지 업로드는 불가능하나 이미지를 첨부하는 것만 가능
			// ture -> false
			disableDragAndDrop : false
		})
		
	})
</script>
</head>
<header class="jumbotron text-center">
	<h3>Build Board System</h3>
</header>
<ul class="nav">
	<li class="nav-item"><a class="nav-link" href="${rootPath}/">Home</a></li>
	<li class="nav-item justify-content-end"><a class="nav-link"
		href="${rootPath}/member/login">로그인</a></li>
	<li class="nav-item"><a class="nav-link"
		href="${rootPath}/member/join">회원가입</a></li>
</ul>
<body class="container">

	<section>
		<c:choose>
			<c:when test="${BODY == 'BBS_INPUT'}">
				<%@ include file="/WEB-INF/views/include/bbs_input.jsp"%>
			</c:when>
			<c:when test="${BODY == 'BBS_VIEW'}">
				<%@ include file="/WEB-INF/views/include/bbs_view.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/include/bbs_list.jsp"%>
				<div class="input-group">
					<div class="input-group-btn">
						<button class="btn btn-primary" id="btn-writer" type="button">게시판작성</button>
					</div>
				</div>
			</c:otherwise>
		</c:choose>

	</section>


</body>
</html>