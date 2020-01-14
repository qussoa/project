<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
$(function() {
	$("#btn-join").click(function() {
		document.location.href="${rootPath}/member/join"
	})
	
	$("#btn-login").click(function() {
		
		// 유효성 검사 
		// id, password가 입력되지 않았을 때 경고
		let u_id = $("#m_id").val()
		if(u_id == ""){
			alert("아이디를 입력하시오")
			$("#m_id").focus()
			return false;
		}
		
		let u_pass = $("#m_password").val()
		if(u_pass == ""){
			alert("비밀번호를 입력하시오")
			$("#m_password").focus()
			return false;
		}
		
		/*
		var params = $("form").serialize();
		$.ajax({
			url : "${rootPath}/rest/member/login",
			type : 'POST',
			data: params,
			dataType:'json',
			success : function(result) {
				alert(result)
			}
		})
		
		*/
		/*
		$.post("${rootPath}/member/login",
			$("form").serialize(),
			function(result) {
			alert(result)
			document.location.href = document.location.href	
			//alert(result)
			}
		)
		*/
		
		
	})
})
</script>

<form method="POST" action="${rootPath}/member/login" class="login-form">
		<h2>SIGN-IN</h2>
		<c:if test="${LOGIN_MSG == 'FAIL'}">
		<h3>you missed your id or password</h3>
		</c:if>
		<c:if test="${LOGIN_MSG == 'TRY'}">
		<h3>you have to sign-in</h3>
		</c:if>
		<c:if test="${LOGIN_MSG == '0'}">
		<h3>welcome sign-in</h3>
		</c:if>
		<input type="text" id="m_id" name="m_id" placeholder="USER ID">
		<input type="password" id="m_password" name="m_password" placeholder="USER PW">
		<button type="submit" id="btn-login">LOGIN</button>
		<button type="button" id="btn-join">JOIN</button>
	</form>
