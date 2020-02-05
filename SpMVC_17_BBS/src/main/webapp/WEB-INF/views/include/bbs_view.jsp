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

<c:if test="${bbsVO.bbs_p_id == 0}">
	<script>
		$(function() {
			$("button.btn-r-save").click(function() {
				let bbs_writer = $("#bbs_writer").val()
				let bbs_content = $("#bbs_content").val()

				if (bbs_writer == "") {
					alert("작성자 입력")
					$("#bbs_wirter").focus()
					return false
				}
				if (bbs_content == "") {
					alert("본문 입력")
					$("#bbs_content").focus()
					return false
				}
				$("form").submit()
			})

		})
	</script>
	<form:form action="${rootPath}/bbs/replay" modelAttribute="bbsVO">
		<div class="form-group">
			<input class="form-control" id="bbs_writer" name="bbs_writer"
				placeholder="답글" />
		</div>
		<textarea name="bbs_content" id="bbs_content"></textarea>
		<button class="btn btn-info btn-r-save" type="button">저장</button>
	</form:form>
</c:if>
