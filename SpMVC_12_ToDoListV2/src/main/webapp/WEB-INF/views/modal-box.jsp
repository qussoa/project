<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.modal {
	display: none;
	position: fixed;
	z-index: 10;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.4);
}

.modal form {
	position: relative;
	width: 30%;
	padding: 10px;
	border: 1px solid #888;
	margin: auto;
	background-color: #fefefe;
	animation-name: form-ani;
	animation-duration: 0.9s;
	animation-fill-mode:forwards;
	
	/* 구글, 사파리 */
	-webkit-animation-name: form-ani;
	-webkit-animation-duration: 0.9s;
	/*	-webkit-animation-fill-mode:forwards; */
	
	/* firefox */
	-moz-webkit-animation-name: form-ani;
	-moz-webkit-animation-duration: 0.9s;
	-moz-webkit-animation-fill-mode:forwards;

	/* IE */	
	-ms-webkit-animation-name: form-ani;
	-ms-webkit-animation-duration: 0.9s;
	-ms-webkit-animation-fill-mode:forwards;
	
	/* 오페라 */
	-o-webkit-animation-name: form-ani;
	-o-webkit-animation-duration: 0.9s;
	-o-webkit-animation-fill-mode:forwards;
	
	}

/* animation을 실행하는 css */
@keyFrames form-ani {
from {
	top:-300px;
	opacity: 0;
}

to {
	top: 200px;
	opacity: 1;
	}
}

@-webkit-keyFrames form-ani {
from {
	top:-300px;
	opacity: 0;
}

to {
	top: 200px;
	opacity: 1;
	}
}
span.modal-close{
color:white;
float:right;
font-size: 30px;
font-weight: bold;
}
span.modal-close:hover{
color:#000;
cursor:pointer;
}
</style>
<script>

$(function() {
	$("span.modal-close").click(function() {
		$("#myModal").css("display","none")	
	})
	
})
</script>
<div id="myModal" class="modal">
	<div>
		<span class="modal-close">&times;</span>
	</div>
	<form method="POST" action="${rootPath}/member/login">
		<div>
			<input type="text" name="user_id" placeholder="사용자 ID">
		</div>
		<div>
			<input type="password" name="password" placeholder="비밀번호">
		</div>
		<div>
			<button id="btn-login">로그인</button>
		</div>
	</form>

</div>