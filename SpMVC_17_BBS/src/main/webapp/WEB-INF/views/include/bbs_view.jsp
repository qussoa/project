<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
.card-header h3 {
	display: inline-block;
	width: auto;
	padding: 5px 15px;
}
</style>
<article class="card">
	<div class="card-header">
		<h3>${bbsVO.bbs_subject}</h3>
		(${bbsVO.bbs_date} : ${bbsVO.bbs_time})
	</div>
	<div class="card-body">${bbsVO.bbs_content}</div>
	<div class="card-footer">${bbsVO.bbs_writer}</div>
</article>
<div class="btn-group">
	<button type="button" class="btn">리스트보기</button>
	<button type="button" class="btn">수정</button>
	<button type="button" class="btn">삭제</button>
	<button type="button" class="btn">댓글</button>
</div>

<div>
	<form:form action="${rootPath}/bbs/replay" modelAttribute="bbsVO">
		<form:textarea path="bbs_content" placeholder="답글 입력" cols=""
			rows="5" />
		<button class="btn btn-info">저장</button>

	</form:form>
</div>