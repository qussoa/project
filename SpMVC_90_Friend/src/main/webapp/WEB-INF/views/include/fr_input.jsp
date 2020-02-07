<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script>
	$(function() {
		$("button.btn-save").click(function() {
			let fr_name = $("#fr_name").val()
			let fr_tel = $("#fr_tel").val()
			let fr_addr = $("#fr_addr").val()

			if (fr_name == "") {
				alert("PLZ INPUT YOU NAME")
				$("#fr_name").focus()
				return false
			}
			if (fr_tel == "") {
				alert("PLZ INPUT YOU TEL")
				$("#fr_tel").focus()
				return false
			}
			if (fr_addr == "") {
				alert("PLZ INPUT YOU ADDR")
				$("#fr_addr").focus()
				return false
			}
			$("form").submit()
		})
	})
</script>
<form:form action="${rootPath}/friend/save" modelAttribute="friendVO">
	<div class="form-group">
		<form:input class="form-control" path="fr_name" placeholder="NAME" />
	</div>

	<div class="form-group">
		<form:input class="form-control" path="fr_tel" placeholder="TEL" />
	</div>

	<div class="form-group">
		<form:input class="form-control" path="fr_addr" placeholder="ADDR" />
	</div>

	<div class="form-group">
		<form:input class="form-control" path="fr_hob" placeholder="HOBBY" />
	</div>

	<div class="form-group">
		<form:input class="form-control" path="fr_rel" placeholder="REL" />
	</div>

	<div class="form-group">
		<button class="btn btn-secondary btn-save" type="button">SAVE</button>
	</div>
</form:form>

