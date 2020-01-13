#IMAGE GALLERY PROJECT
* 2020-01-03
### WYSWYG(WHAT YOU SEE WHAT YOU GET) EDITOR
* SUMMERNOTE : https://summernote.org/

* textarea에 id값을 설정하고 id에 jquery를 이용 속성 설정시 간편하게 WYSWYG 방식으로
문서 작성 가능

### drag & drop으로 파일 올리기
1. drag and drop 수행할 박스를 만들기
2. jquery drag over drop event 설정
3. e.orignal.Evant.DataTranfer로부터 files 객체 추출
4. files 객체에서 [0] 파일 객체를 추출

5. ajax를 통해 서버로 파일을 업로드 수행
6. 파일 이름등을 response로 받기
7. form img_file input box에 저장
8. 내용을 form post로 업로드하고 DB에 저장

### Drag and Drop으로 여러개 파일 올리기
*1~3까지는 single file upload와 동일
4. files 객체에 담긴 모든 file 객체를 formData에 append()

5. ajax를 사용해서 서버로 업로드를 수행하고
6. 컨트롤러는 수신된 파일들을 서버에 저장하고 
7. 저장된 파일이름을 리스트로 생성하고
8. 생성된 파일이름 리스트와 리스트를 표현할 jsp를 rendering하여 다시 return 하고
9. ajax success 코드에서는 return 받은 html코드를 
10. 리스트를 표현할 box에 보인다

#### 리스트를 만들 때 
* hidden으로 파일리스트를 담을 input box를 만들고 
* 각각의 파일이름을 input box의 value에 추가해준다

#### 저장 시
* 컨트롤러에서 본문(text)과 함께 hidden input box에 담긴 파일이름을 수신하는데
* String[] mFile : 문자열 배열로 수신하면 된다

### form에서 같은 tag에 다중 값을 담아서 controller 전달하기

#### 1. List<String> 형식으로 전달하기
	
* form에서 같은 이름의 tag에 다중의 값을 담고 
* <input name="title" value="1번">
* <input name="title" value="2번">
* <input name="title" value="3번">

* controller에서 
* String[] type 형식으로 매개변수 설정하여 받기
* VO 내부에서 List<String> title 변수를 설정해두고 VO와 같이 받기

#### 2. List<subVO>를 포함한 MainVO에 한꺼번에 받기 

* form에서 같은 이름의 tag에 다중의 값을 담고 
* <input name="main[0].title" value="1번">
* <input name="main[1].title" value="2번">
* <input name="main[2].title" value="3번">

### HttpSession
* statusLess :  HTTP(Hyper Text Transfer Protocol)는 특성상 request가 이루어지고 결과를 response하게 되면  웹 browser와 server간에 어떠한 정보도 남지 않는다
* 통신에서는 같은 client(web browser)에서 같은 주소로 서버에 자주 req를 수행하는 경우가 많다
 
* 이때 client가 요청한 req에 대한 정보를 server가 참조할 때가 있는데 대표적 예시로 로그인 한 정보
* 과거에는 cookie라는 것을 사용해서 사용자가 로그인을 수행하면 그 로그인한 데이터를 cookie라는 
* 데이터 형태로 만들어서 client에게 보내면, client 어딘가에 그 정보를 저장해 두었다가 
* 다시 req를 수행할 때 cookie를 req정보에 담아서 같이 전송했다
* 서버에서 req정보에 cookie가 담겨 있으면 그 정보를 분석하여 client로부터 보내온 정보를
* 분석해서 행동을 결정했다
* cookie라는 정보가 보통 암호화 되지 않고, 누구나 열어볼 수 있는 형태가 많다
* 즉, 민감한 개인정보등이 노출되기 쉽고 중간에 가로채기를 통해서 cookie 정보가 노출될 수 있음
* 이러한 단점을 보완하기 위해 Session이라는 개체 개념이 도입이 되었고 Java기반 서버(WAS)에서는
* HttpSession클래스를 만들어 쉽게 Session을 관리할 수 있도록 하고 있다
 
* 서버는 필요할 때 HttpSession객체에 Attribute를 추가하면 java에서 사용할 수 있는 어떤 데이터라도
* Session형 데이터로 만들 수 있다 

* httpSession.setAttribute("MEMBER",memberVO) 형태로 코딩을 하게 되면 memberVO객체 담긴 모든 데이터가
* 서버 기억장치 어딘가에 보관되고, MEMBER라는 이름으로 session ID가 생성된다

* 이때 session ID는 자체적으로 특별한 방법으로 암호화된 값으로 변환된다

* 서버에서 res를 수행하면 자동으로 res body에  session ID값이 추가되어 client로 보내진다

* client는 수신된 res 정보에 session ID가 있으면 cookie영역에 임시보관을 한다
* 이후 client에서 req를 보낼때 이 session ID를 첨가하여 서버로 보낸다

* 서버(spring)에서는 req정보에 session ID가 있으면 해당 session 객체를 메모리에서 찾아보고 
* session 객체를 메모리에서 찾아보고 session ID가 유효하면, 객체를 controller의 method에 주입한다

* controller의 method에서는 HttpSession httpSession형식의 매개변수를 선언해두면 해당 객체의 
* session 객체 값이 담겨있어서 코드에서 사용할 수 있다