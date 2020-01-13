<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP page □□□</title>
<style>
/*
	header : tag 이름
	{} : 모양에 대한 여러가지 속성 지정

*/
header {
	background-color: white; /* box의 바탕색을 지정*/
	color: #A7B2AF; /* 글자색 */
	font-size: 50px;
	margin: 0;
	padding: 1rem;

}

ul{
display: flex;
list-style: none;
}
li{
	width : 100px;
	margin-right: 10px;
}

*, html, body {
	margin: 0;
	padding: 0;
}

* {
	font-family: 'Do Hyeon', sans-serif;
}

a {
	text-decoration: none; /* a tag에 적용될때 밑줄을 없애는 용도*/

	padding : 10px;
}

a:hover {
	
	font-weight: bold; /* 글자모양을 bold체로 변경 */
	font-style: italic; /* 글자모양을 italic체로 변경 */
}
/*
 a:hover 액션을 지정하는데
 nav tag 내에 있는 a tag에만 액션을 지정하라
*/


p#p1 {
	font-size: 50pt;
	
	color: white;
}

p.pc {

	color: black;
	width: 20%;
}
</style>
</head>
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap"
	rel="stylesheet">
<body>
	<header>
		<h2>나의 홈페이지</h2>
	</header>
	<nav>
		<ul>
			<li><a href="#">학생리스트</a></li>
			<li><a href="#">학생검색</a></li>
			<li><a href="#">로그인</a></li>
			<li><a href="#">회원가입</a></li>
		</ul>

	</nav>
	<section>
		<article>
			<p>
				<font size=30pt color=black face=궁서>여기는 본문</font>
			</p>
			<p style="font-size: 30pt; color: black;">여기는
				또다른 본문이다</p>
			<p id="p1">여기는 나의 이야기</p>
			<p id="p2">여기는 나의 이야기</p>
			<p id="p3" class="pc">여기는 나의 이야기</p>
			<p id="p4" class="pc">여기는 나의 이야기</p>
			<p id="p5" class="pc">여기는 나의 이야기</p>
			<p >
				<a href="https://naver.com/">네이버</a>
				<a href="https://daum.net/">다음 바로가기</a>
			</p>
		</article>
	</section>
	<footer>
		<address>CopyRight &copy; qussoa@naver.com</address>
	</footer>
</body>
</html>