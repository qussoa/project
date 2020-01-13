<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		$("#id_use").click(function() {
			$("#u_id", opener.document).val($("#u_id").val())
			window.close()

			window.open('about:blank', '_self').self.close()
		})
	})
</script>
</head>
<body>
	<c:choose>
		<c:when test="${ID_YES}">
			<h3>already have id</h3>
			<h5>try again</h5>
		</c:when>
		<c:when test="${ID_YES == false && empty u_id}">
			<h3>input your id</h3>
		</c:when>
		<c:otherwise>
			<h3>you can this id</h3>
		</c:otherwise>
	</c:choose>
	<form>
		<input name="u_id" id="u_id" value="${u_id}">
		<button>research</button>
		<button type="button" id="id_use">use id</button>
	</form>

</body>
</html>