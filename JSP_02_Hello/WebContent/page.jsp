<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String strName = request.getParameter("strName");
    
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

	/*
	EL(extend Language) tag
	JSP에서 디자이너와 개발자의 협업중에 많은 문제들이 발생을 한다
	JSP(HTML) 디자이너에게 JAVA코드의 학습을 강요하고
	그러는 과정에서 문제를 야기시켰기 때문이다
	JAVA 측에서는 이러한 문제들을 줄이기 위해 
	HTML 코드내에서 최소한의 JAVA문법만을 사용하여 디자이너와 협업을 할 수 있도록
	EL tag라는 특별한 언어 구조를 만들어 낸다
	현재 MVC 패턴ㅇ[서도 대부분의 코드는 EL tag로 구현이 되고 있다
	           
	${변수, 연산식, 등등}
	
	*/
%>
<h3>나의 정보</h3>
<p><% out.write("대한민국"); %>
<p><% out.write(30 * 40); %>
<p><% 
int sum = 30 + 40;
out.write(sum);
%></p>


</body>
</html>