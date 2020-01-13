<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>IMAGE GALLERY</title>

<!-- include libraries(jQuery, bootstrap) -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- include summernote css/js -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>
<script src="${rootPath}/javascript/summernote-ko-KR.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.ui.position.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<style>
* {
	box-sizing: border-box;
	margin: 0px;
	padding: 0px;
}

body {
	width: 100%;
}

header {
	background-color: #41D3BD;
	margin: 0;
	padding: 1rem;
	color: white;
}

section {
	width: 90%;
	margin: 10px auto;
}

#img_box {
	border: 1px solid green;
	display: flex;
	flex-wrap: wrap;
	margin: 10px auto;
}

.img_panel {
	padding: 0.01rem 16px;
	margin-top: 16px;
	margin-bottom: 16px;
}

.img_card {
	width: 200px;
	height: 200px;
	margin: 10px;
	/*이미지가 card box보다 클때 이미지 자르기*/
	overflow: hidden;
	display: flex;
	justify-content: center;
	flex-flow: column;
	box-shadow: 0 4px 10px 0 rgba(0, 0, 0, 0.16), 0 4px 20px 0
		rgba(0, 0, 0, 0.19);
	justify-content: center;
	flex-flow: column;
	flex-flow: column;
}

.img_card .img_title {
	padding: 0.5rem;
	text-align: center;
}

.bz-button {
	border: none;
	display: inline-block;
	padding: 8px 16px;
	margin: 5px;
	vertical-align: middle;
	text-decoration: none;
	color: white;
	background-color: #41D3BD;
	text-align: center;
	cursor: pointer;
	white-space: nowrap;
}

.bz-button:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2) 0 6px 20px 0
		rgba(0, 0, 0, 0.2);
}

a {
	text-decoration: none;
	color: inherit;
}

div.input-box {
	margin: 5px auto;
	width: 90%;
}

input[type="text"] {
	padding: 8px;
	display: block;
	border: none;
	border: 1px solid #ccc;
	border-radius: 5px;
	width: 100%;
	margin: 8px auto;
}

#d_d_box {
	width: 100%;
	height: 300px;
	color: #aaa;
	border: 1px solid #41D3BD;
	display: flex;
	align-items: center;
	justify-content: center;
}

#img_title {
	margin: 10px auto;
}

#img_view {
	display: none;
}

.img_list {
	display: flex;
	flex-wrap: wrap;
}

.img_view img {
	width: 100px;
	height: 100px;
	margin: 5px;
}
</style>
<script>
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/javascript/image_upload.js"></script>
<script src="${rootPath}/javascript/images_upload.js"></script>
<script>
	$(function() {

		var toolbar = [ [ 'style', [ 'bold', 'italic', 'underline' ] ],
				[ 'fontsize', [ 'fontsize' ] ],
				[ 'fontstyle', [ 'fontname' ] ], [ 'color', [ 'color' ] ],
				[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
				[ 'height', [ 'height' ] ], [ 'table', [ 'table' ] ],
				[ 'insert', [ 'link', 'hr', 'picture' ] ],
				[ 'view', [ 'fullscreen', 'codeview' ] ]

		]

		$("#img_text").summernote({
			lang : 'ko-KR',
			placeholder : '본문을 입력',
			witdh : '100%',
			toolbar : toolbar,
			height : '200px',
			disableDragAndDrop : true
		})

		$("#btn_img_up").click(function() {
			document.location.href = "${rootPath}/image/upload"
		})
		$("#d_d_box").on('dragover', function(e) {
			$('#d_d_box h3').text("파일을 올리시오")
			return false;
		})

		$("#d_d_box").on('drop', function(e) {
			$('#d_d_box h3').text("파일을 업로드 중")

			let files = e.originalEvent.dataTransfer.files
			let fileLen = files.length

			let formData = new FormData()

			for (let i = 0; i < fileLen; i++) {
				formData.append('files', files[i])
			}

			files_up(formData)
			return false

			return false;
		})

		var contextCallBack = function(key, options) {
			if (key == 'edit') {
				let img_seq = $(this).attr("data-seq");
				document.location.href = "${rootPath}/image/update/" + img_seq
			}
			if (key == 'delete') {
				if (confirm("이미지를 삭제할까요?")) {
					let img_seq = $(this).attr("data-seq");

					$.ajax({
						url : "${rootPath}/image/delete",
						data : {
							img_seq : img_seq
						},
						type : 'POST',
						success : function(result) {
							if (result < 1) {
								alert("삭제도중 오류")
							}
						},
						error : function() {
							alert("서버통신 오류")
						}
					})
					document.location.replace("${rootPath}/")
					return false
				}
			}
		}

		$.contextMenu({

			selector : '.img_card',
			callback : contextCallBack,
			items : {
				'edit' : {
					name : '수정',
					icon : 'edit'
				},
				'delete' : {
					name : '삭제',
					icon : 'delete'
				}
			}

		})

		var img_context = function(key, option) {
			let img_id = $(this).attr("data-id")
			if (key == "delete") {
				if (confirm(img_id + "이미지를 삭제할까요?")) {

					$.post("${rootPath}/rest/image_delete", {
						img_id : img_id
					}, function(result) {
						if (result == "OK")
							//document.location.replace("${rootPath}/")
							document.location.replace(document.location.href)
						else {
							alert("파일을 삭제할 수 없음")
							document.location.replace(document.location.href)
						}
					})
				}

			} else if (key == "copy") {

			} else if (key == "loading") {
				let file = $(this).find("img").attr("src")
				window.open( file, "target=_new")
			}
		}

		$.contextMenu({

			selector : '.img_view',
			callback : img_context,
			items : {
				'loading' : {
					name : '확대보기',
					icon : 'loading'
				},
				'copy' : {
					name : '다운로드',
					icon : 'copy'
				},
				'delete' : {
					name : '삭제',
					icon : 'delete'
				},
				'search' : {
					name : '검색',
					icon : 'fas fa-search'
				}
			}

		})
	})
</script>
</head>
<body>
	<header>
		<h3>IMAGE GALLERY</h3>
	</header>
	<c:choose>
		<c:when test="${BODY == 'UPLOAD'}">
			<section>
				<%@ include file="/WEB-INF/views/body/img_upload.jsp"%>
			</section>
		</c:when>
		<c:otherwise>
			<section id="img_box">
				<c:forEach items="${imgList}" var="img">
					<%@ include file="/WEB-INF/views/include/img_card.jsp"%>
				</c:forEach>
			</section>
		</c:otherwise>
	</c:choose>

	<section>
		<button id="btn_img_up" class="bz-button">UPLOAD</button>
	</section>
</body>
</html>