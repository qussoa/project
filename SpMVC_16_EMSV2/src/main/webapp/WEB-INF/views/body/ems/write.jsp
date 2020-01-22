<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.js"></script>
<script src="${rootPath}/resources/js/summernote-ko-KR.js"></script>
<script>
	$(function() {
		//summernote toolbar
		var toolbar = [ [ 'style', [ 'bold', 'italic', 'underline' ] ],
				[ 'fontsize', [ 'fontsize' ] ],
				[ 'fontstyle', [ 'fontname' ] ], [ 'color', [ 'color' ] ],
				[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
				[ 'height', [ 'height' ] ], [ 'table', [ 'table' ] ],
				[ 'insert', [ 'link', 'hr', 'picture' ] ],
				[ 'view', [ 'fullscreen', 'codeview' ] ]

		]

		$("#content").summernote({
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
<fieldset class="email-write-box">
	<form:form modelAttribute="emailVO" >

		<div class="in-box">
			<label for="from_emil">보내는 Email</label>
			<form:input path="from_email" />
		</div>

		<div class="in-box">
			<label for="to_email">받는 Email</label>
			<form:input path="to_email" />
		</div>

		<div class="in-box">
			<label for="send_date">작성 일자</label>
			<form:input path="send_date" />
		</div>

		<div class="in-box">
			<label for="send_time">작성 시각</label>
			<form:input path="send_time" />
		</div>

		<div class="in-box">
			<label for="from_name">작성자</label>
			<form:input path="from_name" />
		</div>

		<div class="in-box">
			<label for="to_name">받는사람</label>
			<form:input path="to_name" />
		</div>

		<div class="in-box">
			<label for="subject">제목</label>
			<form:input path="subject" />
		</div>

		<div class="in-box">
			<form:textarea path="content" />
		</div>
		<div class="in-box">
			<button>SEND</button>

		</div>
	</form:form>
	<fieldset>