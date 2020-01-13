<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<style>

</style>

<script>
	$(function() {
		$(".btn-save").click(function() {

			let pass = $("#m_password").val()
			if (pass == "") {
				alert("비밀번호 입력")
				$("#m_password").focus()
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
				$("#m_password").val("")
				$("#re_password").val("")
				$("#m_password").focus()
				return false
			}
			$("form").submit()
		})
	})
</script>

<form method="POST" action="${rootPath}/member/join" class="join-form">
	<h2>JOIN</h2>
	
		<input type="text" name="m_id" placeholder="USER ID"> 
		<input 	type="text" name="m_password" id="m_password" placeholder="USER PW">
		<input 	type="text" name="re_password" id="re_password" placeholder="USER PW CHCECK">
		<button class="btn-save">JOIN</button>
</form>
