<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:set var="rootPath" value="${pageContext.request.contextPath}"></c:set>
<title>□□□ 나의 JSP page □□□</title>
</head>
<body>
<p><a href="${rootPath}/param/update?code=10">나는 코드가 10번입니다</a></p>
</body>
</html>