<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<article>
	<div>
		<div>
			<h4>${friendVO.fr_name}</h4>
		</div>
		<div>${friendVO.fr_tel}</div>
		<div>${friendVO.fr_addr}</div>
		<div>${friendVO.fr_hobby}</div>
		<div>${friendVO.fr_rel}</div>
	</div>

</article>