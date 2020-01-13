<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//여기는 JSP파일 내의 java코드 작성 영역
	int num1 = 20;
	int num2 = 40;

	int sum = num1 + num2;
	System.out.println(sum);
%>
<!DOCTYPE html>
<html>
<!-- head tag는 페이지에 대한 정보등을 기록하는 부분
	 웹페이지에- 표시되지는 않지만 웹페이지에 어떤 것을 표시하기 위한
	 다양한 설정 등을 기록하는 부분 -->
<head>
<meta charset="UTF-8">
<!-- 웹페이지를 표시할떄 제목으로 사용되는 문자열 -->
<title>나의 첫번째 홈페이지</title>
</head>
<!--  웹페이지를 나타날 정보들을 표시하는 영역 
	  디자인과 관련된 문서 표시하는 부분-->
<body>
	<!--  h tag는 h1~h6까지 사용되며 본문보다 큰 글자로 표시  -->
	<h2>나는 Home.jsp이다</h2>
	<h3>반갑다</h3>
	<h4>우리나라만세</h4>
	<h4><%=sum%></h4>
	<p>paragraph</p>
	<p>문단</p>
	<p>웹페이지에서는 Enter의 의미가 없다</p>
	<p>문서를 작성하면서 Enter키를 입력해도 웹페이지에서는 단지 1개의 빈칸으로 인식한다</p>
	<p>문자열을 표시하면서 br tag를 사용하면 해당 위치에서 강제 줄바꿈이 된다<br/>
		br tag는 임의로 문단내에서 문자열을 여러줄에 표시하고잘 할때 사용한다 <br/>
		<p>br tag로 줄바굼을 하면 문단내에서는 <br/>
		
	<p>우리나라<br/> 
	대한민국<br/> 
	Republic of korea</p>
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
		eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl
		tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem
		ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa.
		Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi
		eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at
		imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis.
		Egestas integer eget aliquet nibh praesent. In hac habitasse platea
		dictumst quisque sagittis purus. Pulvinar elementum integer enim neque
		volutpat ac. Senectus et netus et malesuada. Nunc pulvinar sapien et
		ligula ullamcorper malesuada proin. Neque convallis a cras semper
		auctor. Libero id faucibus nisl tincidunt eget. Leo a diam
		sollicitudin tempor id. A lacus vestibulum sed arcu non odio euismod
		lacinia. In tellus integer feugiat scelerisque. Feugiat in fermentum
		posuere urna nec tincidunt praesent. Porttitor rhoncus dolor purus non
		enim praesent elementum facilisis. Nisi scelerisque eu ultrices vitae
		auctor eu augue ut lectus. Ipsum faucibus vitae aliquet nec
		ullamcorper sit amet risus. Et malesuada fames ac turpis egestas sed.
		Sit amet nisl suscipit adipiscing bibendum est ultricies. Arcu ac
		tortor dignissim convallis aenean et tortor at. Pretium viverra
		suspendisse potenti nullam ac tortor vitae purus. Eros donec ac odio
		tempor orci dapibus ultrices. Elementum nibh tellus molestie nunc. Et
		magnis dis parturient montes nascetur. Est placerat in egestas erat
		imperdiet. Consequat interdum varius sit amet mattis vulputate enim.
		Sit amet nulla facilisi morbi tempus. Nulla facilisi cras fermentum
		odio eu. Etiam erat velit scelerisque in dictum non consectetur a
		erat. Enim nulla aliquet porttitor lacus luctus accumsan tortor
		posuere. Ut sem nulla pharetra diam. Fames ac turpis egestas maecenas.
		Bibendum neque egestas congue quisque egestas diam. Laoreet id donec
		ultrices tincidunt arcu non sodales neque. Eget felis eget nunc
		lobortis mattis aliquam faucibus purus. Faucibus interdum posuere
		lorem ipsum dolor sit.</p>
	<p>국토와 자원은 국가의 보호를 받으며, 국가는 그 균형있는 개발과 이용을 위하여 필요한 계획을 수립한다. 훈장등의
		영전은 이를 받은 자에게만 효력이 있고, 어떠한 특권도 이에 따르지 아니한다. 대통령이 임시회의 집회를 요구할 때에는 기간과
		집회요구의 이유를 명시하여야 한다. 국회의원과 정부는 법률안을 제출할 수 있다. 대법원과 각급법원의 조직은 법률로 정한다.
		국회는 헌법 또는 법률에 특별한 규정이 없는 한 재적의원 과반수의 출석과 출석의원 과반수의 찬성으로 의결한다. 가부동수인
		때에는 부결된 것으로 본다. 모든 국민은 고문을 받지 아니하며, 형사상 자기에게 불리한 진술을 강요당하지 아니한다. 학교교육
		및 평생교육을 포함한 교육제도와 그 운영, 교육재정 및 교원의 지위에 관한 기본적인 사항은 법률로 정한다. 모든 국민은 법
		앞에 평등하다. 누구든지 성별·종교 또는 사회적 신분에 의하여 정치적·경제적·사회적·문화적 생활의 모든 영역에 있어서 차별을
		받지 아니한다. 헌법재판소에서 법률의 위헌결정, 탄핵의 결정, 정당해산의 결정 또는 헌법소원에 관한 인용결정을 할 때에는
		재판관 6인 이상의 찬성이 있어야 한다.</p>
</body>
</html>