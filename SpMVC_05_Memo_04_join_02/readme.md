#Spring MVC 메모장 프로젝트

###한개의 테이블을 기준으로 CRUD를 구현하기
###list.jsp : 메모리스트 보여주기
*메모추가 버튼을 클릭하여 메모 작성을 하고 
###메모리스트를 클릭하여 메모 세부내용을 보여주기
###메모 세부내용 보기에서 수정, 삭제버튼을 클릭하여
*메모 내용 수정
*메모 삭제 구현

* web>>controller : Reqmapping >> Service >> Dao + Mapper 합성 >> DBMS 적용
* 결과를 controoler에서 views/8.jsp 파일과 합성 >> HTML 변환 >>  web

### SessionAttributes Annotation, spring의 form tag를 결합하여
* insert와 update의 코드를 다소 간소하게 작성

### context
* 서버 프로젝트를 생성하면 base-package를 설정하게 된다 : com.biz.memo
* 서버를 시작하면 http://localhost:8080/memo/ 라는 URL로 시작된다
*/memo/ : context라고 부른다 project의 root라고 표현한다
*이 프로젝트의 모든 URL은 /memo/~~ 방식으로 시작한다
* pageContext.requset.contextPath 값을 사용하여야하는데 변수사용이
너무 길어서 c:set tag를 사용하여 각 jsp 상단에 rootPath EL 변수를
만들고 그 변수를 사용하여 URL 지정한다
* a href="${rootPath}/memo/list"라고 작성을 하면 
* a href="/memo/memo/list"형식으로 컴파일되어 웹페이지에 노출된다
