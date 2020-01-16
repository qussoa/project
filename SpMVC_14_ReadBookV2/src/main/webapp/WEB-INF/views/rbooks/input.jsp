<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<script>
	$(function() {
		$("#btn-writer").click(function() {
			if ($("#rb_bcode").val == "") {
				alert("도서코드는 반드시 입력")
				$("#rb_bcode").focus()
				return false
			}

			if (parseInt($("#rb_rtime").val()) < 1) {
				alert("독서시간은 반드시 입력")
				$("#rb_rtime").focus()
				return false
			}

			if ($("#rb_subject").val == "") {
				alert("한줄평도 반드시 입력")
				$("#rb_subject").focus()
				return false
			}
			$("form").submit()
		})
		/*
		 	input box에 내용이 있을 때 focus()가 위치하면 내용을 전체 블럭 설정하여
		 	다른 글자를 입력하면 내용이 삭제되는 기능 구현
		 */
		$("#rb_bname").focus(function() {
			$(this).select()
		})

		$("#rb_bname").keypress(function(event) {
			if (event.keyCode == 13) {

				let strText = $(this).val()
				if (strText == "") {
					alert("도서명 입력")
					return false
				}

				$("#modal-box").css("display", "block")
				$.post("${rootPath}/book/search", {
					strText : strText
				}, function(result) {
					$("#modal-content").html(result)
				})
			}

		})

		$(".modal-header span").click(function() {
			$("#modal-box").css("display", "none")
		})

		//summernote toolbar
		var toolbar = [ [ 'style', [ 'bold', 'italic', 'underline' ] ],
				[ 'fontsize', [ 'fontsize' ] ],
				[ 'fontstyle', [ 'fontname' ] ], [ 'color', [ 'color' ] ],
				[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
				[ 'height', [ 'height' ] ], [ 'table', [ 'table' ] ],
				[ 'insert', [ 'link', 'hr', 'picture' ] ],
				[ 'view', [ 'fullscreen', 'codeview' ] ]

		]

		$("#rb_text").summernote({
			lang : 'ko-KR',
			placeholder : '본문을 입력',
			witdh : '100%',
			toolbar : toolbar,
			height : '200px',
			disableDragAndDrop : true
		})
		$("#rb_star").change(function() {
			let star = $(this).val()
			star = star * 10
			$("span.star-red").css("width", star + "%")
			$("span#star-v").text($(this).val())
		})
	})
</script>
<style>
.input-box {
	display: flex;
	width: 80%;
	margin: 5px auto;
}

.input-box input {
	color: rgb(52, 152, 219);
	border: none;
	border-bottom: 1px solid rgb(52, 152, 219);
	display: block;
	font-size: 0.9rem;
	width: 100%;
	padding: 8px;
}

#rb_bcode {
	width: 50%;
	margin-right: 5px;
}

#rb_star {
	width: 60%;
}

span.star-box {
	width: 100px;
}

span.star-box, span.star-red {
	display: inline-block;
	height: 20px;
	overflow: hidden;
	background: url("${rootPath}/image/star.png") no-repeat;
	background-size: 100px 40px;
}


span.star-red {
	background-position: left bottom;
	line-height: 0;
	vertical-align: top;
	width: 50%;
}
</style>
</head>
<body>
	<header>
		<h2>MY READ BOOK</h2>
	</header>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<%
		/*
			글쓰기를 시작할때
			controller get로 path를 받았을때 현재 view를 보여주고
			input box에 데이터를 입력한 후 submit 버튼을 클릭하면
			controller past로 데이터가 전송된다
			
			path는 
			view를 열때 사용했던 path가 그대로 적용된다
			
			그렇게 사용하지 않을 경우에는 별도로 action을 지정해야한다
			
			rbooks/book/insert path를 실행하면
			controller의 get method가 이를 수신하여 현재 input.jsp를 보여주고
			
			데이터를 입력하고 저장 button을 클릭하면 rbooks/book/insert path 
			post method로 데이터가 전송된다
			
			특별히 action을 지정하지 않으면 위와 같은 매커니즘으로 사용된다
			기본값으로 사용하지 않을 경우 action을 지정하여 사용할 수 있다
			
			Spring form tag를 사용할 경우 기본 method가 post이고
			html form tag는 기본 method가 GET이다
			
			button은 type을 지정하지 않으면 type= submit이 기본값
			button을 클릭하면 form에 입력한 데이터를 서버로 전송하는 기능을 한다
			
			button에 특별히 event를 적용하고 싶으면 type=button으로 지정할 수 있다
			
			button은 3가지 type
			1. submit : 기본값이고 form안에 있을 경우 form에 담긴 데이터를 서버로 전송
						input box가 1개만 있을 경우 Enter키에 반응하여 버튼을 클릭한 것처럼 동작
			2. button : 모든 기능을 제거하고 별도의 event를 설정해야한다 
			3. reset : form안에 있을 경우 form의 input box에 임의로 작성한 데이터를 초기화		
			
			중첩된 form의 action은 나중에
		*/
	%>
	<section id="main-writer">
		<article>
			<form:form modelAttribute="rBookVO">
				<div class="input-box">
					<form:input type="text" path="rb_bcode" placeholder="도서 코드" />
					<input id="rb_bname" name="rb_bname"
						placeholder="도서이름을 입력한 후 Enter">
				</div>
				<div class="input-box">
					<form:input type="date" path="rb_date" placeholder="독서일자" />
				</div>
				<div class="input-box">
					<form:input type="time" path="rb_stime" placeholder="독서시작시간" />
				</div>
				<div class="input-box">
					<form:input type="text" path="rb_rtime" placeholder="독서시간" />
				</div>
				<div class="input-box">
					<form:input type="text" path="rb_subject" placeholder="한줄평" />
				</div>
				<div class="input-box">
					<form:input type="range" path="rb_star" min="1" max="10"
						placeholder="별점" />
						<span class="star-box"> <span class="star-red"> </span>
						</span>				
						<span id="star-v"></span>
				</div>
				<div class="input-box">
					<form:textarea path="rb_text" />
				</div>
				<div id="main-button">
					<button id="btn-writer" class="biz-orange flex-right" type="button">독서록
						저장</button>
					<button id="btn-clear" class="biz-red" type="reset">새로작성</button>
					<button id="btn-list" class="biz-blue" type="button">리스트로
						가기</button>
				</div>
			</form:form>
		</article>
	</section>
	<div id="modal-box">
		<div class="modal-header">
			<span>&times;</span>
		</div>
		<div id="modal-content"></div>
	</div>
</body>
</html>