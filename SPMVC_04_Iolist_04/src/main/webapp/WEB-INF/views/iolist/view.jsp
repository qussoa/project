<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
<%@ include file="/WEB-INF/views/include/include-css.jspf"%>
<link href="${rootPath}/css/top-scroll.css?ver=20191128-001"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<style>
p#insert {
	margin-left: 40px;
}

th {
	background-color: white;
	text-align: right;
}

td {
	background-color: white;
}

tr {
	background-color: white;
}

div.btn-box {
	width: 70%;
	display: flex;
	margin: 5px auto;
	justify-content: center;
	align-items: center;
}

a.btn {
	border-radius: 3px;
	padding: 5px 11px;
	color: white;
	display: inline-block;
	border: 1px solid white;
	background-color: green;
	vertical-align: middle;
	text-decoration: none;
	margin: 10px;
}

a.btn:hover {
	cursor: pointer;
	background-color: white;
	color: green;
}
</style>
<script>
$(function () {
	$("#btn-update").on("click",function(){
		/*
			페이지 위에 겹쳐보이기
			뒤로가기 이전페이지 가능
		*/
		document.location.href 
		= "${rootPath}/iolist/update?id=${IO_DTO.io_seq}"
			
	})
	$("#btn-delete").click(function() {
		/*
		페이지 위에 새 페이지
		뒤로가기 history저장된 페이지로 이동
	*/
	docu
		let query = "${rootPath}/iolist/delete?id=${IO_DTO.io_seq}"
			document.location.replace(query)
	})
})
</script>
<body>

	<%@ include file="/WEB-INF/views/include/include-iolist-header.jspf"%>
	<table>
		<!-- 	<caption>매입매출상세</caption> -->
		<tr>
			<th>SEQ</th>
			<td>${IO_DTO.io_seq}</td>
			<th>거래구분</th>
			<td>${IO_DTO.io_inout}</td>
		</tr>
		<tr>
			<th>거래일자</th>
			<td colspan="3">${IO_DTO.io_date}</td>
		</tr>
		<tr>
			<th>거래처</th>
			<td>${IO_DTO.io_dcode}</td>
			<th>거래명</th>
			<td>${IO_DTO.io_dname}(${IO_DTO.io_dceo})</td>
		</tr>
		<tr>
			<th>상품코드</th>
			<td>${IO_DTO.io_pcode}</td>
			<th>상품명</th>
			<td>${IO_DTO.io_pname}</td>
		</tr>
		<tr>
			<th>단가</th>
			<td>${IO_DTO.io_price}</td>
			<th>수량</th>
			<td>${IO_DTO.io_qty}</td>
		</tr>
		<tr>
			<th>합계</th>
			<td colspan="3">${IO_DTO.io_total}</td>
		</tr>
	</table>
	<tr>
		<td colspan="4">
			<div class="btn-box">
				<a href="javascript:void(0)" class="btn" id="btn-update">수정</a> <a
					href="javascript:void(0)" class="btn" id="btn-delete">삭제</a>
			</div>
		</td>
	</tr>
</body>
</html>