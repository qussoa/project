<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
 index.jsp
 보통 도메인네임을 브라우저에 입력하고 Enter를 눌렀을떼
 최초로 보여지는 화면을 index화면이라 하고
 이때 index화면을 구현한 파일들이 
 index.html index.htm  |  index.php index.asp index.jsp
       static 		   |			dynamic
 index page를 만든다 화면구현에서 최초로 만들게 되는 화면
 
 static 방식					dynamic
 - 문서파일 				- DB, App연동
 - 유사한 화면				- 사용자의 요구에 따라 	
 				        	  화면을 다양하게 구현
 
*/

// 웹브라우저에서 query로 전달받은 변수<strName)값을 추출하여
// 문자열 변수 strName에 저장하라
String strName = request.getParameter("strName");



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
</head>
<body>
<h3>나의 홈페이지</h3>
<p>나(<%= strName %>)의 홈페이지에 오신것을 환영합니다</p>
<p> <a href="https://naver.com">네이버</a>
<p> <a href="https://daum.net">다음</a>
<p> <a href="https://google.com">구글</a>
<!-- strName query로 전달받은 값을 page.jsp에게 토스하라 -->
<p> <a href="http://localhost:8080/JSP_02_Hello/page.jsp?strName=<%=strName%>">나의 정보</a>
<p> <a href="/JSP_02_Hello/page.jsp?strName=<%=strName%>">나의 정보</a>
<p> <a href="/JSP_02_Hello/mypage/mypage1.jsp?strName=성춘향&num1=40&num2=50">성춘향의 정보</a>
</body>
</html>