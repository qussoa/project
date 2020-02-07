<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	$(function() {

		var contextCallBack = function(key, options) {

			if (key == 'edit') {
				let f_seq = $(this).attr("id");
				document.location.href = "${rootPath}/friend/save/" + f_seq
				alert("EDIT NUM : " + $(this).attr("id"))
			}

			if (key == 'delete') {
				if (confirm("DELETE YOUR FRIEND?")) {
					let f_seq = $(this).attr("data-id");
					document.location.href = "${rootPath}/friend/delete/"+f_seq
					alert("삭제할 번호 : " + $(this).attr("data-id"))
				}
			}
		}
		$.contextMenu({
			selector : '.fr_tr',
			callback : contextCallBack,
			items : {
				'edit' : {
					name : '수정',
					icon : 'edit'
				},
				'delete' : {
					name : '삭제',
					icon : 'delete'
				}
			}
		})

	})
</script>
<article>
	<div>
		<table>
			<thead>
				<tr>
					<th>NO</th>
					<th>NAME</th>
					<th>TEL</th>
					<th>ADDR</th>
					<th>HOBBY</th>
					<th>REL</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty FR_LIST}">
						<tr>
							<td colspan="6">NOT FOUND</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="FR" items="${FR_LIST}" varStatus="index">
							<tr class="fr_tr" data-id="${FR.fr_num}">
								<td>${index.count}</td>
								<td>${FR.fr_name}</td>
								<td>${FR.fr_tel}</td>
								<td>${FR.fr_addr}</td>
								<td>${FR.fr_hob}</td>
								<td>${FR.fr_rel}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</article>