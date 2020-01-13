<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function() {

		function idcheck() {

			let top = 500
			/* 		(window.screen.availTop
					+ (window.screen.availHeight/2))
					- (window.screen.height/2)
			 */
			let left = 500
			/* (window.screen.availLeft
			+(window.screen.availWidth/2))
			-(window.screen.width/2) */

			//alert("Enter 입력")
			let u_id = $("#u_id").val()
			let status = "toolbar=no,"
			status += "scrollbars=yes,"
			status += "resizable=no,"
			status += "top=500,"
			status += "left=500,"
			status += "width=700,"
			status += "height=400"

			if (u_id == "") {
				alert("input your id")
				return false
			}

			window.open("${rootPath}/user/idcheck?u_id=" + u_id, "_blank",
					status)

		}

		$("#u_id").keypress(function(e) {
			if (e.keyCode == 13) {
				//일반적으로 함수를 불러오는 호출 방법
				idcheck()
			}
		})
		// event handler에 함수목록을 등록하는 절차
		// 이때는 함수 마치 객체처럼 등록이 되기 때문에
		// 함수 이름에 ()넣지 말아야한다
		$("#id_check").click(idcheck)

		$("#btn-save").click(function() {

			let pass = $("#u_password").val()
			if (pass == "") {
				alert("비밀번호 입력")
				$("#u_password").focus()
				return false
			}
			let re_pass = $("#re_password").val()
			if (re_pass == "") {
				alert("비밀번호 재입력")
				$("#re_password").focus()
				return false
			}
			if (pass != re_pass) {
				alert("비밀번호 일치하지않음\n" + "재입력")
				$("#u_password").val("")
				$("#re_password").val("")
				$("#u_password").focus()
				return false
			}

			let u_name = $("#u_name").val()
			if (u_name == "") {
				alert("이름을 입력")
				$("#u_name").focus()
				return false
			}
			$("form").submit()
		})

	})
</script>
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

fieldset {
	width: 70%;
	margin: 20px auto;
	border: 1px solid #D9D4CF;
	border-radius: 10px;
}

legend {
	font-weight: bold;
	font-size: 20px;
}

input, textarea {
	display: inline-block;
	width: 90%;
	padding: 8px;
	margin: 5px;
	border-radius: 20px;
	outline: none;
}

input:focusm textarea:focus, button {
	border: 2px solid #D9D4CF;
	outline: none;
}

input:hover {
	background-color: #F0E5DE;
	border: 2px solid #D9D4CF;
}

.in-error {
	display: inline-block;
	margin-left: 20px;
	font-size: 12px;
	color: red;
}

span#u_id_msg {
	display: none;
}

#u_id {
	width: 70%;
}
</style>
</head>
<body>
	<fieldset>
		<legend>
			<c:if test="${TITLE == null}">회원가입</c:if>
			<c:if test="${TITLE != null}">${TITLE}</c:if>
		</legend>
		<form:form modelAttribute="userDTO" autocomplete="on"
			class="user-form">
			<div class="in-box-border">
				<form:input path="u_id" type="text" class="in-box"
					placeholder="작성자 id Enter" />
				<button type="button" id="id_check">아이디검사</button>
				<br />
				<form:errors path="u_id" class="in-error" />
				<br /> <span id="u_id_msg"></span>
			</div>

			<div class="in-box-border">
				<form:input path="u_password" type="password" class="in-box"
					placeholder="비밀번호" />
				<br />
				<form:errors type="password" path="re_password" class="in-error" />
				<form:errors path="re_password" class="in-error" />

			</div>
			<div class="in-box-border">
				<input type="password" id="re_password" placeholder="비밀번호 재확인">
			</div>
			<div class="in-box-border">
				<form:input path="u_name" class="in-box" placeholder="이름" />
				<br />
				<form:errors path="u_name" class="in-error" />
			</div>
			<div class="in-box-border">
				<form:input path="u_nick" class="in-box" placeholder="별명" />
				<br />
				<form:errors path="u_nick" class="in-error" />
			</div>
			<div class="in-box-border">
				<form:input path="u_tel" type="number" class="in-box"
					placeholder="전화번호는 숫자만" />
				<br />
				<form:errors path="u_tel" class="in-error" />
			</div>
			<button type="button" id="btn-save">ENTER</button>
		</form:form>
	</fieldset>
</body>
</html>